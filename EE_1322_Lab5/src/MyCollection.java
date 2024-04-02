import java.util.Scanner;

public class MyCollection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Item[] myCollection = new Item[5];
        for (int i = 0; i < 5; i++) {
            System.out.println("Please enter B for Book or P for Periodical");
            String bOrP = scanner.nextLine();

            switch (bOrP) {
                case "B" -> {
                    System.out.println("Please enter the name of the Book");
                    String title = scanner.nextLine();
                    System.out.println("Please enter the author of the Book");
                    String author = scanner.nextLine();
                    System.out.println("Please enter the ISBN of the Book");
                    int isbn_number = scanner.nextInt();
                    myCollection[i] = new Book(title, isbn_number, author);
                }
                case "P" -> {
                    System.out.println("Please enter the name of Periodical");
                    String title = scanner.nextLine();
                    System.out.println("Please enter the issue number");
                    int issueNum = scanner.nextInt();
                    myCollection[i] = new Periodical(title, issueNum);
                }
            }
            scanner.nextLine();

            System.out.println(" ");
        }

        System.out.println("Your Items: ");
        for (Item x: myCollection){
            System.out.println(x.getListing());
            System.out.println(" ");
        }
    }
}