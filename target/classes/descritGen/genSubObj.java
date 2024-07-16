package descritGen;

//Нужен для хранения одной связи фигур

import java.util.ArrayList;

public class genSubObj {
    private String nameMainFig; //Имя основнйо фигуры
    private ArrayList<String> figToSum = new ArrayList<String>();  //Имена фигур для суммы (S+R+S1)
    private ArrayList<String> figToPointAdd = new ArrayList<String>(); // Имена фигур для перечисления через тч с зп (...;NV1;NV2)
    
    public genSubObj(String mainF){
        nameMainFig = mainF;
    }
    
    public void AddToSum(String toSum){
        figToSum.add(toSum);
    }
    public void AddToPointAdd(String toPA){
        figToPointAdd.add(toPA);
    }
    public String getDescriptionAsString(){
        String finalString;
        if (figToPointAdd.size() == 0 & figToSum.size() == 0){
            return "ERORR! Connection didnt exist";
        }
        finalString = nameMainFig + " = ";
        boolean isFirst = true;
        for (String ts : figToSum){
            if (isFirst){
                finalString += ts;
                isFirst = false;
                continue;
            }
            finalString += " + " + ts;
        }
        for (String tpa : figToPointAdd){
            finalString += "; " + tpa;
        }
        return finalString;
    }
    
    public String getNameMainFig(){
        return nameMainFig;
    }
    public ArrayList<String> getFigToSum(){
        return figToSum;
    }
    public ArrayList<String> getFigToPointAdd(){
        return figToPointAdd;
    }
     public void setNameMainFig(String newName){
        nameMainFig = newName;
    }
    public void setFigToSum(ArrayList<String> newList){
        figToSum = newList;
    }
    public void setFigToPointAdd(ArrayList<String> newList){
        figToPointAdd = newList;
    }
}
