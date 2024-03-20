package Client_pkg.Employee_pkg;

public class Officer extends Employee{
    public Officer (String name, String email, String phoneNum, String bankName) // overriding polymorphism
    {
        super(name, email, phoneNum, bankName, "Officer");
        // this.empType = employeeType;
    }
}
