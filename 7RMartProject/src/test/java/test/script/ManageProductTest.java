package test.script;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageProductPage;
import utilities.ExcelUtilities;

public class ManageProductTest extends Base{
	@Test
	public void verifyIfUserIsAbleToCreateNewProduct() throws IOException, AWTException {
		
		
		String usernamevalue=ExcelUtilities.getStringData(1, 0,"LoginPage"); 
		String passwordvalue=ExcelUtilities.getStringData(1, 1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSigninButton();
		
		ManageProductPage manageproductpage=new ManageProductPage(driver);
		String titlevalue=ExcelUtilities.getStringData(1, 0,"ManageProductPage");
		String wightvalue=ExcelUtilities.getIntegerData(1, 1,"ManageProductPage");
		String maxqty=ExcelUtilities.getIntegerData(1, 3,"ManageProductPage");
		String pricevalue=ExcelUtilities.getIntegerData(1, 4,"ManageProductPage");
		String stockvalue=ExcelUtilities.getIntegerData(1, 5,"ManageProductPage");
		manageproductpage.clickOnMoreinfoButton();
		manageproductpage.clickOnNewIcon();
		manageproductpage.enterValueOnTitleField(titlevalue);
		manageproductpage.enterValueOnWeightvalueField(wightvalue);
		manageproductpage.selectWeightunitDropdownValue();
		manageproductpage.enterValueOnMaxQuantityField(maxqty);
		manageproductpage.enterPrice(pricevalue);
		manageproductpage.enterStock(stockvalue);
		manageproductpage.fileUpload();
		manageproductpage.selectFeaturedRadiobutton();
		manageproductpage.clickOnSavebutton();
		boolean alertdisplayed=manageproductpage.isAlertMessageDisplayed();
		Assert.assertTrue(alertdisplayed,"Red error Alert not displayed");
	}
	

}
