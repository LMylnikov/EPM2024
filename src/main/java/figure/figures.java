package figure;

import jMDIForm.jMDIFrame;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.JComponent;
import java.util.prefs.Preferences;

public class figures extends JComponent {

    public static Preferences prefs = Preferences.userNodeForPackage(figures.class);
    int x, y;//x,y - координаты центра фигуры 
    int absoluteX, absoluteY; // - координаты при масштабе 100%
    Shape shape;
    int s;//size
    Rectangle2D rec;

    String nameF; // Имя фигуры
    String descriptionF; // Подробное описание объекта
    ArrayList<String> nameNvElement = new ArrayList(); // Лист со входными переменными
    ArrayList<String> varNvElement = new ArrayList(); // Лист с выходными переменными
    String codeF; // Код фигуры
<<<<<<< HEAD
    
    String likelihood = "0,5";//вероятность для S
    String period = "5";//период для S
    int SWorkIndex;//отметка выбора вида работы для S
    
    String coef;//коэффициент эффективности для О
    
    String vSelected;//отметка выбора сложности для V

    int ifSelected = 0; //0-i, 1-nv
    String ifNvElement; //выбранная переменная из NV для сравнения
    int signIfSelected = 0; //0-< 1-<= 2-= 3->= 4-> 
    int compareNumber = 0; // Число с которым сравниваем в IF
    
    static AtomicInteger nextId = new AtomicInteger();
    static int id;
    
    
=======

    static AtomicInteger nextId = new AtomicInteger();
    static int id;
>>>>>>> 05ba5b829904c4d9be046d8ecf0364753e0c955a

    //static public boolean doubleCl = false;    
    public figures() {
        id = nextId.incrementAndGet();
    }

    public double getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public void setXX(int x) {
        this.x = x;
    }

    public int getXX() {
        return x;
    }

    public void setYY(int y) {
        this.y = y;
    }

    public int getYY() {
        return y;
    }

    public void setAbsoluteX(int value) {
        this.absoluteX = value;
    }

    public void setAbsoluteY(int value) {
        this.absoluteY = value;
    }

    public int getAbsoluteX() {
        return absoluteX;
    }

    public int getAbsoluteY() {
        return absoluteY;
    }

    public int getSises() {
        return s;
    }

    public int getId() {
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

<<<<<<< HEAD
    public void setNameNvElement(ArrayList<String> nameNvElement) {
        this.nameNvElement = nameNvElement;
=======
    public void setInVariable(ArrayList<String> inVariable) {
        this.inVariable = inVariable;
    }

    public ArrayList<String> getInVariable() {
        return inVariable;
>>>>>>> 05ba5b829904c4d9be046d8ecf0364753e0c955a
    }

    public ArrayList<String> getNameNvElement() {
        return nameNvElement;
    }

<<<<<<< HEAD
    public void setVarNvElement(ArrayList<String> varNvElement) {
        this.varNvElement = varNvElement;
    }

    public ArrayList<String> getVarNvElement() {
        return varNvElement;
=======
    public ArrayList<String> getOutVariable() {
        return outVariable;
>>>>>>> 05ba5b829904c4d9be046d8ecf0364753e0c955a
    }

    public void setCodeF(String codeF) {
        this.codeF = codeF;
    }

    public String getCodeF() {
        return codeF;
    }

    public Rectangle2D getRec() {
        return rec;
    }

    public void setRec(Rectangle2D rec) {
        this.rec = rec;
    }
<<<<<<< HEAD
    
    public void idChange() {
        id = nextId.getAndAdd(-nextId.get());
    }
    
    public void setCoef(String coef) {
        this.coef = coef;
    }

    public String getCoef() {
        return coef;
    }
    
    public void setLikelihood(String likelihood) {
        this.likelihood = likelihood;
    }

    public String getLikelihood() {
        return likelihood;
    }
    
    public void setPeriod(String period) {
        this.period = period;
    }

    public String getPeriod() {
        return period;
    }
    
    public void setSwork(int SWorkIndex) {
        this.SWorkIndex = SWorkIndex;
    }

    public int getSwork() {
        return SWorkIndex;
    }
    public void setVSelected(String newSel){
        vSelected = newSel;
    }
    public String getVSelected(){
        return vSelected;
    }
    public void setSignIfSelected(int var){
        signIfSelected = var;
    }
    public void setIfNvElement(String var){
        ifNvElement = var;
    }
    public void setIfSelected(int var){
        ifSelected = var;
    }  
    public int getSignIfSelected(){
        return signIfSelected;
    }
    public String getIfNvElement(){
        return ifNvElement;
    }
    public int getIfSelected(){
        return ifSelected;
    }
    public int getCompareNumber(){
        return compareNumber;
    }
    public void setCompareNumber(int var){
        compareNumber = var;
    }
=======

    public void idChange() {
        id = nextId.getAndAdd(-nextId.get());
    }
>>>>>>> 05ba5b829904c4d9be046d8ecf0364753e0c955a
}
