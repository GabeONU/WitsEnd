/**
 * The Storepopup class represents a graphical user interface (GUI) window for interacting with a store.
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Storepopup extends JFrame {
    private Store store; // The store associated with this popup window
    private Person player = new Person(); // The player interacting with the store

    /**
     * Constructs a new Storepopup window.
     * @param store The store to be associated with this popup window
     * @param player The player interacting with the store
     */
    public Storepopup(Store store, Person player) {
        this.store = store; // Initialize the store
        player = Main.player; // Set the player
        initialize(); // Initialize the GUI components
    }

    /**
     * Initializes the GUI components of the Storepopup window.
     */
    private void initialize() {
        player = Main.player; // Set the player
        Main.traveling = false; // Set traveling status to false

        setTitle("Yamhill County's Store"); // Set window title
        setSize(500, 600); // Set window size
        setLocationRelativeTo(null); // Set window location
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Set default close operation

        JPanel panel = new JPanel(); // Create a new JPanel
        getContentPane().add(panel); // Add panel to the content pane
        panel.setLayout(null); // Set layout to null

        JLabel welcomeLabel = new JLabel("Hi, welcome to the store!"); // Create welcome label
        welcomeLabel.setBounds(220, 30, 200, 20); // Set bounds
        panel.add(welcomeLabel); // Add label to panel

        JLabel moneyLabel = new JLabel("Money: $" + player.getMoney()); // Create money label
        moneyLabel.setBounds(20, 30, 100, 20); // Set bounds
        panel.add(moneyLabel); // Add label to panel

        ArrayList<Item> items = store.getItems(); // Get items from store
        for (int i = 0; i < items.size(); i++) {
            final int finalI = i;
            Item item = items.get(i);
            JLabel itemLabel = new JLabel(item.getName() + " - $" + item.getPrice());
            itemLabel.setBounds(20, 60 + i * 30, 200, 20);
            panel.add(itemLabel);

            JTextField quantityField = new JTextField("1");
            quantityField.setBounds(220, 60 + i * 30, 50, 20);
            panel.add(quantityField);

            JButton buyButton = new JButton("Buy");
            buyButton.setBounds(280, 60 + i * 30, 70, 20);
            buyButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int quantity = Integer.parseInt(quantityField.getText());
                    store.purchase(player, finalI, quantity);
                    moneyLabel.setText("Money: $" + player.getMoney());
                }
            });
            panel.add(buyButton);
        }

        JButton exit = new JButton("Exit");
        exit.setBounds(400, 520, 70, 20);
        exit.addActionListener(e -> {
            dispose(); // Dispose the window
            Main.traveling = true; // Set traveling status to true
        });
        panel.add(exit);
    }
}
