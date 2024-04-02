import java.util.ArrayList;

public class ArrayListPractice {

    public static void main(String[] args) {

        /*
         This line of code creates an ArrayList of the object Integer and names it numbers. This means that there
         are a bunch of Integer in the ArrayList called numbers ie numbers holds multiple integers.
        */
        ArrayList<Integer> numbers = new ArrayList<>();


        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(24);
        numbers.add(25);
        numbers.add(78);
        numbers.add(203);
        int myEx = 0;

        /*
        This is the for each loop used in only ArrayLists. It basically says for each single number in
         the ArrayList of object Integer named numbers, print out myEx(A previously named variable) and add
         one each time it goes around.
        */
        for (int singleNumber : numbers){
            System.out.println(myEx+=1);
        }

        // This is the same as the code above but in a regular for loop.
        for (int i=0; i< numbers.size(); i++){
            System.out.println(myEx);
            myEx++;
        }



    }

}
