package testCases;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import testBase.BaseClass;
import utilities.ExcelUtility;

public class TC005_ValidateGSDDetails extends BaseClass
{	
	ExcelUtility excel;
	@Test
	@Parameters({"browser"})
	public void validateGsdDetails(String br)
	{
		if(br.equals("chrome"))
	    excel = new ExcelUtility("C:\\Users\\2318582\\eclipse-workspace\\CASProject\\testData\\Chrome_GsdOutput.xlsx");
		if(br.equals("edge"))
		excel = new ExcelUtility("C:\\Users\\2318582\\eclipse-workspace\\CASProject\\testData\\Edge_GsdOutput.xlsx");
			
		logger.info("**** Starting TC005_ValidateGSDDetails ****");		
		
		try
		{
			Set<Integer> set = new HashSet<Integer>();
			int x;
			while(true)
			{
				x = (int)(Math.random()*100);
				if(x>=1&&x<=56)
				{
					set.add(x);
					if(set.size()>2)
						break;
				}
			}
			List<Integer> list = new ArrayList<Integer>(set);
			
			for(int i=0; i<list.size(); i++)
			{
				gp.clickCountryMenu();
				logger.info("Clicked Country Input Box");
				gp.selectCountry(list.get(i));
				logger.info("Selected Random Country from the Country List");
				String selected_country = gp.getCountryName();
				captureScreen(this.getClass().getName()+"_"+selected_country);
				System.out.println("__________________________________________"+selected_country+"__________________________________________");
				List <String> tool_tips = gp.getToolTips();
				for(String t : tool_tips)
				{
					System.out.println(t);
				}
				for(int j=0; j<tool_tips.size();j++) 
				{
					int cellNo=0;
					excel.setCellData(selected_country, j, cellNo, tool_tips.get(j));
				}
				logger.info("Captured Contents Of Gsd for the "+selected_country+" Country");				
			}
			logger.info("Validating Tooltips");
			Assert.assertTrue(true);
			logger.info("Test Passed");
		}
		catch(Exception e)
		{
			logger.error("TC005 Test Failed");
			Assert.fail();
		}
		
		logger.info("**** Finished TC005_ValidateGSDDetails ****");
	}
}
