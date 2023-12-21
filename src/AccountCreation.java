import java.util.*;


public class AccountCreation {
    Scanner scanner = new Scanner(System.in);
    BankingSystem bankingSystem;
    List<Customer> customerList = new ArrayList<>();
int i=0;
    public AccountCreation(BankingSystem bankingSystem) {
        this.bankingSystem = bankingSystem;
    }

    public void details() {
        Customer customer = new Customer();
        String name, accountNumber, address, phone;

        System.out.println("Enter name");
        name = scanner.next();

        System.out.println("Enter Address");
        address = scanner.next();

        System.out.println("Enter Mobile Number");
        phone=scanner.next();
        if (customer.validation(phone)) {
           System.out.println("");
        }
        else
        { do {
                System.out.println("Enter valid mobile number");
                phone = scanner.next();
            } while (!customer.validation(phone));
        }

        accountNumber = generateAccountNumber();
        customer.setAccountNumber(accountNumber);

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
            String s=customerList.get(i).getAccountNumber();
            System.out.println("Your Account Number: "+s);
            while (true) {
                System.out.println("\n1:Continue to login\n2:Go Back\n3.Exit");
                System.out.println("\nEnter The Option");
                switch (scanner.nextInt()) {
                    case 1:
                        login();
                        break;
                    case 2:
                        i++;
                        bankingSystem.initial();
                        break;
                    case 3:
                        i++;
                        System.out.println("\nExiting From Banking System....");
                        System.exit(0);
                    default:
                        System.out.println("----Invalid choice. Please try again.----");
                }
            }
        }
        else
        {
            System.out.println("\nExiting From Banking System....");
            System.exit(0);
        }
    }


    public static String generateAccountNumber() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid.substring(0, 10);
    }

    public void login() {
        System.out.println("______________\nWelcome To Login\n______________\n");
        System.out.println("Enter Account Number:");
        String acc = scanner.next();
        //String s;
        for (Customer customer : customerList) {
            if (Objects.equals(acc, customer.getAccountNumber())) {

                while (true) {
                    System.out.println("Enter Account Type for transaction.\n1:Savings\n2:Current\nEnter 1 or 2\n");
                    int accountType = scanner.nextInt();
                    switch (accountType) {
                        case 1:
                            SavingsAccount savingsAccount = new SavingsAccount(1000, 2.5);
                            performTransactions(savingsAccount, acc);
                            break;
                        case 2:
                            CurrentAccount currentAccount = new CurrentAccount(1000, 100);
                            performTransactions(currentAccount, acc);
                            break;
                        default:
                            System.out.println("----Invalid choice. Please try again.----");
                    }
                }
            }

        }
            System.out.println("----Invalid Account Number.Authentication Failed!----");
            bankingSystem. initial();
    }
    private void performTransactions(Transaction account,String accountNumber) {
        int choice;
        System.out.println("______________\nWelcome To Transactions\n______________\n");

        while (true) {

            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Balance");
            System.out.println("4.Account Details");
            System.out.println("5. Exit");
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
                     display(accountNumber);
                     break;
                case 5:
                    System.out.println("\nExiting From Banking System....");
                    System.exit(0);

                default:
                    System.out.println("----Invalid choice. Please try again.----");
            }
        }
    }

    public void display(String s){
        System.out.println("\tAccount Details\n\t________________\n\t");
        for (Customer customer : customerList)
            if (Objects.equals(customer.getAccountNumber(), s))
                System.out.println("\tAccount Holder: " + customer.getCustomerName() + "\n\tPhone: " + customer.getMobileNumber() + "\n\tAddress: "
                        + customer.getAddress() + "\n\tAccount Number: " + customer.getAccountNumber() + "\n");
    }
}