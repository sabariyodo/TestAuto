package com.test.testModules;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.pageActions.HomePageActions;
import com.test.pageActions.ResultPageActions;

public class HomePageTest extends HomePageActions {

	@BeforeTest
	public void initMethod() throws FileNotFoundException {
		driver = getDriver();
		navigateTo(getProperty("url"));
		result=new ResultPageActions(driver);
	}

	@Test
	public void validateSearch() {
		String valueToSearch="Hello";
		searchOpenAI(valueToSearch);
		result.validateResultLabel(valueToSearch);
	}
	
	

	@AfterTest
	public void wrapMethod() {
		driver.close();
		System.out.println(driver);
	}

}
