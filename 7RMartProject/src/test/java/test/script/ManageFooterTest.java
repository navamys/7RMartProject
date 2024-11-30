package test.script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageContactPage;
import pages.ManageFooterPage;
import utilities.ExcelUtilities;

public class ManageFooterTest extends Base{
	@Test
	public void updateFooter() throws IOException {
		String loginusernamevalue=ExcelUtilities.getStringData(1, 0,"LoginPage"); 
		String loginpasswordvalue=ExcelUtilities.getStringData(1, 1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(loginusernamevalue);
		loginpage.enterPasswordOnPasswordField(loginpasswordvalue);
		loginpage.clickOnSigninButton();
		
		String address=ExcelUtilities.getStringData(1, 0,"ManageFooterPage");
		String email=ExcelUtilities.getStringData(1, 1,"ManageFooterPage");
		String phone=ExcelUtilities.getIntegerData(1, 2,"ManageFooterPage");
		ManageFooterPage managefooterpage=new ManageFooterPage(driver);
		managefooterpage.clickOnMoreinfobutton();
		managefooterpage.clickOnUpdateicon();
		managefooterpage.enterAddress(address);
		managefooterpage.enterEmail(email);
		managefooterpage.enterPhonenumber(phone);
		managefooterpage.clickOnUpdatebutton();
		boolean alertdisplayed=managefooterpage.isAlertMessageDisplayed();
		Assert.assertTrue(alertdisplayed,"Alert not displayed");
	}
	@Test
	public void checkPresenceOfUpdatebuttonInManageFooter() throws IOException {
		String loginusernamevalue=ExcelUtilities.getStringData(1, 0,"LoginPage"); 
		String loginpasswordvalue=ExcelUtilities.getStringData(1, 1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(loginusernamevalue);
		loginpage.enterPasswordOnPasswordField(loginpasswordvalue);
		loginpage.clickOnSigninButton();
		
		ManageFooterPage managefooterpage=new ManageFooterPage(driver);
		managefooterpage.clickOnMoreinfobutton();
		managefooterpage.clickOnUpdateicon();
		boolean updatebuttondisplayed=managefooterpage.isUpdateButtonDisplayed();
		Assert.assertTrue(updatebuttondisplayed,"Update Button not displayed");
	}
}
