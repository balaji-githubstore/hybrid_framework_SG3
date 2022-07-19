package com.sg.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//will be deleted
public class ExcelDemo {

	public static void main(String[] args) throws IOException    {

		FileInputStream file = new FileInputStream("testdata/orange_testdata.xlsx");

		XSSFWorkbook book=new XSSFWorkbook(file);
		 
		XSSFSheet sheet= book.getSheet("invalidCredentialTest");
		
		int rowCount=sheet.getPhysicalNumberOfRows();
		int cellCount=sheet.getRow(0).getPhysicalNumberOfCells();
		
		DataFormatter format=new DataFormatter();
		
		Object[][] main=new Object[rowCount-1][cellCount];	
		
		for(int r=1;r<rowCount;r++)
		{
			for(int c=0;c<cellCount;c++)
			{
				String value =format.formatCellValue(sheet.getRow(r).getCell(c));
				System.out.println(value);
				main[r-1][c]=value;
			}
		}
		
		
		System.out.println(main);
		
		
		book.close();
		file.close();
	}

}
