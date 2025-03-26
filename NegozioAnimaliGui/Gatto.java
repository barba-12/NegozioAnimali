import java.time.LocalDate;

public class Gatto extends Animale {
    private String mantello;
    private String unghie;

    public Gatto(String razza, String specie, LocalDate dataNascita, float prezzo, String note, String mantello,
            String unghie) {
        super(razza, specie, dataNascita, prezzo, note);
        this.mantello = mantello;
        this.unghie = unghie;
    }

    public String getMantello() {
        return mantello;
    }

    public void setMantello(String mantello) {
        this.mantello = mantello;
    }

    public String getUnghie() {
        return unghie;
    }

    public void setUnghie(String unghie) {
        this.unghie = unghie;
    }

}
