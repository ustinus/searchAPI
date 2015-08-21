package searchAPI;

import org.junit.BeforeClass;
import org.junit.Test;

public class CountryTests {
	
	public static String url = "https://itunes.apple.com/search?term=abba&limit=1&country=uk";
	
	
	@BeforeClass
	public static void beforeClass() {
		SearchObject request = new SearchObject(url);
	}
	
	@Test
	public void test1() {
		
	}
	
	@Test
	public void test2() {
		
	}
	
	@Test
	public void test3() {
		
	}
}
