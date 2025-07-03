import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
        public void WriteFile(String filename, String nim, String nama, String alamat) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write("NIM: " + nim);
            writer.newLine();
            writer.write("Nama: " + nama);
            writer.newLine();
            writer.write("Alamat: " + alamat);
            writer.newLine();
            writer.close();
            System.out.println("Data berhasil ditulis ke file " + filename);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

