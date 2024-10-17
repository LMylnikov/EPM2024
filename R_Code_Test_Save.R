library(vioplot) #Для рисования скрипичной диаграммы
library(purrr)

# --- ==== [ Объявление функций ] ==== ---

####### S элемент с вероятностной работой
# P - вероятность 
# N - число элементов для заполнения
# ID - значение с которого начинается нумерация генерируемых событий
S_prob<-function(N, P, ID){
  RES<-vector(mode = "integer", length = N)
  RES[1:N]<-rpois(N,P)
  
  S1<-data.frame(S=RES, ID=vector(mode = "numeric", length = N))
  ID_S<-ID
  for (i in 1:N){
    if (RES[i]>0){
      Vect<-as.vector(ID_S+1:RES[i], mode = "numeric")
      ID_S<-ID_S+RES[i]
      S1$ID[i]<-list(Value=Vect)
    }
  }
  S_prob<-S1
}

#V линейная сложность
V_L<-function(N){
  V_L<-N
}

V_L01<-function(N){
  V_L<-round(N*0.1)
}

V_L001<-function(N){
  V_L<-round(N*0.01)
}


#V сложность N^2
V_L2<-function(N){
  V_2L<-N*N
}

#V логорифмическая сложность
V_Lg<-function(N){
  if (N == 0) {V_Lg<-0} else {
    if (N == 1) {
      V_Lg<-1
    } else {  
      V_Lg<-N*log(N)
    }  
  }
}

#V экспоненциальная сложность
V_E<-function(N){
  if (N == 0) {V_E<-0} else {V_E<-exp(N)}
}

################# Блок обработки (V)  #######################
# O - тип сложности (1 - линейная сложность, 2 - сложность N^2, 3 - логорифмическая сложность, 4 - експоненциальная сложность)
# S - поток событий
# V - название блока для записи в результирующую талицу (требуется для построения XES файла)

# Формат таблицы которую получаем
# I - номер шага
# J - номер шага на котором последний раз освободился блок (получил статус - свободен)
# Prj_Flow - поток событий
# Prj_File - очередь событий
# V_W - количество шагов обработки
# V - название блока обработки
# R - выходной (после обработки) поток событий 
# ID_File - идентификаторы событий в очереди 
# ID_Out - идентификаторы событий почсле обработки 

V<-function(O, S, V){
  # расчет для логарифмической сложности
  N<-length(S$S)
  Df<-data.frame(I=1:N, 
                 J=vector(mode = "numeric", length = length(N)), 
                 Prj_Flow=S$S, 
                 Prj_File=vector(mode = "numeric", length = length(N)), 
                 V_W=vector(mode = "numeric", length = length(N)), 
                 V=V, 
                 R=vector(mode = "numeric", length = length(N)), 
                 ID_File=vector(mode = "numeric", length = length(N)), 
                 ID_Out=vector(mode = "numeric", length = length(N)))
  j<-1
  L<-0
  for (i in 1:N){
    Df$Prj_File[i]<-sum(Df$Prj_Flow[i:j])
    Df$ID_File[i]<-list(unique(list_c(S$ID[i:j])))
    Df$J[i]<-j
    if (Df$V_W[i]==0) {
      nk<-Df$Prj_File[i]
      if (O == -1) {L<-ceiling(V_L001(nk))}
      if (O == 0) {L<-ceiling(V_L01(nk))}
      if (O == 1) {L<-ceiling(V_L(nk))}
      if (O == 2) {L<-ceiling(V_L2(nk))}
      if (O == 3) {L<-ceiling(V_Lg(nk))}
      if (O == 4) {L<-ceiling(V_E(nk))}
      k<-min(i+L-1,N)
      if (k>=i){
        Df$V_W[i:k]<-L
        Df$R[k] <- nk
        Df$ID_Out[k]<-Df$ID_File[i]
      }
      j<-i+1
    }
    
  }
  
  P1<-Df$R
  P2<-Df$ID_Out
  
  Df$R[1]<-0
  Df$R[2:N]<-P1[1:(N-1)]
  Df$ID_Out[1]<-0
  Df$ID_Out[2:N]<-P2[1:(N-1)]
  V1<-Df
}

################# Собираем статистику в формате XES (Process Mining)  #######################
#  R - таблица выдаваемая блоком V

# Формат таблицы которую получаем
# ID - идентификатор события
# V - операция
# I -	номер шага поступления
# W - длительность обработки в шагах

XES<-function(R){
  Df<-data.frame(ID=0, V="V", I=0, W=0) 
  N1<-length(R$I)
  for (i in 1:N1){
    Vec<-list_c(R$ID_Out[i])
    N2<-length(Vec)
    if (N2>0 & R$R[i]>0){
      for (j in 1:N2){
        if (Vec[j]>0){
          Df_0<-data.frame(ID=Vec[j], V=R$V[i], I=i, W=R$V_W[i-1])
          Df<-rbind(Df,Df_0)
        }
      }
    }
  }
  Df<-Df[-1,]
  XES<-Df
}


# Объединение двух последовательностей типа выдаваемого блоком S по аддитивному закону
Add<-function(A1, A2){
  N1<-length(A1$S)
  AS3<-vector(mode = "integer", length = N1)
  AS3<-A1$S+A2$S
  A3<-data.frame(S=AS3, ID=vector(mode = "numeric", length = N1))
  
  for (i in 1:N1){
    Vect<-as.vector(unique(c(A1$ID[[i]],A2$ID[[i]])), mode = "numeric")
    A3$ID[i]<-list(Value=Vect)
  }
  Add<-A3
}


# Разделение потоков по номерам проектов 
Select<-function(A, N1, N2){
  N<-length(A$S)
  A3<-data.frame(S=A$S, ID=vector(mode = "numeric", length = N))
  for (i in 1:N){
    Vect<-as.vector(unique(A$ID[[i]]), mode = "numeric")
    Vect1<-0
    k<-1
    for (j in 1:length(Vect)) {
      if (Vect[j]>N1 &  Vect[j]<N2){
        Vect1<-c(Vect1, Vect[j])
      }
    }
    A3$ID[i]<-list(Value=Vect1)
    A3$S[i]<-length(A3$ID[[i]])-1
  }
  Select<-A3
}
# --- ==== [ Основная программа ] ==== ---
i = 992189
S1<-S_Prob(N, 0,5, 10)
S22<-S_Prob(N, 0,53, 2)
S3<-S_Prob(N, 0,5, -6)
