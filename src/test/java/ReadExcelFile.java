import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class ReadExcelFile {

	public static void main(String[] args) throws IOException {
		
		File file = new File(System.getProperty("user.dir")+"/src/test/resources/excelfiles/excelFile.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		Sheet sheet1 = wb.getSheetAt(0);
		
		Row row1 = sheet1.getRow(0);
		Cell cell1 = row1.getCell(0);
		//System.out.println(cell1);
		
		for(Row row:sheet1 ) {
			for(Cell cell:row) {
				switch(cell.getCellType())
				{
				case STRING: System.out.print(cell.getRichStringCellValue()+ "\t");
				break;
				case BOOLEAN: System.out.print(cell.getBooleanCellValue()+ "\t");
				break;
				case BLANK: System.out.print("Blank cell" + "\t");
				break;
				case NUMERIC: System.out.print(cell.getNumericCellValue()+ "\t");
				default:
				break;
				}
			}
			System.out.println();
		}
		
		fis.close();
	}

}
