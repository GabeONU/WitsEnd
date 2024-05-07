import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Store {
<<<<<<< HEAD
    private List<Item> items;

    public Store() {
        items = new ArrayList<>();
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

        for (String[] itemData : itemsData) {
            String name = itemData[0];
            int weight = Integer.parseInt(itemData[1]);
            int price = Integer.parseInt(itemData[2]);
            items.add(new Item(name, weight, price));
        }
    }

    public List<Item> getItems() {
        return items;
=======
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
>>>>>>> 8367da9 (app fair stuff)
    }
}
