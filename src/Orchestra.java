public class Orchestra {

	private Strumento[] strumenti = new Strumento[10];
	private String direttore;

	public Orchestra(String direttore) {
		this.direttore = direttore;
	}

	public void accorda() {
		int check = 0;
		for (Strumento strumento : strumenti) {

			if (strumento instanceof Accordabile) {
				((Accordabile) strumento).accorda();
			}
			check += 1;
			if (strumento != null) {
				check = 0;
			}

		}
		if (check == strumenti.length) {
			System.out.println("Non è presente nessuno strumento da accordare");
		}
	}

	public void suona() {
		int check = 0;
		for (Strumento strumento : strumenti) {
			check += 1;
			if (strumento != null) {
				check = 0;
				strumento.suona();
			}
		}
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

	public void aggiungiStrumento(Strumento strumento) {
		int lenght = strumenti.length;
		for (int i = 0; i < strumenti.length; i++) {
			if (this.strumenti[i] == null) {
				this.strumenti[i] = strumento;
				break;
			}
		}
		travaso();
		this.strumenti[lenght] = strumento;
	}

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
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public Strumento cercaStrumentoPerId(int id) {
		try {
			for (int i = 0; i < this.strumenti.length; i++) {
				if (strumenti[i].getId() == id) {
					return strumenti[i];
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

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
