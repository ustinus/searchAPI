package searchAPI;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class LimitTests {
	
	@BeforeClass
	public static void beforeClass() {
		SearchObject request = new SearchObject("https://itunes.apple.com/search?term=abba");
		assertEquals("Verify default limit is 50", request.resultCount, 50);
	}
	
	@Test
	public void test1() {
		SearchObject request = new SearchObject("https://itunes.apple.com/search?term=abba&limit=20");
		assertEquals("Verify requested number of results returned", request.resultCount, 20);
	}
	
	@Test
	public void test2() {
		SearchObject request = new SearchObject("https://itunes.apple.com/search?term=abba&limit=201");
		assertEquals("Verify not more then 200 results returned", request.resultCount, 200);
	}
	
	@Test
	public void test3() {
		SearchObject request = new SearchObject("https://itunes.apple.com/search?term=abba&limit=0");
		assertEquals("Verify requested number of results returned", request.resultCount, 0);
	}
}
