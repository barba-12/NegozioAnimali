import java.util.ArrayList;

public class Negozio {
    //attributi
    private String nome;
    private double cassa;
    private ArrayList<Cliente> clienti;
    private ArrayList<Animale> animali;

    //Costruttore
    public Negozio(String nome) {
        this.nome = nome;
        cassa = 0;
        clienti = new ArrayList<Cliente>();
        animali = new ArrayList<Animale>();
    }

    //metodi
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getCassa() {
        return cassa;
    }
    public void setCassa(double cassa) {
        this.cassa = cassa;
    }
    public ArrayList<Cliente> getClienti() {
        return clienti;
    }
    public void setClienti(ArrayList<Cliente> clienti) {
        this.clienti = clienti;
    }
    public ArrayList<Animale> getAnimali() {
        return animali;
    }
    public void setAnimali(ArrayList<Animale> animali) {
        this.animali = animali;
    }

    //aggiungi cliente
    public void addCliente(Cliente c){
        clienti.add(c);
    }

    //aggiungi animale
    public void addAnimale(Animale a){
        animali.add(a);
    }

    //aquista animale
    public boolean sellAnimale(int codice, Cliente c){
        Animale animaleVenduto = null;
        for(Animale a : animali){
            if(a.codice == codice){
                animaleVenduto = a;
                break;
            }
        }
        if(animaleVenduto != null){
            animali.remove(animaleVenduto);
            c.addAnimale(animaleVenduto);
            cassa+=animaleVenduto.getPrezzo();
            return true;
        }
        else return false;
    }

    //numero di animali venduti
    public int getNumAnimaliVenduti(){
        int numAnimali = 0;
        for(Cliente c : clienti){
            numAnimali += c.getAnimali().size();
        }
        return numAnimali;
    }

    //valore complessivo
    public double getValoreComplessivo(){
        double val = 0;
        for(Animale a : animali){
            val += a.getPrezzo();
        }
        return val;
    }
}