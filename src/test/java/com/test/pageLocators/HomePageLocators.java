package com.test.pageLocators;

import org.openqa.selenium.By;

import com.test.utils.AppUtils;

public class HomePageLocators extends AppUtils {

	public static By tryGptLink = By.xpath("//ul[@aria-labelledby='quicklinksHeading']//a[@aria-label='Try ChatGPT']");
	public static By searchLink=By.xpath("//div[@class='container']//button[@aria-label='Search']");
	public static By searchBtn=By.xpath("//button[@aria-label='Search' and @type='submit']");
	public static By searchTxtField=By.xpath("//div[@aria-hidden='false']//input[@placeholder='Search for anything']");
}
