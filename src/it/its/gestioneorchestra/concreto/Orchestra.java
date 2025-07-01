package it.its.gestioneorchestra.concreto;

import it.its.gestioneorchestra.astratto.Accordabile;
import it.its.gestioneorchestra.astratto.Strumento;

public class Orchestra {
	
	private Strumento[] strumenti;
	private String direttore;

	public Orchestra(String direttore) {
		this.strumenti = new Strumento[10];
		this.direttore = direttore;
	}
	/**
	 * funzione che accorda tutti gli strumenti
	 * 
	 * @author Totti
	 * **/
	public void accorda() {
		//controlla se ci sono strumenti da accordare
		int check = 0;
		for (Strumento strumento : strumenti) {
			//qui vengono accordati solo gli strumenti accordabili
			//controllo per capire se lo strumento implementa l'interfaccia accordabile
			if (strumento instanceof Accordabile) {
				((Accordabile) strumento).accorda();
			}
			check += 1;
			if (strumento != null) {
				check = 0;
			}

		}
		//se la variabile check è uguale al valore della lunghezza dell'array non ci sono strumenti da accordare
		if (check == strumenti.length) {
			System.out.println("Non è presente nessuno strumento da accordare");
		}
	}
	/**funzione che ci permette di suonare tutti gli strumenti**/
	public void suona() {
		//controlla se ci sono strumenti da accordare
		int check = 0;
		for (Strumento strumento : strumenti) {
			check += 1;
			if (strumento != null) {
				check = 0;
				strumento.suona();
			}
		}
		//se la variabile check è uguale al valore della lunghezza dell'array non ci sono strumenti da suonare
		if (check == strumenti.length) {
			System.out.println("Non è presente nessuno strumento da suonare");
		}
	}

	public String getDirettore() {
		return direttore;
	}

	public void setDirettore(String direttore) {
		this.direttore = direttore;
	}

	@Override
	public String toString() {
		String stampa = "Orchestra\n" + "Strumenti:\n";
		for (Strumento s : strumenti) {
			if (s != null)
				stampa += s + "\n";
		}
		stampa += "Direttore: " + this.direttore;

		return stampa;
	}
	/**funzione che ci permette di aggiungere uno strumento alla nostra orchestra
	 * @param strumento elemento da aggiungere all'Array
	 * **/
	public void aggiungiStrumento(Strumento strumento) {
		int lenght = strumenti.length;
		for (int i = 0; i < strumenti.length; i++) {
			if (this.strumenti[i] == null) {
				this.strumenti[i] = strumento;
				return ;
			}
		}
		/**se mi trovo in questo punto tutti gli elementi sono valorizzati
		 * effetto il travaso duplicando la dimensione dell'array**/
		travaso();
		this.strumenti[lenght] = strumento;
	}
	/**funzione che ci permette di cancellare uno strumento dandogli in pasto il suo id
	 * @param id identifica l'oggetto **/
	public Strumento cancellaStrumento(int id) {
		try {
			Strumento mario = null;
			for (int i = 0; i < this.strumenti.length; i++) {
				if (strumenti[i].getId() == id) {
					mario = strumenti[i];
					strumenti[i] = null;
					return mario;
				}
			}
		} catch (java.lang.NullPointerException e) {
			System.out.println("Non è presente nessun oggetto da cancellare con questo ID");
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	/**funzione che ci permette di cercare uno strumento dandogli in pasto il suo id
	 * @param id**/
	public Strumento cercaStrumentoPerId(int id) {
		try {
			for (int i = 0; i < this.strumenti.length; i++) {
				if (strumenti[i].getId() == id) {
					return strumenti[i];
				}
			}
		} catch (java.lang.NullPointerException e) {
			System.out.println("Non è presente nessun oggetto con questo ID");
		}
		return null;
	}
	/**funzione che ci permette di ridimensionare il nostro array qualora servisse**/
	public void travaso() {
		if (this.strumenti[strumenti.length - 1] != null) {
			Strumento[] travasato = new Strumento[strumenti.length * 2];
			for (int i = 0; i < strumenti.length; i++) {
				travasato[i] = strumenti[i];
			}
			this.strumenti = travasato;
		}
	}

}
