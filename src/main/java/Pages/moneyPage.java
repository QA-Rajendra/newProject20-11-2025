package Pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class moneyPage {

    WebDriver driver;
    WebDriverWait wait;

    public moneyPage(WebDriver ldriver) {
        this.driver = ldriver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    // ----------- LOCATORS ---------- //

    @FindBy(xpath ="(//span[contains(text(),'Send Money')])[3]")
    WebElement menu;

    

    @FindBy(xpath ="//input[@placeholder='Search for a country']")
    WebElement searchCountryField;

    @FindBy(xpath = "(//input[@class='form-check-input'])[2]")
      WebElement countryCheckbox1;


    @FindBy(xpath="//input[contains(@class,'fw-bolder')]")
    WebElement amount;

    @FindBy(xpath="//button[contains(text(),'Continue')]")WebElement continousbtn;


    // ----------- MAIN METHOD ---------- //

    public void fillmoney(){

        wait.until(ExpectedConditions.elementToBeClickable(menu)).click();
        

        wait.until(ExpectedConditions.visibilityOf(searchCountryField)).sendKeys("india");
        wait.until(ExpectedConditions.elementToBeClickable(countryCheckbox1)).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
            "arguments[0].value='1';" +
            "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));",
            amount
        );
        amount.click();
        amount.sendKeys(Keys.BACK_SPACE);
        amount.sendKeys("1");

         continousbtn.click();

    }
}
