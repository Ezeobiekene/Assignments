import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Product {

    String size;
    String name;
    String crustType;
    ArrayList<String> topping = new ArrayList<>();
    double price;
    int quantityy;
    String image;

    public static JPanel panel3_2 = new JPanel();

    public static int height;
    public static JFrame cartpage1 = new JFrame();

    public int getQuantityy() {
        return quantityy;
    }

    public void setQuantityy(int quantityy) {
        this.quantityy = quantityy;
    }

    public Product() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }


    public String getCrustType() {
        return crustType;
    }

    public void setCrustType(String crustType) {
        this.crustType = crustType;
    }

    public void setTopping(ArrayList<String> topping) {
        this.topping = topping;
    }


    public double getQuantPrice(){
        return quantityy*price;
    }


    public static void frame(){
        cartpage1.setLayout(null);
        cartpage1.setSize(350, 700);
        cartpage1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




        panel3_2.setPreferredSize(new Dimension(330,1000));
        panel3_2.setLayout(null);
        panel3_2.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(panel3_2);
        scrollPane.setBounds(0, 0, 350, 600);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        cartpage1.add(scrollPane);


        JPanel panel3_3 = new JPanel();
        panel3_3.setBounds(0,600,350, 100);
        panel3_3.setBackground(Color.WHITE);
        cartpage1.add(panel3_3);



        ImageIcon icon1 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/home_icon.png");
        JButton home = new JButton(icon1);
        home.setBounds(0, 630, 40, 40);
        home.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Ppd.menu();
                cartpage1.dispose();
            }
        });
        panel3_3.add(home);

        ImageIcon icon2 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/search_icon.png");
        JButton search = new JButton(icon2);
        search.setBounds(50, 630, 40, 40);
        search.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Ppd.search();
                cartpage1.dispose();
            }
        });
        panel3_3.add(search);

        ImageIcon icon3 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/cart_icon.png");
        JButton cart = new JButton(icon3);
        cart.setBounds(100, 630, 40, 40);
        cart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        panel3_3.add(cart);

        ImageIcon icon4 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/account_icon.png");
        JButton account = new JButton(icon4);
        account.setBounds(150, 630, 40, 40);
        account.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Ppd.account();
                cartpage1.dispose();
            }
        });

        panel3_3.add(account);
        cartpage1.setVisible(true);
    }

    public void display(){


        height = (Ppd.count*105)+15;

        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(null);
        displayPanel.setBackground(Color.decode("#EDEDED"));
        displayPanel.setBounds(2,height,326, 100);
        displayPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel3_2.add(displayPanel);

        int panelHeight = (height+125);
        panel3_2.setPreferredSize(new Dimension(330, panelHeight));

        ImageIcon diplayImage = new ImageIcon(image);
        JLabel imageDisplay = new JLabel(diplayImage);
        imageDisplay.setBounds(5,5,110,90);
        displayPanel.add(imageDisplay);

        JLabel displayName = new JLabel(getName());
        displayName.setBounds(120,5,275,25);
        displayName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        displayName.setForeground(Color.BLACK);
        displayPanel.add(displayName);

        JButton plusButton = new JButton("+");
        plusButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        plusButton.setBounds(120,70,20,25);
        plusButton.setBorder(BorderFactory.createEmptyBorder());
        plusButton.setBorderPainted(false);
        plusButton.setFocusPainted(false);
        plusButton.setForeground(Color.BLACK);
        displayPanel.add(plusButton);

        JButton minusButton = new JButton("Remove item");
        minusButton.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        minusButton.setBounds(240,70,70,25);
        minusButton.setBorder(BorderFactory.createEmptyBorder());
        minusButton.setBorderPainted(false);
        minusButton.setFocusPainted(false);
        minusButton.setForeground(Color.BLACK);
        displayPanel.add(minusButton);

        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(displayName.getParent() !=null){
                    //removes the label from the frame
                    //getContentPane().remove

                }


            }
        });


        //checkoutbutton but it is in the wrong place right now

        // label for the price, will get the price by the getPrice Method
        JLabel priceLabel = new JLabel(String.valueOf(getPrice()));
        //settings for the price label
        priceLabel.setFont(new Font("Times New Roman",Font.PLAIN,15));
        priceLabel.setBounds(280,5,70,25);
        priceLabel.setForeground(Color.BLACK);
        // will add the price label to the display panel
        displayPanel.add(priceLabel);

        //Checkout button
        JButton checkoutButton = new JButton("Checkout");
        // settings for the checkout button
        checkoutButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        checkoutButton.setBounds(5,5,100, 25);
        checkoutButton.setBackground(Color.RED);
        checkoutButton.setOpaque(true);
        checkoutButton.setBorder(BorderFactory.createEmptyBorder());
        checkoutButton.setForeground(Color.WHITE);
        checkoutButton.setBorderPainted(false);
        checkoutButton.setFocusPainted(false);


        displayPanel.add(checkoutButton);






        // method for the remove button that is still in progress

    }
}