package searchAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class SearchObject {
	public JSONObject response;
	public int responseCode, resultCount;
	public ArrayList<String> countryArrayList = new ArrayList<String>();
	
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
				
				JSONArray results = (JSONArray) obj.get("results");
				for (int i = 0; i < results.length(); i++) {
					JSONObject eachResult = (JSONObject) results.get(i);
					String country = eachResult.getString("country");
					countryArrayList.add(country);
				}
				return obj;
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject obj = new JSONObject("{'EMPTY RESPONSE':0}");
		return obj;
	}
}


