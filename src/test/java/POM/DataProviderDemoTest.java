package POM;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;



public class DataProviderDemoTest extends BeforeSuiteDemoTEst  {
	
	
	
	@Test(dataProvider = "data1",dataProviderClass=Data.class)
	public void Name(String name, String Surname) throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(name);
		Thread.sleep(3000);
		
		//driver.findElement(By.xpath("//*[@id=\"u_3_b_FF\"]")).sendKeys(name);
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(Surname);
		
		
		
	}
	
	@Test
	public void Fails()
	{
		
		Assert.assertTrue(false);
	}
	

}
