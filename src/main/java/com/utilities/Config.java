package com.utilities;

import org.apache.log4j.Logger;

import com.customException.UnableToGetBrowserException;
import com.customException.UnableToGetURLException;

public class Config {
	private PropertyUtility prop = new PropertyUtility();
	private static final Logger LOG = Logger.getLogger(Config.class);

	public String getBrowserName() {
		String browser = null;
		try {
			browser = prop.getproperty("browserName");
			LOG.info("Getting " + browser + " browser ");
		} catch (Exception e) {
			LOG.error("Unable to get Browsername from Property file ");
			throw new UnableToGetBrowserException();
		}
		return browser;

	}

	public String getUrl() {
		String url = null;

		String env = System.getProperty("env");
		if (env == null || env.isEmpty()) {
			LOG.error("Please Specify Environment name by property  - Denv ");

			throw new com.customException.InvalidEnvironementException();
		}

		/*
		 * url = getValue("Application.properties", "application."+env+".url");
		 * //System.out.println("Url is : " + url);
		 * 
		 */
		try {
			url = prop.getproperty("app-" + env + "-url");
			LOG.info("Getting url as :  " + url);

		} catch (Exception e) {
			LOG.error("Unable to get URL from Property File");
			throw new UnableToGetURLException();
		}
		return url;
	}

}
