package it.unibs.codicefiscale;

public class Persona {
	
	private String nomeComuneNascita;
	private String nome;
	private String cognome;
	private String sesso;
	private int giorno;
	private boolean presenzaCodice = false;
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
	public String getSessoPerCodice() {
		return sesso;
	}
	
	public void setSesso(String text) {
		this.sesso = text;
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
	
	//metodo che restituisce una stringa del nome della persona, predisposta per la creazione di un codice fiscale
	public String getNomePerCodice() {
		String nomeCodice = "";
		char [] consonanti = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'z',
							'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'Z'};
		char [] vocali = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
		
			String consonantiCodice = "", vocaliCodice = "";
			
				for(int i=0; i < nome.length(); i++) {
				for(int j=0; j < consonanti.length; j++) {
				if(nome.charAt(i) == consonanti[j]){
					consonantiCodice += nome.charAt(i);
					}
				}
				for(int j=0; j < vocali.length; j++) {
				if(nome.charAt(i) == vocali[j]){
					vocaliCodice += nome.charAt(i);
					}
				}
				}
				if(consonantiCodice.length()==3) {
					nomeCodice = consonantiCodice;
				}
				else if(consonantiCodice.length()<3) {
					nomeCodice = consonantiCodice;
					if((vocaliCodice.length() + nomeCodice.length()) < 3) {
						while(nomeCodice.length()<3) {
							nomeCodice += "X";
						}
					}
					else nomeCodice += vocaliCodice.substring(0, 3-consonantiCodice.length());
				}
				else if(consonantiCodice.length()>3) {
					nomeCodice += consonantiCodice.substring(0,1);
					nomeCodice += consonantiCodice.substring(2,4);
				}
		return nomeCodice;
	}

	
	//metodo che restituisce una stringa del cognome della persona, predisposta per la creazione di un codice fiscale
	public String getCognomePerCodice() {
		String cognomeCodice = "";
		char [] consonanti = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'z',
							'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'Z'};
		char [] vocali = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
		
		String consonantiCodice = "", vocaliCodice = "";
		
		for(int i=0; i < cognome.length(); i++) {
			for(int j=0; j < vocali.length; j++) {
			if(cognome.charAt(i) == vocali[j]){
				vocaliCodice += cognome.charAt(i);
				break;
				}
			}
			for(int j=0; j < consonanti.length; j++) {
			if(cognome.charAt(i) == consonanti[j]){
				consonantiCodice += cognome.charAt(i);
				break;
				}
			}
			
		}
		if(consonantiCodice.length()==3) {
			cognomeCodice = consonantiCodice;
		}
		else if(consonantiCodice.length()<3) {
			cognomeCodice = consonantiCodice;
			if((vocaliCodice.length() + cognomeCodice.length()) < 3) {
				while(cognomeCodice.length()<3) {
					cognomeCodice += "X";
				}
			}
			else cognomeCodice += vocaliCodice.substring(0, 3-consonantiCodice.length());
		}
		else if(consonantiCodice.length()>3) {
			cognomeCodice += consonantiCodice.substring(0,3);
		}
		return cognomeCodice;
	}

	//metodo che restituisce una stringa dell' anno di nascita della persona, predisposta per la creazione di un codice fiscale
	public String getAnnoPerCodice() {
		return dataNascita.dataCodice();
	}
	
	//metodo che restituisce una stringa del giorno della persona, predisposta per la creazione di un codice fiscale
	public String getGiornoPerCodice() {
		String monoGiorno;
		String _giornoPersona = "0";
		
		if(giorno < 10) {
			monoGiorno = String.valueOf(giorno);
			_giornoPersona += monoGiorno;
		}		
		else 
			_giornoPersona = String.valueOf(giorno);
		if(giorno >= 10 && giorno <= 31) _giornoPersona = String.valueOf(giorno);
		
		if(sesso.equals("F")) {
			giorno = giorno + 40;
			_giornoPersona = String.valueOf(giorno);
		}
		
		return _giornoPersona;
	}
	
	
//-------------------------------------------------------------data------------------------------------------------------------------

	//metodo che istanzia l'oggetto data, partendo da una stringa
	public void setData(String text) {
		int anno = Integer.parseInt(text.substring(0, 4));
		int mese = Integer.parseInt(text.substring(5, 7));
		int giorno = Integer.parseInt(text.substring(8, 10));
		setGiorno(giorno);
		dataNascita.impostaData(giorno, mese, anno);	
	}
	
	private void setGiorno(int giorno) {
	this.giorno = giorno;
	
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
