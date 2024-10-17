package rtranslator;

import java.util.ArrayList;
import static rtranslator.SaveCodeInFileR.saveToFile;

public class RTranslatorClass {

    ArrayList<String> rows = new ArrayList<>(); //готовые строки
    int unicNvNumber = 1; //уникальный id для технических nv
    boolean isPlotActive = false;
    boolean isXESActime = false;
    int idNumber = 66;
    int idStep = 66;

    public RTranslatorClass(boolean isPlot, boolean isXES, int idN, int idS) {
        isPlotActive = isPlot;
        isXESActime = isXES;
        idNumber = idN;
        idStep = idS;
    }

    public void addString(String text) {
        for (String strg : text.split("\n")) { //перепор каждой строки
            char shape = strg.charAt(0); //выбираем первый символ строки для определения типа фигуры
            String forAdding = "";
            switch (shape) { //переделываем псевдокод в код R
                case ('i'): //первая i = 100 например
                    forAdding = strg;
                    break;
                case ('O'): //O
                    forAdding = strg;
                    break;
                case ('N'): //NV
                    forAdding = generateNVCodeR(strg);
                    break;
                case ('d'): //if
                    forAdding = strg;
                    break;
                case ('R'): //R
                    forAdding = generateRCodeR(strg);
                    break;
                case ('V'): //V
                    forAdding = strg;
                    break;
                case ('S'): //S
                    forAdding = generateSCodeR(strg);
                    break;
            }
            rows.add(forAdding); //Добавляем полученную строку/строкИ в массив с готовыми строками (если нужно хранить именно строку стоит 
            //перед добавлением полученную строку разделить по \n
        }
        for (String strg : rows) {
            System.out.println(strg);
        }
        saveToFile(rows, "R_Code_Test_Save.R"); //Сохраняем в файл
    }

    public String generateSCodeR(String exCode) { //Констиурктор кода языка R для фиугры S
        String rCodeString = "";
        String name = exCode.split(" = ")[0];//до =
        String type = exCode.split(" = ")[1].split("\\(")[0]; // после = до (
        String typeVar = exCode.split(" = ")[1].split("\\(")[1].replace(")", "");// в ()
        rCodeString = name + "<-S_" + type + "(N, " + typeVar + ", " + idNumber + ")";
        idNumber -= idStep;
//        'S<-S_prob(N, 0.9, 1000)';
        if (isPlotActive) { //если нужно строить графики
            rCodeString += "\n"
                    + "plot(1:N, " + name + "$S, type=\"s\", col=\"black\", panel.first=grid(), ylab='S', xlab='i', ylim = c(0,6))";
        }
        return rCodeString;
    }

    public String generateNVCodeR(String exCode) { //Констиурктор кода языка R для фиугры NV
        String rCodeString = "";
        String nvName = exCode.split(" = ")[0]; //имя NV
        String rName = exCode.split(" = ")[1]; //имя R
        rCodeString = nvName + "<-subset( " + rName + ", select=c(R, ID_Out)) colnames( " + nvName + " ) <- c('S', 'ID')";
        return rCodeString;
    }

    String preRCode = ""; //код до блока r = v лдя тогоЮ чтобы записыывать nv = r в случае вхождения r в v

    public String generateRCodeR(String exCode) { //Констиурктор кода языка R для фиугры R
        preRCode = "";
        String rCodeString = "";
        String rName = exCode.split(" = ")[0]; //имя R
        String vName = exCode.split(" = ")[1].split("\\(")[0]; //имя V
        String[] allInProp = exCode.split(" = ")[1].split("\\(")[1].split("\\)")[0].split("\\,");
        String type = allInProp[0]; //сложность
        String[] srFig = allInProp[1].split(" \\+ ");
        String[] nvFig = allInProp[2].split(" \\+ "); //массив всех nv //пока не используем
        String[] oFig = allInProp[3].split(" \\+ "); //массив всех o //пока не используем
        String srElement = srBlockGen(srFig);
//        String s = rName + " = " + vName + "(" + type + ",NULL, NV5 + NV4, O3) ";
        rCodeString = rName + "<- V(" + type + ", " + srElement + ", \"" + vName + "\")";

        return preRCode + rCodeString;
    }

    private String srBlockGen(String[] allObject) {
        String preCode = ""; //Запись преобразования r в nv. Нужно записать перед блоком r = v ()
        ArrayList<String> inFigures = new ArrayList<String>();
        
        for (String el : allObject) {
            inFigures.add(el);
        }
        
        String readyElement = "";
        
        if (inFigures.size() == 1) { //Если только один элемент (делаем без  АДД)
            String curFig = inFigures.remove(0);
            if (curFig.charAt(0) == ('R')) {
                readyElement = addRInVInR(curFig);
                return readyElement; //если была r выдаем NV
            }
            return curFig; //Если была S выдаем S
        }
        
        while (inFigures.size() != 1) {
            readyElement += "Add(";

            String curFig = inFigures.remove(0);
            if (curFig.charAt(0) == ('R')) { //если фигура r переделываем в NV
                curFig = addRInVInR(curFig);
            } //Иначе просто добавляем S
            readyElement += curFig + ",";
        }
        //теперь добавляем последнюю фигуру в список
        String curFig = inFigures.remove(0);
        readyElement += curFig + ")".repeat(allObject.length - 1);

        return readyElement;
    }

    private String addRInVInR(String rName) { //специальный код для получения nv имени и записи пре кода
        String nvName = "NV" + unicNvNumber + rName ; //техническое название nv
        unicNvNumber+=1;
        String nvSelfCode = nvName + " = " + rName; //самописный техничесакий код nv с указаниепм своего имени nv
        preRCode += generateNVCodeR(nvSelfCode) + "\n"; //добавляем в код до текущего блока v = r
        return nvName;
    }
}
