import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Item> itemsStore;

    public Store() {
        itemsStore = new ArrayList<>();
        // Load items from the CSV file
        CSVReader csvReader = new CSVReader();
        itemsStore.addAll(csvReader.readItems("items.csv"));
    }

    public List<Item> getItems() {
        return itemsStore;
    }

    public void purchase(Person buyer, int itemIndex, int quantity) {
        if (itemIndex >= 0 && itemIndex < itemsStore.size()) {
            Item itemToBuy = itemsStore.get(itemIndex);
            int totalPrice = itemToBuy.getPrice() * quantity;
            if (buyer.getMoney() >= totalPrice) {
                buyer.setMoney(-totalPrice);
                for (int i = 0; i < quantity; i++) {
                    buyer.addItemToInventory(itemToBuy);
                }
                System.out.println("Purchase successful: " + itemToBuy.getName() + " x" + quantity);
            } else {
                System.out.println("Not enough money to buy: " + itemToBuy.getName() + " x" + quantity);
            }
        } else {
            System.out.println("Invalid item index: " + itemIndex);
        }
    }
}
