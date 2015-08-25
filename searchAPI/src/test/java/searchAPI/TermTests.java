package searchAPI;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TermTests {
	
	@Test
	public void noSpace() {
		SearchObject request = new SearchObject("https://itunes.apple.com/search?term=abba");
		assertEquals("Verify response code is 200", 200, request.responseCode);
	}
	
	@Test
	public void plusSign() {
		SearchObject request = new SearchObject("https://itunes.apple.com/search?term=bob+marley");
		assertEquals("Verify response code is 200", 200, request.responseCode);
	}
	
	@Test
	public void underscoreTest() {
		SearchObject request = new SearchObject("https://itunes.apple.com/search?term=abba_gold");
		assertEquals("Verify response code is 200", 200, request.responseCode);
	}
	
	@Test
	public void dashTest() {
		SearchObject request = new SearchObject("https://itunes.apple.com/search?term=abba-money");
		assertEquals("Verify response code is 200", 200, request.responseCode);
	}
	
	@Test
	public void asterixTest5() {
		SearchObject request = new SearchObject("https://itunes.apple.com/search?term=abba*money");
		assertEquals("Verify response code is 200", 200, request.responseCode);
	}
}
