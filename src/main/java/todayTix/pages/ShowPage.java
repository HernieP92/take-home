package todayTix.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class ShowPage {

    SoftAssert softAssert = new SoftAssert();

    public void getTicketsAndValidateShowPage() {
        //Also we can put an assertion here to validate the URL
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        //For this basic example, but we can pass this via parameter, just to show selenide perks
        softAssert.assertEquals(currentUrl, "https://www.todaytix.com/nyc/shows/2885-dear-evan-hansen");
        /*To validate if the show page is displayed, the get tickets element needs to be visible
        If this element is not present, the page doesnt load correctly for the show*/
        $("#view-prices").shouldBe(Condition.visible).click();
        //popup basic managment
        $x("//a[contains(text(),'Skip for now')]").click();
    }
}
