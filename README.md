# Negozio di Animali

Un programma in linguaggio Java che simula la gestione di un negozio di animali. Il negozio può vendere animali ai clienti, gestire la cassa e tenere traccia degli animali disponibili e venduti.

## Caratteristiche

- **Gestione dinamica del negozio:**
  - Aggiunta e rimozione di animali dal negozio.
  - Registrazione dei clienti e degli acquisti.
  - Calcolo del valore complessivo degli animali disponibili.
  
- **Classi principali:**
  - `Negozio`: Gestisce gli animali e le vendite.
  - `Cliente`: Rappresenta un cliente che può acquistare animali.
  - `Animale`: Classe base per gli animali venduti.
  - `Gatto`: Sottoclasse di `Animale`, specifica per i gatti.

## Requisiti

- **Java 8+**
- **Ambiente di sviluppo** come IntelliJ IDEA, Eclipse o Visual Studio Code

## Installazione ed Esecuzione

### Compilazione
Per compilare il programma, eseguire il seguente comando nella cartella del progetto:
```sh
javac *.java
```

### Esecuzione
Per eseguire il programma, usare il comando:
```sh
java Main
```

Durante l'esecuzione:
1. Il negozio viene inizializzato con una lista di animali e clienti.
2. I clienti possono acquistare animali disponibili.
3. Il sistema aggiorna automaticamente la cassa e il numero di animali venduti.

## Struttura del Programma

- **Metodi principali:**
  - `addCliente()`: Aggiunge un nuovo cliente.
  - `addAnimale()`: Aggiunge un nuovo animale.
  - `sellAnimale()`: Gestisce la vendita di un animale a un cliente.
  - `getNumAnimaliVenduti()`: Restituisce il numero totale di animali venduti.
  - `getValoreComplessivo()`: Calcola il valore totale degli animali disponibili.

## Esempio di Utilizzo

Durante l'esecuzione del programma, verranno stampati messaggi come:
```
Cliente Mario vuole comprare un Cane.
Negozio: Venduto Animale: Cane, Prezzo: 100.0€.
Mario ha comprato: Animale: Cane, Prezzo: 100.0€.
```

## Personalizzazione

Puoi estendere il programma aggiungendo nuove classi di animali, come `Cane` o `Uccello`, ereditando dalla classe `Animale` e implementando metodi specifici.

## Suggerimenti per il Debug

- **Verificare la disponibilità dell'animale:** Assicurarsi che il codice dell'animale sia valido prima di eseguire la vendita.
- **Gestione degli errori:** Implementare controlli per evitare tentativi di acquisto di animali non disponibili.

