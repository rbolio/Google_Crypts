package imlpementacion;

import cryptoSources.DTO;
import pojos.BitsoBean;

public class Runnable {

	public static void main(String[] args) {

		DTO dto = new DTO();
	
		
		try {
			BitsoBean bitso =dto.bitsoBooks();
			System.out.println(bitso);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
