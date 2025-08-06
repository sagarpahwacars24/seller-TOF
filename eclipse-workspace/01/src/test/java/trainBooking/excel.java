package trainBooking;



import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel {
	 private static String filePath = "test-output/data.xlsx";

	    public static void writeToExcel(String sheetName, String data, int rowNum, int colNum) throws IOException {
	        XSSFWorkbook workbook = new XSSFWorkbook();
	        XSSFSheet sheet = workbook.createSheet(sheetName);
	        XSSFRow row = sheet.createRow(rowNum);
	        Cell cell = row.createCell(colNum);
	        cell.setCellValue(data);
	        
	        FileOutputStream fileOut = new FileOutputStream(filePath);
	        workbook.write(fileOut);
	        fileOut.close();
	        workbook.close();
	    }
	}


