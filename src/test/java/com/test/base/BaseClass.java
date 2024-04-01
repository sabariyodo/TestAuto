package com.test.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.test.pageActions.HomePageActions;
import com.test.pageActions.LoginPageActions;
import com.test.pageActions.ResultPageActions;
import com.test.utils.Configurations;

/**
 * Unit test for simple App.
 */
public class BaseClass {

	public WebDriver driver = null;
	public static String browser = null;
	public HomePageActions home=null;
	public LoginPageActions login=null;
	public ResultPageActions result=null;

	@BeforeSuite()
	public void initSuite() throws IOException {
		Configurations.setProps();
	}

	/**
	 * @throws FileNotFoundException
	 */
	public WebDriver getDriver() throws FileNotFoundException {
		browser = Configurations.getProperty("browser");
		switch (browser) {
		case "firefox":
			driver = new FirefoxDriver(getFireFoxOptions());
			break;

		case "chrome":
			driver = new ChromeDriver(getChromeOptions());
			break;
		}
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
		driver.manage().window().maximize();
		return driver;

	}

	/**
	 * @return
	 * @throws FileNotFoundException
	 */
	public ChromeOptions getChromeOptions() throws FileNotFoundException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		return options;
	}

	/**
	 * @return
	 * @throws FileNotFoundException
	 */
	public FirefoxOptions getFireFoxOptions() throws FileNotFoundException {
		FirefoxOptions opt = new FirefoxOptions();
		opt.addArguments("--start-maximized");
		return opt;
	}

	@AfterSuite()
	public void wrapSuite() {
		System.out.println(driver);
		
		try{if(driver!=null)
		{
		driver.quit();
		}
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
	}

}
