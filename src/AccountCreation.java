import java.util.*;


public class AccountCreation {
    Scanner scanner = new Scanner(System.in);
    BankingSystem bankingSystem;
    List<Customer> customerList = new ArrayList<>();
int i=0;
    public AccountCreation(BankingSystem bankingSystem) {
        this.bankingSystem = bankingSystem;
    }

    public Customer details() {
        Customer customer = new Customer();
        //customers[bankingSystem.i] = c;
        String name, accountNumber, address, phone;

        System.out.println("Enter name");
        name = scanner.next();
        //customer.setCustomerName(name);

        System.out.println("Enter Address");
        address = scanner.next();
        //customer.setAddress(address);
        System.out.println("Enter Mobile Number");
        phone=scanner.next();
        if (customer.validation(phone)) {
           System.out.println(" ");

        } else {
            do {
                System.out.println("Enter valid mobile number");
                phone = scanner.next();
            } while (!customer.validation(phone));


        }
        accountNumber = generateAccountNumber();
        customer.setAccountNumber(accountNumber);

        //bankingSystem.customer[bankingSystem.i] = customers[bankingSystem.i];
        System.out.println("Deposit $1000 as initial balance for opening the account. \n1.Yes\n2.Exit from Account creation");
        int x = scanner.nextInt();
        if (x == 1)
        {
            Customer customers=new Customer();
            customers.setAccountNumber(accountNumber);
            customers.setCustomerName(name);
            customers.setMobileNumber(phone);
            customers.setAddress(address);
            customerList.add(i,customers);
            System.out.println("\n............................\nAccount created Successfully\n............................\n");
            System.out.println("\tAccount Details\n\t________________\n\t");
            display(i);
            System.out.println("1:Continue to login\n2:Exit");
            System.out.println("Enter The Option");
            if (scanner.nextInt() == 1) {
                login();
            }
            else
            {
                i++;
                System.out.println("\nExiting From Banking System....");
                System.exit(0);
            }

        }
        else
        {
            System.out.println("\nExiting From Banking System....");
            System.exit(0);
        }
       // bankingSystem.i++;
        return customer;
    }


    public static String generateAccountNumber() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid.substring(0, 10);
    }

    public void login() {

int flag=0;
        System.out.println("______________\nWelcome To Login\n______________\n");


        //String ao = customer[i].getAccountNumber();

        //  System.out.println(ao);
        System.out.println("Enter Account Number:");
        String acc = scanner.next();
        //String s;
        for ( int n=0;n<customerList.size();)
        {
            if (Objects.equals(acc, customerList.get(n).getAccountNumber())) {
                flag=1;
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
            }
            else {
                n++;

            }
        }
        if(flag==0){
            System.out.println("----Invalid Account Number.Authentication Failed!----");
            bankingSystem. initial();
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
                    System.out.print("Enter deposit amount: RS.");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: RS.");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("\n............Account balance Is RS." + account.getBalance() + "............\n");
                    break;
                case 4:
                    System.out.println("\nExiting From Banking System....");
                    System.exit(0);
                default:
                    System.out.println("----Invalid choice. Please try again.----");
            }
        }
    }

    public void display(int i){
        System.out.println("\tName: " + customerList.get(i).getCustomerName() + "\n\tPhone: " + customerList.get(i).getMobileNumber() + "\n\tAddress: "
                + customerList.get(i).getAddress() + "\n\tAccount Number: " + customerList.get(i).getAccountNumber() + "\n");
    }
}