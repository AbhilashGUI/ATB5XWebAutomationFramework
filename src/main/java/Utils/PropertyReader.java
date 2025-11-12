package Utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {


    public static String readyKey(String key) {  //1st Framework
        FileInputStream fileInputStream = null;
        Properties p = null;
        try{
            fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/Resources/Data.properties");
            p = new Properties();
            p.load(fileInputStream);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return p.getProperty(key);
    }

}
