public class Deposito extends Rekening{
    int jangkaWaktu;
    double bunga;
    boolean statusAktif;

    public Deposito(String namaPemilik, String nomorRekening, double saldo, int jangkaWaktu, double bunga) {
        super(namaPemilik, nomorRekening, saldo);
        this.jangkaWaktu = jangkaWaktu;
        this.bunga = bunga;
        this.statusAktif = true;
    }

    public double hitungBunga() {
        return (saldo * bunga / 100) * (jangkaWaktu / 12.0);
    }

    @Override
    public void tarik(double jumlah) {
        if (!statusAktif) {
            System.out.println("||||||||||||||||||||||||||||||||||");
            System.out.println("Deposito sudah dicairkan. Tidak bisa menarik saldo lagi.");
            System.out.println("||||||||||||||||||||||||||||||||||");
            return;
        }

        if (jangkaWaktu > 0) {
            System.out.println("||||||||||||||||||||||||||||||||||");
            System.out.println("Tidak dapat menarik saldo sebelum jatuh tempo.");
            System.out.println("||||||||||||||||||||||||||||||||||");
        } else {
            saldo += hitungBunga();
            System.out.println("||||||||||||||||||||||||||||||||||");
            System.out.println("Deposito telah jatuh tempo. Saldo dan bunga telah dicairkan.");
            System.out.println("Total saldo setelah bunga: " + saldo);
            System.out.println("||||||||||||||||||||||||||||||||||");
            statusAktif = false;
        }
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Jangka Waktu: " + jangkaWaktu + " bulan");
        System.out.println("Bunga: " + bunga + "% per tahun");
        System.out.println("Status: " + (statusAktif ? "Aktif" : "Sudah Dicairkan"));
        System.out.println("||||||||||||||||||||||||||||||||||");
    }
}
