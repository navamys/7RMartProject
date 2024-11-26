package test.script;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.WaitUtilities;

public class Base {
	public WebDriver driver;

	@BeforeMethod
	public void initializeBrowser() {
		driver=new ChromeDriver();
		driver.get("https://groceryapp.uniqassosiates.com/admin");
		//implicit wait after url loads
		//if given 10 sec, element loads in 2 sec, but it will wait till 10, so dont use for bigger time period
		//common wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtilities.IMPLICIT_WAIT));
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void driverQuitAndClose() {
		//driver.close();
		//driver.quit();
	}
}
