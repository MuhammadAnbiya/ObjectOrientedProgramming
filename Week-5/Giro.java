public class Giro extends Rekening {
    private double limitPenarikan;

    public Giro(String namaPemilik, String nomorRekening, double saldo, double limitPenarikan) {
        super(namaPemilik, nomorRekening, saldo, 0);
        this.limitPenarikan = limitPenarikan;
    }

    @Override
    public void tarik(double jumlah) {
        if (getSaldo() >= jumlah) { 
            setSaldo(getSaldo() - jumlah);
            System.out.println("||||||||||||||||||||||||||||||||||");
            System.out.println("Penarikan berhasil.");
            System.out.println("||||||||||||||||||||||||||||||||||");
        } else if ((getSaldo() + limitPenarikan) >= jumlah) { 
            double sisa = jumlah - getSaldo();
            setSaldo(0);  // Saldo habis, sisa menggunakan limit giro
            limitPenarikan -= sisa;
            System.out.println("||||||||||||||||||||||||||||||||||");
            System.out.println("Penarikan berhasil dengan menggunakan limit giro.");
            System.out.println("Sisa limit giro: " + limitPenarikan);
            System.out.println("||||||||||||||||||||||||||||||||||");
        } else {
            System.out.println("||||||||||||||||||||||||||||||||||");
            System.out.println("Saldo dan limit giro tidak mencukupi.");
            System.out.println("||||||||||||||||||||||||||||||||||");
        }
    }

    public double getLimitPenarikan() {
        return limitPenarikan;
    }

    public void setLimitPenarikan(double limitPenarikan) {
        this.limitPenarikan = limitPenarikan;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Limit Penarikan Giro: " + limitPenarikan);
    }
}
