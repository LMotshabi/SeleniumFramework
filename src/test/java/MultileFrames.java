

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultileFrames {
	
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
		driver.findElement(By.xpath("//a[@aria-label='Start my free sales trial ']")).click();
		
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		
		String parentwindow = iterator.next();
		String child = iterator.next();
		
		driver.switchTo().window(child);
		Thread.sleep(3000);
		driver.findElement(By.name("UserFirstName")).sendKeys("Lemo");
		Thread.sleep(3000);
		driver.switchTo().window(child).close();
		
		driver.switchTo().window(parentwindow);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@aria-label='Watch Demos']")).click();
		
		driver.getWindowHandle();
		String child1 = iterator.next();
		driver.switchTo().window(child1);
		//driver.switchTo().window(child1).close();
		Thread.sleep(3000);
		
		driver.findElement(By.name("UserFirstName")).sendKeys("Lemo2");
		Thread.sleep(3000);
		
		driver.switchTo().window(child);
		driver.findElement(By.name("UserLastName")).sendKeys("Lemo3");
		Thread.sleep(3000);
		
		driver.switchTo().window(parentwindow);
		Thread.sleep(3000);
		
		driver.close();
	}
	
	}


