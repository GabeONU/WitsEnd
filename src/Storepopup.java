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
        this.player = player;
        setupItems();
    }

    private void setupItems() {
        List<String[]> itemsData = new ArrayList<>();
        itemsData.add(new String[]{"Bedroll", "15", "5"});
        itemsData.add(new String[]{"Blacksmithing Tools", "200", "10"});
        itemsData.add(new String[]{"Books", "75", "3"});
        itemsData.add(new String[]{"Medicine", "10", "1"});
        itemsData.add(new String[]{"Cast Iron Stove", "300", "20"});
        itemsData.add(new String[]{"Chair", "20", "8"});
        itemsData.add(new String[]{"Cookware & Eating Utensils", "75", "4"});
        itemsData.add(new String[]{"Granny's Clock", "15", "3"});
        itemsData.add(new String[]{"Gun Making Tools", "200", "12"});
        itemsData.add(new String[]{"Keepsakes", "40", "2"});
        itemsData.add(new String[]{"Lead Shot", "25", "6"});
        itemsData.add(new String[]{"Mirror", "15", "2"});
        itemsData.add(new String[]{"Gunpowder", "80", "5"});
        itemsData.add(new String[]{"Tent & Gear", "150", "15"});
        itemsData.add(new String[]{"Tools", "50", "7"});
        itemsData.add(new String[]{"Toys", "15", "1"});

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        for (String[] itemData : itemsData) {
            String itemName = itemData[0];
            int itemWeight = Integer.parseInt(itemData[1]);
            int itemPrice = Integer.parseInt(itemData[2]);

            JButton itemButton = new JButton(itemName + " - Price: $" + itemPrice + ", Weight: " + itemWeight + " lbs");
            itemButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buyItem(itemName, itemWeight, itemPrice);
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

    private void buyItem(String itemName, int itemWeight, int itemPrice) {
        // Check if the player has enough money and space in the wagon
        if (player.getMoney() >= itemPrice && player.getWagon().getFreeWeight() >= itemWeight) {
            // Deduct money from player
            player.setMoney(-itemPrice);
            // Add item to player's inventory
            player.addItemToInventory(new Item(itemName, itemWeight, itemPrice));
            JOptionPane.showMessageDialog(this, "You bought " + itemName + " for $" + itemPrice);
        } else {
            JOptionPane.showMessageDialog(this, "You don't have enough money or space in the wagon.");
        }
    }
}
