package Client_pkg.Employee_pkg;

public  class Trainee extends Employee{
    public Trainee (String name, String email, String phoneNum, String bankName) // overriding polymorphism
    {
        super(name, email, phoneNum, bankName, "Trainee");
        // this.empType = employeeType;
    }
}
