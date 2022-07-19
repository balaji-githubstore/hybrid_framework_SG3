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
		
		DataFormatter format=new DataFormatter();
		
		Object[][] main=new Object[3][3];	
		
		for(int r=1;r<4;r++)
		{
			for(int c=0;c<3;c++)
			{
				String value =format.formatCellValue(sheet.getRow(r).getCell(c));
				System.out.println(value);
				main[r-1][c]=value;
			}
			System.out.println("----------------------");
		}
		
		
		
		
		
		book.close();
		file.close();
	}

}
