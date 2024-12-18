package pages;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.Constants;
import utilities.FileUploadUtilities;
import utilities.PageUtility;

public class SubcategoryPage {
	WebDriver driver;

	public SubcategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Subcategory/add']")
	private WebElement newbutton;
	@FindBy(xpath = "//select[@id='cat_id']")
	private WebElement categoryfield;
	@FindBy(xpath = "//input[@id='subcategory']")
	private WebElement subcategoryfield;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement imageuploadbutton;
	@FindBy(xpath = "	//button[@type='submit']")
	private WebElement savebutton;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	private WebElement alertmessage;

	public SubcategoryPage clickOnNewbutton() {
		newbutton.click();
		return this;
	}

	public SubcategoryPage selectValueOnCateforyFieldDropdown() {
		PageUtility pageutility = new PageUtility();
		pageutility.selectByIndex(categoryfield, 1);
		return this;
	}

	public SubcategoryPage selectValueOnSubcateforyField(String passingsubcategoryvalue) {
		subcategoryfield.sendKeys(passingsubcategoryvalue);
		return this;
	}

	public SubcategoryPage fileUpload() throws AWTException {
		FileUploadUtilities fileuploadutilities = new FileUploadUtilities();
		// fileuploadutilities.FileuploadUsingRobotclass(imageuploadbutton,
		// Constants.GLUCOSE_MONITOR_IMAGE);
		fileuploadutilities.fileuploadUsingSendkeys(imageuploadbutton, Constants.GLUCOSE_MONITOR_IMAGE);
		return this;
	}

	public SubcategoryPage clickOnSavebutton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", savebutton);
		// savebutton.click();
		return this;
	}

	public boolean isAlertMessageDisplayed() {
		return alertmessage.isDisplayed();
	}

}
