package PHPTravels;

import FileReader.ExcelReader;
import FileReader.PropertiesFileReader;
import FileReader.jsonfile;
import Pages.PHPTravels;
import Pages.PHPTravelsLogInPage;
import Pages.PHPTravelsProfilePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class PHPTravelsStepDef {

    PHPTravels PHP = new PHPTravels();
    PHPTravelsLogInPage PHPSignIn = new PHPTravelsLogInPage();
    PHPTravelsProfilePage PHPProfile = new PHPTravelsProfilePage();

    String input[] = {"Password", "Email","2ndEmail","3rdEmail","4thEmail"};
    String[] data = PropertiesFileReader.propertiesFileReader(input);
    String[][] excelData =  ExcelReader.XslxReader();  // excelData[0][0]  excelData[0][1]
    String Jsondata[][]= jsonfile.json_reader(2,3);//two objects , 3 attributes



    @Given("User Types {string} in First Name Section")
    public void user_Types_in_First_Name_Section(String FirstName) {
        PHP.SendFirstName(FirstName);
    }

    @When("User Types {string} in Last Name Section")
    public void user_Types_in_Last_Name_Section(String LastName) {
        PHP.SendLastName(LastName);
    }

    @When("User Types Gmail in Email Section")
    public void user_Types_Gmail_in_Email_Section() {
        //using properties file , data[1]
        PHP.SendEmail(data[1]);
    }

    @When("User Types another Gmail in Email Section")
    public void user_Types_another_Gmail_in_Email_Section() {
        //using properties file , data[1]
        PHP.SendEmail(data[2]);
    }

    @When("User Types Password")
    public void user_Types_Password() {
        //using Properties file, data[0]
        PHP.SendPassword(data[0]);
    }

    @When("User Types Confirmation Password")
    public void user_Types_Confirmation_Password() {
        //using Excel File
        PHP.SendConfirmPassword(excelData[0][3]);
    }

    @When("User Types Different Confirmation Password")
    public void user_Types_Different_Confirmation_Password() {
        //using Properties file, data[0]
        PHP.SendConfirmPassword(data[1]);
    }

    @When("User Types Phone Number")
    public void user_Types_Phone_Number() {
        PHP.SendMobileNumber(Jsondata[0][1]);
    }

    @When("User Clicks Submit")
    public void user_Clicks_Submit() {
        PHP.PressSignUpButton();
    }

    @Then("User Gets Confirmation Email")
    public void user_Gets_Confirmation_Email() throws InterruptedException {
        Assert.assertFalse(PHPProfile.VerifyRegisteration());//Has to be false to verify that it didnt redirect to profile page
    }

    @When("User Signs Out")
    public void user_Signs_Out() {
    }

    @Given("User Opens the Sign in Page")
    public void user_Opens_the_Sign_in_Page() {
        PHPSignIn.GoToSignInPage();
    }

    @When("User Signs in with Valid Credentials")
    public void user_Signs_in_with_Valid_Credentials() {
        PHPSignIn.SendEmail(data[1]);
        PHPSignIn.SendPassword(data[0]);
    }

    @When("User Clicks Login")
    public void user_Clicks_Login() {
        PHPSignIn.PressSignInButton();
    }

    @Then("User profile opens successfully")
    public void user_profile_opens_successfully() throws InterruptedException {
        Assert.assertTrue(PHPProfile.VerifyRegisteration());
    }

    @When("User Signs in with InValid Credentials {string} And {string}")
    public void user_Signs_in_with_InValid_Credentials_And(String email, String password) {
        PHPSignIn.SendEmail(email);
        PHPSignIn.SendPassword(password);
    }

    @Then("User profile doesn't open")
    public void user_profile_doesnt_open() throws InterruptedException {
        Assert.assertFalse(PHPProfile.VerifyRegisteration());
    }

    @Then("User Gets an Error Message")
    public void user_Gets_an_Error_Message() throws InterruptedException {
        Assert.assertTrue(PHPSignIn.CheckErrorMessage());   }

    @Then("User Gets an Error Message For Typing different Passwords")
    public void user_Gets_an_Error_Message_For_Typing_Different_Passwords() throws InterruptedException {
        Assert.assertTrue(PHP.VerifyPasswordErrorMessage());   }

    @Then("User Gets an Error Message For Typing Small Letters")
    public void user_Gets_an_Error_Message_For_Typing_Small_Letters() throws InterruptedException {
        Assert.assertFalse(PHPProfile.VerifyRegisteration());   }

    @Then("User Doesn't Get an Error Message for Not Having PhoneNumber")
    public void user_Doesnt_Get_an_Error_Message_for_Not_Having_PhoneNumber() throws InterruptedException {
        Assert.assertTrue(PHPProfile.VerifyRegisteration());}

}