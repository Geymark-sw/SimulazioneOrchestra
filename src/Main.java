import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Fase di inserimento dei dati
		System.out.println("Benvenuto nel gestore della tua orchestra");
		Scanner input = new Scanner(System.in);
		String verifica = "s";
		Orchestra orchestra1 = new Orchestra("Mario"); // Fase di istanziazione dell'orchestra

		// ciclo utilizzato per la gestione del menu
		while (verifica.equalsIgnoreCase("s")) {
			System.out.println(
					"Inserisci un comando:" + "\n1. Aggiungi strumento all'orchestra" + "\n2. Cerca lo strumento per id"
							+ "\n3. Cancella lo strumento per id" + "\n4. Stampa tutta l'orchestra"
							+ "\n5. Accorda tutti gli strumenti" + "\n6. Musica maestro" + "\n7. Exit");
			try {
				int comando = Integer.parseInt(input.nextLine());
				switch (comando) {
				// aggiungi strumento all'orchestra
				case 1:

					System.out.println("Inserisci il numero dell'estensione in ottave dello strumento: ");
					int estensione = Integer.parseInt(input.nextLine());
					System.out.println("Inserisci il nome dello strumento: ");
					String nomeStrumento = input.nextLine();
					System.out.println(
							"Inserisci il tipo dello strumento:\n1. Corda\n2. Percussione\n3. Fiato\n4. Tastiera\n5. Elettronica");
					int comandoTipo = Integer.parseInt(input.nextLine());
					TipoStrumento categoria = null;
					switch (comandoTipo) {
					case 1:
						categoria = TipoStrumento.corda;
						break;

					case 2:
						categoria = TipoStrumento.percussione;
						break;

					case 3:
						categoria = TipoStrumento.fiato;
						break;

					case 4:
						categoria = TipoStrumento.tastiera;
						break;

					case 5:
						categoria = TipoStrumento.elettronica;
						break;
					}

					System.out.println("Che strumento vuoi creare?\n1. Tamburo\n2. Chitarra\n3. Maracas");
					int comandoStrumento = Integer.parseInt(input.nextLine());

					// switch per capire quale classe effettiva di strumento istanziare
					switch (comandoStrumento) {
					case 1:
						Strumento tamburo = new Tamburo(nomeStrumento, estensione, categoria);
						orchestra1.aggiungiStrumento(tamburo);
						System.out.println(tamburo);
						break;
					case 2:
						Strumento chitarra = new Chitarra(nomeStrumento, estensione, categoria);
						orchestra1.aggiungiStrumento(chitarra);
						System.out.println(chitarra);
						break;
					case 3:
						Strumento maracas = new Maracas(nomeStrumento, estensione, categoria);
						orchestra1.aggiungiStrumento(maracas);
						System.out.println(maracas);
						break;

					default:

						// Se l'utente digita un numero diverso da 1,2,3)
						break;

					}
					break;
				// ricerca dello strumento per id
				case 2:
					System.out.println("Inserisci l'id dello strumento da cercare");
					int idInserito = Integer.parseInt(input.nextLine());
					Strumento strumentoTrovato = orchestra1.cercaStrumentoPerId(idInserito);
					if (strumentoTrovato != null) {
						System.out.println("Strumento trovato!");
						System.out.println(strumentoTrovato);
					} else {
						System.out.println("Strumento non trovato!");
					}

					break;
				// eliminazione dello strumento per id
				case 3:
					System.out.println("Inserisci l'id dello strumento da cancellare");
					int idInput = Integer.parseInt(input.nextLine());
					if (orchestra1.cancellaStrumento(idInput) != null) {
						System.out.println("Strumento cancellato!");
					} else {
						System.out.println("Strumento non trovato!");
					}

					break;

				// stampa orchestra
				case 4:
					System.out.println(orchestra1.toString());
					break;

				// funzione che accorda tutti gli strumenti dell'orchestra
				case 5:
					orchestra1.accorda();
					break;

				// funzione che suona tutti gli strumenti dell'orchestra
				case 6:
					orchestra1.suona();
					break;
				// uscita immediata dal menu
				case 7:
					verifica = "n";
					break;

				default:
					break;

				}
				//ci assicuriamo che finche la variabile verifica è uguale ad s il programma continua ad andare
				if (verifica.equalsIgnoreCase("s")) {
					System.out.println(
							"Per eseguire un'altra operazione premere: s \nPer fermare il programma premere qualsiasi tasto");
					verifica = input.nextLine();
				}
			} catch (Exception e) {
				System.out.println(e);
			}

		}
		System.out.println("Programma terminato");
	}

}
