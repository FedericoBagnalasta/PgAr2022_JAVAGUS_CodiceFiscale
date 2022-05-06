package it.unibs.codicefiscale;

import java.sql.Time;
import java.time.Instant;
import java.util.Date;

import javax.xml.stream.XMLStreamException;

public class Main {

	public static void main(String[] args) throws XMLStreamException {
		
		ElencoPersone persone = new ElencoPersone();
		//CodiceFiscale cf = new CodiceFiscale("PSNLRI99D64C800M");
		
		XML l = new XML();
		System.out.println(l.getCodiceComune("CAVALLINO-TREPORTI"));

		
		persone.creaCodici();
		//persone.presenzaCodicePersone();
		
		//persone.validitaCodici();
		
		persone.stampaOutput();
		
		
		//for (int i = 0; i < persone.vettorePersone.size(); i++) {
		//	System.out.println(persone.vettorePersone.get(i).getDataNascita().stampaData());
		//} 
			
		System.out.println(persone.vettoreCodici.size());
		System.out.println(persone.vettorePersone.get(127).getNomeComune());

	
	
	}

}
