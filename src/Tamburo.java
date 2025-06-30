public class Tamburo extends Strumento implements Accordabile{
	
	
	public Tamburo(String nome, float estensione, TipoStrumento tipo) {
		super(nome, estensione, tipo);
		
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
