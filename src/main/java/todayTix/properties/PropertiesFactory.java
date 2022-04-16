package todayTix.properties;

import java.util.Properties;

public class PropertiesFactory {

    private PropertiesFactory(){}

    private static PropertiesManager propertiesManager;

    public static PropertiesManager get(){
        if(propertiesManager == null){
            propertiesManager = new PropertiesManager(new Properties());
        }
        return propertiesManager;
    }
}
