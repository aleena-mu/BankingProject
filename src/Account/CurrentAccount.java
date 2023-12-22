package Account;

import Account.BankAccount;

public class CurrentAccount extends BankAccount {
    double OverdraftLimit;

    public CurrentAccount(double InitialBalance, double OverdraftLimit) {
        super(InitialBalance);
        this.OverdraftLimit = OverdraftLimit;
    }




    @Override
    public void withdraw(double amount) {
        System.out.println("Withdrawing RS." + amount);
        if (OverdraftLimit + balance < amount) {
            System.out.println("\n----Overdraft Limit Exceeded!Cannot Complete Account.Transaction----\n");
        } else {
            balance -= amount;
            System.out.println("\n............Successfully Withdrawn RS." + amount + "............\n");
        }

    }



}
