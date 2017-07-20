package cryptoSources;





import com.bitso.Bitso;
import com.bitso.BitsoBook;
import com.bitso.BitsoTicker;

public class DTO {

	
	public void bitsoBooks() throws Exception {
	Bitso bitso = new Bitso(System.getenv("GENGdntMYP"), System.getenv("cb6627ee4055b9718511879c70076541"));
	
//	ArrayList<BookInfo> books = bitso.availableBooks();
//	for (BookInfo bookInfo : books) {
//	    System.out.println(bookInfo);
//	}
	BitsoTicker ticker = bitso.getTicker(BitsoBook.ETH_MXN);
	System.out.println(ticker);
	}
}
