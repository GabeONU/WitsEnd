import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Inventorypopup extends JFrame {

    Person playerInven;

    public Inventorypopup(Person player) {

        playerInven = Main.player;
        initialize();
    }

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

        for(int i = 0; i < playerInven.getInventory().size(); i++) {
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
