package test.script;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends Base { //test class in src test (have TCs)
	@Test
	public void verifyTheUserIsAbleToLoginUsingValidCredentials() {
		String usernamevalue="admin";
		String passwordvalue="admin";
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSigninButton();
		boolean homepageloaded=loginpage.isHomePageDisplayed();
		Assert.assertTrue(homepageloaded,"Homepage is not loaded when user is entering valid credentials");
	}
	@Test
	public void verifyTheUserIsAbleToLoginUsingValidUsernameAndIncorrectPassword() {
		String usernamevalue="admin";
		String passwordvalue="dmin";
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSigninButton();
		boolean assertdisplayed=loginpage.isAlertDisplayed();
		Assert.assertTrue(assertdisplayed,"Alert not displayed");	
	}
	@Test
	public void verifyTheUserIsAbleToLoginUsingIncorrectUsernameAndValidPassword() {
		String usernamevalue="dmin";
		String passwordvalue="admin";
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSigninButton();
		boolean assertdisplayed=loginpage.isAlertDisplayed();
		Assert.assertTrue(assertdisplayed,"Alert not displayed");	
	}
	@Test
	public void verifyTheUserIsAbleToLoginUsingIncorrectCredentials() {
		String usernamevalue="dmin";
		String passwordvalue="dmin";
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSigninButton();
		boolean assertdisplayed=loginpage.isAlertDisplayed();
		Assert.assertTrue(assertdisplayed,"Alert not displayed");	
	}	
}
