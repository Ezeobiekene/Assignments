import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        ArrayList<Customer> myCustomers = new ArrayList<>();
        menu(myCustomers);
    }
    public static void menu(ArrayList<Customer> myCustomer){
        Scanner scanner = new Scanner(System.in);
        int menuOption;

        do{
            System.out.println("1. Take test for new license\n" +
                    "2. Renew existing license\n" +
                    "3. Move from out of state\n" +
                    "4. Answer citation/suspended license\n" +
                    "5. See current queue\n" +
                    "6. Quit");
                  menuOption = scanner.nextInt();
                    scanner.nextLine();

                  switch (menuOption){
                      case 1:
                          System.out.println("What is your name?");
                          String name1 = scanner.nextLine();
                          System.out.println("What is your date of birth?");
                          String dOB = scanner.nextLine();
                          myCustomer.add(new NewTest(name1,dOB));
                          break;
                      case 2:
                          System.out.println("What is your name?");
                          String name2 = scanner.nextLine();
                          myCustomer.add(new Renew(name2));
                          break;
                      case 3:
                          System.out.println("What is your name?");
                          String name3 = scanner.nextLine();
                          System.out.println("What state did you move from?");
                          String state = scanner.nextLine();
                          myCustomer.add(new Move(name3, state));
                          break;
                      case 4:
                          System.out.println("What is your name?");
                          String name4 = scanner.nextLine();
                          System.out.println("What violation did you commit?");
                          String violation = scanner.nextLine();
                          myCustomer.add(new Suspended(name4, violation));
                          break;
                      case 5:
                          for(Customer c : myCustomer){
                              System.out.println(c.getCustomerInfo());
                          }
                          break;
                      case 6:
                          break;
                  }
                  System.out.println(" ");
        }while (menuOption != 6);
    }
}
