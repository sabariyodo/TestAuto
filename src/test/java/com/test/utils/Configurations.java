//$Id$
package com.test.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;



public class Configurations {

	private static Properties prop = null;

	/**
	 * @Desc Sets the Properties into Prop
	 * @throws IOException
	 */
	public static synchronized void setProps() throws IOException {
		prop = new Properties();
		InputStream input = null;
		input = new FileInputStream(new File("./src/test/resources/testResources/config.properties"));
		prop.load(input);
	}

	public static synchronized void updateProperty(String key, String propertyName)
			throws IOException, ConfigurationException {
		PropertiesConfiguration config = new PropertiesConfiguration(
				new File("./src/test/resources/testResources/config.properties").getAbsolutePath());
		config.setProperty(key, propertyName);
		config.save();
		setProps();
	}

	/**
	 * @Desc get #Var the Property from Config file
	 * @param propertyName
	 * @return Matching property value
	 * @throws FileNotFoundException
	 */
	public static synchronized String getProperty(String propertyName) throws FileNotFoundException {
		return prop.getProperty(propertyName);
	}



}
