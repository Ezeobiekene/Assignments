public class Lot {

    //Declare Attributes (all private):
    private int lotNumber;
    private String description;
    private int currentBid;
    private int bidIncrement;
    private boolean sold;
    private int lotID;
    private static int nextID = 1001; // this is static, & will be incremented in each constructor.

    //Begin Constructors
    public Lot() {                       //default constructor
        lotNumber = nextID;
        nextID++;
        description = "Unknown Item";
        currentBid = 0;
        bidIncrement = 0;
        sold = false;
    }//END DEFAULT CONSTRUCTOR

    //BEGIN OVERLOADED CONSTRUCTOR:
    Lot(String aDescription, int aStartingBid, int aBidIncrement) {
        description = aDescription;
        currentBid = aStartingBid;
        bidIncrement = aBidIncrement;
        sold = false;
        lotNumber =nextID;
        nextID++;
    }//end overloaded constructor

    //BEGIN SETTERS
    void markSold(){
        sold =true;

    }//END markSold

    void set_CurrentBid(int theCurrentBid){
        currentBid = theCurrentBid;

    }//end set_CurrentBid


    //BEGIN GETTERS:
    boolean get_Sold(){  // this returns whether the item is sold or not as a boolean
        return sold;
    }//END get_Sold

    int get_BidIncrement(){
        return bidIncrement;

    }//END getBidIncrement

    String get_Description(){
        return description;

    }//END get_Description

    //BEGIN ADDITIONAL METHODS
    int nextBid(){    //nextBid returns the next possible lowest Bid
        int theNextPossibleBid;
        theNextPossibleBid = currentBid+bidIncrement;
        return theNextPossibleBid;
    }//end nextBid

    //BEGIN OVERRIDE SECTION: if lot is "sold" override thus:
    //"lot 1001 Description was sold for $500"
    // and if not,  "lot 1001 Description. current bid $100 minimum bid $120"
    @Override
    public String toString() {
        if (sold == true) {
            return "Lot "+lotNumber+". "+ description +" was sold for $"+currentBid;
        }

        return "Lot "+lotNumber+". "+ description +" current bid $"+currentBid+ " minimum bid $"+nextBid();
    }
    //END OVERRIDE




}//END LOT CLASS
