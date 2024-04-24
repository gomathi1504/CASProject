package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OneCognizantPage extends BasePage
{	
	public OneCognizantPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='oneC_searchAutoComplete']")
	WebElement searchBoxChrome;
	
	@FindBy(xpath="//input[@id = 'oneCSearchTop']")
	WebElement searchBoxEdge;
	
	@FindBy(xpath="//div[text()='Live Support - GSD']")
	WebElement gsd;
	
	@FindBy(xpath="//ul[@class = 'searchBasedTopBar']/li")
	WebElement icon_search;
	
	public void clickSearchChrome(String search)
	{
		searchBoxChrome.sendKeys(search);
	}
	
	public void clickSearchEdge(String search)
	{
		searchBoxEdge.sendKeys(search);
	}
	
	public void clickGSD() throws InterruptedException
	{
		Thread.sleep(3000);
		gsd.click();
	}
	
	public void clickSearchIcon() 
	{
		icon_search.click();
	}
}
