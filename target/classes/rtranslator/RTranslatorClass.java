package rtranslator;

import java.util.ArrayList;
import static rtranslator.SaveCodeInFileR.saveToFile;

public class RTranslatorClass {

    ArrayList<String> rows = new ArrayList<>(); //готовые строки
    public RTranslatorClass() {
        
    }
    public void addString(String text){
        for (String strg: text.split("\n")){ //перепор каждой строки
            char shape = strg.charAt(0); //выбираем первый символ строки для определения типа фигуры
            String forAdding = "";
            switch (shape){ //переделываем псевдокод в код R
                case('i'): //первая i = 100 например
                    forAdding = strg;
                    break; 
                case('O'): //O
                    forAdding = strg;
                    break;
                case('N'): //NV
                    forAdding = strg;
                    break;
                case('d'): //if
                    forAdding = strg;
                    break;
                case('R'): //R
                    forAdding = strg;
                    break;
                case('V'): //V
                    forAdding = strg;
                    break;
                case('S'): //S
                    forAdding = generateSCodeR(strg);
                    break;
            }
            rows.add(forAdding); //Добавляем полученную строку в массив с готовыми строками
        }
        for (String strg : rows){
            System.out.println(strg);
        }
        saveToFile(rows,"R_Code_Test_Save.R"); //Сохраняем в файл
    }
    
    public String generateSCodeR(String exCode){ //Констиурктор кода языка R для фиугры R
        String rCodeString = "";
        String name = exCode.split(" = ")[0];//до =
        String type = exCode.split(" = ")[1].split("\\(")[0]; // после = до (
        String typeVar = exCode.split(" = ")[1].split("\\(")[1].replace(")","");// в ()
        rCodeString = name +"<-S_"+type+"(N, "+typeVar+", "+"1000"+")";
//        'S<-S_prob(N, 0.9, 1000)';
        return rCodeString;
    }
}
