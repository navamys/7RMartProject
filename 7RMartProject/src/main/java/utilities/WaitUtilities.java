package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilities {
	public static final int ImplicitWait=10;  //applicable to all web elements 
	
	public static final long EXPLICIT_WAIT = 10;
	
	public void waitForElementToBeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
