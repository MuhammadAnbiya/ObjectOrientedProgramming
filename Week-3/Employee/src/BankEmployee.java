import java.util.Scanner;

public class BankEmployee {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=====================");
        System.out.println("Enter your name: ");
        System.out.println("1. Permanent Employee");
        System.out.println("2. Contract Employee");

        System.out.println("Please fill in the options: ");
        int option = sc.nextInt();
        System.out.println("Name: ");
        String nama = sc.next();
        System.out.println("Allowance: ");
        double allowance = sc.nextDouble();

        if(option == 1){
            System.out.println("Main Salary");
            double mainSalary = sc.nextDouble();
            PermanentEmployee e1 = new PermanentEmployee(nama, mainSalary, allowance);
            e1.EmployeeInfo(); 
        }else{
            System.out.println("Daily Salary: ");
            int dailySalary = sc.nextInt();
            System.out.println("Daily Attend: ");
            int dailyAttend = sc.nextInt();
            ContractEmployees e2 = new ContractEmployees(nama, allowance);
            e2.setContractEmployees(dailySalary, dailyAttend);
            e2.EmployeeInfo();
        }
    }
}
