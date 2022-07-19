package com.sg.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoTest {

	@DataProvider
	public Object[][] validData() {
		Object[][] main = new Object[4][2];
		// i--> number of testcase
		// j--> number of arguments/parameters

		main[0][0] = "peter";
		main[0][1] = "peter123";

		main[1][0] = "mark";
		main[1][1] = "mark123";

		main[2][0] = "king";
		main[2][1] = "king123";
		
		main[3][0]="bala";
		main[3][1]="bala123";

		return main;
	}

	@Test(dataProvider = "validData")
	public void validTest(String username, String password) {
		System.out.println("Valid Test" + username + password);
	}

}
