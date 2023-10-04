package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesReader {

    private static PropertiesReader propertiesReader = null;
    private PropertiesReader(){}
    public static PropertiesReader getInstance(){
        if(propertiesReader == null){
            propertiesReader = new PropertiesReader();
        }
        return propertiesReader;
    }
    Properties properties;
    public static final String PROPERTIES_PATH = "./src/main/resources/EnvironmentProperties/Configuration.properties";
    public Properties loadProperties() {
        try {
            properties = new Properties();
            File file = new File(PROPERTIES_PATH);
            FileInputStream fileInputStream = new FileInputStream(file);
            properties.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    public  String getPropertyValue(String key){
       return loadProperties().getProperty(key);
    }
}
