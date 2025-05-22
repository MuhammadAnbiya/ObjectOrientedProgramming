import java.util.Scanner;

public class Aritmatic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter the second number: ");
        int num2 = sc.nextInt();
        // System.out.println("The sum of " + num1 + " and " + num2 + " is " + (num1 + num2));
        // System.out.println("The difference of " + num1 + " and " + num2 + " is " + (num1 - num2));
        // System.out.println("The product of " + num1 + " and " + num2 + " is " + (num1 * num2));
        // System.out.println("The quotient of " + num1 + " and " + num2 + " is " + (num1 / num2));
        // System.out.println("The modulus of " + num1 + " and " + num2 + " is " + (num1 % num
        try {
            System.out.println("The sum of " + num1 + " and " + num2 + " is " + (num1 + num2));
            System.out.println("The difference of " + num1 + " and " + num2 + " is " + (num1 - num2));
            System.out.println("The product of " + num1 + " and " + num2 + " is " + (num1 * num2));
            System.out.println("The quotient of " + num1 + " and " + num2 + " is " + (num1 / num2));
            System.out.println("The modulus of " + num1 + " and " + num2 + " is " + (num1 % num2));
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (MatchException e) {
            System.out.println("Error: " + e.getMessage());
        }
         finally {
            System.out.println("Selalu dikerjakan");
        }

        System.out.println("Hasil Pembagian " + num1 + " dan " + num2 + " adalah " + (num1 / num2));
    }
}