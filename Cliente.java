import java.util.ArrayList;

public class Cliente {
    //attributi
    private String nome;
    private String cognome;
    private String telefono;
    private String indirizzo;
    private ArrayList<Animale> animali;

    //costruttori
    public Cliente(String nome, String cognome, String telefono, String indirizzo) {
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
        this.indirizzo = indirizzo;
    }

    //metodi
    public String getNome() {
        return nome;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getIndirizzo() {
        return indirizzo;
    }
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }
    public ArrayList<Animale> getAnimali() {
        return animali;
    }

    //aggiungi animale
    public void addAnimale(Animale a){
        animali.add(a);
    }

    @Override
    public String toString() {
        return "Cliente [nome=" + nome + ", cognome=" + cognome + ", telefono=" + telefono + ", indirizzo=" + indirizzo
                + ", animali=" + animali + "]";
    }
}