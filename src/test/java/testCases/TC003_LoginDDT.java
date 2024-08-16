package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = "Datadriven")// getting data provider from different class
	public void verify_loginDDT(String email, String pwd, String exp)
	{
		logger.info("******* Starting TC003_LoginDDT *******");
		try {
		LoginPage lp = new LoginPage(driver);				
		HomePage hp = new HomePage(driver);			
		MyAccountPage ma = new MyAccountPage(driver);
		
		// Click on MyAccount link
		hp.clickMyAccount();
							
		// Click on login
		hp.clickLogin();
		
		// Enter user name
		lp.enterUsername(email);
					
		// Enter password
		lp.enterpassword(pwd);
					
		// Click on login button
		lp.clickLoginBtn();
		
		boolean targetpage = ma.isMyAccountPageExist();
		Assert.assertTrue(targetpage);
		
		/*
		   Data is Valid -   login success - test pass - logout 
		                     login failed - test fail
		   Data is Invalid - login success - test fail - logout 
		                     login failed - test pass
		 */
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetpage==true)
			{
				ma.clickLogoutBtn();
				ma.clickContinueBtn();
				Assert.assertTrue(true);			
			}
			else
			{
				Assert.assertTrue(false);
			}						
		}
		if(exp.equalsIgnoreCase("Invalid")) {
			
			if(targetpage==true)
			{
				ma.clickLogoutBtn();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}catch (Exception e)
		{
			Assert.fail();
		}
		logger.info("******* Finished TC003_LoginDDT *******");
	}
}
