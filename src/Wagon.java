import java.util.ArrayList;
import java.util.List;

public class Wagon {
    private int numPeople;
    private int foodPounds = 0;
    private int consumptionRate;
    private List<Item> items;

    private static final int BARE_BONES_RATE = 1;
    private static final int MEAGER_RATE = 2;
    private static final int FILLING_RATE = 3;

    private static final int NORMAL_SPEED_MODIFIER = 20;
    private static final int STRENUOUS_SPEED_MODIFIER = 30;
    private static final int GRUELING_SPEED_MODIFIER = 40;

    private int currentSpeedModifier;
    private int maxWeight; // Maximum weight capacity of the wagon

    // Constructor to initialize the wagon with number of people and maximum weight capacity
    public Wagon(int numPeople, int maxWeight) {
        this.numPeople = numPeople;
        this.foodPounds = 300;
        this.consumptionRate = BARE_BONES_RATE; // Default consumption rate: bare bones
        this.currentSpeedModifier = NORMAL_SPEED_MODIFIER; // Default speed
        this.items = new ArrayList<>();
        this.maxWeight = maxWeight;
    }

    // Method to add food to the wagon
    public void addFood(int pounds) {
        this.foodPounds += pounds;
    }

    // Method to set the consumption rate
    public void setConsumptionRate(int rate) {
        switch (rate) {
            case BARE_BONES_RATE:
            case MEAGER_RATE:
            case FILLING_RATE:
                this.consumptionRate = rate;
                break;
            default:
                System.out.println("Invalid consumption rate.");
        }
    }

    // Method to set the current speed modifier
    public void setCurrentSpeed(String speed) {
        switch (speed.toLowerCase()) {
            case "normal":
                this.currentSpeedModifier = NORMAL_SPEED_MODIFIER;
                break;
            case "strenuous":
                this.currentSpeedModifier = STRENUOUS_SPEED_MODIFIER;
                break;
            case "grueling":
                this.currentSpeedModifier = GRUELING_SPEED_MODIFIER;
                break;
            default:
                System.out.println("Invalid speed. Setting to normal.");
                this.currentSpeedModifier = NORMAL_SPEED_MODIFIER;
        }
    }

    // Method to get the current speed modifier
    public int getCurrentSpeedModifier() {
        return this.currentSpeedModifier;
    }

    // Method to calculate food consumption per hour based on current rate and number of people
    public int calculateFoodConsumptionPerHour() {
        return this.consumptionRate * this.numPeople;
    }

    // Method to simulate consuming food for a specified number of hours
    public void consumeFood() {
        int consumptionAmount = this.numPeople * this.consumptionRate * 5; // Multiply by 5
        if (this.foodPounds >= consumptionAmount) {
            this.foodPounds -= consumptionAmount;
        } else {
            // Not enough food for today
        }
    }

    // Method to get the remaining food pounds
    public int getFoodPounds() {
        return this.foodPounds;
    }

    // Method to add an item to the wagon
    public void addItem(Item item) {
        this.items.add(item);
    }

    // Method to calculate the remaining weight capacity of the wagon
    public int getFreeWeight() {
        int totalWeight = 0;
        for (Item item : items) {
            totalWeight += item.getWeight();
        }
        return this.maxWeight - totalWeight;
    }
}
