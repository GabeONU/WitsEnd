/**
 * Description: Creates a popup window to show the player's inventory, allowing them to view their items and money.
 * Author: Julian Calvelage, Enzo Bordogna and Gabe Parry
 * Date: 5/9/2024
 */

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A popup window displaying the inventory of a player.
 */
public class Inventorypopup extends JFrame {

    /** The player whose inventory is displayed. */
    Person playerInven;

    /**
     * Constructs a new Inventorypopup.
     *
     * @param player the player whose inventory is to be displayed
     */
    public Inventorypopup(Person player) {
        playerInven = Main.player;
        initialize();
    }

    /** Initializes the inventory popup window. */
    private void initialize() {
        Main.traveling = false;
        playerInven = Main.player;

        setTitle("Store");
        setSize(500, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel moneyLabel = new JLabel("Money: $" + playerInven.getMoney());
        moneyLabel.setBounds(20, 30, 100, 20);
        panel.add(moneyLabel);

        for (int i = 0; i < playerInven.getInventory().size(); i++) {
            Item item = playerInven.getInventory().get(i);
            JLabel itemLabel = new JLabel(item.getName());
            itemLabel.setBounds(20, 60 + i * 30, 200, 20);
            panel.add(itemLabel);
        }

        JButton exit = new JButton("Exit");
        exit.setBounds(400, 520, 70, 20);
        exit.addActionListener(e -> {
            dispose();
            Main.traveling = true;
        });
        panel.add(exit);
    }
}
