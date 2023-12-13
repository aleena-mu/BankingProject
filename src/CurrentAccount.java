public class CurrentAccount extends BankAccount implements Transaction{
     double overdraftlimit;
    public CurrentAccount(double iniatialbalance,double overdraftlimit)
    {
        super(iniatialbalance);
        this.overdraftlimit=overdraftlimit;
    }


    @Override
    public void deposit(double amount) {
        System.out.println("Deposit Amount is "+amount );
        if (amount>0)
        {
            balance+=amount;
            System.out.println("Deposit SuccessFull");
        }else {
            System.out.println("Enter valid Amount");
        }

    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Withdraw Amount is "+amount);
        if (overdraftlimit+balance>amount)
        {
            System.out.println("Overdraft Limit Exceeded");
        }else {
            balance-=amount;
            System.out.println("Withdrawl is Successfull");
        }

    }

    @Override
    public double getBalance() {
        return balance;
    }


    }
