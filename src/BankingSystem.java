import java.util.Objects;
import java.util.Scanner;

public class BankingSystem {
    Scanner scanner = new Scanner(System.in);
    Customer[] cu = new Customer[10];
    int i = 0;

    public static void main(String[] args) {
        BankingSystem bs = new BankingSystem();
        bs.initial();
    }

    public void initial() {
        AccountCreation ac = new AccountCreation(this);
        int choice;

        while (true) {
            System.out.println("0. Create Account");
            System.out.println("1. Login\nEnter an option:");
            choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    ac.details(cu);
                    break;
                case 1:
                    if (cu[i] == null) {
                        System.out.println("Create an account first\n---------------------");
                        initial();
                    } else {
                        login();
                        break;
                    }
                    break;
                default:
                    System.out.println("Enter valid input");
                    initial();
            }
            break;
        }
    }

    public void login() {


        System.out.println("_______________________\nWelcome To Login\n_______________________");


        String ao=cu[i].getacc();

        System.out.println(ao);
        System.out.println("Enter Account Number:");
        String acc = scanner.next();
        if (Objects.equals(ao, acc)) {

            System.out.println("Enter Account Type for transaction.(1-Savings\n2-Current)");

            int accountType = scanner.nextInt();
            if (accountType == 1) {
                SavingsAccount savingsAccount = new SavingsAccount(1000, 2.5);
                performTransactions(savingsAccount, acc);
            } else if (accountType == 2) {
                CurrentAccount currentAccount = new CurrentAccount(500, 100);
                performTransactions(currentAccount, acc);
            } else {
                System.out.println("invalid input");
                System.exit(0);
            }
        } else {
            System.out.println("Invalid Account Number.Authentication Failed!");
            initial();

        }
    }
    private void performTransactions(Transaction account, String acc) {
        int choice;
        while (true) {
            System.out.println("---------------------------\nWelcome To Transactions\n---------------------------\n");
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
                    System.out.println(account.getBalance());
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}