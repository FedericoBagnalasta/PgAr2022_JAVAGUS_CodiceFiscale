package it.unibs.codicefiscale;

public class Persona {
	
	private String comuneNascita;
	private String nome;
	private String cognome;
	private char sesso;
	private boolean presenzaCodice = true;
	private String codiceComune;
	private CodiceFiscale cf = new CodiceFiscale(null);
	private Data dataNascita = new Data();

	
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

	public String getAnnoCodice() {
		return dataNascita.dataCodice();
	}
	
	public Data getDataNascita() {
		return dataNascita;
		
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

	public void setNome(String text) {
		nome = text;		
	}

	public void setData(String text) {
		int anno = Integer.parseInt(text.substring(0, 4));
		int mese = Integer.parseInt(text.substring(5, 7));
		int giorno = Integer.parseInt(text.substring(8, 10));
		dataNascita.impostaData(giorno, mese, anno);
		
	}

	public void setCognome(String text) {
		cognome = text;
		
	}

	public void setSesso(String text) {
		// TODO Auto-generated method stub
		
	}

	public void setNomeComune(String text) {
		// TODO Auto-generated method stub
		
	}

	public String getNome() {
		return nome;
	}

	public boolean presenzaPersona() {
		if (nome == null && cognome == null)
			return false;
		else 
			return true;
	}

	
	

}
