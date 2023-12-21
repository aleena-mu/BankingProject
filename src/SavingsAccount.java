public class SavingsAccount extends BankAccount implements Transaction {
    double interest;

    public SavingsAccount(double initialBalance, double interest) {
        super(initialBalance);
        this.interest = interest;
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Withdrawing RS. " + amount + "...");
        if (amount > balance) {
            System.out.println("\n----Insufficient Balance----\n");
        } else {
            balance -= amount;
            System.out.println("\n............Successfully Withdrawn RS." + amount + "............\n");
        }

    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {


        if (amount > 0) {
            balance += amount;
            System.out.println("\n............Successfully Deposited RS." + amount + "............\n");
            System.out.println("Applicable Interest Rate : " + interest);
        } else {
            System.out.println("\n----Enter Valid Amount----\n");
        }
    }
}
