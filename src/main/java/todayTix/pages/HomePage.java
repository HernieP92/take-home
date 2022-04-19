package todayTix.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class HomePage {

    public void selectLocationAndShow() {
        $(By.cssSelector("#locations-select"))
                .shouldBe(Condition.visible)
                .click();
        $x("//li[@data-value='nyc']").shouldBe(Condition.visible).click();

        //Validating if the location selection was apply by the search button placeholder
        $x("//input[@placeholder='Search for shows in New York']")
                .shouldBe(Condition.visible);
        $(By.cssSelector("#topBarSearch"))
                .shouldBe(Condition.exist)
                .setValue("Dear Evan Hansen");
        $x("//span[contains(text(),'Dear Evan Hansen')]")
                .shouldBe(Condition.exist)
                .click();
    }
}
