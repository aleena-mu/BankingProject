public class CurrentAccount extends BankAccount implements Transaction {
    double overdraftlimit;

    public CurrentAccount(double iniatialbalance, double overdraftlimit) {
        super(iniatialbalance);
        this.overdraftlimit = overdraftlimit;
    }


    @Override
    public void deposit(double amount) {

        if (amount > 0) {
            balance += amount;
            System.out.println("\n............Successfully Deposited $" + amount + "............\n");
        } else {
            System.out.println("\n----Enter valid Amount----\n");
        }

    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Withdrawing RS." + amount);
        if (overdraftlimit + balance < amount) {
            System.out.println("\n----Overdraft Limit Exceeded!Cannot Complete Transaction----\n");
        } else {
            balance -= amount;
            System.out.println("\n............Successfully Withdrawn $" + amount + "............\n");
        }

    }

    @Override
    public double getBalance() {
        return balance;
    }


}
