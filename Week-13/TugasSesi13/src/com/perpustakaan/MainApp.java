package com.perpustakaan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MainApp {

    // (Fitur 1) Menampilkan semua data buku
    private static void tampilkanBuku() {
        String sql = "SELECT * FROM buku";
        
        try (Connection conn = Koneksi.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            System.out.println("\n--- DAFTAR BUKU PERPUSTAKAAN ---");
            System.out.println("=================================================================================================");
            System.out.printf("| %-5s | %-30s | %-20s | %-15s | %-5s | %-4s |\n", 
                              "ID", "Judul", "Penulis", "Penerbit", "Tahun", "Stok");
            System.out.println("=================================================================================================");

            int jumlahBuku = 0;
            // Loop melalui hasil query
            while (rs.next()) {
                System.out.printf("| %-5s | %-30s | %-20s | %-15s | %-5d | %-4d |\n",
                                  rs.getString("id_buku"),
                                  rs.getString("judul"),
                                  rs.getString("penulis"),
                                  rs.getString("penerbit"),
                                  rs.getInt("tahun_terbit"),
                                  rs.getInt("stok"));
                jumlahBuku++;
            }
            
            if(jumlahBuku == 0) {
                System.out.println("|           TIDAK ADA DATA BUKU DI DATABASE. Silakan tambahkan buku terlebih dahulu.         |");
            }
            System.out.println("=================================================================================================");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // (Fitur 2) Menambahkan data buku baru
    private static void tambahkanBuku(Scanner scanner) {
        // SQL menggunakan '?' sebagai placeholder untuk PreparedStatement
        String sql = "INSERT INTO buku(id_buku, judul, penulis, penerbit, tahun_terbit, stok) VALUES(?,?,?,?,?,?)";

        try (Connection conn = Koneksi.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            System.out.println("\n--- TAMBAH BUKU BARU ---");
            
            // Mengambil input dari user
            System.out.print("ID Buku (e.g., BK001): ");
            String id_buku = scanner.nextLine();
            
            System.out.print("Judul Buku: ");
            String judul = scanner.nextLine();
            
            System.out.print("Penulis: ");
            String penulis = scanner.nextLine();
            
            System.out.print("Penerbit: ");
            String penerbit = scanner.nextLine();
            
            System.out.print("Tahun Terbit (Angka): ");
            int tahun_terbit = Integer.parseInt(scanner.nextLine());
            
            System.out.print("Stok (Angka): ");
            int stok = Integer.parseInt(scanner.nextLine());
            
            // Mengisi placeholder '?' dengan data
            pstmt.setString(1, id_buku);
            pstmt.setString(2, judul);
            pstmt.setString(3, penulis);
            pstmt.setString(4, penerbit);
            pstmt.setInt(5, tahun_terbit);
            pstmt.setInt(6, stok);
            
            // Eksekusi query
            pstmt.executeUpdate();
            System.out.println(">> Sukses! Buku '" + judul + "' berhasil ditambahkan ke database.");

        } catch (SQLException e) {
            System.out.println("Gagal menambahkan buku: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Input Tahun atau Stok tidak valid. Harap masukkan angka.");
        }
    }

    // Program Utama
    public static void main(String[] args) {
        // 1. Siapkan database dan tabel saat program pertama kali berjalan
        Koneksi.setupDatabase();
        
        Scanner scanner = new Scanner(System.in);
        String input = "";

        // 2. Tampilkan Menu
        while(true) {
            System.out.println("\n--- SISTEM DATABASE PERPUSTAKAAN ---");
            System.out.println("1. Tampilkan Data Buku");
            System.out.println("2. Tambahkan Data Buku");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1-3): ");
            
            input = scanner.nextLine();
            
            switch (input) {
                case "1":
                    tampilkanBuku();
                    break;
                case "2":
                    tambahkanBuku(scanner);
                    break;
                case "3":
                    System.out.println("Menutup aplikasi...");
                    scanner.close();
                    System.exit(0); // Keluar dari program
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}