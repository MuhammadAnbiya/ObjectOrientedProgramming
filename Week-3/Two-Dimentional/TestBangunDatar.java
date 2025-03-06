import java.util.Scanner;

public class TestBangunDatar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BangunDatar bangunDatar = null;

        System.out.println("Pilih bangun datar:");
        System.out.println("1. Persegi Panjang");
        System.out.println("2. Bujur Sangkar");
        System.out.println("3. Segitiga");
        int pilihan = sc.nextInt();

        System.out.println("Hitung:");
        System.out.println("1. Luas");
        System.out.println("2. Keliling");
        int hitung = sc.nextInt();

        switch (pilihan) {
            case 1:
                System.out.print("Masukkan panjang: ");
                double panjang = sc.nextDouble();
                System.out.print("Masukkan lebar: ");
                double lebar = sc.nextDouble();
                bangunDatar = new PersegiPanjang(panjang, lebar);
                break;

            case 2:
                System.out.print("Masukkan sisi: ");
                double sisi = sc.nextDouble();
                bangunDatar = new BujurSangkar(sisi);
                break;

            case 3:
                if (hitung == 1) {
                    System.out.print("Masukkan alas: ");
                    double alas = sc.nextDouble();
                    System.out.print("Masukkan tinggi: ");
                    double tinggi = sc.nextDouble();
                    bangunDatar = new Segitiga(alas, tinggi, true);
                } else { 
                    System.out.print("Masukkan sisi pertama: ");
                    double sisiA = sc.nextDouble();
                    System.out.print("Masukkan sisi kedua: ");
                    double sisiB = sc.nextDouble();
                    System.out.print("Masukkan sisi ketiga: ");
                    double sisiC = sc.nextDouble();
                    bangunDatar = new Segitiga(sisiA, sisiB, sisiC);
                }
                break;

            default:
                System.out.println("Pilihan tidak valid.");
                break;
        }

        if (bangunDatar != null) {
            if (hitung == 1) {
                System.out.println("Luas: " + bangunDatar.getLuas());
            } else if (hitung == 2) {
                System.out.println("Keliling: " + bangunDatar.getKeliling());
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }
        sc.close();
    }
}
