package point;

import figure.figures;
import java.util.ArrayList;
import line.Line;

public class detectConfrontation {
    public static boolean isCrossAdding(figures f, ArrayList<figure.Line> lines){
        if (f.getNameF().contains("V") && !(f.getNameF().contains("N")) && f.getNameF().contains("2")){
            return false;
        }
        return false;
    }
}
