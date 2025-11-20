package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.Loginpage;
import Pages.Registration_SendmoneyPage;
import Pages.moneyPage;
import baseClass.BaseClass;

public class verifymoneypage extends BaseClass {

    @Test(description = "Login to calyx and verify logged-in user")
    public void loginTest() throws InterruptedException {
        // Create logger for ExtentReports
        logger = reports.createTest("Login to calyx Test");

        // Initialize PageFactory elements
        Loginpage loginpage = PageFactory.initElements(driver, Loginpage.class);

        // Read username/password from ConfigDataProvider
        String username = config.getUser("username");
        String password = config.getPassword("password");

        logger.info("Starting login");

        // Perform login
        loginpage.loginWithUserPassword(username, password);
     
        loginpage.handlePopups();

        String title = driver.getTitle();
        System.out.println("Page Title: " + title);

        Assert.assertTrue(
                title.toLowerCase().contains("dashboard"),
                "Dashboard title verification failed! Actual title is: " + title
        );

        logger.pass("Dashboard title verified successfully");


        // ====== ASSERTION 2 — VERIFY USERNAME ======
        loginpage.verifyTesterLastname("Tester Lastname");
        logger.pass("Logged-in user verified successfully");

        System.out.println("✔ Login Verified Successfully!");
        
        moneyPage regPage =
                PageFactory.initElements(driver, moneyPage.class);

        regPage.fillmoney();
    }
}
