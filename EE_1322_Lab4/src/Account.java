public class Account {
    private static int nextAccountNumber=10001;
    private final int accountNumber;
    private float accountBalance;

    public Account(){
        accountBalance = 0;
        accountNumber = nextAccountNumber;
        nextAccountNumber ++;
    }

    public Account(float newAccountBalance){
        accountBalance = newAccountBalance;
        accountNumber = nextAccountNumber;
        nextAccountNumber ++;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public float getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void withdrawMoney(float amountToWithdraw){
        accountBalance -= amountToWithdraw;
    }

    public void depositMoney(float amountToDeposit){
        accountBalance += amountToDeposit;
    }



}
