package test.script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtilities;

public class ManageContactTest extends Base {
	HomePage homepage;
	ManageContactPage managecontactpage;

	@Test
	public void VerifyIfUserIsAbleToUpdateContact() throws IOException {
		String loginusernamevalue = ExcelUtilities.getStringData(1, 0, "LoginPage");
		String loginpasswordvalue = ExcelUtilities.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(loginusernamevalue).enterPasswordOnPasswordField(loginpasswordvalue);
		homepage = loginpage.clickOnSigninButton();

		String phonenumber = ExcelUtilities.getIntegerData(1, 0, "ManageContactPage");
		String email = ExcelUtilities.getStringData(1, 1, "ManageContactPage");
		String address = ExcelUtilities.getStringData(1, 2, "ManageContactPage");
		String deliverytime = ExcelUtilities.getIntegerData(1, 3, "ManageContactPage");
		String deliverycharge = ExcelUtilities.getIntegerData(1, 4, "ManageContactPage");

		managecontactpage = homepage.clickOnContactMoreinfobutton();
		managecontactpage.clickOnUpdateicon().enterPhonenumber(phonenumber).enterEmail(email).enterAddress(address)
				.enterDeliveryTime(deliverytime).enterDeliveryCharge(deliverycharge).clickOnUpdatebutton();
		boolean alertdisplayed = managecontactpage.isAlertMessageDisplayed();
		Assert.assertTrue(alertdisplayed, Constants.ADMINUSER_MESSAGE);

	}

	@Test
	public void verifyIfUpdatebuttonIsPresentInManageContactPage() throws IOException {
		String loginusernamevalue = ExcelUtilities.getStringData(1, 0, "LoginPage");
		String loginpasswordvalue = ExcelUtilities.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(loginusernamevalue).enterPasswordOnPasswordField(loginpasswordvalue);
		homepage = loginpage.clickOnSigninButton();

		managecontactpage = homepage.clickOnContactMoreinfobutton();
		managecontactpage.clickOnUpdateicon();
		boolean updatebuttondisplayed = managecontactpage.isUpdateButtonDisplayed();
		Assert.assertTrue(updatebuttondisplayed, Constants.MANAGECONTACT_MESSAGE);
	}
}
