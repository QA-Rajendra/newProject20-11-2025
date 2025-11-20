package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Pages.Loginpage;
import baseClass.BaseClass;




public class VerifyLoginPage extends BaseClass {

	@Test(priority = 1)
	public void loginApp() {
		Reporter.log("system login", true);
		logger = reports.createTest("login to CRM");

		Loginpage loginpage = PageFactory.initElements(driver, Loginpage.class);

		logger.info("starting application");

		loginpage.loginWithUserPassword(excel.getStringData("sheet1", 0, 0), excel.getStringData("Sheet1", 0, 1));

		logger.pass("login sucesss");

	}
	


}
