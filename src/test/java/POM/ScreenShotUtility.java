package POM;
import java.io.File;
import java.io.IOException;

import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenShotUtility extends BeforeSuiteDemoTEst {
	
	public void Screenhot() throws IOException{
		
		Date currentdate = new Date();
		String scrName = currentdate.toString().replace(" ", "-").replace(":", "-");
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(".//screenshot//"+scrName+".png"));

}
}
