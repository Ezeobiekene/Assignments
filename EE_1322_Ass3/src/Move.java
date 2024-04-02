public class Move extends Customer{
    private String name;
    private String formerState;

    public Move(String name, String formerState){
        super('C');
        this.name = name;
        this.formerState = formerState;
    }
    @Override
    public String getCustomerInfo() {
        return "Moved from "+formerState+ ". Ticket Number "+getTicketNumber()+". Name: "+name;
    }
}
