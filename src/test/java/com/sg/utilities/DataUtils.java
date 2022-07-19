package com.sg.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataUtils {
	
	@DataProvider
	public Object[][] validCredentialData()
	{
		Object[][] main=new Object[2][3];
		main[0][0] = "Admin";
		main[0][1] = "admin123";
		main[0][2] = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";

		main[1][0] = "Admin";
		main[1][1] = "admin123";
		main[1][2] = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";

		return main;
	}
	
	@DataProvider
	public Object[][] invalidCredentialData() throws IOException {
		
		Object[][] main= ExcelUtils.getSheetIntoTwoDimArray("testdata/orange_testdata.xlsx", "invalidCredentialTest");
		return main;
	}

//	@DataProvider
//	public Object[][] invalidCredentialData() {
//		Object[][] main = new Object[2][3];
//
//		main[0][0] = "Peter";
//		main[0][1] = "Peter123";
//		main[0][2] = "Invalid credentials";
//
//		main[1][0] = "john";
//		main[1][1] = "john123";
//		main[1][2] = "Invalid credentials";
//
//		return main;
//	}
}
