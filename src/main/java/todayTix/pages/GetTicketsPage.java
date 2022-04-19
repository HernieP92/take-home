package todayTix.pages;


import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class GetTicketsPage {

    public void ticketPageValidations() {
        //Validate if calendar box exists.
        $x("//*[contains(@class,'_1nJAmKbKaq')]").shouldBe(Condition.exist);
        $x("//*[contains(@class,'_2CwvfUoSyY')]").shouldBe(Condition.visible).click();
        //Validate showtime form and click first showtime
        $x("//div[@id='showtime-0-price']")
                .shouldBe(Condition.visible)
                .click();
        //Validate section button and click
        $x("//div[@class='_3cCXDzSOBH']").shouldBe(Condition.visible).click();
        // Validate if there is section to user info form
        $x("//div[@class='so2B1bE8Uw kEBDzFCjja']").shouldBe(Condition.exist);
        // Validate if there is the 2 payment options div[@class='_17t8zL9DDo']/*
        $$("._17t8zL9DDo button").shouldHave(CollectionCondition.size(2));
    }

    public void fillUserInfoAndSelectCardPayment() {
        //Fillout user info
        $x("//input[@name='account.email']")
                .shouldBe(Condition.exist)
                .setValue("test@zaga.com");
        $x("//input[@name='account.firstName']")
                .shouldBe(Condition.exist)
                .setValue("Hernan");
        $x("//input[@name='account.lastName']")
                .shouldBe(Condition.exist)
                .setValue("Perez");
        $x("//input[@name='account.password']")
                .shouldBe(Condition.exist)
                .setValue("technicalTest");
    }

    public void validateCreditCardForm() {
        //Click the credit card button
        $$("._17t8zL9DDo button").get(1).click();
        //For this validation using the capacity of selenide to map elements, i'll verify if all exists.
        $x("//input[@name='payment.creditCard']").shouldBe(Condition.visible).shouldBe(Condition.exist);
        $x("//select[@name='payment.expMonth']").shouldBe(Condition.visible).shouldBe(Condition.exist);
        $x("//input[@name='payment.cvv']").shouldBe(Condition.visible).shouldBe(Condition.exist);
        $x("//select[@name='payment.expYear']").shouldBe(Condition.visible).shouldBe(Condition.exist);
        $x("//input[@name='payment.postalCode']").shouldBe(Condition.visible).shouldBe(Condition.exist);
    }
}
