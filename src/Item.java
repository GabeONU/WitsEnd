/**
 * Represents an item that can be bought or sold in a store.
 */
public class Item {
    /** The name of the item. */
    private String name;

    /** The price of the item. */
    private int price;

    /** The weight of the item. */
    private int weight;

    /** The price per pound of the item. */
    private double pricePerPound;

    /**
     * Constructs a new item with the specified attributes.
     *
     * @param name the name of the item
     * @param price the price of the item
     * @param weight the weight of the item
     * @param pricePerPound the price per pound of the item
     */
    public Item(String name, int price, int weight, double pricePerPound) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.pricePerPound = pricePerPound;
    }

    /**
     * Gets the name of the item.
     *
     * @return the name of the item
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the price of the item.
     *
     * @return the price of the item
     */
    public int getPrice() {
        return price;
    }

    /**
     * Gets the weight of the item.
     *
     * @return the weight of the item
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Gets the price per pound of the item.
     *
     * @return the price per pound of the item
     */
    public double getPricePerPound() {
        return pricePerPound;
    }
}
