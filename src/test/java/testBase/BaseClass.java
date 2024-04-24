package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import pageObjects.GSDPage;
import pageObjects.HomePage;
import pageObjects.OneCognizantPage;

public class BaseClass 
{
	public static WebDriver driver;
	public static FileInputStream file;
	public static Properties p = new Properties();
	public static Logger logger;
	public static HomePage hp;
	public static OneCognizantPage op;
	public static GSDPage gp;
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browserName)
	{
		//Browser
		switch(browserName.toLowerCase()) 
		{
			case "chrome": driver=new ChromeDriver(); break;
			case "edge": driver=new EdgeDriver(); break;
			case "firefox": driver=new FirefoxDriver(); break;
			default : System.out.println("No matching browser"); return;
		}
		//loading properties file
		try
		{
			file = new FileInputStream("C:\\Users\\2318582\\eclipse-workspace\\CASProject\\src\\test\\resources\\config.properties");
			p.load(file);
		}
		catch(Exception e)
		{
			System.out.println("File not Found");
		}
		
		driver.get(p.getProperty("baseUrl"));
		driver.manage().window().maximize();
		
		//Adding implicit wait condition
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//loading log4j 
		logger=LogManager.getLogger(this.getClass());//Log4j
		logger.info("-----------Driver setup done with "+browserName+" browser------------------");
	}
	
	@AfterTest
	public void tearDown()
	{
		logger.info("----------Driver Closed---------------");
		driver.quit();
	}
	
	//Screensot
	public String captureScreen(String tname) throws IOException 
	{
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);		
		sourceFile.renameTo(targetFile);			
		return targetFilePath;
	}
}
