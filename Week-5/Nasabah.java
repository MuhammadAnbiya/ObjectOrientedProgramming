import java.util.Scanner;

public class Nasabah {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tabungan tabungan = new Tabungan("", "", 0, 0);

        System.out.println("=============================================");
        System.out.print("Nama Pemilik: ");
        tabungan.setNamaPemilik(sc.next());
        System.out.print("Nomor Rekening: ");
        tabungan.setNomorRekening(sc.next());
        System.out.print("Saldo: ");
        tabungan.setSaldo(sc.nextDouble());
        System.out.print("Bunga Tahunan (%): ");
        tabungan.bungaTahunan = sc.nextDouble();

        while (true) {
            System.out.println("==========================");
            System.out.println("1. Menambah Saldo");
            System.out.println("2. Mengurangi Saldo");
            System.out.println("3. Menampilkan Informasi");
            System.out.println("4. Hitung Bunga");
            System.out.println("5. Keluar");
            System.out.print("Pilih Menu: ");
            int menu = sc.nextInt();

            if (menu == 1) {
                System.out.print("Jumlah Saldo yang akan ditambahkan: ");
                tabungan.setor(sc.nextDouble());
            } else if (menu == 2) {
                System.out.print("Jumlah Saldo yang akan dikurangi: ");
                tabungan.tarik(sc.nextDouble());
            } else if (menu == 3) {
                tabungan.tampilkanInfo();
            } else if (menu == 4) {
                System.out.print("Masukkan jumlah bulan: ");
                int bulan = sc.nextInt();
                double bunga = tabungan.hitungBunga(bulan);
                System.out.println("Bunga yang diperoleh: " + bunga);
            } else if (menu == 5) {
                System.exit(0);
            } else {
                System.out.println("Menu tidak ada!");
            }
        }
    }
}

