import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	public static void main(String[] args) throws IOException {
		XSSFWorkbook wk = new XSSFWorkbook();
		XSSFSheet sh = wk.createSheet("firstsheet");
		
		//Row row1 = sh.createRow(0);
		//Cell cellA = row1.createCell(0);
		//Cell cellB = row1.createCell(1);
		//Cell cellC = row1.createCell(2);
		
		//cellA.setCellValue("FirstName");
		//cellB.setCellValue("SecondName");
		//cellC.setCellValue("Email");
		
		for(int rows=0;rows<10;rows++) {
			Row row1 = sh.createRow(rows);
			for(int cell=0;cell<10;cell++)
			{
				Cell cellA = row1.createCell(cell);
				cellA.setCellValue((int)(Math.random()*100));
			}
		}
		
	File file = new File(System.getProperty("user.dir")+"/src/test/resources/excelfiles/excelFile.xlsx");
	FileOutputStream fo = new FileOutputStream(file);
	wk.write(fo);
	System.out.println("excel file creataed");
	fo.close();	
	}

}
