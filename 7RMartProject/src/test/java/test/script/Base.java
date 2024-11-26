package test.script;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.WaitUtilities;

public class Base {
	public WebDriver driver;

	@BeforeMethod
	@Parameters("browser")
	public void initializeBrowser(String browser) throws Exception {
		//driver=new ChromeDriver();
		if(browser.equalsIgnoreCase("Chrome")) {
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Edge")) {
			driver=new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox")) {
			driver=new FirefoxDriver();
		}
		else{
			throw new Exception("Browser is incorrect");
		}
		
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
