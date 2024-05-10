/**
 * The Store class represents a store where players can purchase items.
 */
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Store {
    private ArrayList<Item> itemsStore; // The list of items available in the store

    /**
     * Constructs a new Store and initializes it with items from a CSV file.
     */
    public Store() {
        itemsStore = new ArrayList<>(); // Initialize the itemsStore as an empty ArrayList
        CSVReader csvReader = new CSVReader(); // Create a CSVReader instance
        itemsStore.addAll(csvReader.readItems("src/csv/items.csv")); // Read items from CSV and add to store
    }

    /**
     * Retrieves the list of items available in the store.
     * @return The list of items available in the store
     */
    public ArrayList<Item> getItems() {
        return itemsStore;
    }

    /**
     * Allows a person to purchase a specified quantity of an item from the store.
     * @param buyer The person making the purchase
     * @param itemIndex The index of the item to purchase in the store's list
     * @param quantity The quantity of the item to purchase
     */
    public void purchase(Person buyer, int itemIndex, int quantity) {
        if (itemIndex >= 0 && itemIndex < itemsStore.size()) { // Check if item index is valid
            Item itemToBuy = itemsStore.get(itemIndex); // Get the item to buy
            int totalPrice = itemToBuy.getPrice() * quantity; // Calculate total price
            if (buyer.getMoney() >= totalPrice) { // Check if buyer has enough money
                buyer.setMoney(-1 * totalPrice); // Subtract total price from buyer's money
                for (int i = 0; i < quantity; i++) { // Add purchased items to buyer's inventory
                    buyer.addItemToInventory(itemToBuy);
                }
                JOptionPane.showMessageDialog(null, "Bought " + itemToBuy.getName() + " x" + quantity + " for $" + totalPrice);
            } else {
                JOptionPane.showMessageDialog(null, "Not enough money to buy " + itemToBuy.getName() + " x" + quantity);
            }
        } else {
            System.out.println("Invalid item index: " + itemIndex); // Print error for invalid index
        }
    }
}
