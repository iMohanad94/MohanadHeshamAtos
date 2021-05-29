package Pages;

import UIActions.UiAction;
import org.openqa.selenium.By;

public class PHPTravels {
    UiAction Action = new UiAction();

    //XPaths
    By FirstName=By.xpath("//span[normalize-space()='First Name']");
    By LastName = By.xpath("//input[@name='lastname']");
    By MobileNumber=By.xpath("//span[normalize-space()='Mobile Number']");
    By Email = By.xpath("//span[normalize-space()='Email']");
    By Password=By.xpath("//span[normalize-space()='Password']");
    By ConfirmPassword = By.xpath("//span[normalize-space()='Confirm Password']");

    //CSS Selectors
    By CSSFirstName=By.cssSelector("input[name='firstname']");
    By CSSLastName = By.cssSelector("input[name='lastname']");
    By CSSMobileNumber=By.cssSelector("input[name='phone']");
    By CSSEmail = By.cssSelector("input[name='email']");
    By CSSPassword=By.cssSelector("input[name='password']");
    By CSSConfirmPassword = By.cssSelector("input[name='confirmpassword']");
    By CSSSignUPButton = By.cssSelector("button[class='signupbtn btn_full btn btn-success btn-block btn-lg']");
    By ErrorMessage =By.xpath("//p[normalize-space()='Password not matching with confirm password.']");


    public void SendFirstName(String FirstName) {
        Action.FindElement(CSSFirstName).SendKeysToElement(FirstName);
    }
    public void SendLastName(String LastName) {
        Action.FindElement(CSSLastName).SendKeysToElement(LastName);
    }
    public void SendMobileNumber(String MobileNumber) {
        Action.FindElement(CSSMobileNumber).SendKeysToElement(MobileNumber);
    }
    public void SendEmail(String Email) {
        Action.FindElement(CSSEmail).SendKeysToElement(Email);
    }
    public void SendPassword(String Password) {
        Action.FindElement(CSSPassword).SendKeysToElement(Password);
    }
    public void SendConfirmPassword(String Password) {
        Action.FindElement(CSSConfirmPassword).SendKeysToElement(Password);
    }
    public void PressSignUpButton(){
        Action.FindElement(CSSSignUPButton).ActOntheElement(Action.SUBMIT);
    }
    public Boolean VerifyPasswordErrorMessage() throws InterruptedException {
        Boolean Status = Action.IsDisplayedHonda(ErrorMessage);
        return Status;
    }

}
