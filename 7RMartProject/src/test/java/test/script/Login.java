package test.script;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends Base{
	
	//this is just a trial for practice, not required class actually, can delete this class
	@Test
	public void loginTest() {
		String usernamevalue="admin";
		String passwordvalue="admin";
		//for time being we hard code values to be sendkey. but future, we read these values from xcel read.
		WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
		WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		WebElement signinbutton=driver.findElement(By.xpath("//button[@type='submit']"));
		username.sendKeys(usernamevalue);//here time being we use string variable here, future il, we use excel read here
		password.sendKeys(passwordvalue);
		signinbutton.click();
		
		WebElement dashboard=driver.findElement(By.xpath("//p[text()='Dashboard']"));
		boolean ishomepageavailable=dashboard.isDisplayed();
		Assert.assertTrue(ishomepageavailable, "Failed since not logged in- ");
		
		
		
		
		
		
	}
}
