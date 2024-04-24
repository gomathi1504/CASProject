package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(id="O365_UniversalMeContainer")
	WebElement user;
	
	@FindBy(id="mectrl_currentAccount_primary")
	WebElement user_name;
	
	@FindBy(id="mectrl_currentAccount_secondary")
	WebElement user_email;
	
	@FindBy(xpath="//div[@title='OneCognizant']")
	WebElement one_cognizant;
	
	public void clickUser() throws InterruptedException 
	{
		Actions act = new Actions(driver);
		act.click(user).perform();
		Thread.sleep(2000);
		act.doubleClick(user).perform();
	}
	
	public String getUserName()
	{
		return user_name.getText();
	}
	
	public String getUserEmail()
	{
		return user_email.getText();
	}
	
	public void clickOneCognizant() throws InterruptedException
	{
		one_cognizant.click();
	}
}
