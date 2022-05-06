package it.unibs.codicefiscale;

public class Persona {
	
	private String nomeComuneNascita;
	private String nome;
	private String cognome;
	private String sesso;
	private boolean presenzaCodice = false;
	private String codiceComune;
	private CodiceFiscale cf = new CodiceFiscale(null);
	private Data dataNascita = new Data();

	
	public Persona() {
		
	}
	
	public void setNomePersona(String text) {
		nome = text;		
	}
	public void setCognome(String text) {
		cognome = text;
	}
	public String getNomePersona() {
		return nome;
	}
	public String getCognome() {
		return cognome;
	}


	
//-------------------------------------------------------------comune----------------------------------------------------------------

	public void setNomeComune(String text) {
		nomeComuneNascita = text;
	}
	public String getNomeComune() {
		return nomeComuneNascita;
	}
	
	
	public void setCodiceComune(String codiceComune) {
		this.codiceComune = codiceComune;		
	}
	public String getCodiceComune() {
		return codiceComune;
	}
	
	
//-------------------------------------------------------------codiceF----------------------------------------------------------------	
	
	public void setCodice(CodiceFiscale codice) {
		this.cf = codice;
	}
	
	public CodiceFiscale getCodice() {
		return cf;
	}
	
	
//------------------------------------------------------dati per creare codice-------------------------------------------------------
	
	public String getNomePerCodice() {
		return null;
	}

	public String getCognomePerCodice() {
		return null;
	}

	public String getAnnoPerCodice() {
		return dataNascita.dataCodice();
	}
	
	
	public String getSessoPerCodice() {
		return sesso;
	}
	
	public void setSesso(String text) {
		this.sesso = text;
	}
	
	public String getGiornoPerCodice() {
		return null;
	}
	
	
//-------------------------------------------------------------data------------------------------------------------------------------

	public void setData(String text) {
		int anno = Integer.parseInt(text.substring(0, 4));
		int mese = Integer.parseInt(text.substring(5, 7));
		int giorno = Integer.parseInt(text.substring(8, 10));
		dataNascita.impostaData(giorno, mese, anno);	
	}
	
	public Data getDataNascita() {
		return dataNascita;	
	}
	
	
//------------------------------------------------metodi di verifica-----------------------------------------------------------------	
	
	public boolean getpresenzaCodice() {
		return presenzaCodice;
	}
	
	public void setpresenzaCodice(boolean b) {
		this.presenzaCodice = b;
	}
	
	//metodo che controlla che l'oggeto perona sia istanziato
	public boolean presenzaPersona() {
		if (nome == null && cognome == null)
			return false;
		else 
			return true;
	}





	
	

}
