import java.time.LocalDate;


public class Animale {

    private static int newCode = 1; 

    protected final int codice;
    protected final String razza;
    protected final String specie;
    protected final LocalDate dataNascita;
    protected float prezzo;
    protected String note;
    
    public Animale(String razza, String specie, LocalDate dataNascita, float prezzo, String note) {
        this.codice = newCode;
        this.razza = razza;
        this.specie = specie;
        this.dataNascita = dataNascita;
        this.prezzo = prezzo;
        this.note = note;

        newCode++;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public static int getNewCode() {
        return newCode;
    }

    public int getCodice() {
        return codice;
    }

    public String getRazza() {
        return razza;
    }

    public String getSpecie() {
        return specie;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    
        
}
