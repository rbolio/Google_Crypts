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
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utilities {

	public Map<Date, Integer> getGoogleTrend(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);

			String dirtyInput = jsonText.substring(jsonText.indexOf("{\"c\":"), jsonText.length() - 2);

			List<String> data = new LinkedList<String>();
			do {
				// get temp/ modifiable string
				String temp = dirtyInput.substring(0, dirtyInput.indexOf("},{", dirtyInput.indexOf("},{") + 1) + 1);
				// remove js functions
				temp = temp.replace("new Date(", "\"");
				int whereIsF = temp.indexOf('f');
				// remove unecesary files
				if (whereIsF < 0)
					break;
				temp = temp.substring(0, whereIsF - 3) + "\"" + temp.substring(whereIsF - 2, temp.length());

				data.add(temp);
				dirtyInput = dirtyInput.substring(dirtyInput.indexOf("},{", dirtyInput.indexOf("},{") + 1) + 2,
						dirtyInput.length());

			} while (dirtyInput.length() > 0);

			Map<Date, Integer> graphData = new HashMap<Date, Integer>();

			for (String sData : data) {
				String stringDate = sData.substring(sData.indexOf("20"), sData.indexOf("\",\"f"));
				String sValue = sData.substring(sData.indexOf("},{") + 7, sData.indexOf(".")); //
				System.out.println(stringDate);
				SimpleDateFormat parser = new SimpleDateFormat("yyyy,MM,dd");

				try {
					Date date = parser.parse(stringDate);
					date.setMonth(date.getMonth() + 1);

					graphData.put(date, Integer.parseInt(sValue));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			return graphData;

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

	public Map<Date, Double> getEthPrices(String url) throws MalformedURLException, IOException {

		InputStream is = new URL(url).openStream();
		Map<Date, Double> graphData = new HashMap<Date, Double>();
		BufferedReader rd = null;
		try {
			 rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			
			String dirtyText = jsonText.substring(jsonText.indexOf("[")+1,jsonText.length());
			
			String[] dirtyArray = dirtyText.split("\"time\"");
			
			for(String x : dirtyArray){
				if(x.length()>1){
					
					long seconds = Long.parseLong(x.substring(1, x.indexOf(",")));
					
					Date tradeDate = new Date(seconds*1000);
					Double tradePrice = Double.parseDouble(x.substring(x.indexOf("close\":")+7,x.indexOf("high")-2));
					graphData.put(tradeDate, tradePrice);
				}
			}
			
			
			
			
		}catch (Exception e){
			
		}finally{
			rd.close();
		}
		
		return graphData;
	}
}
