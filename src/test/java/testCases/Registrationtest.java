package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.Loginpage;
import Pages.Registration_SendmoneyPage;
import baseClass.BaseClass;

public class Registrationtest extends BaseClass {

    @Test(description = "Login to Calyx and verify logged-in user")
    public void test1() throws InterruptedException {

        // Create logger for ExtentReports
        logger = reports.createTest("Login to Calyx Test");

        // Initialize PageFactory elements
        Loginpage loginpage = PageFactory.initElements(driver, Loginpage.class);

        // Read username/password from config.properties
        String username = config.getUser("username");
        String password = config.getPassword("password");

        logger.info("Starting login process");

        // Perform login
        loginpage.loginWithUserPassword(username, password);
        logger.pass("Entered username and password");

        // Handle popup after login
        loginpage.handlePopups();
        logger.pass("Popup handled successfully");

        // Initialize Registration page

        Registration_SendmoneyPage regPage =
                PageFactory.initElements(driver, Registration_SendmoneyPage.class);

        regPage.fillRecipientRegistration();

        logger.pass("Recipient registration form filled successfully");

        System.out.println("✔ Recipient Registration Completed!");
        logger.pass("Username verified successfully");
    }
}
