package com.takeaway.codechallenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.takeaway.codechallenge.core.SeleniumAPI;
import com.takeaway.codechallenge.utils.Constants;
import com.takeaway.codechallenge.utils.ObjectRepository;
import com.takeaway.codechallenge.utils.SeleniumUtils;

/**
 * The Class Homepage.
 * 
 * @author suthir
 */
public class Homepage {

	/** The selenium utils. */
	public SeleniumUtils seleniumUtils = null;

	/** The selenium API. */
	public SeleniumAPI seleniumAPI = null;

	/**
	 * Instantiates a new homepage.
	 */
	public Homepage() {
		seleniumUtils = new SeleniumUtils();
		seleniumAPI = new SeleniumAPI(SeleniumAPI.getDriver());
	}

	/**
	 * Navigate to homepage.
	 */
	public void navigateToHomepage() {

		seleniumAPI.getPage(Constants.URL);
		

	}

	/**
	 * Fliter restaurant in location.
	 *
	 * @param address the address
	 */
	public void fliterRestaurantInLocation(String address) {
		seleniumUtils.setText(By.xpath(ObjectRepository.ADDRESS_SEARCH_BAR), address);
		try {
			Thread.sleep(Constants.N2000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		seleniumUtils.getElementByXpath(By.xpath(ObjectRepository.ADDRESS_SEARCH_BAR)).sendKeys(Keys.ENTER);
		seleniumUtils.waitUntilPresenceOfElement(By.xpath(ObjectRepository.RESTAURANT_LIST));

	}


}
