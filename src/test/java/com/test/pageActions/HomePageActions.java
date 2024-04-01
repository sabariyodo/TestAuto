package com.test.pageActions;

import org.openqa.selenium.WebDriver;

import com.test.pageLocators.HomePageLocators;
import com.test.utils.Constants;

public class HomePageActions extends HomePageLocators{

	public HomePageActions(WebDriver driver) {
		this.driver = driver;
	}
	
	public HomePageActions() {
		
	}
	
	/**
	 * @param value
	 */
	public void searchOpenAI(String value)
	{
		doAct(searchLink,Constants.CLICK);
		doAct(searchTxtField,Constants.SENDKEYS,value);
		doAct(searchBtn,Constants.CLICK);
		
		
		
	}
}
