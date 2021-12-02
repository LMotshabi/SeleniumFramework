import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptEx {
	public static String browser = "chrome";
	public static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stubpublic static String browser = "chrome";
		
		
	
		
		if (browser.equals("chrome"))
		{
	WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
		}
		else if (browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		}else if (browser.equals("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}else if (browser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.get("https://www.investing.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		
		if (driver.findElement(By.xpath("//*[@id=\"loginPopup\"]")).isDisplayed())
		{
			driver.findElement(By.xpath("//*[@id=\"loginPopup\"]/div[1]/span/i")).click();
			
			
		}else if(driver.findElement(By.xpath("//*[@id=\\\"PromoteSignUpPopUp\\\"]")).isDisplayed())
		{
			driver.findElement(By.xpath("//*[@id=\"PromoteSignUpPopUp\"]/div[2]/i")).click();
		}
		
		JavascriptExecutor jsexec = (JavascriptExecutor) driver;
		System.out.println(jsexec.executeScript("return document.title;"));
		
		jsexec.executeScript("overlay.overlayLogin();");
		
		
	}
	
	
	
	
	

}
