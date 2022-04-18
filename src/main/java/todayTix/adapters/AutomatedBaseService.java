package todayTix.adapters;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import org.testng.asserts.SoftAssert;
import todayTix.properties.PropertiesFactory;
import todayTix.properties.PropertiesManager;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;


@Log4j2
public abstract class AutomatedBaseService {

    private int statusCode;
    private Response globalResponse;
    SoftAssert softAssert = new SoftAssert();

    public AutomatedBaseService() {
        RestAssured.baseURI = PropertiesFactory.get().getProp(PropertiesManager.Property.BASE_URL);
    }


    protected Response get(String method, String headerValue) {
        return getRequest(method, headerValue);

    }

    public void statusCodeValidation(int statusExpected) {

        softAssert.assertEquals(statusCode /*actual value*/, statusExpected /*expected value*/, "Status code returned");
        softAssert.assertAll();
    }

    public void minPriceValidation() {

        try {
            ArrayList<Integer> minPrices = globalResponse.jsonPath().get("response.minPrice");
            for (int i = 0; i < minPrices.size(); i++) {
                if (minPrices.get(i) != null) {
                } else {
                    softAssert.assertNotNull(minPrices.get(i), "For the actual product there is one or more " +
                            "min price field null");
                }
            }
        } catch (Exception e) {
            System.out.println("For the actual product there is no min price values");
        }
    }

    private Response getRequest(String method, String headerValue) {
        log.info(String.format("Sending request to: ", method));

        Response response = given().header("affiliateId", headerValue)
                .when()
                .get(method)
                .then()
                .extract().response();
        statusCode = response.getStatusCode();
        globalResponse = response;
        log.info(String.format("Response to method:  ", method, response.asString()));
        return response;

    }


}
