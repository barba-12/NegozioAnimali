import java.time.LocalDate;

public class Cane extends Animale {
    private String formaOrecchie, tipoMantello;

    public Cane(String razza, String specie, LocalDate dataNascita, float prezzo, String note, String formaOrecchie,
            String tipoMantello) {
        super(razza, specie, dataNascita, prezzo, note);
        this.formaOrecchie = formaOrecchie;
        this.tipoMantello = tipoMantello;
    }

    public String getFormaOrecchie() {
        return formaOrecchie;
    }

    public void setFormaOrecchie(String formaOrecchie) {
        this.formaOrecchie = formaOrecchie;
    }

    public String getTipoMantello() {
        return tipoMantello;
    }

    public void setTipoMantello(String tipoMantello) {
        this.tipoMantello = tipoMantello;
    }

}
