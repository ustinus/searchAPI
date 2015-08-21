package searchAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class SearchObject {
	public JSONObject response;
	public int responseCode, resultCount;
	
	
	SearchObject(String url) {
		this.response = getResponse(url);
		this.resultCount = getResultsCount();
	}
	
	public JSONObject getResponse(String URLName){
	    try {
	        HttpURLConnection.setFollowRedirects(true);
	        HttpURLConnection con = (HttpURLConnection) new URL(URLName).openConnection();
	        con.setRequestMethod("GET");
	        responseCode = con.getResponseCode();
	        
	        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			JSONObject obj = new JSONObject(response.toString());
			
			
			return obj;
	    }
	    catch (Exception e) {
	    	//e.printStackTrace();
	    }
		return null;
    }
	
	public int getResultsCount() {
		int count = (Integer) response.get("resultCount"); 
		return count;	
	}
	
}

/*public static int CheckLink(String URLName){
try {
    HttpURLConnection.setFollowRedirects(true);
    HttpURLConnection con = (HttpURLConnection) new URL(URLName).openConnection();
    con.setRequestMethod("GET");
    
    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	String inputLine;
	StringBuffer response = new StringBuffer();

	while ((inputLine = in.readLine()) != null) {
		response.append(inputLine);
	}
	in.close();
	
	JSONObject obj = new JSONObject(response.toString());
	
	JSONArray results = (JSONArray) obj.get("results");
	
	JSONObject result1 = (JSONObject) results.get(0);
	
	System.out.println(obj.toString(3));
	
	//System.out.println("\n\n");
	
	String i = result1.getString("country");
	//System.out.println(i);
	
	
	for(String a : obj.keySet()) {
		//System.out.println(a);
	}
	
	//JSONArray results = new JSONArray(obj.getJSONArray("results"));
	//System.out.println(results.toString(3));
	
	
	//JSONObject result1 = new JSONObject(results.get(0));
	
	//System.out.println(result1.toString(3));
	
	
	
	//System.out.println(obj.toString(3));
    
    
    return con.getResponseCode();
}
catch (Exception e) {
    //e.printStackTrace();
    return 0;
}
}*/

