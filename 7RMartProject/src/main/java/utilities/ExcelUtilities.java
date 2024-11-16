package utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	static FileInputStream f;
	static XSSFWorkbook w;
	static XSSFSheet sh;
	public static String getStringData(int i, int j, String sheet) throws IOException { 
		String filepath=Constants.TESTDATAFILE; 
 		f=new FileInputStream(file_path); 
 		wb= new XSSFWorkbook(f); 
 		sh = wb.getSheet(sheet); 
 		Row r= sh.getRow(i); 
 		Cell c= r.getCell(j); 
 		return c.getStringCellValue(); 
 	}
	public static String getIntegerData(int i, int j, String sheet){
		String filepath=Constants.TESTDATAFILE; 
 		f=new FileInputStream(file_path); 
		wb=new XSSFWorkbook(f);
		sh=wb.getSheet("Sheet1");
		Row r=sh.getRow(row);
		Cell c=r.getCell(col);
		int val=(int)c.getNumericCellValue();
		return String.valueOf(val);
	}
	}
