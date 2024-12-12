package test.script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContactPage;
import pages.ManageFooterPage;
import utilities.ExcelUtilities;

public class ManageFooterTest extends Base {
	HomePage homepage;
	ManageFooterPage managefooterpage;

	@Test
	public void verifyIfUserIsAbleToUpdateFooter() throws IOException {
		String loginusernamevalue = ExcelUtilities.getStringData(1, 0, "LoginPage");
		String loginpasswordvalue = ExcelUtilities.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(loginusernamevalue).enterPasswordOnPasswordField(loginpasswordvalue);
		homepage = loginpage.clickOnSigninButton();

		String address = ExcelUtilities.getStringData(1, 0, "ManageFooterPage");
		String email = ExcelUtilities.getStringData(1, 1, "ManageFooterPage");
		String phone = ExcelUtilities.getIntegerData(1, 2, "ManageFooterPage");
		managefooterpage = homepage.clickOnFooterMoreinfobutton();
		managefooterpage.clickOnUpdateicon().enterAddress(address).enterEmail(email).enterPhonenumber(phone)
				.clickOnUpdatebutton();
		boolean alertdisplayed = managefooterpage.isAlertMessageDisplayed();
		Assert.assertTrue(alertdisplayed, Constants.ADMINUSER_MESSAGE);
	}

	@Test
	public void verifyIfUpdatebuttonIsPresentInManageFooterPage() throws IOException {
		String loginusernamevalue = ExcelUtilities.getStringData(1, 0, "LoginPage");
		String loginpasswordvalue = ExcelUtilities.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(loginusernamevalue).enterPasswordOnPasswordField(loginpasswordvalue);
		homepage = loginpage.clickOnSigninButton();

		managefooterpage = homepage.clickOnFooterMoreinfobutton();
		managefooterpage.clickOnUpdateicon();
		boolean updatebuttondisplayed = managefooterpage.isUpdateButtonDisplayed();
		Assert.assertTrue(updatebuttondisplayed, Constants.ADMINUSER_MESSAGE);
	}
}
