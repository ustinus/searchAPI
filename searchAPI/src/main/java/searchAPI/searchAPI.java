package searchAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class searchAPI {

	public static String url = "https://itunes.apple.com/search?term=abba";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckLink(url);
	}
	
	public static int CheckLink(String URLName){
	    try {
	        HttpURLConnection.setFollowRedirects(true);
	        HttpURLConnection con = (HttpURLConnection) new URL(URLName).openConnection();
	        con.setRequestMethod("GET");
	        
	        //System.out.println(con.getResponseMessage());
	        //System.out.println(con.getContent());
	        //System.out.println(con.);
	        
	        BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append("\n" + inputLine);
			}
			in.close();
			
			//print result
			System.out.println(response.toString());
	        
	        
	        return con.getResponseCode();
	    }
	    catch (Exception e) {
	        //e.printStackTrace();
	        return 0;
	    }
	}

}
