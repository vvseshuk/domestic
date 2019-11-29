package com.care.domestic.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtility {
	
	public static String getPopertyFromConfig(String propertyFile, String propertName) {
		String propertyValue = null;
		Properties props;
		try {
			String projectPath = System.getProperty("user.dir") + File.separator;
			String propertyFilePath = projectPath + File.separator + "src" + File.separator + "main"
					+ File.separator + "resources" + File.separator + "properties" + File.separator + propertyFile + ".properties";
			props = new Properties();
			props.load(new FileInputStream(propertyFilePath));
			propertyValue = props.getProperty(propertName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return propertyValue;
	}

	public static Properties getAllPoperties(String propertyFile) {
		Properties props = null;
		try {
			String projectPath = System.getProperty("user.dir") + File.separator;
			String propertyFilePath = projectPath + File.separator + "src" + File.separator + "main"
					+ File.separator + "resources" + File.separator + "properties" + File.separator + propertyFile + ".properties";
			props = new Properties();
			props.load(new FileInputStream(propertyFilePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return props;
	}
}
