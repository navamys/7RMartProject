package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	WebDriver driver;
	public ManageNewsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//input[@name='username']") private WebElement loginusername;
	@FindBy(xpath="//input[@name='password']") private WebElement loginpassword;
	@FindBy(xpath="//button[@type='submit']") private WebElement signinbutton;
	
	@FindBy(css="a.small-box-footer[href='https://groceryapp.uniqassosiates.com/admin/list-news']") private WebElement moreinfobutton;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']") private WebElement newbutton;
	@FindBy(xpath="//textarea[@id='news']") private WebElement newsfield;
	@FindBy(xpath="//button[@type='submit']") private WebElement savebutton;
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
		//JavascriptExecutor js = (JavascriptExecutor) driver; 
		//js.executeScript("window.scrollBy(0,150)", ""); 
		//js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		//these three lines for scrolling down, but not needed now
		//moreinfobutton.click();  //here usual click wont work, hence used js
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",moreinfobutton);
	}
	public void clickOnNewButton() {
		newbutton.click();
	}
	public void enterNewsOnNewsField(String news) {
		newsfield.sendKeys(news);
	}
	public void clickOnSavebutton() {
		savebutton.click();
	}
	public boolean isAlertMessageDisplayed() {
		return alertmessage.isDisplayed();
	}
}
