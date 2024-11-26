package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.FileUploadUtilities;
import utilities.PageUtility;

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
	@FindBy(xpath="//input[@name='featured' and @value='yes']") private WebElement featuredradio;
	@FindBy(xpath="//button[@type='submit']") private WebElement savebutton;
	@FindBy(xpath="//input[@id='m_weight']") private WebElement weightvaluefield;
	@FindBy(xpath="//select[@id='w_unit']") private WebElement weightunitdropdown;
	@FindBy(xpath="//input[@id='max_weight']") private WebElement maxquantityfield;
	@FindBy(xpath="//input[@id='w_price']") private WebElement price ;
	@FindBy(xpath="//input[@id='w_stock']") private WebElement stock;
	@FindBy(xpath="//h5[text()=' Alert!']") private WebElement alertmessage;
	
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
		//moreinfobutton.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",moreinfobutton);
	}
	public void clickOnNewIcon() {
		newicon.click();
	}
	public void enterValueOnTitleField(String titlepassing) {
		title.sendKeys(titlepassing);
	}
	public void enterValueOnWeightvalueField(String weightvaluepassing) {
		weightvaluefield.sendKeys(weightvaluepassing);
	}
	public void selectWeightunitDropdownValue() {
		PageUtility pageutility=new PageUtility();
		pageutility.selectByIndex(weightunitdropdown,1);
	}
	public void enterValueOnMaxQuantityField(String maxqtypassing) {
		maxquantityfield.sendKeys(maxqtypassing);
	}
	public void enterPrice(String pricepasssing) {
		price.sendKeys(pricepasssing);
	}
	public void enterStock(String stockpasssing) {
		stock.sendKeys(stockpasssing);
	}
	public void fileUpload() throws AWTException {
		FileUploadUtilities fileuploadutilities=new FileUploadUtilities();
		//fileuploadutilities.FileuploadUsingRobotclass(uploadimagebutton, Constants.APPLE_IMAGE);
		fileuploadutilities.fileuploadUsingSendkeys(uploadimagebutton, Constants.APPLE_IMAGE);
	}
	public void selectFeaturedRadiobutton() {
		featuredradio.click();
	}
	public void clickOnSavebutton() {
		savebutton.click();
	}
	public boolean isAlertMessageDisplayed() {
		return alertmessage.isDisplayed();
	}
	
}
