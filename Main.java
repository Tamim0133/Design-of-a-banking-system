import java.util.*;
/*------------------------------------------------------
                    Client
-------------------------------------------------------*/
abstract class Client {
    private String name;
    private String email;
    private String phoneNum;
    private String accNum;
    private String bankName;

    public Client (String name , String email, String phonrNum, String accNum, String bankName) {
        this.name = name;
        this.email = email;
        this.phoneNum = phonrNum;
        this.accNum = accNum;
        this.bankName = bankName;
    }

    public void printClient()
    {
        System.out.println("Name : " + this.name);
        System.out.println("Email : " + this.email);
        System.out.println("Phone Number : " + this.phoneNum);
        System.out.println("Account Number : " + this.accNum);
        System.out.println("Bank Name : " + this.bankName);
    }

    // getters and setters (Encapsulation)
    // ----------------------------------------------------------------
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNum() {
        return phoneNum;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    public String getAccNum() {
        return accNum;
    }
    public void setAccNum(String accNum) {
        this.accNum = accNum;
    }
    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

}
/*------------------------------------------------------
                    Employee
-------------------------------------------------------*/
class Employee extends Client{
    private String empType = "";
    public Employee(String name, String email, String phoneNum, String accNum, String bankName, String employeeType){
        super(name, email, phoneNum, accNum, bankName);
        this.empType = employeeType;
    }

    @Override
    public void printClient()
    {
        super.printClient();
        System.out.println("Type : " + this.empType);
    }

    // getters and setters  (Encapsulation)
    // ----------------------------------------------------------------
    public String getEmpType() {
        return empType;
    }
    public String getName() {
        return super.getName();
    }
    public String getEmail(){
        return super.getEmail();
    }
    public String getPhoneNum(){
        return super.getPhoneNum();
    }
    public String getAccNum(){
        return super.getAccNum();
    }

}

class Manager extends Employee{
    public Manager (String name, String email, String phoneNum, String accNum, String bankName, String employeeType)
    {
        super(name, email, phoneNum, accNum, bankName, "Manager");
        // this.empType = employeeType;
    }
}

class Officer extends Employee{
    public Officer (String name, String email, String phoneNum, String accNum, String bankName, String employeeType)
    {
        super(name, email, phoneNum, accNum, bankName, "Officer");
        // this.empType = employeeType;
    }
}

class Trainee extends Employee{
    public Trainee (String name, String email, String phoneNum, String accNum, String bankName, String employeeType)
    {
        super(name, email, phoneNum, accNum, bankName, "Trainee");
        // this.empType = employeeType;
    }
}


/*------------------------------------------------------
                    Customer 
-------------------------------------------------------*/
class Customer extends Client{
    private String bin; // Single Person
    private String tin; // Organization

    public Customer (String name , String email, String phoneNum, String accNum, String bankName, String bin, String tin)
    {
        super(name, email, phoneNum, accNum, bankName);
        if(bin.equals("-1"))
        {
            this.tin = tin;
        }
        else {
            this.bin = bin;
        }
    }
    public Customer (Employee employee , String bin )
    {
        super(employee.getName(), employee.getEmail(), employee.getPhoneNum(), employee.getAccNum(),employee.getBankName());
        this.bin = bin;
    }
        /* Overriding Polymorphism
        -------------------------------------------------------*/
    @Override
    public void printClient(){
        super.printClient();
        System.out.println("BIN Number : " + this.bin);
        System.out.println("TIN Number : " + this.tin);
    }
}

class SinglePerson extends Customer{
    private String bin;
    public SinglePerson(String name , String email, String phoneNum, String accNum, String bankName, String bin, String tin)
    {
        super(name, email, phoneNum, accNum, bankName, bin,tin);   
        this.bin = bin;
    }

    public void setBin(String bin) {this.bin = bin;}
    public String getBin(){return this.bin;}
}

class Organization extends Customer{
    private String tin;
    public Organization(String name , String email, String phoneNum, String accNum, String bankName, String bin, String tin)
    {
        super(name, email, phoneNum, accNum, bankName, bin,tin);
        this.tin = tin;
    }

    public void setTin(String tin) {this.tin = tin;}
    public String getTin(){return this.tin;}
}


/*------------------------------------------------------
                    Accounts 
-------------------------------------------------------*/

class Account
{
    private String accountNumber;
    private String accountType;
    private double balance;

  
    public Account(String accountNumber, String type) {
        this.accountNumber = accountNumber;
        this.accountType = type;
        this.balance = 0.0;
    }

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.accountType = null;
        this.balance = 0.0;
    }


    public void deposit(double amount) {
        this.balance += amount;
    }

    public double withdraw(double amount)
    {
        if(amount <= this.balance){
            balance -= amount;
        }
        else{
            System.out.println("Not Sufficient Balance");
        }
        return amount;
    }

    public double getBalance() {return this.balance;}
    public String getAccountType(){return this.accountType;}

    public void setAccountNumber(String accountNumber) {this.accountNumber = accountNumber;}
   public void setAccountType(String accountType) {this.accountType = accountType;}

}

class SavingsAccount extends Account
{
    private double interest = 0.25;
    private double balance = super.getBalance();

    public SavingsAccount(String accountNumber)
    {
        super(accountNumber);
        super.setAccountNumber(accountNumber);
        super.setAccountType("Savings");
    }
}

class SalaryAccount extends Account{
    private double interest = 0.2;
    private double balance = super.getBalance();

    public SalaryAccount(String accountNumber)
    {
        super(accountNumber);
        super.setAccountNumber(accountNumber);
        super.setAccountType("Salary");
    }
}
/*-------------------------------------
                 Bank
----------------------------------*/
class Bank
{
    private String name;
    private List<Employee>employees;
    private List<Customer> customers;

    public Bank(String name)
    {
        this.name = name;
        this.employees = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public void addEmployee(Employee employee)
    {
        employees.add(employee);
    }
    public void removeEmployee(Employee employee)
    {
        employees.remove(employee);
    }

    public void addCustomer (Customer customer)
    {
        customers.add(customer);
    }
    public void removeCustomer(Customer customer)
    {
        customers.remove(customer);
    }

    public void printEmployees()
    {
        for(Employee employee : employees)
        {
            employee.printClient();
            System.out.println();
        }
    }

    public void printCustomers()
    {
        for(Customer customer : customers)
        {
            customer.printClient();
            System.out.println();
        }
    }

    public void printBankInfo()
    {
        System.out.println("Bank Name : " + this.name);
        System.out.println("Number of Employees : " + this.employees.size());
        System.out.println("-----------------------------------------");
        printEmployees();
        System.out.println("Number of Customers : " + this.customers.size());
        System.out.println("-----------------------------------------");
        printCustomers();

    }

    public Account openAccount(Customer customer, String accountType, String accountNumber)
    {
        Account account = new Account(accountNumber, accountType);
        customer.setAccNum(accountNumber);
        return account;
    }
    public void closeAccount(Customer customer) {
        customer.setAccNum(null);
    }

    public void transferMoney(Account fromAccount, Account toAccount, double amount) {
        if(fromAccount.getBalance() >= amount)
        { fromAccount.withdraw(amount); toAccount.deposit(amount); }
    }
    public void withdrawMoney(Account account, double amount) {
        account.withdraw(amount);
    }
    public void DepositMoney(Account account, double amount) {
        account.deposit(amount);
    }

    public double calculateInterest(Account account) {
        if (account.getAccountType().equals("Saving")) {
            return account.getBalance() * 0.025; 
        } else  {
            return account.getBalance() * 0.02;
        }
    }
}


/*------------------------------------------------------
                    Bkash Wallet Account
-------------------------------------------------------*/

class BkashAccount{
    private double balance = 0.0;

    public void addBalance(double balance) {
        this.balance += balance;
    }
    public void printBalance()
    {
        System.out.println("Current Bkash Balance: " + balance);
    }

    public double withdrawFromBkash(double amount, Bank bank, Account account)
    {
        if(balance < amount){
            System.out.println("You Do not have enough money :')");
            return 0.0;
        }
        else 
        {
            bank.DepositMoney(account, amount);
            balance -= amount;
            return amount;
        }
    }
}
// Credit Card Information
//------------------------------    
class CreditCard{
    private double balance = 0.0;

    public void addBalance(double balance) {
        this.balance += balance;
    }
    public void printBalance()
    {
        System.out.println("Current Credit Card Balance: " + balance);
    }

    public double withdrawFromCreditCard(double amount, Account account, Bank bank)
    {
        if(balance < amount){
            System.out.println("You Do not have enough money :')");
            return 0.0;
        }
        else 
        {
            bank.DepositMoney(account, amount);
            balance -= amount;
            return amount;
        }
    }
}

public class Main{
    public static void main(String[] args)
    {
        Bank DutchBanglaBank = new Bank("Dutch Bangla Bank");


        Employee employee1 = new Employee("Rizvee", "<EMAIL>", "0000xxxxx", null, "Dutch Bangla Bank", "Employee");
        Employee employee2 = new Employee("Amio", "<EMAIL>", "0712345678", null, "Dutch Bangla Bank", "Employee");
        Employee employee3 = new Employee("Papry", "<EMAIL>", "0712345678", null, "Dutch Bangla Bank", "Employee");
        Employee employee4 = new Employee("Shakib", "<EMAIL>", "0712345678", null, "Dutch Bangla Bank", "Employee");
        Employee employee5 = new Employee("Tamim", "<EMAIL>","01902008974",null, "Dutch Bangla Bank", "Employee");

        DutchBanglaBank.addEmployee(employee1);
        DutchBanglaBank.addEmployee(employee2);
        DutchBanglaBank.addEmployee(employee3);
        DutchBanglaBank.addEmployee(employee4);
        DutchBanglaBank.addEmployee(employee5);

        Customer customer1 = new Customer ("Tauseef","Email","Phone", null,"Dutch Bangla Bank","001", "-1");
        Customer customer2 = new Customer ("Shampoo Compary","Email","Phone", null,"Dutch Bangla Bank","-1", "00001");
        Customer customer3 = new Customer(employee1, "002");

        DutchBanglaBank.addCustomer(customer1);
        DutchBanglaBank.addCustomer(customer2);
        DutchBanglaBank.addCustomer(customer3);

        DutchBanglaBank.printBankInfo();
        
        Account customer3Account =  DutchBanglaBank.openAccount(customer3, "Salary", "1234");
        Account customer2Account =  DutchBanglaBank.openAccount(customer2, "Savings", "1234");

        DutchBanglaBank.DepositMoney(customer3Account, 1000.00);
        DutchBanglaBank.DepositMoney(customer2Account, 3000.00);
        
        DutchBanglaBank.printBankInfo();

     
        System.out.println(customer2.getName()+" Balance : " + customer2Account.getBalance());        
        System.out.println(customer3.getName()+" Balance : " + customer3Account.getBalance());
        System.out.println();

        customer2Account.withdraw(500.00);
        System.out.println(customer2.getName()+" Balance : " + customer2Account.getBalance());        
        System.out.println(customer3.getName()+" Balance : " + customer3Account.getBalance());
        System.out.println();

        DutchBanglaBank.transferMoney(customer2Account, customer3Account, 1000);
        System.out.println(customer2.getName()+" Balance : " + customer2Account.getBalance());        
        System.out.println(customer3.getName()+" Balance : " + customer3Account.getBalance());
        System.out.println();

        DutchBanglaBank.transferMoney(customer2Account, customer3Account, 2000); // This will not be possible
        System.out.println(customer2.getName()+" Balance : " + customer2Account.getBalance());        
        System.out.println(customer3.getName()+" Balance : " + customer3Account.getBalance());
        System.out.println();

    
        BkashAccount forRizvee = new BkashAccount();

        forRizvee.printBalance();
        forRizvee.addBalance(customer2Account.withdraw(100));
        forRizvee.printBalance();
        System.out.println(customer2.getName()+" Balance : " + customer2Account.getBalance() + " \n");   
        

        forRizvee.withdrawFromBkash(330, DutchBanglaBank, customer2Account);
        forRizvee.printBalance();
        System.out.println(customer2.getName()+" Balance : " + customer2Account.getBalance() + "\n");   

        forRizvee.withdrawFromBkash(33, DutchBanglaBank, customer2Account);
        forRizvee.printBalance();
        System.out.println(customer2.getName()+" Balance : " + customer2Account.getBalance());   

        
    }
}
