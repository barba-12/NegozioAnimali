import java.time.LocalDate;

public class Uccello extends Animale {
    private String colore;
    private float aperturaAlare;

    public Uccello(String razza, String specie, LocalDate dataNascita, float prezzo, String note, String colore,
            float aperturaAlare) {
        super(razza, specie, dataNascita, prezzo, note);
        this.colore = colore;
        this.aperturaAlare = aperturaAlare;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public float getAperturaAlare() {
        return aperturaAlare;
    }

    public void setAperturaAlare(float aperturaAlare) {
        this.aperturaAlare = aperturaAlare;
    }

}
