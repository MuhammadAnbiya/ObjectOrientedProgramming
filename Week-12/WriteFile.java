import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public static void main(String[] args) {
        BufferedWriter bw = null;
        try{
            bw = new BufferedWriter(new FileWriter("data.txt", true));
            bw.write("Hallo!\n");
            bw.write("Apa Kabar\n");
            bw.write("Apakah Kamu baik-baik saja??\n");
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        finally{
            try {
                if(bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

