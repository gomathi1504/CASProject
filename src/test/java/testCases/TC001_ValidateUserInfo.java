package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_ValidateUserInfo extends BaseClass
{
	@Test
	public void validateUser()
	{
		logger.info("**** Starting TC001_ValidateUserInfo ****");		
		
		try
		{
			hp = new HomePage(driver);
			hp.clickUser();
			logger.info("Clicked on User Information");
			String user_name = hp.getUserName();
			System.out.println(user_name);
			String user_email = hp.getUserEmail();
			System.out.println(user_email);
			logger.info("Validating User Information");
			if(user_name.equals("Gomathi, S (Contractor)") && user_email.equals("2318582@cognizant.com")) 
			{				
				logger.info("TC001 Test passed");
				captureScreen(this.getClass().getName());
				Assert.assertTrue(true);
			}
			else 
			{
				logger.error("TC001 Test Failed");
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			logger.error("TC001 Test Failed..");
			Assert.fail();
		}
		
		logger.info("**** Finished TC001_ValidateUserInfo ****");	
	}
}
