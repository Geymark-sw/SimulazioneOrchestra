package it.its.gestioneorchestra.concreto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import it.its.gestioneorchestra.astratto.Accordabile;
import it.its.gestioneorchestra.astratto.Strumento;

public class Orchestra {

	private Map<String, Set<Strumento>> strumenti = new HashMap<String, Set<Strumento>>(); // Chiave: Tipo dello
																							// strumento(es. corda,
																							// percussione)
	private String direttore;

	public Orchestra(String direttore) {

		this.direttore = direttore;
	}

	/**
	 * funzione che accorda tutti gli strumenti
	 * 
	 * @author Totti
	 **/
	public void accorda() {
		// controlla se ci sono strumenti da accordare
		for (Set<Strumento> setStrumento : strumenti.values()) {
			for (Strumento strumento : setStrumento) {
				// qui vengono accordati solo gli strumenti accordabili
				// controllo per capire se lo strumento implementa l'interfaccia accordabile
				if (strumento instanceof Accordabile) {
					((Accordabile) strumento).accorda();
				}
			}

		}
		// se la variabile check è uguale al valore della lunghezza dell'array non ci
		// sono strumenti da accordare
		if (strumenti.size() == 0) {
			System.out.println("Non è presente nessuno strumento da accordare");
		}
	}

	/** funzione che ci permette di suonare tutti gli strumenti **/
	public void suona() {
		// controlla se ci sono strumenti da accordare
		for (Set<Strumento> setStrumento : strumenti.values()) {
			for (Strumento strumento : setStrumento) {
				strumento.suona();
			}
		}

		// se la variabile check è uguale al valore della lunghezza dell'array non ci
		// sono strumenti da suonare
		if (strumenti.size() == 0) {
			System.out.println("Non è presente nessuno strumento da suonare");
		}
	}

	public String getDirettore() {
		return direttore;
	}

	public void setDirettore(String direttore) {
		this.direttore = direttore;
	}

	@Override  //\t serve per spostare il testo a destra di una tabulazione nell'output
	public String toString() {
		String stampa = "Orchestra: \n" + "\tStrumenti:\n";
		for (String chiave : this.strumenti.keySet()) {
			stampa += "Strumenti di tipo " + chiave.substring(0,1).toUpperCase() + chiave.substring(1) + "\n";
			for (Strumento strumento : this.strumenti.get(chiave)) {
				stampa += "\t" + strumento;
			}
		}
		stampa += "\nDirettore: " + this.direttore;

		return stampa;
	}

	/**
	 * funzione che ci permette di aggiungere uno strumento alla nostra orchestra
	 * 
	 * @param strumento elemento da aggiungere all'Array
	 **/
	public void aggiungiStrumento(Strumento strumento) {
		try {
			// tipoStrumento identifica la tipologia della strumento da cercare, ossia la chiave della mappa
			String tipoStrumento = strumento.getTipo().name();
			Set<Strumento> setDiRiferimento = this.strumenti.get(tipoStrumento);
			// nella casistica in cui il set non dovesse esistere, viene creato da zero
			if (setDiRiferimento == null) {
				setDiRiferimento = new HashSet<Strumento>();
				strumenti.put(tipoStrumento, setDiRiferimento);
			}
			// se tutto va a buon fine lo strumento viene inserito
			setDiRiferimento.add(strumento);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * funzione che ci permette di cancellare uno strumento dandogli in pasto il suo
	 * id
	 * 
	 * @param id identifica l'oggetto
	 **/
	public void cancellaStrumento(int id) {
		Strumento strumento = cercaStrumentoPerId(id);
		if (strumento != null) {
			// tipoStrumento identifica la tipologia della strumento da cercare, ossia la chiave della mappa
			String tipoStrumento = strumento.getTipo().name();
			Set<Strumento> setStrumentoTrovato = this.strumenti.get(tipoStrumento);
			// dopo aver trovato lo strumento lo si rimuove dal suo set
			setStrumentoTrovato.remove(strumento);
			// nel caso in cui il set, dopo l'eliminazione, sia vuoto, si cancella sia la chiave che il set stesso.
			if (setStrumentoTrovato.isEmpty()) {
				this.strumenti.remove(tipoStrumento, setStrumentoTrovato);
			}
		} 
		
	}

	/**
	 * funzione che ci permette di cercare uno strumento dandogli in pasto il suo id
	 * 
	 * @param id
	 **/
	public Strumento cercaStrumentoPerId(int id) {

		for (Set<Strumento> setStrumento : strumenti.values()) {
			for (Strumento strumento : setStrumento) {
				if (strumento.getId() == id) {
					return strumento;
				}
			}
		}

		return null;
	}
	/**
	 * funzione che ci permette di ridimensionare il nostro array qualora servisse
	 **/
	/*
	 * public void travaso() { if (this.strumenti[strumenti.length - 1] != null) {
	 * Strumento[] travasato = new Strumento[strumenti.length * 2]; for (int i = 0;
	 * i < strumenti.length; i++) { travasato[i] = strumenti[i]; } this.strumenti =
	 * travasato; } }
	 */

}
