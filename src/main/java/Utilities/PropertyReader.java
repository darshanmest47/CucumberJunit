package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {
   private static volatile PropertyReader instance;
   private Properties properties;

   private PropertyReader() throws Exception {
       try(FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\config.properties")){
           properties = new Properties();
           properties.load(fis);
       }catch (Exception e){
           e.printStackTrace();
           throw new Exception("Failed to load propertyfile");
       }
   }

   public static PropertyReader getInstance() throws Exception {
       if(instance==null){
           synchronized (PropertyReader.class){
               if(instance==null){
                   instance = new PropertyReader();
               }
           }
       }
       return instance;
   }

   public String getProperty(String key){
       return properties.getProperty(key);
   }

}
