package it.unibs.codicefiscale;

public class Persona {
	
	private String nomeComuneNascita;
	private String nome;
	private String cognome;
	private char sesso;
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
	
	public String getNomePerCodice(String nomePersona) {
		String nomeCodice;
		char [] consonanti = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'z'};
		if(nomePersona.length()<4) {
			nomeCodice = nomePersona;
			while(nomeCodice.length()<3) {
				nomeCodice.concat("X");
			}
		}
		else {
			String consonantiCodice;
			for(int i=0; i<nomePersona.length(); i++) {
				for(int j=0; j<consonanti.length; j++) {
				if(CharacterCompare(nomePersona.charAt(i), consonanti(j)){
					
					}
				}
			}
		}
		
		return null;
	}

	public String getCognomePerCodice() {
		return null;
	}

	public String getAnnoPerCodice() {
		return dataNascita.dataCodice();
	}
	
	
	public char getSessoPerCodice() {
		return sesso;
	}
	
	public void setSesso(String text) {
		this.sesso = (text.charAt(0));
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
