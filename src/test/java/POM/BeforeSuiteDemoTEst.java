package POM;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BeforeSuiteDemoTEst {
	
	public static String browser = "chrome";
	public static WebDriver driver;
	
	//@Parameters({"browse"})
	
	@BeforeSuite
	public void Setup() {
		
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
	
	driver.get("https://www.facebook.com/");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

}
}
