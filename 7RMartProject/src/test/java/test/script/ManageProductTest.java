package test.script;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ManageProductPage;
import utilities.ExcelUtilities;

public class ManageProductTest extends Base{
	@Test
	public void createNewProduct() throws IOException, AWTException {
		String loginusernamevalue=ExcelUtilities.getStringData(1, 0,"LoginPage"); 
		String loginpasswordvalue=ExcelUtilities.getStringData(1, 1,"LoginPage");
		ManageProductPage manageproductpage=new ManageProductPage(driver);
		manageproductpage.enterUsernameOnUsernameField(loginusernamevalue);
		manageproductpage.enterPasswordOnPasswordField(loginpasswordvalue);
		manageproductpage.clickOnSigninButton();
		
		String titlevalue=ExcelUtilities.getStringData(1, 0,"ManageProductPage");
		String wightvalue=ExcelUtilities.getIntegerData(1, 1,"ManageProductPage");
		String wightunit=ExcelUtilities.getStringData(1, 2,"ManageProductPage");
		String maxqty=ExcelUtilities.getIntegerData(1, 3,"ManageProductPage");
		String pricevalue=ExcelUtilities.getIntegerData(1, 4,"ManageProductPage");
		String stockvalue=ExcelUtilities.getIntegerData(1, 5,"ManageProductPage");
		manageproductpage.clickOnMoreinfoButton();
		manageproductpage.clickOnNewIcon();
		manageproductpage.enterValueOnTitleField(titlevalue);
		manageproductpage.enterValueOnWeightvalueField(wightvalue);
		manageproductpage.selectWeightunitDropdownValue(wightunit);
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
