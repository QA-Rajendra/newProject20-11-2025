Create Maven Project

In IDE (like IntelliJ/Eclipse) → New → Maven Project.

Choose GroupId (e.g., com.example) and ArtifactId (e.g., SeleniumTest).

| **Dependency**           | **GroupId / ArtifactId**                            | **Version** | **Purpose / Usage**                                                |
| ------------------------ | --------------------------------------------------- | ----------- | ------------------------------------------------------------------ |
| Selenium Java            | `org.seleniumhq.selenium:selenium-java`             | 4.35.0      | Core library for browser automation with WebDriver.                |
| WebDriverManager         | `io.github.bonigarcia:webdrivermanager`             | 5.7.0       | Automatically manages browser drivers (Chrome, Firefox, etc.).     |
| TestNG                   | `org.testng:testng`                                 | 7.11.0      | Testing framework for writing, running, and organizing test cases. |
| ExtentReports            | `com.aventstack:extentreports`                      | 5.1.2       | Generates rich HTML test reports with logs and screenshots.        |
| Allure TestNG            | `io.qameta.allure:allure-testng`                    | 2.26.0      | Generates interactive Allure reports for TestNG tests.             |
| AssertJ                  | `org.assertj:assertj-core`                          | 3.25.1      | Fluent and readable assertions for testing.                        |
| Log4j Core & API         | `org.apache.logging.log4j:log4j-core` / `log4j-api` | 2.22.1      | Logging framework for info, debug, warning, error logs.            |
| Apache POI               | `org.apache.poi:poi`                                | 5.2.4       | Read/write Excel `.xls` files.                                     |
| Apache POI OOXML         | `org.apache.poi:poi-ooxml`                          | 5.2.4       | Read/write Excel `.xlsx` files.                                    |
| Apache POI OOXML Schemas | `org.apache.poi:poi-ooxml-schemas`                  | 4.1.2       | Schema support for `.xlsx` Excel files.                            |
| SLF4J Simple             | `org.slf4j:slf4j-simple`                            | 2.0.7       | Simple logging façade compatible with Log4j.                       |



# CalyxFramework

A **Selenium WebDriver framework** using **Java**, **TestNG**, **Page Object Model (POM)**, and **ExtentReports** with **Excel & Config data support**.

---

## Project Structure


calyxframework
│
├── pom.xml

├── Reports/ # ExtentReports HTML reports

├── src/main/java

│ ├── baseClass

│ │ └── BaseClass.java # Driver setup, TestNG setup, reporting

│ ├── drivers

│ │ └── BrowserFactory.java # Browser initialization and quit

│ ├── pages

│ │ └── Loginpage.java # Page Object Model for Login page
│ └── utility

│ ├── ConfigDataProvider.java # Config properties

│ ├── ExcelDataProvider.java # Excel data reading

│ └── Helpler.java # Screenshots, date-time utils

│
└── src/test/java

└── testCases

└── LoginTestWithProperties.java
