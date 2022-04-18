package todayTix.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import todayTix.definitions.ServiceDefinitions;

public class ServiceSteps {

    private final ServiceDefinitions serviceDefinitions;

    public ServiceSteps(ServiceDefinitions serviceDefinitions) {
        this.serviceDefinitions = serviceDefinitions;
    }

    @Given("^I make a request to availability service with (.+) (.+) (.+) (.+)$")
    public void i_make_a_request_to_availability_service_with(String quantity, String fromdate, String todate, String headerValue) {
        serviceDefinitions.requestAvailability(quantity, fromdate, todate, headerValue);
    }

    @When("^I validate if the status code is 200 (.+)$")
    public void i_validate_if_the_status_code_is_200(int statusExpected) {
        serviceDefinitions.statusCodeValidation(statusExpected);
    }

    @Then("^I make sure that minPrice is not null$")
    public void i_make_sure_that_minprice_is_not_null() {
        serviceDefinitions.minPriceValidation();
    }
}
