public class Tabungan extends Rekening {
    double bungaTahunan;

    public Tabungan(String namaPemilik, String nomorRekening, double saldo, double bungaTahunan) {
        super(namaPemilik, nomorRekening, saldo);
        this.bungaTahunan = bungaTahunan;
    }

    public double hitungBunga(int bulan) {
        if (bulan <= 0) {
            System.out.println("Jumlah bulan harus lebih dari 0.");
            return 0;
        }
        return (bungaTahunan / 12 / 100) * saldo * bulan;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Bunga Tahunan: " + bungaTahunan + "%");
        System.out.println("||||||||||||||||||||||||||||||||||");
    }
}
