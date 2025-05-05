✅ Framework Overview
Language: Java

Testing Framework: Cucumber + JUnit/TestNG

Automation Tool: Selenium WebDriver

Design Pattern: Page Object Model (POM)

Reporting: Allure Reports

Parallel Execution: TestNG or JUnit 5

Data-Driven Testing: CSV/Excel/JSON

Browser Support: Chrome, Firefox (from config)

Source Control: Git (GitHub repo)

📁 Project Structure

bash
Copy
Edit
src
├── main
│   └── java
│       └── pages/                # Page Object classes
│       └── utils/                # Utility classes (e.g., config reader)
├── test
│   └── java
│       └── stepDefinitions/      # Step definitions
│       └── runners/              # Test runners
│       └── features/             # Gherkin feature files
config/
│   └── config.properties         # URL, browser type
testdata/
│   └── loginTestData.csv         # 4 sets of credentials
README.md
pom.xml
🛠️ Implementation Highlights
1. Cucumber Integration
   Use @CucumberOptions in runner class to link to .feature files.

Example step definitions implement login, cart, and checkout flow.

2. Browser Support via Config
   config.properties:

properties
Copy
Edit
browser=chrome
url=https://www.saucedemo.com/
DriverFactory initializes WebDriver based on config.

3. Parallel Execution
   TestNG: use testng.xml with parallel="tests" and thread-count.

JUnit 5: use @Execution(CONCURRENT) and proper config.

4. Page Object Model (POM)
   Create classes like LoginPage.java, ProductPage.java, CartPage.java, CheckoutPage.java, each encapsulating page elements and methods.

5. Data-Driven Test
   Load CSV/Excel using Apache Commons CSV or Jackson (for JSON).

Cucumber ScenarioOutline + Examples or use @DataProvider with TestNG.

6. Allure Reporting
   Add Allure dependencies to pom.xml:

xml
Copy
Edit
<dependency>
<groupId>io.qameta.allure</groupId>
<artifactId>allure-cucumber7-jvm</artifactId>
<version>2.24.0</version>
</dependency>
Add Allure annotations to step definitions.

Generate report with:

bash
Copy
Edit
mvn clean test
mvn allure:serve
7. README.md
   Includes:

Setup instructions

How to run tests

How to generate reports

Browser config usage

Parallel execution guide

8. ## 🧪 How to Run the Tests

**Clone the repository**:
   ```bash
   git clone https://github.com/MahmoudTurkey/demoblaze-automation.git
   cd demoblaze-automation
Install dependencies:

bash
Copy
Edit
mvn clean install
Run tests:

bash
Copy
Edit
mvn test
Generate Allure report:

bash
Copy
Edit
mvn allure:report
mvn allure:serve

📹 Demo

You can find a demo video in the Demo Video folder.

📄 Reporting

All test executions are logged and visually reported using Allure Reports. After running the tests, open the report using:

bash
Copy
Edit
mvn allure:serve

✍️ Authors

MahmoudTurkey - Test Automation Engineer

Contact: mahmoudtorki79@gmail.com
