package test.script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminuserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class AdminuserTest extends Base {
	HomePage homepage;
	AdminuserPage adminuserpage;

	@Test
	public void verifyIfUserIsAbleToUpdateAllFields() throws IOException {
		/*
		 * String loginusernamevalue="admin"; String loginpasswordvalue="admin"; //Will
		 * no longer hard code anymore
		 */
		String usernamevalue = ExcelUtilities.getStringData(1, 0, "LoginPage");
		String passwordvalue = ExcelUtilities.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		// IMP: passing driver only once
		loginpage.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		// methods are called in a single line with a single object
		// loginpage.enterPasswordOnPasswordField(passwordvalue);
		// loginpage.clickOnSigninButton();
		homepage = loginpage.clickOnSigninButton();

		/*
		 * String usernameupdatevalue="hellousername";String
		 * passwordupdatevalue="hellopassword";int usertypeindex=1; //Will no longer
		 * hard code anymore
		 */
		// AdminuserPage adminuserpage=new AdminuserPage(driver);
		String usernameupdatevalue = ExcelUtilities.getStringData(1, 0, "AdminUserPage");
		String passwordupdatevalue = ExcelUtilities.getStringData(1, 1, "AdminUserPage");
		// adminuserpage.clickOnAdminMoreinfoButton();
		adminuserpage = homepage.clickOnAdminMoreinfoButton();
		// now moved to admin page when clicked on moreinfo button
		adminuserpage.clickOnUpdateIcon().enterValueToBeUpdatedOnUsernameField(usernameupdatevalue)
				.enterValueToBeUpdatedOnPasswordField(passwordupdatevalue).selectValueOnUsertypeField()
				.clickOnUpdateButton();
		/*
		 * adminuserpage.enterValueToBeUpdatedOnUsernameField(usernameupdatevalue);
		 * adminuserpage.enterValueToBeUpdatedOnPasswordField(passwordupdatevalue);
		 * adminuserpage.selectValueOnUsertypeField();
		 * adminuserpage.clickOnUpdateButton();
		 */ // wrote in single line aabove
		boolean alertdisplayed = adminuserpage.isAlertMessageDisplayed();
		Assert.assertTrue(alertdisplayed, Constants.ADMINUSER_MESSAGE);
	}
}
