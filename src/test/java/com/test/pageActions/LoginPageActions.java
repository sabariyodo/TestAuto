package com.test.pageActions;

import org.openqa.selenium.WebDriver;

import com.test.pageLocators.LoginPageLocators;

public class LoginPageActions extends LoginPageLocators {

	public LoginPageActions(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPageActions() {

	}
}
