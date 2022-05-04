package it.unibs.codicefiscale;

public class Persona {
	
	private int eta;
	private int luogo;
	private CodiceFiscale cf = new CodiceFiscale(null);
	private boolean presenzaCodice = true;
	
	public Persona() {
		
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

	public char getAnnoCodice() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getSessoCodice() {
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
	
	

}
