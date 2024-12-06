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
	
	
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']") private WebElement newbutton;
	@FindBy(xpath="//textarea[@id='news']") private WebElement newsfield;
	@FindBy(xpath="//button[@type='submit']") private WebElement savebutton;
	@FindBy(xpath="//h5[text()=' Alert!']") private WebElement alertmessage;
	
	
	
	public ManageNewsPage clickOnNewButton() {
		newbutton.click();
		return this;
	}
	public ManageNewsPage enterNewsOnNewsField(String news) {
		newsfield.sendKeys(news);
		return this;
	}
	public ManageNewsPage clickOnSavebutton() {
		savebutton.click();
		return this;
	}
	public boolean isAlertMessageDisplayed() {
		return alertmessage.isDisplayed();
	}
}
