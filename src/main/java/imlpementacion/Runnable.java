package imlpementacion;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.json.JSONException;

import cryptoSources.DTO;
import pojos.BitsoBean;

public class Runnable {

	public static void main(String[] args) {

		DTO dto = new DTO();
//		Map<Date,Integer> ethGoogleTrend =null;
//		BitsoBean bitso;
//
//		// Recibe precio del dia en bitso
//		try {
//				//get bitso daily stock
//			 bitso = dto.bitsoBooks();
//			 	//get google eth trends.
//			 ethGoogleTrend = dto.getEthTrend();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		System.out.println(ethGoogleTrend);

		try {
			Map<Date, Double> ethPrices = dto.getHistoricPriceEth();
			
			System.out.println(ethPrices);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
