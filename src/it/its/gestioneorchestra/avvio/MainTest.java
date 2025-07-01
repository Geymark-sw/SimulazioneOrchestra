package it.its.gestioneorchestra.avvio;

import it.its.gestioneorchestra.astratto.Strumento;
import it.its.gestioneorchestra.concreto.Chitarra;
import it.its.gestioneorchestra.concreto.Maracas;
import it.its.gestioneorchestra.concreto.Orchestra;
import it.its.gestioneorchestra.concreto.Tamburo;
import it.its.gestioneorchestra.enumeratori.TipoStrumento;

public class MainTest {
	public static void main(String[] args) {
		
		testAggiungi();
		testCercaId();
		testTravaso();
		testEliminaId();
		testAccorda();
		testSuona();
		testStampa();
	}

	public static void testAggiungi() {
		Orchestra orchestra1 = new Orchestra("Mario");
		Strumento str = new Tamburo("Marione", 12, TipoStrumento.percussione);
		Strumento str2 = new Chitarra("Ross", 5, TipoStrumento.corda);
		Strumento str3 = new Maracas("Davide", 2, TipoStrumento.percussione);
		Strumento vuoto = new Tamburo("", 5, TipoStrumento.fiato);
		orchestra1.aggiungiStrumento(str);
		orchestra1.aggiungiStrumento(str2);
		orchestra1.aggiungiStrumento(str3);
		orchestra1.aggiungiStrumento(vuoto);
	}
	
	public static void testTravaso() {
		Orchestra orchestra1 = new Orchestra("Mario");
		Strumento str = new Tamburo("Marione", 12, TipoStrumento.percussione);
		Strumento str2 = new Chitarra("Ross", 5, TipoStrumento.corda);
		Strumento str3 = new Maracas("Davide", 2, TipoStrumento.percussione);
		Strumento vuoto = new Tamburo("", 5, TipoStrumento.fiato);
		Strumento str4 = new Tamburo("Marione", 12, TipoStrumento.percussione);
		Strumento str5 = new Chitarra("Ross", 5, TipoStrumento.corda);
		Strumento str6 = new Maracas("Davide", 2, TipoStrumento.percussione);
		Strumento vuoto2 = new Tamburo("", 5, TipoStrumento.fiato);
		Strumento str7 = new Tamburo("Marione", 12, TipoStrumento.percussione);
		Strumento str8 = new Chitarra("Ross", 5, TipoStrumento.corda);
		Strumento str9 = new Maracas("Davide", 2, TipoStrumento.percussione);
		Strumento vuoto3 = new Tamburo("", 5, TipoStrumento.fiato);
		Strumento str12 = new Tamburo("Marione", 12, TipoStrumento.percussione);
		Strumento str2323 = new Chitarra("Ross", 5, TipoStrumento.corda);
		Strumento str342 = new Maracas("Davide", 2, TipoStrumento.percussione);
		Strumento vuoto42 = new Tamburo("", 5, TipoStrumento.fiato);
		Strumento str4424 = new Tamburo("Marione", 12, TipoStrumento.percussione);
		Strumento str552 = new Chitarra("Ross", 5, TipoStrumento.corda);
		Strumento str612 = new Maracas("Davide", 2, TipoStrumento.percussione);
		Strumento vuoto242 = new Tamburo("", 5, TipoStrumento.fiato);
		Strumento str712 = new Tamburo("Marione", 12, TipoStrumento.percussione);
		Strumento str844 = new Chitarra("Ross", 5, TipoStrumento.corda);
		Strumento str9124 = new Maracas("Davide", 2, TipoStrumento.percussione);
		Strumento vuoto324 = new Tamburo("", 5, TipoStrumento.fiato);
		orchestra1.aggiungiStrumento(str);
		orchestra1.aggiungiStrumento(str2);
		orchestra1.aggiungiStrumento(str3);
		orchestra1.aggiungiStrumento(vuoto);
		orchestra1.aggiungiStrumento(str4);
		orchestra1.aggiungiStrumento(str5);
		orchestra1.aggiungiStrumento(str6);
		orchestra1.aggiungiStrumento(vuoto2);
		orchestra1.aggiungiStrumento(str7);
		orchestra1.aggiungiStrumento(str8);
		orchestra1.aggiungiStrumento(str9);
		orchestra1.aggiungiStrumento(vuoto3);
		orchestra1.aggiungiStrumento(str12);
		orchestra1.aggiungiStrumento(str2323);
		orchestra1.aggiungiStrumento(str342);
		orchestra1.aggiungiStrumento(vuoto42);
		orchestra1.aggiungiStrumento(str4424);
		orchestra1.aggiungiStrumento(str552);
		orchestra1.aggiungiStrumento(str612);
		orchestra1.aggiungiStrumento(vuoto242);
		orchestra1.aggiungiStrumento(str712);
		orchestra1.aggiungiStrumento(str844);
		orchestra1.aggiungiStrumento(str9124);
		orchestra1.aggiungiStrumento(vuoto324);

		
	
	}

	public static void testCercaId() {
		Orchestra orchestra1 = new Orchestra("Mario");
		Strumento str = new Tamburo("Marione", 12, TipoStrumento.percussione);
		Strumento str2 = new Chitarra("Ross", 5, TipoStrumento.corda);
		Strumento str3 = new Maracas("Davide", 2, TipoStrumento.percussione);
		Strumento vuoto = new Tamburo("", 5, TipoStrumento.fiato);
		orchestra1.aggiungiStrumento(str);
		orchestra1.aggiungiStrumento(str2);
		orchestra1.aggiungiStrumento(str3);
		orchestra1.aggiungiStrumento(vuoto);
		
		orchestra1.cercaStrumentoPerId(0);
		orchestra1.cercaStrumentoPerId(1);
		orchestra1.cercaStrumentoPerId(2);
		orchestra1.cercaStrumentoPerId(9999);
		orchestra1.cercaStrumentoPerId(-9999);
		
	}

	public static void testEliminaId() {
		Orchestra orchestra1 = new Orchestra("Mario");
		Strumento str = new Tamburo("Marione", 12, TipoStrumento.percussione);
		Strumento str2 = new Chitarra("Ross", 5, TipoStrumento.corda);
		Strumento str3 = new Maracas("Davide", 2, TipoStrumento.percussione);
		Strumento vuoto = new Tamburo("", 5, TipoStrumento.fiato);
		orchestra1.aggiungiStrumento(str);
		orchestra1.aggiungiStrumento(str2);
		orchestra1.aggiungiStrumento(str3);
		orchestra1.aggiungiStrumento(vuoto);
		
		orchestra1.cancellaStrumento(0);
		orchestra1.cancellaStrumento(1);
		orchestra1.cancellaStrumento(2);
		orchestra1.cancellaStrumento(9999);
		orchestra1.cancellaStrumento(-17);
		
	}

	public static void testStampa() {
		Orchestra orchestra1 = new Orchestra("Mario");
		Strumento str = new Tamburo("Marione", 12, TipoStrumento.percussione);
		Strumento str2 = new Chitarra("Ross", 5, TipoStrumento.corda);
		Strumento str3 = new Maracas("Davide", 2, TipoStrumento.percussione);
		Strumento vuoto = new Tamburo("", 5, TipoStrumento.fiato);
		orchestra1.aggiungiStrumento(str);
		orchestra1.aggiungiStrumento(str2);
		orchestra1.aggiungiStrumento(str3);
		orchestra1.aggiungiStrumento(vuoto);
		
		System.out.println(orchestra1.toString());
	}

	public static void testAccorda() {
		Orchestra orchestra1 = new Orchestra("Mario");
		Strumento str = new Tamburo("Marione", 12, TipoStrumento.percussione);
		Strumento str2 = new Chitarra("Ross", 5, TipoStrumento.corda);
		Strumento str3 = new Maracas("Davide", 2, TipoStrumento.percussione);
		Strumento vuoto = new Tamburo("", 5, TipoStrumento.fiato);
		orchestra1.aggiungiStrumento(str);
		orchestra1.aggiungiStrumento(str2);
		orchestra1.aggiungiStrumento(str3);
		orchestra1.aggiungiStrumento(vuoto);
		
		orchestra1.accorda();
	}

	public static void testSuona() {
		Orchestra orchestra1 = new Orchestra("Mario");
		Strumento str = new Tamburo("Marione", 12, TipoStrumento.percussione);
		Strumento str2 = new Chitarra("Ross", 5, TipoStrumento.corda);
		Strumento str3 = new Maracas("Davide", 2, TipoStrumento.percussione);
		Strumento vuoto = new Tamburo("", 5, TipoStrumento.fiato);
		orchestra1.aggiungiStrumento(str);
		orchestra1.aggiungiStrumento(str2);
		orchestra1.aggiungiStrumento(str3);
		orchestra1.aggiungiStrumento(vuoto);
		
		orchestra1.suona();
		orchestra1.accorda();
		orchestra1.suona();

	}

}
