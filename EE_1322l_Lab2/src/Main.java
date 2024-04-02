import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        StockItem Milk = new StockItem("Milk","1 Gallon of Milk", 3.60f, 15);
        StockItem Bread = new StockItem("Bread","1 Loaf of Bread", 1.98f,30);

        Scanner scanner = new Scanner(System.in);
        int menuOption;

        do {
                System.out.println("1. Sold One Milk\n" +
                    "2. Sold One Bread\n" +
                    "3. Change price of Milk\n" +
                    "4. Change price of Bread\n" +
                    "5. Add Milk to Inventory\n" +
                    "6. Add Bread to Inventory\n" +
                    "7. See Inventory\n" +
                    "8. Quit");
                 menuOption = scanner.nextInt();


            switch (menuOption) {
                case 1:
                    Milk.lowerQuantity();
                    break;

                case 2:
                    Bread.lowerQuantity();
                    break;

                case 3:
                    System.out.println("What is the new price for Milk");
                    float newMilkPrice = scanner.nextFloat();
                    Milk.setPrice(newMilkPrice);
                    break;

                case 4:
                    System.out.println("What is the new price for Bread");
                    float newBreadPrice = scanner.nextFloat();
                    Bread.setPrice(newBreadPrice);
                    break;

                case 5:
                    System.out.println("How many gallons of milk did we get?");
                    int newMilkQuantity = scanner.nextInt();
                    Milk.setQuantity(newMilkQuantity);
                    break;

                case 6:
                    System.out.println("How many loafs of bread did we get?");
                    int newBreadQuantity = scanner.nextInt();
                    Bread.setQuantity(newBreadQuantity);
                    break;

                case 7:
                    System.out.println(Milk);
                    System.out.println(Bread);
                    break;

                case 8:
                    break;
            }
            System.out.println();
        }while(menuOption!=8);


    }
}