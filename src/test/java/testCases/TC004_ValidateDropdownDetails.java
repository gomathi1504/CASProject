package testCases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import testBase.BaseClass;

public class TC004_ValidateDropdownDetails extends BaseClass
{
	@Test
	public void validateLanguageList()
	{
		logger.info("**** Starting TC004_ValidateDropdownDetails ****");		
		
		try
		{
			List <String> languagelist = gp.getLanguageList();
			for(String l : languagelist)
			{
				System.out.println(l);
			}
			logger.info("Captued Dropdown elements of Language");		
			if(languagelist.get(0).equals("English")&&languagelist.get(1).equals("Portuguese")) 
			{
				logger.info("TC004 Test Passed");
				gp.clickLanguageMenu();
				captureScreen(this.getClass().getName());
				Assert.assertTrue(true);
			}
			else 
			{
				logger.error("TC004 Test Failed");
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			logger.error("Test Failed..");
			Assert.fail();
		}

		logger.info("**** Finished TC004_ValidateDropdownDetails ****");
	}
}
