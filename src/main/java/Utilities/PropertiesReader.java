package Utilities;

import java.io.*;
import java.util.Properties;

public class PropertiesReader {

    Properties properties;
    public PropertiesReader(String path) {
        try {
            properties = new Properties();
            InputStream inputStream = PropertiesReader.class.getResourceAsStream("/"+path+".properties");
            assert inputStream != null;
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            properties.load(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getPropertyValue(String key) {
        return properties.getProperty(key);
    }
}
