public class BankBNI extends Bank {

    @Override
    public void sukuBunga() {
        System.out.println("Suku Bunga dari BNI adalah : 4%");
    }

    @Override
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        super.transferUang(jumlah, rekeningTujuan, "BNI");
    }

    @Override
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan, String berita) {
        super.transferUang(jumlah, rekeningTujuan, "BNI", berita);
    }
}