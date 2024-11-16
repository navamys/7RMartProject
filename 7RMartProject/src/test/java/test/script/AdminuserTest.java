package test.script;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminuserPage;

public class AdminuserTest extends Base{
	@Test
	public void updateAllFields() {
		String loginusernamevalue="admin";
		String loginpasswordvalue="admin";
		AdminuserPage adminuserpage=new AdminuserPage(driver);
		adminuserpage.enterUsernameOnUsernameField(loginusernamevalue);
		adminuserpage.enterPasswordOnPasswordField(loginpasswordvalue);
		adminuserpage.clickOnSigninButton();

		String usernameupdatevalue="hellousername";
		String passwordupdatevalue="hellopassword";
		int usertypeindex=1;
		adminuserpage.clickOnMoreinfoButton();
		adminuserpage.clickOnUpdateIcon();
		adminuserpage.enterValueToBeUpdatedOnUsernameField(usernameupdatevalue);
		adminuserpage.enterValueToBeUpdatedOnPasswordField(passwordupdatevalue);
		adminuserpage.selectValueOnUsertypeField(usertypeindex);
		adminuserpage.clickOnUpdateButton();
		boolean alertdisplayed=adminuserpage.isAlertMessageDisplayed();
		Assert.assertTrue(alertdisplayed,"Alert not displayed");
	}
}
