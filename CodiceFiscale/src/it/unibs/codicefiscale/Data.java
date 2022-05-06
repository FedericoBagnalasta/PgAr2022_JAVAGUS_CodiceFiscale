package it.unibs.codicefiscale;

public class Data {
	private int giorno;
	private int mese;
	private int anno;
	

	public Data() {
	
	}
	
	public void impostaData(int _giorno, int _mese, int _anno) {
		giorno = _giorno;
		mese = _mese;
		anno = _anno;
	}
	public String dataCodice() {
		String stringaCaratteriMesi = "ABCDEHLMPRST";
		char  mesi[] = stringaCaratteriMesi.toCharArray();
		int annoTagliato = anno % 100;
		if (annoTagliato < 10) {
		String dataCodice = "" + "0" + annoTagliato + mesi[mese-1];	
		return dataCodice;
		}
		else {
			String dataCodice = "" + annoTagliato + mesi[mese-1];	
			return dataCodice;
		}
		
	}
	
	public String stampaData() { 
		String h = "" ;
		h += anno + "-";
		if (mese < 10) h += "0" + mese + "-";
		else h += mese + "-";
		if (giorno < 10) h += "0" + giorno;
		else h += giorno;
		return h;
	}
	
	public int getGiornoPerCodice() {
		return giorno;
	}
	
	
}
