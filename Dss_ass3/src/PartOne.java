// Name:	Ekene Ezeobi
// Class:	CS 3305/ W03
// Term:	Fall 2023
//	Instructor:  Carla McManus
//	Assignment:  3 – Part 1 Iterator

import java.util.LinkedList;
import java.util.Iterator;

public class PartOne {

    static private LinkedList<Integer> myLinkedList;

    public static void main(String[] args) {
        myLinkedList = new LinkedList<Integer>(); //creating a linked list of integers
        myLinkedList.add(1); //adding the integers
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(4);
        myLinkedList.add(5);
        myLinkedList.add(6);
        myLinkedList.add(7);




        removeRepetitions(); //calling the remove repetition method

        printRange(2,5); //printing range 2 to 5
        printRange(2,78);//printing range 2 to 78
        printRange(2,1);//printing range 2 to 1
        printRange(8,5);//printing range 8 to 5
    }

    public static void printRange(int x, int y){
        boolean isXFound = false; // use to check if x is found
        for (int i = 0; i < myLinkedList.size(); i++) {
            if (myLinkedList.get(i) == x) {
                isXFound = true;
            }

            if (isXFound) {
                if (myLinkedList.get(i) == y) {
                    break;
                }
                System.out.print(myLinkedList.get(i) + " ");
            }
        }
        System.out.println();
    }



    public static void removeRepetitions(){ //method to remove duplicate numbers

        Iterator<Integer> iterator = myLinkedList.iterator();
        int prev = iterator.next(); // Gets the first element
        while (iterator.hasNext()) {
            int current = iterator.next();
            if (prev == current) {
                iterator.remove(); // Removes the duplicate value
            } else {
                prev = current; // Moves to the next element
            }
        }
    }
}
