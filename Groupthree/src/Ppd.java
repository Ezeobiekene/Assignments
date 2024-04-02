import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;


public class Ppd {
    static String firstname1;
    static String lastname1;

    static  ArrayList<Product> cartList = new ArrayList<>();;
    public static int count = 0;

    public static void main(String[] args) {
        signUp();
    }

    public static void signUp(){

        JFrame signupPage = new JFrame();

        //****** Sign Up Page ******#####################################################################################################################
        JPanel panel2 = new JPanel();
        signupPage.setSize(350, 700);
        signupPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        signupPage.add(panel2);

        panel2.setLayout(null);

        JLabel sigupSign = new JLabel("Sign Up");
        sigupSign.setForeground(Color.red);
        sigupSign.setFont(new Font("Times New Roman", Font.BOLD, 24));
        sigupSign.setBounds(130, 70, 200, 30);
        panel2.add(sigupSign);

        JLabel firstName = new JLabel("First Name");
        firstName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        firstName.setForeground(Color.red);
        firstName.setBounds(10, 200, 300, 25);
        panel2.add(firstName);

        JTextField firstNameText = new JTextField(20);
        firstNameText.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        firstNameText.setBackground(Color.lightGray);
        firstNameText.setBounds(120, 200, 200, 25);
        panel2.add(firstNameText);

        JLabel lastName = new JLabel("Last Name");
        lastName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lastName.setForeground(Color.red);
        lastName.setBounds(10, 230, 300, 25);
        panel2.add(lastName);

        JTextField lastNameText = new JTextField(20);
        lastNameText.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lastNameText.setBackground(Color.lightGray);
        lastNameText.setBounds(120, 230, 200, 25);
        panel2.add(lastNameText);

        JLabel numberInput1 = new JLabel("Phone Number");
        numberInput1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        numberInput1.setForeground(Color.red);
        numberInput1.setBounds(10, 260, 300, 25);
        panel2.add(numberInput1);

        JTextField numberText1 = new JTextField(20);
        numberText1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        numberText1.setBackground(Color.lightGray);
        numberText1.setBounds(120, 260, 200, 25);
        panel2.add(numberText1);

        JLabel passwordInput1 = new JLabel("Password");
        passwordInput1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        passwordInput1.setForeground(Color.red);
        passwordInput1.setBounds(10, 290, 300, 25);
        panel2.add(passwordInput1);

        JTextField passwordText1 = new JPasswordField(20);
        passwordText1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        passwordText1.setBackground(Color.lightGray);
        passwordText1.setBounds(120, 290, 200, 25);
        panel2.add(passwordText1);

        JLabel passwordInput2 = new JLabel("Confirm");
        passwordInput2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        passwordInput2.setForeground(Color.red);
        passwordInput2.setBounds(10, 320, 300, 25);
        panel2.add(passwordInput2);

        JTextField passwordText2 = new JPasswordField(20);
        passwordText2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        passwordText2.setBackground(Color.lightGray);
        passwordText2.setBounds(120, 320, 200, 25);
        panel2.add(passwordText2);

        JButton signUp = new JButton("Sign Up");
        signUp.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        signUp.setBounds(120, 450, 80, 30);
        signUp.setForeground(Color.red);
        signUp.addActionListener(e -> {
            firstname1 = firstNameText.getText();
            lastname1 = lastNameText.getText();
            String password1 = passwordText1.getText();
            String phnumb = numberText1.getText();

            signupPage.dispose();

            log_in(phnumb, password1);
        });
        panel2.add(signUp);

        signupPage.setVisible(true);
    }

    public static void log_in(String phnumb, String password1) {
        //****** Login Page ******#####################################################################################################################

        JFrame loginPage = new JFrame();
        JPanel panel1 = new JPanel();

        loginPage.setSize(350, 700);
        loginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginPage.add(panel1);

        panel1.setLayout(null);

        JLabel loginsign = new JLabel("Login");
        loginsign.setForeground(Color.red);
        loginsign.setFont(new Font("Times New Roman", Font.BOLD, 24));
        loginsign.setBounds(140, 70, 80, 30);
        panel1.add(loginsign);

        JLabel numberInput = new JLabel("Phone Number");
        numberInput.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        numberInput.setForeground(Color.red);
        numberInput.setBounds(10, 200, 300, 30);
        panel1.add(numberInput);

        JTextField numberText = new JTextField(20);
        numberText.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        numberText.setBackground(Color.lightGray);
        numberText.setBounds(120, 200, 200, 30);
        panel1.add(numberText);

        JLabel passwordInput = new JLabel("Password");
        passwordInput.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        passwordInput.setForeground(Color.red);
        passwordInput.setBounds(10, 250, 300, 30);
        panel1.add(passwordInput);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBackground(Color.lightGray);
        passwordText.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        passwordText.setBounds(120, 250, 200, 30);
        panel1.add(passwordText);

        JLabel success = new JLabel("");
        success.setBounds(100, 350, 300, 25);
        panel1.add(success);

        JButton login = new JButton("Login");
        login.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        login.setBounds(120, 300, 80, 30);
        login.setForeground(Color.red);
        login.addActionListener(e -> {
            String number = numberText.getText();
            String password = passwordText.getText();


            if (number.equals(phnumb) && password.equals(password1)) {
                success.setText("Login Successful!");
                loginPage.dispose();
                menu();
            } else {
                success.setBounds(50, 350, 300, 25);
                success.setText("Phone number or Password incorrect");
            }
        });
        panel1.add(login);


        loginPage.setVisible(true);

    }

    public static void menu(){
        //****** Menu Page ******#####################################################################################################################
        JFrame menuPage = new JFrame();
        menuPage.setLayout(null);
        menuPage.setSize(350, 700);


        JPanel panel3_1 = new JPanel();
        panel3_1.setBounds(0,0,350, 50);
        panel3_1.setBackground(Color.WHITE);
        menuPage.add(panel3_1);


        JPanel panel3_2 = new JPanel();
        panel3_2.setPreferredSize(new Dimension(330, 820));
        panel3_2.setLayout(null);
        panel3_2.setBackground(Color.red);



        JPanel panel3_3 = new JPanel();
        panel3_3.setBounds(0,600,350, 100);
        panel3_3.setBackground(Color.WHITE);
        menuPage.add(panel3_3);

        JPanel panel3_4 = new JPanel();
        panel3_4.setBounds(0,700,350, 1);
        menuPage.add(panel3_4);



        menuPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton delivery = new JButton("Delivery");

        JButton pickup = new JButton("Pickup");
        pickup.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        pickup.setBounds(140, 10, 40, 20);
        panel3_1.add(pickup);
        pickup.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                pickup.setForeground(Color.red);
                delivery.setForeground(Color.black);
            }
        });

        delivery.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        delivery.setBounds(180, 10, 40, 20);
        delivery.setForeground(Color.red);
        panel3_1.add(delivery);
        delivery.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                delivery.setForeground(Color.red);
                pickup.setForeground(Color.black);
            }
        });



        ImageIcon pizza_1 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/pepPizza.jpeg");
        JButton pizza1 = new JButton(pizza_1);
        pizza1.setBounds(15, 10,150,100);
        pizza1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                menuPage.dispose();
                pepperoni();
            }
        });
        panel3_2.add(pizza1);

        JLabel pepPizza1 = new JLabel("Pepperoni Pizza");
        pepPizza1.setFont(new Font("Times New Roman", Font.BOLD, 10));
        pepPizza1.setBounds(15,110,150, 25);
        pepPizza1.setForeground(Color.WHITE);
        panel3_2.add(pepPizza1);

        ImageIcon pizza_2 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/philly_steak.jpeg");
        JButton pizza2 = new JButton(pizza_2);
        pizza2.setBounds(175, 10,150,100);
        pizza2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                menuPage.dispose();
                phillySteak();
            }
        });
        panel3_2.add(pizza2);

        JLabel philly = new JLabel("Philly Cheese Steak Pizza");
        philly.setFont(new Font("Times New Roman", Font.BOLD, 10));
        philly.setBounds(175,110,150, 25);
        philly.setForeground(Color.WHITE);
        panel3_2.add(philly);

        ImageIcon pizza_3 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/Buffalo.jpeg");
        JButton pizza3 = new JButton(pizza_3);
        pizza3.setBounds(15, 145,150,100);
        pizza3.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                menuPage.dispose();
                buffalo();
            }
        });
        panel3_2.add(pizza3);

        JLabel buffaloPizza = new JLabel("Buffalo Chicken Pizza");
        buffaloPizza.setFont(new Font("Times New Roman", Font.BOLD, 10));
        buffaloPizza.setBounds(15,245,150, 25);
        buffaloPizza.setForeground(Color.WHITE);
        panel3_2.add(buffaloPizza);

        ImageIcon pizza_4 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/spinach&feta.jpeg");
        JButton pizza4 = new JButton(pizza_4);
        pizza4.setBounds(175, 145,150,100);
        pizza4.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                menuPage.dispose();
                spinachFeta();
            }
        });
        panel3_2.add(pizza4);


        JLabel sfPizza = new JLabel("Spinach & Feta Pizza");
        sfPizza.setFont(new Font("Times New Roman", Font.BOLD, 10));
        sfPizza.setBounds(175,245,150, 25);
        sfPizza.setForeground(Color.WHITE);
        panel3_2.add(sfPizza);

        ImageIcon cheesePizza = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/cheesyPizza.jpg");
        JButton pizza5 = new JButton(cheesePizza);
        pizza5.setBounds(15, 280,150,100);
        pizza5.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                menuPage.dispose();
                cheesePizza();
            }
        });
        panel3_2.add(pizza5);

        JLabel chPizza = new JLabel("Cheese Pizza");
        chPizza.setFont(new Font("Times New Roman", Font.BOLD, 10));
        chPizza.setBounds(15,380,150, 25);
        chPizza.setForeground(Color.WHITE);
        panel3_2.add(chPizza);


        ImageIcon garlicBeard = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/garlicbread.jpeg");
        JButton bread1 = new JButton(garlicBeard);
        bread1.setBounds(175, 280,150,100);
        bread1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                menuPage.dispose();
                garlicBread();
            }
        });
        panel3_2.add(bread1);

        JLabel gBread = new JLabel("Garlic Bread");
        gBread.setFont(new Font("Times New Roman", Font.BOLD, 10));
        gBread.setBounds(175,380,150, 25);
        gBread.setForeground(Color.WHITE);
        panel3_2.add(gBread);

        ImageIcon cheeseBread = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/cheesyBeard.jpeg");
        JButton bread2 = new JButton(cheeseBread);
        bread2.setBounds(15, 415,150,100);
        bread2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                menuPage.dispose();
                cheesyBread();
            }
        });
        panel3_2.add(bread2);

        JLabel chBread = new JLabel("Cheese Stuffed Bread");
        chBread.setFont(new Font("Times New Roman", Font.BOLD, 10));
        chBread.setBounds(15,515,150, 25);
        chBread.setForeground(Color.WHITE);
        panel3_2.add(chBread);

        ImageIcon fanta = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/fanta.jpeg");
        JButton beverage1 = new JButton(fanta);
        beverage1.setBounds(175, 415,150,100);
        beverage1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                menuPage.dispose();
                fanta();
            }
        });
        panel3_2.add(beverage1);

        JLabel fantaa = new JLabel("Fanta");
        fantaa.setFont(new Font("Times New Roman", Font.BOLD, 10));
        fantaa.setBounds(175,515,150, 25);
        fantaa.setForeground(Color.WHITE);
        panel3_2.add(fantaa);

        ImageIcon lemonade = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/lemonade.jpeg");
        JButton beverage2 = new JButton(lemonade);
        beverage2.setBounds(15, 550,150,100);
        beverage2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                menuPage.dispose();
                lemonade();
            }
        });
        panel3_2.add(beverage2);

        JLabel lemon = new JLabel("Lemonade");
        lemon.setFont(new Font("Times New Roman", Font.BOLD, 10));
        lemon.setBounds(15,650,150, 25);
        lemon.setForeground(Color.WHITE);
        panel3_2.add(lemon);

        ImageIcon coke = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/coca-cola.jpeg");
        JButton beverage3 = new JButton(coke);
        beverage3.setBounds(175, 550,150,100);
        beverage3.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                menuPage.dispose();
                coke();
            }
        });
        panel3_2.add(beverage3);

        JLabel cokee = new JLabel("Coca-Cola");
        cokee.setFont(new Font("Times New Roman", Font.BOLD, 10));
        cokee.setBounds(175,650,150, 25);
        cokee.setForeground(Color.WHITE);
        panel3_2.add(cokee);

        ImageIcon sprite = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/sprite.jpeg");
        JButton beverage4 = new JButton(sprite);
        beverage4.setBounds(15, 685,150,100);
        beverage4.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                menuPage.dispose();
                sprite();
            }
        });
        panel3_2.add(beverage4);

        JLabel spritee = new JLabel("Sprite");
        spritee.setFont(new Font("Times New Roman", Font.BOLD, 10));
        spritee.setBounds(15,785,150, 25);
        spritee.setForeground(Color.WHITE);
        panel3_2.add(spritee);


        ImageIcon water = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/water.jpeg");
        JButton beverage5 = new JButton(water);
        beverage5.setBounds(175, 685,150,100);
        beverage5.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                menuPage.dispose();
                water();
            }
        });
        panel3_2.add(beverage5);

        JLabel waterr = new JLabel("Water");
        waterr.setFont(new Font("Times New Roman", Font.BOLD, 10));
        waterr.setBounds(175,785,150, 25);
        waterr.setForeground(Color.WHITE);
        panel3_2.add(waterr);


        JScrollPane scrollPane = new JScrollPane(panel3_2);
        scrollPane.setBounds(0, 50, 350, 550);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        menuPage.add(scrollPane);
        menuPage.add(panel3_3);


        ImageIcon icon1 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/home_icon.png");
        JButton home = new JButton(icon1);
        home.setBounds(0, 630, 40, 40);
        home.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                menu();
                menuPage.dispose();
            }
        });
        panel3_3.add(home);

        ImageIcon icon2 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/search_icon.png");
        JButton search = new JButton(icon2);
        search.setBounds(50, 630, 40, 40);
        search.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                search();
                menuPage.dispose();
            }
        });
        panel3_3.add(search);

        ImageIcon icon3 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/cart_icon.png");
        JButton cart = new JButton(icon3);
        cart.setBounds(100, 630, 40, 40);
        cart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cart();
                menuPage.dispose();
            }
        });
        panel3_3.add(cart);

        ImageIcon icon4 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/account_icon.png");
        JButton account = new JButton(icon4);
        account.setBounds(150, 630, 40, 40);
        account.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                account();
                menuPage.dispose();
            }
        });
        panel3_3.add(account);

        menuPage.setVisible(true);
    }

    public static void search(){
        //****** Search Page ******#####################################################################################################################

        JFrame searchpage = new JFrame();
        searchpage.setLayout(null);
        JPanel panel1 = new JPanel();

        searchpage.setSize(350, 700);
        searchpage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        searchpage.add(panel1);

        panel1.setLayout(null);

        JPanel panel3_1 = new JPanel();
        panel3_1.setBounds(0,0,350, 50);
        panel3_1.setBackground(Color.WHITE);
        searchpage.add(panel3_1);


        JPanel panel3_2 = new JPanel();
        panel3_2.setBounds(0,50,350, 549);
        panel3_2.setBackground(Color.WHITE);
        panel3_2.setLayout(null);
        searchpage.add(panel3_2);

        JPanel panel3_3 = new JPanel();
        panel3_3.setBounds(0,600,350, 100);
        panel3_3.setBackground(Color.WHITE);
        searchpage.add(panel3_3);

        ImageIcon icon1 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/home_icon.png");
        JButton home = new JButton(icon1);
        home.setBounds(0, 630, 40, 40);
        home.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                menu();
                searchpage.dispose();
            }
        });
        panel3_3.add(home);

        ImageIcon icon2 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/search_icon.png");
        JButton search = new JButton(icon2);
        search.setBounds(50, 630, 40, 40);
        search.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                search();
                searchpage.dispose();
            }
        });
        panel3_3.add(search);

        ImageIcon icon3 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/cart_icon.png");
        JButton cart = new JButton(icon3);
        cart.setBounds(100, 630, 40, 40);
        cart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cart();
                searchpage.dispose();
            }
        });
        panel3_3.add(cart);

        ImageIcon icon4 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/account_icon.png");
        JButton account = new JButton(icon4);
        account.setBounds(150, 630, 40, 40);
        account.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                account();
                searchpage.dispose();
            }
        });
        panel3_3.add(account);
        searchpage.setVisible(true);
    }

    public static void cart(){

        //****** Cart Page ******#####################################################################################################################

        JFrame cartpage = new JFrame();
        cartpage.setLayout(null);
        JPanel panel1 = new JPanel();

        cartpage.setSize(350, 700);
        cartpage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cartpage.add(panel1);

        panel1.setLayout(null);

        JPanel panel3_1 = new JPanel();
        panel3_1.setBounds(0,0,350, 50);
        panel3_1.setBackground(Color.WHITE);
        cartpage.add(panel3_1);


        JPanel panel3_2 = new JPanel();
        panel3_2.setBounds(0,50,350, 549);
        panel3_2.setBackground(Color.WHITE);
        cartpage.add(panel3_2);

        JPanel panel3_3 = new JPanel();
        panel3_3.setBounds(0,600,350, 100);
        panel3_3.setBackground(Color.WHITE);
        cartpage.add(panel3_3);

        ImageIcon icon1 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/home_icon.png");
        JButton home = new JButton(icon1);
        home.setBounds(0, 630, 40, 40);
        home.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                menu();
                cartpage.dispose();
            }
        });
        panel3_3.add(home);

        ImageIcon icon2 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/search_icon.png");
        JButton search = new JButton(icon2);
        search.setBounds(50, 630, 40, 40);
        search.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                search();
                cartpage.dispose();
            }
        });
        panel3_3.add(search);

        ImageIcon icon3 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/cart_icon.png");
        JButton cart = new JButton(icon3);
        cart.setBounds(100, 630, 40, 40);
        cart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cart();
            }
        });
        panel3_3.add(cart);

        ImageIcon icon4 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/account_icon.png");
        JButton account = new JButton(icon4);
        account.setBounds(150, 630, 40, 40);
        account.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                account();
                cartpage.dispose();
            }
        });
        panel3_3.add(account);



        cartpage.setVisible(true);

        if (cartList.isEmpty()){
            JLabel emptyCart = new JLabel("Cart is Empty");
            emptyCart.setBounds(125,200,350,30);
            emptyCart.setForeground(Color.lightGray);
            panel3_2.add(emptyCart);

        }else {

            cartpage.dispose();

            Product.frame();

            for(Product p : cartList){
                p.display();
                count++;
            }

        }
        count=0;


    }
    public static void checkoutPage(){


        //****** Cart Page ******#####################################################################################################################

        JFrame checkoutPage = new JFrame();
        checkoutPage.setLayout(null);
        JPanel panel1 = new JPanel();

        checkoutPage.setSize(350, 700);
        checkoutPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        checkoutPage.add(panel1);

        panel1.setLayout(null);

        JPanel panel3_1 = new JPanel();
        panel3_1.setBounds(0,0,350, 50);
        panel3_1.setBackground(Color.WHITE);
        checkoutPage.add(panel3_1);


        JPanel panel3_2 = new JPanel();
        panel3_2.setBounds(0,50,350, 549);
        panel3_2.setBackground(Color.WHITE);
        checkoutPage.add(panel3_2);

        JPanel panel3_3 = new JPanel();
        panel3_3.setBounds(0,600,350, 100);
        panel3_3.setBackground(Color.WHITE);
        checkoutPage.add(panel3_3);

        ImageIcon icon1 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/home_icon.png");
        JButton home = new JButton(icon1);
        home.setBounds(0, 630, 40, 40);
        home.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                menu();
                checkoutPage.dispose();
            }
        });
        panel3_3.add(home);

        ImageIcon icon2 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/search_icon.png");
        JButton search = new JButton(icon2);
        search.setBounds(50, 630, 40, 40);
        search.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                search();
                checkoutPage.dispose();
            }
        });
        panel3_3.add(search);

        ImageIcon icon3 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/cart_icon.png");
        JButton cart = new JButton(icon3);
        cart.setBounds(100, 630, 40, 40);
        cart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cart();
            }
        });
        panel3_3.add(cart);

        ImageIcon icon4 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/account_icon.png");
        JButton account = new JButton(icon4);
        account.setBounds(150, 630, 40, 40);
        account.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                account();
                checkoutPage.dispose();
            }
        });
        panel3_3.add(account);



        checkoutPage.setVisible(true);





    }

    public static void account(){
        //****** Account Page ******#####################################################################################################################

        JFrame accountPage = new JFrame();
        accountPage.setLayout(null);
        JPanel panel1 = new JPanel();

        accountPage.setSize(350, 700);
        accountPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        accountPage.add(panel1);

        panel1.setLayout(null);


        JPanel panel3_2 = new JPanel();
        panel3_2.setBounds(0,0,350, 599);
        panel3_2.setBackground(Color.WHITE);
        panel3_2.setLayout(null);
        accountPage.add(panel3_2);

        JPanel panel3_3 = new JPanel();
        panel3_3.setBounds(0,600,350, 100);
        panel3_3.setBackground(Color.WHITE);
        accountPage.add(panel3_3);

        ImageIcon icon1 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/home_icon.png");
        JButton home = new JButton(icon1);
        home.setBounds(0, 630, 40, 40);
        home.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                menu();
                accountPage.dispose();
            }
        });
        panel3_3.add(home);

        ImageIcon icon2 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/search_icon.png");
        JButton search = new JButton(icon2);
        search.setBounds(50, 630, 40, 40);
        search.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                search();
                accountPage.dispose();
            }
        });
        panel3_3.add(search);

        ImageIcon icon3 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/cart_icon.png");
        JButton cart = new JButton(icon3);
        cart.setBounds(100, 630, 40, 40);
        cart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cart();
                accountPage.dispose();
            }
        });
        panel3_3.add(cart);

        ImageIcon icon4 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/account_icon.png");
        JButton account = new JButton(icon4);
        account.setBounds(150, 630, 40, 40);
        account.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                account();
            }
        });
        panel3_3.add(account);

        ImageIcon profile_icon = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/profile_icon.png");
        JLabel profile = new JLabel(profile_icon);
        profile.setBounds(130, 50, 100, 100);
        panel3_2.add(profile);

        JLabel name = new JLabel(firstname1 + " "+lastname1);
        name.setBounds(120,150,350,30);
        name.setFont(new Font("Times New Roman", Font.BOLD, 15));
        panel3_2.add(name);

        JLabel email = new JLabel(firstname1 +lastname1+"@gmail.com");
        email.setBounds(120,165,350,30);
        email.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        panel3_2.add(email);

        JLabel edit = new JLabel("Edit Profile");
        edit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        edit.setForeground(Color.red);
        edit.setBounds(10, 200, 300, 25);
        panel3_2.add(edit);

        JButton editb = new JButton(">");
        editb.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        editb.setForeground(Color.red);
        editb.setBounds(300, 200, 15, 15);
        panel3_2.add(editb);


        JLabel paymentMethods = new JLabel("Payment Methods");
        paymentMethods.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        paymentMethods.setForeground(Color.red);
        paymentMethods.setBounds(10, 230, 300, 25);
        panel3_2.add(paymentMethods);

        JButton a = new JButton(">");
        a.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        a.setForeground(Color.red);
        a.setBounds(300, 230, 15, 15);
        panel3_2.add(a);

        JLabel orderHistory = new JLabel("Order History");
        orderHistory.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        orderHistory.setForeground(Color.red);
        orderHistory.setBounds(10, 260, 300, 25);
        panel3_2.add(orderHistory);

        JButton b = new JButton(">");
        b.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        b.setForeground(Color.red);
        b.setBounds(300, 260, 15, 15);
        panel3_2.add(b);

        JLabel ps = new JLabel("Privacy & Settings");
        ps.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        ps.setForeground(Color.red);
        ps.setBounds(10, 290, 300, 15);
        panel3_2.add(ps);

        JButton c = new JButton(">");
        c.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        c.setForeground(Color.red);
        c.setBounds(300, 290, 15, 15);
        panel3_2.add(c);

        JLabel signOut = new JLabel("Sign out");
        signOut.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        signOut.setForeground(Color.red);
        signOut.setBounds(10, 320, 300, 25);
        panel3_2.add(signOut);

        JButton d = new JButton(">");
        d.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        d.setForeground(Color.red);
        d.setBounds(300, 320, 15, 15);
        panel3_2.add(d);

        JLabel deleteAcount = new JLabel("Delete Acount");
        deleteAcount.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        deleteAcount.setForeground(Color.red);
        deleteAcount.setBounds(10, 350, 300, 25);
        panel3_2.add(deleteAcount);

        JButton e = new JButton(">");
        e.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        e.setForeground(Color.red);
        e.setBounds(300, 350, 15, 15);
        panel3_2.add(e);

        accountPage.setVisible(true);


    }

    public static void pepperoni(){
        //****** Pepperoni Page ******#####################################################################################################################
        JFrame pepperoniPage = new JFrame();
        pepperoniPage.setLayout(null);
        JPanel panel1 = new JPanel();

        pepperoniPage.setSize(350, 700);
        pepperoniPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pepperoniPage.add(panel1);

        panel1.setLayout(null);


        JPanel panel3_2 = new JPanel();
        panel3_2.setBounds(0,0,350, 599);
        panel3_2.setBackground(Color.WHITE);
        panel3_2.setLayout(null);
        pepperoniPage.add(panel3_2);

        JPanel panel3_3 = new JPanel();
        panel3_3.setBounds(0,600,350, 100);
        panel3_3.setBackground(Color.WHITE);
        pepperoniPage.add(panel3_3);

        ImageIcon icon1 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/home_icon.png");
        JButton home = new JButton(icon1);
        home.setBounds(0, 630, 40, 40);
        home.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                menu();
                pepperoniPage.dispose();
            }
        });
        panel3_3.add(home);

        ImageIcon icon2 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/search_icon.png");
        JButton search = new JButton(icon2);
        search.setBounds(50, 630, 40, 40);
        search.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                search();
                pepperoniPage.dispose();
            }
        });
        panel3_3.add(search);

        ImageIcon icon3 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/cart_icon.png");
        JButton cart = new JButton(icon3);
        cart.setBounds(100, 630, 40, 40);
        cart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cart();
            }
        });
        panel3_3.add(cart);

        ImageIcon icon4 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/account_icon.png");
        JButton account = new JButton(icon4);
        account.setBounds(150, 630, 40, 40);
        account.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                account();
                pepperoniPage.dispose();
            }
        });
        panel3_3.add(account);

        ImageIcon food_icon = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/pepPizzacopy.jpeg");
        JLabel food = new JLabel(food_icon);
        food.setBounds(0, 0, 350, 150);
        panel3_2.add(food);

        JPanel selectionPanel = new JPanel();
        selectionPanel.setPreferredSize(new Dimension(330, 800));
        selectionPanel.setLayout(null);
        selectionPanel.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(selectionPanel);
        scrollPane.setBounds(0, 150, 350, 550);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        panel3_2.add(scrollPane);

        pepperoniPage.add(panel3_3);


        Product menu1 = new Product();
        menu1.setName("Pepperoni Pizza");

        JLabel size = new JLabel("Size");
        size.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        size.setBounds(10,50,80, 25);
        size.setForeground(Color.RED);
        selectionPanel.add(size);


        JButton size4 = new JButton("x-Large");
        JButton size3 = new JButton("Large");
        JButton size2 = new JButton("Medium");
        JButton size1 = new JButton("Small");
        size1.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        size1.setBounds(100,50,50, 25);
        size1.setBackground(Color.RED);
        size1.setOpaque(true);
        size1.setBorder(BorderFactory.createEmptyBorder());
        size1.setForeground(Color.WHITE);
        size1.setFocusPainted(false);
        size1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu1.setSize("small");

                size1.setForeground(Color.RED);
                size1.setBackground(Color.WHITE);
                size1.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                size2.setForeground(Color.WHITE);
                size2.setBackground(Color.RED);
                size2.setBorder(BorderFactory.createEmptyBorder());

                size3.setForeground(Color.WHITE);
                size3.setBackground(Color.RED);
                size3.setBorder(BorderFactory.createEmptyBorder());

                size4.setForeground(Color.WHITE);
                size4.setBackground(Color.RED);
                size4.setBorder(BorderFactory.createEmptyBorder());

            }
        });
        selectionPanel.add(size1);

        size2.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        size2.setBounds(151,50,50, 25);
        size2.setBackground(Color.WHITE);
        size2.setOpaque(true);
        size2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        size2.setForeground(Color.RED);
        size2.setFocusPainted(false);
        menu1.setSize("medium");
        size2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu1.setSize("medium");

                size1.setForeground(Color.WHITE);
                size1.setBackground(Color.RED);
                size1.setBorder(BorderFactory.createEmptyBorder());

                size2.setForeground(Color.RED);
                size2.setBackground(Color.WHITE);
                size2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                size3.setForeground(Color.WHITE);
                size3.setBackground(Color.RED);
                size3.setBorder(BorderFactory.createEmptyBorder());

                size4.setForeground(Color.WHITE);
                size4.setBackground(Color.RED);
                size4.setBorder(BorderFactory.createEmptyBorder());
            }
        });
        selectionPanel.add(size2);

        size3.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        size3.setBounds(202,50,50, 25);
        size3.setBackground(Color.RED);
        size3.setOpaque(true);
        size3.setBorder(BorderFactory.createEmptyBorder());
        size3.setForeground(Color.WHITE);
        size3.setFocusPainted(false);
        size3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu1.setSize("large");

                size1.setForeground(Color.WHITE);
                size1.setBackground(Color.RED);
                size1.setBorder(BorderFactory.createEmptyBorder());

                size2.setForeground(Color.WHITE);
                size2.setBackground(Color.RED);
                size2.setBorder(BorderFactory.createEmptyBorder());

                size3.setForeground(Color.RED);
                size3.setBackground(Color.WHITE);
                size3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                size4.setForeground(Color.WHITE);
                size4.setBackground(Color.RED);
                size4.setBorder(BorderFactory.createEmptyBorder());

            }
        });
        selectionPanel.add(size3);

        size4.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        size4.setBounds(253,50,50, 25);
        size4.setBackground(Color.RED);
        size4.setOpaque(true);
        size4.setBorder(BorderFactory.createEmptyBorder());
        size4.setForeground(Color.WHITE);
        size4.setFocusPainted(false);
        size4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu1.setSize("extra large");

                size1.setForeground(Color.WHITE);
                size1.setBackground(Color.RED);
                size1.setBorder(BorderFactory.createEmptyBorder());

                size2.setForeground(Color.WHITE);
                size2.setBackground(Color.RED);
                size2.setBorder(BorderFactory.createEmptyBorder());

                size3.setForeground(Color.WHITE);
                size3.setBackground(Color.RED);
                size3.setBorder(BorderFactory.createEmptyBorder());

                size4.setForeground(Color.RED);
                size4.setBackground(Color.WHITE);
                size4.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            }
        });
        selectionPanel.add(size4);

        JLabel chicken =new JLabel("Chicken");
        chicken.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        chicken.setBounds(10,100,80, 25);
        chicken.setForeground(Color.RED);
        selectionPanel.add(chicken);


        JButton chicken3 = new JButton("✓");

        JButton chicken2 = new JButton("✗");
        chicken2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        chicken2.setBounds(151,100,50, 25);
        chicken2.setOpaque(true);
        chicken2.setBorder(BorderFactory.createEmptyBorder());
        chicken2.setFocusPainted(false);
        chicken2.setBackground(Color.WHITE);
        chicken2.setForeground(Color.RED);
        chicken2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        chicken2.addActionListener(new ActionListener() {

                                       @Override
                                       public void actionPerformed(ActionEvent e) {

                                           if(menu1.topping.contains("chicken")){
                                               menu1.topping.remove("chicken");
                                           }

                                           chicken2.setBackground(Color.WHITE);
                                           chicken2.setForeground(Color.RED);
                                           chicken2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                           chicken3.setBackground(Color.RED);
                                           chicken3.setForeground(Color.WHITE);
                                           chicken3.setBorder(BorderFactory.createEmptyBorder());

                                       }
                                   }
        );
        selectionPanel.add(chicken2);

        chicken3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        chicken3.setBounds(202,100,50, 25);
        chicken3.setBackground(Color.RED);
        chicken3.setOpaque(true);
        chicken3.setBorder(BorderFactory.createEmptyBorder());
        chicken3.setForeground(Color.WHITE);
        chicken3.setFocusPainted(false);
        chicken3.addActionListener(new ActionListener() {

                                       @Override
                                       public void actionPerformed(ActionEvent e) {

                                           //if (menutopping.get(4) == null){
                                           menu1.topping.add("chicken");

                                           chicken3.setBackground(Color.WHITE);
                                           chicken3.setForeground(Color.RED);
                                           chicken3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                           chicken2.setBackground(Color.RED);
                                           chicken2.setForeground(Color.WHITE);
                                           chicken2.setBorder(BorderFactory.createEmptyBorder());
                                           //}
                                       }
                                   }
        );
        selectionPanel.add(chicken3);


        JLabel bacon =new JLabel("Bacon");
        bacon.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        bacon.setBounds(10,150,80, 25);
        bacon.setForeground(Color.RED);
        selectionPanel.add(bacon);

        JButton bacon3 = new JButton("✓");
        JButton bacon2 = new JButton("✗");
        bacon2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        bacon2.setBounds(151,150,50, 25);
        bacon2.setBackground(Color.WHITE);
        bacon2.setOpaque(true);
        bacon2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        bacon2.setForeground(Color.RED);
        bacon2.setFocusPainted(false);
        bacon2.addActionListener(new ActionListener() {

                                     @Override
                                     public void actionPerformed(ActionEvent e) {

                                         if(menu1.topping.contains("bacon")){
                                             menu1.topping.remove("bacon");
                                         }

                                         bacon2.setBackground(Color.WHITE);
                                         bacon2.setForeground(Color.RED);
                                         bacon2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                         bacon3.setBackground(Color.RED);
                                         bacon3.setForeground(Color.WHITE);
                                         bacon3.setBorder(BorderFactory.createEmptyBorder());
                                         //}
                                     }
                                 }
        );
        selectionPanel.add(bacon2);

        bacon3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        bacon3.setBounds(202,150,50, 25);
        bacon3.setBackground(Color.RED);
        bacon3.setOpaque(true);
        bacon3.setBorder(BorderFactory.createEmptyBorder());
        bacon3.setForeground(Color.WHITE);
        bacon3.setFocusPainted(false);
        bacon3.addActionListener(new ActionListener() {

                                     @Override
                                     public void actionPerformed(ActionEvent e) {

                                         //if (menutopping.get(4) == null){
                                         menu1.topping.add("bacon");

                                         bacon3.setBackground(Color.WHITE);
                                         bacon3.setForeground(Color.RED);
                                         bacon3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                         bacon2.setBackground(Color.RED);
                                         bacon2.setForeground(Color.WHITE);
                                         bacon2.setBorder(BorderFactory.createEmptyBorder());
                                         //}
                                     }
                                 }
        );
        selectionPanel.add(bacon3);


        JLabel phillySteak =new JLabel("Philly Steak");
        phillySteak.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        phillySteak.setBounds(10,200,80, 25);
        phillySteak.setForeground(Color.RED);
        selectionPanel.add(phillySteak);


        JButton philly3 = new JButton("✓");
        JButton philly2 = new JButton("✗");
        philly2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        philly2.setBounds(151,200,50, 25);
        philly2.setBackground(Color.WHITE);
        philly2.setOpaque(true);
        philly2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        philly2.setForeground(Color.RED);
        philly2.setFocusPainted(false);
        philly2.addActionListener(new ActionListener() {

                                      @Override
                                      public void actionPerformed(ActionEvent e) {

                                          if(menu1.topping.contains("philly steak")){
                                              menu1.topping.remove("philly steak");
                                          }

                                          philly2.setBackground(Color.WHITE);
                                          philly2.setForeground(Color.RED);
                                          philly2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                          philly3.setBackground(Color.RED);
                                          philly3.setForeground(Color.WHITE);
                                          philly3.setBorder(BorderFactory.createEmptyBorder());

                                      }
                                  }
        );
        selectionPanel.add(philly2);

        philly3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        philly3.setBounds(202,200,50, 25);
        philly3.setBackground(Color.RED);
        philly3.setOpaque(true);
        philly3.setBorder(BorderFactory.createEmptyBorder());
        philly3.setForeground(Color.WHITE);
        philly3.setFocusPainted(false);
        philly3.addActionListener(new ActionListener() {

                                      @Override
                                      public void actionPerformed(ActionEvent e) {

                                          //if (menutopping.get(4) == null){
                                          menu1.topping.add("philly steak");

                                          philly3.setBackground(Color.WHITE);
                                          philly3.setForeground(Color.RED);
                                          philly3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                          philly2.setBackground(Color.RED);
                                          philly2.setForeground(Color.WHITE);
                                          philly2.setBorder(BorderFactory.createEmptyBorder());
                                          //}
                                      }
                                  }
        );
        selectionPanel.add(philly3);


        JLabel anchovies =new JLabel("Anchovies");
        anchovies.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        anchovies.setBounds(10,250,80, 25);
        anchovies.setForeground(Color.RED);
        selectionPanel.add(anchovies);



        JButton anchovies3 = new JButton("✓");
        JButton anchovies2 = new JButton("✗");
        anchovies2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        anchovies2.setBounds(151,250,50, 25);
        anchovies2.setBackground(Color.WHITE);
        anchovies2.setOpaque(true);
        anchovies2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        anchovies2.setForeground(Color.RED);
        anchovies2.setFocusPainted(false);
        anchovies2.addActionListener(new ActionListener() {

                                         @Override
                                         public void actionPerformed(ActionEvent e) {

                                             if(menu1.topping.contains("anchovies")){
                                                 menu1.topping.remove("anchovies");
                                             }

                                             anchovies2.setBackground(Color.WHITE);
                                             anchovies2.setForeground(Color.RED);
                                             anchovies2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                             anchovies3.setBackground(Color.RED);
                                             anchovies3.setForeground(Color.WHITE);
                                             anchovies3.setBorder(BorderFactory.createEmptyBorder());
                                             //}
                                         }
                                     }
        );
        selectionPanel.add(philly2);
        selectionPanel.add(anchovies2);

        anchovies3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        anchovies3.setBounds(202,250,50, 25);
        anchovies3.setBackground(Color.RED);
        anchovies3.setOpaque(true);
        anchovies3.setBorder(BorderFactory.createEmptyBorder());
        anchovies3.setForeground(Color.WHITE);
        anchovies3.setFocusPainted(false);
        anchovies3.addActionListener(new ActionListener() {

                                         @Override
                                         public void actionPerformed(ActionEvent e) {

                                             //if (menutopping.get(4) == null){
                                             menu1.topping.add("anchovies");

                                             anchovies3.setBackground(Color.WHITE);
                                             anchovies3.setForeground(Color.RED);
                                             anchovies3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                             anchovies2.setBackground(Color.RED);
                                             anchovies2.setForeground(Color.WHITE);
                                             anchovies2.setBorder(BorderFactory.createEmptyBorder());
                                             //}
                                         }
                                     }
        );
        selectionPanel.add(anchovies3);


        JLabel onions =new JLabel("Onions");
        onions.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        onions.setBounds(10,300,80, 25);
        onions.setForeground(Color.RED);
        selectionPanel.add(onions);



        JButton onion3 = new JButton("✓");
        JButton onion2 = new JButton("✗");
        onion2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        onion2.setBounds(151,300,50, 25);
        onion2.setBackground(Color.WHITE);
        onion2.setOpaque(true);
        onion2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        onion2.setForeground(Color.RED);
        onion2.setFocusPainted(false);
        onion2.addActionListener(new ActionListener() {

                                     @Override
                                     public void actionPerformed(ActionEvent e) {

                                         if(menu1.topping.contains("onions")){
                                             menu1.topping.remove("onions");
                                         }
                                         onion2.setBackground(Color.WHITE);
                                         onion2.setForeground(Color.RED);
                                         onion2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                         onion3.setBackground(Color.RED);
                                         onion3.setForeground(Color.WHITE);
                                         onion3.setBorder(BorderFactory.createEmptyBorder());

                                     }
                                 }
        );
        selectionPanel.add(onion2);

        onion3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        onion3.setBounds(202,300,50, 25);
        onion3.setBackground(Color.RED);
        onion3.setOpaque(true);
        onion3.setBorder(BorderFactory.createEmptyBorder());
        onion3.setForeground(Color.WHITE);
        onion3.setFocusPainted(false);
        onion3.addActionListener(new ActionListener() {

                                     @Override
                                     public void actionPerformed(ActionEvent e) {

                                         //if (menutopping.get(4) == null){
                                         menu1.topping.add("onion");

                                         onion3.setBackground(Color.WHITE);
                                         onion3.setForeground(Color.RED);
                                         onion3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                         onion2.setBackground(Color.RED);
                                         onion2.setForeground(Color.WHITE);
                                         onion2.setBorder(BorderFactory.createEmptyBorder());
                                         //}
                                     }
                                 }
        );
        selectionPanel.add(onion3);



        JLabel olives =new JLabel("Olives");
        olives.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        olives.setBounds(10,350,80, 25);
        olives.setForeground(Color.RED);
        selectionPanel.add(olives);



        JButton olives3 = new JButton("✓");
        JButton olives2 = new JButton("✗");
        olives2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        olives2.setBounds(151,350,50, 25);
        olives2.setBackground(Color.WHITE);
        olives2.setOpaque(true);
        olives2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        olives2.setForeground(Color.RED);
        olives2.setFocusPainted(false);
        olives2.addActionListener(new ActionListener() {

                                      @Override
                                      public void actionPerformed(ActionEvent e) {

                                          if(menu1.topping.contains("olives")){
                                              menu1.topping.remove("olives");
                                          }

                                          olives2.setBackground(Color.WHITE);
                                          olives2.setForeground(Color.RED);
                                          olives2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                          olives3.setBackground(Color.RED);
                                          olives3.setForeground(Color.WHITE);
                                          olives3.setBorder(BorderFactory.createEmptyBorder());
                                      }
                                  }
        );
        selectionPanel.add(olives2);

        olives3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        olives3.setBounds(202,350,50, 25);
        olives3.setBackground(Color.RED);
        olives3.setOpaque(true);
        olives3.setBorder(BorderFactory.createEmptyBorder());
        olives3.setForeground(Color.WHITE);
        olives3.setFocusPainted(false);
        olives3.addActionListener(new ActionListener() {

                                      @Override
                                      public void actionPerformed(ActionEvent e) {

                                          //if (menutopping.get(4) == null){
                                          menu1.topping.add("olives");

                                          olives3.setBackground(Color.WHITE);
                                          olives3.setForeground(Color.RED);
                                          olives3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                          olives2.setBackground(Color.RED);
                                          olives2.setForeground(Color.WHITE);
                                          olives2.setBorder(BorderFactory.createEmptyBorder());
                                          //}
                                      }
                                  }
        );
        selectionPanel.add(olives3);


        JLabel cheese =new JLabel("Cheese");
        cheese.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        cheese.setBounds(10,400,80, 25);
        cheese.setForeground(Color.RED);
        selectionPanel.add(cheese);


        JButton cheese3 = new JButton("✓");
        JButton cheese2 = new JButton("✗");
        cheese2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        cheese2.setBounds(151,400,50, 25);
        cheese2.setBackground(Color.WHITE);
        cheese2.setOpaque(true);
        cheese2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        cheese2.setForeground(Color.RED);
        cheese2.setFocusPainted(false);
        cheese2.addActionListener(new ActionListener() {

                                      @Override
                                      public void actionPerformed(ActionEvent e) {
                                          if(menu1.topping.contains("cheese")){
                                              menu1.topping.remove("cheese");
                                          }

                                          cheese2.setBackground(Color.WHITE);
                                          cheese2.setForeground(Color.RED);
                                          cheese2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                          cheese3.setBackground(Color.RED);
                                          cheese3.setForeground(Color.WHITE);
                                          cheese3.setBorder(BorderFactory.createEmptyBorder());
                                      }
                                  }
        );
        selectionPanel.add(cheese2);

        cheese3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        cheese3.setBounds(202,400,50, 25);
        cheese3.setBackground(Color.RED);
        cheese3.setOpaque(true);
        cheese3.setBorder(BorderFactory.createEmptyBorder());
        cheese3.setForeground(Color.WHITE);
        cheese3.setFocusPainted(false);
        cheese3.addActionListener(new ActionListener() {

                                      @Override
                                      public void actionPerformed(ActionEvent e) {

                                          //if (menutopping.get(4) == null){
                                          menu1.topping.add("cheese");

                                          cheese3.setBackground(Color.WHITE);
                                          cheese3.setForeground(Color.RED);
                                          cheese3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                          cheese2.setBackground(Color.RED);
                                          cheese2.setForeground(Color.WHITE);
                                          cheese2.setBorder(BorderFactory.createEmptyBorder());
                                          //}
                                      }
                                  }
        );
        selectionPanel.add(cheese3);



        JLabel mushroom =new JLabel("Mushroom");
        mushroom.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        mushroom.setBounds(10,450,80, 25);
        mushroom.setForeground(Color.RED);
        selectionPanel.add(mushroom);


        JButton mushroom3 = new JButton("✓");
        JButton mushroom2 = new JButton("✗");
        mushroom2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        mushroom2.setBounds(151,450,50, 25);
        mushroom2.setBackground(Color.WHITE);
        mushroom2.setOpaque(true);
        mushroom2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        mushroom2.setForeground(Color.RED);
        mushroom2.setFocusPainted(false);
        mushroom2.addActionListener(new ActionListener() {

                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            if(menu1.topping.contains("mushroom")){
                                                menu1.topping.remove("mushroom");
                                            }

                                            mushroom2.setBackground(Color.WHITE);
                                            mushroom2.setForeground(Color.RED);
                                            mushroom2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                            mushroom3.setBackground(Color.RED);
                                            mushroom3.setForeground(Color.WHITE);
                                            mushroom3.setBorder(BorderFactory.createEmptyBorder());
                                        }
                                    }
        );
        selectionPanel.add(mushroom2);

        mushroom3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        mushroom3.setBounds(202,450,50, 25);
        mushroom3.setBackground(Color.RED);
        mushroom3.setOpaque(true);
        mushroom3.setBorder(BorderFactory.createEmptyBorder());
        mushroom3.setForeground(Color.WHITE);
        mushroom3.setFocusPainted(false);
        mushroom3.addActionListener(new ActionListener() {

                                        @Override
                                        public void actionPerformed(ActionEvent e) {

                                            //if (menutopping.get(4) == null){
                                            menu1.topping.add("mushroom");

                                            mushroom3.setBackground(Color.WHITE);
                                            mushroom3.setForeground(Color.RED);
                                            mushroom3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                            mushroom2.setBackground(Color.RED);
                                            mushroom2.setForeground(Color.WHITE);
                                            mushroom2.setBorder(BorderFactory.createEmptyBorder());
                                            //}
                                        }
                                    }
        );
        selectionPanel.add(mushroom3);


        JLabel crust =new JLabel("Crust");
        crust.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        crust.setBounds(10,500,80, 25);
        crust.setForeground(Color.RED);
        selectionPanel.add(crust);

        JButton crust4 = new JButton("Gluten Free");
        JButton crust3 = new JButton("Cheese Stuffed");
        JButton crust2 = new JButton("Normal");
        JButton crust1 = new JButton("Thin");
        crust1.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        crust1.setBounds(100,500,50, 25);
        crust1.setBackground(Color.RED);
        crust1.setOpaque(true);
        crust1.setBorder(BorderFactory.createEmptyBorder());
        crust1.setForeground(Color.WHITE);
        crust1.setFocusPainted(false);
        crust1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu1.setCrustType("Thin");

                crust1.setForeground(Color.RED);
                crust1.setBackground(Color.WHITE);
                crust1.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                crust2.setForeground(Color.WHITE);
                crust2.setBackground(Color.RED);
                crust2.setBorder(BorderFactory.createEmptyBorder());

                crust3.setForeground(Color.WHITE);
                crust3.setBackground(Color.RED);
                crust3.setBorder(BorderFactory.createEmptyBorder());

                crust4.setForeground(Color.WHITE);
                crust4.setBackground(Color.RED);
                crust4.setBorder(BorderFactory.createEmptyBorder());

            }
        });
        selectionPanel.add(crust1);

        crust2.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        crust2.setBounds(151,500,50, 25);
        crust2.setBackground(Color.WHITE);
        crust2.setOpaque(true);
        crust2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        crust2.setForeground(Color.RED);
        crust2.setFocusPainted(false);
        crust2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu1.setCrustType("Normal");

                crust1.setForeground(Color.WHITE);
                crust1.setBackground(Color.RED);
                crust1.setBorder(BorderFactory.createEmptyBorder());

                crust2.setForeground(Color.RED);
                crust2.setBackground(Color.WHITE);
                crust2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                crust3.setForeground(Color.WHITE);
                crust3.setBackground(Color.RED);
                crust3.setBorder(BorderFactory.createEmptyBorder());

                crust4.setForeground(Color.WHITE);
                crust4.setBackground(Color.RED);
                crust4.setBorder(BorderFactory.createEmptyBorder());
            }
        });
        selectionPanel.add(crust2);

        menu1.setCrustType("Normal");

        crust3.setFont(new Font("Times New Roman", Font.PLAIN, (int) 7.5));
        crust3.setBounds(202,500,50, 25);
        crust3.setBackground(Color.RED);
        crust3.setOpaque(true);
        crust3.setBorder(BorderFactory.createEmptyBorder());
        crust3.setForeground(Color.WHITE);
        crust3.setFocusPainted(false);
        crust3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu1.setCrustType("Cheese Stuffed");

                crust1.setForeground(Color.WHITE);
                crust1.setBackground(Color.RED);
                crust1.setBorder(BorderFactory.createEmptyBorder());

                crust2.setForeground(Color.WHITE);
                crust2.setBackground(Color.RED);
                crust2.setBorder(BorderFactory.createEmptyBorder());

                crust3.setForeground(Color.RED);
                crust3.setBackground(Color.WHITE);
                crust3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                crust4.setForeground(Color.WHITE);
                crust4.setBackground(Color.RED);
                crust4.setBorder(BorderFactory.createEmptyBorder());

            }
        });
        selectionPanel.add(crust3);

        crust4.setFont(new Font("Times New Roman", Font.PLAIN, 8));
        crust4.setBounds(253,500,50, 25);
        crust4.setBackground(Color.RED);
        crust4.setOpaque(true);
        crust4.setBorder(BorderFactory.createEmptyBorder());
        crust4.setForeground(Color.WHITE);
        crust4.setFocusPainted(false);
        crust4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu1.setCrustType("Gluten Free");

                crust1.setForeground(Color.WHITE);
                crust1.setBackground(Color.RED);
                crust1.setBorder(BorderFactory.createEmptyBorder());

                crust2.setForeground(Color.WHITE);
                crust2.setBackground(Color.RED);
                crust2.setBorder(BorderFactory.createEmptyBorder());

                crust3.setForeground(Color.WHITE);
                crust3.setBackground(Color.RED);
                crust3.setBorder(BorderFactory.createEmptyBorder());

                crust4.setForeground(Color.RED);
                crust4.setBackground(Color.WHITE);
                crust4.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            }
        });
        selectionPanel.add(crust4);


        AtomicInteger quant = new AtomicInteger(1);
        JLabel quantity = new JLabel(" "+quant.toString()+"  ");

        JButton plus = new JButton("+");
        plus.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        plus.setBounds(110,575,30, 25);
        plus.setBackground(Color.RED);
        plus.setOpaque(true);
        plus.setBorder(BorderFactory.createEmptyBorder());
        plus.setForeground(Color.WHITE);
        plus.setBorderPainted(false);
        plus.setFocusPainted(false);
        plus.addActionListener(new ActionListener() {

                                   @Override
                                   public void actionPerformed(ActionEvent e) {
                                       quant.incrementAndGet();
                                       quantity.setText(String.valueOf(quant.get()));
                                   }
                               }
        );

        selectionPanel.add(plus);

        JButton minus = new JButton("-");
        minus.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        minus.setBounds(30,575,30, 25);
        minus.setBackground(Color.RED);
        minus.setOpaque(true);
        minus.setBorder(BorderFactory.createEmptyBorder());
        minus.setForeground(Color.WHITE);
        minus.setBorderPainted(false);
        minus.setFocusPainted(false);
        minus.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (quant.get() == 1 ){
                    quant.set(Integer.valueOf(quant.get()));
                }else {
                    quant.decrementAndGet();
                    quantity.setText(String.valueOf(quant.get()));
                }

            }
        });
        selectionPanel.add(minus);



        quantity.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        quantity.setBounds(80,575,30, 25);
        quantity.setForeground(Color.red);
        selectionPanel.add(quantity);

        menu1.setQuantityy(quant.get());
        menu1.setImage("/Users/ekeneezeobi/IdeaProjects/PPD/src/pepPizza1.jpeg");

        JButton addToCart = new JButton("Add to Cart");
        addToCart.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        addToCart.setBounds(115,650,100, 25);
        addToCart.setBackground(Color.RED);
        addToCart.setOpaque(true);
        addToCart.setBorder(BorderFactory.createEmptyBorder());
        addToCart.setForeground(Color.WHITE);
        addToCart.setBorderPainted(false);
        addToCart.setFocusPainted(false);
        addToCart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if(menu1.getSize().equals("small")){
                    menu1.setPrice(5.99);
                } else if (menu1.getSize().equals("medium")) {
                    menu1.setPrice(7.99);
                } else if (menu1.getSize().equals("large")) {
                    menu1.setPrice(9.99);
                } else if (menu1.getSize().equals("extra large")) {
                    menu1.setPrice(12.99);
                }
                cartList.add(menu1);

            }
        });
        selectionPanel.add(addToCart);



        pepperoniPage.setVisible(true);
    }


    public static void phillySteak(){
        //****** Philly Steak Page ******#####################################################################################################################

        JFrame phillySteakPage = new JFrame();
        phillySteakPage.setLayout(null);
        JPanel panel1 = new JPanel();

        phillySteakPage.setSize(350, 700);
        phillySteakPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        phillySteakPage.add(panel1);

        panel1.setLayout(null);


        JPanel panel3_2 = new JPanel();
        panel3_2.setBounds(0,0,350, 599);
        panel3_2.setBackground(Color.WHITE);
        panel3_2.setLayout(null);
        phillySteakPage.add(panel3_2);

        JPanel panel3_3 = new JPanel();
        panel3_3.setBounds(0,600,350, 100);
        panel3_3.setBackground(Color.WHITE);
        phillySteakPage.add(panel3_3);

        ImageIcon icon1 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/home_icon.png");
        JButton home = new JButton(icon1);
        home.setBounds(0, 630, 40, 40);
        home.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                menu();
                phillySteakPage.dispose();
            }
        });
        panel3_3.add(home);

        ImageIcon icon2 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/search_icon.png");
        JButton search = new JButton(icon2);
        search.setBounds(50, 630, 40, 40);
        search.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                search();
                phillySteakPage.dispose();
            }
        });
        panel3_3.add(search);

        ImageIcon icon3 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/cart_icon.png");
        JButton cart = new JButton(icon3);
        cart.setBounds(100, 630, 40, 40);
        cart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cart();
            }
        });
        panel3_3.add(cart);

        ImageIcon icon4 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/account_icon.png");
        JButton account = new JButton(icon4);
        account.setBounds(150, 630, 40, 40);
        account.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                account();
                phillySteakPage.dispose();
            }
        });
        panel3_3.add(account);

        ImageIcon food_icon = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/philly_steakcopy.jpeg");
        JLabel food = new JLabel(food_icon);
        food.setBounds(0, 0, 350, 150);
        panel3_2.add(food);


        JPanel selectionPanel = new JPanel();
        selectionPanel.setPreferredSize(new Dimension(330, 800));
        selectionPanel.setLayout(null);
        selectionPanel.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(selectionPanel);
        scrollPane.setBounds(0, 150, 350, 550);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        panel3_2.add(scrollPane);
        phillySteakPage.add(panel3_3);

        Product menu2 = new Product();
        menu2.setName("Philly Cheese Steak Pizza");

        JLabel size = new JLabel("Size");
        size.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        size.setBounds(10,50,80, 25);
        size.setForeground(Color.RED);
        selectionPanel.add(size);


        JButton size4 = new JButton("x-Large");
        JButton size3 = new JButton("Large");
        JButton size2 = new JButton("Medium");
        JButton size1 = new JButton("Small");

        menu2.setCrustType("Normal");
        menu2.setSize("medium");


        size1.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        size1.setBounds(100,50,50, 25);
        size1.setBackground(Color.RED);
        size1.setOpaque(true);
        size1.setBorder(BorderFactory.createEmptyBorder());
        size1.setForeground(Color.WHITE);
        size1.setFocusPainted(false);
        size1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu2.setSize("small");

                size1.setForeground(Color.RED);
                size1.setBackground(Color.WHITE);
                size1.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                size2.setForeground(Color.WHITE);
                size2.setBackground(Color.RED);
                size2.setBorder(BorderFactory.createEmptyBorder());

                size3.setForeground(Color.WHITE);
                size3.setBackground(Color.RED);
                size3.setBorder(BorderFactory.createEmptyBorder());

                size4.setForeground(Color.WHITE);
                size4.setBackground(Color.RED);
                size4.setBorder(BorderFactory.createEmptyBorder());

            }
        });
        selectionPanel.add(size1);

        size2.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        size2.setBounds(151,50,50, 25);
        size2.setBackground(Color.WHITE);
        size2.setOpaque(true);
        size2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        size2.setForeground(Color.RED);
        size2.setFocusPainted(false);
        size2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu2.setSize("medium");

                size1.setForeground(Color.WHITE);
                size1.setBackground(Color.RED);
                size1.setBorder(BorderFactory.createEmptyBorder());

                size2.setForeground(Color.RED);
                size2.setBackground(Color.WHITE);
                size2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                size3.setForeground(Color.WHITE);
                size3.setBackground(Color.RED);
                size3.setBorder(BorderFactory.createEmptyBorder());

                size4.setForeground(Color.WHITE);
                size4.setBackground(Color.RED);
                size4.setBorder(BorderFactory.createEmptyBorder());
            }
        });
        selectionPanel.add(size2);

        size3.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        size3.setBounds(202,50,50, 25);
        size3.setBackground(Color.RED);
        size3.setOpaque(true);
        size3.setBorder(BorderFactory.createEmptyBorder());
        size3.setForeground(Color.WHITE);
        size3.setFocusPainted(false);
        size3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu2.setSize("large");

                size1.setForeground(Color.WHITE);
                size1.setBackground(Color.RED);
                size1.setBorder(BorderFactory.createEmptyBorder());

                size2.setForeground(Color.WHITE);
                size2.setBackground(Color.RED);
                size2.setBorder(BorderFactory.createEmptyBorder());

                size3.setForeground(Color.RED);
                size3.setBackground(Color.WHITE);
                size3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                size4.setForeground(Color.WHITE);
                size4.setBackground(Color.RED);
                size4.setBorder(BorderFactory.createEmptyBorder());

            }
        });
        selectionPanel.add(size3);

        size4.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        size4.setBounds(253,50,50, 25);
        size4.setBackground(Color.RED);
        size4.setOpaque(true);
        size4.setBorder(BorderFactory.createEmptyBorder());
        size4.setForeground(Color.WHITE);
        size4.setFocusPainted(false);
        size4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu2.setSize("extra large");

                size1.setForeground(Color.WHITE);
                size1.setBackground(Color.RED);
                size1.setBorder(BorderFactory.createEmptyBorder());

                size2.setForeground(Color.WHITE);
                size2.setBackground(Color.RED);
                size2.setBorder(BorderFactory.createEmptyBorder());

                size3.setForeground(Color.WHITE);
                size3.setBackground(Color.RED);
                size3.setBorder(BorderFactory.createEmptyBorder());

                size4.setForeground(Color.RED);
                size4.setBackground(Color.WHITE);
                size4.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            }
        });
        selectionPanel.add(size4);

        JLabel chicken =new JLabel("Chicken");
        chicken.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        chicken.setBounds(10,100,80, 25);
        chicken.setForeground(Color.RED);
        selectionPanel.add(chicken);


        JButton chicken3 = new JButton("✓");

        JButton chicken2 = new JButton("✗");
        chicken2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        chicken2.setBounds(151,100,50, 25);
        chicken2.setOpaque(true);
        chicken2.setBorder(BorderFactory.createEmptyBorder());
        chicken2.setFocusPainted(false);
        chicken2.setBackground(Color.WHITE);
        chicken2.setForeground(Color.RED);
        chicken2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        chicken2.addActionListener(new ActionListener() {

                                       @Override
                                       public void actionPerformed(ActionEvent e) {

                                           if(menu2.topping.contains("chicken")){
                                               menu2.topping.remove("chicken");
                                           }

                                           chicken2.setBackground(Color.WHITE);
                                           chicken2.setForeground(Color.RED);
                                           chicken2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                           chicken3.setBackground(Color.RED);
                                           chicken3.setForeground(Color.WHITE);
                                           chicken3.setBorder(BorderFactory.createEmptyBorder());

                                       }
                                   }
        );
        selectionPanel.add(chicken2);

        chicken3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        chicken3.setBounds(202,100,50, 25);
        chicken3.setBackground(Color.RED);
        chicken3.setOpaque(true);
        chicken3.setBorder(BorderFactory.createEmptyBorder());
        chicken3.setForeground(Color.WHITE);
        chicken3.setFocusPainted(false);
        chicken3.addActionListener(new ActionListener() {

                                       @Override
                                       public void actionPerformed(ActionEvent e) {

                                           //if (menutopping.get(4) == null){
                                           menu2.topping.add("chicken");

                                           chicken3.setBackground(Color.WHITE);
                                           chicken3.setForeground(Color.RED);
                                           chicken3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                           chicken2.setBackground(Color.RED);
                                           chicken2.setForeground(Color.WHITE);
                                           chicken2.setBorder(BorderFactory.createEmptyBorder());
                                           //}
                                       }
                                   }
        );
        selectionPanel.add(chicken3);


        JLabel bacon =new JLabel("Bacon");
        bacon.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        bacon.setBounds(10,150,80, 25);
        bacon.setForeground(Color.RED);
        selectionPanel.add(bacon);

        JButton bacon3 = new JButton("✓");
        JButton bacon2 = new JButton("✗");
        bacon2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        bacon2.setBounds(151,150,50, 25);
        bacon2.setBackground(Color.WHITE);
        bacon2.setOpaque(true);
        bacon2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        bacon2.setForeground(Color.RED);
        bacon2.setFocusPainted(false);
        bacon2.addActionListener(new ActionListener() {

                                     @Override
                                     public void actionPerformed(ActionEvent e) {

                                         if(menu2.topping.contains("bacon")){
                                             menu2.topping.remove("bacon");
                                         }

                                         bacon2.setBackground(Color.WHITE);
                                         bacon2.setForeground(Color.RED);
                                         bacon2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                         bacon3.setBackground(Color.RED);
                                         bacon3.setForeground(Color.WHITE);
                                         bacon3.setBorder(BorderFactory.createEmptyBorder());
                                         //}
                                     }
                                 }
        );
        selectionPanel.add(bacon2);

        bacon3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        bacon3.setBounds(202,150,50, 25);
        bacon3.setBackground(Color.RED);
        bacon3.setOpaque(true);
        bacon3.setBorder(BorderFactory.createEmptyBorder());
        bacon3.setForeground(Color.WHITE);
        bacon3.setFocusPainted(false);
        bacon3.addActionListener(new ActionListener() {

                                     @Override
                                     public void actionPerformed(ActionEvent e) {

                                         //if (menutopping.get(4) == null){
                                         menu2.topping.add("bacon");

                                         bacon3.setBackground(Color.WHITE);
                                         bacon3.setForeground(Color.RED);
                                         bacon3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                         bacon2.setBackground(Color.RED);
                                         bacon2.setForeground(Color.WHITE);
                                         bacon2.setBorder(BorderFactory.createEmptyBorder());
                                         //}
                                     }
                                 }
        );
        selectionPanel.add(bacon3);


        JLabel phillySteak =new JLabel("Philly Steak");
        phillySteak.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        phillySteak.setBounds(10,200,80, 25);
        phillySteak.setForeground(Color.RED);
        selectionPanel.add(phillySteak);


        JButton philly3 = new JButton("✓");
        JButton philly2 = new JButton("✗");
        philly2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        philly2.setBounds(151,200,50, 25);
        philly2.setBackground(Color.WHITE);
        philly2.setOpaque(true);
        philly2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        philly2.setForeground(Color.RED);
        philly2.setFocusPainted(false);
        philly2.addActionListener(new ActionListener() {

                                      @Override
                                      public void actionPerformed(ActionEvent e) {

                                          if(menu2.topping.contains("philly steak")){
                                              menu2.topping.remove("philly steak");
                                          }

                                          philly2.setBackground(Color.WHITE);
                                          philly2.setForeground(Color.RED);
                                          philly2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                          philly3.setBackground(Color.RED);
                                          philly3.setForeground(Color.WHITE);
                                          philly3.setBorder(BorderFactory.createEmptyBorder());

                                      }
                                  }
        );
        selectionPanel.add(philly2);

        philly3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        philly3.setBounds(202,200,50, 25);
        philly3.setBackground(Color.RED);
        philly3.setOpaque(true);
        philly3.setBorder(BorderFactory.createEmptyBorder());
        philly3.setForeground(Color.WHITE);
        philly3.setFocusPainted(false);
        philly3.addActionListener(new ActionListener() {

                                      @Override
                                      public void actionPerformed(ActionEvent e) {

                                          //if (menutopping.get(4) == null){
                                          menu2.topping.add("philly steak");

                                          philly3.setBackground(Color.WHITE);
                                          philly3.setForeground(Color.RED);
                                          philly3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                          philly2.setBackground(Color.RED);
                                          philly2.setForeground(Color.WHITE);
                                          philly2.setBorder(BorderFactory.createEmptyBorder());
                                          //}
                                      }
                                  }
        );
        selectionPanel.add(philly3);


        JLabel anchovies =new JLabel("Anchovies");
        anchovies.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        anchovies.setBounds(10,250,80, 25);
        anchovies.setForeground(Color.RED);
        selectionPanel.add(anchovies);



        JButton anchovies3 = new JButton("✓");
        JButton anchovies2 = new JButton("✗");
        anchovies2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        anchovies2.setBounds(151,250,50, 25);
        anchovies2.setBackground(Color.WHITE);
        anchovies2.setOpaque(true);
        anchovies2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        anchovies2.setForeground(Color.RED);
        anchovies2.setFocusPainted(false);
        anchovies2.addActionListener(new ActionListener() {

                                         @Override
                                         public void actionPerformed(ActionEvent e) {

                                             if(menu2.topping.contains("anchovies")){
                                                 menu2.topping.remove("anchovies");
                                             }

                                             anchovies2.setBackground(Color.WHITE);
                                             anchovies2.setForeground(Color.RED);
                                             anchovies2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                             anchovies3.setBackground(Color.RED);
                                             anchovies3.setForeground(Color.WHITE);
                                             anchovies3.setBorder(BorderFactory.createEmptyBorder());
                                             //}
                                         }
                                     }
        );
        selectionPanel.add(philly2);
        selectionPanel.add(anchovies2);

        anchovies3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        anchovies3.setBounds(202,250,50, 25);
        anchovies3.setBackground(Color.RED);
        anchovies3.setOpaque(true);
        anchovies3.setBorder(BorderFactory.createEmptyBorder());
        anchovies3.setForeground(Color.WHITE);
        anchovies3.setFocusPainted(false);
        anchovies3.addActionListener(new ActionListener() {

                                         @Override
                                         public void actionPerformed(ActionEvent e) {

                                             //if (menutopping.get(4) == null){
                                             menu2.topping.add("anchovies");

                                             anchovies3.setBackground(Color.WHITE);
                                             anchovies3.setForeground(Color.RED);
                                             anchovies3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                             anchovies2.setBackground(Color.RED);
                                             anchovies2.setForeground(Color.WHITE);
                                             anchovies2.setBorder(BorderFactory.createEmptyBorder());
                                             //}
                                         }
                                     }
        );
        selectionPanel.add(anchovies3);


        JLabel onions =new JLabel("Onions");
        onions.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        onions.setBounds(10,300,80, 25);
        onions.setForeground(Color.RED);
        selectionPanel.add(onions);



        JButton onion3 = new JButton("✓");
        JButton onion2 = new JButton("✗");
        onion2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        onion2.setBounds(151,300,50, 25);
        onion2.setBackground(Color.WHITE);
        onion2.setOpaque(true);
        onion2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        onion2.setForeground(Color.RED);
        onion2.setFocusPainted(false);
        onion2.addActionListener(new ActionListener() {

                                     @Override
                                     public void actionPerformed(ActionEvent e) {

                                         if(menu2.topping.contains("onions")){
                                             menu2.topping.remove("onions");
                                         }
                                         onion2.setBackground(Color.WHITE);
                                         onion2.setForeground(Color.RED);
                                         onion2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                         onion3.setBackground(Color.RED);
                                         onion3.setForeground(Color.WHITE);
                                         onion3.setBorder(BorderFactory.createEmptyBorder());

                                     }
                                 }
        );
        selectionPanel.add(onion2);

        onion3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        onion3.setBounds(202,300,50, 25);
        onion3.setBackground(Color.RED);
        onion3.setOpaque(true);
        onion3.setBorder(BorderFactory.createEmptyBorder());
        onion3.setForeground(Color.WHITE);
        onion3.setFocusPainted(false);
        onion3.addActionListener(new ActionListener() {

                                     @Override
                                     public void actionPerformed(ActionEvent e) {

                                         //if (menutopping.get(4) == null){
                                         menu2.topping.add("onion");

                                         onion3.setBackground(Color.WHITE);
                                         onion3.setForeground(Color.RED);
                                         onion3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                         onion2.setBackground(Color.RED);
                                         onion2.setForeground(Color.WHITE);
                                         onion2.setBorder(BorderFactory.createEmptyBorder());
                                         //}
                                     }
                                 }
        );
        selectionPanel.add(onion3);



        JLabel olives =new JLabel("Olives");
        olives.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        olives.setBounds(10,350,80, 25);
        olives.setForeground(Color.RED);
        selectionPanel.add(olives);



        JButton olives3 = new JButton("✓");
        JButton olives2 = new JButton("✗");
        olives2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        olives2.setBounds(151,350,50, 25);
        olives2.setBackground(Color.WHITE);
        olives2.setOpaque(true);
        olives2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        olives2.setForeground(Color.RED);
        olives2.setFocusPainted(false);
        olives2.addActionListener(new ActionListener() {

                                      @Override
                                      public void actionPerformed(ActionEvent e) {

                                          if(menu2.topping.contains("olives")){
                                              menu2.topping.remove("olives");
                                          }

                                          olives2.setBackground(Color.WHITE);
                                          olives2.setForeground(Color.RED);
                                          olives2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                          olives3.setBackground(Color.RED);
                                          olives3.setForeground(Color.WHITE);
                                          olives3.setBorder(BorderFactory.createEmptyBorder());
                                      }
                                  }
        );
        selectionPanel.add(olives2);

        olives3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        olives3.setBounds(202,350,50, 25);
        olives3.setBackground(Color.RED);
        olives3.setOpaque(true);
        olives3.setBorder(BorderFactory.createEmptyBorder());
        olives3.setForeground(Color.WHITE);
        olives3.setFocusPainted(false);
        olives3.addActionListener(new ActionListener() {

                                      @Override
                                      public void actionPerformed(ActionEvent e) {

                                          //if (menutopping.get(4) == null){
                                          menu2.topping.add("olives");

                                          olives3.setBackground(Color.WHITE);
                                          olives3.setForeground(Color.RED);
                                          olives3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                          olives2.setBackground(Color.RED);
                                          olives2.setForeground(Color.WHITE);
                                          olives2.setBorder(BorderFactory.createEmptyBorder());
                                          //}
                                      }
                                  }
        );
        selectionPanel.add(olives3);


        JLabel cheese =new JLabel("Cheese");
        cheese.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        cheese.setBounds(10,400,80, 25);
        cheese.setForeground(Color.RED);
        selectionPanel.add(cheese);


        JButton cheese3 = new JButton("✓");
        JButton cheese2 = new JButton("✗");
        cheese2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        cheese2.setBounds(151,400,50, 25);
        cheese2.setBackground(Color.WHITE);
        cheese2.setOpaque(true);
        cheese2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        cheese2.setForeground(Color.RED);
        cheese2.setFocusPainted(false);
        cheese2.addActionListener(new ActionListener() {

                                      @Override
                                      public void actionPerformed(ActionEvent e) {
                                          if(menu2.topping.contains("cheese")){
                                              menu2.topping.remove("cheese");
                                          }

                                          cheese2.setBackground(Color.WHITE);
                                          cheese2.setForeground(Color.RED);
                                          cheese2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                          cheese3.setBackground(Color.RED);
                                          cheese3.setForeground(Color.WHITE);
                                          cheese3.setBorder(BorderFactory.createEmptyBorder());
                                      }
                                  }
        );
        selectionPanel.add(cheese2);

        cheese3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        cheese3.setBounds(202,400,50, 25);
        cheese3.setBackground(Color.RED);
        cheese3.setOpaque(true);
        cheese3.setBorder(BorderFactory.createEmptyBorder());
        cheese3.setForeground(Color.WHITE);
        cheese3.setFocusPainted(false);
        cheese3.addActionListener(new ActionListener() {

                                      @Override
                                      public void actionPerformed(ActionEvent e) {

                                          //if (menutopping.get(4) == null){
                                          menu2.topping.add("cheese");

                                          cheese3.setBackground(Color.WHITE);
                                          cheese3.setForeground(Color.RED);
                                          cheese3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                          cheese2.setBackground(Color.RED);
                                          cheese2.setForeground(Color.WHITE);
                                          cheese2.setBorder(BorderFactory.createEmptyBorder());
                                          //}
                                      }
                                  }
        );
        selectionPanel.add(cheese3);



        JLabel mushroom =new JLabel("Mushroom");
        mushroom.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        mushroom.setBounds(10,450,80, 25);
        mushroom.setForeground(Color.RED);
        selectionPanel.add(mushroom);


        JButton mushroom3 = new JButton("✓");
        JButton mushroom2 = new JButton("✗");
        mushroom2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        mushroom2.setBounds(151,450,50, 25);
        mushroom2.setBackground(Color.WHITE);
        mushroom2.setOpaque(true);
        mushroom2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        mushroom2.setForeground(Color.RED);
        mushroom2.setFocusPainted(false);
        mushroom2.addActionListener(new ActionListener() {

                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            if(menu2.topping.contains("mushroom")){
                                                menu2.topping.remove("mushroom");
                                            }

                                            mushroom2.setBackground(Color.WHITE);
                                            mushroom2.setForeground(Color.RED);
                                            mushroom2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                            mushroom3.setBackground(Color.RED);
                                            mushroom3.setForeground(Color.WHITE);
                                            mushroom3.setBorder(BorderFactory.createEmptyBorder());
                                        }
                                    }
        );
        selectionPanel.add(mushroom2);

        mushroom3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        mushroom3.setBounds(202,450,50, 25);
        mushroom3.setBackground(Color.RED);
        mushroom3.setOpaque(true);
        mushroom3.setBorder(BorderFactory.createEmptyBorder());
        mushroom3.setForeground(Color.WHITE);
        mushroom3.setFocusPainted(false);
        mushroom3.addActionListener(new ActionListener() {

                                        @Override
                                        public void actionPerformed(ActionEvent e) {

                                            //if (menutopping.get(4) == null){
                                            menu2.topping.add("mushroom");

                                            mushroom3.setBackground(Color.WHITE);
                                            mushroom3.setForeground(Color.RED);
                                            mushroom3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                            mushroom2.setBackground(Color.RED);
                                            mushroom2.setForeground(Color.WHITE);
                                            mushroom2.setBorder(BorderFactory.createEmptyBorder());
                                            //}
                                        }
                                    }
        );
        selectionPanel.add(mushroom3);


        JLabel crust =new JLabel("Crust");
        crust.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        crust.setBounds(10,500,80, 25);
        crust.setForeground(Color.RED);
        selectionPanel.add(crust);

        JButton crust4 = new JButton("Gluten Free");
        JButton crust3 = new JButton("Cheese Stuffed");
        JButton crust2 = new JButton("Normal");
        JButton crust1 = new JButton("Thin");
        crust1.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        crust1.setBounds(100,500,50, 25);
        crust1.setBackground(Color.RED);
        crust1.setOpaque(true);
        crust1.setBorder(BorderFactory.createEmptyBorder());
        crust1.setForeground(Color.WHITE);
        crust1.setFocusPainted(false);
        crust1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu2.setCrustType("Thin");

                crust1.setForeground(Color.RED);
                crust1.setBackground(Color.WHITE);
                crust1.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                crust2.setForeground(Color.WHITE);
                crust2.setBackground(Color.RED);
                crust2.setBorder(BorderFactory.createEmptyBorder());

                crust3.setForeground(Color.WHITE);
                crust3.setBackground(Color.RED);
                crust3.setBorder(BorderFactory.createEmptyBorder());

                crust4.setForeground(Color.WHITE);
                crust4.setBackground(Color.RED);
                crust4.setBorder(BorderFactory.createEmptyBorder());

            }
        });
        selectionPanel.add(crust1);

        crust2.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        crust2.setBounds(151,500,50, 25);
        crust2.setBackground(Color.WHITE);
        crust2.setOpaque(true);
        crust2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        crust2.setForeground(Color.RED);
        crust2.setFocusPainted(false);
        crust2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu2.setCrustType("Normal");

                crust1.setForeground(Color.WHITE);
                crust1.setBackground(Color.RED);
                crust1.setBorder(BorderFactory.createEmptyBorder());

                crust2.setForeground(Color.RED);
                crust2.setBackground(Color.WHITE);
                crust2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                crust3.setForeground(Color.WHITE);
                crust3.setBackground(Color.RED);
                crust3.setBorder(BorderFactory.createEmptyBorder());

                crust4.setForeground(Color.WHITE);
                crust4.setBackground(Color.RED);
                crust4.setBorder(BorderFactory.createEmptyBorder());
            }
        });
        selectionPanel.add(crust2);

        crust3.setFont(new Font("Times New Roman", Font.PLAIN, (int) 7.5));
        crust3.setBounds(202,500,50, 25);
        crust3.setBackground(Color.RED);
        crust3.setOpaque(true);
        crust3.setBorder(BorderFactory.createEmptyBorder());
        crust3.setForeground(Color.WHITE);
        crust3.setFocusPainted(false);
        crust3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu2.setCrustType("Cheese Stuffed");

                crust1.setForeground(Color.WHITE);
                crust1.setBackground(Color.RED);
                crust1.setBorder(BorderFactory.createEmptyBorder());

                crust2.setForeground(Color.WHITE);
                crust2.setBackground(Color.RED);
                crust2.setBorder(BorderFactory.createEmptyBorder());

                crust3.setForeground(Color.RED);
                crust3.setBackground(Color.WHITE);
                crust3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                crust4.setForeground(Color.WHITE);
                crust4.setBackground(Color.RED);
                crust4.setBorder(BorderFactory.createEmptyBorder());

            }
        });
        selectionPanel.add(crust3);

        crust4.setFont(new Font("Times New Roman", Font.PLAIN, 8));
        crust4.setBounds(253,500,50, 25);
        crust4.setBackground(Color.RED);
        crust4.setOpaque(true);
        crust4.setBorder(BorderFactory.createEmptyBorder());
        crust4.setForeground(Color.WHITE);
        crust4.setFocusPainted(false);
        crust4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu2.setCrustType("Gluten Free");

                crust1.setForeground(Color.WHITE);
                crust1.setBackground(Color.RED);
                crust1.setBorder(BorderFactory.createEmptyBorder());

                crust2.setForeground(Color.WHITE);
                crust2.setBackground(Color.RED);
                crust2.setBorder(BorderFactory.createEmptyBorder());

                crust3.setForeground(Color.WHITE);
                crust3.setBackground(Color.RED);
                crust3.setBorder(BorderFactory.createEmptyBorder());

                crust4.setForeground(Color.RED);
                crust4.setBackground(Color.WHITE);
                crust4.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            }
        });
        selectionPanel.add(crust4);


        AtomicInteger quant = new AtomicInteger(1);
        JLabel quantity = new JLabel(" "+quant.toString()+"  ");

        JButton plus = new JButton("+");
        plus.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        plus.setBounds(110,575,30, 25);
        plus.setBackground(Color.RED);
        plus.setOpaque(true);
        plus.setBorder(BorderFactory.createEmptyBorder());
        plus.setForeground(Color.WHITE);
        plus.setBorderPainted(false);
        plus.setFocusPainted(false);
        plus.addActionListener(new ActionListener() {

                                   @Override
                                   public void actionPerformed(ActionEvent e) {
                                       quant.incrementAndGet();
                                       quantity.setText(String.valueOf(quant.get()));
                                   }
                               }
        );

        selectionPanel.add(plus);

        JButton minus = new JButton("-");
        minus.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        minus.setBounds(30,575,30, 25);
        minus.setBackground(Color.RED);
        minus.setOpaque(true);
        minus.setBorder(BorderFactory.createEmptyBorder());
        minus.setForeground(Color.WHITE);
        minus.setBorderPainted(false);
        minus.setFocusPainted(false);
        minus.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (quant.get() == 1 ){
                    quant.set(Integer.valueOf(quant.get()));
                }else {
                    quant.decrementAndGet();
                    quantity.setText(String.valueOf(quant.get()));
                }

            }
        });
        selectionPanel.add(minus);



        quantity.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        quantity.setBounds(80,575,30, 25);
        quantity.setForeground(Color.red);
        selectionPanel.add(quantity);

        menu2.setQuantityy(quant.get());
        menu2.setImage("/Users/ekeneezeobi/IdeaProjects/PPD/src/philly_steak1.jpeg");

        JButton addToCart = new JButton("Add to Cart");
        addToCart.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        addToCart.setBounds(115,650,100, 25);
        addToCart.setBackground(Color.RED);
        addToCart.setOpaque(true);
        addToCart.setBorder(BorderFactory.createEmptyBorder());
        addToCart.setForeground(Color.WHITE);
        addToCart.setBorderPainted(false);
        addToCart.setFocusPainted(false);
        addToCart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if(menu2.getSize().equals("small")){
                    menu2.setPrice(5.99);
                } else if (menu2.getSize().equals("medium")) {
                    menu2.setPrice(7.99);
                } else if (menu2.getSize().equals("large")) {
                    menu2.setPrice(9.99);
                } else if (menu2.getSize().equals("extra large")) {
                    menu2.setPrice(12.99);
                }
                cartList.add(menu2);

            }
        });
        selectionPanel.add(addToCart);


        phillySteakPage.setVisible(true);
    }

    public static void buffalo(){
        //****** Buffalo Page ******#####################################################################################################################

        JFrame buffaloPage = new JFrame();
        buffaloPage.setLayout(null);
        JPanel panel1 = new JPanel();

        buffaloPage.setSize(350, 700);
        buffaloPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buffaloPage.add(panel1);

        panel1.setLayout(null);


        JPanel panel3_2 = new JPanel();
        panel3_2.setBounds(0,0,350, 599);
        panel3_2.setBackground(Color.WHITE);
        panel3_2.setLayout(null);
        buffaloPage.add(panel3_2);

        JPanel panel3_3 = new JPanel();
        panel3_3.setBounds(0,600,350, 100);
        panel3_3.setBackground(Color.WHITE);
        buffaloPage.add(panel3_3);

        ImageIcon icon1 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/home_icon.png");
        JButton home = new JButton(icon1);
        home.setBounds(0, 630, 40, 40);
        home.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                menu();
                buffaloPage.dispose();
            }
        });
        panel3_3.add(home);

        ImageIcon icon2 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/search_icon.png");
        JButton search = new JButton(icon2);
        search.setBounds(50, 630, 40, 40);
        search.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                search();
                buffaloPage.dispose();
            }
        });
        panel3_3.add(search);

        ImageIcon icon3 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/cart_icon.png");
        JButton cart = new JButton(icon3);
        cart.setBounds(100, 630, 40, 40);
        cart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cart();
            }
        });
        panel3_3.add(cart);

        ImageIcon icon4 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/account_icon.png");
        JButton account = new JButton(icon4);
        account.setBounds(150, 630, 40, 40);
        account.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                account();
                buffaloPage.dispose();
            }
        });
        panel3_3.add(account);

        ImageIcon food_icon = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/Buffalocopy.jpeg");
        JLabel food = new JLabel(food_icon);
        food.setBounds(0, 0, 350, 150);
        panel3_2.add(food);


        JPanel selectionPanel = new JPanel();
        selectionPanel.setPreferredSize(new Dimension(330, 800));
        selectionPanel.setLayout(null);
        selectionPanel.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(selectionPanel);
        scrollPane.setBounds(0, 150, 350, 550);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        panel3_2.add(scrollPane);
        buffaloPage.add(panel3_3);

        Product menu3 = new Product();
        menu3.setName("Buffalo Chicken Pizza");


        JLabel size = new JLabel("Size");
        size.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        size.setBounds(10,50,80, 25);
        size.setForeground(Color.RED);
        selectionPanel.add(size);


        JButton size4 = new JButton("x-Large");
        JButton size3 = new JButton("Large");
        JButton size2 = new JButton("Medium");
        JButton size1 = new JButton("Small");

        menu3.setCrustType("Normal");
        menu3.setSize("medium");


        size1.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        size1.setBounds(100,50,50, 25);
        size1.setBackground(Color.RED);
        size1.setOpaque(true);
        size1.setBorder(BorderFactory.createEmptyBorder());
        size1.setForeground(Color.WHITE);
        size1.setFocusPainted(false);
        size1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu3.setSize("small");

                size1.setForeground(Color.RED);
                size1.setBackground(Color.WHITE);
                size1.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                size2.setForeground(Color.WHITE);
                size2.setBackground(Color.RED);
                size2.setBorder(BorderFactory.createEmptyBorder());

                size3.setForeground(Color.WHITE);
                size3.setBackground(Color.RED);
                size3.setBorder(BorderFactory.createEmptyBorder());

                size4.setForeground(Color.WHITE);
                size4.setBackground(Color.RED);
                size4.setBorder(BorderFactory.createEmptyBorder());

            }
        });
        selectionPanel.add(size1);

        size2.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        size2.setBounds(151,50,50, 25);
        size2.setBackground(Color.WHITE);
        size2.setOpaque(true);
        size2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        size2.setForeground(Color.RED);
        size2.setFocusPainted(false);
        size2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu3.setSize("medium");

                size1.setForeground(Color.WHITE);
                size1.setBackground(Color.RED);
                size1.setBorder(BorderFactory.createEmptyBorder());

                size2.setForeground(Color.RED);
                size2.setBackground(Color.WHITE);
                size2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                size3.setForeground(Color.WHITE);
                size3.setBackground(Color.RED);
                size3.setBorder(BorderFactory.createEmptyBorder());

                size4.setForeground(Color.WHITE);
                size4.setBackground(Color.RED);
                size4.setBorder(BorderFactory.createEmptyBorder());
            }
        });
        selectionPanel.add(size2);

        size3.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        size3.setBounds(202,50,50, 25);
        size3.setBackground(Color.RED);
        size3.setOpaque(true);
        size3.setBorder(BorderFactory.createEmptyBorder());
        size3.setForeground(Color.WHITE);
        size3.setFocusPainted(false);
        size3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu3.setSize("large");

                size1.setForeground(Color.WHITE);
                size1.setBackground(Color.RED);
                size1.setBorder(BorderFactory.createEmptyBorder());

                size2.setForeground(Color.WHITE);
                size2.setBackground(Color.RED);
                size2.setBorder(BorderFactory.createEmptyBorder());

                size3.setForeground(Color.RED);
                size3.setBackground(Color.WHITE);
                size3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                size4.setForeground(Color.WHITE);
                size4.setBackground(Color.RED);
                size4.setBorder(BorderFactory.createEmptyBorder());

            }
        });
        selectionPanel.add(size3);

        size4.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        size4.setBounds(253,50,50, 25);
        size4.setBackground(Color.RED);
        size4.setOpaque(true);
        size4.setBorder(BorderFactory.createEmptyBorder());
        size4.setForeground(Color.WHITE);
        size4.setFocusPainted(false);
        size4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu3.setSize("extra large");

                size1.setForeground(Color.WHITE);
                size1.setBackground(Color.RED);
                size1.setBorder(BorderFactory.createEmptyBorder());

                size2.setForeground(Color.WHITE);
                size2.setBackground(Color.RED);
                size2.setBorder(BorderFactory.createEmptyBorder());

                size3.setForeground(Color.WHITE);
                size3.setBackground(Color.RED);
                size3.setBorder(BorderFactory.createEmptyBorder());

                size4.setForeground(Color.RED);
                size4.setBackground(Color.WHITE);
                size4.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            }
        });
        selectionPanel.add(size4);

        JLabel chicken =new JLabel("Chicken");
        chicken.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        chicken.setBounds(10,100,80, 25);
        chicken.setForeground(Color.RED);
        selectionPanel.add(chicken);


        JButton chicken3 = new JButton("✓");

        JButton chicken2 = new JButton("✗");
        chicken2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        chicken2.setBounds(151,100,50, 25);
        chicken2.setOpaque(true);
        chicken2.setBorder(BorderFactory.createEmptyBorder());
        chicken2.setFocusPainted(false);
        chicken2.setBackground(Color.WHITE);
        chicken2.setForeground(Color.RED);
        chicken2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        chicken2.addActionListener(new ActionListener() {

                                       @Override
                                       public void actionPerformed(ActionEvent e) {

                                           if(menu3.topping.contains("chicken")){
                                               menu3.topping.remove("chicken");
                                           }

                                           chicken2.setBackground(Color.WHITE);
                                           chicken2.setForeground(Color.RED);
                                           chicken2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                           chicken3.setBackground(Color.RED);
                                           chicken3.setForeground(Color.WHITE);
                                           chicken3.setBorder(BorderFactory.createEmptyBorder());

                                       }
                                   }
        );
        selectionPanel.add(chicken2);

        chicken3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        chicken3.setBounds(202,100,50, 25);
        chicken3.setBackground(Color.RED);
        chicken3.setOpaque(true);
        chicken3.setBorder(BorderFactory.createEmptyBorder());
        chicken3.setForeground(Color.WHITE);
        chicken3.setFocusPainted(false);
        chicken3.addActionListener(new ActionListener() {

                                       @Override
                                       public void actionPerformed(ActionEvent e) {

                                           //if (menutopping.get(4) == null){
                                           menu3.topping.add("chicken");

                                           chicken3.setBackground(Color.WHITE);
                                           chicken3.setForeground(Color.RED);
                                           chicken3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                           chicken2.setBackground(Color.RED);
                                           chicken2.setForeground(Color.WHITE);
                                           chicken2.setBorder(BorderFactory.createEmptyBorder());
                                           //}
                                       }
                                   }
        );
        selectionPanel.add(chicken3);


        JLabel bacon =new JLabel("Bacon");
        bacon.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        bacon.setBounds(10,150,80, 25);
        bacon.setForeground(Color.RED);
        selectionPanel.add(bacon);

        JButton bacon3 = new JButton("✓");
        JButton bacon2 = new JButton("✗");
        bacon2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        bacon2.setBounds(151,150,50, 25);
        bacon2.setBackground(Color.WHITE);
        bacon2.setOpaque(true);
        bacon2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        bacon2.setForeground(Color.RED);
        bacon2.setFocusPainted(false);
        bacon2.addActionListener(new ActionListener() {

                                     @Override
                                     public void actionPerformed(ActionEvent e) {

                                         if(menu3.topping.contains("bacon")){
                                             menu3.topping.remove("bacon");
                                         }

                                         bacon2.setBackground(Color.WHITE);
                                         bacon2.setForeground(Color.RED);
                                         bacon2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                         bacon3.setBackground(Color.RED);
                                         bacon3.setForeground(Color.WHITE);
                                         bacon3.setBorder(BorderFactory.createEmptyBorder());
                                         //}
                                     }
                                 }
        );
        selectionPanel.add(bacon2);

        bacon3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        bacon3.setBounds(202,150,50, 25);
        bacon3.setBackground(Color.RED);
        bacon3.setOpaque(true);
        bacon3.setBorder(BorderFactory.createEmptyBorder());
        bacon3.setForeground(Color.WHITE);
        bacon3.setFocusPainted(false);
        bacon3.addActionListener(new ActionListener() {

                                     @Override
                                     public void actionPerformed(ActionEvent e) {

                                         //if (menutopping.get(4) == null){
                                         menu3.topping.add("bacon");

                                         bacon3.setBackground(Color.WHITE);
                                         bacon3.setForeground(Color.RED);
                                         bacon3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                         bacon2.setBackground(Color.RED);
                                         bacon2.setForeground(Color.WHITE);
                                         bacon2.setBorder(BorderFactory.createEmptyBorder());
                                         //}
                                     }
                                 }
        );
        selectionPanel.add(bacon3);


        JLabel phillySteak =new JLabel("Philly Steak");
        phillySteak.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        phillySteak.setBounds(10,200,80, 25);
        phillySteak.setForeground(Color.RED);
        selectionPanel.add(phillySteak);


        JButton philly3 = new JButton("✓");
        JButton philly2 = new JButton("✗");
        philly2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        philly2.setBounds(151,200,50, 25);
        philly2.setBackground(Color.WHITE);
        philly2.setOpaque(true);
        philly2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        philly2.setForeground(Color.RED);
        philly2.setFocusPainted(false);
        philly2.addActionListener(new ActionListener() {

                                      @Override
                                      public void actionPerformed(ActionEvent e) {

                                          if(menu3.topping.contains("philly steak")){
                                              menu3.topping.remove("philly steak");
                                          }

                                          philly2.setBackground(Color.WHITE);
                                          philly2.setForeground(Color.RED);
                                          philly2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                          philly3.setBackground(Color.RED);
                                          philly3.setForeground(Color.WHITE);
                                          philly3.setBorder(BorderFactory.createEmptyBorder());

                                      }
                                  }
        );
        selectionPanel.add(philly2);

        philly3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        philly3.setBounds(202,200,50, 25);
        philly3.setBackground(Color.RED);
        philly3.setOpaque(true);
        philly3.setBorder(BorderFactory.createEmptyBorder());
        philly3.setForeground(Color.WHITE);
        philly3.setFocusPainted(false);
        philly3.addActionListener(new ActionListener() {

                                      @Override
                                      public void actionPerformed(ActionEvent e) {

                                          //if (menutopping.get(4) == null){
                                          menu3.topping.add("philly steak");

                                          philly3.setBackground(Color.WHITE);
                                          philly3.setForeground(Color.RED);
                                          philly3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                          philly2.setBackground(Color.RED);
                                          philly2.setForeground(Color.WHITE);
                                          philly2.setBorder(BorderFactory.createEmptyBorder());
                                          //}
                                      }
                                  }
        );
        selectionPanel.add(philly3);


        JLabel anchovies =new JLabel("Anchovies");
        anchovies.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        anchovies.setBounds(10,250,80, 25);
        anchovies.setForeground(Color.RED);
        selectionPanel.add(anchovies);



        JButton anchovies3 = new JButton("✓");
        JButton anchovies2 = new JButton("✗");
        anchovies2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        anchovies2.setBounds(151,250,50, 25);
        anchovies2.setBackground(Color.WHITE);
        anchovies2.setOpaque(true);
        anchovies2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        anchovies2.setForeground(Color.RED);
        anchovies2.setFocusPainted(false);
        anchovies2.addActionListener(new ActionListener() {

                                         @Override
                                         public void actionPerformed(ActionEvent e) {

                                             if(menu3.topping.contains("anchovies")){
                                                 menu3.topping.remove("anchovies");
                                             }

                                             anchovies2.setBackground(Color.WHITE);
                                             anchovies2.setForeground(Color.RED);
                                             anchovies2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                             anchovies3.setBackground(Color.RED);
                                             anchovies3.setForeground(Color.WHITE);
                                             anchovies3.setBorder(BorderFactory.createEmptyBorder());
                                             //}
                                         }
                                     }
        );
        selectionPanel.add(philly2);
        selectionPanel.add(anchovies2);

        anchovies3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        anchovies3.setBounds(202,250,50, 25);
        anchovies3.setBackground(Color.RED);
        anchovies3.setOpaque(true);
        anchovies3.setBorder(BorderFactory.createEmptyBorder());
        anchovies3.setForeground(Color.WHITE);
        anchovies3.setFocusPainted(false);
        anchovies3.addActionListener(new ActionListener() {

                                         @Override
                                         public void actionPerformed(ActionEvent e) {

                                             //if (menutopping.get(4) == null){
                                             menu3.topping.add("anchovies");

                                             anchovies3.setBackground(Color.WHITE);
                                             anchovies3.setForeground(Color.RED);
                                             anchovies3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                             anchovies2.setBackground(Color.RED);
                                             anchovies2.setForeground(Color.WHITE);
                                             anchovies2.setBorder(BorderFactory.createEmptyBorder());
                                             //}
                                         }
                                     }
        );
        selectionPanel.add(anchovies3);


        JLabel onions =new JLabel("Onions");
        onions.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        onions.setBounds(10,300,80, 25);
        onions.setForeground(Color.RED);
        selectionPanel.add(onions);



        JButton onion3 = new JButton("✓");
        JButton onion2 = new JButton("✗");
        onion2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        onion2.setBounds(151,300,50, 25);
        onion2.setBackground(Color.WHITE);
        onion2.setOpaque(true);
        onion2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        onion2.setForeground(Color.RED);
        onion2.setFocusPainted(false);
        onion2.addActionListener(new ActionListener() {

                                     @Override
                                     public void actionPerformed(ActionEvent e) {

                                         if(menu3.topping.contains("onions")){
                                             menu3.topping.remove("onions");
                                         }
                                         onion2.setBackground(Color.WHITE);
                                         onion2.setForeground(Color.RED);
                                         onion2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                         onion3.setBackground(Color.RED);
                                         onion3.setForeground(Color.WHITE);
                                         onion3.setBorder(BorderFactory.createEmptyBorder());

                                     }
                                 }
        );
        selectionPanel.add(onion2);

        onion3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        onion3.setBounds(202,300,50, 25);
        onion3.setBackground(Color.RED);
        onion3.setOpaque(true);
        onion3.setBorder(BorderFactory.createEmptyBorder());
        onion3.setForeground(Color.WHITE);
        onion3.setFocusPainted(false);
        onion3.addActionListener(new ActionListener() {

                                     @Override
                                     public void actionPerformed(ActionEvent e) {

                                         //if (menutopping.get(4) == null){
                                         menu3.topping.add("onion");

                                         onion3.setBackground(Color.WHITE);
                                         onion3.setForeground(Color.RED);
                                         onion3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                         onion2.setBackground(Color.RED);
                                         onion2.setForeground(Color.WHITE);
                                         onion2.setBorder(BorderFactory.createEmptyBorder());
                                         //}
                                     }
                                 }
        );
        selectionPanel.add(onion3);



        JLabel olives =new JLabel("Olives");
        olives.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        olives.setBounds(10,350,80, 25);
        olives.setForeground(Color.RED);
        selectionPanel.add(olives);



        JButton olives3 = new JButton("✓");
        JButton olives2 = new JButton("✗");
        olives2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        olives2.setBounds(151,350,50, 25);
        olives2.setBackground(Color.WHITE);
        olives2.setOpaque(true);
        olives2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        olives2.setForeground(Color.RED);
        olives2.setFocusPainted(false);
        olives2.addActionListener(new ActionListener() {

                                      @Override
                                      public void actionPerformed(ActionEvent e) {

                                          if(menu3.topping.contains("olives")){
                                              menu3.topping.remove("olives");
                                          }

                                          olives2.setBackground(Color.WHITE);
                                          olives2.setForeground(Color.RED);
                                          olives2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                          olives3.setBackground(Color.RED);
                                          olives3.setForeground(Color.WHITE);
                                          olives3.setBorder(BorderFactory.createEmptyBorder());
                                      }
                                  }
        );
        selectionPanel.add(olives2);

        olives3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        olives3.setBounds(202,350,50, 25);
        olives3.setBackground(Color.RED);
        olives3.setOpaque(true);
        olives3.setBorder(BorderFactory.createEmptyBorder());
        olives3.setForeground(Color.WHITE);
        olives3.setFocusPainted(false);
        olives3.addActionListener(new ActionListener() {

                                      @Override
                                      public void actionPerformed(ActionEvent e) {

                                          //if (menutopping.get(4) == null){
                                          menu3.topping.add("olives");

                                          olives3.setBackground(Color.WHITE);
                                          olives3.setForeground(Color.RED);
                                          olives3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                          olives2.setBackground(Color.RED);
                                          olives2.setForeground(Color.WHITE);
                                          olives2.setBorder(BorderFactory.createEmptyBorder());
                                          //}
                                      }
                                  }
        );
        selectionPanel.add(olives3);


        JLabel cheese =new JLabel("Cheese");
        cheese.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        cheese.setBounds(10,400,80, 25);
        cheese.setForeground(Color.RED);
        selectionPanel.add(cheese);


        JButton cheese3 = new JButton("✓");
        JButton cheese2 = new JButton("✗");
        cheese2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        cheese2.setBounds(151,400,50, 25);
        cheese2.setBackground(Color.WHITE);
        cheese2.setOpaque(true);
        cheese2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        cheese2.setForeground(Color.RED);
        cheese2.setFocusPainted(false);
        cheese2.addActionListener(new ActionListener() {

                                      @Override
                                      public void actionPerformed(ActionEvent e) {
                                          if(menu3.topping.contains("cheese")){
                                              menu3.topping.remove("cheese");
                                          }

                                          cheese2.setBackground(Color.WHITE);
                                          cheese2.setForeground(Color.RED);
                                          cheese2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                          cheese3.setBackground(Color.RED);
                                          cheese3.setForeground(Color.WHITE);
                                          cheese3.setBorder(BorderFactory.createEmptyBorder());
                                      }
                                  }
        );
        selectionPanel.add(cheese2);

        cheese3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        cheese3.setBounds(202,400,50, 25);
        cheese3.setBackground(Color.RED);
        cheese3.setOpaque(true);
        cheese3.setBorder(BorderFactory.createEmptyBorder());
        cheese3.setForeground(Color.WHITE);
        cheese3.setFocusPainted(false);
        cheese3.addActionListener(new ActionListener() {

                                      @Override
                                      public void actionPerformed(ActionEvent e) {

                                          //if (menutopping.get(4) == null){
                                          menu3.topping.add("cheese");

                                          cheese3.setBackground(Color.WHITE);
                                          cheese3.setForeground(Color.RED);
                                          cheese3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                          cheese2.setBackground(Color.RED);
                                          cheese2.setForeground(Color.WHITE);
                                          cheese2.setBorder(BorderFactory.createEmptyBorder());
                                          //}
                                      }
                                  }
        );
        selectionPanel.add(cheese3);



        JLabel mushroom =new JLabel("Mushroom");
        mushroom.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        mushroom.setBounds(10,450,80, 25);
        mushroom.setForeground(Color.RED);
        selectionPanel.add(mushroom);


        JButton mushroom3 = new JButton("✓");
        JButton mushroom2 = new JButton("✗");
        mushroom2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        mushroom2.setBounds(151,450,50, 25);
        mushroom2.setBackground(Color.WHITE);
        mushroom2.setOpaque(true);
        mushroom2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        mushroom2.setForeground(Color.RED);
        mushroom2.setFocusPainted(false);
        mushroom2.addActionListener(new ActionListener() {

                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            if(menu3.topping.contains("mushroom")){
                                                menu3.topping.remove("mushroom");
                                            }

                                            mushroom2.setBackground(Color.WHITE);
                                            mushroom2.setForeground(Color.RED);
                                            mushroom2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                            mushroom3.setBackground(Color.RED);
                                            mushroom3.setForeground(Color.WHITE);
                                            mushroom3.setBorder(BorderFactory.createEmptyBorder());
                                        }
                                    }
        );
        selectionPanel.add(mushroom2);

        mushroom3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        mushroom3.setBounds(202,450,50, 25);
        mushroom3.setBackground(Color.RED);
        mushroom3.setOpaque(true);
        mushroom3.setBorder(BorderFactory.createEmptyBorder());
        mushroom3.setForeground(Color.WHITE);
        mushroom3.setFocusPainted(false);
        mushroom3.addActionListener(new ActionListener() {

                                        @Override
                                        public void actionPerformed(ActionEvent e) {

                                            //if (menutopping.get(4) == null){
                                            menu3.topping.add("mushroom");

                                            mushroom3.setBackground(Color.WHITE);
                                            mushroom3.setForeground(Color.RED);
                                            mushroom3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                            mushroom2.setBackground(Color.RED);
                                            mushroom2.setForeground(Color.WHITE);
                                            mushroom2.setBorder(BorderFactory.createEmptyBorder());
                                            //}
                                        }
                                    }
        );
        selectionPanel.add(mushroom3);


        JLabel crust =new JLabel("Crust");
        crust.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        crust.setBounds(10,500,80, 25);
        crust.setForeground(Color.RED);
        selectionPanel.add(crust);

        JButton crust4 = new JButton("Gluten Free");
        JButton crust3 = new JButton("Cheese Stuffed");
        JButton crust2 = new JButton("Normal");
        JButton crust1 = new JButton("Thin");
        crust1.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        crust1.setBounds(100,500,50, 25);
        crust1.setBackground(Color.RED);
        crust1.setOpaque(true);
        crust1.setBorder(BorderFactory.createEmptyBorder());
        crust1.setForeground(Color.WHITE);
        crust1.setFocusPainted(false);
        crust1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu3.setCrustType("Thin");

                crust1.setForeground(Color.RED);
                crust1.setBackground(Color.WHITE);
                crust1.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                crust2.setForeground(Color.WHITE);
                crust2.setBackground(Color.RED);
                crust2.setBorder(BorderFactory.createEmptyBorder());

                crust3.setForeground(Color.WHITE);
                crust3.setBackground(Color.RED);
                crust3.setBorder(BorderFactory.createEmptyBorder());

                crust4.setForeground(Color.WHITE);
                crust4.setBackground(Color.RED);
                crust4.setBorder(BorderFactory.createEmptyBorder());

            }
        });
        selectionPanel.add(crust1);

        crust2.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        crust2.setBounds(151,500,50, 25);
        crust2.setBackground(Color.WHITE);
        crust2.setOpaque(true);
        crust2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        crust2.setForeground(Color.RED);
        crust2.setFocusPainted(false);
        crust2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu3.setCrustType("Normal");

                crust1.setForeground(Color.WHITE);
                crust1.setBackground(Color.RED);
                crust1.setBorder(BorderFactory.createEmptyBorder());

                crust2.setForeground(Color.RED);
                crust2.setBackground(Color.WHITE);
                crust2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                crust3.setForeground(Color.WHITE);
                crust3.setBackground(Color.RED);
                crust3.setBorder(BorderFactory.createEmptyBorder());

                crust4.setForeground(Color.WHITE);
                crust4.setBackground(Color.RED);
                crust4.setBorder(BorderFactory.createEmptyBorder());
            }
        });
        selectionPanel.add(crust2);

        crust3.setFont(new Font("Times New Roman", Font.PLAIN, (int) 7.5));
        crust3.setBounds(202,500,50, 25);
        crust3.setBackground(Color.RED);
        crust3.setOpaque(true);
        crust3.setBorder(BorderFactory.createEmptyBorder());
        crust3.setForeground(Color.WHITE);
        crust3.setFocusPainted(false);
        crust3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu3.setCrustType("Cheese Stuffed");

                crust1.setForeground(Color.WHITE);
                crust1.setBackground(Color.RED);
                crust1.setBorder(BorderFactory.createEmptyBorder());

                crust2.setForeground(Color.WHITE);
                crust2.setBackground(Color.RED);
                crust2.setBorder(BorderFactory.createEmptyBorder());

                crust3.setForeground(Color.RED);
                crust3.setBackground(Color.WHITE);
                crust3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                crust4.setForeground(Color.WHITE);
                crust4.setBackground(Color.RED);
                crust4.setBorder(BorderFactory.createEmptyBorder());

            }
        });
        selectionPanel.add(crust3);

        crust4.setFont(new Font("Times New Roman", Font.PLAIN, 8));
        crust4.setBounds(253,500,50, 25);
        crust4.setBackground(Color.RED);
        crust4.setOpaque(true);
        crust4.setBorder(BorderFactory.createEmptyBorder());
        crust4.setForeground(Color.WHITE);
        crust4.setFocusPainted(false);
        crust4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu3.setCrustType("Gluten Free");

                crust1.setForeground(Color.WHITE);
                crust1.setBackground(Color.RED);
                crust1.setBorder(BorderFactory.createEmptyBorder());

                crust2.setForeground(Color.WHITE);
                crust2.setBackground(Color.RED);
                crust2.setBorder(BorderFactory.createEmptyBorder());

                crust3.setForeground(Color.WHITE);
                crust3.setBackground(Color.RED);
                crust3.setBorder(BorderFactory.createEmptyBorder());

                crust4.setForeground(Color.RED);
                crust4.setBackground(Color.WHITE);
                crust4.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            }
        });
        selectionPanel.add(crust4);


        AtomicInteger quant = new AtomicInteger(1);
        JLabel quantity = new JLabel(" "+quant.toString()+"  ");

        JButton plus = new JButton("+");
        plus.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        plus.setBounds(110,575,30, 25);
        plus.setBackground(Color.RED);
        plus.setOpaque(true);
        plus.setBorder(BorderFactory.createEmptyBorder());
        plus.setForeground(Color.WHITE);
        plus.setBorderPainted(false);
        plus.setFocusPainted(false);
        plus.addActionListener(new ActionListener() {

                                   @Override
                                   public void actionPerformed(ActionEvent e) {
                                       quant.incrementAndGet();
                                       quantity.setText(String.valueOf(quant.get()));
                                   }
                               }
        );

        selectionPanel.add(plus);

        JButton minus = new JButton("-");
        minus.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        minus.setBounds(30,575,30, 25);
        minus.setBackground(Color.RED);
        minus.setOpaque(true);
        minus.setBorder(BorderFactory.createEmptyBorder());
        minus.setForeground(Color.WHITE);
        minus.setBorderPainted(false);
        minus.setFocusPainted(false);
        minus.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (quant.get() == 1 ){
                    quant.set(Integer.valueOf(quant.get()));
                }else {
                    quant.decrementAndGet();
                    quantity.setText(String.valueOf(quant.get()));
                }

            }
        });
        selectionPanel.add(minus);



        quantity.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        quantity.setBounds(80,575,30, 25);
        quantity.setForeground(Color.red);
        selectionPanel.add(quantity);

        menu3.setQuantityy(quant.get());
        menu3.setImage("/Users/ekeneezeobi/IdeaProjects/PPD/src/Buffalo1.jpeg");

        JButton addToCart = new JButton("Add to Cart");
        addToCart.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        addToCart.setBounds(115,650,100, 25);
        addToCart.setBackground(Color.RED);
        addToCart.setOpaque(true);
        addToCart.setBorder(BorderFactory.createEmptyBorder());
        addToCart.setForeground(Color.WHITE);
        addToCart.setBorderPainted(false);
        addToCart.setFocusPainted(false);
        addToCart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if(menu3.getSize().equals("small")){
                    menu3.setPrice(5.99);
                } else if (menu3.getSize().equals("medium")) {
                    menu3.setPrice(7.99);
                } else if (menu3.getSize().equals("large")) {
                    menu3.setPrice(9.99);
                } else if (menu3.getSize().equals("extra large")) {
                    menu3.setPrice(12.99);
                }
                cartList.add(menu3);

            }
        });
        selectionPanel.add(addToCart);

        buffaloPage.setVisible(true);

    }

    public static void spinachFeta(){
        //****** Spinach & Feta Page ******#####################################################################################################################

        JFrame spinachFetaPage = new JFrame();
        spinachFetaPage.setLayout(null);
        JPanel panel1 = new JPanel();

        spinachFetaPage.setSize(350, 700);
        spinachFetaPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        spinachFetaPage.add(panel1);

        panel1.setLayout(null);


        JPanel panel3_2 = new JPanel();
        panel3_2.setBounds(0,0,350, 599);
        panel3_2.setBackground(Color.WHITE);
        panel3_2.setLayout(null);
        spinachFetaPage.add(panel3_2);

        JPanel panel3_3 = new JPanel();
        panel3_3.setBounds(0,600,350, 100);
        panel3_3.setBackground(Color.WHITE);
        spinachFetaPage.add(panel3_3);

        ImageIcon icon1 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/home_icon.png");
        JButton home = new JButton(icon1);
        home.setBounds(0, 630, 40, 40);
        home.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                menu();
                spinachFetaPage.dispose();
            }
        });
        panel3_3.add(home);

        ImageIcon icon2 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/search_icon.png");
        JButton search = new JButton(icon2);
        search.setBounds(50, 630, 40, 40);
        search.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                search();
                spinachFetaPage.dispose();
            }
        });
        panel3_3.add(search);

        ImageIcon icon3 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/cart_icon.png");
        JButton cart = new JButton(icon3);
        cart.setBounds(100, 630, 40, 40);
        cart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cart();
            }
        });
        panel3_3.add(cart);

        ImageIcon icon4 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/account_icon.png");
        JButton account = new JButton(icon4);
        account.setBounds(150, 630, 40, 40);
        account.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                account();
                spinachFetaPage.dispose();
            }
        });
        panel3_3.add(account);

        ImageIcon food_icon = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/spinach&fetacopy.jpeg");
        JLabel food = new JLabel(food_icon);
        food.setBounds(0, 0, 350, 150);
        panel3_2.add(food);



        JPanel selectionPanel = new JPanel();
        selectionPanel.setPreferredSize(new Dimension(330, 800));
        selectionPanel.setLayout(null);
        selectionPanel.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(selectionPanel);
        scrollPane.setBounds(0, 150, 350, 550);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        panel3_2.add(scrollPane);
        spinachFetaPage.add(panel3_3);

        Product menu4 = new Product();
        menu4.setName("Spinach and Feta Pizza");

        JLabel size = new JLabel("Size");
        size.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        size.setBounds(10,50,80, 25);
        size.setForeground(Color.RED);
        selectionPanel.add(size);


        JButton size4 = new JButton("x-Large");
        JButton size3 = new JButton("Large");
        JButton size2 = new JButton("Medium");
        JButton size1 = new JButton("Small");

        menu4.setCrustType("Normal");
        menu4.setSize("medium");


        size1.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        size1.setBounds(100,50,50, 25);
        size1.setBackground(Color.RED);
        size1.setOpaque(true);
        size1.setBorder(BorderFactory.createEmptyBorder());
        size1.setForeground(Color.WHITE);
        size1.setFocusPainted(false);
        size1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu4.setSize("small");

                size1.setForeground(Color.RED);
                size1.setBackground(Color.WHITE);
                size1.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                size2.setForeground(Color.WHITE);
                size2.setBackground(Color.RED);
                size2.setBorder(BorderFactory.createEmptyBorder());

                size3.setForeground(Color.WHITE);
                size3.setBackground(Color.RED);
                size3.setBorder(BorderFactory.createEmptyBorder());

                size4.setForeground(Color.WHITE);
                size4.setBackground(Color.RED);
                size4.setBorder(BorderFactory.createEmptyBorder());

            }
        });
        selectionPanel.add(size1);

        size2.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        size2.setBounds(151,50,50, 25);
        size2.setBackground(Color.WHITE);
        size2.setOpaque(true);
        size2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        size2.setForeground(Color.RED);
        size2.setFocusPainted(false);
        size2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu4.setSize("medium");

                size1.setForeground(Color.WHITE);
                size1.setBackground(Color.RED);
                size1.setBorder(BorderFactory.createEmptyBorder());

                size2.setForeground(Color.RED);
                size2.setBackground(Color.WHITE);
                size2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                size3.setForeground(Color.WHITE);
                size3.setBackground(Color.RED);
                size3.setBorder(BorderFactory.createEmptyBorder());

                size4.setForeground(Color.WHITE);
                size4.setBackground(Color.RED);
                size4.setBorder(BorderFactory.createEmptyBorder());
            }
        });
        selectionPanel.add(size2);

        size3.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        size3.setBounds(202,50,50, 25);
        size3.setBackground(Color.RED);
        size3.setOpaque(true);
        size3.setBorder(BorderFactory.createEmptyBorder());
        size3.setForeground(Color.WHITE);
        size3.setFocusPainted(false);
        size3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu4.setSize("large");

                size1.setForeground(Color.WHITE);
                size1.setBackground(Color.RED);
                size1.setBorder(BorderFactory.createEmptyBorder());

                size2.setForeground(Color.WHITE);
                size2.setBackground(Color.RED);
                size2.setBorder(BorderFactory.createEmptyBorder());

                size3.setForeground(Color.RED);
                size3.setBackground(Color.WHITE);
                size3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                size4.setForeground(Color.WHITE);
                size4.setBackground(Color.RED);
                size4.setBorder(BorderFactory.createEmptyBorder());

            }
        });
        selectionPanel.add(size3);

        size4.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        size4.setBounds(253,50,50, 25);
        size4.setBackground(Color.RED);
        size4.setOpaque(true);
        size4.setBorder(BorderFactory.createEmptyBorder());
        size4.setForeground(Color.WHITE);
        size4.setFocusPainted(false);
        size4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu4.setSize("extra large");

                size1.setForeground(Color.WHITE);
                size1.setBackground(Color.RED);
                size1.setBorder(BorderFactory.createEmptyBorder());

                size2.setForeground(Color.WHITE);
                size2.setBackground(Color.RED);
                size2.setBorder(BorderFactory.createEmptyBorder());

                size3.setForeground(Color.WHITE);
                size3.setBackground(Color.RED);
                size3.setBorder(BorderFactory.createEmptyBorder());

                size4.setForeground(Color.RED);
                size4.setBackground(Color.WHITE);
                size4.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            }
        });
        selectionPanel.add(size4);

        JLabel chicken =new JLabel("Chicken");
        chicken.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        chicken.setBounds(10,100,80, 25);
        chicken.setForeground(Color.RED);
        selectionPanel.add(chicken);


        JButton chicken3 = new JButton("✓");

        JButton chicken2 = new JButton("✗");
        chicken2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        chicken2.setBounds(151,100,50, 25);
        chicken2.setOpaque(true);
        chicken2.setBorder(BorderFactory.createEmptyBorder());
        chicken2.setFocusPainted(false);
        chicken2.setBackground(Color.WHITE);
        chicken2.setForeground(Color.RED);
        chicken2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        chicken2.addActionListener(new ActionListener() {

                                       @Override
                                       public void actionPerformed(ActionEvent e) {

                                           if(menu4.topping.contains("chicken")){
                                               menu4.topping.remove("chicken");
                                           }

                                           chicken2.setBackground(Color.WHITE);
                                           chicken2.setForeground(Color.RED);
                                           chicken2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                           chicken3.setBackground(Color.RED);
                                           chicken3.setForeground(Color.WHITE);
                                           chicken3.setBorder(BorderFactory.createEmptyBorder());

                                       }
                                   }
        );
        selectionPanel.add(chicken2);

        chicken3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        chicken3.setBounds(202,100,50, 25);
        chicken3.setBackground(Color.RED);
        chicken3.setOpaque(true);
        chicken3.setBorder(BorderFactory.createEmptyBorder());
        chicken3.setForeground(Color.WHITE);
        chicken3.setFocusPainted(false);
        chicken3.addActionListener(new ActionListener() {

                                       @Override
                                       public void actionPerformed(ActionEvent e) {

                                           //if (menutopping.get(4) == null){
                                           menu4.topping.add("chicken");

                                           chicken3.setBackground(Color.WHITE);
                                           chicken3.setForeground(Color.RED);
                                           chicken3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                           chicken2.setBackground(Color.RED);
                                           chicken2.setForeground(Color.WHITE);
                                           chicken2.setBorder(BorderFactory.createEmptyBorder());
                                           //}
                                       }
                                   }
        );
        selectionPanel.add(chicken3);


        JLabel bacon =new JLabel("Bacon");
        bacon.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        bacon.setBounds(10,150,80, 25);
        bacon.setForeground(Color.RED);
        selectionPanel.add(bacon);

        JButton bacon3 = new JButton("✓");
        JButton bacon2 = new JButton("✗");
        bacon2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        bacon2.setBounds(151,150,50, 25);
        bacon2.setBackground(Color.WHITE);
        bacon2.setOpaque(true);
        bacon2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        bacon2.setForeground(Color.RED);
        bacon2.setFocusPainted(false);
        bacon2.addActionListener(new ActionListener() {

                                     @Override
                                     public void actionPerformed(ActionEvent e) {

                                         if(menu4.topping.contains("bacon")){
                                             menu4.topping.remove("bacon");
                                         }

                                         bacon2.setBackground(Color.WHITE);
                                         bacon2.setForeground(Color.RED);
                                         bacon2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                         bacon3.setBackground(Color.RED);
                                         bacon3.setForeground(Color.WHITE);
                                         bacon3.setBorder(BorderFactory.createEmptyBorder());
                                         //}
                                     }
                                 }
        );
        selectionPanel.add(bacon2);

        bacon3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        bacon3.setBounds(202,150,50, 25);
        bacon3.setBackground(Color.RED);
        bacon3.setOpaque(true);
        bacon3.setBorder(BorderFactory.createEmptyBorder());
        bacon3.setForeground(Color.WHITE);
        bacon3.setFocusPainted(false);
        bacon3.addActionListener(new ActionListener() {

                                     @Override
                                     public void actionPerformed(ActionEvent e) {

                                         //if (menutopping.get(4) == null){
                                         menu4.topping.add("bacon");

                                         bacon3.setBackground(Color.WHITE);
                                         bacon3.setForeground(Color.RED);
                                         bacon3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                         bacon2.setBackground(Color.RED);
                                         bacon2.setForeground(Color.WHITE);
                                         bacon2.setBorder(BorderFactory.createEmptyBorder());
                                         //}
                                     }
                                 }
        );
        selectionPanel.add(bacon3);


        JLabel phillySteak =new JLabel("Philly Steak");
        phillySteak.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        phillySteak.setBounds(10,200,80, 25);
        phillySteak.setForeground(Color.RED);
        selectionPanel.add(phillySteak);


        JButton philly3 = new JButton("✓");
        JButton philly2 = new JButton("✗");
        philly2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        philly2.setBounds(151,200,50, 25);
        philly2.setBackground(Color.WHITE);
        philly2.setOpaque(true);
        philly2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        philly2.setForeground(Color.RED);
        philly2.setFocusPainted(false);
        philly2.addActionListener(new ActionListener() {

                                      @Override
                                      public void actionPerformed(ActionEvent e) {

                                          if(menu4.topping.contains("philly steak")){
                                              menu4.topping.remove("philly steak");
                                          }

                                          philly2.setBackground(Color.WHITE);
                                          philly2.setForeground(Color.RED);
                                          philly2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                          philly3.setBackground(Color.RED);
                                          philly3.setForeground(Color.WHITE);
                                          philly3.setBorder(BorderFactory.createEmptyBorder());

                                      }
                                  }
        );
        selectionPanel.add(philly2);

        philly3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        philly3.setBounds(202,200,50, 25);
        philly3.setBackground(Color.RED);
        philly3.setOpaque(true);
        philly3.setBorder(BorderFactory.createEmptyBorder());
        philly3.setForeground(Color.WHITE);
        philly3.setFocusPainted(false);
        philly3.addActionListener(new ActionListener() {

                                      @Override
                                      public void actionPerformed(ActionEvent e) {

                                          //if (menutopping.get(4) == null){
                                          menu4.topping.add("philly steak");

                                          philly3.setBackground(Color.WHITE);
                                          philly3.setForeground(Color.RED);
                                          philly3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                          philly2.setBackground(Color.RED);
                                          philly2.setForeground(Color.WHITE);
                                          philly2.setBorder(BorderFactory.createEmptyBorder());
                                          //}
                                      }
                                  }
        );
        selectionPanel.add(philly3);


        JLabel anchovies =new JLabel("Anchovies");
        anchovies.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        anchovies.setBounds(10,250,80, 25);
        anchovies.setForeground(Color.RED);
        selectionPanel.add(anchovies);



        JButton anchovies3 = new JButton("✓");
        JButton anchovies2 = new JButton("✗");
        anchovies2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        anchovies2.setBounds(151,250,50, 25);
        anchovies2.setBackground(Color.WHITE);
        anchovies2.setOpaque(true);
        anchovies2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        anchovies2.setForeground(Color.RED);
        anchovies2.setFocusPainted(false);
        anchovies2.addActionListener(new ActionListener() {

                                         @Override
                                         public void actionPerformed(ActionEvent e) {

                                             if(menu4.topping.contains("anchovies")){
                                                 menu4.topping.remove("anchovies");
                                             }

                                             anchovies2.setBackground(Color.WHITE);
                                             anchovies2.setForeground(Color.RED);
                                             anchovies2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                             anchovies3.setBackground(Color.RED);
                                             anchovies3.setForeground(Color.WHITE);
                                             anchovies3.setBorder(BorderFactory.createEmptyBorder());
                                             //}
                                         }
                                     }
        );
        selectionPanel.add(philly2);
        selectionPanel.add(anchovies2);

        anchovies3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        anchovies3.setBounds(202,250,50, 25);
        anchovies3.setBackground(Color.RED);
        anchovies3.setOpaque(true);
        anchovies3.setBorder(BorderFactory.createEmptyBorder());
        anchovies3.setForeground(Color.WHITE);
        anchovies3.setFocusPainted(false);
        anchovies3.addActionListener(new ActionListener() {

                                         @Override
                                         public void actionPerformed(ActionEvent e) {

                                             //if (menutopping.get(4) == null){
                                             menu4.topping.add("anchovies");

                                             anchovies3.setBackground(Color.WHITE);
                                             anchovies3.setForeground(Color.RED);
                                             anchovies3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                             anchovies2.setBackground(Color.RED);
                                             anchovies2.setForeground(Color.WHITE);
                                             anchovies2.setBorder(BorderFactory.createEmptyBorder());
                                             //}
                                         }
                                     }
        );
        selectionPanel.add(anchovies3);


        JLabel onions =new JLabel("Onions");
        onions.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        onions.setBounds(10,300,80, 25);
        onions.setForeground(Color.RED);
        selectionPanel.add(onions);



        JButton onion3 = new JButton("✓");
        JButton onion2 = new JButton("✗");
        onion2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        onion2.setBounds(151,300,50, 25);
        onion2.setBackground(Color.WHITE);
        onion2.setOpaque(true);
        onion2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        onion2.setForeground(Color.RED);
        onion2.setFocusPainted(false);
        onion2.addActionListener(new ActionListener() {

                                     @Override
                                     public void actionPerformed(ActionEvent e) {

                                         if(menu4.topping.contains("onions")){
                                             menu4.topping.remove("onions");
                                         }
                                         onion2.setBackground(Color.WHITE);
                                         onion2.setForeground(Color.RED);
                                         onion2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                         onion3.setBackground(Color.RED);
                                         onion3.setForeground(Color.WHITE);
                                         onion3.setBorder(BorderFactory.createEmptyBorder());

                                     }
                                 }
        );
        selectionPanel.add(onion2);

        onion3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        onion3.setBounds(202,300,50, 25);
        onion3.setBackground(Color.RED);
        onion3.setOpaque(true);
        onion3.setBorder(BorderFactory.createEmptyBorder());
        onion3.setForeground(Color.WHITE);
        onion3.setFocusPainted(false);
        onion3.addActionListener(new ActionListener() {

                                     @Override
                                     public void actionPerformed(ActionEvent e) {

                                         //if (menutopping.get(4) == null){
                                         menu4.topping.add("onion");

                                         onion3.setBackground(Color.WHITE);
                                         onion3.setForeground(Color.RED);
                                         onion3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                         onion2.setBackground(Color.RED);
                                         onion2.setForeground(Color.WHITE);
                                         onion2.setBorder(BorderFactory.createEmptyBorder());
                                         //}
                                     }
                                 }
        );
        selectionPanel.add(onion3);



        JLabel olives =new JLabel("Olives");
        olives.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        olives.setBounds(10,350,80, 25);
        olives.setForeground(Color.RED);
        selectionPanel.add(olives);



        JButton olives3 = new JButton("✓");
        JButton olives2 = new JButton("✗");
        olives2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        olives2.setBounds(151,350,50, 25);
        olives2.setBackground(Color.WHITE);
        olives2.setOpaque(true);
        olives2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        olives2.setForeground(Color.RED);
        olives2.setFocusPainted(false);
        olives2.addActionListener(new ActionListener() {

                                      @Override
                                      public void actionPerformed(ActionEvent e) {

                                          if(menu4.topping.contains("olives")){
                                              menu4.topping.remove("olives");
                                          }

                                          olives2.setBackground(Color.WHITE);
                                          olives2.setForeground(Color.RED);
                                          olives2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                          olives3.setBackground(Color.RED);
                                          olives3.setForeground(Color.WHITE);
                                          olives3.setBorder(BorderFactory.createEmptyBorder());
                                      }
                                  }
        );
        selectionPanel.add(olives2);

        olives3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        olives3.setBounds(202,350,50, 25);
        olives3.setBackground(Color.RED);
        olives3.setOpaque(true);
        olives3.setBorder(BorderFactory.createEmptyBorder());
        olives3.setForeground(Color.WHITE);
        olives3.setFocusPainted(false);
        olives3.addActionListener(new ActionListener() {

                                      @Override
                                      public void actionPerformed(ActionEvent e) {

                                          //if (menutopping.get(4) == null){
                                          menu4.topping.add("olives");

                                          olives3.setBackground(Color.WHITE);
                                          olives3.setForeground(Color.RED);
                                          olives3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                          olives2.setBackground(Color.RED);
                                          olives2.setForeground(Color.WHITE);
                                          olives2.setBorder(BorderFactory.createEmptyBorder());
                                          //}
                                      }
                                  }
        );
        selectionPanel.add(olives3);


        JLabel cheese =new JLabel("Cheese");
        cheese.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        cheese.setBounds(10,400,80, 25);
        cheese.setForeground(Color.RED);
        selectionPanel.add(cheese);


        JButton cheese3 = new JButton("✓");
        JButton cheese2 = new JButton("✗");
        cheese2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        cheese2.setBounds(151,400,50, 25);
        cheese2.setBackground(Color.WHITE);
        cheese2.setOpaque(true);
        cheese2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        cheese2.setForeground(Color.RED);
        cheese2.setFocusPainted(false);
        cheese2.addActionListener(new ActionListener() {

                                      @Override
                                      public void actionPerformed(ActionEvent e) {
                                          if(menu4.topping.contains("cheese")){
                                              menu4.topping.remove("cheese");
                                          }

                                          cheese2.setBackground(Color.WHITE);
                                          cheese2.setForeground(Color.RED);
                                          cheese2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                          cheese3.setBackground(Color.RED);
                                          cheese3.setForeground(Color.WHITE);
                                          cheese3.setBorder(BorderFactory.createEmptyBorder());
                                      }
                                  }
        );
        selectionPanel.add(cheese2);

        cheese3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        cheese3.setBounds(202,400,50, 25);
        cheese3.setBackground(Color.RED);
        cheese3.setOpaque(true);
        cheese3.setBorder(BorderFactory.createEmptyBorder());
        cheese3.setForeground(Color.WHITE);
        cheese3.setFocusPainted(false);
        cheese3.addActionListener(new ActionListener() {

                                      @Override
                                      public void actionPerformed(ActionEvent e) {

                                          //if (menutopping.get(4) == null){
                                          menu4.topping.add("cheese");

                                          cheese3.setBackground(Color.WHITE);
                                          cheese3.setForeground(Color.RED);
                                          cheese3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                          cheese2.setBackground(Color.RED);
                                          cheese2.setForeground(Color.WHITE);
                                          cheese2.setBorder(BorderFactory.createEmptyBorder());
                                          //}
                                      }
                                  }
        );
        selectionPanel.add(cheese3);



        JLabel mushroom =new JLabel("Mushroom");
        mushroom.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        mushroom.setBounds(10,450,80, 25);
        mushroom.setForeground(Color.RED);
        selectionPanel.add(mushroom);


        JButton mushroom3 = new JButton("✓");
        JButton mushroom2 = new JButton("✗");
        mushroom2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        mushroom2.setBounds(151,450,50, 25);
        mushroom2.setBackground(Color.WHITE);
        mushroom2.setOpaque(true);
        mushroom2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        mushroom2.setForeground(Color.RED);
        mushroom2.setFocusPainted(false);
        mushroom2.addActionListener(new ActionListener() {

                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            if(menu4.topping.contains("mushroom")){
                                                menu4.topping.remove("mushroom");
                                            }

                                            mushroom2.setBackground(Color.WHITE);
                                            mushroom2.setForeground(Color.RED);
                                            mushroom2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                            mushroom3.setBackground(Color.RED);
                                            mushroom3.setForeground(Color.WHITE);
                                            mushroom3.setBorder(BorderFactory.createEmptyBorder());
                                        }
                                    }
        );
        selectionPanel.add(mushroom2);

        mushroom3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        mushroom3.setBounds(202,450,50, 25);
        mushroom3.setBackground(Color.RED);
        mushroom3.setOpaque(true);
        mushroom3.setBorder(BorderFactory.createEmptyBorder());
        mushroom3.setForeground(Color.WHITE);
        mushroom3.setFocusPainted(false);
        mushroom3.addActionListener(new ActionListener() {

                                        @Override
                                        public void actionPerformed(ActionEvent e) {

                                            //if (menutopping.get(4) == null){
                                            menu4.topping.add("mushroom");

                                            mushroom3.setBackground(Color.WHITE);
                                            mushroom3.setForeground(Color.RED);
                                            mushroom3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                            mushroom2.setBackground(Color.RED);
                                            mushroom2.setForeground(Color.WHITE);
                                            mushroom2.setBorder(BorderFactory.createEmptyBorder());
                                            //}
                                        }
                                    }
        );
        selectionPanel.add(mushroom3);


        JLabel crust =new JLabel("Crust");
        crust.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        crust.setBounds(10,500,80, 25);
        crust.setForeground(Color.RED);
        selectionPanel.add(crust);

        JButton crust4 = new JButton("Gluten Free");
        JButton crust3 = new JButton("Cheese Stuffed");
        JButton crust2 = new JButton("Normal");
        JButton crust1 = new JButton("Thin");
        crust1.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        crust1.setBounds(100,500,50, 25);
        crust1.setBackground(Color.RED);
        crust1.setOpaque(true);
        crust1.setBorder(BorderFactory.createEmptyBorder());
        crust1.setForeground(Color.WHITE);
        crust1.setFocusPainted(false);
        crust1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu4.setCrustType("Thin");

                crust1.setForeground(Color.RED);
                crust1.setBackground(Color.WHITE);
                crust1.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                crust2.setForeground(Color.WHITE);
                crust2.setBackground(Color.RED);
                crust2.setBorder(BorderFactory.createEmptyBorder());

                crust3.setForeground(Color.WHITE);
                crust3.setBackground(Color.RED);
                crust3.setBorder(BorderFactory.createEmptyBorder());

                crust4.setForeground(Color.WHITE);
                crust4.setBackground(Color.RED);
                crust4.setBorder(BorderFactory.createEmptyBorder());

            }
        });
        selectionPanel.add(crust1);

        crust2.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        crust2.setBounds(151,500,50, 25);
        crust2.setBackground(Color.WHITE);
        crust2.setOpaque(true);
        crust2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        crust2.setForeground(Color.RED);
        crust2.setFocusPainted(false);
        crust2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu4.setCrustType("Normal");

                crust1.setForeground(Color.WHITE);
                crust1.setBackground(Color.RED);
                crust1.setBorder(BorderFactory.createEmptyBorder());

                crust2.setForeground(Color.RED);
                crust2.setBackground(Color.WHITE);
                crust2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                crust3.setForeground(Color.WHITE);
                crust3.setBackground(Color.RED);
                crust3.setBorder(BorderFactory.createEmptyBorder());

                crust4.setForeground(Color.WHITE);
                crust4.setBackground(Color.RED);
                crust4.setBorder(BorderFactory.createEmptyBorder());
            }
        });
        selectionPanel.add(crust2);

        crust3.setFont(new Font("Times New Roman", Font.PLAIN, (int) 7.5));
        crust3.setBounds(202,500,50, 25);
        crust3.setBackground(Color.RED);
        crust3.setOpaque(true);
        crust3.setBorder(BorderFactory.createEmptyBorder());
        crust3.setForeground(Color.WHITE);
        crust3.setFocusPainted(false);
        crust3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu4.setCrustType("Cheese Stuffed");

                crust1.setForeground(Color.WHITE);
                crust1.setBackground(Color.RED);
                crust1.setBorder(BorderFactory.createEmptyBorder());

                crust2.setForeground(Color.WHITE);
                crust2.setBackground(Color.RED);
                crust2.setBorder(BorderFactory.createEmptyBorder());

                crust3.setForeground(Color.RED);
                crust3.setBackground(Color.WHITE);
                crust3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                crust4.setForeground(Color.WHITE);
                crust4.setBackground(Color.RED);
                crust4.setBorder(BorderFactory.createEmptyBorder());

            }
        });
        selectionPanel.add(crust3);

        crust4.setFont(new Font("Times New Roman", Font.PLAIN, 8));
        crust4.setBounds(253,500,50, 25);
        crust4.setBackground(Color.RED);
        crust4.setOpaque(true);
        crust4.setBorder(BorderFactory.createEmptyBorder());
        crust4.setForeground(Color.WHITE);
        crust4.setFocusPainted(false);
        crust4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu4.setCrustType("Gluten Free");

                crust1.setForeground(Color.WHITE);
                crust1.setBackground(Color.RED);
                crust1.setBorder(BorderFactory.createEmptyBorder());

                crust2.setForeground(Color.WHITE);
                crust2.setBackground(Color.RED);
                crust2.setBorder(BorderFactory.createEmptyBorder());

                crust3.setForeground(Color.WHITE);
                crust3.setBackground(Color.RED);
                crust3.setBorder(BorderFactory.createEmptyBorder());

                crust4.setForeground(Color.RED);
                crust4.setBackground(Color.WHITE);
                crust4.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            }
        });
        selectionPanel.add(crust4);


        AtomicInteger quant = new AtomicInteger(1);
        JLabel quantity = new JLabel(" "+quant.toString()+"  ");

        JButton plus = new JButton("+");
        plus.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        plus.setBounds(110,575,30, 25);
        plus.setBackground(Color.RED);
        plus.setOpaque(true);
        plus.setBorder(BorderFactory.createEmptyBorder());
        plus.setForeground(Color.WHITE);
        plus.setBorderPainted(false);
        plus.setFocusPainted(false);
        plus.addActionListener(new ActionListener() {

                                   @Override
                                   public void actionPerformed(ActionEvent e) {
                                       quant.incrementAndGet();
                                       quantity.setText(String.valueOf(quant.get()));
                                   }
                               }
        );

        selectionPanel.add(plus);

        JButton minus = new JButton("-");
        minus.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        minus.setBounds(30,575,30, 25);
        minus.setBackground(Color.RED);
        minus.setOpaque(true);
        minus.setBorder(BorderFactory.createEmptyBorder());
        minus.setForeground(Color.WHITE);
        minus.setBorderPainted(false);
        minus.setFocusPainted(false);
        minus.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (quant.get() == 1 ){
                    quant.set(Integer.valueOf(quant.get()));
                }else {
                    quant.decrementAndGet();
                    quantity.setText(String.valueOf(quant.get()));
                }

            }
        });
        selectionPanel.add(minus);



        quantity.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        quantity.setBounds(80,575,30, 25);
        quantity.setForeground(Color.red);
        selectionPanel.add(quantity);

        menu4.setQuantityy(quant.get());
        menu4.setImage("/Users/ekeneezeobi/IdeaProjects/PPD/src/spinach&feta1.jpeg");

        JButton addToCart = new JButton("Add to Cart");
        addToCart.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        addToCart.setBounds(115,650,100, 25);
        addToCart.setBackground(Color.RED);
        addToCart.setOpaque(true);
        addToCart.setBorder(BorderFactory.createEmptyBorder());
        addToCart.setForeground(Color.WHITE);
        addToCart.setBorderPainted(false);
        addToCart.setFocusPainted(false);
        addToCart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if(menu4.getSize().equals("small")){
                    menu4.setPrice(5.99);
                } else if (menu4.getSize().equals("medium")) {
                    menu4.setPrice(7.99);
                } else if (menu4.getSize().equals("large")) {
                    menu4.setPrice(9.99);
                } else if (menu4.getSize().equals("extra large")) {
                    menu4.setPrice(12.99);
                }
                cartList.add(menu4);

            }
        });
        selectionPanel.add(addToCart);

        spinachFetaPage.setVisible(true);

    }

    public static void cheesePizza(){
        //****** Cheese Pizza Page ******#####################################################################################################################

        JFrame cheesePizzaPage = new JFrame();
        cheesePizzaPage.setLayout(null);
        JPanel panel1 = new JPanel();

        cheesePizzaPage.setSize(350, 700);
        cheesePizzaPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cheesePizzaPage.add(panel1);

        panel1.setLayout(null);


        JPanel panel3_2 = new JPanel();
        panel3_2.setBounds(0,0,350, 599);
        panel3_2.setBackground(Color.WHITE);
        panel3_2.setLayout(null);
        cheesePizzaPage.add(panel3_2);

        JPanel panel3_3 = new JPanel();
        panel3_3.setBounds(0,600,350, 100);
        panel3_3.setBackground(Color.WHITE);
        cheesePizzaPage.add(panel3_3);

        ImageIcon icon1 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/home_icon.png");
        JButton home = new JButton(icon1);
        home.setBounds(0, 630, 40, 40);
        home.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                menu();
                cheesePizzaPage.dispose();
            }
        });
        panel3_3.add(home);

        ImageIcon icon2 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/search_icon.png");
        JButton search = new JButton(icon2);
        search.setBounds(50, 630, 40, 40);
        search.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                search();
                cheesePizzaPage.dispose();
            }
        });
        panel3_3.add(search);

        ImageIcon icon3 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/cart_icon.png");
        JButton cart = new JButton(icon3);
        cart.setBounds(100, 630, 40, 40);
        cart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cart();
            }
        });
        panel3_3.add(cart);

        ImageIcon icon4 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/account_icon.png");
        JButton account = new JButton(icon4);
        account.setBounds(150, 630, 40, 40);
        account.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                account();
                cheesePizzaPage.dispose();
            }
        });
        panel3_3.add(account);

        ImageIcon food_icon = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/cheesyPizzacopy.jpg");
        JLabel food = new JLabel(food_icon);
        food.setBounds(0, 0, 350, 150);
        panel3_2.add(food);

        JPanel selectionPanel = new JPanel();
        selectionPanel.setPreferredSize(new Dimension(330, 800));
        selectionPanel.setLayout(null);
        selectionPanel.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(selectionPanel);
        scrollPane.setBounds(0, 150, 350, 550);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        panel3_2.add(scrollPane);
        cheesePizzaPage.add(panel3_3);

        Product menu5 = new Product();
        menu5.setName("Cheese Pizza");

        JLabel size = new JLabel("Size");
        size.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        size.setBounds(10,50,80, 25);
        size.setForeground(Color.RED);
        selectionPanel.add(size);


        JButton size4 = new JButton("x-Large");
        JButton size3 = new JButton("Large");
        JButton size2 = new JButton("Medium");
        JButton size1 = new JButton("Small");
        size1.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        size1.setBounds(100,50,50, 25);
        size1.setBackground(Color.RED);
        size1.setOpaque(true);
        size1.setBorder(BorderFactory.createEmptyBorder());
        size1.setForeground(Color.WHITE);
        size1.setFocusPainted(false);
        size1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu5.setSize("small");

                size1.setForeground(Color.RED);
                size1.setBackground(Color.WHITE);
                size1.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                size2.setForeground(Color.WHITE);
                size2.setBackground(Color.RED);
                size2.setBorder(BorderFactory.createEmptyBorder());

                size3.setForeground(Color.WHITE);
                size3.setBackground(Color.RED);
                size3.setBorder(BorderFactory.createEmptyBorder());

                size4.setForeground(Color.WHITE);
                size4.setBackground(Color.RED);
                size4.setBorder(BorderFactory.createEmptyBorder());

            }
        });
        selectionPanel.add(size1);

        size2.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        size2.setBounds(151,50,50, 25);
        size2.setBackground(Color.WHITE);
        size2.setOpaque(true);
        size2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        size2.setForeground(Color.RED);
        size2.setFocusPainted(false);
        size2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu5.setSize("medium");

                size1.setForeground(Color.WHITE);
                size1.setBackground(Color.RED);
                size1.setBorder(BorderFactory.createEmptyBorder());

                size2.setForeground(Color.RED);
                size2.setBackground(Color.WHITE);
                size2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                size3.setForeground(Color.WHITE);
                size3.setBackground(Color.RED);
                size3.setBorder(BorderFactory.createEmptyBorder());

                size4.setForeground(Color.WHITE);
                size4.setBackground(Color.RED);
                size4.setBorder(BorderFactory.createEmptyBorder());
            }
        });
        selectionPanel.add(size2);

        size3.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        size3.setBounds(202,50,50, 25);
        size3.setBackground(Color.RED);
        size3.setOpaque(true);
        size3.setBorder(BorderFactory.createEmptyBorder());
        size3.setForeground(Color.WHITE);
        size3.setFocusPainted(false);
        size3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu5.setSize("large");

                size1.setForeground(Color.WHITE);
                size1.setBackground(Color.RED);
                size1.setBorder(BorderFactory.createEmptyBorder());

                size2.setForeground(Color.WHITE);
                size2.setBackground(Color.RED);
                size2.setBorder(BorderFactory.createEmptyBorder());

                size3.setForeground(Color.RED);
                size3.setBackground(Color.WHITE);
                size3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                size4.setForeground(Color.WHITE);
                size4.setBackground(Color.RED);
                size4.setBorder(BorderFactory.createEmptyBorder());

            }
        });
        selectionPanel.add(size3);

        size4.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        size4.setBounds(253,50,50, 25);
        size4.setBackground(Color.RED);
        size4.setOpaque(true);
        size4.setBorder(BorderFactory.createEmptyBorder());
        size4.setForeground(Color.WHITE);
        size4.setFocusPainted(false);
        size4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu5.setSize("extra large");

                size1.setForeground(Color.WHITE);
                size1.setBackground(Color.RED);
                size1.setBorder(BorderFactory.createEmptyBorder());

                size2.setForeground(Color.WHITE);
                size2.setBackground(Color.RED);
                size2.setBorder(BorderFactory.createEmptyBorder());

                size3.setForeground(Color.WHITE);
                size3.setBackground(Color.RED);
                size3.setBorder(BorderFactory.createEmptyBorder());

                size4.setForeground(Color.RED);
                size4.setBackground(Color.WHITE);
                size4.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            }
        });
        selectionPanel.add(size4);

        JLabel chicken =new JLabel("Chicken");
        chicken.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        chicken.setBounds(10,100,80, 25);
        chicken.setForeground(Color.RED);
        selectionPanel.add(chicken);


        JButton chicken3 = new JButton("✓");

        JButton chicken2 = new JButton("✗");
        chicken2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        chicken2.setBounds(151,100,50, 25);
        chicken2.setOpaque(true);
        chicken2.setBorder(BorderFactory.createEmptyBorder());
        chicken2.setFocusPainted(false);
        chicken2.setBackground(Color.WHITE);
        chicken2.setForeground(Color.RED);
        chicken2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        chicken2.addActionListener(new ActionListener() {

                                       @Override
                                       public void actionPerformed(ActionEvent e) {

                                           if(menu5.topping.contains("chicken")){
                                               menu5.topping.remove("chicken");
                                           }

                                           chicken2.setBackground(Color.WHITE);
                                           chicken2.setForeground(Color.RED);
                                           chicken2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                           chicken3.setBackground(Color.RED);
                                           chicken3.setForeground(Color.WHITE);
                                           chicken3.setBorder(BorderFactory.createEmptyBorder());

                                       }
                                   }
        );
        selectionPanel.add(chicken2);

        chicken3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        chicken3.setBounds(202,100,50, 25);
        chicken3.setBackground(Color.RED);
        chicken3.setOpaque(true);
        chicken3.setBorder(BorderFactory.createEmptyBorder());
        chicken3.setForeground(Color.WHITE);
        chicken3.setFocusPainted(false);
        chicken3.addActionListener(new ActionListener() {

                                       @Override
                                       public void actionPerformed(ActionEvent e) {

                                           //if (menutopping.get(4) == null){
                                           menu5.topping.add("chicken");

                                           chicken3.setBackground(Color.WHITE);
                                           chicken3.setForeground(Color.RED);
                                           chicken3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                           chicken2.setBackground(Color.RED);
                                           chicken2.setForeground(Color.WHITE);
                                           chicken2.setBorder(BorderFactory.createEmptyBorder());
                                           //}
                                       }
                                   }
        );
        selectionPanel.add(chicken3);


        JLabel bacon =new JLabel("Bacon");
        bacon.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        bacon.setBounds(10,150,80, 25);
        bacon.setForeground(Color.RED);
        selectionPanel.add(bacon);

        JButton bacon3 = new JButton("✓");
        JButton bacon2 = new JButton("✗");
        bacon2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        bacon2.setBounds(151,150,50, 25);
        bacon2.setBackground(Color.WHITE);
        bacon2.setOpaque(true);
        bacon2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        bacon2.setForeground(Color.RED);
        bacon2.setFocusPainted(false);
        bacon2.addActionListener(new ActionListener() {

                                     @Override
                                     public void actionPerformed(ActionEvent e) {

                                         if(menu5.topping.contains("bacon")){
                                             menu5.topping.remove("bacon");
                                         }

                                         bacon2.setBackground(Color.WHITE);
                                         bacon2.setForeground(Color.RED);
                                         bacon2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                         bacon3.setBackground(Color.RED);
                                         bacon3.setForeground(Color.WHITE);
                                         bacon3.setBorder(BorderFactory.createEmptyBorder());
                                         //}
                                     }
                                 }
        );
        selectionPanel.add(bacon2);

        bacon3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        bacon3.setBounds(202,150,50, 25);
        bacon3.setBackground(Color.RED);
        bacon3.setOpaque(true);
        bacon3.setBorder(BorderFactory.createEmptyBorder());
        bacon3.setForeground(Color.WHITE);
        bacon3.setFocusPainted(false);
        bacon3.addActionListener(new ActionListener() {

                                     @Override
                                     public void actionPerformed(ActionEvent e) {

                                         //if (menutopping.get(4) == null){
                                         menu5.topping.add("bacon");

                                         bacon3.setBackground(Color.WHITE);
                                         bacon3.setForeground(Color.RED);
                                         bacon3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                         bacon2.setBackground(Color.RED);
                                         bacon2.setForeground(Color.WHITE);
                                         bacon2.setBorder(BorderFactory.createEmptyBorder());
                                         //}
                                     }
                                 }
        );
        selectionPanel.add(bacon3);


        JLabel phillySteak =new JLabel("Philly Steak");
        phillySteak.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        phillySteak.setBounds(10,200,80, 25);
        phillySteak.setForeground(Color.RED);
        selectionPanel.add(phillySteak);


        JButton philly3 = new JButton("✓");
        JButton philly2 = new JButton("✗");
        philly2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        philly2.setBounds(151,200,50, 25);
        philly2.setBackground(Color.WHITE);
        philly2.setOpaque(true);
        philly2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        philly2.setForeground(Color.RED);
        philly2.setFocusPainted(false);
        philly2.addActionListener(new ActionListener() {

                                      @Override
                                      public void actionPerformed(ActionEvent e) {

                                          if(menu5.topping.contains("philly steak")){
                                              menu5.topping.remove("philly steak");
                                          }

                                          philly2.setBackground(Color.WHITE);
                                          philly2.setForeground(Color.RED);
                                          philly2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                          philly3.setBackground(Color.RED);
                                          philly3.setForeground(Color.WHITE);
                                          philly3.setBorder(BorderFactory.createEmptyBorder());

                                      }
                                  }
        );
        selectionPanel.add(philly2);

        philly3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        philly3.setBounds(202,200,50, 25);
        philly3.setBackground(Color.RED);
        philly3.setOpaque(true);
        philly3.setBorder(BorderFactory.createEmptyBorder());
        philly3.setForeground(Color.WHITE);
        philly3.setFocusPainted(false);
        philly3.addActionListener(new ActionListener() {

                                      @Override
                                      public void actionPerformed(ActionEvent e) {

                                          //if (menutopping.get(4) == null){
                                          menu5.topping.add("philly steak");

                                          philly3.setBackground(Color.WHITE);
                                          philly3.setForeground(Color.RED);
                                          philly3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                          philly2.setBackground(Color.RED);
                                          philly2.setForeground(Color.WHITE);
                                          philly2.setBorder(BorderFactory.createEmptyBorder());
                                          //}
                                      }
                                  }
        );
        selectionPanel.add(philly3);


        JLabel anchovies =new JLabel("Anchovies");
        anchovies.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        anchovies.setBounds(10,250,80, 25);
        anchovies.setForeground(Color.RED);
        selectionPanel.add(anchovies);



        JButton anchovies3 = new JButton("✓");
        JButton anchovies2 = new JButton("✗");
        anchovies2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        anchovies2.setBounds(151,250,50, 25);
        anchovies2.setBackground(Color.WHITE);
        anchovies2.setOpaque(true);
        anchovies2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        anchovies2.setForeground(Color.RED);
        anchovies2.setFocusPainted(false);
        anchovies2.addActionListener(new ActionListener() {

                                         @Override
                                         public void actionPerformed(ActionEvent e) {

                                             if(menu5.topping.contains("anchovies")){
                                                 menu5.topping.remove("anchovies");
                                             }

                                             anchovies2.setBackground(Color.WHITE);
                                             anchovies2.setForeground(Color.RED);
                                             anchovies2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                             anchovies3.setBackground(Color.RED);
                                             anchovies3.setForeground(Color.WHITE);
                                             anchovies3.setBorder(BorderFactory.createEmptyBorder());
                                             //}
                                         }
                                     }
        );
        selectionPanel.add(philly2);
        selectionPanel.add(anchovies2);

        anchovies3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        anchovies3.setBounds(202,250,50, 25);
        anchovies3.setBackground(Color.RED);
        anchovies3.setOpaque(true);
        anchovies3.setBorder(BorderFactory.createEmptyBorder());
        anchovies3.setForeground(Color.WHITE);
        anchovies3.setFocusPainted(false);
        anchovies3.addActionListener(new ActionListener() {

                                         @Override
                                         public void actionPerformed(ActionEvent e) {

                                             //if (menutopping.get(4) == null){
                                             menu5.topping.add("anchovies");

                                             anchovies3.setBackground(Color.WHITE);
                                             anchovies3.setForeground(Color.RED);
                                             anchovies3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                             anchovies2.setBackground(Color.RED);
                                             anchovies2.setForeground(Color.WHITE);
                                             anchovies2.setBorder(BorderFactory.createEmptyBorder());
                                             //}
                                         }
                                     }
        );
        selectionPanel.add(anchovies3);


        JLabel onions =new JLabel("Onions");
        onions.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        onions.setBounds(10,300,80, 25);
        onions.setForeground(Color.RED);
        selectionPanel.add(onions);



        JButton onion3 = new JButton("✓");
        JButton onion2 = new JButton("✗");
        onion2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        onion2.setBounds(151,300,50, 25);
        onion2.setBackground(Color.WHITE);
        onion2.setOpaque(true);
        onion2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        onion2.setForeground(Color.RED);
        onion2.setFocusPainted(false);
        onion2.addActionListener(new ActionListener() {

                                     @Override
                                     public void actionPerformed(ActionEvent e) {

                                         if(menu5.topping.contains("onions")){
                                             menu5.topping.remove("onions");
                                         }
                                         onion2.setBackground(Color.WHITE);
                                         onion2.setForeground(Color.RED);
                                         onion2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                         onion3.setBackground(Color.RED);
                                         onion3.setForeground(Color.WHITE);
                                         onion3.setBorder(BorderFactory.createEmptyBorder());

                                     }
                                 }
        );
        selectionPanel.add(onion2);

        onion3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        onion3.setBounds(202,300,50, 25);
        onion3.setBackground(Color.RED);
        onion3.setOpaque(true);
        onion3.setBorder(BorderFactory.createEmptyBorder());
        onion3.setForeground(Color.WHITE);
        onion3.setFocusPainted(false);
        onion3.addActionListener(new ActionListener() {

                                     @Override
                                     public void actionPerformed(ActionEvent e) {

                                         //if (menutopping.get(4) == null){
                                         menu5.topping.add("onion");

                                         onion3.setBackground(Color.WHITE);
                                         onion3.setForeground(Color.RED);
                                         onion3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                         onion2.setBackground(Color.RED);
                                         onion2.setForeground(Color.WHITE);
                                         onion2.setBorder(BorderFactory.createEmptyBorder());
                                         //}
                                     }
                                 }
        );
        selectionPanel.add(onion3);



        JLabel olives =new JLabel("Olives");
        olives.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        olives.setBounds(10,350,80, 25);
        olives.setForeground(Color.RED);
        selectionPanel.add(olives);



        JButton olives3 = new JButton("✓");
        JButton olives2 = new JButton("✗");
        olives2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        olives2.setBounds(151,350,50, 25);
        olives2.setBackground(Color.WHITE);
        olives2.setOpaque(true);
        olives2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        olives2.setForeground(Color.RED);
        olives2.setFocusPainted(false);
        olives2.addActionListener(new ActionListener() {

                                      @Override
                                      public void actionPerformed(ActionEvent e) {

                                          if(menu5.topping.contains("olives")){
                                              menu5.topping.remove("olives");
                                          }

                                          olives2.setBackground(Color.WHITE);
                                          olives2.setForeground(Color.RED);
                                          olives2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                          olives3.setBackground(Color.RED);
                                          olives3.setForeground(Color.WHITE);
                                          olives3.setBorder(BorderFactory.createEmptyBorder());
                                      }
                                  }
        );
        selectionPanel.add(olives2);

        olives3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        olives3.setBounds(202,350,50, 25);
        olives3.setBackground(Color.RED);
        olives3.setOpaque(true);
        olives3.setBorder(BorderFactory.createEmptyBorder());
        olives3.setForeground(Color.WHITE);
        olives3.setFocusPainted(false);
        olives3.addActionListener(new ActionListener() {

                                      @Override
                                      public void actionPerformed(ActionEvent e) {

                                          //if (menutopping.get(4) == null){
                                          menu5.topping.add("olives");

                                          olives3.setBackground(Color.WHITE);
                                          olives3.setForeground(Color.RED);
                                          olives3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                          olives2.setBackground(Color.RED);
                                          olives2.setForeground(Color.WHITE);
                                          olives2.setBorder(BorderFactory.createEmptyBorder());
                                          //}
                                      }
                                  }
        );
        selectionPanel.add(olives3);


        JLabel cheese =new JLabel("Cheese");
        cheese.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        cheese.setBounds(10,400,80, 25);
        cheese.setForeground(Color.RED);
        selectionPanel.add(cheese);


        JButton cheese3 = new JButton("✓");
        JButton cheese2 = new JButton("✗");
        cheese2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        cheese2.setBounds(151,400,50, 25);
        cheese2.setBackground(Color.WHITE);
        cheese2.setOpaque(true);
        cheese2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        cheese2.setForeground(Color.RED);
        cheese2.setFocusPainted(false);
        cheese2.addActionListener(new ActionListener() {

                                      @Override
                                      public void actionPerformed(ActionEvent e) {
                                          if(menu5.topping.contains("cheese")){
                                              menu5.topping.remove("cheese");
                                          }

                                          cheese2.setBackground(Color.WHITE);
                                          cheese2.setForeground(Color.RED);
                                          cheese2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                          cheese3.setBackground(Color.RED);
                                          cheese3.setForeground(Color.WHITE);
                                          cheese3.setBorder(BorderFactory.createEmptyBorder());
                                      }
                                  }
        );
        selectionPanel.add(cheese2);

        cheese3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        cheese3.setBounds(202,400,50, 25);
        cheese3.setBackground(Color.RED);
        cheese3.setOpaque(true);
        cheese3.setBorder(BorderFactory.createEmptyBorder());
        cheese3.setForeground(Color.WHITE);
        cheese3.setFocusPainted(false);
        cheese3.addActionListener(new ActionListener() {

                                      @Override
                                      public void actionPerformed(ActionEvent e) {

                                          //if (menutopping.get(4) == null){
                                          menu5.topping.add("cheese");

                                          cheese3.setBackground(Color.WHITE);
                                          cheese3.setForeground(Color.RED);
                                          cheese3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                          cheese2.setBackground(Color.RED);
                                          cheese2.setForeground(Color.WHITE);
                                          cheese2.setBorder(BorderFactory.createEmptyBorder());
                                          //}
                                      }
                                  }
        );
        selectionPanel.add(cheese3);



        JLabel mushroom =new JLabel("Mushroom");
        mushroom.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        mushroom.setBounds(10,450,80, 25);
        mushroom.setForeground(Color.RED);
        selectionPanel.add(mushroom);


        JButton mushroom3 = new JButton("✓");
        JButton mushroom2 = new JButton("✗");
        mushroom2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        mushroom2.setBounds(151,450,50, 25);
        mushroom2.setBackground(Color.WHITE);
        mushroom2.setOpaque(true);
        mushroom2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        mushroom2.setForeground(Color.RED);
        mushroom2.setFocusPainted(false);
        mushroom2.addActionListener(new ActionListener() {

                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            if(menu5.topping.contains("mushroom")){
                                                menu5.topping.remove("mushroom");
                                            }

                                            mushroom2.setBackground(Color.WHITE);
                                            mushroom2.setForeground(Color.RED);
                                            mushroom2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                            mushroom3.setBackground(Color.RED);
                                            mushroom3.setForeground(Color.WHITE);
                                            mushroom3.setBorder(BorderFactory.createEmptyBorder());
                                        }
                                    }
        );
        selectionPanel.add(mushroom2);

        mushroom3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        mushroom3.setBounds(202,450,50, 25);
        mushroom3.setBackground(Color.RED);
        mushroom3.setOpaque(true);
        mushroom3.setBorder(BorderFactory.createEmptyBorder());
        mushroom3.setForeground(Color.WHITE);
        mushroom3.setFocusPainted(false);
        mushroom3.addActionListener(new ActionListener() {

                                        @Override
                                        public void actionPerformed(ActionEvent e) {

                                            //if (menutopping.get(4) == null){
                                            menu5.topping.add("mushroom");

                                            mushroom3.setBackground(Color.WHITE);
                                            mushroom3.setForeground(Color.RED);
                                            mushroom3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                                            mushroom2.setBackground(Color.RED);
                                            mushroom2.setForeground(Color.WHITE);
                                            mushroom2.setBorder(BorderFactory.createEmptyBorder());
                                            //}
                                        }
                                    }
        );
        selectionPanel.add(mushroom3);


        JLabel crust =new JLabel("Crust");
        crust.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        crust.setBounds(10,500,80, 25);
        crust.setForeground(Color.RED);
        selectionPanel.add(crust);

        JButton crust4 = new JButton("Gluten Free");
        JButton crust3 = new JButton("Cheese Stuffed");
        JButton crust2 = new JButton("Normal");
        JButton crust1 = new JButton("Thin");
        crust1.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        crust1.setBounds(100,500,50, 25);
        crust1.setBackground(Color.RED);
        crust1.setOpaque(true);
        crust1.setBorder(BorderFactory.createEmptyBorder());
        crust1.setForeground(Color.WHITE);
        crust1.setFocusPainted(false);
        crust1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu5.setCrustType("Thin");

                crust1.setForeground(Color.RED);
                crust1.setBackground(Color.WHITE);
                crust1.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                crust2.setForeground(Color.WHITE);
                crust2.setBackground(Color.RED);
                crust2.setBorder(BorderFactory.createEmptyBorder());

                crust3.setForeground(Color.WHITE);
                crust3.setBackground(Color.RED);
                crust3.setBorder(BorderFactory.createEmptyBorder());

                crust4.setForeground(Color.WHITE);
                crust4.setBackground(Color.RED);
                crust4.setBorder(BorderFactory.createEmptyBorder());

            }
        });
        selectionPanel.add(crust1);

        crust2.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        crust2.setBounds(151,500,50, 25);
        crust2.setBackground(Color.WHITE);
        crust2.setOpaque(true);
        crust2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        crust2.setForeground(Color.RED);
        crust2.setFocusPainted(false);
        crust2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu5.setCrustType("Normal");

                crust1.setForeground(Color.WHITE);
                crust1.setBackground(Color.RED);
                crust1.setBorder(BorderFactory.createEmptyBorder());

                crust2.setForeground(Color.RED);
                crust2.setBackground(Color.WHITE);
                crust2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                crust3.setForeground(Color.WHITE);
                crust3.setBackground(Color.RED);
                crust3.setBorder(BorderFactory.createEmptyBorder());

                crust4.setForeground(Color.WHITE);
                crust4.setBackground(Color.RED);
                crust4.setBorder(BorderFactory.createEmptyBorder());
            }
        });
        selectionPanel.add(crust2);

        crust3.setFont(new Font("Times New Roman", Font.PLAIN, (int) 7.5));
        crust3.setBounds(202,500,50, 25);
        crust3.setBackground(Color.RED);
        crust3.setOpaque(true);
        crust3.setBorder(BorderFactory.createEmptyBorder());
        crust3.setForeground(Color.WHITE);
        crust3.setFocusPainted(false);
        crust3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu5.setCrustType("Cheese Stuffed");

                crust1.setForeground(Color.WHITE);
                crust1.setBackground(Color.RED);
                crust1.setBorder(BorderFactory.createEmptyBorder());

                crust2.setForeground(Color.WHITE);
                crust2.setBackground(Color.RED);
                crust2.setBorder(BorderFactory.createEmptyBorder());

                crust3.setForeground(Color.RED);
                crust3.setBackground(Color.WHITE);
                crust3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                crust4.setForeground(Color.WHITE);
                crust4.setBackground(Color.RED);
                crust4.setBorder(BorderFactory.createEmptyBorder());

            }
        });
        selectionPanel.add(crust3);

        crust4.setFont(new Font("Times New Roman", Font.PLAIN, 8));
        crust4.setBounds(253,500,50, 25);
        crust4.setBackground(Color.RED);
        crust4.setOpaque(true);
        crust4.setBorder(BorderFactory.createEmptyBorder());
        crust4.setForeground(Color.WHITE);
        crust4.setFocusPainted(false);
        crust4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu5.setCrustType("Gluten Free");

                crust1.setForeground(Color.WHITE);
                crust1.setBackground(Color.RED);
                crust1.setBorder(BorderFactory.createEmptyBorder());

                crust2.setForeground(Color.WHITE);
                crust2.setBackground(Color.RED);
                crust2.setBorder(BorderFactory.createEmptyBorder());

                crust3.setForeground(Color.WHITE);
                crust3.setBackground(Color.RED);
                crust3.setBorder(BorderFactory.createEmptyBorder());

                crust4.setForeground(Color.RED);
                crust4.setBackground(Color.WHITE);
                crust4.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            }
        });
        selectionPanel.add(crust4);

        menu5.setCrustType("Normal");
        menu5.setSize("medium");


        AtomicInteger quant = new AtomicInteger(1);
        JLabel quantity = new JLabel(" "+quant.toString()+"  ");

        JButton plus = new JButton("+");
        plus.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        plus.setBounds(110,575,30, 25);
        plus.setBackground(Color.RED);
        plus.setOpaque(true);
        plus.setBorder(BorderFactory.createEmptyBorder());
        plus.setForeground(Color.WHITE);
        plus.setBorderPainted(false);
        plus.setFocusPainted(false);
        plus.addActionListener(new ActionListener() {

                                   @Override
                                   public void actionPerformed(ActionEvent e) {
                                       quant.incrementAndGet();
                                       quantity.setText(String.valueOf(quant.get()));
                                   }
                               }
        );

        selectionPanel.add(plus);

        JButton minus = new JButton("-");
        minus.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        minus.setBounds(30,575,30, 25);
        minus.setBackground(Color.RED);
        minus.setOpaque(true);
        minus.setBorder(BorderFactory.createEmptyBorder());
        minus.setForeground(Color.WHITE);
        minus.setBorderPainted(false);
        minus.setFocusPainted(false);
        minus.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (quant.get() == 1 ){
                    quant.set(Integer.valueOf(quant.get()));
                }else {
                    quant.decrementAndGet();
                    quantity.setText(String.valueOf(quant.get()));
                }

            }
        });
        selectionPanel.add(minus);



        quantity.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        quantity.setBounds(80,575,30, 25);
        quantity.setForeground(Color.red);
        selectionPanel.add(quantity);

        menu5.setQuantityy(quant.get());
        menu5.setImage("/Users/ekeneezeobi/IdeaProjects/PPD/src/cheesyPizza1.jpg");

        JButton addToCart = new JButton("Add to Cart");
        addToCart.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        addToCart.setBounds(115,650,100, 25);
        addToCart.setBackground(Color.RED);
        addToCart.setOpaque(true);
        addToCart.setBorder(BorderFactory.createEmptyBorder());
        addToCart.setForeground(Color.WHITE);
        addToCart.setBorderPainted(false);
        addToCart.setFocusPainted(false);
        addToCart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if(menu5.getSize().equals("small")){
                    menu5.setPrice(5.99);
                } else if (menu5.getSize().equals("medium")) {
                    menu5.setPrice(7.99);
                } else if (menu5.getSize().equals("large")) {
                    menu5.setPrice(9.99);
                } else if (menu5.getSize().equals("extra large")) {
                    menu5.setPrice(12.99);
                }
                cartList.add(menu5);

            }
        });
        selectionPanel.add(addToCart);

        cheesePizzaPage.setVisible(true);
    }

    public static void garlicBread(){
        //****** Garlic Bread Page ******#####################################################################################################################

        JFrame garlicBreadPage = new JFrame();
        garlicBreadPage.setLayout(null);
        JPanel panel1 = new JPanel();

        garlicBreadPage.setSize(350, 700);
        garlicBreadPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        garlicBreadPage.add(panel1);

        panel1.setLayout(null);


        JPanel panel3_2 = new JPanel();
        panel3_2.setBounds(0,0,350, 599);
        panel3_2.setBackground(Color.WHITE);
        panel3_2.setLayout(null);
        garlicBreadPage.add(panel3_2);

        JPanel panel3_3 = new JPanel();
        panel3_3.setBounds(0,600,350, 100);
        panel3_3.setBackground(Color.WHITE);
        garlicBreadPage.add(panel3_3);

        ImageIcon icon1 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/home_icon.png");
        JButton home = new JButton(icon1);
        home.setBounds(0, 630, 40, 40);
        home.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                menu();
                garlicBreadPage.dispose();
            }
        });
        panel3_3.add(home);

        ImageIcon icon2 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/search_icon.png");
        JButton search = new JButton(icon2);
        search.setBounds(50, 630, 40, 40);
        search.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                search();
                garlicBreadPage.dispose();
            }
        });
        panel3_3.add(search);

        ImageIcon icon3 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/cart_icon.png");
        JButton cart = new JButton(icon3);
        cart.setBounds(100, 630, 40, 40);
        cart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cart();
            }
        });
        panel3_3.add(cart);

        ImageIcon icon4 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/account_icon.png");
        JButton account = new JButton(icon4);
        account.setBounds(150, 630, 40, 40);
        account.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                account();
                garlicBreadPage.dispose();
            }
        });
        panel3_3.add(account);

        ImageIcon food_icon = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/garlicbreadcopy.jpeg");
        JLabel food = new JLabel(food_icon);
        food.setBounds(0, 0, 350, 150);
        panel3_2.add(food);


        garlicBreadPage.add(panel3_3);

        AtomicInteger quant = new AtomicInteger(1);
        JLabel quantity = new JLabel(" "+quant.toString()+"  ");

        JButton plus = new JButton("+");
        plus.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        plus.setBounds(110,250,30, 25);
        plus.setBackground(Color.RED);
        plus.setOpaque(true);
        plus.setBorder(BorderFactory.createEmptyBorder());
        plus.setForeground(Color.WHITE);
        plus.setBorderPainted(false);
        plus.setFocusPainted(false);
        plus.addActionListener(new ActionListener() {

                                   @Override
                                   public void actionPerformed(ActionEvent e) {
                                       quant.incrementAndGet();
                                       quantity.setText(String.valueOf(quant.get()));
                                   }
                               }
        );

        panel3_2.add(plus);

        JButton minus = new JButton("-");
        minus.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        minus.setBounds(30,250,30, 25);
        minus.setBackground(Color.RED);
        minus.setOpaque(true);
        minus.setBorder(BorderFactory.createEmptyBorder());
        minus.setForeground(Color.WHITE);
        minus.setBorderPainted(false);
        minus.setFocusPainted(false);
        minus.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (quant.get() == 1 ){
                    quant.set(Integer.valueOf(quant.get()));
                }else {
                    quant.decrementAndGet();
                    quantity.setText(String.valueOf(quant.get()));
                }

            }
        });
        panel3_2.add(minus);



        quantity.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        quantity.setBounds(80,250,30, 25);
        quantity.setForeground(Color.red);
        panel3_2.add(quantity);

        Product menu6 = new Product();
        menu6.setName("Garlic Bread");
        menu6.setSize(null);
        menu6.setQuantityy(quant.get());
        menu6.setTopping(null);
        menu6.setPrice(4.99);
        menu6.setCrustType(null);
        menu6.setImage("/Users/ekeneezeobi/IdeaProjects/PPD/src/garlicbread1.jpeg");


        JButton addToCart = new JButton("Add to Cart");
        addToCart.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        addToCart.setBounds(115,350,100, 25);
        addToCart.setBackground(Color.RED);
        addToCart.setOpaque(true);
        addToCart.setBorder(BorderFactory.createEmptyBorder());
        addToCart.setForeground(Color.WHITE);
        addToCart.setBorderPainted(false);
        addToCart.setFocusPainted(false);
        addToCart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cartList.add(menu6);
            }
        });
        panel3_2.add(addToCart);

        garlicBreadPage.setVisible(true);
    }


    public static void cheesyBread(){
        JFrame cheesyBreadPage = new JFrame();
        cheesyBreadPage.setLayout(null);
        JPanel panel1 = new JPanel();

        cheesyBreadPage.setSize(350, 700);
        cheesyBreadPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cheesyBreadPage.add(panel1);

        panel1.setLayout(null);


        JPanel panel3_2 = new JPanel();
        panel3_2.setBounds(0,0,350, 599);
        panel3_2.setBackground(Color.WHITE);
        panel3_2.setLayout(null);
        cheesyBreadPage.add(panel3_2);

        JPanel panel3_3 = new JPanel();
        panel3_3.setBounds(0,600,350, 100);
        panel3_3.setBackground(Color.WHITE);
        cheesyBreadPage.add(panel3_3);

        ImageIcon icon1 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/home_icon.png");
        JButton home = new JButton(icon1);
        home.setBounds(0, 630, 40, 40);
        home.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                menu();
                cheesyBreadPage.dispose();
            }
        });
        panel3_3.add(home);

        ImageIcon icon2 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/search_icon.png");
        JButton search = new JButton(icon2);
        search.setBounds(50, 630, 40, 40);
        search.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                search();
                cheesyBreadPage.dispose();
            }
        });
        panel3_3.add(search);

        ImageIcon icon3 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/cart_icon.png");
        JButton cart = new JButton(icon3);
        cart.setBounds(100, 630, 40, 40);
        cart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cart();
            }
        });
        panel3_3.add(cart);

        ImageIcon icon4 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/account_icon.png");
        JButton account = new JButton(icon4);
        account.setBounds(150, 630, 40, 40);
        account.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                account();
                cheesyBreadPage.dispose();
            }
        });
        panel3_3.add(account);

        ImageIcon food_icon = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/cheesyBeardcopy.jpeg");
        JLabel food = new JLabel(food_icon);
        food.setBounds(0, 0, 350, 150);
        panel3_2.add(food);


        cheesyBreadPage.add(panel3_3);

        AtomicInteger quant = new AtomicInteger(1);
        JLabel quantity = new JLabel(" "+quant.toString()+"  ");

        JButton plus = new JButton("+");
        plus.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        plus.setBounds(110,250,30, 25);
        plus.setBackground(Color.RED);
        plus.setOpaque(true);
        plus.setBorder(BorderFactory.createEmptyBorder());
        plus.setForeground(Color.WHITE);
        plus.setBorderPainted(false);
        plus.setFocusPainted(false);
        plus.addActionListener(new ActionListener() {

                                   @Override
                                   public void actionPerformed(ActionEvent e) {
                                       quant.incrementAndGet();
                                       quantity.setText(String.valueOf(quant.get()));
                                   }
                               }
        );

        panel3_2.add(plus);

        JButton minus = new JButton("-");
        minus.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        minus.setBounds(30,250,30, 25);
        minus.setBackground(Color.RED);
        minus.setOpaque(true);
        minus.setBorder(BorderFactory.createEmptyBorder());
        minus.setForeground(Color.WHITE);
        minus.setBorderPainted(false);
        minus.setFocusPainted(false);
        minus.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (quant.get() == 1 ){
                    quant.set(Integer.valueOf(quant.get()));
                }else {
                    quant.decrementAndGet();
                    quantity.setText(String.valueOf(quant.get()));
                }

            }
        });
        panel3_2.add(minus);



        quantity.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        quantity.setBounds(80,250,30, 25);
        quantity.setForeground(Color.red);
        panel3_2.add(quantity);

        Product menu7 = new Product();
        menu7.setName("Cheese Stuffed Bread");
        menu7.setSize(null);
        menu7.setQuantityy(quant.get());
        menu7.setTopping(null);
        menu7.setPrice(4.99);
        menu7.setCrustType(null);
        menu7.setImage("/Users/ekeneezeobi/IdeaProjects/PPD/src/cheesyBeard1.jpeg");

        JButton addToCart = new JButton("Add to Cart");
        addToCart.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        addToCart.setBounds(115,350,100, 25);
        addToCart.setBackground(Color.RED);
        addToCart.setOpaque(true);
        addToCart.setBorder(BorderFactory.createEmptyBorder());
        addToCart.setForeground(Color.WHITE);
        addToCart.setBorderPainted(false);
        addToCart.setFocusPainted(false);
        addToCart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cartList.add(menu7);
            }
        });
        panel3_2.add(addToCart);

        cheesyBreadPage.setVisible(true);
    }


    public static void fanta(){
        //****** Fanta Page ******#####################################################################################################################

        JFrame fantaPage = new JFrame();
        fantaPage.setLayout(null);
        JPanel panel1 = new JPanel();



        fantaPage.setSize(350, 700);
        fantaPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fantaPage.add(panel1);

        panel1.setLayout(null);


        JPanel panel3_2 = new JPanel();
        panel3_2.setBounds(0,0,350, 599);
        panel3_2.setBackground(Color.WHITE);
        panel3_2.setLayout(null);
        fantaPage.add(panel3_2);

        JPanel panel3_3 = new JPanel();
        panel3_3.setBounds(0,600,350, 100);
        panel3_3.setBackground(Color.WHITE);
        fantaPage.add(panel3_3);

        ImageIcon icon1 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/home_icon.png");
        JButton home = new JButton(icon1);
        home.setBounds(0, 630, 40, 40);
        home.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                menu();
                fantaPage.dispose();
            }
        });
        panel3_3.add(home);

        ImageIcon icon2 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/search_icon.png");
        JButton search = new JButton(icon2);
        search.setBounds(50, 630, 40, 40);
        search.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                search();
                fantaPage.dispose();
            }
        });
        panel3_3.add(search);

        ImageIcon icon3 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/cart_icon.png");
        JButton cart = new JButton(icon3);
        cart.setBounds(100, 630, 40, 40);
        cart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cart();
            }
        });
        panel3_3.add(cart);

        ImageIcon icon4 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/account_icon.png");
        JButton account = new JButton(icon4);
        account.setBounds(150, 630, 40, 40);
        account.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                account();
                fantaPage.dispose();
            }
        });
        panel3_3.add(account);

        ImageIcon food_icon = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/fantacopy.jpeg");
        JLabel food = new JLabel(food_icon);
        food.setBounds(0, 0, 350, 150);
        panel3_2.add(food);

        fantaPage.add(panel3_3);
        Product menu8 = new Product();


        JLabel size = new JLabel("Size");
        size.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        size.setBounds(10,250,80, 25);
        size.setForeground(Color.RED);
        panel3_2.add(size);


        JButton size3 = new JButton("Large");
        JButton size2 = new JButton("Medium");
        JButton size1 = new JButton("Small");
        size1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        size1.setBounds(100,250,75, 25);
        size1.setBackground(Color.WHITE);
        size1.setOpaque(true);
        size1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        size1.setForeground(Color.RED);
        size1.setFocusPainted(false);
        size1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu8.setSize("small");

                size1.setForeground(Color.RED);
                size1.setBackground(Color.WHITE);
                size1.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                size2.setForeground(Color.WHITE);
                size2.setBackground(Color.RED);
                size2.setBorder(BorderFactory.createEmptyBorder());

                size3.setForeground(Color.WHITE);
                size3.setBackground(Color.RED);
                size3.setBorder(BorderFactory.createEmptyBorder());


            }
        });
        panel3_2.add(size1);

        size2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        size2.setBounds(176,250,75, 25);
        size2.setBackground(Color.RED);
        size2.setOpaque(true);
        size2.setBorder(BorderFactory.createEmptyBorder());
        size2.setForeground(Color.WHITE);
        size2.setFocusPainted(false);
        size2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu8.setSize("medium");

                size1.setForeground(Color.WHITE);
                size1.setBackground(Color.RED);
                size1.setBorder(BorderFactory.createEmptyBorder());

                size2.setForeground(Color.RED);
                size2.setBackground(Color.WHITE);
                size2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                size3.setForeground(Color.WHITE);
                size3.setBackground(Color.RED);
                size3.setBorder(BorderFactory.createEmptyBorder());


            }
        });
        panel3_2.add(size2);

        size3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        size3.setBounds(252,250,75, 25);
        size3.setBackground(Color.RED);
        size3.setOpaque(true);
        size3.setBorder(BorderFactory.createEmptyBorder());
        size3.setForeground(Color.WHITE);
        size3.setFocusPainted(false);
        size3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu8.setSize("large");

                size1.setForeground(Color.WHITE);
                size1.setBackground(Color.RED);
                size1.setBorder(BorderFactory.createEmptyBorder());

                size2.setForeground(Color.WHITE);
                size2.setBackground(Color.RED);
                size2.setBorder(BorderFactory.createEmptyBorder());

                size3.setForeground(Color.RED);
                size3.setBackground(Color.WHITE);
                size3.setBorder(BorderFactory.createLineBorder(Color.BLACK));


            }
        });
        panel3_2.add(size3);

        AtomicInteger quant = new AtomicInteger(1);
        JLabel quantity = new JLabel(" "+quant.toString()+"  ");

        JButton plus = new JButton("+");
        plus.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        plus.setBounds(110,350,30, 25);
        plus.setBackground(Color.RED);
        plus.setOpaque(true);
        plus.setBorder(BorderFactory.createEmptyBorder());
        plus.setForeground(Color.WHITE);
        plus.setBorderPainted(false);
        plus.setFocusPainted(false);
        plus.addActionListener(new ActionListener() {

                                   @Override
                                   public void actionPerformed(ActionEvent e) {
                                       quant.incrementAndGet();
                                       quantity.setText(String.valueOf(quant.get()));
                                   }
                               }
        );

        panel3_2.add(plus);

        JButton minus = new JButton("-");
        minus.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        minus.setBounds(30,350,30, 25);
        minus.setBackground(Color.RED);
        minus.setOpaque(true);
        minus.setBorder(BorderFactory.createEmptyBorder());
        minus.setForeground(Color.WHITE);
        minus.setBorderPainted(false);
        minus.setFocusPainted(false);
        minus.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (quant.get() == 1 ){
                    quant.set(Integer.valueOf(quant.get()));
                }else {
                    quant.decrementAndGet();
                    quantity.setText(String.valueOf(quant.get()));
                }

            }
        });
        panel3_2.add(minus);



        quantity.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        quantity.setBounds(80,350,30, 25);
        quantity.setForeground(Color.red);
        panel3_2.add(quantity);

        menu8.setName("Fanta");
        menu8.setTopping(null);
        menu8.setCrustType(null);
        menu8.setQuantityy(quant.get());
        menu8.setPrice(2.99);
        menu8.setImage("/Users/ekeneezeobi/IdeaProjects/PPD/src/fanta1.jpeg");
        menu8.setSize("small");


        JButton addToCart = new JButton("Add to Cart");
        addToCart.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        addToCart.setBounds(115,450,100, 25);
        addToCart.setBackground(Color.RED);
        addToCart.setOpaque(true);
        addToCart.setBorder(BorderFactory.createEmptyBorder());
        addToCart.setForeground(Color.WHITE);
        addToCart.setBorderPainted(false);
        addToCart.setFocusPainted(false);
        addToCart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cartList.add(menu8);
            }
        });
        panel3_2.add(addToCart);

        fantaPage.setVisible(true);
    }

    public static void lemonade(){
        //****** Lemonade Page ******#####################################################################################################################

        JFrame lemonadepage = new JFrame();
        lemonadepage.setLayout(null);
        JPanel panel1 = new JPanel();

        lemonadepage.setSize(350, 700);
        lemonadepage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lemonadepage.add(panel1);

        panel1.setLayout(null);


        JPanel panel3_2 = new JPanel();
        panel3_2.setBounds(0,0,350, 599);
        panel3_2.setBackground(Color.WHITE);
        panel3_2.setLayout(null);
        lemonadepage.add(panel3_2);

        JPanel panel3_3 = new JPanel();
        panel3_3.setBounds(0,600,350, 100);
        panel3_3.setBackground(Color.WHITE);
        lemonadepage.add(panel3_3);

        ImageIcon icon1 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/home_icon.png");
        JButton home = new JButton(icon1);
        home.setBounds(0, 630, 40, 40);
        home.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                menu();
                lemonadepage.dispose();
            }
        });
        panel3_3.add(home);

        ImageIcon icon2 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/search_icon.png");
        JButton search = new JButton(icon2);
        search.setBounds(50, 630, 40, 40);
        search.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                search();
                lemonadepage.dispose();
            }
        });
        panel3_3.add(search);

        ImageIcon icon3 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/cart_icon.png");
        JButton cart = new JButton(icon3);
        cart.setBounds(100, 630, 40, 40);
        cart.addActionListener(e -> cart());
        panel3_3.add(cart);

        ImageIcon icon4 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/account_icon.png");
        JButton account = new JButton(icon4);
        account.setBounds(150, 630, 40, 40);
        account.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                account();
                lemonadepage.dispose();
            }
        });
        panel3_3.add(account);

        ImageIcon food_icon = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/lemonadecopy.jpeg");
        JLabel food = new JLabel(food_icon);
        food.setBounds(0, 0, 350, 150);
        panel3_2.add(food);

        lemonadepage.add(panel3_3);

        Product menu9 = new Product();


        JLabel size = new JLabel("Size");
        size.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        size.setBounds(10,250,80, 25);
        size.setForeground(Color.RED);
        panel3_2.add(size);


        JButton size3 = new JButton("Large");
        JButton size2 = new JButton("Medium");
        JButton size1 = new JButton("Small");
        size1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        size1.setBounds(100,250,75, 25);
        size1.setBackground(Color.WHITE);
        size1.setOpaque(true);
        size1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        size1.setForeground(Color.RED);
        size1.setFocusPainted(false);
        size1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu9.setSize("small");

                size1.setForeground(Color.RED);
                size1.setBackground(Color.WHITE);
                size1.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                size2.setForeground(Color.WHITE);
                size2.setBackground(Color.RED);
                size2.setBorder(BorderFactory.createEmptyBorder());

                size3.setForeground(Color.WHITE);
                size3.setBackground(Color.RED);
                size3.setBorder(BorderFactory.createEmptyBorder());


            }
        });
        panel3_2.add(size1);

        size2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        size2.setBounds(176,250,75, 25);
        size2.setBackground(Color.RED);
        size2.setOpaque(true);
        size2.setBorder(BorderFactory.createEmptyBorder());
        size2.setForeground(Color.WHITE);
        size2.setFocusPainted(false);
        size2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu9.setSize("medium");

                size1.setForeground(Color.WHITE);
                size1.setBackground(Color.RED);
                size1.setBorder(BorderFactory.createEmptyBorder());

                size2.setForeground(Color.RED);
                size2.setBackground(Color.WHITE);
                size2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                size3.setForeground(Color.WHITE);
                size3.setBackground(Color.RED);
                size3.setBorder(BorderFactory.createEmptyBorder());


            }
        });
        panel3_2.add(size2);

        size3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        size3.setBounds(252,250,75, 25);
        size3.setBackground(Color.RED);
        size3.setOpaque(true);
        size3.setBorder(BorderFactory.createEmptyBorder());
        size3.setForeground(Color.WHITE);
        size3.setFocusPainted(false);
        size3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu9.setSize("large");

                size1.setForeground(Color.WHITE);
                size1.setBackground(Color.RED);
                size1.setBorder(BorderFactory.createEmptyBorder());

                size2.setForeground(Color.WHITE);
                size2.setBackground(Color.RED);
                size2.setBorder(BorderFactory.createEmptyBorder());

                size3.setForeground(Color.RED);
                size3.setBackground(Color.WHITE);
                size3.setBorder(BorderFactory.createLineBorder(Color.BLACK));


            }
        });
        panel3_2.add(size3);

        AtomicInteger quant = new AtomicInteger(1);
        JLabel quantity = new JLabel(" "+quant.toString()+"  ");

        JButton plus = new JButton("+");
        plus.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        plus.setBounds(110,350,30, 25);
        plus.setBackground(Color.RED);
        plus.setOpaque(true);
        plus.setBorder(BorderFactory.createEmptyBorder());
        plus.setForeground(Color.WHITE);
        plus.setBorderPainted(false);
        plus.setFocusPainted(false);
        plus.addActionListener(new ActionListener() {

                                   @Override
                                   public void actionPerformed(ActionEvent e) {
                                       quant.incrementAndGet();
                                       quantity.setText(String.valueOf(quant.get()));
                                   }
                               }
        );

        panel3_2.add(plus);

        JButton minus = new JButton("-");
        minus.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        minus.setBounds(30,350,30, 25);
        minus.setBackground(Color.RED);
        minus.setOpaque(true);
        minus.setBorder(BorderFactory.createEmptyBorder());
        minus.setForeground(Color.WHITE);
        minus.setBorderPainted(false);
        minus.setFocusPainted(false);
        minus.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (quant.get() == 1 ){
                    quant.set(Integer.valueOf(quant.get()));
                }else {
                    quant.decrementAndGet();
                    quantity.setText(String.valueOf(quant.get()));
                }

            }
        });
        panel3_2.add(minus);



        quantity.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        quantity.setBounds(80,350,30, 25);
        quantity.setForeground(Color.red);
        panel3_2.add(quantity);

        menu9.setName("Lemonade");
        menu9.setTopping(null);
        menu9.setCrustType(null);
        menu9.setQuantityy(quant.get());
        menu9.setPrice(2.99);
        menu9.setImage("/Users/ekeneezeobi/IdeaProjects/PPD/src/lemonade1.jpeg");
        menu9.setSize("small");

        JButton addToCart = new JButton("Add to Cart");
        addToCart.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        addToCart.setBounds(115,450,100, 25);
        addToCart.setBackground(Color.RED);
        addToCart.setOpaque(true);
        addToCart.setBorder(BorderFactory.createEmptyBorder());
        addToCart.setForeground(Color.WHITE);
        addToCart.setBorderPainted(false);
        addToCart.setFocusPainted(false);
        addToCart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cartList.add(menu9);
            }
        });
        panel3_2.add(addToCart);

        lemonadepage.setVisible(true);
    }

    public static void coke(){
        //****** Coke Page ******#####################################################################################################################

        JFrame cokePage = new JFrame();
        cokePage.setLayout(null);
        JPanel panel1 = new JPanel();

        cokePage.setSize(350, 700);
        cokePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cokePage.add(panel1);

        panel1.setLayout(null);


        JPanel panel3_2 = new JPanel();
        panel3_2.setBounds(0,0,350, 599);
        panel3_2.setBackground(Color.WHITE);
        panel3_2.setLayout(null);
        cokePage.add(panel3_2);

        JPanel panel3_3 = new JPanel();
        panel3_3.setBounds(0,600,350, 100);
        panel3_3.setBackground(Color.WHITE);
        cokePage.add(panel3_3);

        ImageIcon icon1 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/home_icon.png");
        JButton home = new JButton(icon1);
        home.setBounds(0, 630, 40, 40);
        home.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                menu();
                cokePage.dispose();
            }
        });
        panel3_3.add(home);

        ImageIcon icon2 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/search_icon.png");
        JButton search = new JButton(icon2);
        search.setBounds(50, 630, 40, 40);
        search.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                search();
                cokePage.dispose();
            }
        });
        panel3_3.add(search);

        ImageIcon icon3 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/cart_icon.png");
        JButton cart = new JButton(icon3);
        cart.setBounds(100, 630, 40, 40);
        cart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cart();
            }
        });
        panel3_3.add(cart);

        ImageIcon icon4 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/account_icon.png");
        JButton account = new JButton(icon4);
        account.setBounds(150, 630, 40, 40);
        account.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                account();
                cokePage.dispose();
            }
        });
        panel3_3.add(account);

        ImageIcon food_icon = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/coca-colacopy.jpeg");
        JLabel food = new JLabel(food_icon);
        food.setBounds(0, 0, 350, 150);
        panel3_2.add(food);


        cokePage.add(panel3_3);

        Product menu10 = new Product();


        JLabel size = new JLabel("Size");
        size.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        size.setBounds(10,250,80, 25);
        size.setForeground(Color.RED);
        panel3_2.add(size);


        JButton size3 = new JButton("Large");
        JButton size2 = new JButton("Medium");
        JButton size1 = new JButton("Small");
        size1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        size1.setBounds(100,250,75, 25);
        size1.setBackground(Color.WHITE);
        size1.setOpaque(true);
        size1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        size1.setForeground(Color.RED);
        size1.setFocusPainted(false);
        size1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu10.setSize("small");

                size1.setForeground(Color.RED);
                size1.setBackground(Color.WHITE);
                size1.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                size2.setForeground(Color.WHITE);
                size2.setBackground(Color.RED);
                size2.setBorder(BorderFactory.createEmptyBorder());

                size3.setForeground(Color.WHITE);
                size3.setBackground(Color.RED);
                size3.setBorder(BorderFactory.createEmptyBorder());


            }
        });
        panel3_2.add(size1);

        size2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        size2.setBounds(176,250,75, 25);
        size2.setBackground(Color.RED);
        size2.setOpaque(true);
        size2.setBorder(BorderFactory.createEmptyBorder());
        size2.setForeground(Color.WHITE);
        size2.setFocusPainted(false);
        size2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu10.setSize("medium");

                size1.setForeground(Color.WHITE);
                size1.setBackground(Color.RED);
                size1.setBorder(BorderFactory.createEmptyBorder());

                size2.setForeground(Color.RED);
                size2.setBackground(Color.WHITE);
                size2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                size3.setForeground(Color.WHITE);
                size3.setBackground(Color.RED);
                size3.setBorder(BorderFactory.createEmptyBorder());


            }
        });
        panel3_2.add(size2);

        size3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        size3.setBounds(252,250,75, 25);
        size3.setBackground(Color.RED);
        size3.setOpaque(true);
        size3.setBorder(BorderFactory.createEmptyBorder());
        size3.setForeground(Color.WHITE);
        size3.setFocusPainted(false);
        size3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu10.setSize("large");

                size1.setForeground(Color.WHITE);
                size1.setBackground(Color.RED);
                size1.setBorder(BorderFactory.createEmptyBorder());

                size2.setForeground(Color.WHITE);
                size2.setBackground(Color.RED);
                size2.setBorder(BorderFactory.createEmptyBorder());

                size3.setForeground(Color.RED);
                size3.setBackground(Color.WHITE);
                size3.setBorder(BorderFactory.createLineBorder(Color.BLACK));


            }
        });
        panel3_2.add(size3);

        AtomicInteger quant = new AtomicInteger(1);
        JLabel quantity = new JLabel(" "+quant.toString()+"  ");

        JButton plus = new JButton("+");
        plus.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        plus.setBounds(110,350,30, 25);
        plus.setBackground(Color.RED);
        plus.setOpaque(true);
        plus.setBorder(BorderFactory.createEmptyBorder());
        plus.setForeground(Color.WHITE);
        plus.setBorderPainted(false);
        plus.setFocusPainted(false);
        plus.addActionListener(new ActionListener() {

                                   @Override
                                   public void actionPerformed(ActionEvent e) {
                                       quant.incrementAndGet();
                                       quantity.setText(String.valueOf(quant.get()));
                                   }
                               }
        );

        panel3_2.add(plus);

        JButton minus = new JButton("-");
        minus.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        minus.setBounds(30,350,30, 25);
        minus.setBackground(Color.RED);
        minus.setOpaque(true);
        minus.setBorder(BorderFactory.createEmptyBorder());
        minus.setForeground(Color.WHITE);
        minus.setBorderPainted(false);
        minus.setFocusPainted(false);
        minus.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (quant.get() == 1 ){
                    quant.set(Integer.valueOf(quant.get()));
                }else {
                    quant.decrementAndGet();
                    quantity.setText(String.valueOf(quant.get()));
                }

            }
        });
        panel3_2.add(minus);



        quantity.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        quantity.setBounds(80,350,30, 25);
        quantity.setForeground(Color.red);
        panel3_2.add(quantity);

        menu10.setName("Coca-Cola");
        menu10.setTopping(null);
        menu10.setCrustType(null);
        menu10.setQuantityy(quant.get());
        menu10.setPrice(2.99);
        menu10.setImage("/Users/ekeneezeobi/IdeaProjects/PPD/src/coca-cola1.jpeg");
        menu10.setSize("small");

        JButton addToCart = new JButton("Add to Cart");
        addToCart.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        addToCart.setBounds(115,450,100, 25);
        addToCart.setBackground(Color.RED);
        addToCart.setOpaque(true);
        addToCart.setBorder(BorderFactory.createEmptyBorder());
        addToCart.setForeground(Color.WHITE);
        addToCart.setBorderPainted(false);
        addToCart.setFocusPainted(false);
        addToCart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cartList.add(menu10);
            }
        });
        panel3_2.add(addToCart);

        cokePage.setVisible(true);
    }

    public static void sprite(){
        //****** Sprite Page ******#####################################################################################################################

        JFrame spritePage = new JFrame();
        spritePage.setLayout(null);
        JPanel panel1 = new JPanel();

        spritePage.setSize(350, 700);
        spritePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        spritePage.add(panel1);

        panel1.setLayout(null);


        JPanel panel3_2 = new JPanel();
        panel3_2.setBounds(0,0,350, 599);
        panel3_2.setBackground(Color.WHITE);
        panel3_2.setLayout(null);
        spritePage.add(panel3_2);

        JPanel panel3_3 = new JPanel();
        panel3_3.setBounds(0,600,350, 100);
        panel3_3.setBackground(Color.WHITE);
        spritePage.add(panel3_3);

        ImageIcon icon1 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/home_icon.png");
        JButton home = new JButton(icon1);
        home.setBounds(0, 630, 40, 40);
        home.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                menu();
                spritePage.dispose();
            }
        });
        panel3_3.add(home);

        ImageIcon icon2 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/search_icon.png");
        JButton search = new JButton(icon2);
        search.setBounds(50, 630, 40, 40);
        search.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                search();
                spritePage.dispose();
            }
        });
        panel3_3.add(search);

        ImageIcon icon3 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/cart_icon.png");
        JButton cart = new JButton(icon3);
        cart.setBounds(100, 630, 40, 40);
        cart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cart();
            }
        });
        panel3_3.add(cart);

        ImageIcon icon4 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/account_icon.png");
        JButton account = new JButton(icon4);
        account.setBounds(150, 630, 40, 40);
        account.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                account();
                spritePage.dispose();
            }
        });
        panel3_3.add(account);

        ImageIcon food_icon = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/spritecopy.jpeg");
        JLabel food = new JLabel(food_icon);
        food.setBounds(0, 0, 350, 150);
        panel3_2.add(food);

        spritePage.add(panel3_3);

        Product menu11 = new Product();


        JLabel size = new JLabel("Size");
        size.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        size.setBounds(10,250,80, 25);
        size.setForeground(Color.RED);
        panel3_2.add(size);


        JButton size3 = new JButton("Large");
        JButton size2 = new JButton("Medium");
        JButton size1 = new JButton("Small");
        size1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        size1.setBounds(100,250,75, 25);
        size1.setBackground(Color.WHITE);
        size1.setOpaque(true);
        size1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        size1.setForeground(Color.RED);
        size1.setFocusPainted(false);
        size1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu11.setSize("small");

                size1.setForeground(Color.RED);
                size1.setBackground(Color.WHITE);
                size1.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                size2.setForeground(Color.WHITE);
                size2.setBackground(Color.RED);
                size2.setBorder(BorderFactory.createEmptyBorder());

                size3.setForeground(Color.WHITE);
                size3.setBackground(Color.RED);
                size3.setBorder(BorderFactory.createEmptyBorder());


            }
        });
        panel3_2.add(size1);

        size2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        size2.setBounds(176,250,75, 25);
        size2.setBackground(Color.RED);
        size2.setOpaque(true);
        size2.setBorder(BorderFactory.createEmptyBorder());
        size2.setForeground(Color.WHITE);
        size2.setFocusPainted(false);
        size2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu11.setSize("medium");

                size1.setForeground(Color.WHITE);
                size1.setBackground(Color.RED);
                size1.setBorder(BorderFactory.createEmptyBorder());

                size2.setForeground(Color.RED);
                size2.setBackground(Color.WHITE);
                size2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                size3.setForeground(Color.WHITE);
                size3.setBackground(Color.RED);
                size3.setBorder(BorderFactory.createEmptyBorder());


            }
        });
        panel3_2.add(size2);

        size3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        size3.setBounds(252,250,75, 25);
        size3.setBackground(Color.RED);
        size3.setOpaque(true);
        size3.setBorder(BorderFactory.createEmptyBorder());
        size3.setForeground(Color.WHITE);
        size3.setFocusPainted(false);
        size3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu11.setSize("large");

                size1.setForeground(Color.WHITE);
                size1.setBackground(Color.RED);
                size1.setBorder(BorderFactory.createEmptyBorder());

                size2.setForeground(Color.WHITE);
                size2.setBackground(Color.RED);
                size2.setBorder(BorderFactory.createEmptyBorder());

                size3.setForeground(Color.RED);
                size3.setBackground(Color.WHITE);
                size3.setBorder(BorderFactory.createLineBorder(Color.BLACK));


            }
        });
        panel3_2.add(size3);

        AtomicInteger quant = new AtomicInteger(1);
        JLabel quantity = new JLabel(" "+quant.toString()+"  ");

        JButton plus = new JButton("+");
        plus.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        plus.setBounds(110,350,30, 25);
        plus.setBackground(Color.RED);
        plus.setOpaque(true);
        plus.setBorder(BorderFactory.createEmptyBorder());
        plus.setForeground(Color.WHITE);
        plus.setBorderPainted(false);
        plus.setFocusPainted(false);
        plus.addActionListener(new ActionListener() {

                                   @Override
                                   public void actionPerformed(ActionEvent e) {
                                       quant.incrementAndGet();
                                       quantity.setText(String.valueOf(quant.get()));
                                   }
                               }
        );

        panel3_2.add(plus);

        JButton minus = new JButton("-");
        minus.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        minus.setBounds(30,350,30, 25);
        minus.setBackground(Color.RED);
        minus.setOpaque(true);
        minus.setBorder(BorderFactory.createEmptyBorder());
        minus.setForeground(Color.WHITE);
        minus.setBorderPainted(false);
        minus.setFocusPainted(false);
        minus.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (quant.get() == 1 ){
                    quant.set(Integer.valueOf(quant.get()));
                }else {
                    quant.decrementAndGet();
                    quantity.setText(String.valueOf(quant.get()));
                }

            }
        });
        panel3_2.add(minus);



        quantity.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        quantity.setBounds(80,350,30, 25);
        quantity.setForeground(Color.red);
        panel3_2.add(quantity);

        menu11.setName("Sprite");
        menu11.setTopping(null);
        menu11.setCrustType(null);
        menu11.setQuantityy(quant.get());
        menu11.setPrice(2.99);
        menu11.setImage("/Users/ekeneezeobi/IdeaProjects/PPD/src/sprite1.jpeg");
        menu11.setSize("small");

        JButton addToCart = new JButton("Add to Cart");
        addToCart.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        addToCart.setBounds(115,450,100, 25);
        addToCart.setBackground(Color.RED);
        addToCart.setOpaque(true);
        addToCart.setBorder(BorderFactory.createEmptyBorder());
        addToCart.setForeground(Color.WHITE);
        addToCart.setBorderPainted(false);
        addToCart.setFocusPainted(false);
        addToCart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cartList.add(menu11);
            }
        });
        panel3_2.add(addToCart);

        spritePage.setVisible(true);
    }

    public static void water(){
        //****** Water Page ******#####################################################################################################################

        JFrame waterPage = new JFrame();
        waterPage.setLayout(null);
        JPanel panel1 = new JPanel();

        waterPage.setSize(350, 700);
        waterPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        waterPage.add(panel1);

        panel1.setLayout(null);


        JPanel panel3_2 = new JPanel();
        panel3_2.setBounds(0,0,350, 599);
        panel3_2.setBackground(Color.WHITE);
        panel3_2.setLayout(null);
        waterPage.add(panel3_2);

        JPanel panel3_3 = new JPanel();
        panel3_3.setBounds(0,600,350, 100);
        panel3_3.setBackground(Color.WHITE);
        waterPage.add(panel3_3);

        ImageIcon icon1 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/home_icon.png");
        JButton home = new JButton(icon1);
        home.setBounds(0, 630, 40, 40);
        home.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                menu();
                waterPage.dispose();
            }
        });
        panel3_3.add(home);

        ImageIcon icon2 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/search_icon.png");
        JButton search = new JButton(icon2);
        search.setBounds(50, 630, 40, 40);
        search.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                search();
                waterPage.dispose();
            }
        });
        panel3_3.add(search);

        ImageIcon icon3 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/cart_icon.png");
        JButton cart = new JButton(icon3);
        cart.setBounds(100, 630, 40, 40);
        cart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cart();
            }
        });
        panel3_3.add(cart);

        ImageIcon icon4 = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/account_icon.png");
        JButton account = new JButton(icon4);
        account.setBounds(150, 630, 40, 40);
        account.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                account();
                waterPage.dispose();
            }
        });
        panel3_3.add(account);

        ImageIcon food_icon = new ImageIcon("/Users/ekeneezeobi/IdeaProjects/PPD/src/watercopy.jpeg");
        JLabel food = new JLabel(food_icon);
        food.setBounds(0, 0, 350, 150);
        panel3_2.add(food);




        waterPage.add(panel3_3);

        Product menu12 = new Product();


        JLabel size = new JLabel("Size");
        size.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        size.setBounds(10,250,80, 25);
        size.setForeground(Color.RED);
        panel3_2.add(size);


        JButton size3 = new JButton("Large");
        JButton size2 = new JButton("Medium");
        JButton size1 = new JButton("Small");
        size1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        size1.setBounds(100,250,75, 25);
        size1.setBackground(Color.WHITE);
        size1.setOpaque(true);
        size1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        size1.setForeground(Color.RED);
        size1.setFocusPainted(false);
        size1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu12.setSize("small");

                size1.setForeground(Color.RED);
                size1.setBackground(Color.WHITE);
                size1.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                size2.setForeground(Color.WHITE);
                size2.setBackground(Color.RED);
                size2.setBorder(BorderFactory.createEmptyBorder());

                size3.setForeground(Color.WHITE);
                size3.setBackground(Color.RED);
                size3.setBorder(BorderFactory.createEmptyBorder());


            }
        });
        panel3_2.add(size1);

        size2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        size2.setBounds(176,250,75, 25);
        size2.setBackground(Color.RED);
        size2.setOpaque(true);
        size2.setBorder(BorderFactory.createEmptyBorder());
        size2.setForeground(Color.WHITE);
        size2.setFocusPainted(false);
        size2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu12.setSize("medium");

                size1.setForeground(Color.WHITE);
                size1.setBackground(Color.RED);
                size1.setBorder(BorderFactory.createEmptyBorder());

                size2.setForeground(Color.RED);
                size2.setBackground(Color.WHITE);
                size2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                size3.setForeground(Color.WHITE);
                size3.setBackground(Color.RED);
                size3.setBorder(BorderFactory.createEmptyBorder());


            }
        });
        panel3_2.add(size2);

        size3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        size3.setBounds(252,250,75, 25);
        size3.setBackground(Color.RED);
        size3.setOpaque(true);
        size3.setBorder(BorderFactory.createEmptyBorder());
        size3.setForeground(Color.WHITE);
        size3.setFocusPainted(false);
        size3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu12.setSize("large");

                size1.setForeground(Color.WHITE);
                size1.setBackground(Color.RED);
                size1.setBorder(BorderFactory.createEmptyBorder());

                size2.setForeground(Color.WHITE);
                size2.setBackground(Color.RED);
                size2.setBorder(BorderFactory.createEmptyBorder());

                size3.setForeground(Color.RED);
                size3.setBackground(Color.WHITE);
                size3.setBorder(BorderFactory.createLineBorder(Color.BLACK));


            }
        });
        panel3_2.add(size3);

        AtomicInteger quant = new AtomicInteger(1);
        JLabel quantity = new JLabel(" "+quant.toString()+"  ");

        JButton plus = new JButton("+");
        plus.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        plus.setBounds(110,350,30, 25);
        plus.setBackground(Color.RED);
        plus.setOpaque(true);
        plus.setBorder(BorderFactory.createEmptyBorder());
        plus.setForeground(Color.WHITE);
        plus.setBorderPainted(false);
        plus.setFocusPainted(false);
        plus.addActionListener(new ActionListener() {

                                   @Override
                                   public void actionPerformed(ActionEvent e) {
                                       quant.incrementAndGet();
                                       quantity.setText(String.valueOf(quant.get()));
                                   }
                               }
        );

        panel3_2.add(plus);

        JButton minus = new JButton("-");
        minus.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        minus.setBounds(30,350,30, 25);
        minus.setBackground(Color.RED);
        minus.setOpaque(true);
        minus.setBorder(BorderFactory.createEmptyBorder());
        minus.setForeground(Color.WHITE);
        minus.setBorderPainted(false);
        minus.setFocusPainted(false);
        minus.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (quant.get() == 1 ){
                    quant.set(Integer.valueOf(quant.get()));
                }else {
                    quant.decrementAndGet();
                    quantity.setText(String.valueOf(quant.get()));
                }

            }
        });
        panel3_2.add(minus);



        quantity.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        quantity.setBounds(80,350,30, 25);
        quantity.setForeground(Color.red);
        panel3_2.add(quantity);

        menu12.setName("Water");
        menu12.setTopping(null);
        menu12.setCrustType(null);
        menu12.setQuantityy(quant.get());
        menu12.setPrice(2.99);
        menu12.setImage("/Users/ekeneezeobi/IdeaProjects/PPD/src/water1.jpeg");
        menu12.setSize("small");


        JButton addToCart = new JButton("Add to Cart");
        addToCart.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        addToCart.setBounds(115,450,100, 25);
        addToCart.setBackground(Color.RED);
        addToCart.setOpaque(true);
        addToCart.setBorder(BorderFactory.createEmptyBorder());
        addToCart.setForeground(Color.WHITE);
        addToCart.setBorderPainted(false);
        addToCart.setFocusPainted(false);
        addToCart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cartList.add(menu12);
            }
        });
        panel3_2.add(addToCart);

        waterPage.setVisible(true);
    }



}