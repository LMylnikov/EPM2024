package converter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
//Совмещает в себе все классы, которые нужно сохранить в json
public class ConvertedObject {
    private List<Line_s> currentLine;
    private List<Figure_s> currentFigures;

    public ConvertedObject() {}
    
    public ConvertedObject(List<Line_s> linesList, List<Figure_s> figuresList) {
        currentFigures = figuresList;
        currentLine = linesList;
    }
    
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
        return currentFigures;
    }
}
