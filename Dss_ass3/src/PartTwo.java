// Name:	Ekene Ezeobi
// Class:	CS 3305/ W03
// Term:	Spring 2023
//	Instructor:  Carla McManus
//	Assignment:  3 – Part 2 Capitals


import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class PartTwo {

    public static void main(String[] args) {
        Random rand = new Random();


        int correctCount = 0;
        String[][] array = { // the array that contains the
                {"Alabama", "Montgomery"},
                {"Alaska", "Juneau"},
                {"Arizona", "Phoenix"},
                {"Arkansas", "Little Rock"},
                {"California", "Sacramento"},
                {"Colorado", "Denver"},
                {"Connecticut", "Hartford"},
                {"Delaware", "Dover"},
                {"Florida", "Tallahassee"},
                {"Georgia", "Atlanta"},
                {"Hawaii", "Honolulu"},
                {"Idaho", "Boise"},
                {"Illinois", "Springfield"},
                {"Indiana", "Indianapolis"},
                {"Iowa", "Des Moines"},
                {"Kansas", "Topeka"},
                {"Kentucky", "Frankfort"},
                {"Louisiana", "Baton Rouge"},
                {"Maine", "Augusta"},
                {"Maryland", "Annapolis"},
                {"Massachusetts", "Boston"},
                {"Michigan", "Lansing"},
                {"Minnesota", "Saint Paul"},
                {"Mississippi", "Jackson"},
                {"Missouri", "Jefferson City"},
                {"Montana", "Helena"},
                {"Nebraska", "Lincoln"},
                {"Nevada", "Carson City"},
                {"New Hampshire", "Concord"},
                {"New Jersey", "Trenton"},
                {"New Mexico", "Santa Fe"},
                {"New York", "Albany"},
                {"North Carolina", "Raleigh"},
                {"North Dakota", "Bismarck"},
                {"Ohio", "Columbus"},
                {"Oklahoma", "Oklahoma City"},
                {"Oregon", "Salem"},
                {"Pennsylvania", "Harrisburg"},
                {"Rhode Island", "Providence"},
                {"South Carolina", "Columbia"},
                {"South Dakota", "Pierre"},
                {"Tennessee", "Nashville"},
                {"Texas", "Austin"},
                {"Utah", "Salt Lake City"},
                {"Vermont", "Montpelier"},
                {"Virginia", "Richmond"},
                {"Washington", "Olympia"},
                {"West Virginia", "Charleston"},
                {"Wisconsin", "Madison"},
                {"Wyoming", "Cheyenne"}
        };

        System.out.println("Welcome to the State and Capital Game!!!");
        System.out.println(" ");
        System.out.println(" ");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.print(".   ");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.print(".   ");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.print(".   \n");

        try {
            TimeUnit.SECONDS.sleep(1); //added some pauses for fun
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Starting game...");
        System.out.println(" ");

        game(array, correctCount, rand); // calling the game method
    }


    public static void game( String[][] array, int correctCount, Random rand) {
        Scanner scanner = new Scanner(System.in);


                for (int i = 0; i < 5; i++) { // to ask different state capitals 5 times
                    int num;
                    System.out.println("What is the capital city of " + array[num = (rand.nextInt(50) + 1)][0] + "?");
                    String answer = scanner.next();

                    if (answer.equalsIgnoreCase(array[num][1])) {
                        System.out.println("Your answer is correct!!");
                        System.out.println(" ");
                        correctCount++;
                    } else {
                        System.out.println("The correct answer is " + array[num][1]);
                        System.out.println(" ");
                    }
                }
                System.out.println("You got " + correctCount + " out of 5 right"); //telling user their score
                playOrQuit(array, rand); // calling method to quit or play
    }




    public static void playOrQuit ( String[][] array, Random rand) { // method to quit or play
        Scanner scanner = new Scanner(System.in);

        System.out.println(" ");
        System.out.println("Press 1 for new game");
        System.out.println("Press 2 to quit");
        int number = scanner.nextInt();


        while (number < 3) {
            if (number != 2) {
                int correctCount = 0;
                game(array, correctCount, rand);
            }else {
                System.out.println("Existing....");
                number = number + 2;
            }

        }
        System.out.println(" ");
    }
}