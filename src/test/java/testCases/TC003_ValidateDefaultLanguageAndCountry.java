package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import testBase.BaseClass;

public class TC003_ValidateDefaultLanguageAndCountry extends BaseClass
{
	@Test
	public void validateLanguageAndCountry()
	{
		logger.info("**** Starting TC003_ValidateDefaultLanguageAndCountry ****");		
		
		try
		{
			String exp_language = "English";
			String actual_language = gp.getDefaultLanguage();
			System.out.println(actual_language);
			String exp_country = "India";
			String actual_country = gp.getDefaultCountry();
			System.out.println(actual_country);
			logger.info("Captured Default Country And Language");			
			logger.info("Validating Default Country And Language");
			if(exp_country.equals(actual_country)&&exp_language.equals(actual_language)) 
			{
				logger.info("TC003_Test Passed");
				captureScreen(this.getClass().getName());
				Assert.assertTrue(true);
			}
			else 
			{
				logger.error("TC003_Test Failed");
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			logger.error("TC003 Test Failed");
			Assert.fail();
		}
		logger.info("**** Finished TC003_ValidateDefaultLanguageAndCountry ****");
	}
}
