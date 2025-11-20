package utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;



public class Helpler {

  // Screenshot ,alerts,frames, windows issue, javaScrepit executors
	public static String captureScrenshot(WebDriver driver) {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String screenshotPath=System.getProperty("user.dir")+"/Screenshot/Calyx_"+getCurrentDateTime()+".png";
		
		try {
			
			
			FileHandler.copy(src, new File(screenshotPath));
			
			System.out.println("screenshot capture");
			
		} catch (Exception e) {
			System.out.println("unable to capture Screenshot"+e.getMessage());
		}
	  return screenshotPath;
	}
	
	public static String getCurrentDateTime() {
		
		DateFormat customDateFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date curreDate =new Date();
		
		return customDateFormat.format(curreDate);
		
	}

}
