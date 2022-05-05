package it.unibs.codicefiscale;

import java.util.ArrayList;

import javax.xml.stream.XMLStreamException;

public class ElencoPersone {
	
	ArrayList<CodiceFiscale> vettoreCodici = new ArrayList<>();
	ArrayList<Persona> vettorePersone = new ArrayList<>();
	ArrayList<CodiceFiscale> vettoreCodiciErrati = new ArrayList<>();
	ArrayList<String> vettoreComuni = new ArrayList<>();
	
	//nuovo oggetto della classe XML
	private XML dialogo = new XML();
	
	//costruttore
	public ElencoPersone() throws XMLStreamException{
		//invocazione dei metodi sull'oggetto dialogo, in modo da recuperare i dati utili
		dialogo.recuperaCodici(vettoreCodici);
		dialogo.recuperaPersone(vettorePersone);
		dialogo.recuperaComuni(vettoreComuni);
	}
	
	//metodo che crea i rispettivi codici di ogni persona
	public void creaCodici() throws XMLStreamException {
		Persona _persona = new Persona();
		for (int i = 0; i < vettorePersone.size(); i ++) {
			_persona = vettorePersone.get(i);
			_persona.setCodiceComune(dialogo.getCodiceComune(_persona.getNomeComune()));
			CodiceFiscale codice = new CodiceFiscale(_persona.getNomeCodice(), _persona.getCognomeCodice(), 
					_persona.getAnnoCodice(), _persona.getCodiceComune(), _persona.getSessoCodice());
			_persona.setCodice(codice);
		}
	}
	
	
//--------------------------------------------------------verifica codici---------------------------------------------------
	
	//metodo che verifica la presenza del codice della persona nel vettore di codici
	public void presenzaCodicePersone() {
		for (int i = 0; i < vettorePersone.size(); i++) {
			for (int j = 0; j < vettoreCodici.size(); j++) {
				if (vettorePersone.get(i).getCodice().equals(vettoreCodici.get(j))) {
					vettoreCodici.remove(j);
				}
				else 
					vettorePersone.get(i).presenzaCodice(false);
			}
		}
			
	}
	
	//metodo che verifica se tra i codici c'è ne sono invalidi, e li mette in una lista
	public void validitaCodici() throws XMLStreamException {
		for (int i = 0; i < vettoreCodici.size(); i++) {
			CodiceFiscale verifica = vettoreCodici.get(i);
			if (!verifica.controlloCodice()) {
				vettoreCodiciErrati.add(verifica);
				vettoreCodici.remove(i);
			}
		}	
	}
	
//---------------------------------------------------output-----------------------------------------------------------------
	
	public void stampaOutput() {
		
			dialogo.stampaPersona(vettorePersone);
				
	
	}
	

}
