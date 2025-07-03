public class MainBank {
    public static void main(String[] args) {
        System.out.println("--- Pengujian Bank Umum ---");
        Bank bankUmum = new Bank();
        bankUmum.sukuBunga();
        bankUmum.transferUang(50000, "1234567890");
        bankUmum.transferUang(100000, "0987654321", "Mandiri");
        bankUmum.transferUang(200000, "1122334455", "BRI", "Pembayaran tagihan listrik");
        System.out.println("\n");

        System.out.println("--- Pengujian Bank BNI ---");
        BankBNI bankBNI = new BankBNI();
        bankBNI.sukuBunga();
        bankBNI.transferUang(75000, "9876543210", "BNI");
        bankBNI.transferUang(150000, "8765432109", "BNI", "Pembelian online");
        System.out.println("\n");

        System.out.println("--- Pengujian Bank BCA ---");
        BankBCA bankBCA = new BankBCA();
        bankBCA.sukuBunga();
        bankBCA.transferUang(120000, "7654321098", "BCA");
        bankBCA.transferUang(250000, "6543210987", "BCA", "Biaya pendidikan");
        System.out.println("\n");

        System.out.println("--- Contoh Saldo Tidak Cukup ---");
        Bank bankTestSaldo = new Bank();
        bankTestSaldo.saldo = 5000;
        bankTestSaldo.transferUang(10000, "9999999999");
        System.out.println("\n");
    }
}