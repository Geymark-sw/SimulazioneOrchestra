
public class Chitarra extends Strumento implements Accordabile {

	public Chitarra(String nome, float estensione, TipoStrumento tipo) {
		super(nome, estensione, tipo);
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
