package Bank_pkg;

import java.util.*;
import Client_pkg.Employee_pkg.Employee;
import Client_pkg.Customer_pkg.Customer;
import Account_pkg.Account;
import Account_pkg.SalaryAccount_pkg.SalaryAccount;
import Account_pkg.SavingsAccount_pkg.SavingsAccount;

public class Bank
{
    private String name;
    private List<Employee>employees;
    private List<Customer> customers;
    private int curr_bank_acc_num = 133;

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
        System.out.println("\n\n-----------------------------------------");
        System.out.println("Bank Name : " + this.name);
        System.out.println("-----------------------------------------\n\n");

        System.out.println("Number of Employees : " + this.employees.size());
        System.out.println("-----------------------------------------");
        printEmployees();
        System.out.println("Number of Customers : " + this.customers.size());
        System.out.println("-----------------------------------------");
        printCustomers();

    }

    public Account openAccount(Customer customer, String accountType)
    {
        customer.setAccNum(curr_bank_acc_num+1);
        Account account = new Account(curr_bank_acc_num+1, accountType);
        customer.setAccNum(curr_bank_acc_num + 1);
        curr_bank_acc_num++;
        return account;
    }
    public Account openSavingsAccount(Customer customer)
    {
        customer.setAccNum(curr_bank_acc_num+1);
        SavingsAccount account = new SavingsAccount(curr_bank_acc_num+1);
        customer.setAccNum(curr_bank_acc_num + 1);
        curr_bank_acc_num++;
        return account;
    }

    public Account openSalaryAccount(Customer customer)
    {
        customer.setAccNum(curr_bank_acc_num+1);
        SalaryAccount account = new SalaryAccount(curr_bank_acc_num+1);
        customer.setAccNum(curr_bank_acc_num + 1);
        curr_bank_acc_num++;
        return account;
    }

    public void closeAccount(Customer customer) {
        customer.setAccNum(0);
    }

    public void transferMoney(Account fromAccount, Account toAccount, double amount) {
        if(fromAccount.getBalance() >= amount)
        { fromAccount.withdraw(amount); toAccount.deposit(amount); }
        else {
            System.out.println("You Dont have enough money to transfer");
        }
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

