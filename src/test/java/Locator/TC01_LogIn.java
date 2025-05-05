package Locator;

import StepDefinition.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC01_LogIn {
    WebDriver driver= Hooks.driver;

    public WebElement UserName(){return driver.findElement(By.id("user-name"));}
    public WebElement Password(){return driver.findElement(By.id("password"));}
    public WebElement LogInButton(){return driver.findElement(By.id("login-button"));}
    public WebElement ErrorMessage(){return driver.findElement(By.xpath("//*[@data-test=\"error\"]\n"));}
}
