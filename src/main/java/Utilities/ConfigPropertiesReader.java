package Utilities;

import io.cucumber.java.Scenario;

import java.io.*;
import java.util.HashMap;
import java.util.Properties;

public class ConfigPropertiesReader {

    private static ConfigPropertiesReader configPropertiesReader = null;
    public HashMap<String, Scenario> scenarioContext = new HashMap<>();
    private ConfigPropertiesReader(){}
    public static ConfigPropertiesReader getInstance(){
        if(configPropertiesReader == null){
            configPropertiesReader = new ConfigPropertiesReader();
        }
        return configPropertiesReader;
    }
    Properties properties;
    public Properties loadProperties() {
        try {
            properties = new Properties();
            InputStream inputStream = ConfigPropertiesReader.class.getResourceAsStream("/EnvironmentProperties/Configuration.properties");
            assert inputStream != null;
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            properties.load(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }
    public  String getPropertyValue(String key){
       return loadProperties().getProperty(key);
    }

    public void setScenarioContext(String key,Scenario value){
        scenarioContext.put(key+Thread.currentThread().getId(),value);
    }

    public Scenario getScenarioContext(String key){
        return scenarioContext.get(key+Thread.currentThread().getId());
    }
}
