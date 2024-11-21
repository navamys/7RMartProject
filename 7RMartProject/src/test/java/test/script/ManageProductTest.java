package test.script;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.ManageProductPage;
import utilities.ExcelUtilities;

public class ManageProductTest extends Base{
	@Test
	public void createNewProduct() throws IOException {
		String loginusernamevalue=ExcelUtilities.getStringData(1, 0,"LoginPage"); 
		String loginpasswordvalue=ExcelUtilities.getStringData(1, 1,"LoginPage");
		ManageProductPage manageproductpage=new ManageProductPage(driver);
		manageproductpage.enterUsernameOnUsernameField(loginusernamevalue);
		manageproductpage.enterPasswordOnPasswordField(loginpasswordvalue);
		manageproductpage.clickOnSigninButton();
	}
	

}
