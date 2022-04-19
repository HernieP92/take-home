package todayTix.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import todayTix.definitions.SelenideDefinitions;
import todayTix.definitions.ServiceDefinitions;



public class ServiceSteps {

    private final ServiceDefinitions serviceDefinitions;
    private final SelenideDefinitions selenideDefinitions;

    public ServiceSteps(ServiceDefinitions serviceDefinitions, SelenideDefinitions selenideDefinitions) {
        this.serviceDefinitions = serviceDefinitions;
        this.selenideDefinitions = selenideDefinitions;
    }


    @Given("^I make a request to availability service with (.+) (.+) (.+) (.+)$")
    public void i_make_a_request_to_availability_service_with(String quantity, String fromdate, String todate, String headerValue) {
        serviceDefinitions.requestAvailability(quantity, fromdate, todate, headerValue);
    }

    @When("^I validate if the status code is 200 (.+)$")
    public void i_validate_if_the_status_code_is_200(int statusExpected) {
        serviceDefinitions.statusCodeValidation(statusExpected);
    }

    @And("^I also validate if the response error message is the expected (.+)$")
    public void i_also_validate_if_the_response_error_message_is_the_expected(String expectederrormessage) {
        serviceDefinitions.errorMessageValidation(expectederrormessage);
    }

    @Then("^I make sure that minPrice is not null$")
    public void i_make_sure_that_minprice_is_not_null() {
        serviceDefinitions.minPriceValidation();
    }

}
