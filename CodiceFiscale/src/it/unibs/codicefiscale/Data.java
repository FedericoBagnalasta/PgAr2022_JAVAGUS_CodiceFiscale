package it.unibs.codicefiscale;

public class Data {
	private int giorno;
	private int mese;
	private int anno;
	
	public Data(int _giorno, int _mese, int _anno) {
		giorno = _giorno;
		mese = _mese;
		anno = _anno;
	}

	public Data() {
	
	}

	public String dataCodice() {
		String stringaCaratteriMesi = "ABCDEHLMPRST";
		char  mesi[] = stringaCaratteriMesi.toCharArray();
		int annoTagliato = anno % 100;
		String dataCodice = "" + annoTagliato + mesi[mese];	
		return dataCodice;
		
	}
	
	public String stampaData() { 
		return "" + "-" + anno + "-" + mese + "-" + giorno;
	}
	
	
}
