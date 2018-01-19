package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import pageObjects.ElementGCPI;

public class ExcelDriven extends Base{
	
	public static FileInputStream fis;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static String getCellData(int rowNum, int cellNum) throws IOException{
		fis = new FileInputStream(prop.getProperty("excelfile"));
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet("script");
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		String value = cell.getStringCellValue();
		
		return value;
		
	}
	
	public static String setCellData(String text, int rowNum, int cellNum) throws IOException{
		fis = new FileInputStream(prop.getProperty("excelfile"));
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet("script");
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		// set the value in the excelsheet
		cell.setCellValue(text);
		
		FileOutputStream fos = new FileOutputStream(prop.getProperty("excelfile"));
		wb.write(fos);
		fos.close();
		
		return cell.getStringCellValue();
	}
	
	public static void iterateCellContents() throws IOException{
		fis = new FileInputStream(prop.getProperty("excelfile"));

		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet("script");
		//row = sheet.getRow(rowNum);
		//cell = row.getCell(cellNum);
		DataFormatter formatter = new DataFormatter();
	    //Sheet sheet1 = wb.getSheetAt(0);
	    for (Row row : sheet) {
	        for (Cell cell : row) {
	            CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
	            System.out.print(cellRef.formatAsString());
	            System.out.print(" - ");

	            // get the text that appears in the cell by getting the cell value and applying any data formats (Date, 0.00, 1.23e9, $1.23, etc)
	            String text = formatter.formatCellValue(cell);
	            System.out.println(text);

	            // Alternatively, get the value and format it yourself
	            switch (cell.getCellType()) {
	            
	                case 1:  // CellType.STRING
	                    System.out.println(cell.getRichStringCellValue().getString());
	                    break;
	                case 0:  // CellType.NUMERIC:
	                    if (DateUtil.isCellDateFormatted(cell)) {
	                        System.out.println(cell.getDateCellValue());
	                    } else {
	                        System.out.println(cell.getNumericCellValue());
	                    }
	                    break;
	                case 4:  // CellType.BOOLEAN:
	                    System.out.println(cell.getBooleanCellValue());
	                    break;
	                case 2:  //  CellType.FORMULA:
	                    System.out.println(cell.getCellFormula());
	                    break;
	                case 3:   // CellType.BLANK:
	                    System.out.println();
	                    break;
	                default:
	                    System.out.println();
	            }
	        }
	    }
		
	}

}
