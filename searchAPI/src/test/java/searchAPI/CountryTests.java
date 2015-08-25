package searchAPI;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CountryTests {

	public static String url = "https://itunes.apple.com/search?term=abba&limit=1&country=uk";

	@Test
	public void testDefaultCountry() {
		SearchObject request = new SearchObject("https://itunes.apple.com/search?term=abba&limit=10");
		for (int i = 0; i < request.countryArrayList.size(); i++) {
			assertEquals("Verify country of origin is US in all results", "USA", request.countryArrayList.get(i));
		}
	}

	@Test
	public void ValidCountryGBR() {
		SearchObject request = new SearchObject("https://itunes.apple.com/search?term=abba&country=gb");
		for (int i = 0; i < request.countryArrayList.size(); i++) {
			assertEquals("Verify country of origin is GRB in all results", "GBR", request.countryArrayList.get(i));
		}
	}

	@Test
	public void invalidCountryNegative() {
		SearchObject request = new SearchObject("https://itunes.apple.com/search?term=abba&country=uk");
		assertEquals("Verify response code is 400", 400, request.responseCode);
	}
}
