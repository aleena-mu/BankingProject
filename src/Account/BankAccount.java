package Account;

import java.util.Objects;
import java.util.Scanner;

public abstract class BankAccount  implements Transaction {

    protected double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
Scanner scanner=new Scanner(System.in);
     @Override
     public void deposit(double amount) {

         if (amount > 0) {
             balance += amount;
             System.out.println("\n............Successfully Deposited RS." + amount + "............\n");
         } else {
             System.out.println("\n----Enter valid Amount----\n");
         }

     }
    public void showTransactionOptions(){
        int choice;
        System.out.println("______________\nWelcome To Transactions\n______________\n");



            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Balance");

            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: RS.");
                    double depositAmount = scanner.nextDouble();
                   deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: RS.");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("\n............Account balance Is RS." +getBalance() + "............\n");
                    break;

                case 4:
                    System.out.println("\nExiting From Banking System....");
                    break;

                default:
                    System.out.println("----Invalid choice. Please try again.----");
            }
        }



     @Override
     public double getBalance() {
         return balance;
     }



//    public void display(String s){
////        System.out.println("\tAccount Details\n\t________________\n\t");
////
////
////                System.out.println("\tAccount Holder: " + customer.getCustomerName() + "\n\tPhone: " + customer.getMobileNumber() + "\n\tAddress: "
////                        + customer.getAddress() + "\n\tAccount Number: " + customer.getAccountNumber() + "\n");
////
////
////
}
