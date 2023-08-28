package com.ebrahim.mobile.automation.base;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.ebrahim.mobile.automation.utilities.AppiumServer;
import com.ebrahim.mobile.automation.utilities.CommonUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TestBase {

	public AppiumDriver<MobileElement> driver;
	public static String LoadPropertyFile = "Android_flipboard.properties";
	public static Logger log = Logger.getLogger(TestBase.class);

	public void setUp() {
		if (driver == null) {
			PropertyConfigurator.configure(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\log4j.properties");

			if (LoadPropertyFile.startsWith("Android_")) {
				AppiumServer.start();
				log.info("Appium server started.");
				
				CommonUtils.loadAndroidConfProp(LoadPropertyFile);
				log.info(LoadPropertyFile + "property file loaded");
				
				CommonUtils.setAndroidCapabilities();
				driver = CommonUtils.getAndroidDriver();

			} else if (LoadPropertyFile.startsWith("IOS_")) {
				
				

			}
		}
	}

	public void quit(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
		log.info("Test case execution complete");
		AppiumServer.stop();
		log.info("Appium server stoped!!");
	}
}
