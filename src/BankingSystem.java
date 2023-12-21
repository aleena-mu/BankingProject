import java.util.*;


public class BankingSystem {
    Scanner scanner = new Scanner(System.in);
    AccountMangement accountManagement = new AccountMangement(this);
    List<Customer> customerList = new ArrayList<>();
    int i=0;
 private static BankingSystem instance;
private  BankingSystem(){

}

public static BankingSystem getInstance(){
    if(instance==null){
        instance=new BankingSystem();
    }
    return instance;
}

    public void start() {

        int choice;


        System.out.println("1. Create Account");
        System.out.println("2. Login\nEnter an option(1 OR 2):");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                 customerList.add(accountManagement.accountCreation());
                 i++;

                break;
            case 2:
                if (customerList.isEmpty()) {
                    System.out.println("----Create an account first----\n");
                    start();
                } else {
                   accountManagement. login();
                    break;
                }
                break;
            default:
                System.out.println("----Enter valid input----");
                start();
                break;
        }


    }



}