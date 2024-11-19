package point;

import figure.V;
import figure.figures;
import java.util.ArrayList;

public class cancellationCondition {
    boolean iscancell = false;
    ArrayList<figures> all;
    figures curFig;
    public cancellationCondition(String endFig, String startFig, ArrayList<figures> alls){
        this.all = alls;
        for (figures f: all){
            if (f.getNameF().equals(endFig)){
                curFig = f;
            }
        }
    }
    
    public boolean isCancellationCondition(){
        if (curFig.getClass().equals(V.class)){
            iscancell = true;
        }
        return iscancell;
    }
}
