import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Store {
    private ArrayList<Item> itemsStore;

    public Store() {
        itemsStore = new ArrayList<>();
        CSVReader csvReader = new CSVReader();
        itemsStore.addAll(csvReader.readItems("src/csv/items.csv"));
    }

    public ArrayList<Item> getItems() {
        return itemsStore;
    }

    public void purchase(Person buyer, int itemIndex, int quantity) {
        if (itemIndex >= 0 && itemIndex < itemsStore.size()) {
            Item itemToBuy = itemsStore.get(itemIndex);
            int totalPrice = itemToBuy.getPrice() * quantity;
            if (buyer.getMoney() >= totalPrice) {
                buyer.setMoney(-1 * totalPrice);
                for (int i = 0; i < quantity; i++) {
                    buyer.addItemToInventory(itemToBuy);
                }
                JOptionPane.showMessageDialog(null, "Bought " + itemToBuy.getName() + " x" + quantity + " for $" + totalPrice);
            } else {
                JOptionPane.showMessageDialog(null, "Not enough money to buy " + itemToBuy.getName() + " x" + quantity);
            }
        } else {
            System.out.println("Invalid item index: " + itemIndex);
        }
    }
}
