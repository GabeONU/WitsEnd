/**
 * Description: 
 * Author: Julian Calvelage, Enzo Bordogna and Gabe Parry
 * Date: 5/9/2024
 */

/**
 * The Wagon class represents a wagon used for traveling in the game.
 */
public class Wagon {

    private int numPeople; // Number of people in the wagon
    private int foodPounds = 0; // Amount of food in pounds
    private int consumptionRate; // Rate at which food is consumed
    private static final int BARE_BONES_RATE = 1; // Constant for bare bones consumption rate
    private static final int MEAGER_RATE = 2; // Constant for meager consumption rate
    private static final int FILLING_RATE = 3; // Constant for filling consumption rate
    private static final int NORMAL_SPEED_MODIFIER = 20; // Normal speed modifier
    private static final int STRENUOUS_SPEED_MODIFIER = 30; // Strenuous speed modifier
    private static final int GRUELING_SPEED_MODIFIER = 40; // Grueling speed modifier
    public int numberOfOx; // Number of oxen pulling the wagon
    private int currentSpeedModifier; // Current speed modifier

    /**
     * Constructs a wagon with a specified number of people.
     * @param numPeople The number of people in the wagon
     */
    public Wagon(int numPeople) {
        this.numPeople = numPeople; // Initialize number of people
        this.foodPounds = 300; // Initialize food pounds
        this.consumptionRate = BARE_BONES_RATE; // Default consumption rate
        this.currentSpeedModifier = NORMAL_SPEED_MODIFIER; // Default speed modifier
    }

    /**
     * Adds food to the wagon.
     * @param pounds The amount of food to add in pounds
     */
    public void addFood(int pounds) {
        this.foodPounds += pounds;
    }

    /**
     * Sets the consumption rate of the wagon.
     * @param rate The consumption rate to set
     */
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

    /**
     * Sets the current speed modifier of the wagon.
     * @param speed The speed modifier to set
     */
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

    /**
     * Gets the current speed modifier of the wagon.
     * @return The current speed modifier
     */
    public int getCurrentSpeedModifier() {
        return this.currentSpeedModifier;
    }

    /**
     * Calculates the food consumption per hour based on the current rate and number of people.
     * @return The food consumption per hour
     */
    public int calculateFoodConsumptionPerHour() {
        return this.consumptionRate * this.numPeople;
    }

    /**
     * Simulates consuming food for a specified number of hours.
     */
    public void consumeFood() {
        int consumptionAmount = this.numPeople * this.consumptionRate * 5;
        if (this.foodPounds >= consumptionAmount) {
            this.foodPounds -= consumptionAmount;
        } else {
            // Not enough food for today
        }
    }

    /**
     * Gets the remaining food pounds in the wagon.
     * @return The remaining food pounds
     */
    public int getFoodPounds() {
        return this.foodPounds;
    }

    /**
     * Sets the number of oxen pulling the wagon.
     * @param numOx The number of oxen to set
     */
    public void setNumOx(int numOx) {
        this.numberOfOx = numOx;
    }

    /**
     * Adds a specified number to the current number of oxen.
     * @param i The number to add to the current number of oxen
     */
    public void setOxNumber(int i) {
        this.numberOfOx = numberOfOx + i;
    }
} 


       

    
    

