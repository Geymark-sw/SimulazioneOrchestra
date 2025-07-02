package it.its.gestioneorchestra.concreto;

import it.its.gestioneorchestra.astratto.Accordabile;
import it.its.gestioneorchestra.astratto.Strumento;
import it.its.gestioneorchestra.enumeratori.TipoStrumento;

public class Tamburo extends Strumento implements Accordabile{
	
	
	
	public Tamburo(String nome, float estensione) {
		super(nome, estensione, TipoStrumento.percussione);
		
	}

	private boolean isAccordato = false;
	@Override
	public void suona() {
		if (this.isAccordato) {
			System.out.println("Se gode");
		} else {
			System.out.println("piagni");
		}
	}

	@Override
	public void accorda() {
		this.isAccordato = true;
	}

	public boolean isAccordato() {
	
		return isAccordato;
	}


	
	

	
}
