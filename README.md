🧪 UI Automation Framework – SauceDemo
This repository contains a robust UI Test Automation Framework built in Java using Selenium WebDriver, Cucumber, and TestNG, designed to automate end-to-end test scenarios for SauceDemo.

📌 Features

✅ Java-based test framework

✅ Selenium WebDriver integration

✅ Cucumber BDD with Gherkin

✅ Cross-browser support (Chrome and Firefox)

✅ Configurable settings via config.properties (URL, browser)

✅ Data-driven testing with external file (CSV/Excel/JSON)

✅ Parallel test execution using TestNG

✅ Page Object Model (POM) design pattern

✅ Allure Reporting for test results

✅ GitHub integrated project with version control

✅ Demo video of test execution embedded in Allure report

🔍 Test Scenarios
Scenario 1 – Invalid Login
Visit SauceDemo

Attempt login using invalid credentials (4 data sets)

Verify appropriate error messages are displayed

Scenario 2 – End-to-End Valid Flow
Login with valid credentials:

Username: standard_user

Password: secret_sauce

Verify navigation to the Products page

Add the two most expensive products to the cart

Navigate to Cart and validate added items

Proceed to Checkout and fill form

Verify:

Navigation to Overview page

Total item amount (before taxes)

Correct final URL

Click Finish and verify:

"Thank You" message

Order dispatch message

⚙️ How to Run
Clone the repository

Set up Maven dependencies (mvn clean install)

Configure config.properties:

properties
Copy
Edit
browser=chrome
url=https://www.saucedemo.com
Run tests:

bash
Copy
Edit
mvn test
Generate Allure Report:

bash
Copy
Edit
allure serve target/allure-results
📊 Reporting
Allure Report is used for visual test reports

Embedded test execution demo video inside Allure report

📽️ Demo Video
🎥 Watch the test execution demo (replace with actual link)

📁 Project Structure
bash
Copy
Edit
src/
├── main/
│   └── java/
│       └── pages/           # Page Object classes
│       └── utils/           # Driver setup, config reader
├── test/
│   └── java/
│       └── stepdefinitions/ # Cucumber step defs
│       └── runners/         # Test runners
│       └── features/        # Gherkin feature files
