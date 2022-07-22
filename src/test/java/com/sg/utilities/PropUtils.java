package com.sg.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropUtils {

	public static String getValueUsingKey(String filePath, String key) throws IOException {
		FileInputStream file = new FileInputStream(filePath);

		Properties prop = new Properties();
		prop.load(file);

		String value = prop.getProperty(key);

		return value;
	}

}
