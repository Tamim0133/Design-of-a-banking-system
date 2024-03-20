package Account_pkg.SalaryAccount_pkg;

import Account_pkg.Account;

public class SalaryAccount extends Account{
    private double interest = 0.2;
    private double balance = super.getBalance();

    public SalaryAccount(int accountNumber)
    {
        super(accountNumber);
        super.setAccountNumber(accountNumber);
        super.setAccountType("Salary");
    }
}