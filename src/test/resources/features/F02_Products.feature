Feature: Add Products Successfully
  Scenario: Login with a valid username and password
    Given Login with a valid "standard_user" and "secret_sauce"
    And Verify that you’ve been logged in successfully and navigated to the products page

    # Add the most expensive two products
      Given Add the most expensive two products to your cart
      And Click on the cart button
      And Verify that you’ve been navigated to Cart page and the previously selected products are displayed at the page

    # Fill all the displayed form
     Given Click on the Checkout button
     And Verify that you’ve been navigated to the Checkout page
     And Fill "<FirstName>" and "<LastName>"and "<PostalCode>" in the displayed form
       | FirstName | LastName | PostalCode  |
       | Mahmoud   | Turkey   | 21500 |
     And Click on the “Continue” button

    Given Verify that you’ve been navigated to the Overview page
    And Verify the Items total amount before taxes
    And Verify that the URL matches with "https://www.saucedemo.com/checkout-step-two.html"
    And Click on the Finish button
    Then Verify both, the (Thank You) and the (order has been dispatched) messages

