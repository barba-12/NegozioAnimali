import java.util.ArrayList;

public class Negozio {
    private String nome;
    private ArrayList<Cliente> clienti;
    private ArrayList<Animale> animali;
    private ArrayList<Animale> animaliComprati;
    private double cassa;

    public Negozio(String nome) {
        this.nome = nome;
        this.cassa = 0;
        this.animali = new ArrayList<>();
        this.animaliComprati = new ArrayList<>();
        this.clienti = new ArrayList<>();
    }

    public void addCliente(Cliente c) {
        clienti.add(c);
    }

    public void addAnimale(Animale a) {
        if(a == null) return;
        cassa-= a.getPrezzo();
        animali.add(a);
        animaliComprati.add(a);
    }

    public ArrayList<Animale> getAnimaliComprati(){
        return animaliComprati;
    }

    public void addAnimaleComprato(Animale a){
        if(a != null) animaliComprati.add(a);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Cliente> getClienti() {
        return clienti;
    }

    public ArrayList<Animale> getAnimali() {
        return animali;
    }

    public double getCassa() {
        return cassa;
    }

    public void setCassa(double cassa) {
        this.cassa = cassa;
    }

    public boolean vendiAnimale(int _codice, Cliente cliente) {
        Animale animaleVenduto = null;

        for (Animale a : animali) {
            if (a.getCodice() != _codice)
                continue;

            animaleVenduto = a;
            break;
        }

        if (animaleVenduto == null)
            return false;

        animali.remove(animaleVenduto);
        cliente.addAnimale(animaleVenduto);
        cassa += animaleVenduto.getPrezzo()*1.5;
        //this.addCliente(cliente);

        return true;
    }

    public int getNumAnimaliVenduti() {
        int num = 0;

        for (Cliente c : clienti)
            num += c.getAnimali().size();

        return num;
    }

    public float getValoreComplessivoAnimali() {
        float price = 0f;

        for (Animale a : animali)
            price += a.getPrezzo();
        
        return price;
    }
}
