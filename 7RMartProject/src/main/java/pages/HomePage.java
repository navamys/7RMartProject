package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a.small-box-footer[href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	private WebElement adminmoreinfobutton;
	@FindBy(css = "a.small-box-footer[href='https://groceryapp.uniqassosiates.com/admin/list-contact']")
	private WebElement contactmoreinfobutton;
	@FindBy(css = "a.small-box-footer[href='https://groceryapp.uniqassosiates.com/admin/list-footertext']")
	private WebElement footermoreinfobutton;
	@FindBy(css = "a.small-box-footer[href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	private WebElement newsmoreinfobutton;
	@FindBy(css = "a.small-box-footer[href='https://groceryapp.uniqassosiates.com/admin/list-product']")
	private WebElement productmoreinfobutton;
	@FindBy(css = "a.small-box-footer[href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']")
	private WebElement subcategorymoreinfobutton;

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	private WebElement adminimagebutton;
	@FindBy(css = "a.dropdown-item[href='https://groceryapp.uniqassosiates.com/admin/logout']")
	private WebElement logoutbutton;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement signinbutton;

	public AdminuserPage clickOnAdminMoreinfoButton() {
		adminmoreinfobutton.click();
		return new AdminuserPage(driver);
	}

	public ManageContactPage clickOnContactMoreinfobutton() {
		contactmoreinfobutton.click();
		return new ManageContactPage(driver);
	}

	public ManageFooterPage clickOnFooterMoreinfobutton() {
		// moreinfobutton.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", footermoreinfobutton);
		return new ManageFooterPage(driver);
	}

	public ManageNewsPage clickOnNewsMoreinfoButton() {
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollBy(0,150)", "");
		// js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		// these three lines for scrolling down, but not needed now
		// moreinfobutton.click(); //here usual click wont work, hence used js
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", newsmoreinfobutton);
		return new ManageNewsPage(driver);
	}

	public ManageProductPage clickOnProductMoreinfoButton() {
		// moreinfobutton.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", productmoreinfobutton);
		return new ManageProductPage(driver);
	}

	public SubcategoryPage clickOnSubcategoryMoreinfobutton() {
		// moreinfobutton.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", subcategorymoreinfobutton);
		return new SubcategoryPage(driver);
	}

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
