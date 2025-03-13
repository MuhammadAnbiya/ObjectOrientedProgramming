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
                System.out.println("Pilih metode setor:");
                System.out.println("1. Setor Tunai");
                System.out.println("2. Setor dari Rekening Lain");
                System.out.print("Pilihan: ");
                int metodeSetor = sc.nextInt();

                if (metodeSetor == 1) {
                    System.out.print("Jumlah yang akan disetorkan: ");
                    double jumlah = sc.nextDouble();
                    rekening.setor(jumlah);
                    System.out.println("Setoran tunai berhasil.");
                } else if (metodeSetor == 2) {
                    System.out.print("Masukkan nomor rekening sumber: ");
                    String rekeningSumber = sc.next();
                    System.out.print("Jumlah yang akan disetorkan: ");
                    double jumlah = sc.nextDouble();
                    rekening.setor(jumlah, true);
                    System.out.println("Setoran dari rekening " + rekeningSumber + " berhasil.");
                } else {
                    System.out.println("Metode setor tidak valid.");
                }
            } else if (menu == 2) {
                System.out.print("Jumlah Saldo yang akan dikurangi: ");
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
