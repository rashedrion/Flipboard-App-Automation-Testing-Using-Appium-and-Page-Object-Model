package com.ebrahim.mobile.automation.utilities;

import java.io.File;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumServer {

	public static AppiumDriverLocalService service;
	
	public static void start() {
		service = AppiumDriverLocalService.buildService(
				new AppiumServiceBuilder().usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
				.withAppiumJS(new File("C:\\Program Files\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"))
				.withLogFile(new File(System.getProperty("user.dir")+"\\\\src\\\\test\\\\resources\\\\properties\\\\log4j.properties"))
				.withArgument(GeneralServerFlag.LOCAL_TIMEZONE));
		service.start();
	}
	
	public static void stop() {
		service.stop();
	}
}
