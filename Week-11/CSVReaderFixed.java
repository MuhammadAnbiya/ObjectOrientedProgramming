import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReaderFixed {
    public static void main(String[] args) {
        String csvFile = "/media/muhammadanbiya/Data 1/Pemrograman Berorientasi Objek/Week-11/students.csv";
        String line;
        String csvSplitBy = ",";
        int jumlahBaris = 0;

        System.out.println("NIM\t\tNAMA\t\tUMUR\tPRODI");

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] student = line.split(csvSplitBy);

                if (student.length >= 4) {
                    System.out.printf("%s\t%s\t%s\t%s%n", student[0], student[1], student[2], student[3]);
                    jumlahBaris++;
                } else {
                    System.out.println("Baris rusak atau tidak lengkap: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Gagal membaca file: " + e.getMessage());
        }

        System.out.println("\n======================================");
        System.out.println("Jumlah baris data dalam file: " + jumlahBaris);
        System.out.println("======================================");
    }
}
