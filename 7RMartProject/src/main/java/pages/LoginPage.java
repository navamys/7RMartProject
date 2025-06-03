package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { // page class also called element repo(have methods and elements)in src main
	WebDriver driver;

	public LoginPage(WebDriver driver) { // constructor
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// pom(page object model) with page factory(@FindBy). Design is 'page by page'
	// WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
	// WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
	// WebElement signinbutton=driver.findElement(By.xpath("//button[@type='submit']"));
	// WebElement dashboard=driver.findElement(By.xpath("//p[text()='Dashboard']"));
	@FindBy(xpath = "//input[@name='username']")
	private WebElement username;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement signinbutton;
	@FindBy(xpath = "//p[text()='Dashboard']")
	private WebElement dashboard;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement alertmessage;

	public LoginPage enterUsernameOnUsernameField(String usernamepassing) {
		username.sendKeys(usernamepassing);
		return this;
	}

	public LoginPage enterPasswordOnPasswordField(String passwordpassing) {
		password.sendKeys(passwordpassing);
		return this;
	}

	public HomePage clickOnSigninButton() {
		signinbutton.click();
		return new HomePage(driver);
	}

	public boolean isHomePageDisplayed() {
		return dashboard.isDisplayed();
	}

	public boolean isAlertDisplayed() {
		return alertmessage.isDisplayed();
	}

}
