package PHPTravels;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/PHPTravels",glue= {"PHPTravels"},plugin = {"pretty","html:target/cucumber-html-report"})

public class PHPTravelsRunner extends AbstractTestNGCucumberTests{
}
