import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PizzaOrderApp extends JFrame {

    private JLabel pizzaSizeLabel, pizzaTypeLabel, toppingsLabel;
    private JRadioButton smallRadioButton, mediumRadioButton, largeRadioButton;
    private JRadioButton cheeseRadioButton, pepperoniRadioButton, veggieRadioButton;
    private JCheckBox extraCheeseCheckBox, extraToppingsCheckBox;
    private JTextField addressTextField, phoneTextField;
    private JButton orderButton;

    public PizzaOrderApp() {
        setTitle("Pizza Order App");
        setLayout(new GridLayout(6, 2));

        // Pizza size selection
        pizzaSizeLabel = new JLabel("Pizza Size:");
        add(pizzaSizeLabel);

        JPanel sizePanel = new JPanel();
        sizePanel.setLayout(new GridLayout(3, 1));
        smallRadioButton = new JRadioButton("Small");
        mediumRadioButton = new JRadioButton("Medium");
        largeRadioButton = new JRadioButton("Large");

        ButtonGroup sizeButtonGroup = new ButtonGroup();
        sizeButtonGroup.add(smallRadioButton);
        sizeButtonGroup.add(mediumRadioButton);
        sizeButtonGroup.add(largeRadioButton);

        sizePanel.add(smallRadioButton);
        sizePanel.add(mediumRadioButton);
        sizePanel.add(largeRadioButton);

        add(sizePanel);

        // Pizza type selection
        pizzaTypeLabel = new JLabel("Pizza Type:");
        add(pizzaTypeLabel);

        JPanel typePanel = new JPanel();
        typePanel.setLayout(new GridLayout(3, 1));
        cheeseRadioButton = new JRadioButton("Cheese");
        pepperoniRadioButton = new JRadioButton("Pepperoni");
        veggieRadioButton = new JRadioButton("Veggie");

        ButtonGroup typeButtonGroup = new ButtonGroup();
        typeButtonGroup.add(cheeseRadioButton);
        typeButtonGroup.add(pepperoniRadioButton);
        typeButtonGroup.add(veggieRadioButton);

        typePanel.add(cheeseRadioButton);
        typePanel.add(pepperoniRadioButton);
        typePanel.add(veggieRadioButton);

        add(typePanel);

        // Toppings selection
        toppingsLabel = new JLabel("Toppings:");
        add(toppingsLabel);

        JPanel toppingsPanel = new JPanel();
        toppingsPanel.setLayout(new GridLayout(2, 1));
        extraCheeseCheckBox = new JCheckBox("Extra Cheese");
        extraToppingsCheckBox = new JCheckBox("Extra Toppings");

        toppingsPanel.add(extraCheeseCheckBox);
        toppingsPanel.add(extraToppingsCheckBox);

        add(toppingsPanel);

        // Customer address
        JLabel addressLabel = new JLabel("Delivery Address:");
        add(addressLabel);

        addressTextField = new JTextField(20);
        add(addressTextField);

        // Customer phone number
        JLabel phoneLabel = new JLabel("Phone Number:");
        add(phoneLabel);

        phoneTextField = new JTextField(20);
        add(phoneTextField);

        // Order button
        orderButton = new JButton("Order Pizza");
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ei) {
                System.out.println("Pizza Order Summary:");

                // Get selected pizza size
                String pizzaSize = "";
                if (smallRadioButton.isSelected()) {
                    pizzaSize = "Small";
                } else if (mediumRadioButton.isSelected()) {
                    pizzaSize = "Medium";
                } else if (largeRadioButton.isSelected()) {
                    pizzaSize = "Large";
                }

                // Get selected pizza type
                String pizzaType = "";
                if (cheeseRadioButton.isSelected()) {
                    pizzaType = "Cheese";
                } else if (pepperoniRadioButton.isSelected()) {
                    pizzaType = "Pepperoni";
                } else if (veggieRadioButton.isSelected()) {
                    pizzaType = "Veggie";
                }

                // Get selected toppings
                String toppings = "";
                if (extraCheeseCheckBox.isSelected()) {
                    toppings += "Extra Cheese";
                }

                if (extraToppingsCheckBox.isSelected()) {
                    if (toppings.length() > 0) {
                        toppings += ", ";
                    }
                    toppings += "Extra Toppings";
                }

                // Get customer address and phone number
                String address = addressTextField.getText();
                String phone = phoneTextField.getText();

                // Display order summary
                System.out.println("Pizza Size: " + pizzaSize);
                System.out.println("Pizza Type: " + pizzaType);
                System.out.println("Toppings: " + toppings);
                System.out.println("Delivery Address: " + address);
                System.out.println("Phone Number: " + phone);

                // Simulate order processing
                System.out.println("\nYour pizza is being prepared.");
                for (int i = 0; i < 3; i++) {
                    try {
                        Thread.sleep(1000);
                        System.out.print(".");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("\nYour pizza is ready for delivery!");

                // Reset input fields and radio buttons
                addressTextField.setText("");
                phoneTextField.setText("");

                smallRadioButton.setSelected(true);
                cheeseRadioButton.setSelected(true);
                extraCheeseCheckBox.setSelected(false);
                extraToppingsCheckBox.setSelected(false);
            }
        });

        add(orderButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new PizzaOrderApp();
    }
}
