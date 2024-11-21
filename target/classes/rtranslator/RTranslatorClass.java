package rtranslator;

import EPM.mdi;
import static EPM.mdi.prefsMdi;
import java.util.ArrayList;
import java.util.prefs.Preferences;
import rtranslator.CreateRCode;

public class RTranslatorClass {

    ArrayList<String> rows = new ArrayList<>(); //готовые строки
    String rFileName = "";
    String xesFileName = "";
    String rFilePath = "";
    String startN = "";
    int unicNvNumber = 1; //уникальный id для технических nv
    boolean isPlotActive = false; //строить графики
    boolean isXESActive = false; //Выгрузка в ХЕС
    boolean isActiveO = false; //Учитывать О
    int idNumber = 66;
    int idStep = 66;
    int rCount = 0;
    int numSpace = 0; //Отступы для if
    private static Preferences localPrefsMdis = prefsMdi; 
    private String preCode;
    public RTranslatorClass(String preCode) {
        this.preCode = preCode;
        boolean help = true; String hep = "f";
        startN = localPrefsMdis.get("NValue", hep);
        isPlotActive = (localPrefsMdis.getBoolean("graphState",help));
        isXESActive = (localPrefsMdis.getBoolean("xesState",help));
        idNumber = Integer.valueOf(localPrefsMdis.get("startId",hep));
        idStep = Integer.valueOf(localPrefsMdis.get( "stepId",hep));
        isActiveO = (localPrefsMdis.getBoolean("oActiveState",help));
        this.rFileName =  localPrefsMdis.get("rName", hep);
        this.xesFileName = localPrefsMdis.get("xesName", hep);
        this.rFilePath = localPrefsMdis.get("rPath", hep);
        
        if (!isPlotActive){ //если не строим графики, то не выгружаем хес
            isXESActive = false;
        }
    }
    public String getStringRCode(){
        return CreateRCode.generateCodeRFromString(preCode,rows); //Сохраняем в файл
    }
    public void addString(String text) {
        rows.add("N <- "+startN);
        for (String strg : text.split("\n")) { //перепор каждой строки
            if (strg.length() == 0){
                continue;
            }
            strg = strg.replace("    ", "");
            char shape = strg.charAt(0); //выбираем первый символ строки для определения типа фигуры
            String forAdding = "";
            switch (shape) { //переделываем псевдокод в код R
                case ('i'): //первая i = 100 например
                    forAdding = space() + strg.replace("=","<-");
                    break;
                case ('N'): //NV
                    forAdding = generateNVCodeR(strg);
                    break;
                case ('d'): //if
                    forAdding = generateIfStartCodeR(strg);
                    break;
                case ('e'): // end if
                    numSpace-=1;
                    forAdding = generateIfEndCodeR(strg);
                    break;
                case ('R'): //R
                    forAdding = generateRCodeR(strg);
                    if(forAdding.equals("empty")){
                        continue;
                    }
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
        if (isXESActive && rCount>0){
            rows.add("write.csv(X, file=\""+xesFileName+".csv\")"); //Если выгружаем хес добавляем соотв строку
        }
//        return CreateRCode.generateCodeRFromString(preCode,rows); //Сохраняем в файл
//        (rFilePath+"/"+rFileName+".R") Указание сохранения файла R
    }
    public String generateIfStartCodeR(String exCode) { //Констиурктор кода языка R для if start
        String rCodeString  = "";
        String condition = exCode.split("\\(")[1].split("\\)")[0];
        rCodeString = space() + "while (" + condition + "){";
        numSpace+=1;
        return rCodeString;
    }
    public String generateIfEndCodeR(String exCode) { //Констиурктор кода языка R для if end
        String rCodeString = "";
        String afterElse = exCode.split("else ")[1].replace("=","<-");
        rCodeString = space() + "}" + "\n"+ space() + afterElse;
        return rCodeString;
    }
    public String generateSCodeR(String exCode) { //Констиурктор кода языка R для фиугры S
        String rCodeString = "";
        String name = exCode.split(" = ")[0];//до =
        String type = exCode.split(" = ")[1].split("\\(")[0]; // после = до (
        String typeVar = exCode.split(" = ")[1].split("\\(")[1].replace(")", "");// в ()
        typeVar = typeVar.replace(',','.'); //Замена запятой на точку, так как конфликт в R. ИСПРАВИТЬ В ОСНОВНОЙ ПРОГЕ ИЛИ УЧЕСТЬ ВЕЗДЕ
        rCodeString = space() + name + "<-S_" + type + "(N, " + typeVar + ", " + idNumber + ")";
        idNumber += idStep;
//        'S<-S_prob(N, 0.9, 1000)';
        if (isPlotActive) { //если нужно строить графики
            rCodeString += "\n"
                    + space() + "plot(1:N, " + name + "$S, type=\"s\", col=\"black\", panel.first=grid(), ylab='S', xlab='i', ylim = c(0,6), main = \"Элемент "+name+"\")";
        }
        return rCodeString;
    }

    public String generateNVCodeR(String exCode) { //Констиурктор кода языка R для фиугры NV
        String rCodeString = "";
        String nvName = exCode.split(" = ")[0]; //имя NV
        String rName = exCode.split(" = ")[1]; //имя R
        rCodeString = space() + nvName + "<-subset( " + rName + ", select=c(R, ID_Out)) colnames( " + nvName + " ) <- c('S', 'ID')";
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
        if (srFig[0].equals("NULL")){
            return "empty";
        }
        String srElement = srBlockGen(srFig);
        if (isActiveO && !(oFig[0].equals(" NULL"))){ //если нужно выводить О
            rCodeString = space() + rName+"_O" + "<- V(" + type + ", " + srElement + ", \"" + vName + "\")";
            String oNum =  exCode.split("\\(")[2].split("\\)")[0];
            rCodeString += "\n"+ space() + rName+ "<-O("+rName+"_O,"+oNum+")";
        }
        else{
            rCodeString = space() + rName + "<- V(" + type + ", " + srElement + ", \"" + vName + "\")";
        }
        if (isPlotActive){ //график для R
            rCodeString +=  "\n"+ space() +"plot(1:N, "+rName+"$R, type=\"s\", col=\"black\", panel.first=grid(), ylab='S', xlab='i', ylim = c(0,15), main = \"Элемент "+rName+"\")" +
            "\n" + space() + "plot(1:N, "+rName+"$Prj_File, type=\"s\", col=\"black\", panel.first=grid(), ylab='S', xlab='i', ylim = c(0,15), main = \"Элемент "+rName+"\")";
            if (isXESActive){ // график для X
                rCount+=1;
                String xName = "X";
                if (rCount == 1){
                    rCodeString+="\n" + space() +xName+"<-XES("+rName+")";
                }else{
                    xName += rCount;
                    rCodeString+="\n"+ space() +xName+"<-XES("+rName+")"
                            +"\n" + space() + "X<-rbind(X,"+xName+")";
                    rCodeString+="\n" + space() + "vioplot("+xName+"$W, col = \"lightgray\",  panel.first=grid(), main = \"Элемент "+rName+"\")";
                }
                rCodeString+= "\n" + space() + "vioplot(X$W, col = \"lightgray\",  panel.first=grid(), main = \"Все элементы до "+rName+"\")";
            }
        }
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
    private String space(){
        return "    ".repeat(numSpace);
    }
}
