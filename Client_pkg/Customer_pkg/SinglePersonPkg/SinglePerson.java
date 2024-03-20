package Client_pkg.Customer_pkg.SinglePersonPkg;
import Client_pkg.Customer_pkg.Customer;
public 
class SinglePerson extends Customer{
    private String bin;
    public SinglePerson(String name , String email, String phoneNum, String bankName, String bin)
    {
        super(name, email, phoneNum, bankName, bin,null);   
        this.bin = bin;
    }

    public void setBin(String bin) {this.bin = bin;}
    public String getBin(){return this.bin;}
}
