package it.its.gestioneorchestra.concreto;

import it.its.gestioneorchestra.astratto.Strumento;
import it.its.gestioneorchestra.enumeratori.TipoStrumento;

public class Maracas extends Strumento {
	

	public Maracas(String nome, float estensione, TipoStrumento tipo) {
		super(nome, estensione, tipo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void suona() {
		System.out.println("LESGOSKIII Maracas");
	}
	
	
}
