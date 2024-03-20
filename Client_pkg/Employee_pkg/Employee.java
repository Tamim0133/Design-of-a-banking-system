package Client_pkg.Employee_pkg;
import Client_pkg.Client;

public class Employee extends Client{
    private String empType = "";
    public Employee(String name, String email, String phoneNum, String bankName, String employeeType){
        super(name, email, phoneNum, bankName);
        this.empType = employeeType;
    }

    @Override
    public void printClient()
    {
        super.printClient();
        System.out.println("Type : " + this.empType);
    }

    // getters and setters  (Encapsulation)
    // ----------------------------------------------------------------
    public String getEmpType() {
        return empType;
    }
    public String getName() {
        return super.getName();
    }
    public String getEmail(){
        return super.getEmail();
    }
    public String getPhoneNum(){
        return super.getPhoneNum();
    }
    public int getAccNum(){
        return super.getAccNum();
    }

}


