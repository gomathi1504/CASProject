package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class GSDPage extends BasePage
{	
	public GSDPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//p[@class='Welcome-automated-text']")
	WebElement welcome;
	
	@FindBy(xpath="//span[@class='optionLangSelected']")
	WebElement language;
	
	@FindBy(xpath="//span[@class='optionCountrySelected']")
	WebElement country;
	
	@FindBy(xpath="//ul[@class='dropdown-menu langList' and @aria-labelledby='menu1']//a")
	List <WebElement> language_list;
	
	@FindBy(xpath="//ul[@class='dropdown-menu countryList pt-0 show']//a")
	List <WebElement> country_list;
	
	@FindBy(xpath="//nav[@class='navbar navbar-light app-headers navbar-expand-lg py-0']//span[@class='optionCountrySelected']")
	WebElement selected_country;
	
	@FindBy(xpath="//div[@class='col-md-12 application-tiles']")
	List <WebElement> tool_tips;
	
	public String getWelcomeMessage()
	{
		return welcome.getText();
	}
	
	public String getDefaultLanguage()
	{
		return language.getText();
	}
	
	public String getDefaultCountry()
	{
		return country.getText();
	}
	
	public void clickLanguageMenu()
	{
		language.click();
	}
	
	public List <String> getLanguageList()
	{
		List <String> languagelist = new ArrayList<String>();
		for(WebElement l : language_list)
		{
			languagelist.add(l.getAttribute("innerHTML"));
		}
		return languagelist;
	}
	
	public void clickCountryMenu()
	{
		country.click();
	}
	
	public void selectCountry(int i)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement c = country_list.get(i);
		js.executeScript("arguments[0].click();", c);
	}
	
	public String getCountryName()
	{
		return selected_country.getText();
	}
	
	public List<String> getToolTips()
	{
		List <String> tool_tips_list = new ArrayList<String>();
		for(WebElement t : tool_tips)
		{
			Actions act = new Actions(driver);
			act.moveToElement(t);
			tool_tips_list.add(t.getText()+" - "+t.getAttribute("data-bs-original-title"));
		}
		return tool_tips_list;
	}
}
