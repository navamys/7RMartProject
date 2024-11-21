package test.script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminuserPage;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class AdminuserTest extends Base{
	@Test
	public void updateAllFields() throws IOException {
		/*String loginusernamevalue="admin"; String loginpasswordvalue="admin"; //Will no longer hard code anymore*/
		String loginusernamevalue=ExcelUtilities.getStringData(1, 0,"LoginPage"); 
		String loginpasswordvalue=ExcelUtilities.getStringData(1, 1,"LoginPage");
		AdminuserPage adminuserpage=new AdminuserPage(driver); //can use loginpage by creating its object 
		adminuserpage.enterUsernameOnUsernameField(loginusernamevalue);
		adminuserpage.enterPasswordOnPasswordField(loginpasswordvalue);
		adminuserpage.clickOnSigninButton();

		
		/*String usernameupdatevalue="hellousername";String passwordupdatevalue="hellopassword";int usertypeindex=1; //Will no longer hard code anymore*/
		String usernameupdatevalue=ExcelUtilities.getStringData(1, 0, "AdminUserPage");
		String passwordupdatevalue=ExcelUtilities.getStringData(1, 1, "AdminUserPage");
		String usertypevalue=ExcelUtilities.getStringData(1, 2, "AdminUserPage");
		adminuserpage.clickOnMoreinfoButton();
		adminuserpage.clickOnUpdateIcon();
		adminuserpage.enterValueToBeUpdatedOnUsernameField(usernameupdatevalue);
		adminuserpage.enterValueToBeUpdatedOnPasswordField(passwordupdatevalue);
		adminuserpage.selectValueOnUsertypeField(usertypevalue);
		adminuserpage.clickOnUpdateButton();
		boolean alertdisplayed=adminuserpage.isAlertMessageDisplayed();
		Assert.assertTrue(alertdisplayed,"Alert not displayed");
	}
}
