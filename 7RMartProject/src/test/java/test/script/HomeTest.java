package test.script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminuserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class HomeTest extends Base{
	@Test
	public void verifyIfUserIsAbleToLogout() throws IOException {
		String usernamevalue=ExcelUtilities.getStringData(1, 0,"LoginPage"); 
		String passwordvalue=ExcelUtilities.getStringData(1, 1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSigninButton();
		
		HomePage homepage=new HomePage(driver);
		homepage.clickOnAdminimagebutton();
		homepage.clickOnLogoutbutton();
		boolean signinbuttondisplayed=homepage.isSigninButtonDisplayed();
		Assert.assertTrue(signinbuttondisplayed,"signin button is not displayed as logout is not successful");

	}
}
