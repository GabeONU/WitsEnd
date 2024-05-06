public class Item {
    private String name;
    private int price;
    private int weight;
    private double pricePerPound;

    public Item(String name, int price, int weight, double pricePerPound) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.pricePerPound = pricePerPound;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    public double getPricePerPound() {
        return pricePerPound;
    }
}
