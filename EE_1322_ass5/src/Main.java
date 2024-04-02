public class Main {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            String fold_string = paperFold(i);
            System.out.println("For " + i + " folds we get: " + fold_string + "\n");
        }
    }

    public static String reverse(String word) {
        if (word.length() == 1) {
            return word;
        } else {
            return reverse(word.substring(1)) + word.charAt(0);
        }
    }

    public static String flip(String letterToFlip) {
        return letterToFlip.replace('^', 't').replace('v', '^').replace('t', 'v');
    }

    public static String paperFold(int number) {
        if (number == 1) {
            return "v";
        } else {
            String previousFold = paperFold(number - 1);
            String reversedFold = reverse(previousFold);
            String flippedFold = flip(reversedFold);
            return flippedFold + "v" + previousFold;
        }
    }
}
