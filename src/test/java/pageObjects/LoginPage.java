package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement username;
	
	public void enterUsername(String userName)
	{
		username.sendKeys(userName);
	}
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;
	
	public void enterpassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement login_button;
	
	public void clickLoginBtn()
	{
		login_button.click();
	}
	
	
}
