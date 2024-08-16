package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{

	@Test(groups={"Sanity", "Master"})
	public void verify_Logintest() 
	{
		
		try
		{
			logger.info("******* Starting TC002_LoginTest *******");
			
			LoginPage lp = new LoginPage(driver);
			logger.info("LoginPage object created");
			
			HomePage hp = new HomePage(driver);
			logger.info("HomePage object is created");
			
			MyAccountPage ma = new MyAccountPage(driver);
			logger.info("MyAccountPage object is created");
			
			// Click on MyAccount link
			hp.clickMyAccount();
			logger.info("Clicked on MyAccoount link");
			
			// Click on login
			hp.clickLogin();
			logger.info("Clicked on Login");
						
			// Enter user name
			lp.enterUsername(p.getProperty("userName"));
			logger.info("Entered user name");
			
			// Enter password
			lp.enterpassword(p.getProperty("password"));
			logger.info("Entered password");
			
			// Click on login button
			lp.clickLoginBtn();
			logger.info("Clicked on login button");
			
			boolean targetpage = ma.isMyAccountPageExist();
			Assert.assertTrue(targetpage);
			// Assert.assertEquals(targetpage, true, "Login failed");
			
		}
		catch (Exception e)
		{
			Assert.fail();
		}
		
		logger.info("******* Finished TC001_AccountRegistrationTest *******");

	}
}
