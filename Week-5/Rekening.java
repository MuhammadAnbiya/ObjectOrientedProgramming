public class Rekening {
    String namaPemilik;
    String nomorRekening;
    double saldo;


    public void setor(double jumlah) {
        saldo += jumlah;
        System.out.println("||||||||||||||||||||||||||||||||||");
        System.out.println("Penambahasan Saldo Berhasil.");
        System.out.println("||||||||||||||||||||||||||||||||||");
    }

    public void tarik(double jumlah) {
        if (saldo >= jumlah) {
            System.out.println("||||||||||||||||||||||||||||||||||");
            System.out.println("Penarikan berhasil.");
            System.out.println("||||||||||||||||||||||||||||||||||");
            saldo -= jumlah;
        } else {
            System.out.println("||||||||||||||||||||||||||||||||||");
            System.out.println("Saldo tidak mencukupi.");
            System.out.println("||||||||||||||||||||||||||||||||||");
        }
    }

    public void tampilkanInfo() {
        System.out.println("||||||||||||||||||||||||||||||||||");
        System.out.println("Nama Pemilik: " + namaPemilik);
        System.out.println("Nomor Rekening: " + nomorRekening);
        System.out.println("Saldo: " + saldo);
        System.out.println("||||||||||||||||||||||||||||||||||");
    }

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public void setNamaPemilik(String namaPemilik) {
        this.namaPemilik = namaPemilik;
    }

    public String getNomorRekening() {
        return nomorRekening;
    }

    public void setNomorRekening(String nomorRekening) {
        this.nomorRekening = nomorRekening;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    

}
