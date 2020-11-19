/**
 * 
 */
package com.takeaway.codechallenge.core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.takeaway.codechallenge.utils.Constants;

/**
 * The Class SeleniumAPI.
 * 
 * @author suthir
 */
public class SeleniumAPI {

	/** The driver. */
	private static WebDriver driver = null;

	/**
	 * Instantiates a new selenium API.
	 */
	private SeleniumAPI() {
		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER);
		driver = new ChromeDriver();
	}

	public SeleniumAPI(WebDriver driver) {

	}

	/**
	 * Gets the driver.
	 *
	 * @return the driver
	 */
	public static WebDriver getDriver() {
		if (driver == null) {
			new SeleniumAPI();
		}
		return driver;
	}

	/**
	 * Checks if element is present in the web page.
	 * 
	 * @param by the by
	 * @return true, if element is present. false, if element is not present.
	 */
	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("SeleniumAPI.java: NoSuchElementException: Element is not present - " + e.getMessage());
			return false;
		}
	}

	/**
	 * Checks if element is displayed in the web page.
	 * 
	 * @param by the by
	 * @return true, if element is displayed false, if element is not displayed
	 */
	public boolean isDisplayed(By by) {
		try {
			driver.findElement(by).isDisplayed();
			return true;
		} catch (NoSuchElementException ex) {
			System.out
					.println("SeleniumAPI.java: NoSuchElementException: Element is not displayed - " + ex.getMessage());
			return false;
		}
	}

	/**
	 * Wait for presence of text in element.
	 * 
	 * @param by   the by locator
	 * @param text the text that needs to be present
	 */
	public void waitUntilPresenceOfTextInElement(By by, String text) {
		try {
			new WebDriverWait(driver, Constants.N10)
					.until(ExpectedConditions.textToBePresentInElementLocated(by, text));
		} catch (NoSuchElementException ex) {
			System.out.println("SeleniumAPI.java: NoSuchElementException: waitUntilPresenceOfTextInElement(By,String)");
			System.out.println("Presence of element Located by: " + by.toString());
		} catch (TimeoutException excTimeout) {
			System.out.println("SeleniumAPI.java: TimeoutException: waitUntilPresenceOfTextInElement(By,String)");
			System.out.println("Presence of element Located by: " + by.toString());
		}
	}

	/**
	 * Click if element is present else throw exception.
	 * 
	 * @param by - By param to click
	 */
	public void click(By by) {
		if (isElementPresent(by)) {
			// driver.findElement(by).click();
			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click()", driver.findElement(by));
			} catch (Exception ex) {
				System.out.println(driver.findElement(by));
			}
		} else {
			throw new NoSuchElementException("Element not found");

		}
	}

	/**
	 * Gets the page.
	 *
	 * @param url the url
	 * @return the page
	 */
	public String getPage(String url) {
		driver.manage().window().maximize();
		driver.get(url);
		return driver.getCurrentUrl();
	}

	/**
	 * Returns the text of the given locator.
	 * 
	 * @param by - By locator.
	 * @return String.
	 */
	public String getText(By by) {
		String value = null;
		if (isElementPresent(by)) {
			value = driver.findElement(by).getText().trim();
			return value;
		} else {
			System.out.println("SeleniumAPI.java: No such element exception to get text!");
			throw new NoSuchElementException("Element not found");
		}
	}

}
