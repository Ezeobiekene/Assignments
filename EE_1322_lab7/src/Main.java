import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Calculator myCalculator = new Calculator();

        Scanner scanner = new Scanner(System.in);
        int menuOption;


        do{
            System.out.println("0 - Exit");
            System.out.println("1 - Addition");
            System.out.println("2 - Subtraction");
            System.out.println("3 - Multiplication");
            System.out.println("4 - Division");
            System.out.print("Please Choose an Option: ");
            menuOption = scanner.nextInt();

            switch(menuOption){
                case 0:
                    break;

                case 1:
                    System.out.print("Please enter the first number: ");
                    int a = scanner.nextInt();

                    System.out.print("Please enter the second number: ");
                    int b = scanner.nextInt();

                    System.out.println(myCalculator.add(a,b));
                    break;

                case 2:
                    System.out.print("Please enter the first number: ");
                    int c = scanner.nextInt();

                    System.out.print("Please enter the second number: ");
                    int d = scanner.nextInt();

                    System.out.println(myCalculator.subtract(c,d));
                    break;

                case 3:
                    System.out.print("Please enter the first number: ");
                    int e = scanner.nextInt();

                    System.out.print("Please enter the second number: ");
                    int f = scanner.nextInt();

                    System.out.println(myCalculator.multiply(e,f));
                    break;

                case 4:
                    System.out.print("Please enter the first number: ");
                    int g = scanner.nextInt();

                    System.out.print("Please enter the second number: ");
                    int h = scanner.nextInt();

                    System.out.println(myCalculator.divide(g,h));
                    break;
            }
            System.out.println(" ");
        }while(menuOption != 0);
    }
}