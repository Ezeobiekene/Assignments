
import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {
    static ArrayList<Question> quiz = new ArrayList<>();

    public void add_question(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the question text?");
        String newText = scanner.nextLine();

        System.out.println("What is the answer?");
        String newAnswer = scanner.nextLine();

        System.out.println("How Difficult (1-3)?");
        int newLevelOfDifficulty = scanner.nextInt();

        Question theQuestions = new Question(newText, newAnswer, newLevelOfDifficulty );
        quiz.add(theQuestions);
    }

    public void remove_question()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose the question to remove?");

                for(int i =0; i < quiz.size(); i++){
                    System.out.println(i+". "+ quiz.get(i).getText());
                }
        int question_to_remove = scanner.nextInt();
        Question theQuestion = quiz.get(question_to_remove);

        quiz.remove(theQuestion);

    }

    public void modify_question(){
        Scanner scanner = new Scanner(System.in);


        System.out.println("Choose the question to modify?");
        for(int i =0; i < quiz.size(); i++){
            System.out.println(i+". "+ quiz.get(i).getText());
        }
        int question_to_modify = scanner.nextInt();

        scanner.nextLine();

        System.out.println("What is the question text?");
        String newText = scanner.nextLine();
        quiz.get(question_to_modify).setText(newText);

        System.out.println("What is the answer?");
        String newAnswer = scanner.nextLine();
        quiz.get(question_to_modify).setAnswer(newAnswer);

        System.out.println("How Difficult (1-3)?");
        int newLevelOfDifficulty = scanner.nextInt();
        quiz.get(question_to_modify).setLevelOfDifficulty(newLevelOfDifficulty);


    }

    public void give_quiz(){
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        for(int i =0; i < quiz.size(); i++){
            System.out.println(i+". "+ quiz.get(i).getText());
            String userAnswer = scanner.nextLine();

            if (userAnswer.equals(quiz.get(i).getAnswer())){
                System.out.println("Correct");
                score++;
            } else {
                System.out.println("Incorrect");
            }

        }
        System.out.println("You got "+score+" out of "+quiz.size());
    }
}
