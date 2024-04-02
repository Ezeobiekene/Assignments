import java.util.ArrayList;
import java.util.Arrays;

public class Poker {
    private PlayingCards deck;
    private ArrayList<String> hand1 = new ArrayList<String>();
    private ArrayList<String> hand2 = new ArrayList<String>();
    public void dealHands(){
        // use add() method to 5 cards to each hand, alternating:
        hand1.add(deck.getNextCard());
        hand2.add(deck.getNextCard());
        hand1.add(deck.getNextCard());
        hand2.add(deck.getNextCard());
        hand1.add(deck.getNextCard());
        hand2.add(deck.getNextCard());
        hand1.add(deck.getNextCard());
        hand2.add(deck.getNextCard());
        hand1.add(deck.getNextCard());
        hand2.add(deck.getNextCard());
    }

    //CONSTRUCTOR SECTION STARTS HERE
    // Create a class constructor for the Poker class
    //First Constructor -- this one takes no parameters:
    public Poker() {
        //"Instantiate a PlayingCard Object on your deck variable"??
        deck = new PlayingCards();
        //"call the shuffle() method in PlayingCard to shuffle the deck"
        deck.Shuffle();
        //call the dealHands method
        dealHands();
    }

    //Second Constructor - this one takes two ArrayLists as parameters:
    //I renamed the parameters as passedHand1 and passedHand2 but this may be wrong
    public Poker(ArrayList passedHand1, ArrayList passedHand2) {
        deck = new PlayingCards();
        hand1 = passedHand1;
        hand2 = passedHand2;
        // this constructor will be used to test the code later.
    }

    //METHOD SECTION STARTS HERE:
    //this METHOD  is used to show the players hand depending on if 1 or 2 is passed in
    void showHand(int playerNumber) {
        if (playerNumber == 1) {
            System.out.println("Player 1's hand:" );
            for (int i = 0; i<5; i++)
                System.out.print(hand1.get(i)+",");
            System.out.println("");  // prints a blank line
        }
        else {
            System.out.println("Player 2's hand:" );
            for (int i = 0; i<5; i++)
                System.out.print(hand2.get(i)+",");
            System.out.println(""); //prints a blank line
        }
    }

    //this method is supposed to take  in an ArrayList and return an array of integers
    int[] countSuite(ArrayList <String> theHand) {
        int []  countSuiteArray = new int[4];  // makes a 4-cell array for 4 suits
        //cell 0 is clubs, cell 1 is diamonds, cell 2 is hearts, cell 3 is spades.
        for  (int i =0; i<theHand.size(); i++) {

            if (theHand.get(i).contains("Club")){
                countSuiteArray[0]++;
            }
            if (theHand.get(i).contains("Diamond")){
                countSuiteArray[1]++;
            }
            if (theHand.get(i).contains("Heart")){
                countSuiteArray[2]++;
            }
            if (theHand.get(i).contains("Spade")){
                countSuiteArray[3]++;
            }
        }//end loop
        return countSuiteArray;
    }//END countSuite Method

    //BEGIN COUNTVALUES METHOD
    int [] countValues(ArrayList <String> theHand){
        int[] cardValuesArray =new int[14];
        Arrays.fill(cardValuesArray, 0); // this is for testing

        //this array has 13 CORRECTION 14 elements, one for each card number Ace (1) to King (13)
        //this loop extracts the value from theHand arraylist and puts it into the CardValuesArray;
        // pulled this out to test: theHand.size()
        for  (int i =0;i<theHand.size(); i++) {

            if (theHand.get(i).contains("1")) {   //I am not sure about testing vs a string value here
                cardValuesArray[1]++;
            }

            if (theHand.get(i).contains("2")) {   //I am not sure about testing vs a string value here
                cardValuesArray[2]++;
            }
            if (theHand.get(i).contains("3")) {   //I am not sure about testing vs a string value here
                cardValuesArray[3]++;
            }
            if (theHand.get(i).contains("4")) {   //I am not sure about testing vs a string value here
                cardValuesArray[4]++;
            }
            if (theHand.get(i).contains("5")) {   //I am not sure about testing vs a string value here
                cardValuesArray[5]++;
            }
            if (theHand.get(i).contains("6")) {   //I am not sure about testing vs a string value here
                cardValuesArray[6]++;
            }
            if (theHand.get(i).contains("7")) {   //I am not sure about testing vs a string value here
                cardValuesArray[7]++;
            }
            if (theHand.get(i).contains("8")) {   //I am not sure about testing vs a string value here
                cardValuesArray[8]++;
            }
            if (theHand.get(i).contains("9")) {   //I am not sure about testing vs a string value here
                cardValuesArray[9]++;
            }
            if (theHand.get(i).contains("10")) {   //I am not sure about testing vs a string value here
                cardValuesArray[10]++;
            }
            if (theHand.get(i).contains("J")) {   //I am not sure about testing vs a string value here
                cardValuesArray[11]++;
            }
            if (theHand.get(i).contains("Q")) {   //I am not sure about testing vs a string value here
                cardValuesArray[12]++;
            }
            if (theHand.get(i).contains("K")) {   //I am not sure about testing vs a string value here
                cardValuesArray[13]++;
            }
        }//end loop
        return cardValuesArray;
    }//end countValues method

    //BEGIN numPairs Method
    int  numPairs(int[] theCardValuesArray){
        int theNumberOfPairs = 0; // creates a variable to hold the number of pairs found in the array
        for (int eachCell  : theCardValuesArray){   // getting fancy with a for-each loop here, y'all
            if (eachCell ==2 ) {
                theNumberOfPairs++;
            }
        }//End For-Each loop
        return theNumberOfPairs;
    }//end numPairs

    //BEGIN THREEOFAKIND method
    int threeOfAKind(int[] theCardValuesArray){
        int theNumberOfTriples = 0;
        for (int eachCell : theCardValuesArray){
            if (eachCell == 3) {
                theNumberOfTriples++;
            }
        }//end FOR-EACH loop
        return theNumberOfTriples;
    }//end ThreeOfAKind

    //BEGIN 4OFAKIND

    int fourOfAKind(int[] theCardValuesArray){
        int theNumberOfQuads = 0;
        for (int eachCell : theCardValuesArray){
            if (eachCell ==4){
                theNumberOfQuads++;
            }
        }//end FOR-EACH loop
        return theNumberOfQuads;
    }//end ThreeOfAKind

    //BEGIN FULL HOUSE
    boolean fullHouse(int[] theCardValuesArray){
        boolean yesFullHouse = false;
        if ((numPairs(theCardValuesArray) == 1) && (threeOfAKind(theCardValuesArray)==1) ){
            yesFullHouse = true;
        }
        return yesFullHouse;
    }//END fullHouse

    //BEGIN STRAIGHT
    public boolean straight(int[] theCardValuesArray){
        int count = 0;
        for (int countValue : theCardValuesArray) {
            if (countValue == 1) {
                count++;
                if (count == 5) {
                    return true;
                }
            }
        }
        return false;
    }//END STRAIGHT

    //BEGIN FLUSH
    //flush will check countSuite array to see if there are 5 of any suit, and return yes if true
    boolean flush(int[] aCountSuiteArray){
        boolean yesFlush = false;
        if ( (aCountSuiteArray[0] == 5) || (aCountSuiteArray[1] ==5) || (aCountSuiteArray[2]==5)
                || (aCountSuiteArray[3] == 5) || (aCountSuiteArray[4]== 5) ) {
            yesFlush = true;
        }

        return yesFlush;
    }//end flush

//BEGIN STRAIGHTFLUSH

    boolean straightFlush(int[]aCountSuiteArray,int[] aCountValuesArray){
        boolean yesStraightFlush = false;

        //checks to see if there is both a straight and a flush
        boolean yesFlush = false;
        if ( (aCountSuiteArray[0] == 5) || (aCountSuiteArray[1] ==5) || (aCountSuiteArray[2]==5)
                || (aCountSuiteArray[3] == 5) || (aCountSuiteArray[4]== 5) ) {
            yesFlush = true;
        }

        boolean yesStraight = false;
        // this segment passes the parameter received up to  the straight() method to check for a straight.
        if (straight(aCountValuesArray) == true){
            yesStraight = true;
        }

        if (yesStraight && yesFlush){
            yesStraightFlush = true;
        }
        return yesStraightFlush;
    }//END StraightFlush Method

    //BEGIN ROYAL FLUSH Method
    boolean royalFlush(ArrayList<String> hand){
        boolean yesRoyalFlush = false;  // Set this to false, intially

        int[] valueCount = countValues(hand);
        int[] count = countSuite(hand);
        boolean yesFlush = false;
        boolean yesStraight = false;
        boolean yesRoyal = false;
        //Check for each of these three elements
        for (int countValue : valueCount) {
            if (countValue == 5){
                if (count[1]==1 && count[10]==1 && count[11]==1 && count[12]==1 &&count[13]==1){
                    return true;
                }
            }
        }




    }//end royalFLush()

    //BEGIN SCOREHAND METHOD
    String scoreHand(int anInteger){
        //this method returns a string showing the strength of the hand
        //if passed a 1, it returns the strength of hand 1
        //otherwise it returns  the strength of hand2
        ArrayList<String> hand = null;
        if (anInteger == 1) {  //this will calculate hand 1


            if (royalFlush(hand) == true ) {
                return "Royal Flush";
            }else if(straightFlush(countSuite(hand1), countValues(hand1)))
            {return "Straight Flush";}
            else if(flush(countSuite(hand1))==true)
            {return "Flush";}
            else if(straight(countValues(hand1))==true)
            {return "Straight";}
            else if(fullHouse(countValues(hand1)) ==true)
            {return "Full House";}
            else if (fourOfAKind(countValues((hand1))) !=0 )
            {return "Four of A Kind";}
            else if (threeOfAKind(countValues(hand1)) !=0 )
            {return "Three of a Kind";}
            else if (numPairs(countValues(hand1)) == 2) {
                return "Two Pairs";}
            else if (numPairs (countValues(hand1)) ==1){
                return "One Pair";}
            else return "high Card";
        }//end calc hand1


        return "blah blah";

//          //Testing bits of code  -- commented out when not testing
//            int[] testCode1 = countSuite(hand1);
//            for (int i:testCode1) {
//                System.out.println(i);
//            }
//          //more testing:
//           int[] testCode2 = countValues(hand1);
//            for (int i: testCode2){
//                System.out.print(i);
//            }

    }//END scoreHand


}//END CLASS
