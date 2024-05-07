import java.util.ArrayList;
import java.util.List;

public class Person {
<<<<<<< HEAD
    private int money;
    private Wagon wagon; // Assuming each person has a wagon
    private List<Item> inventory; // Assuming each person has an inventory
=======
    private List<Item> inventory;
    public int money;
>>>>>>> 8367da9 (app fair stuff)

    public Person(int initialMoney) {
        this.money = initialMoney;
        this.wagon = new Wagon(2400); // Create a wagon for the person with 2400 pounds of food
        this.inventory = new ArrayList<>(); // Initialize inventory
    }

    // Define a getter method for the wagon
    public Wagon getWagon() {
        return this.wagon;
    }

    // Define getter and setter methods for money...
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money += money;
    }

    // Define methods to manage inventory...
    public List<Item> getInventory() {
        return inventory;
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
