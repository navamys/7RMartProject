package test.script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtilities;

public class LoginTest extends Base { //test class in src test (have TCs)
	@Test(retryAnalyzer=retry.Retry.class,groups= {"regression"},description="Verifying if the user is able to login using valid credentials")
	public void verifyTheUserIsAbleToLoginUsingValidCredentials() throws IOException {
		//String usernamevalue="admin";
		//String passwordvalue="admin";
		String usernamevalue=ExcelUtilities.getStringData(1, 0,"LoginPage"); 
		String passwordvalue=ExcelUtilities.getStringData(1, 1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSigninButton();
		boolean homepageloaded=loginpage.isHomePageDisplayed();
		Assert.assertTrue(homepageloaded,"Homepage is not loaded when user is entering valid credentials");
	}
	@Test(description="verifyTheUserIsAbleToLoginUsingValidUsernameAndIncorrectPassword")
	public void verifyTheUserIsAbleToLoginUsingValidUsernameAndIncorrectPassword() throws IOException {
		//String usernamevalue="admin";
		//String passwordvalue="dmin";
		String usernamevalue=ExcelUtilities.getStringData(2, 0, "LoginPage");
		String passwordvalue=ExcelUtilities.getStringData(2, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSigninButton();
		boolean assertdisplayed=loginpage.isAlertDisplayed();
		Assert.assertTrue(assertdisplayed,"Alert not displayed");	
	}
	@Test(groups= {"regression"})
	public void verifyTheUserIsAbleToLoginUsingIncorrectUsernameAndValidPassword() throws IOException {
		//String usernamevalue="dmin";
		//String passwordvalue="admin";
		String usernamevalue=ExcelUtilities.getStringData(3, 0, "LoginPage");
		String passwordvalue=ExcelUtilities.getStringData(3, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSigninButton();
		boolean assertdisplayed=loginpage.isAlertDisplayed();
		Assert.assertTrue(assertdisplayed,"Alert not displayed");	
	}
	@Test
	public void verifyTheUserIsAbleToLoginUsingIncorrectCredentials() throws IOException {
		//String usernamevalue="dmin";
		//String passwordvalue="dmin";
		String usernamevalue=ExcelUtilities.getStringData(4, 0, "LoginPage");
		String passwordvalue=ExcelUtilities.getStringData(4, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSigninButton();
		boolean assertdisplayed=loginpage.isAlertDisplayed();
		Assert.assertTrue(assertdisplayed,"Alert not displayed");	
	}	
}
