package searchAPI;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class GeneralTestsPositive {
	
	@Test
	public void termCountry() {
		SearchObject request = new SearchObject("https://itunes.apple.com/search?term=bobmarley&country=gb");
		assertEquals("Verify response code is 200", 200, request.responseCode);
	}
	
	@Test
	public void termCountryMedia() {
		SearchObject request = new SearchObject("https://itunes.apple.com/search?term=bobmarley&country=gb&media=movie");
		assertEquals("Verify response code is 200", 200, request.responseCode);
	}
	
	@Test
	public void termCountryMediaLimit() {
		SearchObject request = new SearchObject("https://itunes.apple.com/search?term=bob&country=gb&media=movie&limit=15");
		assertEquals("Verify response code is 200", 200, request.responseCode);	
	}
	
}
