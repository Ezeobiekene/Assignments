// Name:	Ekene Ezeobi
// Class:	CS 3305/ W03
// Term:	Spring 2023
//	Instructor:  Carla McManus
//	Assignment:  04-Part-1-Stacks

import java.util.Scanner;

public class StackPair {
    private static int[] array;
    private int topA;
    private int topB;
    private final int size;



    public StackPair(int capacity) {//StackPair constructor
        array = new int[capacity];
        size = capacity;
        topA = -1;
        topB = size;
    }

    public int popA() {// method to delete value from stack A
        if (isEmptyA()) {
            System.out.println("StackA is empty.");
            return -1;
        }
        int temp = array[topA];
        array[topA] = 0;
        topA--;
        return temp;
    }

    public int popB() {// method to delete value from stack B
        if (isEmptyB()) {
            System.out.println("StackB is empty.");
            return -1;
        }
        int temp = array[topB];
        array[topB] = 0;
        topB++;
        return temp;
    }

    public void pushA(int value) {// method to add value to stack A
        if (isFull()) {
            System.out.println("Array is full. Cannot push to StackA.");
            return;
        }
        array[++topA] = value;
    }

    public void pushB(int value) {// method to add value to stack B
        if (isFull()) {
            System.out.println("Array is full. Cannot push to StackB.");
            return;
        }
        array[--topB] = value;
    }

    public boolean isEmptyA() {//to check if stack A is empty
        return topA == -1;
    }

    public boolean isEmptyB() {//to check if stack B is empty
        return topB == size;
    }

    public boolean isFull() { //to check if the array is full
        return (topA + 1) == topB;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your desired number of arrays");
        int intArray = scanner.nextInt();
        StackPair stackPair = new StackPair(intArray);

        //user menu to input values to stack A or B
        int menuOption;
        do {
            System.out.println("Enter 1 to push to stack A, 2 for stack B and 3 to quit");
            menuOption = scanner.nextInt();

            switch (menuOption) {
                case 1:
                    System.out.println("What value would you like to push to stack A");
                    int valueA = scanner.nextInt();
                    stackPair.pushA(valueA);
                    break;
                case 2:
                    System.out.println("What value would you like to push to stack B");
                    int valueB = scanner.nextInt();
                    stackPair.pushB(valueB);
                    break;
                case 3:
                    break;
            }
        }while (menuOption != 3);


        //print the array(Stack A and B)
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();

            int menuOption1;

            //user input for what values will be popped
        do {
            System.out.println("Enter 1 to pop from stack A, 2 for stack B and 3 to quit");
            menuOption1 = scanner.nextInt();

            switch (menuOption1) {
                case 1:
                    System.out.println(stackPair.popA()+" was popped from stack A");
                    break;
                case 2:

                    System.out.println(stackPair.popB()+ " was popped from stack B");
                    break;
                case 3:
                    break;
            }
        }while(menuOption1 != 3);

        //print the array after some values have been popped
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


}

