import java.util.Scanner;
import java.util.UUID;


public class AccountCreation {
    Scanner scanner = new Scanner(System.in);
    BankingSystem bankingSystem;

    public AccountCreation(BankingSystem bankingSystem) {
        this.bankingSystem = bankingSystem;
    }

    public Customer details(Customer[] customers) {
        Customer c = new Customer(null, null, null, null);
        customers[bankingSystem.i] = c;
        String name, accountNumber, address, phone;

        System.out.println("Enter name");
        name = scanner.next();
        customers[bankingSystem.i].setCustomerName(name);

        System.out.println("Enter Address");
        address = scanner.next();
        customers[bankingSystem.i].setAddress(address);

        System.out.println("Enter Phone Number");

        phone = scanner.next();
        customers[bankingSystem.i].setMobileNumber(phone);

        accountNumber = generateAccountNumber();
        customers[bankingSystem.i].setAccountNumber(accountNumber);

        bankingSystem.customer[bankingSystem.i] = customers[bankingSystem.i];
        System.out.println("Deposit $1000 as initial balance for opening the account. \n1.Yes\n2.Exit from Account creation");
        int x = scanner.nextInt();
        if (x == 1) {
            System.out.println("\n............................\nAccount created Successfully\n............................\n");
            System.out.println("\tAccount Details\n\t________________\n\t");
            displayDetails(customers, bankingSystem.i);
            System.out.println("1:Continue to login\n2:Exit");
            System.out.println("Enter The Option");


            if (scanner.nextInt() == 1) {
                bankingSystem.login();
            } else {
                System.out.println("\nExiting From Banking System....");
                System.exit(0);
            }

            return customers[bankingSystem.i];
        } else
        {
            System.out.println("\nExiting From Banking System....");
            System.exit(0);
        }
return null;
    }


    public static String generateAccountNumber() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid.substring(0, 10);
    }

    public void displayDetails(Customer[] customers, int k) {
        System.out.println("\tName: " + customers[k].getCustomerName() + "\n\tPhone: " + customers[k].getMobileNumber() + "\n\tAddress: "
                + customers[k].getAddress() + "\n\tAccount Number: " + customers[k].getAccountNumber() + "\n");
    }
}