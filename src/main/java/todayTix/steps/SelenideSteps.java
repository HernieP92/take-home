package todayTix.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import todayTix.definitions.SelenideDefinitions;

public class SelenideSteps {
    private final SelenideDefinitions selenideDefinitions;

    public SelenideSteps(SelenideDefinitions selenideDefinitions) {
        this.selenideDefinitions = selenideDefinitions;
    }

    @Given("^I open today tix home page$")
    public void i_open_today_tix_home_page() {
        selenideDefinitions.openTodayTixPage();
    }

    @When("I select location and search one show")
    public void iSelectLocationAndSearchOneShow() {
        selenideDefinitions.locationAndShow();
        selenideDefinitions.getTicketsAndShowValidation();
    }


    @And("I try to get tickets for desired date")
    public void iTryToGetTicketsForDesiredDate() {
        selenideDefinitions.ticketPageSelectionsAndValidations();
    }

    @Then("I fill out the information and click the credit card method")
    public void iFillOutTheInformationAndClickTheCreditCardMethod() {
        selenideDefinitions.fillUserForm();
        selenideDefinitions.creditCardFormValidations();
    }
}
