package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static FileInputStream fis;

	public static FileOutputStream fos;
	
	private static XSSFSheet sheet;

	private static XSSFWorkbook workbook;

	public static void openExcel(String sheetName) {

		try {
			fis = new FileInputStream("C://Users//Admin//workspace//SeleniumTraining//src//test//java//TestData//GmailLoginData1.xlsx");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = workbook.getSheet(sheetName);
	//	System.out.println("Hurray! reached the sheet");

	}

	
	
	  public static Object[][] getTableArray()
	  throws Exception {
		  {
	  String[][] tabArray = null;
	  int rowCount = sheet.getLastRowNum();
	  System.out.println("RowCount is  "+rowCount);
	  int colCount = sheet.getRow(0).getLastCellNum();
	  System.out.println("ColCount is  "+colCount);
	  
	  tabArray = new String[rowCount+1][colCount];
	  
	  for(int i=0;i<tabArray.length;i++){
		  for(int j=0;j<tabArray[0].length;j++){  
			String value = sheet.getRow(i).getCell(j).getStringCellValue();
			tabArray[i][j]=value;
		//	System.out.println("Value of  "+ tabArray[i][j] );
             
		  }}
	  return tabArray;
	  }
	  
	  }
public static void main(String[] args){
		openExcel("Sheet1");
		try {
			getTableArray();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}  
}
