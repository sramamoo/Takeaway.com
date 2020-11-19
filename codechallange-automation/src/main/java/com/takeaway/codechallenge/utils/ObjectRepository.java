/**
 * 
 */
package com.takeaway.codechallenge.utils;

/**
 * @author suthir
 *
 */
public class ObjectRepository {
		
	public static final String ADDRESS_SEARCH_BAR = "//input[@id='imysearchstring']";
	public static final String DELIVERY_COSTS_LIST = "//div[@id='irestaurantlist']//div[@class='delivery-cost js-delivery-cost notranslate']";
	public static final String LESS_THAN_1_RADIO = "//a[@data-value='[0,1]']";
	public static final String LESS_THAN_2_5_RADIO = "//a[@data-value='[0,2.5]']";
	public static final String NO_PREFERENCE = "//a[@data-value='reset']";
	
	public static final String RESTAURANT_LIST ="//div[@id= 'irestaurantlist']";
	public static final String CUISINE_ITALIAN_LINK = "//a[@data-type='Cuisine']//span[contains(text(),'Italian')]";
	public static final String CUISINE_INDIAN_LINK = "//a[@data-type='Cuisine']//span[contains(text(),'Indian')]";
	public static final String CUISINE_MEXICAN_LINK = "//a[@data-type='Cuisine']//span[contains(text(),'Mexican')]";
	
	public static final String ALL_CUISINE = "//a[@data-type='Cuisine']//span[contains(text(),'All')]";
	
	public static final String KITCHEN_CUISINE_LIST = "//div[@id= 'irestaurantlist']//div[@class='kitchens']//span";
	public static final String RESTAURANT_COUNT = "//span[@class='restaurant-amount']";

}
