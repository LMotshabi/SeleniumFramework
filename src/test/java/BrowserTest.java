import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import POM.searchPagePOM;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserTest {
	
	public static String browser = "chrome";
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		
		
		//System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+ "/src/main/resources/drivers/geckodriver.exe");
		
		
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
		
		
		
		
		driver.get("https://www.facebook.com/");
		//driver.get("https://materializecss.com/radio-buttons.html");
		
		String handler =driver.getWindowHandle();
		System.out.print(handler);
		
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		Thread.sleep(3000);
		WebElement seleted = driver.findElement(By.xpath("//*[@id=\"day\"]"));
		Select DropD = new Select(seleted);
		
		DropD.selectByIndex(5);
		//System.out.println(seleted.isSelected());
		
		//Thread.sleep(5000);
		//WebElement Deseleted = driver.findElement(By.xpath("//*[@id=\"radio\"]/form/p[1]/label/span"));
		
		//Deseleted.click();
		
		//System.out.println("is " + Deseleted.isSelected());
		
		//WebElement email = driver.findElement(By.name("email"));
				//email.sendKeys("lera@gmail.com");
				
		Thread.sleep(5000);
		
		//List<WebElement> alltags = driver.findElements(By.tagName("a"));
		
	//	for(int i=0;i<alltags.size();i++)
		//{
			//System.out.println("Link on page are " + alltags.get(i).getAttribute("href"));
		//}
		//driver.findElement(By.xpath("//a[@data-testid=\"open-registration-form-button\"]")).click();
		
		//WebElement dropD = driver.findElement(By.id("day"));
		//Select select = new Select(dropD);
		//select.selectByIndex(2);
		
		
		driver.close();
	
		
	}
	
	
	     }
	


