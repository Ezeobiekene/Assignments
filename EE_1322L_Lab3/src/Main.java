import java.util.Scanner;

public class Main {
    public static void main(String[] args){


        Quiz myQuiz = new Quiz();
        Scanner scanner = new Scanner(System.in);
        int menuOption;

        do {
            System.out.println("What would you like to do?");
            System.out.println("""
                    1. Add a question to the quiz
                    2. Remove a question from the quiz
                    3. Modify a question in the quiz
                    4. Take the quiz
                    5. Quit""");
            menuOption = scanner.nextInt();

            switch (menuOption){
                case 1: myQuiz.add_question();
                break;

                case 2: myQuiz.remove_question();
                break;

                case 3: myQuiz.modify_question();
                    break;
                case 4: myQuiz.give_quiz();
                    break;
                case 5:
                    break;
            }
                System.out.println(" ");

        }while (menuOption != 5);

        }
}
