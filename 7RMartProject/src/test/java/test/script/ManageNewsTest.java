package test.script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtilities;

public class ManageNewsTest extends Base{
	HomePage homepage;
	ManageNewsPage managenewspage;
	@Test
	public void verifyIfUserIsAbleToCreateNews() throws IOException {
		String usernamevalue=ExcelUtilities.getStringData(1, 0,"LoginPage"); 
		String passwordvalue=ExcelUtilities.getStringData(1, 1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		homepage=loginpage.clickOnSigninButton();
		
		
		String news=ExcelUtilities.getStringData(1, 0,"ManagenewsPage");
		managenewspage=homepage.clickOnNewsMoreinfoButton();
		managenewspage.clickOnNewButton().enterNewsOnNewsField(news).clickOnSavebutton();
		boolean alertdisplayed=managenewspage.isAlertMessageDisplayed();
		Assert.assertTrue(alertdisplayed,"Alert not displayed");
	}
}
