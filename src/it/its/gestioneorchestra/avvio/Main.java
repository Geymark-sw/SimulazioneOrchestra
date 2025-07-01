package it.its.gestioneorchestra.avvio;

import java.util.Scanner;

import it.its.gestioneorchestra.astratto.Strumento;
import it.its.gestioneorchestra.concreto.Chitarra;
import it.its.gestioneorchestra.concreto.Maracas;
import it.its.gestioneorchestra.concreto.Orchestra;
import it.its.gestioneorchestra.concreto.Tamburo;
import it.its.gestioneorchestra.enumeratori.TipoStrumento;
import it.its.gestioneorchestra.exceptions.NegativeValueException;

public class Main {

	public static void main(String[] args) {

		// Fase di inserimento dei dati
		System.out.println("Benvenuto nel gestore della tua orchestra");
		Scanner input = new Scanner(System.in);
		//String verifica = "s";
		Orchestra orchestra1 = new Orchestra("Mario"); // Fase di istanziazione dell'orchestra

		// ciclo utilizzato per la gestione del menu
		while (true) {
			System.out.println(
					"Inserisci un comando:" + "\n1. Aggiungi strumento all'orchestra" + "\n2. Cerca lo strumento per id"
							+ "\n3. Cancella lo strumento per id" + "\n4. Stampa tutta l'orchestra"
							+ "\n5. Accorda tutti gli strumenti" + "\n6. Musica maestro" + "\n7. Exit");
			/**
			 * controllo se l'utente inserisce un valore accetato dal sistema
			 * **/
			try {
				int comando = Integer.parseInt(input.nextLine());
				// primo switch per far selezionare all'utente quale operazione vuole eseguire
				switch (comando) {
				// aggiungi strumento all'orchestra
				case 1: {

					System.out.println("Inserisci il numero dell'estensione in ottave dello strumento: ");
					int estensione = 0;
					//ciclo per forzare l'utente ad inserire un valore accetato
					while (true) {
						//verifica se il valore dell'estensione inserito è positivo, quindi accettato
						try {
							estensione = Integer.parseInt(input.nextLine());
							if (estensione < 0) {
								throw new NegativeValueException(estensione);
							}
							break;
						// altrimenti viene sollevato un eccezione
						} catch (NegativeValueException e) {
							System.out.println(e.getMessage());
							System.out.println("Inserisci un numero strettamente positivo");
						} catch (java.lang.NumberFormatException e) {
							System.out.println("Comando non riconosciuto. Inserisci un numero valido");
						}
					}

					System.out.println("Inserisci il nome dello strumento: ");
					String nomeStrumento = input.nextLine();
					System.out.println(
							"Inserisci il tipo dello strumento:\n1. Corda\n2. Percussione\n3. Fiato\n4. Tastiera\n5. Elettronica");
					int comandoTipo = 0;
					TipoStrumento categoria = null;
					boolean numeroInRange = false;
					//ciclo per forzare l'utente ad inserire un valore accetato
					while (!numeroInRange) {
						//verifica se il valore del tipo inserito è un intero quindi accettato
						try {
							comandoTipo = Integer.parseInt(input.nextLine());

							// secondo switch per categoria dello strumento
							switch (comandoTipo) {
							case 1:
								categoria = TipoStrumento.corda;
								numeroInRange = true;
								break;

							case 2:
								categoria = TipoStrumento.percussione;
								numeroInRange = true;
								break;

							case 3:
								categoria = TipoStrumento.fiato;
								numeroInRange = true;
								break;

							case 4:
								categoria = TipoStrumento.tastiera;
								numeroInRange = true;
								break;

							case 5:
								categoria = TipoStrumento.elettronica;
								numeroInRange = true;
								break;
							default:
								System.out.println("Errore: inserisci un valore corretto");

							}

						} catch (java.lang.NumberFormatException e) {
							System.out.println("Comando non riconosciuto. Inserisci un numero valido");
						}
					}

					System.out.println("Che strumento vuoi creare?\n1. Tamburo\n2. Chitarra\n3. Maracas");
					int comandoStrumento = 0;
					numeroInRange = false;
					Strumento strumento = null;
					//ciclo per forzare l'utente ad inserire un valore accetato
					while (!numeroInRange) {
						// switch per capire quale classe effettiva di strumento istanziare
						try {
							comandoStrumento = Integer.parseInt(input.nextLine());
							switch (comandoStrumento) {
								case 1:
									strumento = new Tamburo(nomeStrumento, estensione, categoria);
									numeroInRange = true;
									break;
								case 2:
									strumento = new Chitarra(nomeStrumento, estensione, categoria);
									numeroInRange = true;
									break;
								case 3:
									strumento = new Maracas(nomeStrumento, estensione, categoria);
									numeroInRange = true;
									break;
	
								default:
									System.out
											.println("Comando non riconosciuto. Inserire uno dei comandi a disposizione.");
								}
						} catch (Exception e) {
							System.out.println(e);
						}
					}//solo nel caso in cui lo strumento sia correttamente istanziato viene aggiunto all'orchestra
					if (strumento != null) {
						orchestra1.aggiungiStrumento(strumento);
						System.out.println(strumento);
					}
					break;
				}
				// ricerca dello strumento per id
				case 2: {
					System.out.println("Inserisci l'id dello strumento da cercare");
					int idInserito = 0;
					while(true) {
						try {
							idInserito = Integer.parseInt(input.nextLine());
							Strumento strumentoTrovato = orchestra1.cercaStrumentoPerId(idInserito);
							if (strumentoTrovato != null) {
								System.out.println("Strumento trovato!");
								System.out.println(strumentoTrovato);
							} else {
								System.out.println("Strumento non trovato!");
							}

							break;
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
					
				}
				// eliminazione dello strumento per id
				case 3: {
					System.out.println("Inserisci l'id dello strumento da cancellare");
					int idInput = Integer.parseInt(input.nextLine());
					if (orchestra1.cancellaStrumento(idInput) != null) {
						System.out.println("Strumento cancellato!");
					} else {
						System.out.println("Strumento non trovato!");
					}

					break;
				}
				// stampa orchestra
				case 4: {
					System.out.println(orchestra1.toString());
					break;
				}
				// funzione che accorda tutti gli strumenti dell'orchestra
				case 5: {
					orchestra1.accorda();
					break;
				}
				// funzione che suona tutti gli strumenti dell'orchestra
				case 6: {
					orchestra1.suona();
					break;
				}
				// uscita immediata dal menu
				case 7: {
					System.out.println("Programma terminato");
					return;
				}
				default: {
					System.out.println(
							"Il comando che hai inserito non è riconosciuto dal sistema.\nInserisci un valore valido");
					break;
				}
				}
				// ci assicuriamo che finche la variabile verifica è uguale ad s il programma
				// continua ad andare

				// commentiamo questo pezzo per ottimizzare la gestione del menu,
				// richiedendo sempre un numero presente nella lista menu
				/*
				 * if (verifica.equalsIgnoreCase("s")) { System.out.println(
				 * "Per eseguire un'altra operazione premere: s \nPer fermare il programma premere qualsiasi tasto"
				 * ); verifica = input.nextLine(); }
				 */
			} catch (java.lang.NumberFormatException e) {
				System.out.println("Comando non riconosciuto. Inserisci un numero valido");
			} catch (Exception e) {
				System.out.println(e);
			}

		}
	}
}
