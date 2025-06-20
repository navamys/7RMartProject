package test.script;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constants;
import utilities.ScreenshotUtility;
import utilities.WaitUtilities;

public class Base {
	public WebDriver driver;
	public Properties properties;
	public FileInputStream fileinputstream;
	public ScreenshotUtility scrshot;

	@BeforeMethod(alwaysRun = true) // for grouping to run
	@Parameters("browser")
	public void initializeBrowser(String browser) throws Exception {
		try {
			properties = new Properties();
			fileinputstream = new FileInputStream(Constants.CONFIG_FILE);
			properties.load(fileinputstream);

		} catch (Exception e) {
			System.out.println("catch");
		}
		// driver=new ChromeDriver();
		if (browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else {
			throw new Exception("Browser is incorrect");
		}

		// driver.get("https://groceryapp.uniqassosiates.com/admin");
		driver.get(properties.getProperty("url"));
		// implicit wait after url loads
		// if given 10 sec, element loads in 2 sec, but it will wait till 10, so dont
		// use for bigger time period
		// common wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtilities.IMPLICIT_WAIT));
		driver.manage().window().maximize();
	}

	@AfterMethod(alwaysRun = true) // for grouping to run
	/*
	 * public void driverQuitAndClose() { //driver.close(); //driver.quit();
	 */
	public void browserQuit(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			scrshot = new ScreenshotUtility();
			scrshot.getScreenShot(driver, iTestResult.getName());
		}
		driver.quit();
	}

}
