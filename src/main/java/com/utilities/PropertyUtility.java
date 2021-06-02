package com.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtility {
	public String getproperty(String key) {

		Properties property = PropertyUtility.loadPropertiFile();
		return (String) property.get(key);
	}

	private static Properties loadPropertiFile() {
		FileInputStream fs = null;
		String path = System.getProperty("user.dir");
		try {
			fs = new FileInputStream(path + "\\src\\main\\resources\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prop;

	}
}
