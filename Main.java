import java.util.*;

import Bank_pkg.Bank;
import Account_pkg.Account;
import Client_pkg.Customer_pkg.Customer;
import Client_pkg.Employee_pkg.Employee;
import Client_pkg.Employee_pkg.Manager;
import Client_pkg.Employee_pkg.Officer;
import Client_pkg.Employee_pkg.Trainee;
import Client_pkg.Customer_pkg.SinglePersonPkg.SinglePerson;
import Client_pkg.Customer_pkg.Organization_pkg.Organization;
import BkashWallet.BkashAccount;
import CreditCardSystem.CreditCard;


public class Main{
    public static void main(String[] args)
    {
        Bank DutchBanglaBank = new Bank("Dutch Bangla Bank");  //  Creating a Bank


        Employee employee1 = new Employee("Rahul", "<EMAIL>", "0000xxxxx", "Dutch Bangla Bank", "Manager");
        Employee employee2 = new Employee("Amio", "<EMAIL>", "0712345678","Dutch Bangla Bank", "Officer");
        Manager employee3 = new Manager("Sadia", "<Email", "0000XXX", "Dutch Bangla Bank");
        Officer employee4 = new Officer("Shakib", "<EMAIL>", "0712345678", "Dutch Bangla Bank");
        Trainee employee5 = new Trainee("Tamim", "<EMAIL>","01902008974", "Dutch Bangla Bank");

        DutchBanglaBank.addEmployee(employee1);
        DutchBanglaBank.addEmployee(employee2);
        DutchBanglaBank.addEmployee(employee3);
        DutchBanglaBank.addEmployee(employee4);
        DutchBanglaBank.addEmployee(employee5);

        Customer customer1 = new Customer ("Tauseef","Email","Phone", "Dutch Bangla Bank","bin-001", null);
        Customer customer2 = new Customer ("Shampoo Compary","Email","Phone", "Dutch Bangla Bank",null, "tin-001");
        // Employee 1 as a customer
        Customer customer3 = new Customer(employee1, "bin-002");

        DutchBanglaBank.addCustomer(customer1);
        DutchBanglaBank.addCustomer(customer2);
        DutchBanglaBank.addCustomer(customer3);

        
        SinglePerson customer4 = new SinglePerson("SinglePerson1","Email","0000XXX","Dutch Bangla Bank","bin-003");
        Organization customer5 = new Organization("Organization2","Email","0000XXX","Dutch Bangla Bank","tin-003");
        
        DutchBanglaBank.addCustomer(customer4);
        DutchBanglaBank.addCustomer(customer5);
        
        
        customer2.account =  DutchBanglaBank.openAccount(customer2, "Savings"); // Shampoo Cmp
        customer3.account =  DutchBanglaBank.openAccount(customer3, "Salary"); // Rahul

        
        customer2.account =  DutchBanglaBank.openSavingsAccount(customer2); // Shampoo Cmp
        customer3.account =  DutchBanglaBank.openSalaryAccount(customer3); // Rahul

        DutchBanglaBank.printBankInfo();
        
        
        customer2.printAccountBalance();
        customer3.printAccountBalance();

        DutchBanglaBank.DepositMoney(customer2.account, 3000.00); // Manual Deposit
        DutchBanglaBank.DepositMoney(customer3.account, 1000.00);

        customer2.printAccountBalance();
        customer3.printAccountBalance();
     

        customer2.account.withdraw(500.00); // Manual Withdraw like Booth

        customer2.printAccountBalance();
        customer3.printAccountBalance();
        
        
        DutchBanglaBank.transferMoney(customer2.account, customer3.account, 1000);  // Shampoo Company to Rahul 1000 tk
        
        customer2.printAccountBalance();
        customer3.printAccountBalance();

        DutchBanglaBank.transferMoney(customer2.account, customer3.account, 2000); // This will not be possible , Shampoo does not have 2000 taka

        System.out.println();
    
        BkashAccount bkashOfRahul = new BkashAccount();
        bkashOfRahul.printBalance(); // Bkash e Balance

        bkashOfRahul.addBalance(customer3.account, 100); // Rahul 100 taka tar bank theke bkash e pathalo
        bkashOfRahul.printBalance();
        customer3.printAccountBalance(); 
        
        System.out.println();

        bkashOfRahul.withdrawFromBkash(330, DutchBanglaBank, customer3.account);
        bkashOfRahul.printBalance();
        customer3.printAccountBalance();

        System.out.println();

        bkashOfRahul.withdrawFromBkash(33, DutchBanglaBank, customer3.account);
        bkashOfRahul.printBalance();
        customer3.printAccountBalance();  


        CreditCard creditCardOfRahul = new CreditCard();
        creditCardOfRahul.withdrawFromCreditCard(100);
        creditCardOfRahul.withdrawFromCreditCard(150);

        creditCardOfRahul.returnDebt(customer3.account, 75);
        creditCardOfRahul.printDebt();
        customer3.printAccountBalance();

        bkashOfRahul.addBalance(customer3.account, 1700);
        customer3.printAccountBalance();

        creditCardOfRahul.returnDebt(customer3.account);
        creditCardOfRahul.printDebt();
        customer3.printAccountBalance();

        
    }
}
