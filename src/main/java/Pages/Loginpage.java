package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Loginpage {
    WebDriver driver;
    
    public Loginpage(WebDriver ldriver) {
        this.driver = ldriver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath ="//input[contains(@id,'email')]")
    WebElement username;
    
    @FindBy(xpath ="//input[contains(@type,'password')]")
    WebElement password;
    
    @FindBy(xpath ="//button[contains(text(),'Login')]")
    WebElement button;
    
    @FindBy(xpath = "//div[contains(text(),'Tester Lastname')]")
    private WebElement clientname;
    @FindBy(xpath = "//button[text()='Yes']")
    private WebElement yesbtn;
    
    @FindBy(xpath = "(//span[text()='Home'])[2]")private WebElement homebtnElement; 
    
  //  @FindBy(xpath = "(//a[normalize-space(span)='Profile'])[2]")private WebElement profilebtn; 
    
    @FindBy(xpath = "//button[text()=\"No, I'll verify later\"]")
    private WebElement verifyLaterButton;
    
    // Login method with explicit wait
    public void loginWithUserPassword(String userapplication, String passwordapplication) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        
        wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(userapplication);
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(passwordapplication);
        wait.until(ExpectedConditions.elementToBeClickable(button)).click();
        wait.until(ExpectedConditions.elementToBeClickable(yesbtn)).click();
     
    
    	wait.until(ExpectedConditions.elementToBeClickable(homebtnElement)).click();
    	//wait.until(ExpectedConditions.elementToBeClickable(profilebtn)).click();
    	   
	}
    public void handlePopups() {
     
        try {
            if (verifyLaterButton.isDisplayed()) {
            	verifyLaterButton.click();
            }
        } catch (Exception e) {
            // ignore if not displayed
        }
    }

  

    // Getter
    public WebElement getTesterLastname() {
        return clientname;
    }

    // Assertion method with wait
    public void verifyTesterLastname(String expectedName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(clientname)); // Wait until element is visible
        String actualName = clientname.getText();
        Assert.assertEquals(actualName, expectedName, "Tester Lastname text does not match!");
    }
}
