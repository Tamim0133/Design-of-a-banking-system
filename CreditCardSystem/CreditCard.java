package CreditCardSystem;

import Bank_pkg.Bank;
import Account_pkg.Account;

public class CreditCard{
    private double balance = 0.0;
    private double current_debt = 0.0;

    public void withdrawFromCreditCard(double balance) {
        this.current_debt += balance + (balance * 10) / 100;
        printDebt();
    }
    public void returnDebt(Account account, double balance) {
        if(balance < current_debt)
        {account.withdraw(balance);
        this.current_debt-= balance;}
        else {
            account.withdraw(current_debt);
            this.current_debt = 0.0;
        }
    }

    public void returnDebt(Account account)
    {
        if(account.getBalance() < current_debt)
        {
            current_debt -= account.getBalance();
            account.setBalance(0);
        }
        else 
        {
            account.withdraw(current_debt);
            current_debt = 0;
        }
    }
    public void printBalance()
    {
        System.out.println("Current Credit Card Balance: " + balance);
    }
    public void printDebt()
    {
        System.out.println("Current Debt To Bank: " + current_debt);
    }
}
