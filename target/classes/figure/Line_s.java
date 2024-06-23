package figure;

import java.awt.geom.Point2D;

public class Line_s {
    private String x1; //Старые переменные для указания местоположения с1 и с2
    private String y1;
    private String x2;
    private String y2;
    private String id11;
    private String id22;
    private String ID1;
    private String ID2;
    
//    private String C1; //переменная содержи тдве координаты в одной строке
//    private String C2;
    
//    //Добавляю новый сетер, который объединяет две координаты в одну строку
//    public void SetC1(Point2D c1) {
//        String crossCoord = Double.toString(c1.getX())+" "+Double.toString(c1.getY());
//        this.C1 = crossCoord;
//    }
//    public void SetC2(Point2D c2) {
//        String crossCoord = Double.toString(c2.getX())+" "+Double.toString(c2.getY());
//        this.C2 = crossCoord;
//    }
//    
//    public String GetC1() {
//        return C1;
//    }
//    public String GetC2() {
//        return C2;
//    }
//    
    
    public void SetC1(Point2D c1) {
        this.x1 = Double.toString(c1.getX());
        this.y1 = Double.toString(c1.getY());
    }
    public void SetC2(Point2D c2) {
        this.x2 = Double.toString(c2.getX());
        this.y2 = Double.toString(c2.getY());
    } //Старый код
    public void SetId11(int id11){
        this.id11 = Integer.toString(id11);
    }
    public void SetId22(int id22){
        this.id22 = Integer.toString(id22);
    }
    public void SetID1(String ID1){
        this.ID1 = ID1;
    }
    public void SetID2(String ID2){
        this.ID2 = ID2;
    }
    
    public Point2D GetC1() {
        Point2D c1 = new Point2D.Double(Double.valueOf(x1), Double.valueOf(y1));
        return c1;
    }
    public Point2D GetC2() {
        Point2D c2 = new Point2D.Double(Double.valueOf(x2), Double.valueOf(y2));
        return c2;
    } //старый код
    
    public int GetId11(){
        return Integer.valueOf(id11);
    }
    public int GetId22(){
        return Integer.valueOf(id22);
    }
    public String GetID1(){
        return ID1;
    } 
    public String GetID2(){
        return ID2;
    }
}
