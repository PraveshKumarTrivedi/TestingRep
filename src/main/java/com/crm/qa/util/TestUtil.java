package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public static long PAGE_LONG_TIMEOUT = 50;
	public static long IMPLICT_WAIT = 30;
	
	public static String TESTSHEET_DATA_PATH = "D:/newworkspace/FreeCRMTest/src/main/java/com/rcm/qa/testdata/FreeCRMData.xlsx";
	
	public static Sheet sheet;
	public static Workbook book;
	public static Object[][] getTestData(String sheetName)
	{
		FileInputStream file = null;
		
		try {
			file = new FileInputStream(TESTSHEET_DATA_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			try {
				book = WorkbookFactory.create(file);
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sheet = book.getSheet(sheetName);
			Object[][]data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
			for(int i=0;i<sheet.getLastRowNum();i++)
			{
				for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
				{
					data[i][j]= sheet.getRow(i+1).getCell(j).toString();
				}
			}
			return data;	
	}
	
	public static void takeScreenshotAtEndOfTest()throws IOException
	{
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(srcFile, new File(currentDir + "/screenshots" + System.currentTimeMillis()+".png"));
	}
}
