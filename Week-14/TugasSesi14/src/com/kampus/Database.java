package com.kampus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private static final String NAMA_DATABASE = "mahasiswa.db";
    private static final String URL = "jdbc:sqlite:" + NAMA_DATABASE;

    // Metode untuk membuat koneksi ke database
    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.out.println("Koneksi Gagal: " + e.getMessage());
        }
        return conn;
    }

    // Metode untuk membuat tabel 'mahasiswa' saat aplikasi pertama kali berjalan
    public static void setupDatabase() {
        String sql = "CREATE TABLE IF NOT EXISTS mahasiswa ("
                   + " nim TEXT PRIMARY KEY,"
                   + " nama TEXT NOT NULL,"
                   + " jurusan TEXT NOT NULL,"
                   + " fakultas TEXT,"
                   + " angkatan INTEGER"
                   + ");";
        
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            
            // Membuat tabel
            stmt.execute(sql);
            System.out.println("Database dan Tabel 'mahasiswa' siap digunakan.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}