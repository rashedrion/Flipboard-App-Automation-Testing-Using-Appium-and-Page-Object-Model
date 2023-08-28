package com.ebrahim.mobile.automation.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class CommonUtils {

	public static AppiumDriver<MobileElement> driver;
	public static URL serverUrl;
	public static DesiredCapabilities capabilities = new DesiredCapabilities();
	public static String APPIUM_PORT;
	public static int IMPLICIT_WAIT_TIME;
	public static int EXPLICIT_WAIT_TIME;
	public static String BASE_PKG;
	public static String APP_ACTIVITY;
	public static String APP_PATH;
	public static String BROWSER_NAME;
	public static String PLATFORM_NAME;
	public static String PLATFORM_VERSION;
	public static String DEVICE_NAME;
	public static String UDID;
	public static String BUNDLE_ID;
	public static String APP;

	public static Properties prop = new Properties();
	private static FileInputStream fis;

	public static void loadAndroidConfProp(String loadPropertyFile) {
		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/properties/" + loadPropertyFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		IMPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("implicit.wait"));
		EXPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("explicit.wait"));
		BASE_PKG = prop.getProperty("base.pgk");
		APP_ACTIVITY = prop.getProperty("application.activity");
		APP_PATH = prop.getProperty("application.path");
		BROWSER_NAME = prop.getProperty("browser.name");
		PLATFORM_NAME = prop.getProperty("platform.name");
		DEVICE_NAME = prop.getProperty("device.name");
		APPIUM_PORT = prop.getProperty("appium.server.port");
		PLATFORM_VERSION = prop.getProperty("platform.version");

	}

	public static void setAndroidCapabilities() {

		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, BASE_PKG);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, APP_ACTIVITY);

	}

	public static void loadIOSConfProp(String loadPropertyFile) {
		// TODO Auto-generated method stub

	}

	public static void setIOSCapabilities() {

	}

	public static AppiumDriver<MobileElement> getAndroidDriver() {
		try {
			serverUrl = new URL("http://localhost:" + APPIUM_PORT + "/wd/hub");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver = new AndroidDriver<MobileElement>(serverUrl, capabilities);
		return driver;
	}

	public static AppiumDriver<MobileElement> getIOSDriver() {

		return driver;
	}
}
