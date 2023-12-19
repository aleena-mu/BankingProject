
import java.util.Scanner;
import java.util.regex.*;
public class Customer {

    private String customerName;
    private String mobileNumber;
    private String accountNumber;
    private String address;
    public Customer( String customerName, String mobileNumber, String accountNumber, String address) {


        this.customerName = customerName;
        this.mobileNumber = mobileNumber;
        this.accountNumber = accountNumber;
        this.address = address;
    }

    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String custName) {
        this.customerName = customerName;
    }
    public String getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(String mobileNumber) {
        if (validation(mobileNumber))
        {
            this.mobileNumber = mobileNumber;
        }
       else {
           System.out.println("Enter valid mobile number");

            Scanner sc=new Scanner(System.in);
            mobileNumber= sc.next();
           setMobileNumber(mobileNumber);
        }
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String acc) {
        this.accountNumber = accountNumber;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String addr) {
        this.address = addr;
    }

    public boolean validation(String str)
    {
        Pattern ptrn = Pattern.compile("[6-9][0-9]{9}");
        Matcher match = ptrn.matcher(str);
        return (match.find() && match.group().equals(str));
    }
}
 