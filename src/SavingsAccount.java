public class SavingsAccount extends BankAccount implements Transaction
{
 double interest;

    public SavingsAccount(double iniatialbalance,double interest)
    {
        super(iniatialbalance);
        this.interest=interest;
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Withdrawing $ "+amount+"...");
        if (amount>balance)
        {
            System.out.println("\n----Insufficiant Balance----\n");
        }else {
            balance-=amount;
            System.out.println("\n............Successfully Withdrawn $"+amount+"............\n");
        }

    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {


        if (amount>0)
        {
            balance+=amount;
            System.out.println("\n............Successfully Deposited $"+amount+"............\n");
            System.out.println("Applicable Interest Rate : "+interest);
        }else {
            System.out.println("Enter valid Amount");
        }
    }
}
