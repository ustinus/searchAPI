package searchAPI;

import static org.junit.Assert.assertEquals;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class CountryTests {

	public static String url = "https://itunes.apple.com/search?term=abba&limit=1&country=uk";

	@Test
	public void testOriginCountry() {
		SearchObject request = new SearchObject("https://itunes.apple.com/search?term=abba&limit=10");

		JSONArray results = (JSONArray) request.response.get("results");

		for (int i = 0; i < results.length(); i++) {
			JSONObject eachResult = (JSONObject) results.get(i);
			String country = eachResult.getString("country");
			assertEquals("Verify country of origin is US", "USA", country);
		}
	}

	@Test
	public void noCounryProvided() {
		SearchObject request = new SearchObject("https://itunes.apple.com/search?term=abba");
		assertEquals("Verify response code is 200", 200, request.responseCode);
	}

	@Test
	public void ValidCountry() {
		SearchObject request = new SearchObject("https://itunes.apple.com/search?term=abba&country=gb");
		assertEquals("Verify response code is 200", 200, request.responseCode);
	}

	@Test
	public void invalidCountryNegative() {
		SearchObject request = new SearchObject("https://itunes.apple.com/search?term=abba&country=uk");
		assertEquals("Verify response code is 400", 400, request.responseCode);
	}
}
