import java.util.Objects;
import java.util.Scanner;

public class BankingSystem {
    Scanner scanner = new Scanner(System.in);
    Customer[] cu = new Customer[10];
    int i = 0;

    public static void main(String[] args) {
        System.out.println("***************\nBanking App\n***************\n");
        BankingSystem bs = new BankingSystem();
        bs.initial();
    }

    public void initial() {
        AccountCreation ac = new AccountCreation(this);
        int choice;

        while (true) {
            System.out.println("1. Create Account");
            System.out.println("2. Login\nEnter an option(1/2):");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    ac.details(cu);
                    break;
                case 2:
                    if (cu[i] == null) {
                        System.out.println("----Create an account first----\n");
                        initial();
                    } else {
                        login();
                        break;
                    }
                    break;
                default:
                    System.out.println("----Enter valid input----");
                    initial();
            }
            break;
        }
    }

    public void login() {



        System.out.println("______________\nWelcome To Login\n______________\n");


        String ao=cu[i].getacc();

        System.out.println(ao);
        System.out.println("Enter Account Number:");
        String acc = scanner.next();
        if (Objects.equals(ao, acc)) {

            System.out.println("Enter Account Type for transaction.\n1-Savings\n2-Current");

            int accountType = scanner.nextInt();
            if (accountType == 1) {
                SavingsAccount savingsAccount = new SavingsAccount(1000, 2.5);
                performTransactions(savingsAccount);
            } else if (accountType == 2) {
                CurrentAccount currentAccount = new CurrentAccount(1000, 100);
                performTransactions(currentAccount);
            } else {
                System.out.println("invalid input");
                System.exit(0);
            }
        } else {
            System.out.println("----Invalid Account Number.Authentication Failed!----");
            initial();

        }
    }
    private void performTransactions(Transaction account) {
        int choice;
        System.out.println("______________\nWelcome To Transactions\n______________\n");

        while (true) {

            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("\n............Account balance Is $"+account.getBalance()+"............\n");
                    break;
                case 4:
                    System.out.println("\nExiting From Banking System....");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}