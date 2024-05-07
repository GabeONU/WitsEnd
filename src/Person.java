import java.util.ArrayList;
import java.util.List;

public class Person {
    private List<Item> inventory;
    private int money;
    private Wagon wagon; // Add Wagon field

    public Person() {
        inventory = new ArrayList<>();
        money = 800; // Initial money
        wagon = new Wagon(5, money); // Initialize wagon with capacity for 5 people
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int amount) {
        money += amount;
    }

    public void addItemToInventory(Item item) {
        inventory.add(item);
    }

    public void removeItemFromInventory(Item item) {
        inventory.remove(item);
    }
    
    // Add method to get the wagon
    public Wagon getWagon() {
        return wagon;
    }
}
