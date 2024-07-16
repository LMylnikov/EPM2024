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
    private ArrayList<String> fastCheck = new ArrayList<String>(); // Массив для быстрой проверки 
    public generatorObj(ConvertedObject co){
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
        for (Figure_s s : curFig){
            if (s.getShape().equals("R")){ //Если R то создаем "новую строку"
                genSubObj newSubOb = new genSubObj(s.getName());
                curAllRes.add(newSubOb); 
                fastCheck.add(s.getName());
            }
        }
        for (Line_s l : curLine){
            String toFind = l.GetID2();
            if (fastCheck.contains(toFind)){
                String startLine = l.GetID1();
                String startShape = ""; 
                for (Figure_s s : curFig){
                    if (s.getName().equals(startLine)){
                        startShape = s.getShape();
                        break;
                    }
                }
                
                for (genSubObj objc : curAllRes){
                    if (toFind.equals(objc.getNameMainFig())){
                        if (startShape.equals("R") || startShape.equals("S1")){
                            objc.AddToSum(startLine);
                        }
                        else{
                            objc.AddToPointAdd(startLine);
                        }
                    }   
                }
            }
        }
    }
}
