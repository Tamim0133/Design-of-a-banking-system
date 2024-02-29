import java.util.*;
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

    // getters and setters
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

    // getters and setters
    public String getEmpType() {
        return empType;
    }
    // public void setEmpType(String empType) { // setter apadoto lagtesena
    //     this.empType = empType;
    // }
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

    @Override
    public void printClient(){
        super.printClient();
        System.out.println("BIN Number : " + this.bin);
        System.out.println("TIN Number : " + this.tin);
    }
}

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

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount)
    {
        if(amount <= this.balance){
            balance -= amount;
        }
        else{
            System.out.println("Not Sufficient Balance");
        }
    }

    public double getBalance() {return this.balance;}
    public String getAccountType(){return this.accountType;}

}

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
            return account.getBalance() * 0.025; // 2.5% annual interest for Savings account
        } else  {
            return account.getBalance() * 0.02; // 2% annual interest for Salary account
        }
    }
}

public class Main{
    public static void main(String[] args)
    {
        Bank DutchBanglaBank = new Bank("Dutch Bangla Bank");


        Employee employee1 = new Employee("Rizvee", "<EMAIL>", "0000xxxxx", null, "Dutch Bangla Bank", "Employee");
        Employee employee2 = new Employee("Mary", "<EMAIL>", "0712345678", null, "Dutch Bangla Bank", "Employee");
        Employee employee3 = new Employee("Peter", "<EMAIL>", "0712345678", null, "Dutch Bangla Bank", "Employee");
        Employee employee4 = new Employee("Jane", "<EMAIL>", "0712345678", null, "Dutch Bangla Bank", "Employee");
        Employee employee5 = new Employee("Sara", "<EMAIL>","01902008974",null, "Dutch Bangla Bank", "Employee");

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
    }
}
