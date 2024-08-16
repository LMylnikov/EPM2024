package descritGen;

import java.util.ArrayList;

public class subObjIF {
    private String linkedInR; //в теории только по одной фигуре на вход и выход да/нет, так что просто сттроки
    private String linkedOutTrueR;
    private String linkedOutFalseV;
    
    private String nameIF;
    
    public subObjIF(String name){ //стандартный генератор с прикреплением имени
        nameIF = name;
    }
    public boolean isCorrect(){ // если нет одного из элементов if не имеет смысла
        if (linkedOutFalseV == null || linkedOutTrueR == null || linkedInR == null){
            return false;
        }
        return true;
    }
    public String getLinkedOutTrueR(){
        return linkedOutTrueR;
    }
    public void setLinkedOutTrueR(String rLink){
        linkedOutTrueR = rLink;
    }
    public void setLinkedOutFalseV(String vLink){
        linkedOutFalseV = vLink;
    }
    public String getLinkedOutFalseV(){
        return linkedOutFalseV;
    }
    public void setLinkedInR(String rLink){
        linkedInR = rLink;
    }
    public String getLinkedInR(){
        return linkedInR;
    }
    
    public String getName(){
        return nameIF;
    }
    public void setName(String name){
        nameIF = name;
    }
}
