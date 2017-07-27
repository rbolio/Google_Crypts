package cryptoSources;

import java.io.BufferedReader;
import java.io.File;

import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utilities {

	public boolean json2csv(JSONObject input) throws JSONException, IOException {
		boolean status = false;
		JSONArray doc = input.getJSONArray("rows");

		File file = new File("/temp2/fromJSON.csv");

		String csv = CDL.toString(doc);

		FileUtils.writeStringToFile(file, csv);

		return status;
	}

	public JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			System.out.println(jsonText);
			jsonText = jsonText.substring(jsonText.indexOf("{\"c\":"), jsonText.length() - 2) + ";";
			System.out.println(jsonText);
			JSONObject json = new JSONObject(jsonText);
			return json;

		} finally {
			is.close();
		}
	}

	private String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}
}
