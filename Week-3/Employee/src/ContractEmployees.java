public class ContractEmployees extends Employee {
    int dailySalary;
    int dailyAttend;

    public ContractEmployees(String name, double allowance){
        super(name, allowance);
        dailySalary = 200_000;
    }

    public void setContractEmployees(int dailySalary, int dailyAttend){
        this.dailySalary = dailySalary;
        this.dailyAttend = dailyAttend;
    }

    @Override
    public double getSalary(){
        double total = super.getAllowance() + dailySalary * dailyAttend;
        return total;
    }

    public int getDailySalary(){
        return dailySalary;
    }

    public int getDailyAttend(){
        return dailyAttend;
    }

    public void EmployeeInfo(){
        System.out.println("Name: " + super.getName());
        System.out.println("Daily Salary: " + getDailySalary());
        System.out.println("Daily Attend: " + getDailyAttend());
        System.out.println("Total: " + super.getSalary());
        System.out.println("================================");
    }



}
