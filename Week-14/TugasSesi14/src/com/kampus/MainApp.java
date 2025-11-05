package com.kampus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainApp {

    private static Scanner scanner = new Scanner(System.in);

    // --- FITUR 1: TAMPILKAN DATA ---
    private static void tampilkanDataMahasiswa() {
        String sql = "SELECT * FROM mahasiswa";
        
        try (Connection conn = Database.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            System.out.println("\n--- DAFTAR DATA MAHASISWA ---");
            System.out.println("======================================================================================");
            System.out.printf("| %-10s | %-25s | %-20s | %-15s | %-8s |\n", 
                              "NIM", "Nama Lengkap", "Jurusan", "Fakultas", "Angkatan");
            System.out.println("======================================================================================");

            int jumlahData = 0;
            while (rs.next()) {
                System.out.printf("| %-10s | %-25s | %-20s | %-15s | %-8d |\n",
                                  rs.getString("nim"),
                                  rs.getString("nama"),
                                  rs.getString("jurusan"),
                                  rs.getString("fakultas"),
                                  rs.getInt("angkatan"));
                jumlahData++;
            }
            
            if(jumlahData == 0) {
                System.out.println("|                      TIDAK ADA DATA MAHASISWA DI DATABASE.                       |");
            }
            System.out.println("======================================================================================");

        } catch (SQLException e) {
            System.out.println("Gagal menampilkan data: " + e.getMessage());
        }
    }

    // --- FITUR 2: INPUT DATA ---
    private static void inputDataMahasiswa() {
        String sql = "INSERT INTO mahasiswa(nim, nama, jurusan, fakultas, angkatan) VALUES(?,?,?,?,?)";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            System.out.println("\n--- INPUT DATA MAHASISWA BARU ---");
            
            System.out.print("NIM: ");
            String nim = scanner.nextLine();
            
            System.out.print("Nama Lengkap: ");
            String nama = scanner.nextLine();
            
            System.out.print("Jurusan: ");
            String jurusan = scanner.nextLine();
            
            System.out.print("Fakultas: ");
            String fakultas = scanner.nextLine();
            
            System.out.print("Angkatan (Tahun): ");
            int angkatan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline buffer

            pstmt.setString(1, nim);
            pstmt.setString(2, nama);
            pstmt.setString(3, jurusan);
            pstmt.setString(4, fakultas);
            pstmt.setInt(5, angkatan);
            
            pstmt.executeUpdate();
            System.out.println(">> Sukses! Data mahasiswa '" + nama + "' berhasil ditambahkan.");

        } catch (SQLException e) {
            System.out.println("Gagal menambahkan data: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Input Angkatan tidak valid. Harap masukkan angka.");
            scanner.nextLine(); // Membersihkan buffer scanner
        }
    }
    
    // --- FITUR 3: CARI DATA ---
    private static void cariDataMahasiswa() {
        System.out.println("\n--- CARI DATA MAHASISWA ---");
        System.out.print("Masukkan NIM mahasiswa yang ingin dicari: ");
        String nim = scanner.nextLine();
        
        String sql = "SELECT * FROM mahasiswa WHERE nim = ?";
        
        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, nim);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                System.out.println("\n--- DATA DITEMUKAN ---");
                System.out.println("NIM        : " + rs.getString("nim"));
                System.out.println("Nama       : " + rs.getString("nama"));
                System.out.println("Jurusan    : " + rs.getString("jurusan"));
                System.out.println("Fakultas   : " + rs.getString("fakultas"));
                System.out.println("Angkatan   : " + rs.getInt("angkatan"));
            } else {
                System.out.println(">> Data mahasiswa dengan NIM '" + nim + "' tidak ditemukan.");
            }

        } catch (SQLException e) {
            System.out.println("Gagal mencari data: " + e.getMessage());
        }
    }

    // --- FITUR 4: UBAH DATA ---
    private static void ubahDataMahasiswa() {
        System.out.println("\n--- UBAH DATA MAHASISWA ---");
        System.out.print("Masukkan NIM mahasiswa yang ingin diubah: ");
        String nim = scanner.nextLine();
        
        // Cek dulu apakah data ada
        String sqlCek = "SELECT * FROM mahasiswa WHERE nim = ?";
        String sqlUpdate = "UPDATE mahasiswa SET nama = ?, jurusan = ?, fakultas = ?, angkatan = ? WHERE nim = ?";

        try (Connection conn = Database.connect();
             PreparedStatement pstmtCek = conn.prepareStatement(sqlCek);
             PreparedStatement pstmtUpdate = conn.prepareStatement(sqlUpdate)) {
            
            pstmtCek.setString(1, nim);
            ResultSet rs = pstmtCek.executeQuery();
            
            if (rs.next()) {
                System.out.println("Data Lama:");
                String namaLama = rs.getString("nama");
                System.out.println("Nama: " + namaLama);
                
                // Input data baru
                System.out.print("Masukkan Nama Baru (Kosongkan jika tidak diubah): ");
                String namaBaru = scanner.nextLine();
                if(namaBaru.isEmpty()) {
                    namaBaru = namaLama; // Tetap pakai data lama jika input kosong
                }
                
                System.out.print("Masukkan Jurusan Baru (Kosongkan jika tidak diubah): ");
                String jurusanBaru = scanner.nextLine();
                if(jurusanBaru.isEmpty()) {
                    jurusanBaru = rs.getString("jurusan");
                }
                
                System.out.print("Masukkan Fakultas Baru (Kosongkan jika tidak diubah): ");
                String fakultasBaru = scanner.nextLine();
                if(fakultasBaru.isEmpty()) {
                    fakultasBaru = rs.getString("fakultas");
                }

                System.out.print("Masukkan Angkatan Baru (Kosongkan jika tidak diubah): ");
                String angkatanInput = scanner.nextLine();
                int angkatanBaru;
                if(angkatanInput.isEmpty()) {
                    angkatanBaru = rs.getInt("angkatan");
                } else {
                    angkatanBaru = Integer.parseInt(angkatanInput);
                }

                // Set parameter untuk query UPDATE
                pstmtUpdate.setString(1, namaBaru);
                pstmtUpdate.setString(2, jurusanBaru);
                pstmtUpdate.setString(3, fakultasBaru);
                pstmtUpdate.setInt(4, angkatanBaru);
                pstmtUpdate.setString(5, nim); // WHERE clause

                pstmtUpdate.executeUpdate();
                System.out.println(">> Sukses! Data mahasiswa '" + nim + "' berhasil diperbarui.");

            } else {
                System.out.println(">> Data mahasiswa dengan NIM '" + nim + "' tidak ditemukan.");
            }

        } catch (SQLException e) {
            System.out.println("Gagal mengubah data: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Input Angkatan tidak valid. Harap masukkan angka.");
        }
    }
    
    // --- FITUR 5: HAPUS DATA ---
    private static void hapusDataMahasiswa() {
        System.out.println("\n--- HAPUS DATA MAHASISWA ---");
        System.out.print("Masukkan NIM mahasiswa yang ingin dihapus: ");
        String nim = scanner.nextLine();
        
        String sql = "DELETE FROM mahasiswa WHERE nim = ?";
        
        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, nim);
            
            // executeUpdate() mengembalikan jumlah baris yang terpengaruh
            int affectedRows = pstmt.executeUpdate();
            
            if (affectedRows > 0) {
                System.out.println(">> Sukses! Data mahasiswa dengan NIM '" + nim + "' berhasil dihapus.");
            } else {
                System.out.println(">> Data mahasiswa dengan NIM '" + nim + "' tidak ditemukan.");
            }

        } catch (SQLException e) {
            System.out.println("Gagal menghapus data: " + e.getMessage());
        }
    }

    // --- PROGRAM UTAMA ---
    public static void main(String[] args) {
        // Siapkan database dan tabel saat program pertama kali berjalan
        Database.setupDatabase();
        
        String input = "";

        while(true) {
            System.out.println("\n--- SISTEM DATABASE MAHASISWA ---");
            System.out.println("1. Tampilkan Data Mahasiswa");
            System.out.println("2. Input Data Mahasiswa");
            System.out.println("3. Cari Data Mahasiswa");
            System.out.println("4. Ubah Data Mahasiswa");
            System.out.println("5. Hapus Data Mahasiswa");
            System.out.println("6. Exit");
            System.out.print("Pilih menu (1-6): ");
            
            input = scanner.nextLine();
            
            switch (input) {
                case "1":
                    tampilkanDataMahasiswa();
                    break;
                case "2":
                    inputDataMahasiswa();
                    break;
                case "3":
                    cariDataMahasiswa();
                    break;
                case "4":
                    ubahDataMahasiswa();
                    break;
                case "5":
                    hapusDataMahasiswa();
                    break;
                case "6":
                    System.out.println("Menutup aplikasi...");
                    scanner.close();
                    System.exit(0); // Keluar dari program
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}