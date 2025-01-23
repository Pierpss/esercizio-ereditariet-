import java.time.LocalDate;

public class Fattura {

    private int numero;
    private LocalDate data;
    private String cliente;
    private double importo;
    public int nome;

    public Fattura(int numero, LocalDate data, String cliente, double importo) {
        this.numero = numero;
        this.data = data;
        this.cliente = cliente;
        this.importo = importo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getImporto() {
        return importo;
    }

    public void setImporto(double importo) {
        this.importo = importo;
    }

    @Override
    public String toString() {
        return "Fattura di" + nome + "[numero=" + numero + ", data=" + data + ", cliente=" + cliente + ", importo=" + importo + "]";
    }
}
