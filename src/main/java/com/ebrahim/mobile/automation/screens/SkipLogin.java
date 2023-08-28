package com.ebrahim.mobile.automation.screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.ebrahim.mobile.automation.base.ScreenBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SkipLogin extends ScreenBase{
	
	@AndroidFindBy(id="flipboard.app:id/account_login_buttons_skip")
	public WebElement skipButton;

	public SkipLogin(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void skipLoginBtn() {
		skipButton.click();
	}
	
}
