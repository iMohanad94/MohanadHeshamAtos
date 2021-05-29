package UIActions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class UiAction {
	private WebElement element = null; //so that i needn't to implement all element methods
	
	static public WebDriver driver ;//all classes sees and uses this driver
	static public WebDriverWait wait;


	public static final int CLICK = 1;
	public static final int CLEAR = 2;
	public static final int ENTER = 3;
	public static final int GET_TEXT = 4;
	public static final int SUBMIT = 5;



	public static final int WAIT_UNTIL_VISIBILITY = 1;
	public static final int WAIT_implicitlyWait = 2;


	public UiAction ElementWait(By byxpath,int waitype) {
		
		switch(waitype) {
		case WAIT_UNTIL_VISIBILITY:
			wait.until(ExpectedConditions.visibilityOfElementLocated(byxpath));
			break;
		case WAIT_implicitlyWait:
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			break;
		default:
			break;
		
		}
		return this;
	}


	public static void ScrollVertical(){
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

	}
	
	public UiAction FindElement(By Xpath) {

		element = driver.findElement(Xpath);
		return this;
	
	}
	
	public UiAction SendKeysToElement(String keys) {

	     element.sendKeys(keys);	
		return this;
	}



	public String ActOntheElement(int action) {
		
		switch(action) {
			case UiAction.CLICK:
				element.click();
				break;
			case UiAction.CLEAR:
				element.clear();
				break;
			case UiAction.ENTER:
				element.sendKeys(Keys.ENTER);
				break;
			case UiAction.GET_TEXT:
				return element.getText();
			case UiAction.SUBMIT:
				 element.submit();
				 break;
			default :
				break;
		}
		return null;//so that it doesn't need to return anything in the string
	}

	public void GoToPage (String URL){
		driver.navigate().to(URL);
	}

	public static void setDriver(WebDriver driver){
		UiAction.driver = driver;
	}

	public static WebDriver getDriver(){
		return UiAction.driver;
	}
	public static WebDriverWait getWaitDriver(){
		return UiAction.wait;
	}
	public static void setWaitDriver(WebDriverWait wait){
		UiAction.wait = wait;
	}

	public Boolean IsDisplayedHonda(By xpath) throws InterruptedException {
		Thread.sleep(5000);
		Boolean Status = UiAction.driver.findElement(xpath).isDisplayed();
		return Status;
	}
}