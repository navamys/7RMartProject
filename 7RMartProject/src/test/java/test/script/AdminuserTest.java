package test.script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminuserPage;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class AdminuserTest extends Base{
	@Test
	public void verifyIfUserIsAbleToUpdateAllFields() throws IOException {
		/*String loginusernamevalue="admin"; String loginpasswordvalue="admin"; //Will no longer hard code anymore*/
		String usernamevalue=ExcelUtilities.getStringData(1, 0,"LoginPage"); 
		String passwordvalue=ExcelUtilities.getStringData(1, 1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSigninButton();

		
		/*String usernameupdatevalue="hellousername";String passwordupdatevalue="hellopassword";int usertypeindex=1; //Will no longer hard code anymore*/
		AdminuserPage adminuserpage=new AdminuserPage(driver);
		String usernameupdatevalue=ExcelUtilities.getStringData(1, 0, "AdminUserPage");
		String passwordupdatevalue=ExcelUtilities.getStringData(1, 1, "AdminUserPage");
		adminuserpage.clickOnMoreinfoButton();
		adminuserpage.clickOnUpdateIcon();
		adminuserpage.enterValueToBeUpdatedOnUsernameField(usernameupdatevalue);
		adminuserpage.enterValueToBeUpdatedOnPasswordField(passwordupdatevalue);
		adminuserpage.selectValueOnUsertypeField();
		adminuserpage.clickOnUpdateButton();
		boolean alertdisplayed=adminuserpage.isAlertMessageDisplayed();
		Assert.assertTrue(alertdisplayed,"Alert not displayed");
	}
}
