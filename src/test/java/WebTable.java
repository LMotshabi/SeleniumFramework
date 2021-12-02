import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {
	
		public static String browser = "chrome";
		public static WebDriver driver;
		
	public static void main(String[] args) {
		
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
		
		driver.findElement(By.xpath("//*[@id=\"PromoteSignUpPopUp\"]")).isDisplayed();
		
		if (driver.findElement(By.xpath("//*[@id=\"PromoteSignUpPopUp\"]")).isDisplayed())
		{
			driver.findElement(By.xpath("//*[@id=\"PromoteSignUpPopUp\"]/div[2]/i")).click();
		}
		
		List<WebElement> row = driver.findElements(By.xpath("//*[@id=\"leftColumn\"]/div[1]/div[4]/table/tbody/tr"));
		List<WebElement> col = driver.findElements(By.xpath("//*[@id=\"leftColumn\"]/div[1]/div[4]/table/tbody/tr[1]/td"));
		
		//System.out.println("before"+driver.findElement(By.xpath("//*[@id=\"home_top_five\"]/div/div/div/div[1]/table/tbody/tr[1]/td")).getText()+"after");
		
		for(int i =1; i<=row.size();i++) {
			for(int j=1;j<=col.size();j++)
			{
				System.out.print(driver.findElement(By.xpath("//*[@id=\"leftColumn\"]/div[1]/div[4]/table/tbody/tr["+i+"]/td["+j+"]")).getText()+ " ");
			}
			System.out.println();
		}
		
		//*[@id="home_top_five"]/div/div/div/div[1]/table/tbody/tr
		
		//*[@id="home_top_five"]/div/div/div/div[1]/table/tbody/tr[1]/td

	}

}

