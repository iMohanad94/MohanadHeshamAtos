package Pages;

import UIActions.UiAction;
import org.openqa.selenium.By;

public class PHPTravelsProfilePage {
    UiAction Action = new UiAction();

    By Title = By.xpath("//h3[contains(text(),'Hi')]");

    public Boolean VerifyRegisteration() throws InterruptedException {
        Boolean Status = Action.IsDisplayedHonda(Title);
        return Status;
    }


}
