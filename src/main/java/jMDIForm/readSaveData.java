/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jMDIForm;

import figure.*;
import java.util.ArrayList;

public class readSaveData {
    //Код для очищения основного файла. Определяем тип, который необходимо создать и создаем его.
    public ArrayList <figures> getElement(ArrayList <figures> list, String shape, String Sx, String Sy, String Ss, String name, String code, String description, ArrayList<String> inVariable,ArrayList<String> outVariable){
        int x = Integer.parseInt(Sx);
        int y = Integer.parseInt(Sy);
        int s = Integer.parseInt(Ss);
        double zoom = 1; 
        
        if ("d".equals(shape)){
            d dn =  new d(x, y, s); 
            dn.setVisible(true);
            dn.setNameF(name);
            dn.setDescriptionF(description);
            dn.setInVariable(inVariable);
            dn.setOutVariable(outVariable);
            dn.setCodeF(code);
            list.add(0,dn);
            
        }
        if ("V".equals(shape)){
            V dn =  new V(x, y, s); 
            dn.setVisible(true);
            dn.setNameF(name);
            dn.setDescriptionF(description);
            dn.setInVariable(inVariable);
            dn.setOutVariable(outVariable);
            dn.setCodeF(code);
            list.add(0,dn);
        }
        if ("R".equals(shape)){
            R dn =  new R(x, y, s); 
            dn.setVisible(true);
            dn.setNameF(name);
            dn.setDescriptionF(description);
            dn.setInVariable(inVariable);
            dn.setOutVariable(outVariable);
            dn.setCodeF(code);
            list.add(0,dn);
        }
        if ("NV".equals(shape)){
            NV dn =  new NV(x, y, s); 
            dn.setVisible(true);
            dn.setNameF(name);
            dn.setDescriptionF(description);
            dn.setInVariable(inVariable);
            dn.setOutVariable(outVariable);
            dn.setCodeF(code);
            list.add(0,dn);
        }
        if ("S1".equals(shape)){
            S1 dn =  new S1(x, y, s); 
            dn.setVisible(true);
            dn.setNameF(name);
            dn.setDescriptionF(description);
            dn.setInVariable(inVariable);
            dn.setOutVariable(outVariable);
            dn.setCodeF(code);
            list.add(0,dn);
        }
        return list;
    }
}
