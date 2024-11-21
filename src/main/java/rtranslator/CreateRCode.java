package rtranslator;
import java.io.*;
import java.util.ArrayList;
import static rtranslator.BasicFunctionCode.returnBasicFunktionCode;

public class CreateRCode {
    public static String generateCodeRFromString(String preCode, ArrayList<String> rows){
        String global = returnBasicFunktionCode() + "\n" + preCode+"\n# --- ==== [ Основная программа ] ==== ---\n"; 
        for (String row: rows){
            global+= row + "\n";
        }
        return global;
    }
    
    public static void saveInFile(String global ,String fileName){
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
