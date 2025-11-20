package Pages;

import java.awt.Desktop.Action;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Registration_SendmoneyPage {

    WebDriver driver;
    WebDriverWait wait;

    public Registration_SendmoneyPage(WebDriver ldriver) {
        this.driver = ldriver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    // ----------- LOCATORS ---------- //

    @FindBy(xpath ="(//span[contains(text(),'Recipient')])[2]")
    WebElement recipientMenu;

    @FindBy(xpath ="//a[normalize-space()='Add New Recipient']")
    WebElement addNewRecipientBtn;

    @FindBy(xpath ="//input[@placeholder='Search for a country']")
    WebElement searchCountryField;

    @FindBy(xpath = "//input[@class='form-check-input']")
    WebElement countryCheckbox;

    @FindBy(xpath = "//div[text()='Select Collection Type *']")
    WebElement collectionTypeDropdown;

    @FindBy(xpath = "(//div[contains(@class,'option')])[1]")
    WebElement firstDropdownOption;

    @FindBy(xpath = "//div[text()='Male']")
    WebElement genderMaleOption;

    @FindBy(xpath="//button[text()='Select Bank *']")
    WebElement selectBankBtn;

    @FindBy(xpath="//span[text()='AB Bank Ltd.']")
    WebElement bankAB;

    @FindBy(xpath="//input[@placeholder='Recipient Name ']")
    WebElement recipientName;

    @FindBy(xpath="//input[@placeholder='Enter  Account No.  *']")
    WebElement accountNo;

    @FindBy(xpath="//input[@placeholder='Enter Confirm  Account No.  ']")
    WebElement confirmAccountNo;

    @FindBy(xpath="//input[@placeholder='Enter Account Holder Name  *']")
    WebElement accountHolderName;

    @FindBy(xpath="//input[@placeholder='Enter  IFSC Code  ']")
    WebElement ifscCode;

    @FindBy(xpath="//input[@placeholder='Enter Branch *']")
    WebElement branchName;

    @FindBy(xpath="//input[@placeholder='Enter Branch Code *']")
    WebElement branchCode;


    // ----------- MAIN METHOD ---------- //

    public void fillRecipientRegistration() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(recipientMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addNewRecipientBtn)).click();

        wait.until(ExpectedConditions.visibilityOf(searchCountryField)).sendKeys("india");
        wait.until(ExpectedConditions.elementToBeClickable(countryCheckbox)).click();
   Thread.sleep(2000);
   collectionTypeDropdown.clear();
   
        wait.until(ExpectedConditions.visibilityOf(collectionTypeDropdown)).sendKeys("Bank Deposit");
        Actions actions = new Actions(driver);
        actions.moveToElement(collectionTypeDropdown)
               .click()
               .sendKeys(Keys.ENTER)
               .build()
               .perform();
        wait.until(ExpectedConditions.elementToBeClickable(firstDropdownOption)).click();
        
        wait.until(ExpectedConditions.elementToBeClickable(genderMaleOption)).click();

      //  wait.until(ExpectedConditions.elementToBeClickable(firstDropdownOption)).click();
        wait.until(ExpectedConditions.elementToBeClickable(bankAB)).click();

        recipientName.sendKeys("John Doe");
        accountNo.sendKeys("123456789012");
        confirmAccountNo.sendKeys("123456789012");
        accountHolderName.sendKeys("John Doe");
        ifscCode.sendKeys("ABCD0123456");
        branchName.sendKeys("Mumbai");
        branchCode.sendKeys("0045");
    }
}
