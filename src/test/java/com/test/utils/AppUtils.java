package com.test.utils;

import org.openqa.selenium.By;

public class AppUtils extends Assertions {

	
	public static String freeTrialCustom="//span[contains(text(),'Free Trial string1')]";
	public static String stockCustom="//span[contains(text(),'string1')]//ancestor::tr//td[5]";
	
	public By getDynamicXpath(String locator,String replacement)
	{
		return By.xpath(freeTrialCustom.replace("string1",replacement));
	}
}
