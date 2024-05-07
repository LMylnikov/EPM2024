package figure;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.JComponent;
import java.util.prefs.Preferences;

public class figures extends JComponent{
    public static Preferences prefs = Preferences.userNodeForPackage(figures.class);
    int x, y;//x,y - координаты центра фигуры 
    Shape shape;
    int s;//s - size
    Rectangle2D rec;
//    String str;
//     private static int counter = 0;
//    public final int id = 0;
    
    String nameF; // Имя фигуры
    String descriptionF; // Подробное описание объекта
    ArrayList<String> inVariable = new ArrayList(); // Лист со входными переменными
    ArrayList<String> outVariable = new ArrayList(); // Лист с выходными переменными
    String codeF; // Код фигуры
    
    static AtomicInteger nextId = new AtomicInteger();
    static int id;
    //static public boolean doubleCl = false;
    public figures() {
        id = nextId.incrementAndGet();   
    }
    
      public double getS(){
       return s;        
    }
    
    public void setS(int s){
        this.s=s;
    }
      public Shape getShape(){
       return shape;       
    }
    public void setShape(Shape shape) {
        this.shape = shape;
    }
    
    public void setXX(int x){
        this.x=x;
    }
      public int getXX(){
       return x;       
    }
    public void setYY(int y){
        this.y=y;
    }
      public int getYY(){
       return y;       
    }
      
    public int getSises(){
        return s;
    }
    public int getId(){
        return id;
    }

    public void setSize(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    //Новые переменные
    public void setNameF(String nameF) {
        this.nameF = nameF;
    }
    public String getNameF() {
        return nameF;
    }

    public void setDescriptionF(String descriptionF) {
        this.descriptionF = descriptionF;
    }
    public String getDescriptionF() {
        return descriptionF;
    }

    public void setInVariable(ArrayList<String> inVariable) {
        this.inVariable = inVariable;
    }
    public ArrayList<String> getInVariable() {
        return inVariable;
    }

    public void setOutVariable(ArrayList<String> outVariable) {
        this.outVariable = outVariable;
    }
     public ArrayList<String> getOutVariable() {
        return outVariable;
    }

    public void setCodeF(String codeF) {
        this.codeF = codeF;
    }
    public String getCodeF() {
        return codeF;
    }
    public Rectangle2D getRec(){  
        return rec;
    }
    public void setRec(Rectangle2D rec){
        this.rec=rec;
    } 
       
}
