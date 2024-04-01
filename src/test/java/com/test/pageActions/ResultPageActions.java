package com.test.pageActions;

import org.openqa.selenium.WebDriver;

import com.test.pageLocators.ResultPageLocators;

public class ResultPageActions extends ResultPageLocators {

	public ResultPageActions(WebDriver driver) {
		this.driver = driver;
	}

	public ResultPageActions() {

	}

	/**
	 * @param value
	 */
	public void validateResultLabel(String value) {
		String valueToAssert = doGet(resultLabel);
		aTC(valueToAssert, value, "Value mismatches in Search");
	}

}
