package BankingSystemMain;
import  Account.*;
import Account.CurrentAccount;
import CustomerPackage.*;

import java.util.*;


public class AccountManager {
    Scanner scanner = new Scanner(System.in);
    Map<String, Customer> customers = new HashMap<>();
    private Customer loggedInCustomer;
   // BankingSystemMain.BankingSystem bankingSystem;

//int i=0;
////public AccountMangement(BankingSystemMain.BankingSystem bankingSystem) {
//        this.bankingSystem = bankingSystem;
//    }

    public void accountCreation() {
        Customer customer = new Customer();
        String name, accountNumber, address, phone;

        System.out.println("Enter name");
        name = scanner.next();

        System.out.println("Enter Address");
        address = scanner.next();

        System.out.println("Enter Mobile Number");
        phone=scanner.next();
        if (customer.validation(phone)) {
           System.out.println();

        }
        else
        { do {
                System.out.println("Enter valid mobile number");
                phone = scanner.next();
            } while (!customer.validation(phone));
        }

        accountNumber = generateAccountNumber();

        System.out.println("Deposit RS.1000 as initial balance for opening the account. \n1.Yes\n2.Exit from Account creation");
        int x = scanner.nextInt();
        if (x == 1)
        {

            customer.setAccountNumber(accountNumber);
            customer.setCustomerName(name);
            customer.setMobileNumber(phone);
            customer.setAddress(address);
            customer.setCurrentAccount(new CurrentAccount(1000, BankingSystem.OVERDRAFT_LIMIT));
            customer.setSavingsAccount(new SavingsAccount(1000, BankingSystem.SAVINGS_INTEREST));


            System.out.println("\n............................\nAccount created Successfully\n............................\n");
           customers.put(accountNumber,customer);
            System.out.println("Your Account Number: "+accountNumber);
            BankingSystem.getInstance().start();

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

        if(customers.isEmpty()) {
        System.out.println("----Create an account First----");
        BankingSystem.getInstance().start();
        return;
        }
        System.out.println("______________\nWelcome To Login\n______________\n");
        System.out.println("Enter Account Number:");
        String accountNumber = scanner.next();
        if (customers.containsKey(accountNumber)) {

           loggedInCustomer=customers.get(accountNumber);
            System.out.println("Successfully connected to: "+loggedInCustomer.getCustomerName());
            showLoggedInCustomerActions();
        } else {
            System.out.println("----Invalid Account Number.Authentication Failed!----");
            BankingSystem.getInstance().start();
        }
    }

    public void showLoggedInCustomerActions() {
        int choice=0;

        do{

            System.out.println("\n1.Savings\n2.Current \n3.Show Account Details\n4.Log Out\n Enter an option");//show details

            choice=scanner.nextInt();
           switch (choice) {
               case 1:
                   loggedInCustomer.getSavingsAccount().showTransactionOptions();
                   break;
               case 2:
                   loggedInCustomer.getCurrentAccount().showTransactionOptions();
                   break;
               case 3:loggedInCustomer.dispaly();
                     break;
               case 4:
                   loggedInCustomer = null;
                   BankingSystem.getInstance().start();
                   break;

           }
       }while (choice!=4);
    }

//    public void showAccountDetails() {
//        System.out.println("Customer Details:");
//        System.out.println("Name: " + loggedInCustomer.getCustomerName());
//        System.out.println("Address: " + loggedInCustomer.getAddress());
//        System.out.println("Mobile Number: " + loggedInCustomer.getMobileNumber());
//        System.out.println("Account Number: " + loggedInCustomer.getAccountNumber());
//    }
}