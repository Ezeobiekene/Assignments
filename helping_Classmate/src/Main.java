import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //System.out.printf("Hello and welcome!");

        //The main method creates an ArrayList of Lots called "Auction" and passes to the menu method
        ArrayList<Lot> auction  = new ArrayList<Lot>();
        System.out.println(auction);

        mainMenu(auction);
    }//END MAIN

    //BEGIN METHODS FOR DRIVER
   public static Lot getNextLot(ArrayList <Lot> someLots){
        if (someLots.isEmpty()==false) {
            Lot tempLot = someLots.get(0);
            someLots.remove(0);
            return tempLot; // TempLot IS NECESSARY BC ONCE THE RETURN HAPPENS ITS OVER
        }

        Lot aNewLot = new Lot();
        return aNewLot;
    }//end GETNEXTLOT METHOD

    //BEGIN addItem
    public static void addItem(ArrayList <Lot> someMoreLots){
        Scanner aScanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("What is the new Description? ");
        String aNewDescription = aScanner.nextLine();  // Read user's input
        System.out.println("What is the new Starting Bid? ");
        int aNewStartingBid = aScanner.nextInt();  // Read user's input
        System.out.println("What is the new Bid Increment? ");
        int aNewBidIncrement = aScanner.nextInt();  // Read user's input
//Pass this data to the constructor, create a lot,  and add to someMoreLots
        // note that since in java objects are passed by reference, this will act
        // on the original object, despite the name change. I THINK.
        Lot aSparklingLot = new Lot(aNewDescription,aNewStartingBid,aNewBidIncrement);
        someMoreLots.add(aSparklingLot);
    }//end addItem
    //BEGIN bid Method
    public static void bid(Lot aPassedLot){
        Scanner aScanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("How Much Do You Want To Bid?");
        int theNextPossibleBid = aPassedLot.nextBid();
        System.out.println("(Minimum Bid is: "+ theNextPossibleBid);
        int aPotentialBid= aScanner.nextInt();  // Read user's input
        if (aPotentialBid < theNextPossibleBid){
            System.out.println("Sorry, that bid is too low");
        }else{ aPassedLot.set_CurrentBid(aPotentialBid);}
        //if the bid is high enough, set the current bid to their bid.
    }//END BID METHOD
    //BEGIN markSold
    void markSold(Lot aPassedLot){
        aPassedLot.markSold();
        System.out.println(aPassedLot);
    }//end DRIVER method MarkSold - note duplicate name with Lot Class method

    //BEGIN MENU CODE
    public static void mainMenu(ArrayList<Lot> anArrayListOfLots) {
        Lot currentLot = null;
        int userChoice = 0; //MUST INITIALIZE OUTSIDE OF DO-WHILE TO ALLOW DO WHILE TO WORK.
        do {
            if (currentLot != null) {
                System.out.print("Current Lot: ");
                System.out.println(currentLot);
            }
            if ((currentLot == null) || (currentLot.get_Description() == "Unknown Item")) {
                System.out.println("We are Not Currently Bidding");
                //THIS PROBABLY IS BUGGY DUE TO == not working on objects--NOTE
            }
            //BEGIN MENU LIST
            System.out.println("1. Add Lot to Auction");
            System.out.println("2. Start bidding on next Lot");
            System.out.println("3. Bid on current Lot");
            System.out.println("4. Mark current Lot sold");
            System.out.println("5. Quit");

            Scanner menuScanner = new Scanner(System.in);  // Create a Scanner object
            userChoice = menuScanner.nextInt();  // read in the users choice
            if (userChoice == 1) {
                addItem(anArrayListOfLots);//ads a new item
            }//END USERCHOICE 1

            if (userChoice ==2) {            //this choice is to start bidding
                if (anArrayListOfLots.isEmpty()) {
                    System.out.println("There is Nothing To Bid on, add an item first");
                }
                if (currentLot != null && (currentLot.get_Sold() == false)) {
                    System.out.println("You must mark the current lot sold before bringing up the next Lot");
                } else {
                    currentLot = getNextLot(anArrayListOfLots);
                }
            }//END USERCHOICE 2
            if (userChoice ==3) {  //THIS IS FOR BIDDING
                if ((currentLot == null) || (currentLot.get_Description() == "Unknown Item") || (currentLot.get_Sold() == true)) {
                    System.out.println("You Must first bring a Lot up for bidding");
                } else {bid(currentLot);}
            }//END USERCHOICE 3

            if (userChoice == 4){
                if ((currentLot == null) || (currentLot.get_Description()== "Unknown Item") || (currentLot.get_Sold() == true)){
                    System.out.println("You must first bring a Lot up for bidding");
                }else{
                    currentLot.markSold();
                    currentLot = getNextLot(anArrayListOfLots);}
            }//END USERCHOICE 4
        }while(userChoice != 5); // END DO-WHILE MENU LOOP

    }//END MENU

}//END CLASS