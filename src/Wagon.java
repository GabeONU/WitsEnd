public class Wagon {
    
    //speed changing stuff in rate of miles per hour
    public static final int NORMAL_SPEED_MODIFIER = 20;
    public static final int STRENUOUS_SPEED_MODIFIER = 30;
    public static final int GRUELING_SPEED_MODIFIER = 40;

    private int currentSpeedModifier;


    public Wagon() {
        this.currentSpeedModifier = NORMAL_SPEED_MODIFIER;
    }
    
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

    public int getCurrentSpeedModifier() {
        return this.currentSpeedModifier;
    }

  
}
