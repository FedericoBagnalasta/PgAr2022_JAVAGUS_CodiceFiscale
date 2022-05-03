package it.unibs.codicefiscale;

public class CodiceFiscale {
	public static final String MESS_CODICE_ERRATO = "Il codice fiscale inserito non e' corretto.";
	String codiceFiscale;
	int inizio, fine;
	
	public CodiceFiscale (String codiceFiscale){
		this.codiceFiscale = codiceFiscale;
	}
	public boolean verificaStringa (String codiceFiscale, int inizio, int fine) {
		String stringaAppoggio= codiceFiscale.substring(inizio, fine);
		boolean result=true;
	    int ascii;
	    for(int i=0;i<stringaAppoggio.length();i++){
	        ascii = (int)stringaAppoggio.charAt(i);
	        if((ascii>65)&&(ascii<90)) result=true;
	        else result= false;
	    }
	    return result;
	}
	 public void controlloCodice () {
		 if (codiceFiscale.length() < 16) {
			 System.out.println(MESS_CODICE_ERRATO);
		 }
		 if (.verificaStringa(codiceFiscale, inizio, fine)) {
			 System.out.println(MESS_CODICE_ERRATO);
		 }
	}
}
