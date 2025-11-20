package drivers;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

    public static WebDriver startapplication(WebDriver driver, String browsername, String appURL) {

        if (browsername.equalsIgnoreCase("Chrome")) {

            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
           
            options.addArguments("--incognito");       // Enable incognito mode

            driver = new ChromeDriver(options);

        } else if (browsername.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions fOptions = new FirefoxOptions();
            fOptions.addArguments("--width=1400", "--height=1000");

            driver = new FirefoxDriver(fOptions);

        } else if (browsername.equalsIgnoreCase("edge")) {

            System.out.println("🟦 Launching Microsoft Edge...");


            System.setProperty("webdriver.edge.driver",
                System.getProperty("user.dir") + "\\pathDriver\\msedgedriver.exe");

         

            EdgeOptions eOptions = new EdgeOptions();
            eOptions.addArguments("--start-maximized");
            eOptions.addArguments("--remote-allow-origins=*");

            driver = new EdgeDriver(eOptions);

        } else {
            System.out.println("❌ Browser not supported: " + browsername);
            return null;
        }

       
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get(appURL);

        return driver;
    }

    public static void quitBrowser(WebDriver driver) {
        driver.quit();
    }
}
