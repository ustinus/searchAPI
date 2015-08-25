package searchAPI;

import org.json.JSONArray;
import org.json.JSONObject;

public class searchAPI {

	public static String url = "https://itunes.apple.com/search?term=abba&limit=1&country=uk";
	
	public static void main(String[] args) {
		
		SearchObject request = new SearchObject(url);
		
		System.out.println(request.resultCount);
		System.out.println(request.responseCode);
		System.out.println(request.response.toString(3));
		
		
		
	}
}
