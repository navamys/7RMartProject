package test.script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtilities;

public class ManageContactTest extends Base {
	@Test
	public void VerifyIfUserIsAbleToUpdateContact() throws IOException {
		String loginusernamevalue=ExcelUtilities.getStringData(1, 0,"LoginPage"); 
		String loginpasswordvalue=ExcelUtilities.getStringData(1, 1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(loginusernamevalue);
		loginpage.enterPasswordOnPasswordField(loginpasswordvalue);
		loginpage.clickOnSigninButton();
		
		String phonenumber=ExcelUtilities.getIntegerData(1, 0, "ManageContactPage");
		String email=ExcelUtilities.getStringData(1, 1, "ManageContactPage");
		String address=ExcelUtilities.getStringData(1, 2, "ManageContactPage");
		String deliverytime=ExcelUtilities.getIntegerData(1, 3, "ManageContactPage");
		String deliverycharge=ExcelUtilities.getIntegerData(1, 4, "ManageContactPage");
		ManageContactPage managecontactpage=new ManageContactPage(driver);
		managecontactpage.clickOnMoreinfobutton();
		managecontactpage.clickOnUpdateicon();
		managecontactpage.enterPhonenumber(phonenumber);
		managecontactpage.enterEmail(email);
		managecontactpage.enterAddress(address);
		managecontactpage.enterDeliveryTime(deliverytime);
		managecontactpage.enterDeliveryCharge(deliverycharge);
		managecontactpage.clickOnUpdatebutton();
		boolean alertdisplayed=managecontactpage.isAlertMessageDisplayed();
		Assert.assertTrue(alertdisplayed,"Alert not displayed");
		
		
	}
	@Test
	public void verifyIfUpdatebuttonIsPresentInManageContactPage() throws IOException {
		String loginusernamevalue=ExcelUtilities.getStringData(1, 0,"LoginPage"); 
		String loginpasswordvalue=ExcelUtilities.getStringData(1, 1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(loginusernamevalue);
		loginpage.enterPasswordOnPasswordField(loginpasswordvalue);
		loginpage.clickOnSigninButton();
		
		ManageContactPage managecontactpage=new ManageContactPage(driver);
		managecontactpage.clickOnMoreinfobutton();
		managecontactpage.clickOnUpdateicon();
		boolean updatebuttondisplayed=managecontactpage.isUpdateButtonDisplayed();
		Assert.assertTrue(updatebuttondisplayed,"Update Button not displayed");
	}
}
