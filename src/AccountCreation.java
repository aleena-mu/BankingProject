import java.util.Scanner;
import java.util.UUID;


public class AccountCreation {
    Scanner sc = new Scanner(System.in);
    BankingSystem bs;

    public AccountCreation(BankingSystem bs) {
        this.bs = bs;
    }

    public Customer details(Customer[] arr) {
        Customer c = new Customer(null, null, null, null);
        arr[bs.i] = c;
        String name, accNo, address, phone;

        System.out.println("Enter name");
        name = sc.next();
        arr[bs.i].setCustName(name);

        System.out.println("Enter Address");
        address = sc.next();
        arr[bs.i].setAddr(address);

        System.out.println("Enter Phone Number");

        phone = sc.next();
        arr[bs.i].setMobNo(phone);

        accNo = generateAccountNumber();
        arr[bs.i].setacc(accNo);

        bs.cu[bs.i] = arr[bs.i];
        System.out.println("Deposit $1000 as initial balance for opening the account. \n1.Yes\n2.Exit from Account creation");
        int x = sc.nextInt();
        if (x == 1) {
            System.out.println("\n............................\nAccount created Successfully\n............................\n");
            System.out.println("\tAccount Details\n\t________________\n\t");
            displayDetails(arr, bs.i);
            System.out.println("1:Continue to login\n2:Exit");
            System.out.println("Enter The Option(1 or 2");


            if (sc.nextInt() == 1) {
                bs.login();
            } else {
                System.out.println("\nExiting From Banking System....");
                System.exit(0);
            }

            return arr[bs.i];
        } else {
            System.out.println("\nExiting From Banking System....");
            System.exit(0);
        }
        return null;
    }


    public static String generateAccountNumber() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid.substring(0, 10);
    }

    public void displayDetails(Customer[] arr, int k) {
        System.out.println("\tName: " + arr[k].getCustName() + "\n\tPhone: " + arr[k].getMobNo() + "\n\tAddress: "
                + arr[k].getAddr() + "\n\tAccount Number: " + arr[k].getacc() + "\n");
    }
}