import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSVCopier {
    public static void main(String[] args) {
        String fileSumber = "/media/muhammadanbiya/Data 1/Pemrograman Berorientasi Objek/Week-11/students.csv";
        String fileTujuan = "/media/muhammadanbiya/Data 1/Pemrograman Berorientasi Objek/Week-11/students_copy.csv";

        System.out.println("Mulai menyalin file...");

        try (BufferedReader br = new BufferedReader(new FileReader(fileSumber));
             BufferedWriter bw = new BufferedWriter(new FileWriter(fileTujuan))) {

            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }

        } catch (IOException e) {
            System.err.println("Terjadi kesalahan: " + e.getMessage());
        }

        System.out.println("File berhasil disalin dari " + fileSumber + " ke " + fileTujuan);
    }
}
