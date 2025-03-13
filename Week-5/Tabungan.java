public class Tabungan extends Rekening {
    double bungaTahunan;

    public Tabungan(String namaPemilik, String nomorRekening, double saldo, double bungaTahunan) {
        super(namaPemilik, nomorRekening, saldo);
        this.bungaTahunan = bungaTahunan;
    }

    public double hitungBunga(int bulan) {
        return (bungaTahunan/12/100) * saldo * bulan;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("||||||||||||||||||||||||||||||||||");
        System.out.println("Bunga Tahunan: " + bungaTahunan + "%");
        System.out.println("||||||||||||||||||||||||||||||||||");
    }
}

