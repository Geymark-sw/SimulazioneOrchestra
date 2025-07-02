package it.its.gestioneorchestra.concreto;

import it.its.gestioneorchestra.astratto.Accordabile;
import it.its.gestioneorchestra.astratto.Strumento;
import it.its.gestioneorchestra.enumeratori.TipoStrumento;

public class Chitarra extends Strumento implements Accordabile {

	public Chitarra(String nome, float estensione) {
		super(nome, estensione, TipoStrumento.corda);
		// TODO Auto-generated constructor stub
	}

	private boolean isAccordato = false;
	
	@Override
	public void accorda() {
		this.isAccordato = true;
	}

	@Override
	public void suona() {
		if (this.isAccordato) {
			System.out.println("Se gode");
		} else {
			System.out.println("piagni");
		}
		
	}
	
}
