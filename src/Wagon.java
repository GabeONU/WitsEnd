import java.util.ArrayList;
import java.util.List;

public class Wagon {
<<<<<<< HEAD
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

    // Constructor to initialize the wagon with number of people
    public Wagon(int numPeople) {
        this.numPeople = numPeople;
        this.foodPounds = 300;
        this.consumptionRate = BARE_BONES_RATE; // Default consumption rate: bare bones
        this.currentSpeedModifier = NORMAL_SPEED_MODIFIER; // Default speed
        this.items = new ArrayList<>();
        this.maxWeight = 1000; // Assuming maximum weight capacity of the wagon is 1000 lbs
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
=======
    
        private int numPeople;
        private int foodPounds = 0;
        private int consumptionRate;
    
        private static final int BARE_BONES_RATE = 1;
        private static final int MEAGER_RATE = 2;
        private static final int FILLING_RATE = 3;
    
        private static final int NORMAL_SPEED_MODIFIER = 20;
        private static final int STRENUOUS_SPEED_MODIFIER = 30;
        private static final int GRUELING_SPEED_MODIFIER = 40;
    
        public int numberOfOx; 

        private int currentSpeedModifier;
    
        // Constructor to initialize the wagon with number of people
        public Wagon(int numPeople) {
            this.numPeople = numPeople;
            this.foodPounds = 300;
            this.consumptionRate = BARE_BONES_RATE; // Default consumption rate: bare bones
            this.currentSpeedModifier = NORMAL_SPEED_MODIFIER; // Default speed
>>>>>>> 8367da9 (app fair stuff)
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

    public void consumeFood() {
        int consumptionAmount = this.numPeople * this.consumptionRate * 24; // Calculate consumption for 24 hours
        if (this.foodPounds >= consumptionAmount) {
            this.foodPounds -= consumptionAmount;
        } else {
            // Not enough food for today
            System.out.println("Not enough food for today!");
        }

        public void setNumOx(int numOx) {
            this.numberOfOx = numOx;
        }

        public void setOxNumber(int i) {
            this.numberOfOx = numberOfOx + i;
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
