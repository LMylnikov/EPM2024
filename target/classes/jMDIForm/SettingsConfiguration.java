package jMDIForm;

import EPM.mdi;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SettingsConfiguration {
    @JsonProperty("iValue")
    private String iValue;
    @JsonProperty("nValue")
    private String nValue;
    @JsonProperty("firstIdValue")
    private String firstIdValue;
    @JsonProperty("stepIdValue")
    private String stepIdValue;
    @JsonProperty("fpValue")
    private String fpValue;
    @JsonProperty("xesNameValue")
    private String xesNameValue;
    @JsonProperty("diagrammEnable")
    private boolean diagrammEnable;
    @JsonProperty("xesEnable")
    private boolean xesEnable;
    @JsonProperty("oEnable")
    private boolean oEnable;
    
    public SettingsConfiguration(){
        this.iValue = "1";
        this.nValue = "1";
        this.firstIdValue = "1";
        this.stepIdValue = "1";
        this.fpValue = "1";
        this.xesNameValue = "results";
        this.diagrammEnable = true;
        this.xesEnable = true;
        this.oEnable = true;
    }

    public SettingsConfiguration(String iValue, String nValue, String firstIdValue, String stepIdValue, String fpValue, String xesNameValue, boolean diagrammEnable, boolean xesEnable, boolean oEnable) {
        this.iValue = iValue;
        this.nValue = nValue;
        this.firstIdValue = firstIdValue;
        this.stepIdValue = stepIdValue;
        this.fpValue = fpValue;
        this.xesNameValue = xesNameValue;
        this.diagrammEnable = diagrammEnable;
        this.xesEnable = xesEnable;
        this.oEnable = oEnable;
    }
    
    public void setDiagrammEnable(boolean diagrammEnable) {
        this.diagrammEnable = diagrammEnable;
    }

    public void setFpValue(String fpValue) {
        this.fpValue = fpValue;
    }

    public void setFirstIdValue(String firstIdValue) {
        this.firstIdValue = firstIdValue;
    }

    public void setStepIdValue(String stepIdValue) {
        this.stepIdValue = stepIdValue;
    }

    public void setXesEnable(boolean xesEnable) {
        this.xesEnable = xesEnable;
    }

    public void setXesNameValue(String xesNameValue) {
        this.xesNameValue = xesNameValue;
    }

    public void setIValue(String iValue) {
        this.iValue = iValue;
    }

    public void setNValue(String nValue) {
        this.nValue = nValue;
    }

    public void setOEnable(boolean oEnable) {
        this.oEnable = oEnable;
    }

    public String getFirstIdValue() {
        return firstIdValue;
    }

    public String getFpValue() {
        return fpValue;
    }

    public String getStepIdValue() {
        return stepIdValue;
    }

    public String getXesNameValue() {
        return xesNameValue;
    }

    public String getIValue() {
        return iValue;
    }

    public String getNValue() {
        return nValue;
    }

    public boolean isDiagrammEnable() {
        return diagrammEnable;
    }

    public boolean isXesEnable() {
        return xesEnable;
    }

    public boolean isOEnable() {
        return oEnable;
    }
    
    
}
