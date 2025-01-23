import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Professionista extends Persona {
    private String partitaIva;
    private LocalDate dataInizioAttività;
    private int fatturato;
    private HashMap<Integer, List<Fattura>> fattureAnnue = new HashMap<>();

    public Professionista(String nome, String cognome, LocalDate dataNascita, String username, String password,
            String partitaIva, LocalDate dataInizioAttività, double fatturato) {
        super(nome, cognome, dataNascita, username, password);
        this.partitaIva = partitaIva;
        this.dataInizioAttività = dataInizioAttività;
        this.fatturato = 0;
    }

    public void emettiFattura(LocalDate data, String cliente, double importo) {
        int anno = data.getYear();
        if (!fattureAnnue.containsKey(anno)) {
            fattureAnnue.put(anno, new ArrayList<>());
        }
        List<Fattura> listaFatture = fattureAnnue.get(anno);
        int numeroFattura = listaFatture.size() + 1;
        Fattura fattura = new Fattura(numeroFattura, data, cliente, importo);
        listaFatture.add(fattura);
        fatturato += importo;
    }

    public String getPartitaIva() {
        return partitaIva;
    }

    public void setPartitaIva(String partitaIva) {
        this.partitaIva = partitaIva;
    }

    public LocalDate getDataInizioAttività() {
        return dataInizioAttività;
    }

    public void setDataInizioAttività(LocalDate dataInizioAttività) {
        this.dataInizioAttività = dataInizioAttività;
    }

    public int getFatturato() {
        return fatturato;
    }

    public void setFatturato(int fatturato) {
        this.fatturato = fatturato;
    }

    public HashMap<Integer, List<Fattura>> getFattureAnnue() {
        return fattureAnnue;
    }

    public void setFattureAnnue(HashMap<Integer, List<Fattura>> fattureAnnue) {
        this.fattureAnnue = fattureAnnue;
    }

    public void visualizzaFatture() {
        for (Map.Entry<Integer, List<Fattura>> entry : fattureAnnue.entrySet()) {
            System.out.println("Fatture emesse nel " + entry.getKey() + ":");
            entry.getValue().forEach(System.out::println);
        }
    }

    public void visualizzaFatture(String cliente) {
        for (Map.Entry<Integer, List<Fattura>> entry : fattureAnnue.entrySet()) {
            List<Fattura> listaFatture = entry.getValue()
                    .stream()
                    .filter(fattura -> fattura.getCliente().equals(cliente))
                    .toList();

            if (!listaFatture.isEmpty()) {
                System.out.println("Fatture emesse nel " + entry.getKey() + " per " + cliente + ":");
                listaFatture.forEach(System.out::println);
            }
        }
    }

    @Override
    public String toString() {
        return "Professionista [dataInizioAttività=" + dataInizioAttività + ", fatturato=" + fatturato + ", partitaIva="
                + partitaIva + "]";
    }
}
