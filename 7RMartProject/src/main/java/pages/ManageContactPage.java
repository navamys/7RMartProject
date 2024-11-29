package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageContactPage {
	WebDriver driver;
	public ManageContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(css="a.small-box-footer[href='https://groceryapp.uniqassosiates.com/admin/list-contact']") private WebElement moreinfobutton ;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1']") private WebElement updateicon ;
	@FindBy(xpath="//input[@id='phone']") private WebElement phonefield ;
	@FindBy(xpath="//input[@id='email']") private WebElement emailfield ;
	@FindBy(xpath="//textarea[@name='address']") private WebElement addressfield ;
	@FindBy(xpath="//textarea[@name='del_time']") private WebElement deliverytimefield;
	@FindBy(xpath="//input[@id=\"del_limit\"]") private WebElement deliverychargefield ;
	@FindBy(xpath="//button[@type='submit']") private WebElement updatebutton ;
	@FindBy(xpath="//h5[text()=' Alert!']") private WebElement alertmessage;
	
	public void clickOnMoreinfobutton() {
		moreinfobutton.click();
	}
	public void clickOnUpdateicon() {
		updateicon.click();
	}
	public void enterPhonenumber(String passphonenumber) {
		phonefield.clear();
		phonefield.sendKeys(passphonenumber);
	}
	public void enterEmail(String passingemail) {
		emailfield.clear();
		emailfield.sendKeys(passingemail);
	}
	public void enterAddress(String passingaddress) {
		addressfield.clear();
		addressfield.sendKeys(passingaddress);
	}
	public void enterDeliveryTime(String passingdeliverytime) {
		deliverytimefield.clear();
		deliverytimefield.sendKeys(passingdeliverytime);
	}
	public void enterDeliveryCharge(String passingdeliverycharge) {
		deliverychargefield.clear();
		deliverychargefield.sendKeys(passingdeliverycharge);
	}
	public void clickOnUpdatebutton() {
		//updatebutton.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",updatebutton);
	}
	public boolean isAlertMessageDisplayed() {
		return alertmessage.isDisplayed();
	}
	public boolean isUpdateButtonDisplayed() {
		return updatebutton.isDisplayed();
	}


	
	
	
}
