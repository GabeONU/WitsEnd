import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Storepopup extends JFrame {
    private Store store;
    private Person player;

    public Storepopup(Store store, Person player) {
        this.store = store;
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
        }
    }
}
