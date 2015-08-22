package searchAPI;

import static org.junit.Assert.assertEquals;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class CountryTests {
	
	public static String url = "https://itunes.apple.com/search?term=abba&limit=1&country=uk";
	
	@Test
	public void test1() {
		SearchObject request = new SearchObject("https://itunes.apple.com/search?term=abba&country=uk");
		assertEquals("Verify response code is 200", request.responseCode, 200);
	}
	
	@Test
	public void test2() {
		SearchObject request = new SearchObject("https://itunes.apple.com/search?term=abba&limit=1");
		//JSONObject obj = new JSONObject(response.toString());
		
		//JSONArray results = (JSONArray) request.get("results");
		//JSONObject result1 = (JSONObject) results.get(0);
		//String i = result1.getString("country");
		//assertEquals("Verify default country is US", i, "US");
	}
	
	@Test
	public void test3() {
		
	}
}
