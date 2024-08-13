package converter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Figure_s {

    @JsonProperty("x_pos")
    private String x_pos;
    @JsonProperty("y_pos")
    private String y_pos;
    @JsonProperty("shape")
    private String shape;
    @JsonProperty("size")
    private String size;
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name; // Имя фигуры
    @JsonProperty("description")
    private String description; // Подробное описание объекта
    @JsonProperty("inVariable")
    private ArrayList<String> inVariable = new ArrayList(); // Лист со входными переменными
    @JsonProperty("outVariable")
    private ArrayList<String> outVariable = new ArrayList(); // Лист с выходными переменными
    @JsonProperty("code")
    private String code; // Код фигуры

    public void setX_pos(String x_pos) {
        this.x_pos = x_pos;
    }

    public void setY_pos(String y_pos) {
        this.y_pos = y_pos;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getX_pos() {
        return x_pos;
    }

    public String getY_pos() {
        return y_pos;
    }

    public String getShape() {
        return shape;
    }

    public String getSize() {
        return size;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setInVariable(ArrayList<String> inVar) {
        this.inVariable = inVar;
    }

    public ArrayList<String> getInVariable() {
        return inVariable;
    }

    public void setOutVariable(ArrayList<String> outVar) {
        this.outVariable = outVar;
    }

    public ArrayList<String> getOutVariable() {
        return outVariable;
    }
}