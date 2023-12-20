public class CurrentAccount extends BankAccount implements Transaction {
    double OverdraftLimit;

    public CurrentAccount(double IniatialBalance, double OverdraftLimit) {
        super(IniatialBalance);
        this.OverdraftLimit = OverdraftLimit;
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
        if (OverdraftLimit + balance < amount) {
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
