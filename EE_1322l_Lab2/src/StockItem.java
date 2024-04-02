public class StockItem {
    private String description;
    private String name;
    private int id;
    private static int nextId = 0;
    private float price;
    private int quantity;

    public float getPrice() {
        return price;
    }
    public void setPrice(float newPrice) {
        price = newPrice;
        if(price<0){
            System.out.println("Error");
        }
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int newQuantity) {
        quantity += newQuantity;
    }
    public int getId() {
        return id;
    }

    public StockItem() {
        price = 0;
        description = "An Item";
        quantity = 0;
        name="";
        id=nextId;
        nextId++;
    }
    public StockItem(String newName, String newDescription, float newPrice, int newQuantity) {
        name = newName;
        price = newPrice;
        description = newDescription;
        quantity = newQuantity;
        id = nextId;
        nextId++;

    }

    @Override
    public String toString() {
        return name+": Item number: "+id+" is "+description+" has price "+price+ " we currently have "+quantity+" in stock";
    }

    public void lowerQuantity(){
        quantity -= 1;

        if(quantity<0){
            System.out.println("Error");
        }
    }
}
