package boundary;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate; 
import java.time.format.DateTimeFormatter; 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import control.GestioneCampeggio;
import entity.Piazzola;
import entity.Prenotazione;
import entity.Settore;
import exception.OperationException;

public class BoundaryClienteRegistrato {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		boolean exit = false;
		while(!exit) {
			//scelta dell'operazione
			System.out.println("Cliente Registrato\n");
			System.out.println("1. Visualizza Disponibilita' \n");
			System.out.println("2. Effettua Prenotazione \n");
			System.out.println("3. Acquista Servizio \n");
			System.out.println("inserire il numero dell'opzione desiderata: \n");
			
			String risposta = scan.nextLine(); //acquisisce input
			
			if(risposta.equals("1")) {
				VisualizzaDisponibilità();
				exit = true;	
			}else if(risposta.equals("2")) {
				EffettuaPrenotazione();
				exit = true;
			}else if(risposta.equals("3")) {
				AcquistaServizio();
				exit = true;
			}else System.out.println(risposta+ " non è un valore valido\n");
		}
		
		System.out.println("Bye Bye ;) \n");
		
	}
	
//un metodo static non richiede l'istanziazione di un oggetto di quella classe per il suo utilizzo	
	
	private static void VisualizzaDisponibilità() {
		
		LocalDate DataInizio= null;
		LocalDate DataFine = null;
		LocalDate verifica = null;

		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-gg");

		GestioneCampeggio gestioneCampeggio = GestioneCampeggio.getInstance();  
		int NomeSettore = 0;
		String Categoria = null; //premium o economy
		String Tipo = null; //camper o tende
		String giorno=null;
		boolean inputvalido = false;
		String risposta; 
		while(!inputvalido){
			try {
				System.out.println("Inserire data inizio yyyy-mm-gg\n");
				risposta = scan.nextLine();
				//conversione String in LocalDate
				DataInizio = LocalDate.parse(risposta);
				//System.out.println(DataInizio.getDayOfWeek());
				giorno=DataInizio.getDayOfWeek().toString();
				if(giorno.equals("SATURDAY")) {
					inputvalido = true;
					}else System.out.println("Inserire un giorno di sabato\n");
			}catch (Exception error) {
				System.out.println("Errore nell'acquisizione di data inizio soggiorno, riprovare (metti bene grazie)\n");
				//System.out.println();//nuovo inserimento	//scan.close();
			}
		}
			
	
		inputvalido = false;
		//inserire data fine soggiorno
		//scan.close();
		while(!inputvalido) {
			try {
				System.out.println("Inserire data fine gg-mm-yyyy\n");
				risposta = scan.nextLine();
				//conversione String in LocalDate
				DataFine = LocalDate.parse(risposta);
				if(DataFine.isBefore(DataInizio)) {
					System.out.println("Errore nell'ordine dei soggiorni, riprovare (metti bene grazie)\n");
				}else {
				giorno=DataFine.getDayOfWeek().toString();
				if(giorno.equals("SATURDAY")) {
					verifica=DataFine.minusDays(7);
					if(DataInizio.compareTo(verifica)==0) {
						inputvalido = true;
						}else System.out.println("Inserire un periodo di tempo di una settimana\n");
					}else System.out.println("Inserire un giorno di sabato\n");
				}
			}catch (Exception error) {
				System.out.println("Errore nell'acquisizione di data fine soggiorno, riprovare (metti bene grazie)\n");
				//System.out.println();//nuovo inserimento
				//scan.close();
			}
			
		}
		
		
		
		inputvalido = false;
		
		//scan.close();
		while(!inputvalido) {
			System.out.println("Inserire il tipo -camper- o -tenda-\n");
			Tipo = scan.nextLine();
			//controllo se la risposta è camper o tenda
		if(!((Tipo.equals("camper"))||(Tipo.equals("Camper"))||(Tipo.equals("CAMPER"))||(Tipo.equals("tenda"))||(Tipo.equals("Tenda"))||(Tipo.equals("TENDA")))) {
			System.out.println("Errore. Inserire risposta corretta \n");
			//Tipo = scan.nextLine();
		}else inputvalido = true;
		}
		
		inputvalido = false;
		while(!inputvalido){
			System.out.println("Inserire categoria -economy- o -premium- \n");
			Categoria = scan.nextLine();
			//controllo se la risposta è economy o premium
			if(!((Categoria.equals("economy"))||(Categoria.equals("Economy"))||(Categoria.equals("ECONOMY"))||(Categoria.equals("premium"))||(Categoria.equals("Premium"))||(Categoria.equals("PREMIUM")))) {
				System.out.println("Errore. Inserire risposta corretta \n");
				//Categoria = scan.nextLine();
			}else inputvalido= true;
		}
		if((Tipo.equals("camper"))||(Tipo.equals("Camper"))||(Tipo.equals("CAMPER"))) {
			if((Categoria.equals("economy"))||(Categoria.equals("Economy"))||(Categoria.equals("ECONOMY"))) {
				NomeSettore = 2; 
			}else {NomeSettore = 1;}
		}else if((Categoria.equals("economy"))||(Categoria.equals("Economy"))||(Categoria.equals("ECONOMY"))) {
				NomeSettore = 3;
			}else {NomeSettore = 4;}
		try {
		gestioneCampeggio.VisualizzaDisponibilità(DataInizio, DataFine, NomeSettore, Categoria, Tipo);
		}catch(OperationException e) {
			System.out.print(e.getMessage());}
	}
	
private static void EffettuaPrenotazione() {
		
		LocalDate DataInizio= null;
		LocalDate DataFine = null;
		Prenotazione p=null;
		LocalDate verifica = null;
		String giorno=null;
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-gg");

		GestioneCampeggio gestioneCampeggio = GestioneCampeggio.getInstance();  
		int NomeSettore = 0;
		String Categoria = null; //premium o economy
		String Tipo = null; //camper o tende
		boolean inputvalido = false;
		String email = null;
		String risposta; 
		
		while(!inputvalido){
			try {
				System.out.println("Inserire data inizio yyyy-mm-gg\n");
				risposta = scan.nextLine();
				//conversione String in LocalDate
				DataInizio = LocalDate.parse(risposta);
				//System.out.println(DataInizio.getDayOfWeek());
				giorno=DataInizio.getDayOfWeek().toString();
				if(giorno.equals("SATURDAY")) {
					inputvalido = true;
					}else System.out.println("Inserire un giorno di sabato\n");
			}catch (Exception error) {
				System.out.println("Errore nell'acquisizione di data inizio soggiorno, riprovare (metti bene grazie)\n");
				//System.out.println();//nuovo inserimento	//scan.close();
			}
		}
			
	
		inputvalido = false;
		//inserire data fine soggiorno
		//scan.close();
		while(!inputvalido) {
			try {
				System.out.println("Inserire data fine yyyy-mm-gg\n");
				risposta = scan.nextLine();
				//conversione String in LocalDate
				DataFine = LocalDate.parse(risposta);
				if(DataFine.isBefore(DataInizio)) {
					System.out.println("Errore nell'ordine dei soggiorni, riprovare (metti bene grazie)\n");
				}else {
				giorno=DataFine.getDayOfWeek().toString();
				if(giorno.equals("SATURDAY")) {
					verifica=DataFine.minusDays(7);
					if(DataInizio.compareTo(verifica)==0) {
						inputvalido = true;
						}else System.out.println("Inserire un periodo di tempo di una settimana\n");
					}else System.out.println("Inserire un giorno di sabato\n");
				}
			}catch (Exception error) {
				System.out.println("Errore nell'acquisizione di data fine soggiorno, riprovare (metti bene grazie)\n");
				//System.out.println();//nuovo inserimento
				//scan.close();
			}
			
		}
		
		
		
		inputvalido = false;
		
		//scan.close();
		while(!inputvalido) {
			System.out.println("Inserire il tipo -camper- o -tenda-\n");
			Tipo = scan.nextLine();
			//controllo se la risposta è camper o tenda
		if(!((Tipo.equals("camper"))||(Tipo.equals("Camper"))||(Tipo.equals("CAMPER"))||(Tipo.equals("tenda"))||(Tipo.equals("Tenda"))||(Tipo.equals("TENDA")))) {
			System.out.println("Errore. Inserire risposta corretta \n");
			//Tipo = scan.nextLine();
		}else inputvalido = true;
		}
		
		inputvalido = false;
		while(!inputvalido){
			System.out.println("Inserire categoria -economy- o -premium- \n");
			Categoria = scan.nextLine();
			//controllo se la risposta è economy o premium
			if(!((Categoria.equals("economy"))||(Categoria.equals("Economy"))||(Categoria.equals("ECONOMY"))||(Categoria.equals("premium"))||(Categoria.equals("Premium"))||(Categoria.equals("PREMIUM")))) {
				System.out.println("Errore. Inserire risposta corretta \n");
				//Categoria = scan.nextLine();
			}else inputvalido= true;
		}
		if((Tipo.equals("camper"))||(Tipo.equals("Camper"))||(Tipo.equals("CAMPER"))) {
			if((Categoria.equals("economy"))||(Categoria.equals("Economy"))||(Categoria.equals("ECONOMY"))) {
				NomeSettore = 2; 
			}else {NomeSettore = 1;}
		}else if((Categoria.equals("economy"))||(Categoria.equals("Economy"))||(Categoria.equals("ECONOMY"))) {
				NomeSettore = 3;
			}else {NomeSettore = 4;}
		
		inputvalido = false;
		while (!inputvalido) {
            System.out.println("Inserire email - esempiomail@... - \n");
            email = scan.nextLine();
            
            // Controlla se contiene "@" e "."
            if (email.contains("@") && email.contains(".")) {
                // Controlla che il punto sia dopo la chiocciola
                int atPosition = email.indexOf("@");
                int dotPosition = email.lastIndexOf(".");
                
                // Verifica che il "." sia dopo la "@"
                if (dotPosition > atPosition) {
                    inputvalido = true;
                    //System.out.println("Email valida.");
                } else {
                    System.out.println("Email non valida");
                }
            }
		}
            
		try {
			p=gestioneCampeggio.EffettuaPrenotazione(DataInizio, DataFine, NomeSettore, Categoria, Tipo, email);
			
			System.out.println("Data Inizio: " + p.getDataInizio()+ "\nData Fine: " + p.getDataFine() +
					"\nIdPiazzola assegnata: " + p.getPiazzola() + "\nIdSettore assegnato: " + NomeSettore +
					"\nTipologia: " + Tipo + "\nCategoria: " + Categoria + "\nEmail: " + email + "\nTotale: " + p.getPrezzoPrenotazione() );
			
			}catch(OperationException e) {System.out.println(e.getMessage());}	
		
		System.out.println("Digita 'Yes' per confermare il pagamento della prenotazione o qualunque altro carattere per annullare..");
		String conferma = scan.nextLine();
		
		try {
		if (!(conferma.equals("Yes") || conferma.equals("yes") || conferma.equals("YES"))) {
			System.out.println("Prenotazione annullata :( \n");
		}
		else {
			System.out.println();
			System.out.println("Pagamento in corso..");
			TimeUnit.SECONDS.sleep(3);
			System.out.println("Pagamento effettuato!");
			gestioneCampeggio.salvaPrenotazione(p);
			System.out.println("Prenotazione effettuata :) ");
			gestioneCampeggio.InvioCodice(email);
			System.out.println("Codice Prenotazione inviato ;) ");
		}
		}catch(OperationException e) {
			System.out.println(e.getMessage());
		}catch (Exception e) {
			System.out.println("Unexpected exception, riprovare..");
		}
   }

	private static void AcquistaServizio() {
		
		int codiceConto = 0;
		int codiceServizio = 0;
		String risposta = null;
		
		
		boolean inputvalido = false;
		boolean prova= true;
		GestioneCampeggio gestioneCampeggio = GestioneCampeggio.getInstance(); 
		while(!inputvalido) {
			System.out.println("inserire codice conto \n");
			risposta = scan.nextLine();
			prova = true;
			for (int i = 0; i< risposta.length() && prova; i++) {
				if(risposta.charAt(i)<'0' || risposta.charAt(i) > '9'  ) {
					prova = false;
					System.out.println("Mettere solo numeri!!!");
				}
			}
			if(prova) {
				inputvalido = true;
				codiceConto = Integer.parseInt(risposta);
			}
		}
		prova = true;
		inputvalido = false;
		while(!inputvalido) {
			System.out.println("inserire codice servizio \n");
			risposta = scan.nextLine();
			prova = true;
			for (int i = 0; i< risposta.length() && prova; i++) {
				if(risposta.charAt(i)<'0' || risposta.charAt(i) > '9'  ) {
					prova = false;
					System.out.println("Mettere solo numeri!!!");
				}
			}
			if(prova) {
				inputvalido = true;
				codiceServizio = Integer.parseInt(risposta);
			}
		}
		
		try {
			String acquisto = gestioneCampeggio.AcquistaServizio(codiceConto, codiceServizio);
			System.out.println(acquisto);
			gestioneCampeggio.invioSpeseEmail(codiceConto);
			}catch(OperationException e) {
				System.out.println(e.getMessage());}	
		}
		
	}