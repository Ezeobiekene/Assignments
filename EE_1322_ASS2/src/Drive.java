import java.util.ArrayList;
import java.util.Scanner;

public class Drive {



    public static Lot getNextLot(ArrayList<Lot> auction){

        if (!auction.isEmpty()){
            return auction.remove(0);
        }
        return new Lot();
    }
    public static void addItem(ArrayList<Lot> auction){
        Scanner scanner= new Scanner(System.in);

        System.out.println("What is the description of this item?");
        String description = scanner.nextLine();

        System.out.println("What is the Starting bid?");
        int startingBid = scanner.nextInt();

        System.out.println("What is the bid increment?");
        int bidIncrement = scanner.nextInt();
        scanner.nextLine();
        auction.add(new Lot(description, startingBid, bidIncrement));
    }

    public static void bid(Lot auction){
        Scanner scanner= new Scanner(System.in);

        System.out.println("How much would you like to bid?");
        System.out.println("Minimum bid is "+ auction.nextBid());
        int bid = scanner.nextInt();

        if(bid < auction.nextBid()){
            System.out.println("Bid is too small. Minimum bid is $"+auction.nextBid());
        }else{
            auction.setCurrentBid(bid);
        }
    }

    public static void markSold(Lot auction){
        auction.markSold();
        System.out.println(auction.toString());
    }

    public static void mainMenu(ArrayList<Lot> auction){
        Scanner scanner= new Scanner(System.in);
        Lot currentLot = null;
        int menuOption;

        do{
            if((currentLot == null) || currentLot.getDescription().equals("Unknown Item")){
                System.out.println("We are not currently bidding");
            }else {
                System.out.println("Current Lot: \n" + currentLot.toString());
            }

            System.out.println("""
                    1. Add Lot to Auction
                    2. Start bidding on next Lot
                    3. Bid on current Lot
                    4. Mark current Lot sold
                    5. Quit""");
            menuOption = scanner.nextInt();

            switch (menuOption){
                case 1:
                    addItem(auction);
                    break;

                case 2:
                    if (auction.isEmpty()) {
                        System.out.println("There is nothing to bid on. Add an item first.");
                    } else if (currentLot != null && !currentLot.isSold()) {
                        System.out.println("You must mark the current lot as sold before bringing up the next Lot.");
                    } else {
                        currentLot = getNextLot(auction);
                        System.out.println("Current Lot: \n" + currentLot.getDescription());
                    }
                    break;

                case 3:
                    if (currentLot == null || currentLot.getDescription().equals("Unknown Item") || currentLot.isSold()) {
                        System.out.println("You must first bring a Lot up for bidding.");
                    } else {
                        bid(currentLot);
                    }
                    break;

                case 4:
                    if (currentLot == null || currentLot.getDescription().equals("Unknown Item") || currentLot.isSold()) {
                        System.out.println("You must first bring a Lot up for bidding.");
                    } else {
                        markSold(currentLot);
                        currentLot = getNextLot(auction);
                    }
                    break;

                case 5:
                    break;
            }

        }while (menuOption != 5);
    }

    public static void main(String[] args) {
        ArrayList<Lot> auction = new ArrayList<>();
        mainMenu(auction);
    }

}
