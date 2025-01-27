package converter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jMDIForm.SettingsConfiguration;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
//Совмещает в себе все классы, которые нужно сохранить в json
public class ConvertedObject {
    private SettingsConfiguration settingConfig;
    private ArrayList<Line_s> currentLine;
    private ArrayList<Figure_s> currentFigures;

    public ConvertedObject() {}
    
    public ConvertedObject(ArrayList<Line_s> linesList, ArrayList<Figure_s> figuresList, SettingsConfiguration settingConfig) {
        this.currentFigures = figuresList;
        this.currentLine = linesList;
        this.settingConfig = settingConfig;
    }
    
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
        return currentFigures;
    }
    public void setSettingConfig(SettingsConfiguration settingConfig) {
        this.settingConfig = settingConfig;
    }

    public SettingsConfiguration getSettingConfig() {
        return settingConfig;
    }
    
}
