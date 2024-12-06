package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);	
	}
	@FindBy(xpath="//a[@data-toggle='dropdown']")private WebElement adminimagebutton;
	@FindBy(css="a.dropdown-item[href='https://groceryapp.uniqassosiates.com/admin/logout']")private WebElement logoutbutton;
	@FindBy(xpath="//button[@type='submit']")private WebElement signinbutton;
	
	public void clickOnAdminimagebutton() {
		adminimagebutton.click();
	}
	public void clickOnLogoutbutton() {
		logoutbutton.click();
	}
	public boolean isSigninButtonDisplayed() {
		return signinbutton.isDisplayed();
	}
	
}
