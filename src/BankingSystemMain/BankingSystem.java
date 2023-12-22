package BankingSystemMain;

import java.util.*;


public class BankingSystem {
    Scanner scanner = new Scanner(System.in);
    AccountManager accountManagement = new AccountManager();
    public static final int OVERDRAFT_LIMIT=100;
    public static final double SAVINGS_INTEREST=2.5;

    int i=0;
 private static BankingSystem instance;
private  BankingSystem(){}

public static BankingSystem getInstance(){
    if(instance==null){
        instance=new BankingSystem();
    }
    return instance;
}

    public void start() {

        int choice;


        System.out.println("1. Create Account");
        System.out.println("2. Login\n3.Exit\nEnter an option:");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                accountManagement.accountCreation();


                break;
            case 2:

                   accountManagement.login();
                    break;
            case 3:System.exit(0);

            default:
                System.out.println("----Enter valid input----");
                start();
                break;
        }


    }



}