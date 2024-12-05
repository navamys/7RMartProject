package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {
	public void getScreenShot(WebDriver driver, String failedTestCase) throws IOException { 
 		TakesScreenshot scrShot = (TakesScreenshot) driver; 
 		File screenShot = scrShot.getScreenshotAs(OutputType.FILE); 
 		//generate a time stamp for this screenshot
 		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date()); 
 		//create the output directly if it doesn't exists
 		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot"); 
 		if (!f1.exists()) { 
 			f1.mkdirs(); 
 		} 
 		//set the destination path for the screenshot
 		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp + ".png"; 
 		File finalDestination = new File(destination); 
 		FileHandler.copy(screenShot, finalDestination);
 		
 		//TakesScreenshot is an interface
 	}
}
