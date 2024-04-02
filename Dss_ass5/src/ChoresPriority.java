import java.util.LinkedList;
import java.util.Scanner;

public class ChoresPriority {
    LinkedList<Chores> choreList = new LinkedList<>();
    Chores first;
    Chores last;

    public void addChore(Chores chore) {
        int index = 0;

        if (first == null && last == null) {
            choreList.add(chore);
        } else {
            while (chore.priority <= choreList.get(index).priority) {
                index++;
            }
            choreList.add(index, chore);
        }
        while()
    }

    public Chores removeChore() {
        if (!choreList.isEmpty()) {
            return choreList.removeFirst();
        }
        return null;
    }
    public LinkedList<Chores> display() {
        return choreList;
    }


    public static void main(String[] args) {
        ChoresPriority choresPriority = new ChoresPriority();
        Scanner scanner = new Scanner(System.in);
        int x = 0;
        do {
            System.out.println("Enter a chore");
            String name = scanner.nextLine();

            System.out.println("Enter your chores priority");
            int priority = scanner.nextInt();

            Chores chore = new Chores(name, priority);
            choresPriority.addChore(chore);
            System.out.println();
            scanner.nextLine();
            x++;

        }while(x != 4);

        System.out.println(choresPriority.display());
        choresPriority.removeChore();
        System.out.println(choresPriority.display());
    }
}
