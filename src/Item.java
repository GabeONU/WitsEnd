public class Item {
    private String name;
    private int weight;
    private int price;

    public Item(String name, int weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    // Getter methods for name, weight, and price
    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }
}
