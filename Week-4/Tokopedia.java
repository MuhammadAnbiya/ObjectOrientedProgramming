package Week4;

import java.util.Scanner;

public class Tokopedia {
    public static void main(String[] args) {
        Electronic electronic = null;
        Clothing clothing = null;
        Food food = null;

        Scanner sc = new Scanner(System.in);
        System.out.println("List Product: ");
        System.out.println("1. Laptop");
        System.out.println("2. Jaket");
        System.out.println("3. Seblak");
        System.out.println("Please choose your product: ");
        int choose = sc.nextInt();
        

        if (choose == 1){
            System.out.print("Masukkan nama barang Electronic: ");
            String name = sc.next();
            System.out.print("Harga: ");
            int price = sc.nextInt();
            System.out.print("Warranty: ");
            int warranty = sc.nextInt();
            electronic = new Electronic(name, price, warranty);
            electronic.ElectronicInfo();
        }

    }
}
