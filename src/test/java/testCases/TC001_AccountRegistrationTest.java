package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups={"Regression", "Master"})
	public void verify_account_registration()
	{
		
		try {
		logger.info("******* Strating TC001_AccountRegistrationTest *******");
		
		HomePage hp = new HomePage(driver);
		logger.info("HomePage object is created");
		
		// Click on MyAccount link
		hp.clickMyAccount();
		logger.info("Clicked on MyAccoount link");
		
		// Click on Register link
		hp.clickRegister();
		logger.info("Clicked on Register link");
		
		AccountRegistrationPage ac = new AccountRegistrationPage(driver);
		logger.info("AccountRegistrationPage object is created");
		
		// Enter first name
		ac.enterFirstName(randomString().toUpperCase());
		logger.info("Entered first name");			
		
		// Enter last name
		ac.enterLastName(randomString().toUpperCase());
		logger.info("Entered last name");
		
		// Enter email address
		ac.enterEmail(randomString()+"@gmail.com");
		logger.info("Entered email address");
		
		// Enter telephone 
		ac.enterTelephone(randomNumber());
		logger.info("Entered telephone number");
		
		// Captured random alphanumeric and stored in password variable
		String password = randomAlphaNumeric();
		logger.info("Stored the random alphanumeric test data in password variable:-"+password);
		
		// Enter password
		ac.enterPassword(password);
		logger.info("Entered password");
		
		// Enter confirm password
		ac.enterConfirmPassword(password);
		logger.info("Entered confirm password");
		
		// Click on privacy policy
		ac.clickPrivacyPolicy();
		logger.info("Clicked on privacy policy");
		
		// Click on continue button
		ac.clickOnContinue();
		logger.info("Clicked on continue button");
		
		String confmsg = ac.getConfirmationmsg();
		logger.info("Get the confirmation message:-"+confmsg);
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}else
		{
			logger.error("Test Failed...");
			logger.debug("Debug logs...");
			Assert.assertTrue(false);
			
		}
		
		// Verify the confirmation message
		// Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		logger.info("Verify the confirmation message after account registered");
		} 
		catch (Exception e)
		{
			Assert.fail();
		}
		
		logger.info("******* Finished TC001_AccountRegistrationTest *******");
	}
	
	
}
