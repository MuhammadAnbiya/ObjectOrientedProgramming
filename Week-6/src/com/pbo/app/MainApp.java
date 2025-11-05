package com.pbo.app;

import com.pbo.interfaces.Laptop;
import com.pbo.interfaces.LaptopUser;
import com.pbo.interfaces.Lenovo;
import com.pbo.interfaces.Toshiba;
import com.pbo.interfaces.MacBook;

import java.util.Scanner;

public class MainApp {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Laptop device = null;
        
        System.out.println("Pilih Laptop yang ingin Anda gunakan:");
        System.out.println("1. Lenovo");
        System.out.println("2. Toshiba");
        System.out.println("3. MacBook");
        System.out.print("Pilihan Anda (1-3): ");
        
        String pilihanLaptop = scanner.nextLine();
        
        switch (pilihanLaptop) {
            case "1":
                device = new Lenovo();
                System.out.println("Anda memilih Lenovo.");
                break;
            case "2":
                device = new Toshiba();
                System.out.println("Anda memilih Toshiba.");
                break;
            case "3":
                device = new MacBook();
                System.out.println("Anda memilih MacBook.");
                break;
            default:
                System.out.println("Pilihan tidak valid. Menggunakan Lenovo secara default.");
                device = new Lenovo();
                break;
        }

        LaptopUser user = new LaptopUser(device);
        
        String input = "";
        
        while (true) {
            System.out.println("\n--- MENU KONTROL LAPTOP ---");
            System.out.println("ON   : Menyalakan laptop");
            System.out.println("OFF  : Mematikan laptop");
            System.out.println("UP   : Memperbesar volume");
            System.out.println("DOWN : Memperkecil volume");
            System.out.println("KELUAR : Keluar dari program");
            System.out.print("Masukkan perintah (ON/OFF/UP/DOWN/KELUAR): ");
            
            input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("ON")) {
                user.hidupkanLaptop();
            } else if (input.equalsIgnoreCase("OFF")) {
                user.matikanLaptop();
            } else if (input.equalsIgnoreCase("UP")) {
                user.tambahVolume();
            } else if (input.equalsIgnoreCase("DOWN")) {
                user.kurangiVolume();
            } else if (input.equalsIgnoreCase("KELUAR")) {
                System.out.println("Terima kasih. Program ditutup.");
                break;
            } else {
                System.out.println("Perintah tidak dikenali. Coba lagi.");
            }
        }
        
        scanner.close();
    }
}