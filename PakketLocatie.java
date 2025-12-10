import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class PakketLocatie extends JFrame {

    private JTextField pakketIdField;
    private JLabel locatieLabel;
    private Map<String, String> pakketLocatieMap;

    public PakketLocatie() {
        // Set up the frame
        setTitle("PakketLocatie");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize the package location map
        pakketLocatieMap = new HashMap<>();
        // Sample data: pakketId -> locatie
        pakketLocatieMap.put("123", "Sectie A, Rek 1");
        pakketLocatieMap.put("456", "Sectie B, Rek 2");
        pakketLocatieMap.put("789", "Sectie C, Rek 3");

        // Create components
        pakketIdField = new JTextField(15);
        JButton zoekButton = new JButton("Zoek Locatie");
        locatieLabel = new JLabel("Locatie: ");

        // Add action listener to the button
        zoekButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pakketId = pakketIdField.getText();
                String locatie = pakketLocatieMap.get(pakketId);
                if (locatie != null) {
                    locatieLabel.setText("Locatie: " + locatie);
                } else {
                    locatieLabel.setText("Pakket niet gevonden.");
                }
            }
        });

        // Set up the layout
        setLayout(new FlowLayout());
        add(new JLabel("Pakket ID:"));
        add(pakketIdField);
        add(zoekButton);
        add(locatieLabel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PakketLocatie().setVisible(true);
            }
        });
    }
}


