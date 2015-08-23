package searchAPI;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TermTests {
	
	@Test
	public void test1() {
		SearchObject request = new SearchObject("https://itunes.apple.com/search?term=abba");
		assertEquals("Verify response code is 200", 200, request.responseCode);
	}
	
	@Test
	public void test2() {
		SearchObject request = new SearchObject("https://itunes.apple.com/search?term=bob+marley");
		assertEquals("Verify response code is 200", 200, request.responseCode);
	}
	
	@Test
	public void test3() {
		SearchObject request = new SearchObject("https://itunes.apple.com/search?term=abba_gold");
		assertEquals("Verify response code is 200", 200, request.responseCode);
	}
	
	@Test
	public void test4() {
		SearchObject request = new SearchObject("https://itunes.apple.com/search?term=abba-money");
		assertEquals("Verify response code is 200", 200, request.responseCode);
	}
	
	@Test
	public void test5() {
		SearchObject request = new SearchObject("https://itunes.apple.com/search?term=abba-money");
		assertEquals("Verify response code is 200", 200, request.responseCode);
	}
}
