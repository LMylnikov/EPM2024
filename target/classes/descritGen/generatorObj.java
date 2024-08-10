package descritGen;

import converter.ConvertedObject;
import converter.Figure_s;
import converter.Line_s;
import java.util.ArrayList;
import java.util.List;

public class generatorObj {
    private ConvertedObject curObj; //Объект с массивами
    private ArrayList<Figure_s> curFig = new ArrayList<Figure_s>(); // Массив фигур
    private ArrayList<Line_s> curLine = new ArrayList<Line_s>(); // Массив линий
    private ArrayList<genSubObj> curAllRes = new ArrayList<genSubObj>(); // Массив со всеми ураванениями
    
    public generatorObj(ConvertedObject co){ //стандартный генератор из объекта сохранения*
        curObj = co;
        curFig = curObj.getCurrentFigures();
        curLine = curObj.getCurrentLine();
    }
    public String generateString(){
        generateObject();
        String globalString = "";
        for (genSubObj objc : curAllRes){
            String objcText = objc.getDescriptionAsString();
            if (objcText.equals("ERORR! Connection didnt exist")){
                continue;
            }
            globalString += objcText+"\n";
        }                
        return globalString;
    }
    public void generateObject(){
        for (Figure_s rFig : curFig){
            if (rFig.getShape().equals("R")){ //Если R то создаем "новую строку"
                genSubObj newSubOb = new genSubObj(rFig.getName());              
                for (Line_s l : curLine){ //проверяем все линии с концом в results
                    if (rFig.getName().equals(l.GetID2())){
                        String startLine = l.GetID1(); //откуда идёт связь
                        for (Figure_s vFig : curFig){
                            if (vFig.getName().equals(startLine)){ //если фигура является начальной
                                if (vFig.getShape().equals("V")){ //если фигура V
                                    newSubOb.setVFig(vFig.getName());
                                    collectFigToV(vFig.getName(),newSubOb);
                                }
                                break; //сразу выходим тк в теории есть только одна V связанная с R !! можно заменять для более солжных формул
                            }
                        }
                    }                  
                }   
                curAllRes.add(newSubOb); //добавляем одно уравнение в массив
            }
        }
    }  
    private void collectFigToV(String vName, genSubObj subOb ){
        for (Line_s l : curLine){ //проверяем все линии с концом в v
            if (vName.equals(l.GetID2())){
                String startLine = l.GetID1(); //откуда идёт связь
                for (Figure_s startFig : curFig){
                    if (startFig.getName().equals(startLine)){ //если фигура является начальной
                        if (startFig.getShape().equals("S1")){ //если фигура S
                            subOb.AddToS(startFig.getName());
                            continue;
                        }
                        if (startFig.getShape().equals("NV")){ //если фигура NV
                            subOb.AddToNV(startFig.getName());
                            continue;
                        }                    
                    }
                }
            }                  
        }   
    }
}


