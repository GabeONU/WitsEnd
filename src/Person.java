import java.util.ArrayList;
import java.util.List;

public class Person {
    private List<Item> inventory;
    public int money;

    public Person() {
        inventory = new ArrayList<>();
        money = 800; // Initial money
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
}
