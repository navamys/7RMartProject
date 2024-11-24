package test.script;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ManageNewsPage;
import pages.SubcategoryPage;
import utilities.ExcelUtilities;

public class SubcategoryTest extends Base{
	@Test
	public void createSubcategory() throws IOException, AWTException {
		String loginusernamevalue=ExcelUtilities.getStringData(1, 0,"LoginPage"); 
		String loginpasswordvalue=ExcelUtilities.getStringData(1, 1,"LoginPage");
		SubcategoryPage subcategorypage=new SubcategoryPage(driver);
		subcategorypage.enterUsernameOnUsernameField(loginusernamevalue);
		subcategorypage.enterPasswordOnPasswordField(loginpasswordvalue);
		subcategorypage.clickOnSigninButton();
		
		String categoryvalue=ExcelUtilities.getStringData(1, 0,"SubcategoryPage");
		String subcategoryvalue=ExcelUtilities.getStringData(1, 1,"SubcategoryPage");
		subcategorypage.selectValueOnCateforyFieldDropdown(categoryvalue);
		subcategorypage.selectValueOnSubcateforyFieldDropdown(subcategoryvalue);
		subcategorypage.fileUpload();
		subcategorypage.clickOnSavebutton();
		boolean alertdisplayed=subcategorypage.isAlertMessageDisplayed();
		Assert.assertTrue(alertdisplayed,"Green success Alert not displayed");
	}
	@Test
	public void createExistingSubcategory() throws IOException, AWTException {
		String loginusernamevalue=ExcelUtilities.getStringData(1, 0,"LoginPage"); 
		String loginpasswordvalue=ExcelUtilities.getStringData(1, 1,"LoginPage");
		SubcategoryPage subcategorypage=new SubcategoryPage(driver);
		subcategorypage.enterUsernameOnUsernameField(loginusernamevalue);
		subcategorypage.enterPasswordOnPasswordField(loginpasswordvalue);
		subcategorypage.clickOnSigninButton();
		
		String categoryvalue=ExcelUtilities.getStringData(2, 0,"SubcategoryPage");
		String subcategoryvalue=ExcelUtilities.getStringData(2, 1,"SubcategoryPage");
		subcategorypage.selectValueOnCateforyFieldDropdown(categoryvalue);
		subcategorypage.selectValueOnSubcateforyFieldDropdown(subcategoryvalue);
		subcategorypage.clickOnSavebutton();
		boolean alertdisplayed=subcategorypage.isAlertMessageDisplayed();
		Assert.assertTrue(alertdisplayed,"Red error Alert not displayed");
	}
}
