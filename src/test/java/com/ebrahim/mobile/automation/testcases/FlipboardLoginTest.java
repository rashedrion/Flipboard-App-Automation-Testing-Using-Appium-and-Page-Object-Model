package com.ebrahim.mobile.automation.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ebrahim.mobile.automation.base.TestBase;
import com.ebrahim.mobile.automation.screens.ChooseTopisScreen;
//import com.ebrahim.mobile.automation.screens.ChooseTopisScreen;
import com.ebrahim.mobile.automation.screens.LoginScreen;
import com.ebrahim.mobile.automation.screens.SkipLogin;
import com.ebrahim.mobile.automation.utilities.ScrollUtil;

public class FlipboardLoginTest extends TestBase {

	LoginScreen login;
	ChooseTopisScreen topicscreen;
	SkipLogin skipLogin;
	
	@BeforeTest
	public void init() {
		setUp();
		login = new LoginScreen(driver);
		topicscreen =new ChooseTopisScreen(driver);
		skipLogin = new SkipLogin(driver);
	}
	
	@Test(priority = 1)
	public void validateGetStartedButton() throws InterruptedException {
		login.clickGetStartedBtn();
		Thread.sleep(4000);
	}
	
	@Test(priority = 2)
	public void chooseTopicsTest() {
		topicscreen.chooseTopics(4).clickContinue();
		//topicscreen.clickContinue();
	}
	
	@Test(priority = 3)
	public void skiLoginTest() throws InterruptedException {
		skipLogin.skipLoginBtn();
		Thread.sleep(3000);
		ScrollUtil.scrollUp(2, driver);
	}
	
	
	@AfterTest
	public void quitDriver() {
		quit();
	}
}
