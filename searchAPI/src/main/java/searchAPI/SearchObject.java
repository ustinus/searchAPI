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
	}

	public JSONObject getResponse(String URLName) {
		try {
			HttpURLConnection.setFollowRedirects(true);
			HttpURLConnection con = (HttpURLConnection) new URL(URLName).openConnection();
			con.setRequestMethod("GET");
			responseCode = con.getResponseCode();
			if (responseCode == 200) {
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				JSONObject obj = new JSONObject(response.toString());
				resultCount = (Integer) obj.get("resultCount");	
				return obj;
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject obj = new JSONObject("{'EMPTY RESPONSE':0}");
		return obj;
	}

	

}

/*
 * public int getResultsCount() {
		int count;
		if(responseCode == 200) {
			count = (Integer) response.get("resultCount");
		} else {count = 0;}
		
		return count;
	}
 * 
 * 
 * 
 * 
 * 
 * **** Navigation *****
 * 
 * JSONObject obj = new JSONObject(response.toString());
 * 
 * JSONArray results = (JSONArray) obj.get("results");
 * 
 * JSONObject result1 = (JSONObject) results.get(0);
 * 
 * System.out.println(obj.toString(3));
 * 
 * String i = result1.getString("country");
 * 
 * for(String a : obj.keySet()) { System.out.println(a); }
 * 
 * JSONArray results = new JSONArray(obj.getJSONArray("results"));
 * System.out.println(results.toString(3));
 * 
 * JSONObject result1 = new JSONObject(results.get(0));
 * 
 */
