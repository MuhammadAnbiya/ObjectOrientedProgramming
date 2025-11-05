package com.perpustakaan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Koneksi {

    private static final String NAMA_DATABASE = "perpustakaan.db";
    private static final String URL = "jdbc:sqlite:" + NAMA_DATABASE;

    // Metode untuk membuat koneksi ke database
    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
            System.out.println("Koneksi ke SQLite berhasil.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    // Metode untuk membuat tabel 'buku' saat aplikasi pertama kali berjalan
    public static void setupDatabase() {
        String sql = "CREATE TABLE IF NOT EXISTS buku ("
                   + " id_buku TEXT PRIMARY KEY,"
                   + " judul TEXT NOT NULL,"
                   + " penulis TEXT NOT NULL,"
                   + " penerbit TEXT,"
                   + " tahun_terbit INTEGER,"
                   + " stok INTEGER NOT NULL DEFAULT 0"
                   + ");";
        
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            
            // Membuat tabel
            stmt.execute(sql);
            System.out.println("Tabel 'buku' siap digunakan.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}