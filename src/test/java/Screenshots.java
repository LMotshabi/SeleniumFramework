
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshots {

	public static String browser = "chrome";
	public static WebDriver driver;
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {

			DesiredCapabilities handleSSL = new DesiredCapabilities();

		if (browser.equals("chrome"))
		{
	WebDriverManager.chromedriver().setup();
	handleSSL.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
	handleSSL.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	ChromeOptions  Coptions= new ChromeOptions();
	Coptions.merge(handleSSL);
	 driver = new ChromeDriver(Coptions);
		}
		else if (browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			handleSSL.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			handleSSL.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			FirefoxOptions ffOptions = new FirefoxOptions();
			ffOptions.merge(handleSSL);
			 driver = new FirefoxDriver(ffOptions);
		}else if (browser.equals("ie"))
		{
			WebDriverManager.iedriver().setup();
			handleSSL.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			handleSSL.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			InternetExplorerOptions ieOptions = new InternetExplorerOptions();
			ieOptions.merge(handleSSL);
			driver = new InternetExplorerDriver(handleSSL);
		}else if (browser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			
			handleSSL.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			handleSSL.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			EdgeOptions eOptions = new EdgeOptions();
			eOptions.merge(handleSSL);
			driver = new EdgeDriver(handleSSL);
		}
		
		driver.get("https://expired.badssl.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Date currentDate = new Date();
		String Date = currentDate.toString().replace(" ", "-").replace(":", "-");
		
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot/" + Date + ".png"));
	}

}
