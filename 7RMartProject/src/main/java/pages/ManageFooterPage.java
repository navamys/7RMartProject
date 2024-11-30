package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterPage {
	WebDriver driver;
	public ManageFooterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(css="a.small-box-footer[href='https://groceryapp.uniqassosiates.com/admin/list-footertext']") private WebElement moreinfobutton;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1']") private WebElement updateicon ;
	@FindBy(xpath="//textarea[@name='address']") private WebElement addressfield;
	@FindBy(xpath="//input[@id='email']") private WebElement emailfield;
	@FindBy(xpath="//input[@id='phone']") private WebElement phonefield ;
	@FindBy(xpath="//button[@type='submit']") private WebElement updatebutton;
	@FindBy(xpath="//h5[text()=' Alert!']") private WebElement alertmessage;
	
	public void clickOnMoreinfobutton() {
		//moreinfobutton.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",moreinfobutton);
	}
	public void clickOnUpdateicon() {
		updateicon.click();
	}
	public void enterAddress(String passingaddress) {
		addressfield.clear();
		addressfield.sendKeys(passingaddress);
	}
	public void enterEmail(String passingemail) {
		emailfield.clear();
		emailfield.sendKeys(passingemail);
	}
	public void enterPhonenumber(String passphonenumber) {
		phonefield.clear();
		phonefield.sendKeys(passphonenumber);
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
