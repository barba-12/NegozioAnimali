public class Animale {
    //attributi
    private static int newCode = 1;
    protected int codice;
    protected String razza;
    protected String specie;
    protected int anno;
    protected double prezzo;
    protected String note;

    //costruttore
    public Animale(String razza, String specie, int anno, double prezzo, String note) {
        this.codice = newCode;
        newCode ++;
        this.razza = razza;
        this.specie = specie;
        this.anno = anno;
        this.prezzo = prezzo;
        this.note = note;
    }

    //metodi
    public int getCodice() {
        return codice;
    }
    public String getRazza() {
        return razza;
    }
    public String getSpecie() {
        return specie;
    }
    public int getAnno() {
        return anno;
    }
    public double getPrezzo() {
        return prezzo;
    }
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Animale [codice=" + codice + ", razza=" + razza + ", specie=" + specie + ", anno=" + anno + ", prezzo="
                + prezzo + ", note=" + note + "]";
    }
}