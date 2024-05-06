import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.Timer;


import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;

public class Main {

	private  JFrame frmOregonTrail;
	
	private static CSVReader csvRead = new CSVReader();

	private static LabelReader lblMake = new LabelReader();
	public static int miliSecondCound = 0;
	public static int secondCount = 0;


	
	private static List<JLabel> allLabels = new ArrayList<JLabel>();

	
	
	

	/**
	 * Launch the application.
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
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOregonTrail = new JFrame();
		frmOregonTrail.setTitle("Oregon Trail");
		frmOregonTrail.setBounds(100, 100, 900, 600);
		frmOregonTrail.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOregonTrail.getContentPane().setLayout(null);
		
		JLabel lblDays = new JLabel("Number of Days: ");
		lblDays.setBounds(29, 417, 179, 16);
		frmOregonTrail.getContentPane().add(lblDays);
		
		JLabel lblHealth = new JLabel("Party Health:  ");
		lblHealth.setBounds(29, 440, 179, 16);
		frmOregonTrail.getContentPane().add(lblHealth);
		
		JLabel lblFood = new JLabel("Pounds of Food:");
		lblFood.setBounds(29, 462, 179, 16);
		frmOregonTrail.getContentPane().add(lblFood);
		
		JButton btnState = new JButton("Start/ Stop");
		btnState.setBounds(220, 412, 117, 29);
		frmOregonTrail.getContentPane().add(btnState);
		
		JLabel lblStats = new JLabel("Stats:");
		lblStats.setBounds(51, 389, 61, 16);
		frmOregonTrail.getContentPane().add(lblStats);
		
		gameLoop();
		
	}
	
	private void gameLoop() {
		Timer timer = new Timer(41, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	
            	miliSecondCound = miliSecondCound + 1;
        		if(miliSecondCound >= 24) {
        			
        			secondCount++;
        			miliSecondCound = 0;					
        			allLabels.add(lblMake.randLabel("src/csv/images.csv"));
        			System.out.println("Words");
				}
            	
            	
            	
    			for(int i = 0; i < allLabels.size(); i++) {
        			if(allLabels.get(i).getName().equals("for")) {
						allLabels.get(i).setLayout(null);
						frmOregonTrail.add(allLabels.get(i));
        			}
        			if(allLabels.get(i).getName().equals("mid")) {
						allLabels.get(i).setLayout(null);
						frmOregonTrail.add(allLabels.get(i));
        			}
        			if(allLabels.get(i).getName().equals("bac")) {
						allLabels.get(i).setLayout(null);
						frmOregonTrail.add(allLabels.get(i));
        			} 

        			
        			if(allLabels.get(i).getX() > 900) {
        				allLabels.remove(i);
        			}
        		}
        		
        		
        		for(int i = 0; i < allLabels.size(); i++) {			
        			if(allLabels.get(i).getName().equals("for")) {
        				
        				allLabels.get(i).setBounds(allLabels.get(i).getX() + 5, allLabels.get(i).getY(), allLabels.get(i).getWidth(), allLabels.get(i).getHeight());
        				          			
        				}
        			if(allLabels.get(i).getName().equals("mid")) {
        				
        				allLabels.get(i).setBounds(allLabels.get(i).getX() + 3, allLabels.get(i).getY(), allLabels.get(i).getWidth(), allLabels.get(i).getHeight());
       			
        				}
        			if(allLabels.get(i).getName().equals("bac")) {
        				
        				allLabels.get(i).setBounds(allLabels.get(i).getX() + 1, allLabels.get(i).getY(), allLabels.get(i).getWidth(), allLabels.get(i).getHeight());
        			
        				}

        			frmOregonTrail.repaint();  
        			
        		}
            	
            }
		 });

        timer.start(); // Start the timer

		
		
	}
}
