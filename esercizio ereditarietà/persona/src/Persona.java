import java.time.LocalDate;

public class Persona {
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private String username;
    private String password;

    public Persona(String nome, String cognome, LocalDate dataNascita, String username, String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.username = username;
        this.password = password;
    }

    public int calcolaEta() {
        return LocalDate.now().getYear() - dataNascita.getYear();
    }

    public void saluta() {
        System.out.println("Ciao, sono " + nome + " " + cognome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
