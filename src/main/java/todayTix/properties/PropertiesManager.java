package todayTix.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesManager {
    private final Properties prop;

    @Getter
    @AllArgsConstructor
    public enum Property {
        EVIDENCE_PATH("EVIDENCEPATH"),
        BASE_URL("BASE.URL");

        private final String value;
    }

    @SneakyThrows
    /*This method is builded as part of the general structure of 1 automation project to manage envs ;D
    For this example we will just use a simple base URL, but this will help in the future */

    public PropertiesManager(Properties prop) {
        this.prop = prop;

        prop.load(new FileInputStream("src/main/resources/properties/configuration.properties"));

    }

    public String getProp(Property property) {
        return prop.getProperty(property.getValue());
    }

}
