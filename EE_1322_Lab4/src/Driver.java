import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Checking myChecking = new Checking(100);
        Savings mySavings = new Savings(2000);

        int menuOption;
        do{

            System.out.println(" ");
            System.out.println("""
                    1. Withdraw from Checking
                    2. Withdraw from Savings
                    3. Deposit to Checking
                    4. Deposit to Savings
                    5. Balance of Checking
                    6. Balance of Savings
                    7. Award Interest to Savings now
                    8. Quit""");
            menuOption = scanner.nextInt();

            switch (menuOption){
                case 1:
                    System.out.println("How much would you like to withdraw from Checking?");
                    int checkingWithdraw = scanner.nextInt();
                    myChecking.withdrawMoney(checkingWithdraw);
                    break;

                case 2:
                    System.out.println("How much would you like to withdraw from Savings?");
                    int savingsWithdraw = scanner.nextInt();
                    mySavings.withdrawMoney(savingsWithdraw);
                    break;

                case 3:
                    System.out.println("How much would you like to deposit into Checking?");
                    int checkingDeposit = scanner.nextInt();
                    myChecking.depositMoney(checkingDeposit);
                    break;

                case 4:
                    System.out.println("How much would you like to deposit into Savings?");
                    int savingsDeposit = scanner.nextInt();
                    myChecking.depositMoney(savingsDeposit);
                    break;

                case 5:
                    System.out.println("Your balance for checking " + myChecking.getAccountNumber() + " is " + myChecking.getAccountBalance());
                    break;

                case 6:
                    System.out.println("Your balance for savings " + mySavings.getAccountNumber() + " is " + mySavings.getAccountBalance());
                    break;

                case 7:
                    mySavings.interest();
                    break;

                case 8:
                    break;
            }

        }while(menuOption != 8);

    }

}
