package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement input_firstname;
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement input_lastname;
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement input_email;
	
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement input_telephone;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement input_password;
	
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement input_Confirmpassword;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement lnkContinue;
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement privacy_policy;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void enterFirstName(String firstname)
	{
		input_firstname.sendKeys(firstname);
	}
		
	public void enterLastName(String lastname)
	{
		input_lastname.sendKeys(lastname);
	}
		
	public void enterEmail(String email)
	{
		input_email.sendKeys(email);
	}
		
	public void enterTelephone(String telipphone)
	{
		input_telephone.sendKeys(telipphone);
	}
		
	public void enterPassword(String password)
	{
		input_password.sendKeys(password);
	}
	
	public void enterConfirmPassword(String Cpassword)
	{
		input_Confirmpassword.sendKeys(Cpassword);
	}
		
	public void clickOnContinue()
	{
		lnkContinue.click();
	}
	
	public void clickPrivacyPolicy()
	{
		privacy_policy.click();
	}
	
	public String getConfirmationmsg()
	{
		try {
			return (msgConfirmation.getText());
		}catch (Exception e) {
			return (e.getMessage());
		}
	}
	
}
