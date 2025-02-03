public class Gatto extends Animale{
    //attributi
    private String mantello; 
    private String unghie;

    //costruttore
    public Gatto(String razza, String specie, int anno, double prezzo, String note, String mantello, String unghie) {
        super(razza, specie, anno, prezzo, note);
        this.mantello = mantello;
        this.unghie = unghie;
    }

    //metodi
    public String getMantello() {
        return mantello;
    }
    public String getUnghie() {
        return unghie;
    }

    @Override
    public String toString(){
        return "gatto, " + "razza: " + razza + " | anno: " + anno + " | prezzo: " + prezzo + " | mantello: " + mantello + " | unghie: " + unghie;
    }
}