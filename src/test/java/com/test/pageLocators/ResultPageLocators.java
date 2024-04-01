package com.test.pageLocators;

import org.openqa.selenium.By;

import com.test.utils.AppUtils;

public class ResultPageLocators extends AppUtils {

	public static By resultLabel = By.xpath("//h1[contains(text(),'Search results')]");
	
	
}
