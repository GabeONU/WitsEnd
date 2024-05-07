import javax.swing.*;
<<<<<<< HEAD
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
=======

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
>>>>>>> 8367da9 (app fair stuff)

public class Storepopup extends JFrame {
    private Store store;
    private Person player = new Person();

    public Storepopup(Store store, Person player) {
        this.store = store;
<<<<<<< HEAD
        this.player = player; // Initialize player object
        setupItems(); // Call the setupItems method to populate the store items
    }

    private void setupItems() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        for (Item item : store.getItems()) {
            JButton itemButton = new JButton(item.getName() + " - Price: $" + item.getPrice() + ", Weight: " + item.getWeight() + " lbs");
            itemButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buyItem(item);
                }
            });
            panel.add(itemButton);
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setPreferredSize(new Dimension(400, 300));

        add(scrollPane);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
    }

    private void buyItem(Item item) {
        // Check if the player has enough money and space in the wagon
        if (player.getMoney() >= item.getPrice() && player.getWagon().getFreeWeight() >= item.getWeight()) {
            // Deduct money from player
            player.setMoney(-item.getPrice());
            // Add item to player's inventory
            player.addItemToInventory(item);
            JOptionPane.showMessageDialog(this, "You bought " + item.getName() + " for $" + item.getPrice());
        } else {
            JOptionPane.showMessageDialog(this, "You don't have enough money or space in the wagon.");
=======
        player = Main.player;
        initialize();
    }

    private void initialize() {

        player = Main.player;
        Main.traveling = false;


        setTitle("Yamhill County's Store");
        setSize(500, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel welcomeLabel = new JLabel("Hi, welcome to the store!");
        welcomeLabel.setBounds(220, 30, 200, 20);
        panel.add(welcomeLabel);

        JLabel moneyLabel = new JLabel("Money: $" + player.getMoney());
        moneyLabel.setBounds(20, 30, 100, 20);
        panel.add(moneyLabel);

        ArrayList<Item> items = store.getItems();
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
>>>>>>> 8367da9 (app fair stuff)
        }

        JButton exit = new JButton("Exit");
        exit.setBounds(400, 520, 70, 20);
        exit.addActionListener(e -> {
            dispose();
            Main.traveling = true;
        });
        panel.add(exit);
        
    }
}
