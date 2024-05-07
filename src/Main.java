import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Main {

    private JFrame frmOregonTrail;
    private static CSVReader csvRead = new CSVReader();
    private static LabelReader lblMake = new LabelReader();
    public static int miliSecondCound = 0;
    public static int secondCount = 0;
    private static List<JLabel> allLabels = new ArrayList<>();
    private static Wagon wagon = new Wagon(5, miliSecondCound);

    private static boolean traveling = true;

    private static MyLabel lblFood = new MyLabel("Pounds of Food:");

    private Store store;
    private Person player;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main window = new Main();
                    window.frmOregonTrail.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Main() {
        initialize();
    }

    private void initialize() {
        frmOregonTrail = new JFrame();
        frmOregonTrail.setTitle("Oregon Trail");
        frmOregonTrail.setBounds(100, 100, 900, 600);
        frmOregonTrail.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmOregonTrail.getContentPane().setLayout(null);

        MyLabel lblDays = new MyLabel("Number of Days: ");
        lblDays.setBounds(29, 417, 179, 16);
        frmOregonTrail.getContentPane().add(lblDays);

        MyLabel lblHealth = new MyLabel("Party Health:  ");
        lblHealth.setBounds(29, 440, 179, 16);
        frmOregonTrail.getContentPane().add(lblHealth);

        lblFood.setBounds(29, 462, 179, 16);
        frmOregonTrail.getContentPane().add(lblFood);

        MyLabel lblMoney = new MyLabel("Party Money:");
        lblMoney.setBounds(29, 486, 179, 16);
        frmOregonTrail.getContentPane().add(lblMoney);

        JButton btnState = new JButton("Pause/ Resume");
        btnState.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                traveling = !traveling;
            }
        });
        btnState.setBounds(220, 412, 137, 29);
        frmOregonTrail.getContentPane().add(btnState);

        JButton btnStore = new JButton("Store");
        btnStore.setBounds(370, 412, 117, 29);
        frmOregonTrail.getContentPane().add(btnStore);
        btnStore.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openStore();
            }

        });

        JLabel lblStats = new JLabel("Stats:");
        lblStats.setBounds(51, 389, 61, 16);
        frmOregonTrail.getContentPane().add(lblStats);

        JButton SpeedIncrease = new JButton("Speed Increase");
        SpeedIncrease.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        SpeedIncrease.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 13));
        SpeedIncrease.setBounds(520, 412, 170, 29);
        frmOregonTrail.getContentPane().add(SpeedIncrease);

        JButton SpeedDecrease = new JButton("Speed Increase");
        SpeedDecrease.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        JLabel SpeedRateDisplay = new JLabel("Speed Rate: "/* + wag.getCurrentSpeedModifier()*/);
        SpeedRateDisplay.setBounds(520, 440, 170, 29);
        frmOregonTrail.getContentPane().add(SpeedRateDisplay);

        SpeedDecrease.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 13));
        SpeedDecrease.setBounds(520, 470, 170, 29);
        frmOregonTrail.getContentPane().add(SpeedDecrease);

        JButton foodConsumptionIncrease = new JButton("Consumption Increase");
        foodConsumptionIncrease.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });


        foodConsumptionIncrease.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 13));
        foodConsumptionIncrease.setBounds(715, 412, 170, 29);
        frmOregonTrail.getContentPane().add(foodConsumptionIncrease);

        JButton foodConsumptionDecrease = new JButton("Consumption Decrease");
        foodConsumptionDecrease.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        JLabel DisplayConsumtionRate = new JLabel("ConsumtionRate: ");
        DisplayConsumtionRate.setBounds(715, 440, 170, 29);
        frmOregonTrail.getContentPane().add(DisplayConsumtionRate);

        foodConsumptionDecrease.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 13));
        foodConsumptionDecrease.setBounds(715, 470, 170, 29);
        frmOregonTrail.getContentPane().add(foodConsumptionDecrease);

        gameLoop();
    }

    private void openStore() {
        Store store = new Store(); // Instantiate the store
        Person player = getPlayer(); // Get the player object (you need to implement this method)
        Storepopup storepopup = new Storepopup(store, player);
        storepopup.setVisible(true);
    }

    private Person getPlayer() {
        if (player == null) {
            player = new Person();
        }
        return player;
    }

    private void gameLoop() {
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wagon.consumeFood(); // Simulate consuming food every second
                lblFood.setText("Pounds of Food: " + wagon.getFoodPounds()); // Update food label
                // Implement other game logic here
                // Update UI elements if necessary
            }
        });
        timer.start();
    }
}
