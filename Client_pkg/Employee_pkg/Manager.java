package Client_pkg.Employee_pkg;

public class Manager extends Employee{ // Inheritance
    public Manager (String name, String email, String phoneNum,  String bankName) // overriding polymorphism
    {
        super(name, email, phoneNum, bankName, "Manager");
        // this.empType = employeeType;
    }
}