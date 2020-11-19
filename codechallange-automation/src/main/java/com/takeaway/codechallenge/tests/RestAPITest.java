package com.takeaway.codechallenge.tests;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.takeaway.codechallenge.utils.Constants;
import com.takeaway.codechallenge.utils.JSONUtils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAPITest {
	RequestSpecification request;

	@Test(testName = "API:EggsCount")
	public void eggsCount() {

		Map<String, String> referenceMap = new HashMap<>();

		referenceMap.put("action", "eggs-count");
		referenceMap.put("success", "true");
		referenceMap.put("message", "You have collected a total of 0 eggs today");
		referenceMap.put("data", "0");
		Response response = request.post("/eggs-count");
		Assert.assertEquals(response.getStatusCode(), 200);
		JSONUtils jsonUtils = new JSONUtils();
		try {
			Map<String, String> responseMap = jsonUtils.jsonToMap(response.asString());
			Assert.assertTrue(jsonUtils.compareJsonMaps(responseMap, referenceMap));
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	@Test(testName = "API:ChickenFeed")
	public void chickenFeed() {

		Map<String, String> referenceMap = new HashMap<>();

		referenceMap.put("action", "chickens-feed");
		referenceMap.put("success", "true");
		referenceMap.put("message", "Your chickens are now full and happy");
		referenceMap.put("data", "null");
		Response response = request.post("/chickens-feed");
		Assert.assertEquals(response.getStatusCode(), 200);
		JSONUtils jsonUtils = new JSONUtils();
		try {
			Map<String, String> responseMap = jsonUtils.jsonToMap(response.asString());
			Assert.assertTrue(jsonUtils.compareJsonMaps(responseMap, referenceMap));
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	@Test(testName="API:BarnUnlock")
	public void barnUnlock() {
		Map<String, String> referenceMap = new HashMap<>();
		referenceMap.put("action", "barn-unlock");
		referenceMap.put("success", "true");
		referenceMap.put("message", "You just unlocked your barn! Watch out for strangers!");
		referenceMap.put("data", "null");
		Response response = request.post("/barn-unlock");
		Assert.assertEquals(response.getStatusCode(), 200);
		JSONUtils jsonUtils = new JSONUtils();
		try {
			Map<String, String> responseMap = jsonUtils.jsonToMap(response.asString());
			Assert.assertTrue(jsonUtils.compareJsonMaps(responseMap, referenceMap));
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	@BeforeClass
	public void beforeClass() {
		RestAssured.baseURI = Constants.BASE_URI;
		request = RestAssured.given();
		request.header("Authorization", Constants.AUTH_CODE);
	}


}
