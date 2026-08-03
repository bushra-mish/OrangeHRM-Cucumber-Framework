package com.qa.hrm.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Encapsulated configuration reader. The underlying Properties object is
 * private — consumers call {@link #readProperties(String)} once at startup,
 * then {@link #getProperty(String)} to retrieve values.
 */
public class ConfigsReader {

	private static Properties prop;

	public static void readProperties(String filePath) {
		try (FileInputStream fis = new FileInputStream(filePath)) {
			prop = new Properties();
			prop.load(fis);
		} catch (IOException e) {
			throw new RuntimeException("Cannot read config at: " + filePath
					+ ". Copy the .template file and fill in your settings.", e);
		}
	}

	public static String getProperty(String key) {
		if (prop == null) {
			throw new IllegalStateException("Properties not loaded — call readProperties() first.");
		}
		return prop.getProperty(key);
	}

}
