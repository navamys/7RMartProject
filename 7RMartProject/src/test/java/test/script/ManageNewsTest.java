package test.script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtilities;

public class ManageNewsTest extends Base{
	@Test
	public void createNews() throws IOException {
		String usernamevalue=ExcelUtilities.getStringData(1, 0,"LoginPage"); 
		String passwordvalue=ExcelUtilities.getStringData(1, 1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSigninButton();
		
		
		
		ManageNewsPage managenewspage=new ManageNewsPage(driver);
		String news=ExcelUtilities.getStringData(1, 0,"ManagenewsPage");
		managenewspage.clickOnMoreinfoButton();
		managenewspage.clickOnNewButton();
		managenewspage.enterNewsOnNewsField(news);
		managenewspage.clickOnSavebutton();
		boolean alertdisplayed=managenewspage.isAlertMessageDisplayed();
		Assert.assertTrue(alertdisplayed,"Alert not displayed");
	}
}
