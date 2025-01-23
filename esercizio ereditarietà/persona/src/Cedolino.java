import java.time.LocalDate;

public class Cedolino {

    private LocalDate data;
    private double importo;
    private String nome;

    public Cedolino(LocalDate data, double importo, String nome) {
        this.data = data;
        this.importo = importo;
        this.nome = nome;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getImporto() {
        return importo;
    }

    public void setImporto(double importo) {
        this.importo = importo;
    }

    @Override
    public String toString() {
        return "Cedolino " + nome + "[data=" + data + ", importo=" + importo + "]";
    }
}
