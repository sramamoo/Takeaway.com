package com.takeaway.codechallenge.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.takeaway.codechallenge.core.SeleniumAPI;
import com.takeaway.codechallenge.pages.Homepage;
import com.takeaway.codechallenge.pages.SearchResultPage;
import com.takeaway.codechallenge.utils.Constants;

public class UITest {
	public Homepage homePage = null;
	public SearchResultPage searchResultPage = null;

	@Test(priority = Constants.PR1, testName = "UI:DeliveryCostTest1Euro")
	public void deliveryCostTest1() {
		homePage = new Homepage();
		searchResultPage = new SearchResultPage();
		homePage.navigateToHomepage();
		homePage.fliterRestaurantInLocation(Constants.FILTER_ADDRESS);
		searchResultPage.fliterRestaurantByDeliveryCost(Constants.LESSTHAN_1);
		Assert.assertTrue(searchResultPage.verifyFliterRestaurantByDeliveryCost(Constants.LESSTHAN1));

	}
	@Test(priority = Constants.PR5, testName = "UI:DeliveryCostTest2_5Euro")
	public void deliveryCostTest2_5() {
		homePage = new Homepage();
		searchResultPage = new SearchResultPage();
		homePage.navigateToHomepage();
		homePage.fliterRestaurantInLocation(Constants.FILTER_ADDRESS);
		searchResultPage.fliterRestaurantByDeliveryCost(Constants.LESSTHAN_2_5);
		Assert.assertTrue(searchResultPage.verifyFliterRestaurantByDeliveryCost(Constants.LESSTHAN2_5));

	}
	@Test(priority = Constants.PR2,testName = "UI:cusineTestItalian")
	public void cusineTestItalian() {
		homePage = new Homepage();
		searchResultPage = new SearchResultPage();
		homePage.navigateToHomepage();
		homePage.fliterRestaurantInLocation(Constants.FILTER_ADDRESS);
		searchResultPage.filterRestaurantByCusine(Constants.ITALIAN);
		Assert.assertTrue(searchResultPage.verifyFliterRestaurantByCuisine(Constants.ITALIAN));
	}

	@Test(priority = Constants.PR2,testName = "UI:cusineTestIndian")
	public void cusineTestIndian() {
		homePage = new Homepage();
		searchResultPage = new SearchResultPage();
		homePage.navigateToHomepage();
		homePage.fliterRestaurantInLocation(Constants.FILTER_ADDRESS);
		searchResultPage.filterRestaurantByCusine(Constants.INDIAN);
		Assert.assertTrue(searchResultPage.verifyFliterRestaurantByCuisine(Constants.INDIAN));
	}
	
	@Test(priority = Constants.PR2,testName = "UI:cusineTestMexican")
	public void cusineTestMexican() {
		homePage = new Homepage();
		searchResultPage = new SearchResultPage();
		homePage.navigateToHomepage();
		homePage.fliterRestaurantInLocation(Constants.FILTER_ADDRESS);
		searchResultPage.filterRestaurantByCusine(Constants.MEXICAN);
		Assert.assertTrue(searchResultPage.verifyFliterRestaurantByCuisine(Constants.MEXICAN));
	}
	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
		SeleniumAPI.getDriver().quit();
	}

}
