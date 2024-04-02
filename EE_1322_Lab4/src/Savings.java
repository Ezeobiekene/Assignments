public class Savings extends Account{
    int numOfDeposit;

    public Savings (float accountBalance) {
        super(accountBalance);
        numOfDeposit = 0;
    }

    @Override
    public void withdrawMoney(float amountToWithdraw){
        if(getAccountBalance() < 500){
           System.out.println("Charging a fee of $10 because you are below $500");
           setAccountBalance(getAccountBalance() - amountToWithdraw);
           setAccountBalance(getAccountBalance() - 10);
       }else {
            setAccountBalance(getAccountBalance() - amountToWithdraw);
        }

    }

    @Override
    public void depositMoney(float amountToDeposit){

        numOfDeposit++;

        if (numOfDeposit > 5){

            System.out.println("This is deposit "+ numOfDeposit +" to this account");
            System.out.println("Charging a fee of $10");
            setAccountBalance(getAccountBalance() - 10);

        }else {
            System.out.println("This is deposit "+ numOfDeposit +" to this account");
        }
        super.depositMoney(amountToDeposit);
    }

    public void interest(){
       float interest = (float) (getAccountBalance() * 0.015);

       System.out.println("Customer earned "+interest+" in interest");
       setAccountBalance(getAccountBalance() + interest);
    }
}
