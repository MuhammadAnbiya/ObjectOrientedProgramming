public class PermanentEmployee extends Employee{
    int bonus;
    public PermanentEmployee(String name, double salary, double allowance){
        super(name, salary, allowance);
    }
    @Override
    public double getSalary(){
        double total = super.getSalary() + super.getAllowance() + bonus;
        return total;
    }

    public void EmployeeInfo(){
        System.out.println("Name: " + super.getName());
        System.out.println("Salary: " + super.getSalary());
        System.out.println("Allowance: " + super.getAllowance());
        System.out.println("Total: " + super.getSalary());
        System.out.println("================================");

    }
}
