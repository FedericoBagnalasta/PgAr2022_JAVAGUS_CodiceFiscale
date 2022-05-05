package it.unibs.codicefiscale;

import javax.xml.stream.XMLStreamException;

public class Main {

	public static void main(String[] args) throws XMLStreamException {
		
		ElencoPersone persone = new ElencoPersone();
		CodiceFiscale cf = new CodiceFiscale("PSNLRI99D64C800M");
		
		//persone.creaCodici();
		
		persone.presenzaCodicePersone();
		
		//persone.validitaCodici();
		
		persone.stampaOutput();
		
		
		for (int i = 0; i < persone.vettorePersone.size(); i++) {
			System.out.println(persone.vettorePersone.get(i).getDataNascita().stampaData());
		} 
		System.out.println(persone.vettorePersone.get(1).getDataNascita().stampaData());
		
		//file.stampaCaratteri("pari");
	

		
		System.out.println(cf.controlloCodice());

	
	
	}

}
