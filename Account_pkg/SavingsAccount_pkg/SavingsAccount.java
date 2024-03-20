package Account_pkg.SavingsAccount_pkg;

import Account_pkg.Account;

public class SavingsAccount extends Account
{
    private double interest = 0.25;
    private double balance = super.getBalance();

    public SavingsAccount(int accountNumber)
    {
        super(accountNumber);
        super.setAccountNumber(accountNumber);
        super.setAccountType("Savings");
    }
}