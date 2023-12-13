public class SavingsAccount extends BankAccount implements Transaction
{
 double interest;
 double DepositAmount;
    public SavingsAccount(double iniatialbalance,double interest)
    {
        super(iniatialbalance);
        this.interest=interest;
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Withdraw Amount is "+amount);
        if (amount>balance)
        {
            System.out.println("Insufficiant Balance");
        }else {
            balance-=amount;
            System.out.println("Withdrawl is Successfull");
        }

    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
       System.out.println("Deposit Amount is "+amount );
       System.out.println("Applicable Interest Rate : "+interest);
        if (amount>0)
        {
            balance+=amount;
            System.out.println("Deposit SuccessFull");
        }else {
            System.out.println("Enter valid Amount");
        }
    }
}
