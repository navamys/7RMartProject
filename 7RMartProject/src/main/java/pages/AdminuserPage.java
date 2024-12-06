package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.ExcelUtilities;
import utilities.PageUtility;

public class AdminuserPage {
	WebDriver driver;
	
	public AdminuserPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/user/edit?edit=11002&page_ad=1']")private WebElement updateicon;
	@FindBy(xpath="//input[@id='username']")private WebElement usernameupdate;
	@FindBy(xpath="//input[@id='password']")private WebElement passwordupdate;
	@FindBy(xpath="//select[@id='user_type']")private WebElement usertypeupdate;
	@FindBy(xpath="//button[@name='Update']")private WebElement updatebutton;
	@FindBy(xpath="//h5[text()=' Alert!']")private WebElement alertmessage;
	
	
	public AdminuserPage clickOnUpdateIcon() {
		updateicon.click();
		return this; //return this page
	}
	public AdminuserPage enterValueToBeUpdatedOnUsernameField(String usernameupdatepassing) {
		usernameupdate.clear();
		usernameupdate.sendKeys(usernameupdatepassing);
		return this;
	}
	public AdminuserPage enterValueToBeUpdatedOnPasswordField(String passwordupdatepassing) {
		passwordupdate.clear();
		passwordupdate.sendKeys(passwordupdatepassing);
		return this;
	}
	public AdminuserPage selectValueOnUsertypeField() {
		//Select select=new Select(usertypeupdate);
		//select.selectByValue(passingusertypevalue);
		PageUtility pageutility=new PageUtility();
		pageutility.selectByIndex(usertypeupdate, 1);
		return this;
	}
	public AdminuserPage clickOnUpdateButton() {
		updatebutton.click();
		return this;
	}
	public boolean isAlertMessageDisplayed() {
		return alertmessage.isDisplayed();
	}
	
}
