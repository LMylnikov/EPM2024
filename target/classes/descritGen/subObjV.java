package descritGen;

import java.util.ArrayList;

public class subObjV {
    private ArrayList<String> arrayLinkedNvR = new ArrayList<String>();
    private ArrayList<String> arrayLinkedO = new ArrayList<String>();
    private ArrayList<String> arrayLinkedS = new ArrayList<String>();
    private String nameV;
    
    public subObjV(String name){ //стандартный генератор с прикреплением имени
        nameV = name;
    }
    //генератор для клонирования объекта
    public subObjV(String name,  ArrayList<String> oldS,  ArrayList<String> oldNvR,  ArrayList<String> oldO){ //стандартный генератор с прикреплением имени
        nameV = name;
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
    
    public String getName(){
        return nameV;
    }
    public void setName(String name){
        nameV = name;
    }
}
