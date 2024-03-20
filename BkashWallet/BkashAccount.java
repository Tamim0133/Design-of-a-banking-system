package BkashWallet;

import Account_pkg.Account;
import Bank_pkg.Bank;

public  class BkashAccount{
    private double balance = 0.0;

    public void addBalance(double balance) {
        this.balance += balance;
    }
    public void addBalance(Account account, double balance) {
        account.withdraw(balance);
        this.balance+=balance;
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
            System.out.println("Suucessfully withdraw from BKASH: " + amount);
            bank.DepositMoney(account, amount);
            balance -= amount;
            return amount;
        }
    }
}
 