import java.util.Scanner;

public class GudangMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Gudang<String> gudang = new Gudang<>();

        while (true) {
            System.out.println("======== Menu Gudang ========");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Hapus Barang");
            System.out.println("3. Barang Masuk");
            System.out.println("4. Barang Keluar");
            System.out.println("5. Tampilkan Semua Barang");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            int menu = sc.nextInt();

            switch (menu) {
                case 1:
                    System.out.print("Masukkan kode barang: ");
                    String code = sc.next();
                    System.out.print("Masukkan nama barang: ");
                    String name = sc.next();
                    System.out.print("Masukkan stok barang: ");
                    int stock = sc.nextInt();
                    gudang.addItem(new Item<String>(code, name, stock));
                    break;
                case 2:
                    System.out.print("Masukkan kode barang yang akan dihapus: ");
                    code = sc.next();
                    gudang.removeItem(code);
                    break;
                case 3:
                    System.out.println("Masukan kode barang yang ditambahkan stocknya");
                    String codeStock = sc.next();
                    System.out.println("Jumlah Stock barangnya");
                    int jumlahStock = sc.nextInt();
                    gudang.updateStock(codeStock, jumlahStock);
                    break;
                case 4:
                    System.out.println("Masukan kode barang yang dikeluarkan stocknya");
                    String codeStock1 = sc.next();
                    System.out.println("Jumlah Stock barangnya");
                    int jumlahStock1 = sc.nextInt();
                    gudang.removeStock(codeStock1, jumlahStock1);
                    break;
                case 5:
                    gudang.printItem();
                case 6:
                    System.out.println("Terima kasih!");
                    sc.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}

