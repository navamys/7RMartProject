package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterPage {
	WebDriver driver;

	public ManageFooterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1']")
	private WebElement updateicon;
	@FindBy(xpath = "//textarea[@name='address']")
	private WebElement addressfield;
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailfield;
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phonefield;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement updatebutton;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	private WebElement alertmessage;

	public ManageFooterPage clickOnUpdateicon() {
		updateicon.click();
		return this;
	}

	public ManageFooterPage enterAddress(String passingaddress) {
		addressfield.clear();
		addressfield.sendKeys(passingaddress);
		return this;
	}

	public ManageFooterPage enterEmail(String passingemail) {
		emailfield.clear();
		emailfield.sendKeys(passingemail);
		return this;
	}

	public ManageFooterPage enterPhonenumber(String passphonenumber) {
		phonefield.clear();
		phonefield.sendKeys(passphonenumber);
		return this;
	}

	public ManageFooterPage clickOnUpdatebutton() {
		// updatebutton.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", updatebutton);
		return this;
	}

	public boolean isAlertMessageDisplayed() {
		return alertmessage.isDisplayed();
	}

	public boolean isUpdateButtonDisplayed() {
		return updatebutton.isDisplayed();
	}

}
