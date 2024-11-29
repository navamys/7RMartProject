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
	@FindBy(css="a.small-box-footer[href='https://groceryapp.uniqassosiates.com/admin/list-admin']")private WebElement moreinfobutton;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/user/edit?edit=10816&page_ad=1']")private WebElement updateicon;
	@FindBy(xpath="//input[@id='username']")private WebElement usernameupdate;
	@FindBy(xpath="//input[@id='password']")private WebElement passwordupdate;
	@FindBy(xpath="//select[@id='user_type']")private WebElement usertypeupdate;
	@FindBy(xpath="//button[@name='Update']")private WebElement updatebutton;
	@FindBy(xpath="//h5[text()=' Alert!']")private WebElement alertmessage;
	
	public void clickOnMoreinfoButton() {
		moreinfobutton.click();
	}
	public void clickOnUpdateIcon() {
		updateicon.click();
	}
	public void enterValueToBeUpdatedOnUsernameField(String usernameupdatepassing) {
		usernameupdate.clear();
		usernameupdate.sendKeys(usernameupdatepassing);
	}
	public void enterValueToBeUpdatedOnPasswordField(String passwordupdatepassing) {
		passwordupdate.clear();
		passwordupdate.sendKeys(passwordupdatepassing);
	}
	public void selectValueOnUsertypeField() {
		//Select select=new Select(usertypeupdate);
		//select.selectByValue(passingusertypevalue);
		PageUtility pageutility=new PageUtility();
		pageutility.selectByIndex(usertypeupdate, 1);
	}
	public void clickOnUpdateButton() {
		updatebutton.click();
	}
	public boolean isAlertMessageDisplayed() {
		return alertmessage.isDisplayed();
	}
	
}
