package it.its.gestioneorchestra.astratto;

import it.its.gestioneorchestra.enumeratori.TipoStrumento;
import it.its.gestioneorchestra.exceptions.NegativeValueException;

public abstract class Strumento {
	private static int ultimoID = 0;
	private int id;
	private String nome;
	private float estensione;
	private TipoStrumento tipo;
	
	
	
	public Strumento(String nome, float estensione, TipoStrumento tipo) {
		
		
		this.id = ultimoID;
		ultimoID ++;
		this.nome = nome;
		this.estensione = estensione;
		this.tipo = tipo;
		
		
	}

	

	public static int getUltimoID() {
		return ultimoID;
	}



	public static void setUltimoID(int ultimoID) {
		Strumento.ultimoID = ultimoID;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public float getEstensione() {
		return estensione;
	}



	public void setEstensione(float estensione) {
		this.estensione = estensione;
	}



	public TipoStrumento getTipo() {
		return tipo;
	}



	public void setTipo(TipoStrumento tipo) {
		this.tipo = tipo;
	}



	public abstract void suona();



	@Override
	public String toString() {
		String nomeTipoEffettivo = this.getClass().getName();
		return nomeTipoEffettivo.substring(nomeTipoEffettivo.lastIndexOf(".")+1) + " [id=" + id + ", nome=" + nome + ", estensione=" + estensione + ", tipo=" + tipo + "]\n";
	}


	
	
	


	
	
}
