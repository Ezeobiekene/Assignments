import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        BlueRayCollection myCollection = new BlueRayCollection();

        Scanner scanner = new Scanner(System.in);
        int menuOption;
        do{
            System.out.println(" ");
            System.out.println("0. Quit\n" +
                    "1. Add BlueRay to collection \n" +
                    "2. See collection ");
            menuOption = scanner.nextInt();

            scanner.nextLine();

            switch (menuOption){

                case 0:
                    break;
                case 1:
                    System.out.println("What is the title?");
                    String title = scanner.nextLine();

                    System.out.println("What is the director?");
                    String director = scanner.nextLine();

                    System.out.println("What is the year of release?");
                    int yearOfRelease = scanner.nextInt();

                    System.out.println("What is the cost?");
                    double cost = scanner.nextDouble();

                    myCollection.add(title,director,yearOfRelease,cost);
                    break;
                case 2:
                    myCollection.show_all();
                    break;
            }

        }while (menuOption != 0);

    }

}
