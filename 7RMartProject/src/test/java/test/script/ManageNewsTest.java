package test.script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ManageNewsPage;
import utilities.ExcelUtilities;

public class ManageNewsTest extends Base{
	@Test
	public void deleteNews() throws IOException {
		String loginusernamevalue=ExcelUtilities.getStringData(1, 0,"LoginPage"); 
		String loginpasswordvalue=ExcelUtilities.getStringData(1, 1,"LoginPage");
		ManageNewsPage managenewspage=new ManageNewsPage(driver);
		managenewspage.enterUsernameOnUsernameField(loginusernamevalue);
		managenewspage.enterPasswordOnPasswordField(loginpasswordvalue);
		managenewspage.clickOnSigninButton();
		
		managenewspage.clickOnMoreinfoButton();
		managenewspage.clickOnDeleteButton();
		boolean alertdisplayed=managenewspage.isAlertMessageDisplayed();
		Assert.assertTrue(alertdisplayed,"Alert not displayed");
	}
}
