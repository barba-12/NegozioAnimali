import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class MainWindow extends JFrame implements ActionListener {
    private JLabel header;
    private JPanel mainContent;
    private static final String TITLE = "Negozio di animali";
    private static final int WINDOW_WIDTH = 1200;
    private static final int WINDOW_HEIGHT = 675;
    private static final int HEADER_HEIGHT = 60;
    private static Negozio negozio = new Negozio("negozio animali");

    private enum Page {
        BUY("Acquista Animali"),
        SELL("Vendi Animali"),
        MANAGE("Gestionale");

        private final String buttonText;

        Page(String buttonText) {
            this.buttonText = buttonText;
        }

        public String getButtonText() {
            return buttonText;
        }
    }

    public MainWindow() {
        setTitle(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        init();
    }

    private void init() {
        mainContent = new JPanel(new BorderLayout());
        add(mainContent, BorderLayout.CENTER);
        showHomePage();
        setVisible(true);
    }

    private void clean() {
        mainContent.removeAll();
        mainContent.revalidate();
        mainContent.repaint();
    }

    private void setHeader() {
        header = new JLabel(TITLE, SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 30));
        header.setOpaque(true);
        header.setBackground(Color.GRAY);
        header.setForeground(Color.WHITE);
        header.setPreferredSize(new Dimension(getWidth(), HEADER_HEIGHT));

        add(header, BorderLayout.NORTH);
    }

    private void setBackButton(){
        MyButton backButton = new MyButton("Torna alla Home");
        backButton.addActionListener(evt -> showHomePage());
        add(backButton, BorderLayout.SOUTH);
    }

    private void showHomePage() {
        clean();
        setHeader();
        JPanel container = new JPanel(new BorderLayout(20, 20));
        container.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel grid = new JPanel(new GridLayout(1, Page.values().length, 20, 20));

        for (Page page : Page.values()) {
            MyButton button = new MyButton(page.getButtonText());
            button.addActionListener(this);
            button.setActionCommand(page.name());
            grid.add(button);
        }

        container.add(grid, BorderLayout.NORTH);

        JLabel welcome = new JLabel(
                "Benvenuto nel gestionale del negozio. Scegliere la sezione interessata.",
                SwingConstants.CENTER
        );
        welcome.setFont(new Font("Arial", Font.PLAIN, 18));
        container.add(welcome, BorderLayout.CENTER);

        mainContent.add(container, BorderLayout.CENTER);
    }

    public void showBuyPage() {
        clean();  // Pulire il pannello esistente
        setHeader();
        setBackButton();

        // Variabili per i campi specifici degli animali
        JTextField txtOrecchie = new JTextField();
        JTextField txtMantello = new JTextField();
        JTextField txtUnghie = new JTextField();
        JTextField txtColore = new JTextField();
        JTextField txtAperturaAlare = new JTextField();

        DefaultListModel<String> lista = new DefaultListModel<>();
        JList<String> jList = new JList<>(lista);
        JScrollPane scrollPane = new JScrollPane(jList);
        
        JPanel panel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(0, 2));
        
        JLabel lblTipo = new JLabel("Tipo di animale:");
        String[] animali = {"none", "Cane", "Gatto", "Uccello"};
        JComboBox<String> cbTipo = new JComboBox<>(animali);
        
        JLabel lblRazza = new JLabel("Razza:");
        JTextField txtRazza = new JTextField();
        
        JLabel lblDataNascita = new JLabel("Data di nascita (YYYY-MM-DD):");
        JTextField txtDataNascita = new JTextField();
        
        JLabel lblPrezzo = new JLabel("Prezzo:");
        JTextField txtPrezzo = new JTextField();
        
        JLabel lblNote = new JLabel("Note:");
        JTextField txtNote = new JTextField();
        
        cbTipo.addActionListener(e -> {
            inputPanel.removeAll(); // Puliamo il pannello
        
            // Aggiunta dei campi comuni a tutti gli animali
            inputPanel.add(lblTipo);
            inputPanel.add(cbTipo);
            inputPanel.add(lblRazza);
            inputPanel.add(txtRazza);
            inputPanel.add(lblDataNascita);
            inputPanel.add(txtDataNascita);
            inputPanel.add(lblPrezzo);
            inputPanel.add(txtPrezzo);
            inputPanel.add(lblNote);
            inputPanel.add(txtNote);
        
            String tipo = (String) cbTipo.getSelectedItem();
        
            if ("Cane".equals(tipo)) {
                inputPanel.add(new JLabel("Forma Orecchie:"));
                inputPanel.add(txtOrecchie);
                
                inputPanel.add(new JLabel("Tipo Mantello:"));
                inputPanel.add(txtMantello);
            } else if ("Gatto".equals(tipo)) {
                inputPanel.add(new JLabel("Mantello:"));
                inputPanel.add(txtMantello);
                
                inputPanel.add(new JLabel("Unghie:"));
                inputPanel.add(txtUnghie);
            } else if ("Uccello".equals(tipo)) {
                inputPanel.add(new JLabel("Colore:"));
                inputPanel.add(txtColore);
                
                inputPanel.add(new JLabel("Apertura Alare (cm):"));
                inputPanel.add(txtAperturaAlare);
            }
        
            inputPanel.revalidate();
            inputPanel.repaint();
        });
        
        JButton btnAggiungi = new JButton("Aggiungi");
        btnAggiungi.addActionListener(e -> {
            try {
                String tipo = (String) cbTipo.getSelectedItem();
                String razza = txtRazza.getText().trim();
                LocalDate dataNascita = LocalDate.parse(txtDataNascita.getText().trim());
                float prezzo = Float.parseFloat(txtPrezzo.getText().trim());
                String note = txtNote.getText().trim();

                //aggiungo al negozio l'anima inserito dall'utebnte
                if ("Cane".equals(tipo)) {
                    String formaOrecchie = txtOrecchie.getText().trim();
                    String tipoMantello = txtMantello.getText().trim();
                    negozio.addAnimale(new Cane("Cane", razza, dataNascita, prezzo, note, formaOrecchie, tipoMantello));
                } else if ("Gatto".equals(tipo)) {
                    String mantello = txtMantello.getText().trim();
                    String unghie = txtUnghie.getText().trim();
                    negozio.addAnimale(new Gatto("Gatto", razza, dataNascita, prezzo, note, mantello, unghie));
                } else if ("Uccello".equals(tipo)) {
                    String colore = txtColore.getText().trim();
                    int aperturaAlare = Integer.parseInt(txtAperturaAlare.getText().trim());
                    negozio.addAnimale(new Uccello("Uccello", razza, dataNascita, prezzo, note, colore, aperturaAlare));
                }

                String dettagli = tipo + " - " + razza + " - " + dataNascita + " - " + prezzo + " - " + note;
                lista.addElement(dettagli);
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Errore nell'inserimento dei dati!");
            }
        });
        
        inputPanel.add(lblTipo);
        inputPanel.add(cbTipo);
        inputPanel.add(lblRazza);
        inputPanel.add(txtRazza);
        inputPanel.add(lblDataNascita);
        inputPanel.add(txtDataNascita);
        inputPanel.add(lblPrezzo);
        inputPanel.add(txtPrezzo);
        inputPanel.add(lblNote);
        inputPanel.add(txtNote);
        
        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(btnAggiungi, BorderLayout.SOUTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        mainContent.add(panel, BorderLayout.CENTER);
        mainContent.revalidate();
        mainContent.repaint();
    }

    public void showSellPage() {
        clean();  // Pulire il pannello esistente
        setHeader();
        setBackButton();
    
        DefaultListModel<String> lista = new DefaultListModel<>();
        JList<String> jList = new JList<>(lista);
        JScrollPane scrollPane = new JScrollPane(jList);
        
        for (Animale a : negozio.getAnimali()) {
            lista.addElement(a.getRazza() + " - " + a.getSpecie() + " - " + a.getDataNascita() + " - " + a.getPrezzo() + " - " + a.getNote() + " - ID: " + a.getCodice());
        }

        JPanel panel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(0, 2));
        
        JLabel lblNome = new JLabel("Nome:");
        JTextField txtNome = new JTextField();
        
        JLabel lblCognome = new JLabel("Cognome:");
        JTextField txtCognome = new JTextField();
        
        JLabel lblIndirizzo = new JLabel("Indirizzo:");
        JTextField txtIndirizzo = new JTextField();
        
        JLabel lblTelefono = new JLabel("Telefono:");
        JTextField txtTelefono = new JTextField();
        
        JLabel lblIdAnimale = new JLabel("ID Animale:");
        JTextField txtIdAnimale = new JTextField();
        
        JButton btnAcquista = new JButton("Acquista");
        btnAcquista.addActionListener(e -> {
            try {
                String nome = txtNome.getText().trim();
                String cognome = txtCognome.getText().trim();
                String Indirizzo = txtIndirizzo.getText().trim();
                String telefono = txtTelefono.getText().trim();
                int idAnimale = Integer.parseInt(txtIdAnimale.getText().trim());

                Animale animaleComprato = negozio.getAnimali().get(idAnimale-1);
                System.out.println(negozio.vendiAnimale(idAnimale, new Cliente(nome, cognome, Indirizzo, telefono)));
                
                lista.removeElement(animaleComprato.getRazza() + " - " + animaleComprato.getSpecie() + " - " + animaleComprato.getDataNascita() + " - " + animaleComprato.getPrezzo() + " - " + animaleComprato.getNote() + " - ID: " + animaleComprato.getCodice());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Errore nell'inserimento dei dati!");
            }
        });
        
        JPanel containerPanel = new JPanel(new BorderLayout());
        JPanel combinedInputsPanel = new JPanel(new BorderLayout());
        
        inputPanel.add(lblNome);
        inputPanel.add(txtNome);
        inputPanel.add(lblCognome);
        inputPanel.add(txtCognome);
        inputPanel.add(lblIndirizzo);
        inputPanel.add(txtIndirizzo);
        inputPanel.add(lblTelefono);
        inputPanel.add(txtTelefono);
        inputPanel.add(lblIdAnimale);
        inputPanel.add(txtIdAnimale);
        
        combinedInputsPanel.add(inputPanel, BorderLayout.NORTH);
        
        containerPanel.add(combinedInputsPanel, BorderLayout.NORTH);
        containerPanel.add(btnAcquista, BorderLayout.SOUTH);
        containerPanel.add(scrollPane, BorderLayout.CENTER);
        
        panel.add(containerPanel, BorderLayout.CENTER);
        
        mainContent.add(panel, BorderLayout.CENTER);
        mainContent.revalidate();
        mainContent.repaint();
    }
    
    public void showManagementPage() {
        clean();  // Pulire il pannello esistente
        setHeader();
        setBackButton();
        
        JPanel panel = new JPanel(new BorderLayout());
        
        // Saldo del negozio
        JLabel lblSaldo = new JLabel("Saldo attuale del negozio: €0", SwingConstants.CENTER);
        lblSaldo.setFont(new Font("Arial", Font.BOLD, 16));
        
        // Lista degli animali venduti
        /* a.getRazza() + " - " + a.getSpecie() + " - " + a.getDataNascita() + " - " + a.getPrezzo() + " - " + a.getNote() + " - ID: " + a.getCodice() */
        DefaultListModel<String> listaVendite = new DefaultListModel<>();
        JList<String> jListVendite = new JList<>(listaVendite);
        JScrollPane scrollPane = new JScrollPane(jListVendite);

        if(negozio.getAnimaliComprati() != null){
            for (Animale a : negozio.getAnimaliComprati()) {
                listaVendite.addElement(a.getRazza() + " - " + a.getSpecie() + " - " + a.getDataNascita() + " - " + a.getPrezzo() + " - " + a.getNote() + " - ID: " + a.getCodice());
            }
        }

        lblSaldo.setText("Saldo attuale del negozio: €" + String.format("%.2f", negozio.getCassa()));
        
        panel.add(lblSaldo, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        mainContent.add(panel, BorderLayout.CENTER);
        mainContent.revalidate();
        mainContent.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        clean();

        if(command.equals("BUY")) showBuyPage();
        if(command.equals("SELL")) showSellPage();
        if(command.equals("MANAGE")) showManagementPage();
    }
}