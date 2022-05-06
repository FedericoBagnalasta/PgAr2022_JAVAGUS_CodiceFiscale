package it.unibs.codicefiscale;

import javax.xml.stream.XMLStreamException;
import it.unibs.fp.mylib.MyMenu;

public class Main {

private static final String OPERAZIONE_ANDATA_A_BUON_FINE = "Operazione andata a buon fine";
private static final String FINE_PROGRAMMA = "Programma terminato";
private static final String SCELTA_OPZIONE = "Scegli l'opzione";
private static final String OUTPUT = "Stampa output";
private static final String VERIFICA_LA_PRESENZA_DEI_CODICI = "Verifica la presenza dei codici fiscali delle persone";
private static final String SCARICA_ELENCO_PERSONE = "Scarica elenco persone da file";


public static void main(String[] args) throws XMLStreamException {

	ElencoPersone persone = new ElencoPersone();

	//condizione di permanenza nel menu
	boolean continua = true;

	String vociMenu[] = {SCARICA_ELENCO_PERSONE, VERIFICA_LA_PRESENZA_DEI_CODICI, OUTPUT};

	MyMenu menu = new MyMenu(SCELTA_OPZIONE, vociMenu);

	while(continua) {
		switch(menu.scegli()) {

		//primo caso del menu, elenco persone
		case 1:
			persone.creaCodici();
			System.out.println(OPERAZIONE_ANDATA_A_BUON_FINE);
			break;

			//secondo caso del menu, verifica la presenza dei codici
		case 2:
			persone.presenzaCodicePersone();
			persone.validitaCodici();
			System.out.println(OPERAZIONE_ANDATA_A_BUON_FINE);
			break;

			//terzo caso del menu, verifica la correttezza dei codici 
		case 3:
			persone.stampaOutput();
			System.out.println(OPERAZIONE_ANDATA_A_BUON_FINE);
			break;

			//caso zero del menu, condizione di uscita dal programma
		case 0:
			System.out.println(FINE_PROGRAMMA);
			continua = false;
			break;
		}
	} 
}
}
