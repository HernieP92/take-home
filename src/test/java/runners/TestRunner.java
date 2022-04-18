package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features"
        , glue = {"todayTix/steps"}
        , plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
        , tags = "@todayTix"
)
public class TestRunner extends AbstractTestNGCucumberTests {


}
