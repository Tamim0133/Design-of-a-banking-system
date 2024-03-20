package Account_pkg;

public class Account
{
    private int accountNumber;
    private String accountType;
    private double balance;

  
    public Account(int accountNumber, String type) {
        this.accountNumber = accountNumber;
        this.accountType = type;
        this.balance = 0.0;
    }

    public Account(int accountNumber) {
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
    public int getAccountNumber() {return this.accountNumber;}

    public void setAccountNumber(int accountNumber) {this.accountNumber = accountNumber; }
    public void setAccountType(String accountType) {this.accountType = accountType;}
    public void setBalance(double amount){this.balance = amount;}

}