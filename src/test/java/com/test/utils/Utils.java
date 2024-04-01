package com.test.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.base.BaseClass;

public class Utils extends BaseClass {

	public void waitForElement(By by) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.visibilityOfElementLocated(by));

	}

	
	/**
	 * @param by
	 * @param action
	 */
	public void handleJsAction(By by, String action) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		switch (action) {
		case Constants.JSCLICK:

			executor.executeScript("arguments[0].click();", element(by));
			break;

		case Constants.JSSCROLL:
			executor.executeScript("arguments[0].scrollIntoView(true);", element(by));
			break;

		}
	}

	/**
	 * @param by
	 * @param actionName
	 */
	public void handleActions(By by, String actionName) {
		Actions act = new Actions(driver);
		switch (actionName) {
		case Constants.HOVER:
			act.moveToElement(element(by)).perform();
			break;
		case Constants.DOUBLECLICK:
			act.doubleClick(element(by)).perform();
			break;
		case Constants.RIGHTCLICK:
			act.contextClick(element(by)).perform();
			break;

		}
	}

	/**
	 * @param by
	 * @return
	 */
	public WebElement element(By by) {
		try {
			waitForElement(by);

		} catch (Exception e) {// Exception finding element
			e.getStackTrace();
		}
		return driver.findElement(by);
	}

	
	/**
	 * @param by
	 * @param param
	 * @return
	 */
	public String doGet(By by, String... param) {
		String value = null;
		if (param.length == 0) {
			value = element(by).getText();
		} else {
			value = element(by).getAttribute(param[0]);
		}
		return value;

	}

	/**
	 * @param url
	 */
	public void navigateTo(String url) {
		driver.get(url);
	}
	
	/**
	 * @param url
	 */
	public String getCurrentUrl() {
		
	return	driver.getCurrentUrl();
		}

	private void createDirectory(String directory) {
		File dir = new File(directory);
		if (!dir.exists()) {
			dir.mkdir();
		}
	}

	public void takeScreenshot() {
		// Convert WebDriver object to TakesScreenshot
		String fileName = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		TakesScreenshot screenshot = (TakesScreenshot) driver;

		// Capture screenshot as file
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

		// Specify the destination directory
		String directory = System.getProperty("user.dir") + "/src/test/resources/screenshots/";

		// Create directory if it doesn't exist
		createDirectory(directory);

		// Build the path for the screenshot file
		Path destinationPath = Paths.get(directory, fileName + ".png");

		try {
			// Copy the screenshot to the destination path
			Files.copy(srcFile.toPath(), destinationPath);
			System.out.println("Screenshot saved: " + destinationPath.toString());
		} catch (IOException e) {
			System.out.println("Failed to save screenshot: " + e.getMessage());
		}
	}

	/**
	 * @param by
	 * @param action
	 * @param keys
	 */
	public void doAct(By by, String action, String... keys) {
		switch (action) {
		case Constants.CLICK:
			element(by).click();
			break;
		case Constants.JSCLICK:
			handleJsAction(by, action);
			break;
		case Constants.SENDKEYS:
			if (keys.length > 0) {
				element(by).clear();
				element(by).sendKeys(keys[0]);
			}
			break;
		case Constants.HOVER:
			handleActions(by, action);
			break;
		case Constants.DOUBLECLICK:
			handleActions(by, action);
			break;
		case Constants.RIGHTCLICK:
			handleActions(by, action);
			break;
		case Constants.JSSCROLL:
			handleJsAction(by, action);
			break;
		}

	}

	/**
	 * @param propertyName
	 * @return
	 * @throws FileNotFoundException
	 */
	public String getProperty(String propertyName) throws FileNotFoundException {
		return Configurations.getProperty(propertyName);
	}

	public void updateProperty(String propertyName, String valueToUpdate) throws ConfigurationException, IOException {
		Configurations.updateProperty(propertyName, valueToUpdate);
	}
}