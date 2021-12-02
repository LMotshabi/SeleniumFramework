import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assertions {
	
	public static String browser = "chrome";
	public static WebDriver driver;
	
	@Test 
public void Title()

{
		
		SoftAssert softassert = new SoftAssert();
	if (browser.equals("chrome"))
	{
WebDriverManager.chromedriver().setup();
 driver = new ChromeDriver();
	}
	else if (browser.equals("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		 driver = new FirefoxDriver();
	}
	
	else if (browser.equals("ie"))
	{
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
		
	}
	
	else if (browser.equals("edge"))
	{
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}
	
	driver.get("https://www.investing.com/");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	String ExpectedTitle = "Investing.com - Stock Market Quotes & Financial Newsq";
	String actualTitle = driver.getTitle();
	
	softassert.assertEquals(ExpectedTitle, actualTitle);
	
	softassert.assertAll();
}
	
}
