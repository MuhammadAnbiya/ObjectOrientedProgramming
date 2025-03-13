import java.util.Scanner;

public class Nasabah {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Rekening rekening = new Rekening();

        System.out.println("=============================================");
        System.out.print("Nama Pemilik: ");
        rekening.setNamaPemilik(sc.next());
        System.out.print("Nomor Rekening: ");
        rekening.setNomorRekening(sc.next());
        System.out.print("Saldo: ");
        rekening.setSaldo(sc.nextDouble());

        while (true) {
            System.out.println("==========================");
            System.out.println("1. Menambah Saldo");
            System.out.println("2. Mengurangi Saldo");
            System.out.println("3. Menampilkan Informasi");
            System.out.println("4. Keluar");
            System.out.print("Pilih Menu: ");
            int menu = sc.nextInt();

            if (menu == 1) {
                System.out.print("Jumlah Saldo yang akan ditambahkan: ");
                rekening.setor(sc.nextDouble());
            } else if (menu == 2) {
                System.out.print("Jumlah Saldo yang akan dikurangi: ");
                rekening.tarik(sc.nextDouble());
            } else if (menu == 3) {
                rekening.tampilkanInfo();
            } else if (menu == 4) {
                System.exit(0);
            } else {
                System.out.println("Menu tidak ada!");
            }
        }
    }
}

