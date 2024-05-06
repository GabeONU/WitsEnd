import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Storepopup extends JFrame {
    private Store store;
    private Person player;

    public Storepopup(Store store, Person player) {
        this.store = store;
        this.player = player;
        initialize();
    }

    private void initialize() {
        setTitle("Store");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel welcomeLabel = new JLabel("Hi, welcome to the store!");
        welcomeLabel.setBounds(220, 30, 200, 20);
        panel.add(welcomeLabel);

        int y = 60;
        for (int i = 0; i < store.getItems().size(); i++) {
            Item item = store.getItems().get(i);
            JLabel itemLabel = new JLabel(item.getName() + " - Price: $" + item.getPrice() + ", Weight: " + item.getWeight() + " lbs");
            itemLabel.setBounds(50, y, 400, 20);
            panel.add(itemLabel);

            JTextField quantityField = new JTextField("0");
            quantityField.setBounds(470, y, 50, 20);
            panel.add(quantityField);

            JButton buyButton = new JButton("Buy");
            buyButton.setBounds(530, y, 60, 20);
            int finalI = i; // Need to make a final copy for ActionListener
            buyButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int quantity = Integer.parseInt(quantityField.getText());
                    store.purchase(player, finalI, quantity);
                }
            });
            panel.add(buyButton);

            y += 30;
        }
    }
}
