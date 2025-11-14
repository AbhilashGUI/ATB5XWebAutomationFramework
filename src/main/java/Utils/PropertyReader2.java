package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;


//Cucumber BDD Framework
public class PropertyReader2 {

    PropertyReader2()
    {

    }

    public static String readykey(String key) throws Exception {
            FileInputStream fileInputStream=null;
            Properties p=null;

        try {
            fileInputStream= new FileInputStream(new File(System.getProperty("user.dir")+"/src/main/java/Resources/Data.properties"));
            p=new Properties();
            p.load(fileInputStream);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (Objects.nonNull(fileInputStream)) {
                fileInputStream.close();
            }
        }

        if (p.getProperty(key) == null) {
            throw new Exception(p.getProperty(key) + " not found!!");
        } else {
            return p.getProperty(key);
        }

    }

}