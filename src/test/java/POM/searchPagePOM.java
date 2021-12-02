package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class searchPagePOM {
	
	private static WebElement element=null;
	 
	public   WebElement searchbox( WebDriver driver)
	{
		 element= driver.findElement(By.name("q"));
		return element;
		
		
	}
	
	public WebElement SearchButton(WebDriver driver) 
	{
		 element= driver.findElement(By.name("btnK"));
		return element;
	}

}
