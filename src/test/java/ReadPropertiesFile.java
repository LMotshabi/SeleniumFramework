import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadPropertiesFile {
	
		public static WebDriver driver;
	public static void main(String[] args) throws IOException {
		
		Properties pro = new Properties();
		FileInputStream inpulFile = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/data.properties");
		pro.load(inpulFile);
		
		String  Browser = pro.getProperty("browser");
		
		
		if (Browser.equals("chrome"))
		{
	WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
		}
		else if (Browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		}else if (Browser.equals("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}else if (Browser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		
		
	}

}
