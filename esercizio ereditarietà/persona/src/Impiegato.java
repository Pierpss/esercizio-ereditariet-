import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Impiegato extends Persona {
    private String nTesserino;
    private LocalDate dataAssunzione;
    private double stipendio;
    private List<Cedolino> cedolini = new ArrayList<>();

    public Impiegato(String nome, String cognome, LocalDate dataNascita, String username, String password,
            double stipendio, String nTesserino, LocalDate dataAssunzione) {
        super(nome, cognome, dataNascita, username, password);
        this.stipendio = stipendio;
        this.nTesserino = nTesserino;
        this.dataAssunzione = dataAssunzione;
    }

    public void riceviAumento(double aumento) {
        if (aumento > 0) {
            stipendio += aumento;
        } else {
            System.out.println("Errore: l'aumento deve essere positivo");
        }
    }

    public void riceviCedolino(LocalDate data, double importo) {
        if (importo > 0) {
            Cedolino cedolino = new Cedolino(data, importo, getNome() + " " + getCognome());
            cedolini.add(cedolino);
        } else {
            System.out.println("Errore: l'importo deve essere positivo");
        }
    }

    public void visualizzaCedolini(int anno) {
        boolean trovato = false;
        for (Cedolino cedolino : cedolini) {
            if (cedolino.getData().getYear() == anno) {
                System.out.println(cedolino);
                trovato = true;
            }
        }
        if (!trovato) {
            System.out.println("Nessun cedolino disponibile per l'anno " + anno);
        }
    }

    public String getnTesserino() {
        return nTesserino;
    }

    public void setnTesserino(String nTesserino) {
        this.nTesserino = nTesserino;
    }

    public LocalDate getDataAssunzione() {
        return dataAssunzione;
    }

    public void setDataAssunzione(LocalDate dataAssunzione) {
        this.dataAssunzione = dataAssunzione;
    }

    public double getStipendio() {
        return stipendio;
    }

    public void setStipendio(double stipendio) {
        this.stipendio = stipendio;
    }

    public List<Cedolino> getCedolini() {
        return cedolini;
    }

    public void setCedolini(List<Cedolino> cedolini) {
        this.cedolini = cedolini;
    }

    @Override
    public String toString() {
        return "Impiegato [dataAssunzione=" + dataAssunzione + ", nTesserino=" + nTesserino + ", stipendio=" + stipendio
                + "]";
    }
}
