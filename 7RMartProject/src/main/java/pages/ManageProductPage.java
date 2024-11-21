package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.FileUploadUtilities;

public class ManageProductPage {
	WebDriver driver;
	public ManageProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//input[@name='username']") private WebElement loginusername;
	@FindBy(xpath="//input[@name='password']") private WebElement loginpassword;
	@FindBy(xpath="//button[@type='submit']") private WebElement signinbutton;
	
	@FindBy(css="a.small-box-footer[href='https://groceryapp.uniqassosiates.com/admin/list-product']") private WebElement moreinfobutton;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Product/add']") private WebElement newicon;
	@FindBy(xpath="//input[@id='title']") private WebElement title;
	@FindBy(xpath="//input[@id='main_img']") private WebElement uploadimagebutton; 
	//we cannot do this test as some mandatory fields are not inspectable - website issue- not even possible in manual testing
	
	public void enterUsernameOnUsernameField(String usernamepassing) {
		loginusername.sendKeys(usernamepassing);
	}
	public void enterPasswordOnPasswordField(String passwordpassing) {
		loginpassword.sendKeys(passwordpassing);
	}
	public void clickOnSigninButton() {
		signinbutton.click();
	}
	public void clickOnMoreinfoButton() {
		moreinfobutton.click();
	}
	public void clickOnNewIcon() {
		newicon.click();
	}
	public void enterValueOnTitleField(String titlepassing) {
		title.sendKeys(titlepassing);
	}
	public void fileUpload() throws AWTException {
		FileUploadUtilities fileuploadutilities=new FileUploadUtilities();
		fileuploadutilities.FileuploadUsingRobotclass(uploadimagebutton, Constants.APPLE_IMAGE);
	}
	//we cannot do this test as some mandatory fields are not inspectable - website issue- not even possible in manual testing
	
}
