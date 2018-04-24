package com.example.topcolleguesbackend.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.topcolleguesbackend.entite.Collegue;

public class JsonReader {

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static Collegue getSingleCollegueFromJson(String url) throws IOException, JSONException {
		
		InputStream is = new URL(url).openStream();
		
		Collegue collegue = null;
		
		try {
			
			Collegue newCollegue = new Collegue();
			
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);

			JSONArray jsonArray = new JSONArray(jsonText);
			// iterate loop
			for (int i = 0; i < jsonArray.length(); i++) {

				// get the JSON Object
				JSONObject obj = jsonArray.getJSONObject(i);
					
				newCollegue.setNom(obj.getString("nom"));
				newCollegue.setPrenom(obj.getString("prenom"));
				newCollegue.setEmail(obj.getString("email"));
				newCollegue.setAdresse(obj.getString("adresse"));
				newCollegue.setUrlImage(obj.getString("photo"));
				newCollegue.setScore(0);
				
				collegue = newCollegue;

			}
			
			return collegue;

		} finally {
			is.close();
		}
	}
}
