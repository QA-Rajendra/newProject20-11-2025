package Pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.RandomDataUtil;

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

    @FindBy(xpath = "//input[contains(@id,'react-select-') and @type='text']")
    WebElement collectionTypeDropdown;

    @FindBy(xpath = "(//div[contains(@class,'option')])[1]")
    WebElement firstDropdownOption;

    
    @FindBy(xpath = "//input[contains(@placeholder,'Your mobile number')]") WebElement mobile;
    
    @FindBy(xpath="//input[@placeholder='Recipient Name ']")
    WebElement recipientName;
    @FindBy(xpath = "//input[@id='react-select-3-input' and @role='combobox']")WebElement clickGender;
    @FindBy(xpath = "//div[@role='option' and contains(text(),'Male')]")
    WebElement genderMaleOption;

    @FindBy(xpath="//button[normalize-space(text())='Select Bank *']")
    WebElement selectBankBtn;

    @FindBy(xpath="//span[text()='AB Bank Ltd.']")
    WebElement bankAB;

  

    @FindBy(xpath="//input[contains(@placeholder,'Enter') and contains(@placeholder,'Account No')]")
    WebElement accountNo;

    @FindBy(xpath="//input[contains(@placeholder,'Confirm') and contains(@placeholder,'Account No')]")
    WebElement confirmAccountNo;

    @FindBy(xpath="//input[@placeholder='Enter Account Holder Name  *']")
    WebElement accountHolderName;

    @FindBy(xpath="//input[@placeholder='Enter  IFSC Code  ']")
    WebElement ifscCode;

    @FindBy(xpath="//input[@placeholder='Enter Branch *']")
    WebElement branchName;

    @FindBy(xpath="//input[@placeholder='Enter Branch Code *']")
    WebElement branchCode;
    
    @FindBy(xpath ="//button[@type='button' and normalize-space()='Submit']")WebElement submitbtn;


    // ----------- MAIN METHOD ---------- //

    public void fillRecipientRegistration() throws InterruptedException {
    	
    	   // 🔹 Random Data Variables
    	String randomfirstName=RandomDataUtil.getRandomFirstName();
        String randomFullName = RandomDataUtil.getRandomFullName();
        String randomMobile   = RandomDataUtil.getRandomMobile();
        String randomAccNo    = RandomDataUtil.getRandomAccountNumber();
        String randomIFSC     = RandomDataUtil.getRandomIFSC();
        String randomBranch   = RandomDataUtil.getRandomCity();
        

        System.out.println("------ RANDOM TEST DATA -------");
        System.out.println("Full Name: " + randomFullName);
        System.out.println("Mobile: " + randomMobile);
        System.out.println("Account No: " + randomAccNo);
        System.out.println("IFSC: " + randomIFSC);
        
        System.out.println("Branch Code: " + randomBranch);
        System.out.println("--------------------------------");

        wait.until(ExpectedConditions.elementToBeClickable(recipientMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addNewRecipientBtn)).click();

        wait.until(ExpectedConditions.visibilityOf(searchCountryField)).sendKeys("india");
        wait.until(ExpectedConditions.elementToBeClickable(countryCheckbox)).click();
   Thread.sleep(2000);
  
   
        wait.until(ExpectedConditions.visibilityOf(collectionTypeDropdown)).sendKeys("Bank Deposit");
        Actions actions = new Actions(driver);
        actions.moveToElement(collectionTypeDropdown)
               .click()
               .sendKeys(Keys.ENTER)
               .build()
               .perform();
      //  wait.until(ExpectedConditions.elementToBeClickable(firstDropdownOption)).click();
        
        wait.until(ExpectedConditions.visibilityOf(mobile)).sendKeys(randomMobile);
        recipientName.sendKeys(randomfirstName);
        
        clickGender.click();
        wait.until(ExpectedConditions.elementToBeClickable(genderMaleOption)).click();

        wait.until(ExpectedConditions.elementToBeClickable(selectBankBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(bankAB)).click();

      Thread.sleep(2000);
        accountNo.sendKeys(randomAccNo);
        confirmAccountNo.sendKeys(randomAccNo);
        accountHolderName.sendKeys(randomFullName);
        ifscCode.sendKeys(randomIFSC);
        branchName.sendKeys(randomBranch);
        branchCode.sendKeys("1234");
        Actions act = new Actions(driver);
        act.moveToElement(submitbtn).click().perform();

        

    }
}
