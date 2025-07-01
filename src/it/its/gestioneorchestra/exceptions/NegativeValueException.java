package it.its.gestioneorchestra.exceptions;

public class NegativeValueException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int value;
	
	public NegativeValueException(int value) {
		super("Atteso valore superiore o uguale a 0, valore riscontrato: " + value);
		this.value = value;
		
	}
	
	public NegativeValueException() {
		super("Il valore è inferiore a 0");
	}
	
	public NegativeValueException(String msg) {
		super(msg);
	}
	
	public NegativeValueException(float value) {
		super("Atteso valore superiore o uguale a 0, valore riscontrato: " + value);
		
	}


	
	
}
