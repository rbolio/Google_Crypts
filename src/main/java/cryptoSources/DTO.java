package cryptoSources;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.bitso.Bitso;
import com.bitso.BitsoBook;
import com.bitso.BitsoTicker;
import com.ritaja.xchangerate.api.CurrencyConverter;
import com.ritaja.xchangerate.api.CurrencyConverterBuilder;
import com.ritaja.xchangerate.util.Currency;
import com.ritaja.xchangerate.util.Strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import pojos.BitsoBean;

public class DTO{
	//mxn -> usd
	private CurrencyConverter converter = new CurrencyConverterBuilder().strategy(Strategy.YAHOO_FINANCE_FILESTORE).buildConverter();

	public BitsoBean bitsoBooks() throws Exception {
		Bitso bitso = new Bitso(System.getenv("GENGdntMYP"), System.getenv("cb6627ee4055b9718511879c70076541"));
		converter.setRefreshRateSeconds(86400);

		BitsoTicker ticker = bitso.getTicker(BitsoBook.ETH_MXN);

		BitsoBean bitsoBean = new BitsoBean();
		
		BigDecimal CR  =converter.convertCurrency(new BigDecimal(1), Currency.MXN, Currency.USD);
		
		bitsoBean.setLast(ticker.last.multiply(CR));
		bitsoBean.setHigh(ticker.high.multiply(CR));
		bitsoBean.setLow(ticker.low.multiply(CR));
		bitsoBean.setVwap(ticker.vwap.multiply(CR));
		bitsoBean.setVolume(ticker.volume.multiply(CR));
		bitsoBean.setBid(ticker.bid.multiply(CR));
		bitsoBean.setAsk(ticker.ask.multiply(CR));
		bitsoBean.setCreatedAt(ticker.createdAt);
		
		
		return bitsoBean;
	}
	
	public Map<Date,Integer> getEthTrend() throws IOException, JSONException{
		Utilities utilities = new Utilities();
		
		String ethQry = "https://trends.google.com/trends/fetchComponent?cid=TIMESERIES_GRAPH_0&export=3&q=ETHEREUM";
		
		//gets eth trend from internet
		Map<Date,Integer> ethTrend = utilities.getGoogleTrend(ethQry);
		
		if (ethTrend.size() > 0)
			return ethTrend;
		return null;
	}

	public Map<Date,Double> getHistoricPriceEth() throws IOException, JSONException{
		
			Utilities utilities = new Utilities();
		
		String ethQry = "https://min-api.cryptocompare.com/data/histoday?fsym=ETH&tsym=USD&limit=600000000000000000000000000000000000000000000000000&aggregate=3&e=CCCAGG";
		
		//gets eth trend from internet
		Map<Date,Double> ethPrices = utilities.getEthPrices(ethQry);

		return ethPrices;

	}

}
