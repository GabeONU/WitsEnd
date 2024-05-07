import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Item> inventory;

    public Store() {
        inventory = new ArrayList<>();
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void purchase(Person person, int itemIndex, int quantity) {
        if (itemIndex >= 0 && itemIndex < inventory.size()) {
            Item item = inventory.get(itemIndex);
            int totalPrice = item.getPrice() * quantity;
            int totalWeight = item.getWeight() * quantity;
            if (person.getMoney() >= totalPrice && person.getWagon().getFreeWeight() >= totalWeight) {
                person.setMoney(person.getMoney() - totalPrice);
                person.getWagon().addItem(new Item(item.getName(), totalWeight, totalPrice));
                System.out.println("You purchased " + quantity + " " + item.getName() + " for $" + totalPrice);
            } else {
                System.out.println("Insufficient funds or not enough space in the wagon.");
            }
        } else {
            System.out.println("Invalid item index.");
        }
    }
}
