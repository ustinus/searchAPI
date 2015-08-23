package searchAPI;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class MediaTests {
	@BeforeClass
	public static void beforeClass() {
		SearchObject request = new SearchObject("https://itunes.apple.com/search?term=abba&media=movie");
		assertEquals("Verify response code is 200", 200, request.responseCode);
	}
	
	@Test
	public void testPodcast() {
		SearchObject request = new SearchObject("https://itunes.apple.com/search?term=abba&media=podcast");
		assertEquals("Verify response code is 200", 200, request.responseCode);
	}
	
	@Test
	public void testMusic() {
		SearchObject request = new SearchObject("https://itunes.apple.com/search?term=abba&media=music");
		assertEquals("Verify response code is 200", 200, request.responseCode);
	}
	
	@Test
	public void testMusicVideo() {
		SearchObject request = new SearchObject("https://itunes.apple.com/search?term=abba&media=musicVideo");
		assertEquals("Verify response code is 200", 200, request.responseCode);
	}
	
	@Test
	public void testAudiobook() {
		SearchObject request = new SearchObject("https://itunes.apple.com/search?term=abba&media=audiobook");
		assertEquals("Verify response code is 200", 200, request.responseCode);
	}
	
	@Test
	public void testShortFilm() {
		SearchObject request = new SearchObject("https://itunes.apple.com/search?term=abba&media=shortFilm");
		assertEquals("Verify response code is 200", 200, request.responseCode);
	}
	
	@Test
	public void testTVShow() {
		SearchObject request = new SearchObject("https://itunes.apple.com/search?term=abba&media=tvShow");
		assertEquals("Verify response code is 200", 200, request.responseCode);
	}
	
	@Test
	public void testSoftware() {
		SearchObject request = new SearchObject("https://itunes.apple.com/search?term=abba&media=software");
		assertEquals("Verify response code is 200", 200, request.responseCode);
	}
	
	@Test
	public void testEbook() {
		SearchObject request = new SearchObject("https://itunes.apple.com/search?term=abba&media=ebook");
		assertEquals("Verify response code is 200", 200, request.responseCode);
	}
	
	@Test
	public void testAll() {
		SearchObject request = new SearchObject("https://itunes.apple.com/search?term=abba&media=all");
		assertEquals("Verify response code is 200", 200, request.responseCode);
	}
}

