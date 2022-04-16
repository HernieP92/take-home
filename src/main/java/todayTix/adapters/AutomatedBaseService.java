package todayTix.adapters;

import io.restassured.RestAssured;
import lombok.extern.log4j.Log4j2;
import todayTix.properties.PropertiesFactory;
import todayTix.properties.PropertiesManager;

@Log4j2
public abstract class AutomatedBaseService {

    public AutomatedBaseService() {
        RestAssured.baseURI = PropertiesFactory.get().getProp(PropertiesManager.Property.BASE_URL);
    }

}
