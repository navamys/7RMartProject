package test.script;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtilities;

public class ManageContactTest extends Base {
	@Test
	public void updateContact() throws IOException {
		String loginusernamevalue=ExcelUtilities.getStringData(1, 0,"LoginPage"); 
		String loginpasswordvalue=ExcelUtilities.getStringData(1, 1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(loginusernamevalue);
		loginpage.enterPasswordOnPasswordField(loginpasswordvalue);
		loginpage.clickOnSigninButton();
	}
	@Test
	public void checkPresenceOfUpdatebuttonInManageContact() throws IOException {
		String loginusernamevalue=ExcelUtilities.getStringData(1, 0,"LoginPage"); 
		String loginpasswordvalue=ExcelUtilities.getStringData(1, 1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(loginusernamevalue);
		loginpage.enterPasswordOnPasswordField(loginpasswordvalue);
		loginpage.clickOnSigninButton();
	}
}
