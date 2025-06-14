import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner; 

public class CSVWriterModified {
    public static void main(String[] args) {
        String csvFile = "/media/muhammadanbiya/Data 1/Pemrograman Berorientasi Objek/Week-11/students.csv";        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Masukkan data mahasiswa baru:");
        System.out.print("NIM: ");
        String nim = scanner.nextLine();
        
        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        
        System.out.print("Umur: ");
        String umur = scanner.nextLine();
        
        System.out.print("Prodi: ");
        String prodi = scanner.nextLine();
        
        String dataBaru = nim + "," + nama + "," + umur + "," + prodi;
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile, true))) {
            bw.write(dataBaru);
            bw.newLine();
            
            System.out.println("\nData berhasil ditambahkan ke " + csvFile);
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}