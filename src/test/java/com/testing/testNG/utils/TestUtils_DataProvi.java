package com.testing.testNG.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.testng.annotations.DataProvider;

public class TestUtils_DataProvi {

	Properties prop;
	public Properties readProp() throws IOException {
		FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
	prop = new Properties();
	prop.load(fis);
	return prop;
	}
	
	@DataProvider
	public Object[][] readExcelData (String sheetName) throws IOException{
		FileInputStream fis = new FileInputStream("src/test/resources/ExcelTestData.xls");
		DataFormatter formatter = new DataFormatter();
		HSSFWorkbook book = new HSSFWorkbook(fis);
		HSSFSheet sheet = book.getSheet(sheetName);
		HSSFRow hrow = sheet.getRow(0);
		int rows = sheet.getPhysicalNumberOfRows();
		int columns = hrow.getLastCellNum();
		
		Object testData[][] = new Object[rows-1][columns];
		
		for(int i=0; i<rows-1; i++) {
			HSSFRow row = sheet.getRow(i+1);
			for(int j=0; j<columns; j++) {
				if(row == null) {
					testData[i][j] ="";
				}else {
					HSSFCell cell = row.getCell(j);
				if(cell == null) {
					testData[i][j] ="";
				}else {
					String value = formatter.formatCellValue(cell);
					testData[i][j] = value;
					
				}
				}
			}
		}
		return testData;
	}
}