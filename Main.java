public class Main{
/* Si vogliono gestire le informazioni relative ad un negozio di animali, di ogni animale interessa codice univoco, razza, specie,
anno di nascita, prezzo, note. Il negozio di animale vende principalmente CANI, GATTI e UCCELLI. 
Dei cani in particolare interessa la forma delle orecchie, e il tipo di mantello (corto o lungo, ispido o morbido, liscio o riccio).
Dei gatti in particolare interessa mantello e tipologia delle unghie (retrattili o protrattili).
Degli uccelli in particolare interessa colore del piumaggio e apertura alare.
Degli acquirenti/proprietari interessa nome, cognome, indirizzo, telefono. Si noti che un animale può essere acquistato da un solo
proprietario.
Realizzare un’applicazione che gestisca l’elenco degli animali del negozio (inseriti hard coded), e permetta di inserire i dati del
compratore (che dovranno essere memorizzati dal programma unitamente al codice dell’animale acquistato). All’esecuzione dell’acquisto
l’animale risulterà acquistato dal compratore e sarà eliminato dalla lista degli animali del negozio e associato direttamente al
cliente. 
Si noti che il negozio dovrà tenere traccia di tutti i suoi clienti.
Predisporre i metodi per visualizzare:
Numero di animali vendutiCifra totale incassataNumero di clientiNumero di animali nel negozio e valore complessivo */
    public static void main(String[] args) {
        Negozio negozio = new Negozio("n1");
        negozio.addAnimale(new Gatto("siamese", "gatto", 2018, 100, "", "riccio", "rettratili"));
        negozio.addAnimale(new Gatto("sphynx", "gatto", 2018, 100, "", "riccio", "rettratili"));
        negozio.addAnimale(new Gatto("europeo", "gatto", 2018, 100, "", "riccio", "rettratili"));
        
        negozio.addCliente(new Cliente("tadei", "pogacia", "", ""));
    }
}