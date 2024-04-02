// Name:	Ekene Ezeobi
// Class:	CS 3305/ W03
// Term:	Spring 2023
//	Instructor:  Carla McManus
//	Assignment:  05-Part-1-Queues

import java.util.LinkedList;

public class Chores {

    String name;
    int priority;

    public Chores(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return name + ", " + priority ;
    }
}
