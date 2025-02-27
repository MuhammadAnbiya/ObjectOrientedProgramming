public class Employee {
    String name;
    double salary;
    double allowance;

    public Employee(String name, double salary, double allowance) {
        this.name = name;
        this.salary = salary;
        this.allowance = allowance;
    }

    public Employee(String name, double allowance){
        this.name = name;
        this.allowance = allowance;
    }

    public void setDataEmployee(String name, double salary, double allowance){
        this.name = name;
        this.salary = salary;
        this.allowance = allowance;
    }

    public String getName(){
        return name;
    }

    public double getSalary(){
        return salary;
    }

    public double getAllowance(){
        return allowance;
    }

    
}

