package Client_pkg.Customer_pkg.Organization_pkg;

import Client_pkg.Customer_pkg.Customer;

public class Organization extends Customer{
    private String tin;
    public Organization(String name , String email, String phoneNum, String bankName, String tin)
    {
        super(name, email, phoneNum, bankName, null,tin);
        this.tin = tin;
    }

    public void setTin(String tin) {this.tin = tin;}
    public String getTin(){return this.tin;}
}
