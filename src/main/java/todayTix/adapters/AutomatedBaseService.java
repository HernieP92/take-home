package todayTix.adapters;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONObject;
import org.testng.Assert;
import todayTix.properties.PropertiesFactory;
import todayTix.properties.PropertiesManager;

import java.util.Map;

import static io.restassured.RestAssured.given;

@Log4j2
public abstract class AutomatedBaseService {

    public AutomatedBaseService() {
        RestAssured.baseURI = PropertiesFactory.get().getProp(PropertiesManager.Property.BASE_URL);
    }

    protected Response get(String method, Map<String, Object> attributes) {
        return sendGet(method, attributes);
    }

    protected Response get(String method) {
        return getRequest(method);

    }

    private Response sendGet(String method, Map<String, Object> attributes) {
        log.info(String.format("Sending request to: %s with parameters: %s", method, attributes));
        RequestSpecification request = given();
        request.header("affiliateId", " londontheatredd");
        request.body(getJsonObject(attributes));
        Response get = request.get(method);
        log.info(String.format("Response to method: %s -->>>  %s: ", method, get.asString()));
        return get;
    }

    private Response getRequest(String method) {
        //log.info(String.format("Sending request to: %s with parameters: %s", method));
        Response response = given().header("affiliateId", " londontheatredd")
                .when()
                .get(method)
                .then()
                .extract().response();
        int statusCode = response.getStatusCode();
        log.info(String.format("Response to method: %s -->>>  %s: ", method, response.asString()));
        Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
        return response;

        //Assertions.assertEquals("qui est esse", response.jsonPath().getString("title[1]"));
    }

    @NotNull
    @SuppressWarnings("unchecked")
    private String getJsonObject(Map<String, Object> attributes) {
        JSONObject requestParams = new JSONObject();
        // Set every attribute to the request
        attributes.forEach(requestParams::put);
        return requestParams.toJSONString();
    }
}
