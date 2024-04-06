import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class pizzaDemo {
    public static void main(String[] args) {
        // GUI setup

        // creating the JFrame
        JFrame frame = new JFrame("Worcester Pizza Order");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);

        // set default font
        Font font = new Font("Verdana", Font.PLAIN, 30);

        //intropanel: contains intro label and continue button
        // continue button functionality: moves into panel2
        JPanel introPanel = new JPanel();
        introPanel.setLayout(new FlowLayout());
        JLabel welcomeLabel = new JLabel("Welcome to the best pizza in town!");
        JButton continueButton = new JButton("Place my order");
        // Setting font for introPanel components
        welcomeLabel.setFont(font);
        continueButton.setFont(font);
        // adding the elements to the intro panel
        introPanel.add(welcomeLabel);
        introPanel.add(continueButton);

        // panel2: contains combobox to choose number of toppings and checkboxes to choose specific toppings
        // contains two labels to provide instructions for checkboxes and choosing toppings
        JPanel panel2 = new JPanel();
        JLabel toppingsLabel = new JLabel("Please choose the amount of toppings you would like");
        panel2.setLayout(new FlowLayout()); // 3 rows, 1 column
        JComboBox<Integer> toppingsComboBox = new JComboBox<>();
        for (int i = 1; i <= 10; i++) {
            toppingsComboBox.addItem(i);
        }
        JLabel toppingschoice = new JLabel("Please choose your toppings");
        JCheckBox pepperoni = new JCheckBox("Pepperoni");
        JCheckBox pineapple = new JCheckBox("Pineapple");
        JCheckBox chicken = new JCheckBox("Chicken");
        JButton continuePanel2 = new JButton("Click here to continue");
        // Setting font for panel2 components
        toppingsLabel.setFont(font);
        toppingsComboBox.setFont(font);
        toppingschoice.setFont(font);
        pepperoni.setFont(font);
        pineapple.setFont(font);
        chicken.setFont(font);
        continuePanel2.setFont(font);
        //adding the elements to panel2
        panel2.add(toppingsLabel);
        panel2.add(toppingsComboBox);
        panel2.add(toppingschoice);
        panel2.add(pepperoni);
        panel2.add(pineapple);
        panel2.add(chicken);
        panel2.add(continuePanel2);


        //panel3: creating a JPanel to choose the place where the person will be eating
        //contains: label to choose place, two checkboxes for yes and no, textfield to enter the address, button to continue to the fourth panel,
        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout()); // 3 rows, 1 column
        JLabel eatLabel = new JLabel("WOULD YOU LIKE TO EAT AT HOME?");
        JCheckBox yes = new JCheckBox("YES");
        JCheckBox no = new JCheckBox("NO");
        JTextField address = new JTextField("ENTER YOUR ADDRESS");
        JButton continueButtonPanel3 = new JButton("Continue");
        // Setting font for panel3 components
        eatLabel.setFont(font);
        yes.setFont(font);
        no.setFont(font);
        address.setFont(font);
        continueButtonPanel3.setFont(font);
        // adding the elements to the panel
        panel3.add(eatLabel);
        panel3.add(yes);
        panel3.add(no);
        panel3.add(address);
        panel3.add(continueButtonPanel3);

        //panel4: Displays thank you message, details button that if clicked displays the user input from the toppings combobox,
        // from the 3 different toppings checkboxes, from the delivery checkbox and from the delivery address textfield
        JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayout(8, 1)); // 2 rows, 1 column
        JLabel thankYouLabel = new JLabel("Thank you for ordering! Here are the details of your order:");
        JButton detailsButton = new JButton("Details of my order");
        JLabel detailsLabel = new JLabel("");
        JLabel priceLabel = new JLabel("Your total is: ");
        // Setting font for panel4 components
        thankYouLabel.setFont(font);
        detailsButton.setFont(font);
        // adding the labels and buttons
        panel4.add(thankYouLabel);
        panel4.add(detailsButton);
        panel4.add(detailsLabel);
        panel4.add(priceLabel);

        // FUNCTIONALITY

        // continue button 1 to continue to panel2
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(panel2);
                frame.revalidate();
                frame.repaint();
            }
        });

        // for the order delivery button to continue to panel 3

        continuePanel2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(panel3);
                frame.revalidate();
                frame.repaint();
            }
        });

        // J button to continue to panel4

        continueButtonPanel3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(panel4);
                frame.revalidate();
                frame.repaint();
            }
        });

        // button to display details of the user's order if it is clicked

        detailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder details = new StringBuilder();

                // check each components state and update details accordingly

                int price = 15;
                if (toppingsComboBox.getSelectedIndex() != -1) {
                    int selectedNumber = (Integer) toppingsComboBox.getSelectedItem();
                    details.append("The amount of toppings we will place (No extra charge): ").append(selectedNumber).append("\n,") ;
                }

                if (pineapple.isSelected()) {
                    details.append("Topping: Pineapple\n,");
                    price += 3;
                }

                if (chicken.isSelected()) {
                    details.append("Topping: Chicken,\n");
                    price += 3;
                }

                if (pepperoni.isSelected()) {
                    details.append("Topping: Pepperoni,\n");
                    price += 3;
                }

                if (yes.isSelected()) {
                    details.append("Eat At Home,\n");
                    price += 3;
                }

                if (no.isSelected()) {
                    details.append("Eat At Restaurant,\n");
                }

                String userInput = address.getText();
                if (!userInput.isEmpty()) {
                    details.append("Deliver to: ").append(userInput).append(",\n");
                }

                detailsLabel.setText(details.toString());
                priceLabel.setText("Total Price: $" + price);
            }


        });

        frame.add(introPanel);
        frame.setVisible(true);

    }
}






