package POM;

import org.testng.annotations.DataProvider;

public class Data {
	
	
	@DataProvider(name = "data1")
	public Object[][] FacebookData()
	{
		return new Object[][]
				{
						{"Lerato", "Motshabi"}
						
				};
	}

}
