public class Suspended extends Customer{
    private String name;
    private String violation;

    public Suspended(String name, String violation){
        super('D');
        this.name=name;
        this.violation=violation;
    }

    @Override
    public String getCustomerInfo() {
        return "Violation; "+violation+". Ticket Number "+getTicketNumber()+". Name: "+name;
    }
}
