package Client_pkg.Customer_pkg;
import Client_pkg.Client;
import Client_pkg.Employee_pkg.Employee;
import Account_pkg.Account;

public class Customer extends Client{
    private String bin; // Single Person
    private String tin; // Organization
    public Account account;

     // Ekjon Employee Jdi Customer Hy
    // ----------------------------------------------------------------
    public Customer(Employee employee, String bin) { 
        super(employee.getName(), employee.getEmail(), employee.getPhoneNum(),employee.getBankName());
        this.bin = bin;
    }

    public Customer (String name , String email, String phoneNum, String bankName, String bin, String tin)
    {
        super(name, email, phoneNum, bankName);
        if(bin == null)
        {
            this.tin = tin;
        }
        else {
            this.bin = bin;
        }
    }
   
        /* Overriding Polymorphism
        -------------------------------------------------------*/
    @Override
    public void printClient(){
        super.printClient();
        System.out.println("BIN Number : " + this.bin);
        System.out.println("TIN Number : " + this.tin);
        if(account != null && account.getAccountNumber() != 0){
            System.out.println("Account Type : " + "\"" +this.account.getAccountType()+ "\"" );
        }
    }

    public void printAccountBalance(){
        if(account != null)
        System.out.println(super.getName()+" Bank Balance : " + account.getBalance());
    }

    // getters and setters  (Encapsulation)
    
}

