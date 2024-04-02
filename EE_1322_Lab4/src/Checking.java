public class Checking extends Account{


    public Checking(float accountBalance) {
        super(accountBalance);
    }


    @Override
    public void withdrawMoney(float amountToWithdraw){
        if(getAccountBalance() < 0){
            System.out.println("Charging an overdraft fee of $20 because account is below $0");
            setAccountBalance(getAccountBalance() - amountToWithdraw);
            setAccountBalance(getAccountBalance() - 20);
        } else {
            setAccountBalance(getAccountBalance() - amountToWithdraw);
        }

    }


}
