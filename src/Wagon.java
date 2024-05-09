public class Wagon {
    
        private int numPeople;
        private int foodPounds = 0;
        private int consumptionRate;
    
        private static final int BARE_BONES_RATE = 1;
        private static final int MEAGER_RATE = 2;
        private static final int FILLING_RATE = 3;
        private int foodConsumeIndex;
        private static final int NORMAL_SPEED_MODIFIER = 20;
        private static final int STRENUOUS_SPEED_MODIFIER = 30;
        private static final int GRUELING_SPEED_MODIFIER = 40;
    
        public int numberOfOx; 

        private int currentSpeedModifier;
    
        // Constructor to initialize the wagon with number of people
       
       
        public void setFoodConsumeIndex(int index) {
            this.foodConsumeIndex = index;
        }
        public Wagon(int numPeople) {
            this.numPeople = numPeople;
            this.foodPounds = 300;
            this.consumptionRate = BARE_BONES_RATE; // Default consumption rate: bare bones
            this.currentSpeedModifier = NORMAL_SPEED_MODIFIER; // Default speed
        }
    
        // Method to add food to the wagon
        public void addFood(int pounds) {
            this.foodPounds += pounds;
        }
    
        // Method to set the consumption rate
        public void setConsumptionRate(int index) {
                    this.consumptionRate = index;
                   
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
            int consumptionAmount = this.numPeople * this.consumptionRate; // Multiply by 5
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

        public void setNumOx(int numOx) {
            this.numberOfOx = numOx;
        }

        public void setOxNumber(int i) {
            this.numberOfOx = numberOfOx + i;
        }
        public int getConsumptionRate() {
            return consumptionRate;
        }

    }
    
