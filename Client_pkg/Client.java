package Client_pkg;
public abstract class Client { // Abstraction
    private String name;
    private String email;
    private String phoneNum;
    protected int accNum;
    private String bankName;

    public Client (String name , String email, String phonrNum, String bankName) {
        this.name = name;
        this.email = email;
        this.phoneNum = phonrNum;
        this.accNum = 0;
        this.bankName = bankName;
    }

    public void printClient()
    {
        System.out.println("Name : " + this.name);
        System.out.println("Email : " + this.email);
        System.out.println("Phone Number : " + this.phoneNum);
        System.out.println("Bank Name : " + this.bankName);
        System.out.println("Account Number : " + this.accNum);
        
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
    public int getAccNum() {
        return accNum;
    }
    public void setAccNum(int accNum) {
        this.accNum = accNum;
    }
    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

}

