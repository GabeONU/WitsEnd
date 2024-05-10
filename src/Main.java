/**
 * The Main class represents the main entry point of the Oregon Trail game application.
 * It initializes the game environment, GUI components, and controls the game loop.
 */


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.*;

public class Main {
// Variables for GUI components and game state
    private JFrame frmOregonTrail;
    private static CSVReader csvRead = new CSVReader();
    private static LabelReader lblMake = new LabelReader();
    public static int miliSecondCound = 0;
	public static int miliSecondCound2 = 0;
    public static int secondCount = 0;
	public static int secondCount2 = 0;
    private static List<JLabel> allLabels = new ArrayList<>();
	private static List<JLabel> allOxLabels = new ArrayList<>();
	private static Wagon wagon = new Wagon(5);
	private static boolean riverOnScreen = false;
	private static int riverTime = 0;
    public static int waggonTime = 0;
	private static int riverSpeed = 0;
	private static boolean riverCrossed = false;
	private static JLabel ox;	
	private static boolean fortOnScreen = false;
	private static int fortTime = 0;
	private static boolean skipTree = false;
    private static boolean waggonOnScreen = false;

	public static boolean traveling = true;

	private static MyLabel lblFood = new MyLabel("Pounds of Food:");
	private static MyLabel lblDays = new MyLabel("Number of Days: ");

	private static boolean eventHappened = false;

	private static boolean flag = false;

	private static int foodConsumeIndex = 1;
	private static int speedRateIndex = 1;

    private Store store;
    public static Person player = new Person();

	private static boolean oxDrawn = false;

	/**
     * The main method, the entry point of the program.
     * @param args Command-line arguments
     */
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
 /**
     * Creates a new instance of the Main class.
     */
    public Main() {
        initialize();
    }
/**
     * Initializes the GUI components and sets up the game environment.
     */
    private void initialize() {
        frmOregonTrail = new JFrame();
        frmOregonTrail.setTitle("Oregon Trail");
        frmOregonTrail.setBounds(100, 100, 900, 600);
        frmOregonTrail.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOregonTrail.setResizable(false);
        frmOregonTrail.getContentPane().setLayout(null);

        lblDays.setBounds(29, 417, 179, 16);
        frmOregonTrail.getContentPane().add(lblDays);

        MyLabel lblHealth = new MyLabel("Party Health:  100");
        lblHealth.setBounds(29, 440, 179, 16);
        frmOregonTrail.getContentPane().add(lblHealth);

        lblFood.setBounds(29, 462, 179, 16);
        frmOregonTrail.getContentPane().add(lblFood);

        JButton btnState = new JButton("Pause/ Resume");
		btnState.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				traveling = !traveling;
			}
		});
        btnState.setBounds(220, 412, 137, 29);
        frmOregonTrail.getContentPane().add(btnState);

		JButton btnMap = new JButton("Map");
		btnMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frmOregonTrail, "Go this way: <----", "Map", JOptionPane.INFORMATION_MESSAGE);
			}
		});
        btnMap.setBounds(220, 442, 137, 29);
        frmOregonTrail.getContentPane().add(btnMap);


		JButton btnInventory = new JButton("Check Inventory");
        btnInventory.setBounds(370, 412, 147, 29);
        frmOregonTrail.getContentPane().add(btnInventory);
        btnInventory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               openIventory();
            }
            
        });

		JButton btnMoneyMini = new JButton("Money MiniGame");
        btnMoneyMini.setBounds(370, 442, 147, 29);
        frmOregonTrail.getContentPane().add(btnMoneyMini);
        btnMoneyMini.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				traveling = false;
				Random rand = new Random();
				int correctResponse = rand.nextInt(4);
               int response = JOptionPane.showOptionDialog(frmOregonTrail, "You have found a money mini game! \n You can play to win money! \n Try to guess the number", "Money MiniGame", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"Four", "Three", "Two", "One"}, null);
			   if(response == correctResponse){
				   player.money = player.money + 100;
				   JOptionPane.showMessageDialog(frmOregonTrail, "You have won $100!");
			   }
			   traveling = true;

            }
            
        });

        JLabel lblStats = new JLabel("Stats:");
        lblStats.setBounds(51, 389, 61, 16);
        frmOregonTrail.getContentPane().add(lblStats);

		MyLabel SpeedRateDisplay = new MyLabel("Speed Rate: "/* + wag.getCurrentSpeedModifier()*/);
        SpeedRateDisplay.setBounds(520, 440, 170, 29);
        frmOregonTrail.getContentPane().add(SpeedRateDisplay);
       
        JButton SpeedIncrease = new JButton("Speed Increase");
        SpeedIncrease.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

				if(speedRateIndex < 3){
					speedRateIndex++;
					if(speedRateIndex == 1){
						SpeedRateDisplay.setText("Speed Rate: Normal");
					}
					if(speedRateIndex == 2){
						SpeedRateDisplay.setText("Speed Rate: Strenuous");
					}
					if(speedRateIndex == 3){
						SpeedRateDisplay.setText("Speed Rate: Grueling");
					}
				}
               
            }
        });
        SpeedIncrease.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 13));
        SpeedIncrease.setBounds(520, 412, 170, 29);
        frmOregonTrail.getContentPane().add(SpeedIncrease);

        JButton SpeedDecrease = new JButton("Speed Decrease");
        SpeedDecrease.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

				if(speedRateIndex > 0){
					speedRateIndex--;
					if(speedRateIndex == 1){
						SpeedRateDisplay.setText("Speed Rate: Normal");
					}
					if(speedRateIndex == 2){
						SpeedRateDisplay.setText("Speed Rate: Strenuous");
					}
					if(speedRateIndex == 3){
						SpeedRateDisplay.setText("Speed Rate: Grueling");
					}
				}
               
            }
        });
        
        SpeedDecrease.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 13));
        SpeedDecrease.setBounds(520, 470, 170, 29);
        frmOregonTrail.getContentPane().add(SpeedDecrease);
        
        JButton foodConsumptionIncrease = new JButton("Consumption Increase");
        foodConsumptionIncrease.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        
            }
        });

		MyLabel DisplayConsumtionRate = new MyLabel("ConsumtionRate: ");
        DisplayConsumtionRate.setBounds(715, 440, 170, 29);
        frmOregonTrail.getContentPane().add(DisplayConsumtionRate);

        
        foodConsumptionIncrease.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 13));
        foodConsumptionIncrease.setBounds(715, 412, 170, 29);
		foodConsumptionIncrease.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(foodConsumeIndex < 3){
					foodConsumeIndex++;
					if(foodConsumeIndex == 1){
						DisplayConsumtionRate.setText("ConsumtionRate: Bare Bones");
						wagon.setConsumptionRate(foodConsumeIndex); // Remove this line
					}
					if(foodConsumeIndex == 2){
						DisplayConsumtionRate.setText("ConsumtionRate: Meager");
						wagon.setConsumptionRate(foodConsumeIndex);
					}
					if(foodConsumeIndex == 3){
						DisplayConsumtionRate.setText("ConsumtionRate: Filling");
						wagon.setConsumptionRate(foodConsumeIndex);
					}
				}

        
            }

		});

        frmOregonTrail.getContentPane().add(foodConsumptionIncrease);
      
        JButton foodConsumptionDecrease = new JButton("Consumption Decrease");
        foodConsumptionDecrease.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

				if(foodConsumeIndex > 1){
					foodConsumeIndex--;
					if(foodConsumeIndex == 1){
						DisplayConsumtionRate.setText("ConsumtionRate: Bare Bones");
						wagon.setConsumptionRate(foodConsumeIndex);
					}
					if(foodConsumeIndex == 2){
						DisplayConsumtionRate.setText("ConsumtionRate: Meager");
						wagon.setConsumptionRate(foodConsumeIndex);
					}
					if(foodConsumeIndex == 3){
						DisplayConsumtionRate.setText("ConsumtionRate: Filling");
						wagon.setConsumptionRate(foodConsumeIndex);
					}
				}
			}

        });

        foodConsumptionDecrease.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 13));
        foodConsumptionDecrease.setBounds(715, 470, 170, 29);
        frmOregonTrail.getContentPane().add(foodConsumptionDecrease);


		startStore();

    }
/**
     * Opens the inventory interface to check the player's inventory.
     */
	private void openStore() {
		Store store = new Store(); // Instantiate the store
		Storepopup storePopup = new Storepopup(store, player); // Create the store popup window
		storePopup.setVisible(true); // Display the store popup window
	}

	private void openIventory() {
		Inventorypopup inventoryPopup = new Inventorypopup(player); // Create the inventory popup window
		inventoryPopup.setVisible(true); // Display the inventory popup window
	}
	/**
     * Starts the store where players can buy supplies.
     */
	private void startStore() {

		JLabel title = new JLabel("General Store");
		title.setFont(new Font("Arial", Font.PLAIN, 16));
		title.setBounds(370, 25, 130, 20);
		frmOregonTrail.add(title);


		JPanel store = new JPanel();
		store.setBackground(new Color(93, 226, 231));
		store.setOpaque(true);
		store.setBounds(300,50,250,300);
		store.setLayout(null);
		frmOregonTrail.add(store);

		JPanel gre = new JPanel();
		gre.setBackground(new Color(255, 255, 255));
		gre.setOpaque(true);
		gre.setBounds(290,20,270,340);
		frmOregonTrail.add(gre);

		
		JTextArea blerb = new JTextArea("You have $800 to spend at the store. \nYou can buy food and oxen. \nOther supplies can be bought at forts. \nYou can see the status of money and items in the inventory. \nGood luck!");
		blerb.setFont(new Font("Arial", Font.PLAIN, 13));
		blerb.setBounds(20, 50, 260, 200);
		blerb.setLineWrap(true); 
		blerb.setWrapStyleWord(true); 
		blerb.setEditable(false);
		frmOregonTrail.add(blerb);

		JLabel money = new JLabel("Money: $" + player.money);
		money.setFont(new Font("Arial", Font.PLAIN, 13));
		money.setBounds(20, 20, 100, 20);
		store.add(money);

		JLabel food = new JLabel("Food: " + wagon.getFoodPounds() + " lbs");
		food.setFont(new Font("Arial", Font.PLAIN, 13));
		food.setBounds(80, 50, 80, 30);
		store.add(food);

		JButton btnFoodIncrease = new JButton("+50 lbs");
		btnFoodIncrease.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(player.money >= 50){
					player.money = player.money - 50;
					wagon.addFood(50);
					money.setText("Money: $" + player.money);
					food.setText("Food: " + wagon.getFoodPounds() + " lbs");
				
			} else {
				JOptionPane.showMessageDialog(null, "You don't have enough money");	
			}
			 
			}
		});

		btnFoodIncrease.setFont(new Font("Arial", Font.PLAIN, 13));
		btnFoodIncrease.setBounds(6, 50, 80, 30);
		store.add(btnFoodIncrease);

		JButton btnFoodDecrease = new JButton("-50 lbs");
		btnFoodDecrease.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(wagon.getFoodPounds() > 0){
				player.money = player.money + 50;
				wagon.addFood(-50);
				money.setText("Money: $" + player.money);
				food.setText("Food: " + wagon.getFoodPounds() + " lbs");
				
				 
			}
			else {
				JOptionPane.showMessageDialog(null, "You can't have negative food");	
			}
			
			}
		});

		

		btnFoodDecrease.setFont(new Font("Arial", Font.PLAIN, 13));
		btnFoodDecrease.setBounds(150, 50, 80, 30);
		store.add(btnFoodDecrease);

		

		JCheckBox ox1 = new JCheckBox("+1 Oxen");
		ox1.addActionListener(e -> {

			if (ox1.isSelected()) {
				if(player.money >= 100){
				wagon.setOxNumber(1);
				player.money = player.money - 100;
				money.setText("Money: $" + player.money);
				} else {
					JOptionPane.showMessageDialog(null, "You don't have enough money");
					ox1.setSelected(false);

				}
			} else { 
				wagon.setOxNumber(-1);
				player.money = player.money + 100;
				money.setText("Money: $" + player.money);
			}
		});
		ox1.setBounds(6, 200, 90, 20);
		store.add(ox1);

		JCheckBox ox2 = new JCheckBox("+1 Oxen");
		ox2.addActionListener(e -> {
            		
			if (ox2.isSelected()) {
				if(player.money >= 100){
					wagon.setOxNumber(1);
					player.money = player.money - 100;
					money.setText("Money: $" + player.money);
					} else {
						JOptionPane.showMessageDialog(null, "You don't have enough money");
						ox2.setSelected(false);

					}
			} else { 
				wagon.setOxNumber(-1);
				player.money = player.money + 100;
				money.setText("Money: $" + player.money);
			}

		});
		ox2.setBounds(85, 200, 90, 20);
		store.add(ox2);

		JCheckBox ox3 = new JCheckBox("+1 Oxen");
		ox3.addActionListener(e -> {

			if (ox3.isSelected()) {
				if(player.money >= 100){
					wagon.setOxNumber(1);
					player.money = player.money - 100;
					money.setText("Money: $" + player.money);
					} else {
						JOptionPane.showMessageDialog(null, "You don't have enough money");
						ox3.setSelected(false);
					}
			} else { 
				wagon.setOxNumber(-1);
				player.money = player.money + 100;
				money.setText("Money: $" + player.money);
			}
		});
		ox3.setBounds(165, 200, 90, 20);
		store.add(ox3);

		JButton btnNewButton = new JButton("Start Journey");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmOregonTrail.remove(store);
				frmOregonTrail.remove(gre);
				frmOregonTrail.remove(blerb);
				frmOregonTrail.remove(title);
				frmOregonTrail.repaint();
				gameLoop();
			}
		});

		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 13));
		btnNewButton.setBounds(140, 270, 110, 30);
		store.add(btnNewButton);


		
    }

 /**
     * The main game loop controlling the game flow and events.
     */
    private void gameLoop() {

		JLabel waggon = new JLabel("Wagon");
		waggon = lblMake.makeLabel("src/imgs/Wagon.png", "bac", 64, 64);
		waggon.setBounds(400, 150, 64, 64);
		frmOregonTrail.getContentPane().add(waggon);

		JPanel oxPanel = new JPanel();
		oxPanel.setOpaque(false);
		oxPanel.setBounds(0, 0, 900, 600);
		frmOregonTrail.getContentPane().add(oxPanel);


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

				for(int i = 0; i < wagon.numberOfOx; i++){

			
					ox = lblMake.makeLabel("src/imgs/ox.png", "ox", 64, 64);
					ox.setBounds(350 - (i * 50), 150, 64, 64);
					allOxLabels.add(ox);
		
				}


				if(wagon.getFoodPounds() <= 0){
					traveling = false;
					JOptionPane.showMessageDialog(frmOregonTrail, "You have run out of food! Game Over!");
					System.exit(0);

				}

				if(wagon.numberOfOx <= 0){
					traveling = false;
					JOptionPane.showMessageDialog(frmOregonTrail, "You have run out of oxen! Game Over!");
					System.exit(0);
				}

				if(traveling == true){
                

				if(secondCount %7== 0 && eventHappened == false){
					Random rand = new Random();
					int randomEvent = rand.nextInt(4) + 1;
					if(randomEvent == 1){
						skipTree = true;
						allLabels.add(lblMake.makeLabel("src/imgs/river.png", "for", 800, 450));
						riverOnScreen = true;
						Random rand2 = new Random();
						riverSpeed = rand2.nextInt(10) + 1;
						
					}
					if(randomEvent == 2){
						skipTree = true;
						allLabels.add(lblMake.makeLabel("src/imgs/fort.png", "mid", 64, 64));
						fortOnScreen = true;
					}
					if(randomEvent == 3){
						JOptionPane.showMessageDialog(frmOregonTrail, "You got a minnor fever! \n But you recovered!");
					}
					eventHappened = true;

                    if(randomEvent == 4) {
                        skipTree = true;
                        allLabels.add(lblMake.makeLabel("src/imgs/wagon.png", "mid", 64, 64));
                        waggonOnScreen = true;
                    }
                }

                if(waggonOnScreen == true){
                    waggonTime++;
					if(waggonTime > 120){
						traveling = false;
						int response = JOptionPane.showOptionDialog(frmOregonTrail, "You have reached a broken wagon! ", "Wagon", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"Leave", "Talk"}, null);
						if(response == 0){
							JOptionPane.showMessageDialog(frmOregonTrail, "You have left the wagon!");
                                traveling = true;
								waggonTime = 0;
								waggonOnScreen = false;
						}
						if(response == 1){
							JOptionPane.showMessageDialog(frmOregonTrail, "You talk to a traveling woman. \n She says, make sure you talk to all the people at forts, they give great advice!");
							traveling = true;
                            waggonTime = 0;
							waggonOnScreen = false;
						}
					}
				}

				if(secondCount > 25 && flag == false){
					skipTree = true;
					allLabels.add(lblMake.makeLabel("src/imgs/flag.png", "for", 800, 450));
					flag = true;
				}

				if(riverOnScreen == true){
					riverTime++;
					if(riverTime > 70){
						traveling = false;
						int response = JOptionPane.showOptionDialog(frmOregonTrail, "You have reached a river! \n You must cross it to continue! \n The speed is " + riverSpeed + "mph", "River Crossing", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"Float", "Ford"}, null);
						if(response == 0){
							if(riverSpeed < 5){
								JOptionPane.showMessageDialog(frmOregonTrail, "You have successfully floated across the river!");
								riverCrossed = true;
							}
							else{
								JOptionPane.showMessageDialog(frmOregonTrail, "You have failed to float across the river! \n You have lost 1 oxen and 100 pounds of food!");
								wagon.setOxNumber(-1);
								wagon.addFood(-100);
							}
						}
						if(response == 1){
							if(riverSpeed > 5){
								JOptionPane.showMessageDialog(frmOregonTrail, "You have successfully forded across the river!");
								riverCrossed = true;
							}
							else{
								JOptionPane.showMessageDialog(frmOregonTrail, "You have failed to ford across the river! \n You have lost 1 oxen and 100 pounds of food!");
								wagon.setOxNumber(-1);
								wagon.addFood(-100);
							}
						}

						riverCrossed = true;
						riverOnScreen = false;
						riverTime = 0;
						traveling = true;
					}
					
				}

				if(fortOnScreen == true){
					fortTime++;
					if(fortTime > 90){
						traveling = false;
						int response = JOptionPane.showOptionDialog(frmOregonTrail, "You have reached a fort! \n You can buy supplies here!", "Fort", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"Buy", "Leave", "Talk"}, null);
						if(response == 0){
							openStore();
						}
						if(response == 1){
							JOptionPane.showMessageDialog(frmOregonTrail, "You have left the fort!");
							traveling = true;
						}
						if(response == 2){
							JOptionPane.showMessageDialog(frmOregonTrail, "You talk to a traveling Woman. \n She tells you that if a river is fast to ford and if its slow to float");
							traveling = true;
						}
						fortOnScreen = false;
						fortTime = 0;

					}

				}

				
				miliSecondCound2++;
				if (miliSecondCound2 >= 24 && speedRateIndex == 1){
				secondCount2++;
				miliSecondCound2 = 0;
				lblDays.setText("Number of Days: " + secondCount2);
				}
				if (miliSecondCound2 >= 8 && miliSecondCound2 <= 16 && speedRateIndex == 2){
				secondCount2++;
				miliSecondCound2 = 0;
				lblDays.setText("Number of Days: " + secondCount2);
			}
				if (miliSecondCound2 >= 7 && miliSecondCound2 <= 8 && speedRateIndex == 3){
				secondCount2++;
				miliSecondCound2 = 0;
				lblDays.setText("Number of Days: " + secondCount2);
			}

				miliSecondCound++;
				if(miliSecondCound>= 24){
					secondCount++;
					miliSecondCound = 0;
				
					wagon.consumeFood();
					lblFood.setText("Pounds of Food: " + wagon.getFoodPounds());

					
					if(skipTree != true){
                    allLabels.add(lblMake.randLabel("src/csv/images.csv"));
					} else {
						skipTree = false;
					}

					eventHappened = false;

                }



				if(secondCount > 30){
					traveling = false;
					JOptionPane.showMessageDialog(frmOregonTrail, "You have reached Oregon! \n Congratulations! You have won the game!");
					System.exit(0);


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

				for (JLabel ox : allOxLabels) {
					oxPanel.remove(ox);
				}

				allOxLabels.clear();

				for (int i = 0; i < wagon.numberOfOx; i++) {
					ox = lblMake.makeLabel("src/imgs/ox.png", "ox", 64, 64);
					ox.setBounds(350 - (i * 50), 150, 64, 64);
					oxPanel.add(ox);
					allOxLabels.add(ox);
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

		public static void setFoodConsumeIndex(int foodConsumeIndex) {
			Main.foodConsumeIndex = foodConsumeIndex;
		}
	} // Add this closing brace to complete the class body



