package StepDefinition;

import Locator.TC02_Products;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class TC02_Products_Steps {

    String name1;
    String name2;
    WebDriver driver=Hooks.driver;
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    TC02_Products Products=new TC02_Products();
    SoftAssert softAssert=new SoftAssert();

    @Given("Login with a valid {string} and {string}")
    public void login_with_a_valid_and(String username, String password) {
        wait.until(ExpectedConditions.visibilityOf(Products.UserName()));
        Products.UserName().sendKeys(username);
        Products.Password().sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(Products.LogInButton()));
        Products.LogInButton().click();
    }
    @Given("Verify that you’ve been logged in successfully and navigated to the products page")
    public void verify_that_you_ve_been_logged_in_successfully_and_navigated_to_the_products_page() {
        wait.until(ExpectedConditions.visibilityOf(Products.products_page()));
        String actualTitle = Products.products_page().getText();
        String expectedTitle = "Products";
        softAssert.assertEquals(actualTitle, expectedTitle, "User was not redirected to the products page.");
        System.out.println(actualTitle);
    }

    @Given("Add the most expensive two products to your cart")
    public void add_the_most_expensive_two_products_to_your_cart() {
        wait.until(ExpectedConditions.elementToBeClickable(Products.SortDropdown())).click();
        Products.selectPriceHighToLow();
        wait.until(ExpectedConditions.visibilityOf(Products.products_page()));
        name1=Products.name1().getText();
        name2=Products.name2().getText();
        Products.Add_P1().click();
        Products.Add_P2().click();

    }
    @Given("Click on the cart button")
    public void click_on_the_cart_button() {
        wait.until(ExpectedConditions.elementToBeClickable(Products.Cart_Button())).click();
    }
    @Given("Verify that you’ve been navigated to Cart page and the previously selected products are displayed at the page")
    public void verify_that_you_ve_been_navigated_to_cart_page_and_the_previously_selected_products_are_displayed_at_the_page() {
       wait.until(ExpectedConditions.visibilityOf(Products.Cart_Page()));
       String actualTitle = Products.Cart_Page().getText();
       String expectedTitle = "Your Cart";
       softAssert.assertEquals(actualTitle, expectedTitle, "User was not redirected to the products page.");
       wait.until(ExpectedConditions.visibilityOf(Products.P1()));
       String P1_cart=Products.P1().getText();
       String P2_cart=Products.P2().getText();
       softAssert.assertEquals(P1_cart,name1);
       softAssert.assertEquals(P2_cart,name2);
       softAssert.assertAll();
    }

    @Given("Click on the Checkout button")
    public void click_on_the_checkout_button() {
        wait.until(ExpectedConditions.elementToBeClickable(Products.checkoutButton())).click();
    }
    @Given("Verify that you’ve been navigated to the Checkout page")
    public void verify_that_you_ve_been_navigated_to_the_checkout_page() {
        wait.until(ExpectedConditions.visibilityOf(Products.checkoutPage()));
        String checkoutPage_name=Products.checkoutPage().getText();
        String expectedName="Checkout: Your Information";
        softAssert.assertEquals(checkoutPage_name,expectedName);
        softAssert.assertAll();
    }
    @Given("Fill \"<FirstName>\" and \"<LastName>\"and \"<PostalCode>\" in the displayed form")
    public void fill_all_the_displayed_form(io.cucumber.datatable.DataTable dataTable) {
        wait.until(ExpectedConditions.visibilityOf(Products.FirstName()));
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            Products.FirstName().sendKeys(row.get("FirstName"));
            Products.LastName().sendKeys(row.get("LastName"));
            Products.PostalCode().sendKeys(row.get("PostalCode"));
        }
    }
    @Given("Click on the “Continue” button")
    public void click_on_the_continue_button() {
        wait.until(ExpectedConditions.elementToBeClickable(Products.Continue())).click();
    }

    @Given("Verify that you’ve been navigated to the Overview page")
    public void verify_that_you_ve_been_navigated_to_the_overview_page() {
        wait.until(ExpectedConditions.visibilityOf(Products.OverviewPage()));
        String OverviewPageName=Products.OverviewPage().getText();
        String expectedName="Checkout: Overview";
        softAssert.assertEquals(OverviewPageName,expectedName);
        softAssert.assertAll();
    }
    @Given("Verify the Items total amount before taxes")
    public void verify_the_items_total_amount_before_taxes() {
        wait.until(ExpectedConditions.visibilityOf(Products.total_amount_before_taxes()));
        Products.total_amount_before_taxes().isDisplayed();
    }

    @Given("Verify that the URL matches with {string}")
    public void verify_that_the_url_matches_with(String expectedUrl) {
        wait.until(ExpectedConditions.visibilityOf(Products.OverviewPage()));
        expectedUrl = "https://www.saucedemo.com/checkout-step-two.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "User is not on the Checkout Step Two page!");
    }

    @Given("Click on the Finish button")
    public void click_on_the_finish_button() {
      wait.until(ExpectedConditions.elementToBeClickable(Products.finishButton())).click();
    }
    @Then("Verify both, the \\(Thank You) and the \\(order has been dispatched) messages")
    public void verify_both_the_thank_you_and_the_order_has_been_dispatched_messages() {
        wait.until(ExpectedConditions.visibilityOf(Products.Message1()));
        Products.Message1().isDisplayed();
        Products.Message2().isDisplayed();
    }
}
