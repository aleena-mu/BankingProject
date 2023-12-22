package CustomerPackage;

import Account.BankAccount;

import java.util.regex.*;
public class Customer {

    private String customerName;
    private String mobileNumber;
    private String accountNumber;
    private String address;
    private BankAccount savingsAccount,currentAccount;


    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public BankAccount getSavingsAccount() {
        return savingsAccount;
    }

    public void setSavingsAccount(BankAccount savingsAccount) {
        this.savingsAccount = savingsAccount;
    }

    public BankAccount getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(BankAccount currentAccount) {
        this.currentAccount = currentAccount;
    }

    public boolean validation(String str)
    {
        Pattern pattern= Pattern.compile("[6-9][0-9]{9}");
        Matcher match = pattern.matcher(str);
        return (match.find() && match.group().equals(str));

    }


    public void dispaly(){
        System.out.println("********ACCOUNT DETAILS********");
        System.out.println("\tAccount Holder: " +getCustomerName() + "\n\tPhone: " + getMobileNumber() + "\n\tAddress: "
                + getAddress() + "\n\tAccount Number: " + getAccountNumber() + "\n");


    }
}
 