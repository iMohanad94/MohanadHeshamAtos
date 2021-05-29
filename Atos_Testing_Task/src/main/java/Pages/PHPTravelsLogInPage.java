package Pages;

import UIActions.UiAction;
import org.openqa.selenium.By;

public class PHPTravelsLogInPage {

    UiAction Action = new UiAction();
    String URL = "https://www.phptravels.net/login/en";

    //CSS Selectors
    By CSSEmail = By.cssSelector("input[name='username']");
    By CSSPassword = By.cssSelector("input[name='password']");
    By CSSSignInButton = By.cssSelector(".btn.btn-primary.btn-lg.btn-block.loginbtn");
    By CSSErrorMessage = By.cssSelector(".alert.alert-danger");
    By ErrorMessage = By.xpath("//div[@class='alert alert-danger']");

    public void SendEmail(String Email) {
        Action.FindElement(CSSEmail).SendKeysToElement(Email);
    }

    public void SendPassword(String Password) {
        Action.FindElement(CSSPassword).SendKeysToElement(Password);
    }

    public void PressSignInButton() {
        Action.FindElement(CSSSignInButton).ActOntheElement(Action.CLICK);
    }

    public void GoToSignInPage() {
        Action.GoToPage(URL);
    }

    public Boolean CheckErrorMessage() throws InterruptedException {
       Boolean Status = Action.IsDisplayedHonda(CSSErrorMessage);
        return Status;
    }
}