import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.JFrame;

public class Main {

    private JFrame frmOregonTrail;
    private static CSVReader csvRead = new CSVReader();
    private static LabelReader lblMake = new LabelReader();
    public static int miliSecondCound = 0;
    public static int secondCount = 0;
    private static List<JLabel> allLabels = new ArrayList<>();
	private static Wagon wagon = new Wagon(5);

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
       
        JButton SpeedChange = new JButton("Speed");
        SpeedChange.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
            }
        });
        SpeedChange.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 13));
        SpeedChange.setBounds(520, 412, 117, 29);
        frmOregonTrail.getContentPane().add(SpeedChange);
        
        JButton foodConsumptionIncrease = new JButton("Food Consumption Increase");
        foodConsumptionIncrease.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        
            }
        });
        foodConsumptionIncrease.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 13));
        foodConsumptionIncrease.setBounds(670, 412, 150, 29);
        frmOregonTrail.getContentPane().add(foodConsumptionIncrease);
      
        gameLoop();
    }

	private void openStore() {
		Store store = new Store(); // Instantiate the store
		Storepopup storePopup = new Storepopup(store, player); // Create the store popup window
		storePopup.setVisible(true); // Display the store popup window
	}
	
	

    private void gameLoop() {

		JPanel forPanel = new JPanel();
		forPanel.setOpaque(false);
		forPanel.setBounds(0, 0, 900, 600);
		frmOregonTrail.getContentPane().add(forPanel);

		JPanel midPanel = new JPanel();
		midPanel.setOpaque(false);
		midPanel.setBounds(0, 0, 900, 600);
		frmOregonTrail.getContentPane().add(midPanel);

		JPanel backPanel = new JPanel();
		backPanel.setOpaque(false);
		backPanel.setBounds(0, 0, 900, 600);
		frmOregonTrail.getContentPane().add(backPanel);


        Timer timer = new Timer(41, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

				if(traveling == true){
                miliSecondCound++;
                if (miliSecondCound >= 24) {
                    secondCount++;
                    miliSecondCound = 0;
					wagon.consumeFood();
					lblFood.setText("Pounds of Food: " + wagon.getFoodPounds());
                    allLabels.add(lblMake.randLabel("src/csv/images.csv"));
                    System.out.println("Words");
                }

                for (int i = 0; i < allLabels.size(); i++) {
                    if (allLabels.get(i).getName().equals("for")) {
                        allLabels.get(i).setLayout(null);
                        forPanel.add(allLabels.get(i));
                    }
                    if (allLabels.get(i).getName().equals("mid")) {
                        allLabels.get(i).setLayout(null);
                        midPanel.add(allLabels.get(i));
                    }
                    if (allLabels.get(i).getName().equals("bac")) {
                        allLabels.get(i).setLayout(null);
                        backPanel.add(allLabels.get(i));
                    }

                    if (allLabels.get(i).getX() > 900) {
                        allLabels.remove(i);
                    }
                }

                for (int i = 0; i < allLabels.size(); i++) {
                    if (allLabels.get(i).getName().equals("for")) {
                        allLabels.get(i).setBounds(allLabels.get(i).getX() + 5, allLabels.get(i).getY(), allLabels.get(i).getWidth(), allLabels.get(i).getHeight());
                    }
                    if (allLabels.get(i).getName().equals("mid")) {
                        allLabels.get(i).setBounds(allLabels.get(i).getX() + 3, allLabels.get(i).getY(), allLabels.get(i).getWidth(), allLabels.get(i).getHeight());
                    }
                    if (allLabels.get(i).getName().equals("bac")) {
                        allLabels.get(i).setBounds(allLabels.get(i).getX() + 1, allLabels.get(i).getY(), allLabels.get(i).getWidth(), allLabels.get(i).getHeight());
                    }

                    frmOregonTrail.repaint();

                }
            }
		}
	
        });

        timer.start(); // Start the timer
    }
}
