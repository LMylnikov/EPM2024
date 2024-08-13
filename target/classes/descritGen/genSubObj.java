package descritGen;

//Нужен для хранения одной связи фигур

import java.util.ArrayList;

public class genSubObj {
    private String resultFigName; //Имя result фигуры
    private String vFigName; //Имя v фиугры, ведущей к result
    private ArrayList<String> figAsS = new ArrayList<String>();  //Имена фигур s (S+S1)
    private ArrayList<String> figAsNV = new ArrayList<String>(); // Имена фигур NV (NV1+NV2)
    private ArrayList<String> figAsO = new ArrayList<String>();  //Имена фигур o (O+O1)

    
    public genSubObj(String mainF){ //станартный генератор с созданием первоначальной фигурой
        resultFigName = mainF;
    }
    public void setVFig(String vFig){ //привязка v фигуры
        vFigName = vFig;
    }
   
    public void AddToS(String toS){
        figAsS.add(toS);
    }
    public void AddToNV(String toNV){
        figAsNV.add(toNV);
    }
    public void AddToO(String toO){
        figAsO.add(toO);
    }
//    public String getDescriptionAsString(){
//        String finalString;
//        if (figAsNV.size() == 0 & figAsS.size() == 0 & figAsO.size() == 0){
//            return "ERORR! Connection didnt exist";
//        }
//        finalString = resultFigName + " = " + vFigName + "(";
//        boolean isFirst = true;
//        
//        for (String sFig : figAsS){ //Записываем все S
//            if (isFirst){
//                finalString += sFig;
//                isFirst = false;
//                continue;
//            }
//            finalString += " + " + sFig;
//        }
//        
//        if (isFirst == false){ //Проверка на наилчие S в записи
//            finalString += ", ";
//        }
//        
//        isFirst = true;
//        for (String nvFig : figAsNV){  //Записываем все NV
//            if (isFirst){
//                finalString += nvFig;
//                isFirst = false;
//                continue;
//            }
//            finalString += " + " + nvFig;
//        }
//        if (isFirst == false){ //Проверка на наилчие NV в записи
//            finalString += ", "; 
//        }
//        isFirst = true;
//        for (String oFig : figAsO){  //Записываем все O
//            if (isFirst){
//                finalString += oFig;
//                isFirst = false;
//                continue;
//            }
//            finalString += " + " + oFig;
//        }
//        finalString += ")";
//        
//        return finalString;
//    } //не совсем работает, ставит фиктивную запятую после S
    
     public String getDescriptionAsString(){
        String finalString;
        
        finalString = resultFigName + " = " + vFigName + "("; //начало
        boolean commaStopper = true; //Задержка запятой перед первым массивом
        if (figAsS.size() != 0){ //если фигуры S присутствуют
            commaStopper = false;
            finalString += workWithMas(figAsS);
        }
        if (figAsNV.size() != 0){ //если фигуры NV присутствуют
            if (commaStopper){ //Если до этого ещё не обрабатывался массив
                commaStopper = false;
            }
            else{ //Иначе добавить запятую
                finalString += ", ";
            }
            finalString += workWithMas(figAsNV);
        }
        if (figAsO.size() != 0){ //если фигуры O присутствуют
            if (commaStopper){ //Если до этого ещё не обрабатывался массив
                commaStopper = false;
            }
            else{ //Иначе добавить запятую
                finalString += ", ";
            }
            finalString += workWithMas(figAsO);
        }
        if (commaStopper){ //Если ни разу не вызывался обработчик массива фигур
            return "ERORR! Connection didnt exist";  //ошибка о пустых массивах
        }
        finalString += ")";
        return finalString;
    }
     
    private String workWithMas(ArrayList<String> curMas){ //функция перебора фигур в массиве
        String curStr = "";
        boolean isFirst = true;
        for (String curFig : curMas){ 
            if (isFirst){
                curStr += curFig;
                isFirst = false;
                continue;
            }
            curStr += " + " + curFig;
        }
        return curStr;
    }
    public String getNameMainFig(){
        return resultFigName;
    }
    public ArrayList<String> getFigAsS(){
        return figAsS;
    }
    public ArrayList<String> getFigAsNV(){
        return figAsNV;
    }
    public ArrayList<String> getFigAsO(){
        return figAsO;
    }
    public void setNameMainFig(String newName){
        resultFigName = newName;
    }
    public void setFigAsS(ArrayList<String> newList){
        figAsS = newList;
    }
    public void setFigAsNV(ArrayList<String> newList){
        figAsNV = newList;
    }
    public void setFigAsO(ArrayList<String> newList){
        figAsNV = newList;
    }
}
