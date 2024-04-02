// Name:	Ekene Ezeobi
// Class:	CS 3305/W03
// Term:	Fall 2023
//	Instructor:  Carla McManus
//	Assignment:  2 – Part 2 Recursion

import java.util.Scanner;

public class PartTwo {

    //the variables are here because I need them to be usable in all methods
    static int temp;
    static int num;
    static int count = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the desired number of levels"); //prompt for input
        num = scanner.nextInt();//save input into a variable
        temp = num;
        System.out.println(recursion(num));//calling the recursive method and passing the given integer
    }
    public static String recursion(int num){

      if(num == 1){
          return recursionHelper(temp) + "This was written by call number " + temp + ". \n" + recursionHelper(temp) +
                  "This was ALSO written by call number " + temp + ".\n";
        }//base condition
        else if(num == temp){

          return recursionHelper(1) + "This was written by call number " + 1 + ". \n" +recursion(num-1)+ recursionHelper(1) +
                  "This was ALSO written by call number " + (1) + ".\n";//prints out the first and last statements
        }else{
          count++;
          String printOut = recursionHelper(1+count) + "This was written by call number " + (1+count) + ". \n" +recursion(num-1)+ recursionHelper(1+count) +
                  "This was ALSO written by call number " + (1+count) + ".\n";
          count--;
          return printOut;//prints the other statements, count++ and count-- are used to move the numbers up and down
        }


    }

        public static String recursionHelper(int n){//method to print the spaces
            if (n == 1){
                return "";
            } else{
            return "  " + recursionHelper(n-1);
        }
    }
}
