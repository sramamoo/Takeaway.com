package com.takeaway.codechallenge.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * The Class JSONUtils.
 */
public class JSONUtils {

	/**
	 * Json to map.
	 *
	 * @param t the t
	 * @return the map
	 * @throws JSONException the JSON exception
	 */
	public Map<String, String> jsonToMap(String response) throws JSONException {

		HashMap<String, String> map = new HashMap<String, String>();
		JSONObject jObject = new JSONObject(response);
		Iterator<?> keys = jObject.keys();

		while (keys.hasNext()) {
			String key = (String) keys.next();
			String value = jObject.getString(key);
			map.put(key, value.replaceAll("\"", ""));

		}
		return map;
	}

	/**
	 * Compare json maps.
	 *
	 * @param responseMap  the response map
	 * @param referenceMap the reference map
	 * @return true, if successful
	 */
	public boolean compareJsonMaps(Map<String, String> responseMap, Map<String, String> referenceMap) {
		for (String key : referenceMap.keySet()) {

			if (referenceMap.get(key) != null && !referenceMap.get(key).equals(responseMap.get(key))) {
				return false;

			}

		}
		return true;
	}

}
