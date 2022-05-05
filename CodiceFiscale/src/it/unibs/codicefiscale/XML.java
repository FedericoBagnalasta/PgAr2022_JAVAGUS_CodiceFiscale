package it.unibs.codicefiscale;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

public class XML {
	private String tag_persona = "persona";
	private String tag_nome = "nome";
	private String tag_cognome = "cognome";
	private String tag_sesso = "sesso";
	private String tag_comune = "comune_nascita";
	private String tag_data = "data_nascita";
	private final static String filename = "inputPersone.xml";
	private static String fileValoreCaratteri = "";
	
	XMLInputFactory xmlif;
	XMLStreamReader xmlr ;
	
	
	public XML() {
	}
	
//---------------------------------------------metodi che recuperano i valori dai file------------------------------------	
	
	//metodo che legge dal file xml i codici e li mette in una lista
	public void recuperaCodici(ArrayList<CodiceFiscale> vettoreCodici) {
	}

	//metodo che legge dal file xml le persone e le inserisce nell'arrey
	public void recuperaPersone(ArrayList<Persona> vettorePersone) throws XMLStreamException {
		
		{
			try {
		xmlif = XMLInputFactory.newInstance();
		xmlr = xmlif.createXMLStreamReader(filename , new FileInputStream(filename));
		} catch (Exception e) {
		System.out.println("Errore nell'inizializzazione del reader:");
		System.out.println(e.getMessage());}
		}
		
		
		String next = null;
		//bisogna creare una persona con i dati del file e poi aggiungere la persona al vettore
		Persona p = new Persona();
		while (xmlr.hasNext()) { // continua a leggere finché ha eventi a disposizione
			
			switch (xmlr.getEventType()) { // switch sul tipo di evento
			case XMLStreamConstants.START_DOCUMENT: // inizio del documento: stampa che inizia il documento
				System.out.println("Start Read Doc " + filename); 
				break;
			
			case XMLStreamConstants.START_ELEMENT: // inizio di un elemento: stampa il nome del tag e i suoi attributi
			     if (xmlr.getLocalName().equals(tag_nome)) {
			    	 next = tag_nome;
			     }
			     else if (xmlr.getLocalName().equals(tag_cognome)) {
			    	 next = tag_cognome;
				     }
			     else if (xmlr.getLocalName().equals(tag_sesso)) {
			    	 next = tag_sesso;
				     }
			     else if (xmlr.getLocalName().equals(tag_data)) {
			    	 next = tag_data;
				     }
			     else if (xmlr.getLocalName().equals(tag_comune)) {
			    	 next = tag_comune;
				     }
			     System.out.println("open-Tag " + xmlr.getLocalName());
			
			case XMLStreamConstants.END_ELEMENT: // fine di un elemento: stampa il nome del tag chiuso
				 if (xmlr.getLocalName().equals(tag_persona) && p.presenzaPersona()) {
					 vettorePersone.add(p);
					 p = new Persona();
			     } 
				System.out.println("END-Tag " + xmlr.getLocalName()); 
				break;
			
			case XMLStreamConstants.COMMENT:
				 System.out.println("// commento " + xmlr.getText()); 
				 break; // commento: ne stampa il contenuto
			
			case XMLStreamConstants.CHARACTERS: // content all’interno di un elemento: stampa il testo
				if (xmlr.getText().trim().length() > 0) {// controlla se il testo non contiene solo spazi
					
					if (next.equals(tag_nome))
						p.setNome(xmlr.getText()); 
					else if (next.equals(tag_cognome))
						p.setCognome(xmlr.getText());
					else if (next.equals(tag_sesso))
						p.setSesso(xmlr.getText());
					else if (next.equals(tag_comune))
						p.setNomeComune(xmlr.getText());
					else if (next.equals(tag_data))
						p.setData(xmlr.getText());
					
					
				System.out.println("-> " + xmlr.getText());
				
				}
			break;
			}
			xmlr.next();
			}
	}

	//metodo che crea due file necessari a calcolare il carattere di controllo
	public void stampaCaratteri(String pari_dispari) {
		String[] caratteri = {"0",  "1",  "2",  "3",  "4",  "5",  "6",  "7",  "8",  "9", 
				"A",  "B",  "C",  "D",  "E",  "F",  "G",  "H",  "I",  "J",  "K",  "L",  "M",  
				"N",  "O",  "P",  "Q",  "R",  "S",  "T",  "U",  "V",  "W",  "X",  "Y",  "Z",};
		String[] valoriCaratteriDispari = {"1",  "0",  "5",  "7",  "9",  "13",  "15",  "17",  "19", 
				"21",  "1",  "0",  "5",  "7",  "9",  "13",  "15",  "17",  "19",  "21",  "2",
				"4",  "18",  "20",  "11",  "3", "6", "8", "12", "14", "16", "10", "22", "25", 
				"24", "23"};
		String[] valoriCaratteriPari = {"0",  "1",  "2",  "3",  "4",  "5",  "6",  "7",  "8",
				"9",  "0",  "1",  "2",  "3",  "4",  "5",  "6",  "7",  "8",  "9",  "10",  "11",
				"12",  "13",  "14",  "15",  "16",  "17",  "18",  "19",  "20",  "21",  "22",
				"23",  "24",  "25"};
		String[] vettore = {};
		
		if (pari_dispari.equals("pari")) {
			fileValoreCaratteri = "valore carattere pari.xml";
			vettore = Arrays.copyOf(valoriCaratteriPari, valoriCaratteriPari.length);
		}
		else if (pari_dispari.equals("dispari")) {
			fileValoreCaratteri = "valore carattere dispari.xml";
			vettore = Arrays.copyOf(valoriCaratteriDispari, valoriCaratteriDispari.length);
		}
		else {
			System.out.println("specificare di quale categoria di caratteri si vuole creare il file");
			return;
		}

		XMLOutputFactory xmlof = null;
		XMLStreamWriter xmlw = null;
		{
			try {
		xmlof = XMLOutputFactory.newInstance();
		xmlw = xmlof.createXMLStreamWriter(new FileOutputStream(fileValoreCaratteri), "utf-8");
		xmlw.writeStartDocument("utf-8", "1.0");
		} catch (Exception e) {
		System.out.println("Errore nell'inizializzazione del writer:");
		System.out.println(e.getMessage());
			}
		}
		
		try { // blocco try per raccogliere eccezioni
		xmlw.writeStartElement("valoricaratteri"); // scrittura del tag radice <programmaArnaldo>
		for (int i = 0; i < caratteri.length; i++) {
		xmlw.writeStartElement("carattere"); // scrittura del tag autore...
		xmlw.writeAttribute("valore", vettore[i]); // ...con attributo id...
		xmlw.writeCharacters(caratteri[i]); // ...e content dato
		xmlw.writeEndElement(); // chiusura di </autore>
		}
		xmlw.writeEndElement(); // chiusura di </programmaArnaldo>
		xmlw.writeEndDocument(); // scrittura della fine del documento
		xmlw.flush(); // svuota il buffer e procede alla scrittura
		System.out.println("scrittura");
		xmlw.close(); // chiusura del documento e delle risorse impiegate
		} catch (Exception e) { // se c’è un errore viene eseguita questa parte
		System.out.println("Errore nella scrittura");
		}
	}
	
	//metodo che legge dal file xml i codici dei comuni e li mette in una lista
	public void recuperaComuni(ArrayList<String> vettoreComuni) {		
	}
//--------------------------------------------------------metodi carattere controllo--------------------------------------
	
	public int valoreNumeroDispari(char charAt) throws XMLStreamException {
	
		{
		try {
			xmlif = XMLInputFactory.newInstance();
			xmlr = xmlif.createXMLStreamReader("valore carattere dispari.xml" , new FileInputStream("valore carattere dispari.xml"));
			} catch (Exception e) {
			System.out.println("Errore nell'inizializzazione del reader:");
			System.out.println(e.getMessage());}
			}
		
		int next = 0;
		while (xmlr.hasNext()) { // continua a leggere finché ha eventi a disposizione
			
			switch (xmlr.getEventType()) { // switch sul tipo di evento
			case XMLStreamConstants.START_DOCUMENT: // inizio del documento: stampa che inizia il documento
				//System.out.println("Start Read Doc " + "valore carattere dispari.xml"); 
				break;
			
			case XMLStreamConstants.START_ELEMENT: // inizio di un elemento: stampa il nome del tag e i suoi attributi
			     if (xmlr.getLocalName().equals("carattere")) {
			    	 next = Integer.parseInt(xmlr.getAttributeValue(0));
			     }
			     break;
			     
			case XMLStreamConstants.CHARACTERS: // content all’interno di un elemento: stampa il testo
				if (xmlr.getText().trim().length() > 0) {// controlla se il testo non contiene solo spazi
					Character y = xmlr.getText().charAt(0);
					if (y.equals(charAt)) {
						return next;
					}
				}
			break;
			}
			xmlr.next();
			}
		return next;
	}

	public int valoreNumeroPari(char charAt) throws XMLStreamException {
		
		{
		try {
			xmlif = XMLInputFactory.newInstance();
			xmlr = xmlif.createXMLStreamReader("valore carattere pari.xml" , new FileInputStream("valore carattere pari.xml"));
			} catch (Exception e) {
			System.out.println("Errore nell'inizializzazione del reader:");
			System.out.println(e.getMessage());}
			}
		
		int next = 0;
		while (xmlr.hasNext()) { // continua a leggere finché ha eventi a disposizione
			
			switch (xmlr.getEventType()) { // switch sul tipo di evento
			case XMLStreamConstants.START_DOCUMENT: // inizio del documento: stampa che inizia il documento
				//System.out.println("Start Read Doc " + "valore carattere pari.xml"); 
				break;
			
			case XMLStreamConstants.START_ELEMENT: // inizio di un elemento: stampa il nome del tag e i suoi attributi
			     if (xmlr.getLocalName().equals("carattere")) {
			    	 next = Integer.parseInt(xmlr.getAttributeValue(0));
			     }
			     break;
			     
			case XMLStreamConstants.CHARACTERS: // content all’interno di un elemento: stampa il testo
				if (xmlr.getText().trim().length() > 0) {// controlla se il testo non contiene solo spazi
					Character y = xmlr.getText().charAt(0);
					if (y.equals(charAt)) {
						return next;
					}
				}
			break;
			}
			xmlr.next();
			}
		return next;
	}

	public char valoreCarattereControllo(int resto) {
		// TODO Auto-generated method stub
		return 's';
	}
	
	
//----------------------------------------------------fine metodi carattere controllo--------------------------------------

//----------------------------------------------------metodi di stampa------------------------------------------------------
	public Object getCodiceComune(Object nomeComune) {
		// TODO Auto-generated method stub
		return null;
	}

	public void stampaPersona(ArrayList<Persona> vettorePersone) {
		int dimensione = vettorePersone.size();
		for(int i = 0; i < vettorePersone.size(); i++ ) {
			Persona personaAttuale = vettorePersone.get(i);
			
			
			personaAttuale.getDataNascita().stampaData();
		}		
			
		
	}

}
