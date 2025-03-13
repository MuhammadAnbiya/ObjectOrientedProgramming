import java.util.Scanner;

public class Nasabah {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=============================================");
        System.out.print("Nama Pemilik: ");
        String namaPemilik = sc.next();
        System.out.print("Nomor Rekening: ");
        String nomorRekening = sc.next();
        System.out.print("Saldo: ");
        double saldo = sc.nextDouble();

        System.out.println("Pilih jenis rekening:");
        System.out.println("1. Tabungan");
        System.out.println("2. Giro");
        System.out.println("3. Deposito");
        System.out.print("Pilihan: ");
        int jenisRekening = sc.nextInt();

        Rekening rekening;

        if (jenisRekening == 1) {
            System.out.print("Bunga Tahunan (%): ");
            double bungaTahunan = sc.nextDouble();
            rekening = new Tabungan(namaPemilik, nomorRekening, saldo, bungaTahunan);
        } else if (jenisRekening == 2) {
            System.out.print("Limit Penarikan Giro: ");
            double limitPenarikan = sc.nextDouble();
            rekening = new Giro(namaPemilik, nomorRekening, saldo, limitPenarikan);
        } else if (jenisRekening == 3) {
            System.out.print("Jangka Waktu (bulan): ");
            int jangkaWaktu = sc.nextInt();
            System.out.print("Bunga Tahunan (%): ");
            double bungaTahunan = sc.nextDouble();
            rekening = new Deposito(namaPemilik, nomorRekening, saldo, jangkaWaktu, bungaTahunan);
            
            ((Deposito) rekening).hitungBunga();
            
            System.out.println("Mencoba menarik saldo sebelum jatuh tempo...");
            ((Deposito) rekening).tarik(saldo / 2);
        } else {
            System.out.println("Pilihan tidak valid. Program berhenti.");
            sc.close();
            return;
        }

        while (true) {
            System.out.println("==========================");
            System.out.println("1. Menambah Saldo");
            System.out.println("2. Mengurangi Saldo");
            System.out.println("3. Menampilkan Informasi");
            System.out.println("4. Keluar");
            System.out.print("Pilih Menu: ");
            
            int menu = sc.nextInt();
            
            if (menu == 1) {
                System.out.print("Jumlah yang akan disetorkan: ");
                double jumlah = sc.nextDouble();
                rekening.setor(jumlah);
                System.out.println("Setoran berhasil.");
            } else if (menu == 2) {
                System.out.print("Jumlah Saldo yang akan ditarik: ");
                rekening.tarik(sc.nextDouble());
            } else if (menu == 3) {
                rekening.tampilkanInfo();
            } else if (menu == 4) {
                System.out.println("Terima kasih telah menggunakan layanan kami.");
                sc.close();
                System.exit(0);
            } else {
                System.out.println("Menu tidak ada!");
            }
        }
    }
}
