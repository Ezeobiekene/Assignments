public class Renew extends Customer{
    private String name;

    public Renew(String name){
        super('B');
        this.name = name;
    }
    @Override
    public String getCustomerInfo() {
        return "Renew License. Ticket Number "+ getTicketNumber() + " . Name: "+name;
    }
}
