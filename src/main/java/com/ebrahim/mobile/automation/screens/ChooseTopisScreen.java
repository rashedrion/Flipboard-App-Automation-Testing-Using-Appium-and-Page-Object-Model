package com.ebrahim.mobile.automation.screens;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import com.ebrahim.mobile.automation.base.ScreenBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ChooseTopisScreen extends ScreenBase{

	@AndroidFindBy(id="flipboard.app:id/topic_picker_topic_row_topic_tag")
	public  List<AndroidElement> topic;
	
	@AndroidFindBy(id="flipboard.app:id/topic_picker_continue_button")
	public AndroidElement pickercontinuebutton;
	
	public ChooseTopisScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public ChooseTopisScreen chooseTopics(int topicsCount) {
		for (int i = 0; i < topicsCount; i++) {
			topic.get(i).click();
		}
		
		return this;
	}
	
	public void clickContinue() {
		pickercontinuebutton.click();
	}

}
