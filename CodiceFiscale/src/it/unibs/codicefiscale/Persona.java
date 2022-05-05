package it.unibs.codicefiscale;

public class Persona {
	
	private int eta;
	private int luogo;
	private boolean presenzaCodice = true;
	private String codiceComune;
	private CodiceFiscale cf = new CodiceFiscale(null);
	private Data dataNascita = new Data();

	
	public Persona() {
		/*
		 * leggi nome, cognome, eta, sesso
		 * crea codice nome, cognome, eta, sesso 
		 * crea codice fiscal
		 * 
		 * 
		 */
	}
	
	public CodiceFiscale getCodice() {
		return cf;
	}

	public void setCodice(CodiceFiscale codice) {
		// TODO Auto-generated method stub
	}
	

	public String getNomeCodice() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCognomeCodice() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAnnoCodice() {
		return dataNascita.dataCodice();
	}

	public char getSessoCodice() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getCodiceComune() {
		// TODO Auto-generated method stub
		return null;
	}

	public void presenzaCodice(boolean f) {
		// TODO Auto-generated method stub
		
	}

	public Object getNomeComune() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCodiceComune(Object codiceComune) {
		// TODO Auto-generated method stub
		
	}
	
	

}
