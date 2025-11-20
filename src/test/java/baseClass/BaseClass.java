package baseClass;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import drivers.BrowserFactory;
import utility.ConfigDataProvider;
import utility.ExcelDataProvider;
import utility.Helpler;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports reports;
	public ExtentTest logger;

	@BeforeSuite
	public void setUpSuite() {
		
		Reporter.log("Setting up Report and Test Started ", true);
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		ExtentSparkReporter spark = new ExtentSparkReporter(
		        System.getProperty("user.dir") + "/Reports/Calyx_" + Helpler.getCurrentDateTime() + ".html");

		reports = new ExtentReports();
		reports.attachReporter(spark);

		
		Reporter.log("Setting Done Test can be Started ", true);

	}

	@BeforeClass
	public void setUp() {
		Reporter.log("Tring to start ad gettting appliaction ready ", true);
		driver = BrowserFactory.startapplication(driver, config.getBrowser(), config.getStringURL());
		Reporter.log("Browser and application is up and running ", true);
	}


	@AfterMethod
	public void teardownMethod(ITestResult result) throws IOException {
		
		Reporter.log("Test is about to end", true);
		if (result.getStatus() == ITestResult.FAILURE) {

			logger.fail("test Failed ",
					MediaEntityBuilder.createScreenCaptureFromPath(Helpler.captureScrenshot(driver)).build());

		}

		else if (result.getStatus() == ITestResult.SUCCESS) {

			logger.pass("test pass ",
					MediaEntityBuilder.createScreenCaptureFromPath(Helpler.captureScrenshot(driver)).build());
		}

		else if (result.getStatus() == ITestResult.SKIP) {

			logger.skip("test skip ",
					MediaEntityBuilder.createScreenCaptureFromPath(Helpler.captureScrenshot(driver)).build());
		}
		reports.flush(); // reports flush
		Reporter.log("test completed >> Report Ganarated", true);
	}
	
	@AfterClass
	public void tearDown() {
	//	BrowserFactory.quitBrowser(driver);
	}


}
