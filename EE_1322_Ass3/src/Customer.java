public abstract class Customer {
    private char letter;
    private int number;
    public static int nextA=1;
    public static int nextB=1;
    public static int nextC=1;
    public static int nextD=1;

    public Customer(){
        letter = 'X';
        number= 0;
    }
    public Customer(char letter){
        if(letter == 'A'){
            this.letter = 'A';
            this.number = nextA;
            nextA++;
        } else if (letter == 'B') {
            this.letter = 'B';
            this.number = nextB;
            nextB++;
        } else if (letter == 'C') {
            this.letter = 'C';
            this.number = nextC;
            nextC++;
        } else if (letter == 'D') {
            this.letter = 'D';
            this.number = nextD;
            nextD++;
        }else {
            System.out.println("Error, letter must be A, B, C or D");
        }
    }

    protected String getTicketNumber() {
        return String.valueOf(letter) + number;
    }

    public abstract String getCustomerInfo();
}
