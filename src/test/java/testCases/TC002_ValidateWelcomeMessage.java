package testCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.GSDPage;
import pageObjects.OneCognizantPage;
import testBase.BaseClass;

public class TC002_ValidateWelcomeMessage extends BaseClass
{	
	@Test
	@Parameters({"browser"})
	public void welcomeMsgValidation(String browserName) throws IOException, InterruptedException {
		
		try {
			
			op = new OneCognizantPage(driver);
		    gp = new GSDPage(driver);
			
		logger.info("************TC002_ValidateWelcomeMsg***************");			
			
		hp.clickOneCognizant();
		logger.info("Clicked OneC");	
		//switching the driver to onec page
        Set<String> windId = driver.getWindowHandles();		
		ArrayList<String> windIds = new ArrayList<String>(windId);		
		driver.switchTo().window(windIds.get(1));
		
		if(browserName.equals("chrome")) {
			op.clickSearchChrome("gsd");
		}
		else if(browserName.equals("edge")) {
			op.clickSearchIcon();
			op.clickSearchEdge("gsd");
		}
		
		logger.info("Searching Gsd in input search box");
		op.clickGSD();
		logger.info("Clicked GSD Link");
		driver.switchTo().frame("appFrame");
		
		logger.info("Validating Welcome Message");
		String actual_wlcmMsg = gp.getWelcomeMessage();
		String exp_wlcmMsg = "Welcome to the all-in-one Live Support!";
		
		System.out.println("Welcome Message : "+actual_wlcmMsg);
		
			if(actual_wlcmMsg.equals(exp_wlcmMsg)) {
				logger.info("TC002 Test Passed");
				captureScreen(this.getClass().getName());
				Assert.assertTrue(true);
			}
			else {
				logger.error("TC002 Test Failed");
				Assert.fail();
			}
		}
		catch(Exception e) {
			logger.error("TC002 Test Failed");
			Assert.fail();
		}	
	}	
}
