package converter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
<<<<<<< HEAD
import java.util.ArrayList;
=======
import java.util.List;
>>>>>>> 05ba5b829904c4d9be046d8ecf0364753e0c955a

@JsonIgnoreProperties(ignoreUnknown = true)
//Совмещает в себе все классы, которые нужно сохранить в json
public class ConvertedObject {
<<<<<<< HEAD
    private ArrayList<Line_s> currentLine;
    private ArrayList<Figure_s> currentFigures;

    public ConvertedObject() {}
    
    public ConvertedObject(ArrayList<Line_s> linesList, ArrayList<Figure_s> figuresList) {
=======
    private List<Line_s> currentLine;
    private List<Figure_s> currentFigures;

    public ConvertedObject() {}
    
    public ConvertedObject(List<Line_s> linesList, List<Figure_s> figuresList) {
>>>>>>> 05ba5b829904c4d9be046d8ecf0364753e0c955a
        currentFigures = figuresList;
        currentLine = linesList;
    }
    
<<<<<<< HEAD
    public void setCurrentLine(ArrayList<Line_s> linesList){
        this.currentLine = linesList;
    }
    public void setCurrentFigures(ArrayList<Figure_s> figuresList){
        this.currentFigures = figuresList;
    }
    public ArrayList<Line_s> getCurrentLine(){
        return currentLine;
    }
    public ArrayList<Figure_s> getCurrentFigures(){
=======
    public void setCurrentLine(List<Line_s> linesList){
        this.currentLine = linesList;
    }
    public void setCurrentFigures(List<Figure_s> figuresList){
        this.currentFigures = figuresList;
    }
    public List<Line_s> getCurrentLine(){
        return currentLine;
    }
    public List<Figure_s> getCurrentFigures(){
>>>>>>> 05ba5b829904c4d9be046d8ecf0364753e0c955a
        return currentFigures;
    }
}
