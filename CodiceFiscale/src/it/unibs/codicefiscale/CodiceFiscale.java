package it.unibs.codicefiscale;
import java.util.Iterator;

public class CodiceFiscale {
	public static final String MESS_CODICE_ERRATO = "Il codice fiscale inserito non e' corretto";
	private String codiceFiscale;
	private String codiceIncompleto;

	
	//costruttore per creare un nuovo codice
	public CodiceFiscale (String nome,  String cognome,  String data, String comune, char sesso){
		this.codiceIncompleto = cognome + nome + data + comune;
		this.codiceFiscale = codiceIncompleto + carattereControllo(codiceIncompleto);
		
	}
	
	//costruttore che crea un oggetto codice partendo da una stringa
	public CodiceFiscale (String codiceFiscale){
		this.codiceFiscale = codiceFiscale;
		codiceIncompleto = codiceFiscale.substring(0, 15);
	}


	
//-------------------------------------------------manipolazione codice fiscale--------------------------------------------
	
	//metodo che controlla un oggetto CodiceFiscale, e retituisce 
	//vero in caso il codice rispetti tutte le condizioni di un codice fiscale, falso in caso contrario
	 public boolean controlloCodice () {
		 
		 if (codiceFiscale.length() < 16) {
			 System.out.println(MESS_CODICE_ERRATO);
			 return false;
		 }
		 if (!verificaStringaLettere(0, 6)) {
			 System.out.println(MESS_CODICE_ERRATO);
			 return false;
		 }
		 if(!verificaStringaNumero(6) && !verificaStringaNumero(7) && !verificaLetteraMese()){
			 System.out.println(MESS_CODICE_ERRATO);
			 return false;
		 }
		 if (!verificaStringaNumero(9) && !verificaStringaNumero(10)) {
			 System.out.println(MESS_CODICE_ERRATO);
			 return false;
		 }
		 if (codiceFiscale.charAt(9) == codiceFiscale.charAt(10) && codiceFiscale.charAt(9) == '0') {
			 System.out.println(MESS_CODICE_ERRATO);
			 return false;
		 }
		 
		 if (!verificaComune()) {///da fare
			 System.out.println(MESS_CODICE_ERRATO);
			 return false;
		 }
 
		 if (!(codiceFiscale.charAt(15) == carattereControllo(codiceIncompleto))) {
			 System.out.println(MESS_CODICE_ERRATO);
			 return false;
		 }
		return true;
	}

//+++++++++++++++++++++++++++++++metodi di supporto al metodo controllo++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	//verifica se la stringa passata sia formata solo da lettere maiuscole
	private boolean verificaStringaLettere (int inizio, int fine) {
		String stringaAppoggio= codiceFiscale.substring(inizio, fine);
		boolean verificato = true;
	    int ascii;
	    for(int i=0; i<stringaAppoggio.length(); i++){
	        ascii = (int)stringaAppoggio.charAt(i);
	        if((ascii >= 65) && (ascii <= 90)) 
	        	verificato=true;
	        else {
	        	verificato= false;
	        	break;
	        }
	    }
	    return verificato;
	}
	 
	//verifica che il carattere all'indice posLettera sia effettivamente un numero
	private boolean verificaStringaNumero (int posLettera) {
		int ascii = (int)codiceFiscale.charAt(posLettera);
		if (posLettera == 9) {
			if((ascii >= 48) && (ascii <= 55)) 
				return true;
	        else {
	        	return false;
	        }
		}
		else if((ascii >= 48) && (ascii <= 57)) 
			return true;
        else {
        	return false;
        }
	}
	
	//verifica che la lettera inposizione 9 sia quella di un mese 
	private boolean verificaLetteraMese() {
		String stringaCaratteriMesi = "ABCDEHLMPRST";
		char  mesi[] = stringaCaratteriMesi.toCharArray();
		for (int i = 0; i < stringaCaratteriMesi.length(); i++) {
		     if (codiceFiscale.charAt(8) == mesi[i]) {
			     return true;
		     }
		}
		return false;
	}

	//verifica che il codice del comune sia giusto
	private boolean verificaComune() {//da fare
		return false;
	}
	 
	//metodo che calcola il valore del carattere di controllo
	private char carattereControllo(String codiceAttuale) {
		XML com = new XML();
		int resto;int sommaValoriPari = 0; int sommaValoriDispari = 0;

		for (int i = 0; i < 15; i+=2) {
			sommaValoriPari += com.valoreNumeroPari(codiceAttuale.charAt(i));
			if (!(i==14))
				sommaValoriDispari += com.valoreNumeroDisari(codiceAttuale.charAt(i+1));
		}
		resto = (sommaValoriPari + sommaValoriDispari) % 26;
		
		return com.valoreCarattereControllo(resto);
		
	}

//++++++++++++++++++++++++++fine metodi di supporto al metodo controllo++++++++++++++++++++++++++++++++++++++++++++++++
	
	 
}
