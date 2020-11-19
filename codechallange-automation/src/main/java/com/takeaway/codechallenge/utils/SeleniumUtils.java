/**
 * 
 */
package com.takeaway.codechallenge.utils;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.takeaway.codechallenge.core.SeleniumAPI;

// TODO: Auto-generated Javadoc
/**
 * The Class SeleniumUtils.
 * 
 * @author suthir
 */
public class SeleniumUtils {

	/**
	 * Instantiates a new selenium utils.
	 */
	public SeleniumUtils() {
		SeleniumAPI.getDriver();
	}

	/**
	 * Wait until presence of element.
	 * 
	 * @param driver the driver
	 * @param by     the by
	 */
	public void waitUntilPresenceOfElement(By by) {
		try {
			new WebDriverWait(SeleniumAPI.getDriver(), Constants.N10)
					.until(ExpectedConditions.presenceOfElementLocated(by));
		} catch (NoSuchElementException ex) {
			System.out.println(ex.getMessage());
		}
	}

	/**
	 * Sets the text.
	 *
	 * @param xpath the xpath
	 * @param address the address
	 */
	public void setText(By xpath, String address) {
		SeleniumAPI.getDriver().findElement(xpath).sendKeys("");
		SeleniumAPI.getDriver().findElement(xpath).sendKeys(address);

	}

	/**
	 * Gets the element by xpath.
	 *
	 * @param xpath the xpath
	 * @return the element by xpath
	 */
	public WebElement getElementByXpath(By xpath) {
		waitUntilPresenceOfElement(xpath);
		return SeleniumAPI.getDriver().findElement(xpath);
	}

}
