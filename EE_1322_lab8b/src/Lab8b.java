import java.util.Scanner;

class Lab8b{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println(repeatNTimes("I must study recursion until it makes sense\n", 100));

          System.out.println("Enter the first string");
          String s1 = scanner.nextLine();

          System.out.println("Enter the second string");
          String s2 = scanner.nextLine();

         if(isReverse(s1,s2)){
           System.out.println(s1+ " is the reverse of "+s2);
         }else{
           System.out.println(s1+" is not the reverse of " +s2);
         }
    }

    public static String repeatNTimes(String words, int numbers){
        if(numbers == 0){
            return "";
        }else{
            return words+repeatNTimes(words, numbers-1);
        }
    }

    public static boolean isReverse(String wordOne, String wordTwo){
        if(wordOne.isEmpty() && wordTwo.isEmpty()){
            return true;
        }
        if(wordOne.length()==1 && wordTwo.length()==1){
            return true;
        }
        if(wordOne.charAt(0) == wordTwo.charAt(wordTwo.length() - 1)) {
            return isReverse(wordOne.substring(1), wordTwo.substring(0, wordTwo.length() - 1));
        } else {
            return false;
        }

    }
}