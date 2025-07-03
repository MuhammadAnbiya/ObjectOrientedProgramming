public class Bank {

    protected double saldo = 1000000;

    public void transferUang(int jumlah, String rekeningTujuan) {
        if (saldo >= jumlah) {
            saldo -= jumlah;
            System.out.println("Transfer sebesar Rp" + jumlah + " ke rekening " + rekeningTujuan + " berhasil.");
            System.out.println("Sisa saldo: Rp" + saldo);
        } else {
            System.out.println("Saldo tidak mencukupi untuk transfer Rp" + jumlah + ".");
        }
    }

    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        if (saldo >= jumlah) {
            saldo -= jumlah;
            System.out.println("Transfer sebesar Rp" + jumlah + " ke rekening " + rekeningTujuan + " (" + bankTujuan + ") berhasil.");
            System.out.println("Sisa saldo: Rp" + saldo);
            hitungBiayaTransfer(bankTujuan);
        } else {
            System.out.println("Saldo tidak mencukupi untuk transfer Rp" + jumlah + ".");
        }
    }

    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan, String berita) {
        if (saldo >= jumlah) {
            saldo -= jumlah;
            System.out.println("Transfer sebesar Rp" + jumlah + " ke rekening " + rekeningTujuan + " (" + bankTujuan + ") dengan berita: \"" + berita + "\" berhasil.");
            System.out.println("Sisa saldo: Rp" + saldo);
            hitungBiayaTransfer(bankTujuan);
        } else {
            System.out.println("Saldo tidak mencukupi untuk transfer Rp" + jumlah + ".");
        }
    }

    public void sukuBunga() {
        System.out.println("Suku Bunga standar adalah 3%");
    }

    protected void hitungBiayaTransfer(String bankTujuan) {
        double biaya = 0;
        switch (bankTujuan.toUpperCase()) {
            case "BNI":
            case "BCA":
                biaya = 6500;
                break;
            default:
                biaya = 0;
                break;
        }
        if (biaya > 0) {
            System.out.println("Biaya transfer ke " + bankTujuan + ": Rp" + biaya);
            if (saldo >= biaya) {
                saldo -= biaya;
                System.out.println("Biaya transfer telah dipotong. Sisa saldo: Rp" + saldo);
            } else {
                System.out.println("Saldo tidak cukup untuk biaya transfer.");
            }
        }
    }
}