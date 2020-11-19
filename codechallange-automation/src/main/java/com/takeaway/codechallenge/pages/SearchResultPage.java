package com.takeaway.codechallenge.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.takeaway.codechallenge.core.SeleniumAPI;
import com.takeaway.codechallenge.utils.ObjectRepository;
import com.takeaway.codechallenge.utils.SeleniumUtils;

/**
 * The Class SearchResultPage.
 */
public class SearchResultPage {

	/** The selenium utils. */
	public SeleniumUtils seleniumUtils = null;

	/** The selenium API. */
	public SeleniumAPI seleniumAPI = null;

	/**
	 * Instantiates a new search result page.
	 */
	public SearchResultPage() {
		seleniumUtils = new SeleniumUtils();
		seleniumAPI = new SeleniumAPI(SeleniumAPI.getDriver());

	}

	/**
	 * Verify the delivery costs.
	 *
	 * @param cost the cost
	 * @return true, if successful
	 */
	public boolean verifyFliterRestaurantByDeliveryCost(double cost) {
		List<Double> deliveryCostList = new ArrayList<Double>();
		List<WebElement> elements = SeleniumAPI.getDriver()
				.findElements(By.xpath(ObjectRepository.DELIVERY_COSTS_LIST));

		for (WebElement element : elements) {
			String value = element.getText().replace("€", "").replace(",", ".");
			if (!("FREE").equals(value) && value.length() > 0) {
				deliveryCostList.add(Double.parseDouble(value));
			}
		}
		Collections.sort(deliveryCostList);
		if (deliveryCostList.get(deliveryCostList.size() - 1) > cost) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * Fliter restaurant by delivery cost.
	 *
	 * @param deliveryCost the delivery cost
	 */
	public void fliterRestaurantByDeliveryCost(String deliveryCost) {
		String xpath = null;
		switch (deliveryCost) {
		case "less than 1":
			xpath = ObjectRepository.LESS_THAN_1_RADIO;
			break;
		case "less than 2.5":
			xpath = ObjectRepository.LESS_THAN_2_5_RADIO;
			break;
		default:
			xpath = ObjectRepository.NO_PREFERENCE;
		}

		seleniumAPI.click(By.xpath(xpath));

	}

	/**
	 * Filter restaurant by cuisine.
	 *
	 * @param cuisineType the cuisine type
	 */
	public void filterRestaurantByCusine(String cuisineType) {
		String xpath = null;
		switch (cuisineType) {
		case "Italian":
			xpath = ObjectRepository.CUISINE_ITALIAN_LINK;
			break;
		case "Indian":
			xpath = ObjectRepository.CUISINE_INDIAN_LINK;
			break;
		case "Mexican":
			xpath = ObjectRepository.CUISINE_MEXICAN_LINK;
			break;
		default:
			xpath = ObjectRepository.ALL_CUISINE;
		}
		seleniumAPI.click(By.xpath(xpath));
	}

	/**
	 * Verify fliter restaurant by cuisine.
	 *
	 * @param cuisineType the cuisine type
	 * @return true, if successful
	 */
	public boolean verifyFliterRestaurantByCuisine(String cuisineType) {
		int count = 0;
		List<WebElement> elements = SeleniumAPI.getDriver()
				.findElements(By.xpath(ObjectRepository.KITCHEN_CUISINE_LIST));

		for (WebElement element : elements) {
			String value = element.getText().trim();
			if (value.contains(cuisineType)) {
				count = count + 1;
			}
		}
		int restaurantCount = Integer
				.parseInt(SeleniumAPI.getDriver().findElement(By.xpath(ObjectRepository.RESTAURANT_COUNT)).getText());
		if (count == restaurantCount) {
			return true;
		} else {
			return false;

		}
	}
}
