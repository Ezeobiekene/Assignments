// Name:	Ekene Ezeobi
// Class:	CS 3305/ W03
// Term:	Spring 2023
//	Instructor:  Carla McManus
//	Assignment:  04-Part-2-Palindromes

import java.util.Stack;
import java.util.Scanner;

public class PartTwo {
    static Stack<Character> stackOne = new Stack<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a word"); //input word from the user
        String word = scanner.nextLine();

        boolean results = isPalindromes(word); // printing the results
        if (results) {
            System.out.println( word + " is a palindrome.");
        } else {
            System.out.println( word + " is not a palindrome.");
        }

    }


    public static boolean isPalindromes(String word){
        //creating the three stacks
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        Stack<Character> stack3 = new Stack<>();

        char[] charArray = word.toCharArray(); //converting from String to char

        for (char c : charArray) { //adding the characters from the charArray to both stack 1 and 2
            stack1.push(c);
            stack2.push(c);
        }

        while (!stack1.isEmpty()) { //popping from stack 1 to 3
            stack3.push(stack1.pop());
        }

        return stack2.equals(stack3); //comparing stack 2 and 3
    }
}