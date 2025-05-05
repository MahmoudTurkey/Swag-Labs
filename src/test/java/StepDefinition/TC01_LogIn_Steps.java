package StepDefinition;

import Locator.TC01_LogIn;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TC01_LogIn_Steps {
    WebDriver driver=Hooks.driver;
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    TC01_LogIn LogInPage=new TC01_LogIn();
    SoftAssert softAssert=new SoftAssert();

    @Given("Fill in the {string} and {string} in the Login with invalid credentials")
    public void fill_in_the_and_in_the_login_with_invalid_credentials(String username, String password) {
        wait.until(ExpectedConditions.visibilityOf(LogInPage.UserName()));
        LogInPage.UserName().sendKeys(username);
        LogInPage.Password().sendKeys(password);
    }
    @Given("Click on the Login button.")
    public void click_on_the_login_button() {
        wait.until(ExpectedConditions.elementToBeClickable(LogInPage.LogInButton()));
        LogInPage.LogInButton().click();
    }
    @Then("Verify each error message")
    public void verify_each_error_message() {
        wait.until(ExpectedConditions.visibilityOf(LogInPage.ErrorMessage()));
        String ActResult= LogInPage.ErrorMessage().getText();
        String ExpResult="Error";
        System.out.println(ActResult);
        softAssert.assertEquals(ActResult,ExpResult);

    }


}
