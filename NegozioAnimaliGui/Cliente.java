import java.util.ArrayList;
import java.util.List;

public class Cliente {
    @SuppressWarnings("unused")
    private final String nome;
    @SuppressWarnings("unused")
    private final String cognome;
    private String indirizzo;
    private String telefono;
    private List<Animale> animali;

    public Cliente(String nome, String cognome, String indirizzo, String telefono) {
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        this.telefono = telefono;
        this.animali = new ArrayList<>();
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Animale> getAnimali() {
        return animali;
    }

    void addAnimale(Animale a) {
        animali.add(a);
    }

}
