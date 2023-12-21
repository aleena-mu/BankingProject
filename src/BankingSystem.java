import java.util.*;


public class BankingSystem {
    Scanner scanner = new Scanner(System.in);
    AccountCreation ac = new AccountCreation(this);


    public static void main(String[] args) {
        System.out.println("***************\nBanking App\n***************\n");
        BankingSystem bankingSystem = new BankingSystem();
        bankingSystem.initial();
    }

    public void initial() {

        int choice;


        System.out.println("1. Create Account");
        System.out.println("2. Login\nEnter an option(1 OR 2):");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                 ac.details();
                break;
            case 2:
                if (ac.customerList.isEmpty()) {
                    System.out.println("----Create an account first----\n");
                    initial();
                } else {
                   ac. login();
                    break;
                }
                break;
            default:
                System.out.println("----Enter valid input----");
                initial();
        }


    }



}