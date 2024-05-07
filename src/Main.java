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
        // Initialize the store object
        this.store = new Store();
    }

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

        gameLoop();
    }

    private void openStore() {
        Storepopup storePopup = new Storepopup(store, player);
        storePopup.setVisible(true);
    }

    private void gameLoop() {

		JPanel forg = new JPanel();
		forg.setOpaque(false);
		forg.setBounds(0, 0, 900, 600);
		frmOregonTrail.getContentPane().add(forg);

		JPanel midg = new JPanel();
		midg.setOpaque(false);
		midg.setBounds(0, 0, 900, 600);
		frmOregonTrail.getContentPane().add(midg);

		JPanel backg = new JPanel();
		backg.setOpaque(false);
		backg.setBounds(0, 0, 900, 600);
		frmOregonTrail.getContentPane().add(backg);

        Timer timer = new Timer(41, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miliSecondCound++;
                if (miliSecondCound >= 24) {
                    secondCount++;
                    miliSecondCound = 0;
                    allLabels.add(lblMake.randLabel("src/csv/images.csv"));
                    System.out.println("Words");
                }

                for (int i = 0; i < allLabels.size(); i++) {
                    if (allLabels.get(i).getName().equals("for")) {
                        allLabels.get(i).setLayout(null);
                        forg.add(allLabels.get(i));
                    }
                    if (allLabels.get(i).getName().equals("mid")) {
                        allLabels.get(i).setLayout(null);
                        midg.add(allLabels.get(i));
                    }
                    if (allLabels.get(i).getName().equals("bac")) {
                        allLabels.get(i).setLayout(null);
                        backg.add(allLabels.get(i));
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
        });

        timer.start(); // Start the timer
    }
}
