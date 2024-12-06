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
	
		
	public ManageProductPage clickOnNewIcon() {
		newicon.click();
		return this;
	}
	public ManageProductPage enterValueOnTitleField(String titlepassing) {
		title.sendKeys(titlepassing);
		return this;
	}
	public ManageProductPage enterValueOnWeightvalueField(String weightvaluepassing) {
		weightvaluefield.sendKeys(weightvaluepassing);
		return this;
	}
	public ManageProductPage selectWeightunitDropdownValue() {
		PageUtility pageutility=new PageUtility();
		pageutility.selectByIndex(weightunitdropdown,1);
		return this;
	}
	public ManageProductPage enterValueOnMaxQuantityField(String maxqtypassing) {
		maxquantityfield.sendKeys(maxqtypassing);
		return this;
	}
	public ManageProductPage enterPrice(String pricepasssing) {
		price.sendKeys(pricepasssing);
		return this;
	}
	public ManageProductPage enterStock(String stockpasssing) {
		stock.sendKeys(stockpasssing);
		return this;
	}
	public ManageProductPage fileUpload() throws AWTException {
		FileUploadUtilities fileuploadutilities=new FileUploadUtilities();
		//fileuploadutilities.FileuploadUsingRobotclass(uploadimagebutton, Constants.APPLE_IMAGE);
		fileuploadutilities.fileuploadUsingSendkeys(uploadimagebutton, Constants.APPLE_IMAGE);
		return this;
	}
	public ManageProductPage selectFeaturedRadiobutton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",featuredradio);
		return this;
		//featuredradio.click();
	}
	public ManageProductPage clickOnSavebutton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",savebutton);
		//savebutton.click();
		return this;
	}
	public boolean isAlertMessageDisplayed() {
		return alertmessage.isDisplayed();
	}
	
}
