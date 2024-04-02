import java.util.ArrayList;
public class Poker {
    private final PlayingCards deck;
    private ArrayList<String> hand1;
    private ArrayList<String> hand2;

    public void dealHands(){
        hand1 = new ArrayList<>();
        hand2 = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            hand1.add(deck.getNextCard());
            hand2.add(deck.getNextCard());
        }
    }
    public Poker() {
        deck = new PlayingCards();
        deck.Shuffle();
        dealHands();
    }
    public Poker(ArrayList<String> hand1, ArrayList<String> hand2){
        deck = new PlayingCards();
        this.hand1 = hand1;
        this.hand2 = hand2;
    }
    public void showHand(int user){
        if (user == 1){
            System.out.println("Player 1's hand:");
            for (String card : hand1) {
                System.out.print(card + " ");
            }
            System.out.println();
        }else{
            System.out.println("Player 2's hand:");
            for (String card : hand2) {
                System.out.print(card + " ");
            }
            System.out.println();
        }
    }

    public  int[] countSuite(ArrayList<String> hand){
        int[] count = new int[4];
        for (String card : hand){
            String[] parts = card.split(" ");
            String suite = parts[2];

            switch (suite) {
                case "Clubs" -> count[0]++;
                case "Diamonds" -> count[1]++;
                case "Hearts" -> count[2]++;
                case "Spades" -> count[3]++;
            }

        }
        return count;
    }

    public int[] countValues(ArrayList<String> hand){
        int[] count = new int[14];

        for (String card : hand){
            String[] parts = card.split(" ");
            String value = parts[0];

            switch (value) {
                case "A" -> count[1]++;
                case "2" -> count[2]++;
                case "3" -> count[3]++;
                case "4" -> count[4]++;
                case "5" -> count[5]++;
                case "6" -> count[6]++;
                case "7" -> count[7]++;
                case "8" -> count[8]++;
                case "9" -> count[9]++;
                case "10" -> count[10]++;
                case "J" -> count[11]++;
                case "Q" -> count[12]++;
                case "K" -> count[13]++;
            }

        }
        return count;
    }

    public int numPairs(int[] countValues){
        int numOfPairs =0;
        for(int count : countValues){
            if (count == 2){
                numOfPairs++;
            }
        }

        return numOfPairs;
    }

    public int threeOfAKind(int[] countValues){
        for (int i = 1; i < countValues.length; i++){
            if (countValues[i] == 3) {

                return i;
            }
        }

        return 0;
    }
    public int fourOfAKind(int[] countValues) {
        for (int i = 1; i < countValues.length; i++) {
            if (countValues[i] == 4) {
                return i;
            }
        }
        return 0;
    }

    public boolean fullHouse(int[] countValues){
        boolean isFullHouse = false;
        
        for (int countValue : countValues) {
            if ((countValue == 3) && (numPairs(countValues) == 1)) {
               isFullHouse = true;
            }
        }
        return isFullHouse;
    }

    public boolean straight(int[] countValues){
        int count = 0;
        for (int countValue : countValues) {
            if (countValue == 1) {
                count++;
                if (count == 5) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean flush(ArrayList<String> hand){
        int[] suiteCount = countSuite(hand);
        for (int count : suiteCount) {
            if (count == 5) {
                return true;
            }
        }
        return false;
    }

    public boolean straightFlush(ArrayList<String> hand, int[] countValues){

        return straight(countValues) && flush(hand);
    }

    public boolean royalFlush(ArrayList<String> hand){
        int[] valueCount = countValues(hand);
        int[] count = countSuite(hand);
        for (int countValue : valueCount) {
            if (countValue == 5){
                if (count[1]==1 && count[10]==1 && count[11]==1 && count[12]==1 &&count[13]==1){
                    return true;
                }
            }
        }
     return false;
    }

    public String scoreHand(int user){
        ArrayList<String> hand;

        if(user == 1) {
            hand = hand1;
        } else {
            hand = hand2;
        }

        if(royalFlush(hand)){
            return "Royal Flush";
        }
        if (straightFlush(hand, countValues(hand))) {
            return "Straight Flush";
        }
        if (fourOfAKind(countValues(hand)) != 0) {
            return "4 of a kind";
        }
        if (fullHouse(countValues(hand))){
            return "Full House";
        }
        if (flush(hand)){
            return "Flush";
        }
        if(straight(countValues(hand))){
            return "Straight";
        }
        if(threeOfAKind(countValues(hand)) != 0){
            return "3 of a kind";
        }
        if (numPairs(countValues(hand)) == 2){
            return "2 pairs";
        }
        if (numPairs(countValues(hand)) == 1){
            return "1 pair";
        }
        return "High Card";
    }
}

