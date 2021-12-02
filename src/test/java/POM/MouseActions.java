package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseActions {

	public static String browser = "chrome";
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		

		
		
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
		
		driver.get("https://www.salesforce.com/eu/");
		driver.manage().window().maximize();
		
		WebElement Products = driver.findElement(By.id("products_menu_item"));
		
		Actions action = new Actions(driver);
		action.moveToElement(Products).perform();
		
		driver.findElement(By.xpath("//*[@id=\"drawer_products\"]/div/div/div[1]/ul/li/div/ul/li[1]/a")).click();
		
		

}
}
