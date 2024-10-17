package descritGen;

import java.util.ArrayList;

public class subObjV {
    private ArrayList<String> arrayLinkedNvR = new ArrayList<String>();
    private ArrayList<String> arrayLinkedO = new ArrayList<String>();
    private ArrayList<String> arrayLinkedS = new ArrayList<String>();
    private String nameV;
    private String type;
    
    public subObjV(String name,String type){ //стандартный генератор с прикреплением имени
        nameV = name;
        setNumberType(type);
    }
    //генератор для клонирования объекта
    public subObjV(String name,String type,  ArrayList<String> oldS,  ArrayList<String> oldNvR,  ArrayList<String> oldO){ //стандартный генератор с прикреплением имени
        nameV = name;
        this.type = type;
        for (String el: oldO){
            arrayLinkedO.add(el);
        }
        for (String el: oldS){
            arrayLinkedS.add(el);
        }
        for (String el: oldNvR){
            arrayLinkedNvR.add(el);
        }
    }
    public void AddToNvRList(String vName){
        arrayLinkedNvR.add(vName);
    }
    public void AddToOList(String vName){
        arrayLinkedO.add(vName);
    }
    public void AddToSList(String vName){
        arrayLinkedS.add(vName);
    }
    public boolean isEmpty(){
        if (arrayLinkedNvR.size() == 0 & arrayLinkedO.size() == 0 & arrayLinkedS.size() == 0){
            return true;
        }
        return false;
    }
    public ArrayList<String> getArrayLinkedNvR(){
        return arrayLinkedNvR;
    }
    public void setArrayLinkedNvR(ArrayList<String> array){
        arrayLinkedNvR = array;
    }
    public ArrayList<String> getArrayLinkedO(){
        return arrayLinkedO;
    }
    public void setArrayLinkedO(ArrayList<String> array){
        arrayLinkedO = array;
    }
    public ArrayList<String> getArrayLinkedS(){
        return arrayLinkedS;
    }
    public void setArrayLinkedS(ArrayList<String> array){
        arrayLinkedS = array;
    }
    public String getType(){
        return type;
    }
    public void setType(String type){
        setNumberType(type);
    }
    public String getName(){
        return nameV;
    }
    public void setName(String name){
        nameV = name;
    }
    private void setNumberType(String textType){
        switch (textType.charAt(2)){
            case('с'): //эксп
                type = "4";
                break; 
            case('е'): //Элем
                type = "1";
                break;
            case('ш'): //1 шаг
                type = "2";
                break; 
            case('г'): //Логар
                type = "3";
                break;
            case('o'): //xlog
                type = "5";
                break;
        }
    }
}
