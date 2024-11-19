package rtranslator;
import java.io.*;
import java.util.ArrayList;
import static rtranslator.BasicFunctionCode.returnBasicFunktionCode;

public class SaveCodeInFileR {
    static public void saveToFile(String preCode, ArrayList<String> rows, String fileName){
        String global = returnBasicFunktionCode() + "\n" + preCode+"\n# --- ==== [ Основная программа ] ==== ---\n"; 
        for (String row: rows){
            global+= row + "\n";
        }
        try(FileWriter writer = new FileWriter(fileName, false))
        {
            writer.write(global);           
            writer.flush();
        }
        catch(IOException ex){
            System.out.println("Ошибка с сохранением в R code: "+ex.getMessage());
        } 
    }
}
