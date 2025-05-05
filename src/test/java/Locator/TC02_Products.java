package Locator;

import StepDefinition.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TC02_Products {

    WebDriver driver= Hooks.driver;

    public WebElement UserName(){return driver.findElement(By.id("user-name"));}
    public WebElement Password(){return driver.findElement(By.id("password"));}
    public WebElement LogInButton(){return driver.findElement(By.id("login-button"));}
    public WebElement products_page(){return driver.findElement(By.xpath("//*[@data-test=\"title\"]"));}
    public WebElement SortDropdown() {return driver.findElement(By.className("product_sort_container"));}
    public void selectPriceHighToLow() {
        Select select = new Select(SortDropdown());
        select.selectByValue("hilo"); // or selectByVisibleText("Price (high to low)")
    }
    public WebElement name1(){return driver.findElement(By.xpath("//*[@data-test=\"item-5-title-link\"]"));}
    public WebElement name2(){return driver.findElement(By.xpath("//*[@data-test=\"item-4-title-link\"]"));}
    public WebElement Add_P1(){return driver.findElement(By.xpath("//*[@data-test=\"add-to-cart-sauce-labs-fleece-jacket\"]"));}
    public WebElement Add_P2(){return driver.findElement(By.xpath("//*[@data-test=\"add-to-cart-sauce-labs-backpack\"]"));}
    public WebElement Cart_Button(){return driver.findElement(By.xpath("//*[@data-test=\"shopping-cart-link\"]"));}
    public WebElement Cart_Page(){return driver.findElement(By.xpath("//*[@data-test=\"title\"]"));}
    public WebElement P1(){return driver.findElement(By.xpath("//*[@data-test=\"item-5-title-link\"]"));}
    public WebElement P2(){return driver.findElement(By.xpath("//*[@data-test=\"item-4-title-link\"]"));}
    public WebElement checkoutButton(){return driver.findElement(By.xpath("//*[@data-test=\"checkout\"]"));}
    public WebElement checkoutPage(){return driver.findElement(By.xpath("//*[@data-test=\"secondary-header\"]"));}
    public WebElement FirstName(){return driver.findElement(By.xpath("//*[@data-test=\"firstName\"]"));}
    public WebElement LastName(){return driver.findElement(By.xpath("//*[@data-test=\"lastName\"]"));}
    public WebElement PostalCode(){return driver.findElement(By.xpath("//*[@data-test=\"postalCode\"]"));}
    public WebElement Continue(){return driver.findElement(By.xpath("//*[@data-test=\"continue\"]"));}
    public WebElement OverviewPage(){return driver.findElement(By.xpath("//span[text()='Checkout: Overview']"));}
    public WebElement total_amount_before_taxes(){return driver.findElement(By.xpath("//*[@data-test=\"subtotal-label\"]"));}
    public WebElement finishButton(){return driver.findElement(By.xpath("//*[@data-test=\"finish\"]"));}
    public WebElement Message1(){return driver.findElement(By.xpath("//*[@data-test=\"complete-header\"]"));}
    public WebElement Message2(){return driver.findElement(By.xpath("//*[@data-test=\"complete-text\"]"));}


}
