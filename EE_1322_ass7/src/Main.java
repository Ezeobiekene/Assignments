import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        StatisticGradeBook statGradeBook = new StatisticGradeBook("/Users/ekeneezeobi/Downloads/Assignment7-Spreadsheet.csv");
        Thread thread = new Thread(statGradeBook);
        thread.start();

        Scanner scanner = new Scanner(System.in);

        System.out.println("What student would you like to see grades for");
        String name = scanner.nextLine();

        statGradeBook.getStudentGrade(name);
    }

}
