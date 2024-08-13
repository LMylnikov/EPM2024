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
    
    
//    private ArrayList<genSubObj> finalRObjects = new ArrayList<genSubObj>(); // Массив со всеми ураванениями
    
    public generatorObj(ConvertedObject co){ //стандартный генератор из объекта сохранения*
        curObj = co;
        curFigures = curObj.getCurrentFigures();
        curLines = curObj.getCurrentLine();
    }
//    public String generateString(){
//        generateObject();
//        String globalString = "";
//        for (genSubObj objc : finalRObjects){
//            String objcText = objc.getDescriptionAsString();
//            if (objcText.equals("ERORR! Connection didnt exist")){ //если нет привязанных фигур, то пропускаем
//                continue;
//            }
//            globalString += objcText+"\n";
//        }                
//        return globalString;
//    }
//    public void generateObject(){
//        for (Figure_s rFig : curFigures){
//            if (rFig.getShape().equals("R")){ //Если R то создаем "новую строку"
//                genSubObj newSubOb = new genSubObj(rFig.getName());              
//                for (Line_s l : curLines){ //проверяем все линии с концом в results
//                    if (rFig.getName().equals(l.GetID2())){
//                        String startLine = l.GetID1(); //откуда идёт связь
//                        for (Figure_s vFig : curFigures){
//                            if (vFig.getName().equals(startLine)){ //если фигура является начальной
//                                if (vFig.getShape().equals("V")){ //если фигура V
//                                    newSubOb.setVFig(vFig.getName());
//                                    collectFigToV(vFig.getName(),newSubOb);
//                                }
//                                break; //сразу выходим тк в теории есть только одна V связанная с R !! можно заменять для более солжных формул
//                            }
//                        }
//                    }                  
//                }   
//                finalRObjects.add(newSubOb); //добавляем одно уравнение в массив
//            }
//        }
//    }  
//    private void collectFigToV(String vName, genSubObj subOb ){
//        for (Line_s l : curLines){ //проверяем все линии с концом в v
//            if (vName.equals(l.GetID2())){
//                String startLine = l.GetID1(); //откуда идёт связь
//                for (Figure_s startFig : curFigures){
//                    if (startFig.getName().equals(startLine)){ //если фигура является начальной
//                        if (startFig.getShape().equals("S1")){ //если фигура S
//                            subOb.AddToS(startFig.getName());
//                            continue;
//                        }
//                        if (startFig.getShape().equals("NV") | startFig.getShape().equals("R")){ //если фигура NV
//                            subOb.AddToNV(startFig.getName());
//                            continue;
//                        }    
//                        if (startFig.getShape().equals("O")){ //если фигура O
//                            subOb.AddToO(startFig.getName());
//                            continue;
//                        }
//                    }
//                }
//            }                  
//        }   
//    }
    
    public String generateString(){
        linkHandler();
        String globalResult = "";
        for (subObjNV objNV:arrayNVs){ //Обработка всех NV объектов и его связи
            String subString = objNV.getName() + " = ";
            subString += generateStringFromSubArray(objNV.getArrayLinkedR());
            globalResult+=subString+"\n";
        }
        
        for (subObjR objR:arrayRs){ //обработка всех R связей
            String subString = objR.getName() + " = ";
            boolean isEmpty = true; //для проверки наличия записи в R, иначе не будем добавлять в общую запись
            for (String connectedV: objR.getArrayLinkedV()){
                subObjV objV = findVObjByName(connectedV);
                if (objV == null){
                    continue;
                }
                if (objV.isEmpty()){
                    continue;
                }
                isEmpty = false;
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
            }          
            if (isEmpty){
                continue;
            }
            globalResult+=subString+"\n";
        }
        
        return globalResult;
    }
    
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
    
    ArrayList<subObjR> arrayRs = new ArrayList<subObjR>();
    ArrayList<subObjNV> arrayNVs = new ArrayList<subObjNV>();
    ArrayList<subObjV> arrayVs = new ArrayList<subObjV>();
    
    private Figure_s findFigByName(String name){
        for (Figure_s figure: curFigures){
            if (figure.getName().equals(name)){
                return figure;
            }
        }
        return null;
    }
    
    private void linkHandler(){
        for (Line_s link: curLines){ //Перебор всех линий
            Figure_s endOfLink = findFigByName(link.GetID2());
            Figure_s startOfLink = findFigByName(link.GetID1());
            if (endOfLink.getShape().equals("R") & startOfLink.getShape().equals("V")){ //если связь V->R
                if (findRObjByName(endOfLink.getName()) == null){ //если не найден элемент
                    subObjR newAr = new subObjR(endOfLink.getName(),startOfLink.getName());
                    arrayRs.add(newAr);
                    continue;
                }
                findRObjByName(endOfLink.getName()).AddToVList(startOfLink.getName());
                continue;
            }
            if (endOfLink.getShape().equals("NV") & startOfLink.getShape().equals("R")){ //если связь R->NV
                if (findNVObjByName(endOfLink.getName()) == null){ //если не найден элемент
                   subObjNV newAr = new subObjNV(endOfLink.getName(),startOfLink.getName());
                   arrayNVs.add(newAr);
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
}


