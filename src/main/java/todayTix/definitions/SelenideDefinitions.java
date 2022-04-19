package todayTix.definitions;

import lombok.RequiredArgsConstructor;
import todayTix.pages.GetTicketsPage;
import todayTix.pages.HomePage;
import todayTix.pages.ShowPage;
import todayTix.properties.PropertiesManager;

import static com.codeborne.selenide.Selenide.open;

@RequiredArgsConstructor
public class SelenideDefinitions extends Definition {

    private final HomePage homePage;
    private final ShowPage showPage;
    private final GetTicketsPage getTicketsPage;
    private final PropertiesManager prop;

    public void openTodayTixPage() {
        execute("Go to today tix home page", () ->
                open(prop.getProp(PropertiesManager.Property.TODAY_APP_URL)));
    }

    public void locationAndShow() {
        execute("Selecting location and show", homePage::selectLocationAndShow);
    }

    public void getTicketsAndShowValidation() {
        execute("Getting ticket and validating show page", showPage::getTicketsAndValidateShowPage);
    }

    public void ticketPageSelectionsAndValidations() {
        execute("Validating ticket page elements to continue with the user flow",
                getTicketsPage::ticketPageValidations);
    }

    public void fillUserForm() {
        execute("Filling user form and making field validations",
                getTicketsPage::fillUserInfoAndSelectCardPayment);
    }

    public void creditCardFormValidations() {
        execute("Validating credit card form", getTicketsPage::validateCreditCardForm);
    }

}
