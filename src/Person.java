/**
 * The Person class represents a player in the game, managing their inventory and money.
 */
import java.util.ArrayList;
import java.util.List;

public class Person {
    private List<Item> inventory; // The inventory of the person
    public int money; // The amount of money the person has

    /**
     * Constructs a new Person with an empty inventory and the specified initial money.
     */
    public Person() {
        inventory = new ArrayList<>(); // Initialize the inventory as an empty ArrayList
        money = 800; // Initial money
    }

    /**
     * Retrieves the inventory of the person.
     * @return The inventory of the person
     */
    public List<Item> getInventory() {
        return inventory;
    }

    /**
     * Retrieves the amount of money the person has.
     * @return The amount of money the person has
     */
    public int getMoney() {
        return money;
    }

    /**
     * Sets the amount of money the person has by adding the specified amount.
     * @param amount The amount to add to the person's money
     */
    public void setMoney(int amount) {
        money += amount;
    }

    /**
     * Adds an item to the person's inventory.
     * @param item The item to add to the inventory
     */
    public void addItemToInventory(Item item) {
        inventory.add(item);
    }

    /**
     * Removes an item from the person's inventory.
     * @param item The item to remove from the inventory
     */
    public void removeItemFromInventory(Item item) {
        inventory.remove(item);
    }
}
