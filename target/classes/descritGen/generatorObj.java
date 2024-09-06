package descritGen;

import converter.ConvertedObject;
import converter.Figure_s;
import converter.Line_s;
import java.util.ArrayList;
import java.util.List;

public class generatorObj {
    private ConvertedObject curObj; //Объект с массивами
    private ArrayList<Figure_s> curFigures = new ArrayList<Figure_s>(); // Массив фигур
    private ArrayList<Line_s> curLines = new ArrayList<Line_s>(); // Массив линий
    ArrayList<subObjR> arrayRs = new ArrayList<subObjR>(); // Связи V->R 
    ArrayList<subObjNV> arrayNVs = new ArrayList<subObjNV>(); // Связи R->NV
    ArrayList<subObjV> arrayVs = new ArrayList<subObjV>();// Связи O,R,NV,S -> V
    ArrayList<subObjIF> arrayIFs = new ArrayList<subObjIF>();// Связи R -> IF ->R,V
    
    public generatorObj(ConvertedObject co){ //стандартный генератор из объекта сохранения*
        curObj = co;
        curFigures = curObj.getCurrentFigures();
        curLines = curObj.getCurrentLine();
    }

    //Функции для генерации строк каждого элемента
    public String nVStringGenerator(subObjNV objNV){
        String subString = objNV.getName() + " = ";
        subString += generateStringFromSubArray(objNV.getArrayLinkedR());
        return subString;
    }
    public String rStringGenerator(subObjR objR){
        String subString = objR.getName() + " = ";
        boolean isEmpty = true; //для проверки наличия записи в R, иначе не будем добавлять в общую запись
        for (String connectedV: objR.getArrayLinkedV()){
            subObjV objV = findVObjByName(connectedV);
            if (objV == null){
                return "FATALERROR";
            }
            if (objV.isEmpty()){
                return "FATALERROR";
            }
            isEmpty = false;
            subString+=generateVFunction(objV);
        }          
        if (isEmpty){
            return "FATALERROR";
        }
        return subString;
    }
    
    
    
    
    public String generateString(){
        linkHandler();
        String globalResult = "";
        for (subObjNV objNV:arrayNVs){ //Обработка всех NV объектов и их связей
            String subString = nVStringGenerator(objNV);
            globalResult+=subString+"\n";
        }
        
        for (subObjR objR:arrayRs){ //обработка всех R связей
            String subString =  rStringGenerator(objR);
            if (subString.equals("FATALERROR")){
                continue;
            }
            globalResult+=subString+"\n";
        }
        for (subObjIF objIF:arrayIFs){ //Обработка всех IF объектов и их связей
            if (objIF.isCorrect() == false){ //Проверяем на наличие всех элементов в объекте if
                continue;
            } 
            // do IF(R1) then R2 = R1 else R1 = 
            String subString = "do " + objIF.getName() + "(i) then \n i = i + 1"; 
            ArrayList<String> beforest =findStartOfLine(objIF.getLinkedOutFalseV(),objIF.getName()); // всё что входит в фигуру V
            subString += createExFigureCode(beforest,"");
            for (subObjR objR: arrayRs){
                if (objR.getArrayLinkedV().getFirst().equals(objIF.getLinkedOutFalseV())){ //ищем связанный с V r для уникального обозначения
                    subObjV objV = findVObjByName(objIF.getLinkedOutFalseV());
                    objV.AddToSList(objR.getName()); //добавляем в список S наш R. Далее необходимо делать это в другом(склонированном)  V
                    //убрал лишние проверки
                    subString+= "\n"+objR.getName() + " = " + generateVFunction(objV);
                }
            }
            subString+="\nelse "+ objIF.getLinkedOutTrueR()+" = "+objIF.getLinkedInR()+" (i)/" +objIF.getLinkedInR() +" (i-1);";
            
                    /*    
            + objIF.getLinkedOutTrueR() + " = " + objIF.getLinkedInR() + " else " + objIF.getLinkedInR() + " = " ; 
            subObjV objV = findVObjByName(objIF.getLinkedOutFalseV());*/
            /*if (objV == null){
                continue;
            }
            if (objV.isEmpty()){
                continue;
            }
            subString+=generateVFunction(objV);*/
            globalResult+=subString+"\n";
        }
        return globalResult;
    }
    private String createExFigureCode( ArrayList<String> startLineNames, String exFiguresString){
        for (String figName: startLineNames){
            Figure_s exFindedFig = findFigByName(figName);
            if (exFindedFig == null){
                return exFiguresString;
            }
            String cShape = exFindedFig.getShape();
            switch(cShape){
                case("S1"):
                    exFiguresString+="\n"+ figName +" = Prob()";
                    continue;
                case("R"):
                    subObjR r = findRObjByName(figName);
                    if (r == null){
                        continue;
                    }
                    exFiguresString+="\n"+ rStringGenerator(r);
                    break;
                case("NV"):
                    exFiguresString+="\n"+ nVStringGenerator(findNVObjByName(figName));
                    break;
            }
            createExFigureCode(findStartOfLine(figName,""),exFiguresString);        
        }
        return exFiguresString;
    }
    private ArrayList<String> findStartOfLine(String endOfLine,String iskluchenia){
        ArrayList<String> allLinks = new ArrayList<String>();
        for (Line_s line: curLines){
            if (line.GetID2().equals(endOfLine)){
                if (line.GetID1().equals(iskluchenia)){
                    continue;
                }
                allLinks.add(line.GetID1());
            }
        }
        return allLinks;
    }
    
    //Сосздание суммы любой фигуры, типа R + R1 ,  O + O1 для удобства
    private String generateStringFromSubArray(ArrayList<String> array){
        String summ = "";
        boolean isFirst = true;
        for (String el :array){
            if (isFirst){
                summ += el;
                isFirst = false;
                continue;
            }
            summ += " + " + el;
        }
        return summ;
    }

    //Поиск фигуры по имени
    private Figure_s findFigByName(String name){
        for (Figure_s figure: curFigures){
            if (figure.getName().equals(name)){
                return figure;
            }
        }
        return null;
    }
    
    //Создает объекты со связями
    private void linkHandler(){
        for (Line_s link: curLines){ //Перебор всех линий
            Figure_s endOfLink = findFigByName(link.GetID2());
            Figure_s startOfLink = findFigByName(link.GetID1());
            if (endOfLink.getShape().equals("d") & startOfLink.getShape().equals("R")){ // если R -> IF
                if (findIFObjByName(endOfLink.getName()) == null){ //если не найден элемент{
                    subObjIF newEl = new subObjIF(endOfLink.getName());
                    newEl.setLinkedInR(startOfLink.getName());
                    arrayIFs.add(newEl);
                    continue;
                }
                findIFObjByName(endOfLink.getName()).setLinkedInR(startOfLink.getName());
            }
            if (endOfLink.getShape().equals("R") & startOfLink.getShape().equals("d")){ // если IF -> R
                if (findIFObjByName(startOfLink.getName()) == null){ //если не найден элемент{
                    subObjIF newEl = new subObjIF(startOfLink.getName());
                    newEl.setLinkedOutTrueR(endOfLink.getName());
                    arrayIFs.add(newEl);
                    continue;
                }
                findIFObjByName(startOfLink.getName()).setLinkedOutTrueR(endOfLink.getName());
            }
            if (endOfLink.getShape().equals("V") & startOfLink.getShape().equals("d")){ // если IF -> V
                if (findIFObjByName(startOfLink.getName()) == null){ //если не найден элемент{
                    subObjIF newEl = new subObjIF(startOfLink.getName());
                    newEl.setLinkedOutFalseV(endOfLink.getName());
                    arrayIFs.add(newEl);
                    continue;
                }
                findIFObjByName(startOfLink.getName()).setLinkedOutFalseV(endOfLink.getName());
            }
            if (endOfLink.getShape().equals("R") & startOfLink.getShape().equals("V")){ //если связь V->R
                if (findRObjByName(endOfLink.getName()) == null){ //если не найден элемент
                    subObjR newEl = new subObjR(endOfLink.getName(),startOfLink.getName());
                    arrayRs.add(newEl);
                    continue;
                }
                findRObjByName(endOfLink.getName()).AddToVList(startOfLink.getName());
                continue;
            }
            if (endOfLink.getShape().equals("NV") & startOfLink.getShape().equals("R")){ //если связь R->NV
                if (findNVObjByName(endOfLink.getName()) == null){ //если не найден элемент
                   subObjNV newEl = new subObjNV(endOfLink.getName(),startOfLink.getName());
                   arrayNVs.add(newEl);
                   continue;
                }
                findNVObjByName(endOfLink.getName()).AddToRList(startOfLink.getName());
                continue;
            }
            if (endOfLink.getShape().equals("V")){ //если связь R->V NV->V O->V S->V
                subObjV cur = findVObjByName(endOfLink.getName());
                if (cur == null){ //если элемент не найден
                    cur = new subObjV(endOfLink.getName());
                    arrayVs.add(cur);
                }
                String startShape = startOfLink.getShape();
                switch(startShape){
                    case "S1":
                        cur.AddToSList(startOfLink.getName());
                        break;
                    case "O":
                        cur.AddToOList(startOfLink.getName());
                        break;
                    case "NV":
                        cur.AddToNvRList(startOfLink.getName());
                        break;
                    case "R": 
                        cur.AddToNvRList(startOfLink.getName());
                        break;
                }
            }                  
        }
    }
    
    private subObjIF findIFObjByName(String name){ //Поисковик в массиве IF с объектами по имени
        for (subObjIF curAr: arrayIFs){
            if (curAr.getName().equals(name)){
                return curAr;
            }
        }
        return null;
    }
    private subObjR findRObjByName(String name){ //Поисковик в массиве R с объектами по имени
        for (subObjR curAr: arrayRs){
            if (curAr.getName().equals(name)){
                return curAr;
            }
        }
        return null;
    }
    private subObjV findVObjByName(String name){ //Поисковик в массиве V с объектами по имени
        for (subObjV curAr: arrayVs){
            if (curAr.getName().equals(name)){
                return curAr;
            }
        }
        return null;
    }
    private subObjNV findNVObjByName(String name){ //Поисковик в массиве NV с объектами по имени
        for (subObjNV curAr: arrayNVs){
            if (curAr.getName().equals(name)){
                return curAr;
            }
        }
        return null;
    }
    
    private String generateVFunction(subObjV objV){    
        String subString="";
        subString += objV.getName()+"(";
        boolean isFirstArrayToPrint = true;
        String help = generateStringFromSubArray(objV.getArrayLinkedS()); //пишем все s
        subString+=help;
        if (help != ""){
            isFirstArrayToPrint = false;
        }
        help = generateStringFromSubArray(objV.getArrayLinkedNvR()); //пишем все nv и r
        if (isFirstArrayToPrint == false & help != ""){
            subString+=", "; //если надо добавляем запятую
        }
        subString+=help;
        if (help != ""){
            isFirstArrayToPrint = false;
        }
        help = generateStringFromSubArray(objV.getArrayLinkedO()); //пишем все o
        if (isFirstArrayToPrint == false & help != ""){
            subString+=", "; //если надо добавляем запятую
        }
        subString+=help;
        subString+=") ";
        return subString;
    }
}


