package PHPTravels;

import FileReader.PropertiesFileReader;
import UIActions.UiAction;
import io.cucumber.core.api.Scenario;
import io.cucumber.core.event.Status;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Base {
//    String URL = "https://www.phptravels.net/register/en";

//    @Before
//    public void Before() {
//
//        ChromeOptions options = new ChromeOptions();//to remove notification banner
////    options.addArguments("--disable-notifications");
//        options.addArguments("--lang=en-GB");
//        WebDriverManager.chromedriver().setup();//to make the resources driver needless
//        UiAction.driver = new ChromeDriver(options);
//
//        UiAction.driver.navigate().to(URL);
//        UiAction.driver.manage().window().maximize();
//        UiAction.wait = new WebDriverWait(UiAction.driver, 300);//implicit wait before every selenium method
//    }
String URL = "https://www.phptravels.net/register/en";
    @Before
    public void Before() {
        String[] Browser = PropertiesFileReader.propertiesFileReader(new String[]{"Browser"});
        switch (Browser[0]) {
            case "chrome": // run tests by chrome
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                WebDriverManager.chromedriver().setup();
                UiAction.setDriver(new ChromeDriver(options)) ;
                break;
            case "firefox": //run tests by firefox
                WebDriverManager.firefoxdriver().setup();
                UiAction.setDriver(new FirefoxDriver());
                break;
            case "internet explorer": //run tests by internet explore
                WebDriverManager.iedriver().setup();
                UiAction.setDriver(new InternetExplorerDriver());
                break;
            case "opera": //run tests by opera
                WebDriverManager.operadriver().setup();
                UiAction.setDriver(new OperaDriver());
                break;
        }
        UiAction.driver.navigate().to(URL);
        UiAction.driver.manage().window().maximize();
        UiAction.wait = new WebDriverWait(UiAction.driver, 300);//implicit wait before every selenium method
    }
    public void resetWebDriver() {
        ChromeOptions options = new ChromeOptions();//to remove notification banner
//    options.addArguments("--disable-notifications");
        options.addArguments("--lang=en-GB");
        WebDriverManager.chromedriver().setup();//to make the resources driver needless
        UiAction.driver = new ChromeDriver(options);

        UiAction.driver.navigate().to(URL);
        UiAction.driver.manage().window().maximize();
        UiAction.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @After
    public void After() {

        UiAction.driver.close();
        UiAction.driver.quit();

    }



    @BeforeStep
    public void BeforeStep() throws InterruptedException {
        Thread.sleep(500);
    }

    @AfterStep
    public void AfterStep(Scenario scenario) throws InterruptedException, IOException {
        Thread.sleep(1000);
        if ((scenario).equals(Status.FAILED)) {
            takeScreenshot(scenario);
        }
    }



    private void takeScreenshot(Scenario scenario) {

        final byte[] screenshot = ((TakesScreenshot) getWebDriver())
                .getScreenshotAs(OutputType.BYTES);
        String currentDate = new SimpleDateFormat("_yyyy-MM-dd_HH:mm:ss").format(new Date());
        scenario.embed(screenshot, "image/png", scenario.getName() + "" + currentDate);
    }



    public  WebDriver getWebDriver() {
        if (UiAction.driver == null) {
            resetWebDriver();
        }
        return UiAction.driver;
    }
}