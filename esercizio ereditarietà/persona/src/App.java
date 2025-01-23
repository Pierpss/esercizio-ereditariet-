import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<Persona> persone = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        persone.add(new Impiegato("Mario", "Rossi", LocalDate.of(1990, 1, 1), "mario", "password", 30000, "T1234",
                LocalDate.of(2015, 6, 1)));
        persone.add(new Impiegato("Giuseppe", "Verdi", LocalDate.of(1980, 3, 15), "giuseppe", "1234", 35000, "T5678",
                LocalDate.of(2010, 3, 15)));
        persone.add(new Impiegato("Paolo", "Neri", LocalDate.of(1975, 7, 10), "paolo", "secure", 40000, "T9876",
                LocalDate.of(2005, 7, 10)));
        persone.add(new Professionista("Luca", "Bianchi", LocalDate.of(1985, 5, 20), "luca", "secure", "PIVA12345",
                LocalDate.of(2010, 4, 15), 100000));
        persone.add(new Professionista("Andrea", "Gialli", LocalDate.of(1995, 10, 5), "andrea", "secure", "PIVA67890",
                LocalDate.of(2015, 3, 20), 50000));
        persone.add(new Professionista("Giovanni", "Marroni", LocalDate.of(1970, 12, 25), "giovanni", "secure",
                "PIVA54321", LocalDate.of(2000, 1, 1), 200000));

        System.out.print("Inserisci username: ");
        String username = sc.nextLine();
        System.out.print("Inserisci password: ");
        String password = sc.nextLine();

        Persona persona = login(persone, username, password);

        if (persona != null) {
            System.out.println("Benvenuto " + persona.getNome() + " " + persona.getCognome());
            saluta(persona);
            mostraMenu(sc, persona);
        } else {
            System.out.println("username o password non validi");
        }
    }

    public static Persona login(ArrayList<Persona> persone, String username, String password) {
        for (Persona p : persone) {
            if (p.getUsername().equals(username) && p.getPassword().equals(password)) {
                return p;
            }
        }
        return null;
    }

    public static void saluta(Persona persona) {
        persona.saluta();
    }

    public static void mostraMenu(Scanner sc, Persona persona) {
        if (persona instanceof Impiegato) {
            menuImpiegato(sc, (Impiegato) persona);
        } else if (persona instanceof Professionista) {
            menuProfessionista(sc, (Professionista) persona);
        } else {
            menuPersona(sc, persona);
        }
    }

    public static void menuImpiegato(Scanner sc, Impiegato impiegato) {
        while (true) {
            System.out.println("\nAzioni disponibili per Impiegato:");
            System.out.println("1. Controllo Stipendio");
            System.out.println("2. Aumento Stipendio");
            System.out.println("3. Controllo Numero del Tesserino");
            System.out.println("4. Controllo Data Assunzione");
            System.out.println("5. Ricevi Cedolino");
            System.out.println("6. Visualizza Cedolini per Anno");
            System.out.println("7. Esci");
            System.out.print("Scegli un'opzione: ");
            int scelta = sc.nextInt();
            sc.nextLine();

            switch (scelta) {
                case 1:
                    System.out.println("Stipendio: " + impiegato.getStipendio());
                    break;
                case 2:
                    System.out.print("Inserisci importo dell'aumento: ");
                    double aumento = sc.nextDouble();
                    sc.nextLine();
                    if (aumento > 0) {
                        impiegato.riceviAumento(aumento);
                        System.out.println("Nuovo stipendio: " + impiegato.getStipendio());
                    } else {
                        System.out.println("Errore: l'aumento deve essere positivo");
                    }
                    break;
                case 3:
                    System.out.println("Numero del Tesserino: " + impiegato.getnTesserino());
                    break;
                case 4:
                    System.out.println("Data Assunzione: " + impiegato.getDataAssunzione());
                    break;
                case 5:
                    System.out.print("Inserisci data del cedolino (yyyy-mm-dd): ");
                    LocalDate dataCedolino = LocalDate.parse(sc.nextLine());
                    System.out.print("Inserisci importo del cedolino: ");
                    double importoCedolino = sc.nextDouble();
                    sc.nextLine();
                    if (importoCedolino > 0) {
                        impiegato.riceviCedolino(dataCedolino, importoCedolino);
                        System.out.println("Cedolino ricevuto.");
                    } else {
                        System.out.println("Errore: l'importo deve essere positivo");
                    }
                    break;
                case 6:
                    System.out.print("Inserisci anno: ");
                    int anno = sc.nextInt();
                    sc.nextLine();
                    impiegato.visualizzaCedolini(anno);
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Scelta non valida, riprova.");
                    break;
            }
        }
    }

    public static void menuProfessionista(Scanner sc, Professionista professionista) {
        while (true) {
            System.out.println("\nAzioni disponibili per Professionista:");
            System.out.println("1. Emetti Fattura");
            System.out.println("2. Controllo Partita IVA");
            System.out.println("3. Controllo Data Inizio Attività");
            System.out.println("4. Controllo Fatturato");
            System.out.println("5. Visualizza Fatture");
            System.out.println("6. Visualizza Fatture per Cliente");
            System.out.println("7. Esci");
            System.out.print("Scegli un'opzione: ");
            int scelta = sc.nextInt();
            sc.nextLine();
    
            switch (scelta) {
                case 1:
                    System.out.print("Inserisci data della fattura (yyyy-mm-dd): ");
                    LocalDate dataFattura = LocalDate.parse(sc.nextLine());
                    System.out.print("Inserisci cliente: ");
                    String cliente = sc.nextLine();
                    System.out.print("Inserisci importo da fatturare: ");
                    int importo = sc.nextInt();
                    sc.nextLine();
                    if (importo > 0) {
                        professionista.emettiFattura(dataFattura, cliente, importo);
                        System.out.println("Fattura emessa.");
                    } else {
                        System.out.println("Errore: l'importo deve essere positivo");
                    }
                    break;
                case 2:
                    System.out.println("Partita IVA: " + professionista.getPartitaIva());
                    break;
                case 3:
                    System.out.println("Data Inizio Attività: " + professionista.getDataInizioAttività());
                    break;
                case 4:
                    System.out.println("Fatturato: " + professionista.getFatturato());
                    break;
                case 5:
                    if (professionista.getFatturato() == 0) {
                        System.out.println("Errore: nessuna fattura emessa.");
                    } else {
                        professionista.visualizzaFatture();
                    }
                    break;
                case 6:
                    if (professionista.getFatturato() == 0) {
                        System.out.println("Errore: nessuna fattura emessa.");
                    } else {
                        System.out.print("Inserisci cliente: ");
                        String clienteFatture = sc.nextLine();
                        professionista.visualizzaFatture(clienteFatture);
                    }
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Scelta non valida, riprova.");
                    break;
            }
        }
    }
    

    public static void menuPersona(Scanner sc, Persona persona) {
        while (true) {
            System.out.println("\nAzioni disponibili per Persona:");
            System.out.println("1. Saluta");
            System.out.println("2. Esci");
            System.out.print("Scegli un'opzione: ");
            int scelta = sc.nextInt();
            sc.nextLine();

            switch (scelta) {
                case 1:
                    persona.saluta();
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Scelta non valida, riprova.");
                    break;
            }
        }
    }
}
