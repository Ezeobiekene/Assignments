public class Lot {
    private static int NextLotNumber=1001;
    private int lotNumber;
    private String description;
    private int currentBid;
    private int bidIncrement;
    private boolean sold;

    public Lot(){
        lotNumber=NextLotNumber;
        description="Unknown Item";
        currentBid=0;
        bidIncrement=0;
        sold=false;

        NextLotNumber++;
    }
    public Lot(String newDescription, int startingBid, int newBidIncrement){
        lotNumber=NextLotNumber;
        description=newDescription;
        currentBid=startingBid;
        bidIncrement=newBidIncrement;
        sold=false;

        NextLotNumber++;
    }

    public void markSold(){
        sold=true;
    }

    public String getDescription() {
        return description;
    }

    public int getBidIncrement() {
        return bidIncrement;
    }

    public boolean isSold() {
        return sold;
    }

    public void setCurrentBid(int currentBid) {
        this.currentBid = currentBid;
    }
    public int nextBid(){
        return currentBid + bidIncrement;
    }

    @Override
    public String toString(){
        if(sold){
            return "Lot "+lotNumber+". "+ description +" was sold for $"+currentBid;
        }else{
            return "Lot "+lotNumber+". "+ description +" current bid $"+currentBid+ " minimum bid $"+nextBid();
        }
    }
}
