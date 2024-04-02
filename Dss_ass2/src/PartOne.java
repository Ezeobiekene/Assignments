// Name:	Ekene Ezeobi
// Class:	CS 3305/ W03
// Term:	Fall 2023
//	Instructor:  Carla McManus
//	Assignment: 2 – Part 1 Factorial

import  java.util.Scanner;

public class PartOne {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a nonnegative number: "); //number prompt
        int n = scanner.nextInt(); //assigning a variable to the input number
        int result = factorial(n);//calling the recursive method
        System.out.println("Factorial of " + n + " is " + result); //display statement
    }

    public static int factorial(int num){ //factorial method takes in the given number and returns an int (the factorial of the number)
        if(num == 1 || num ==2){ //base condition
            return num; //because factorial of 1 is 1 and factorial of 2 is 2
        }else{
            return num * factorial(num - 1); //recusive call, "num - 1" bringing the num closer to the base condition
        }
    }
}
