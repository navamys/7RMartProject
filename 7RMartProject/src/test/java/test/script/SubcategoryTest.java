package test.script;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import pages.SubcategoryPage;
import utilities.ExcelUtilities;

public class SubcategoryTest extends Base{
	HomePage homepage;
	SubcategoryPage subcategorypage;
	@Test
	public void verifyIfUserIsAbleToCreateSubcategory() throws IOException, AWTException {
		String loginusernamevalue=ExcelUtilities.getStringData(1, 0,"LoginPage"); 
		String loginpasswordvalue=ExcelUtilities.getStringData(1, 1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(loginusernamevalue).enterPasswordOnPasswordField(loginpasswordvalue);
		homepage=loginpage.clickOnSigninButton();
		
		String subcategoryvalue=ExcelUtilities.getStringData(1, 1,"SubcategoryPage");
		subcategorypage=homepage.clickOnSubcategoryMoreinfobutton();
		subcategorypage.clickOnNewbutton().selectValueOnCateforyFieldDropdown().selectValueOnSubcateforyField(subcategoryvalue).fileUpload().clickOnSavebutton();
		boolean alertdisplayed=subcategorypage.isAlertMessageDisplayed();
		Assert.assertTrue(alertdisplayed,"Green success Alert not displayed");
	}
	@Test
	public void VerifyIfUserIsNotAbleToCreateExistingSubcategory() throws IOException, AWTException {
		String loginusernamevalue=ExcelUtilities.getStringData(1, 0,"LoginPage"); 
		String loginpasswordvalue=ExcelUtilities.getStringData(1, 1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(loginusernamevalue).enterPasswordOnPasswordField(loginpasswordvalue);
		homepage=loginpage.clickOnSigninButton();
		
		
		String subcategoryvalue=ExcelUtilities.getStringData(2, 1,"SubcategoryPage");
		SubcategoryPage subcategorypage=new SubcategoryPage(driver);
		subcategorypage=homepage.clickOnSubcategoryMoreinfobutton();
		subcategorypage.clickOnNewbutton().selectValueOnCateforyFieldDropdown().selectValueOnSubcateforyField(subcategoryvalue).clickOnSavebutton();
		boolean alertdisplayed=subcategorypage.isAlertMessageDisplayed();
		Assert.assertTrue(alertdisplayed,"Red error Alert not displayed");
	}
}
