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
		String nomeCodice = "";
		char [] consonanti = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'z',
							'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'Z'};
		char [] vocali = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
		
			String consonantiCodice = "", vocaliCodice = "";
			
				for(int i=0; i < nomePersona.length(); i++) {
				for(int j=0; j < consonanti.length; j++) {
				if(nomePersona.charAt(i) == consonanti[j]){
					consonantiCodice.concat(nomePersona.substring(i, i+1));
					}
				}
				for(int j=0; j < vocali.length; j++) {
				if(nomePersona.charAt(i) == vocali[j]){
					vocaliCodice.concat(nomePersona.substring(i, i+1));
					}
				}
				}
				if(consonantiCodice.length()==3) {
					nomeCodice = consonantiCodice;
				}
				else if(consonantiCodice.length()<3) {
					nomeCodice = consonantiCodice;
					if(vocaliCodice.length() + nomeCodice.length() < 3) {
						while(nomeCodice.length()<3) {
							nomeCodice.concat("X");
						}
					}
					else nomeCodice.concat(vocaliCodice.substring(0, 3-consonantiCodice.length()));
				}
				else if(consonantiCodice.length()>3) {
					nomeCodice.concat(consonantiCodice.substring(0,1));
					nomeCodice.concat(consonantiCodice.substring(2,4));
				}
		return nomeCodice;
	}

	public String getCognomePerCodice(String cognomePersona) {
		String cognomeCodice = "";
		char [] consonanti = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'z',
							'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'Z'};
		char [] vocali = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
		
		String consonantiCodice = "", vocaliCodice = "";
		
		for(int i=0; i < cognomePersona.length(); i++) {
			for(int j=0; j < consonanti.length; j++) {
			if(cognomePersona.charAt(i) == consonanti[j]){
				consonantiCodice.concat(cognomePersona.substring(i, i+1));
				}
			}
			for(int j=0; j < vocali.length; j++) {
			if(cognomePersona.charAt(i) == vocali[j]){
				vocaliCodice.concat(cognomePersona.substring(i, i+1));
				}
			}
		}
		for(int i=0; i<3; i++) {
		if(consonantiCodice.length() > i) {
			cognomeCodice.concat(consonantiCodice.substring(i, i+1));
			}
		else if (vocaliCodice.length() > i) {
			cognomeCodice.concat(vocaliCodice.substring(i, i+1));
			}
		}	
		return cognomeCodice;
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
	
	public String getGiornoPerCodice(int giornoPersona) {
		String monoGiorno;
		String _giornoPersona = "0";
		
		if(giornoPersona < 10) {
			monoGiorno = String.valueOf(giornoPersona);
			_giornoPersona.concat(monoGiorno);
		}		
		if(giornoPersona >= 10 && giornoPersona <= 31) _giornoPersona = String.valueOf(giornoPersona);
		
		if(sesso == 'F') {
			giornoPersona = giornoPersona + 40;
			_giornoPersona = String.valueOf(giornoPersona);
		}
		if(sesso == 'M') {
			monoGiorno = String.valueOf(giornoPersona);
			_giornoPersona.concat(monoGiorno);
		}
		return _giornoPersona;
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
