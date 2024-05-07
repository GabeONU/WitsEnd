import javax.swing.*;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Storepopup extends JFrame {
    private Store store;
    private Person player = new Person();

    public Storepopup(Store store, Person player) {
        this.store = store;
        player = Main.player;
        initialize();
    }

    private void initialize() {

        player = Main.player;
        Main.traveling = false;


        setTitle("Yamhill County's Store");
        setSize(500, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel welcomeLabel = new JLabel("Hi, welcome to the store!");
        welcomeLabel.setBounds(220, 30, 200, 20);
        panel.add(welcomeLabel);

        JLabel moneyLabel = new JLabel("Money: $" + player.getMoney());
        moneyLabel.setBounds(20, 30, 100, 20);
        panel.add(moneyLabel);

        ArrayList<Item> items = store.getItems();
        for (int i = 0; i < items.size(); i++) {
            final int finalI = i;
            Item item = items.get(i);
            JLabel itemLabel = new JLabel(item.getName() + " - $" + item.getPrice());
            itemLabel.setBounds(20, 60 + i * 30, 200, 20);
            panel.add(itemLabel);

            JTextField quantityField = new JTextField("1");
            quantityField.setBounds(220, 60 + i * 30, 50, 20);
            panel.add(quantityField);

            JButton buyButton = new JButton("Buy");
            buyButton.setBounds(280, 60 + i * 30, 70, 20);
            buyButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int quantity = Integer.parseInt(quantityField.getText());
                    store.purchase(player, finalI, quantity);
                    moneyLabel.setText("Money: $" + player.getMoney());
                }
            });
            panel.add(buyButton);
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
