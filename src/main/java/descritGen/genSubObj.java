package descritGen;

//Нужен для хранения одной связи фигур

import java.util.ArrayList;

public class genSubObj {
    private String resultFigName; //Имя result фигуры
    private String vFigName; //Имя v фиугры, ведущей к result
    private ArrayList<String> figAsS = new ArrayList<String>();  //Имена фигур s (S+S1)
    private ArrayList<String> figAsNV = new ArrayList<String>(); // Имена фигур NV (NV1+NV2)
    
    public genSubObj(String mainF){ //станартный генератор с созданием первоначальной фигурой
        resultFigName = mainF;
    }
    public void setVFig(String vFig){ //привязка v фигуры
        vFigName = vFig;
    }
   
    public void AddToS(String toSum){
        figAsS.add(toSum);
    }
    public void AddToNV(String toPA){
        figAsNV.add(toPA);
    }
    public String getDescriptionAsString(){
        String finalString;
        if (figAsNV.size() == 0 & figAsS.size() == 0){
            return "ERORR! Connection didnt exist";
        }
        finalString = resultFigName + " = " + vFigName + "(";
        boolean isFirst = true;
        for (String sFig : figAsS){
            if (isFirst){
                finalString += sFig;
                isFirst = false;
                continue;
            }
            finalString += " + " + sFig;
        }
        if (isFirst == false){
            finalString += ", ";
        }
        isFirst = true;
        for (String nvFig : figAsNV){
            if (isFirst){
                finalString += nvFig;
                isFirst = false;
                continue;
            }
            finalString += " + " + nvFig;
        }
        finalString += ")";
        
        return finalString;
    }
    
    public String getNameMainFig(){
        return resultFigName;
    }
    public ArrayList<String> getFigToSum(){
        return figAsS;
    }
    public ArrayList<String> getFigToPointAdd(){
        return figAsNV;
    }
     public void setNameMainFig(String newName){
        resultFigName = newName;
    }
    public void setFigToSum(ArrayList<String> newList){
        figAsS = newList;
    }
    public void setFigToPointAdd(ArrayList<String> newList){
        figAsNV = newList;
    }
}
