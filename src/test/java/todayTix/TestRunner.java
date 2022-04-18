package todayTix;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;

import static java.lang.System.getProperty;
import static java.lang.System.setProperty;
import static org.apache.commons.lang3.StringUtils.isEmpty;

@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {"todayTix/steps/"},
        plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumberProyectoBase.json", "com.cucumber.listener.ExtentCucumberFormatter:"}
)

public class TestRunner extends AbstractTestNGCucumberTests {
    @BeforeClass
    public void setup() {
        setProperty("selenide.timeout", "30000");
        if (isEmpty(getProperty("selenide.browser"))) {
            setProperty("selenide.browser", "chrome");
        }
    }
}
