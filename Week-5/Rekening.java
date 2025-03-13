public class Rekening {
    String namaPemilik;
    String nomorRekening;
    double saldo;
    double limitGiro;

    public Rekening(String namaPemilik, String nomorRekening, double saldo) {
        this.namaPemilik = namaPemilik;
        this.nomorRekening = nomorRekening;
        this.saldo = saldo;
        this.limitGiro = 0;
    }

    public Rekening(String namaPemilik, String nomorRekening, double saldo, double limitGiro) {
        this.namaPemilik = namaPemilik;
        this.nomorRekening = nomorRekening;
        this.saldo = saldo;
        this.limitGiro = limitGiro;
    }

    public void setor(double jumlah) {
        if (jumlah > 0) {
            saldo += jumlah;
            System.out.println("||||||||||||||||||||||||||||||||||");
            System.out.println("Penambahan saldo berhasil.");
            System.out.println("Saldo saat ini: " + saldo);
            System.out.println("||||||||||||||||||||||||||||||||||");
        } else {
            System.out.println("||||||||||||||||||||||||||||||||||");
            System.out.println("Jumlah setor harus lebih dari 0.");
            System.out.println("||||||||||||||||||||||||||||||||||");
        }
    }

    public void setor(double jumlah, boolean transfer) {
        if (jumlah > 0) {
            if (transfer) {
                double biayaAdmin = 2500;
                if (jumlah > biayaAdmin) {
                    saldo += (jumlah - biayaAdmin);
                    System.out.println("||||||||||||||||||||||||||||||||||");
                    System.out.println("Setoran melalui transfer berhasil.");
                    System.out.println("Biaya admin: " + biayaAdmin);
                    System.out.println("Saldo saat ini: " + saldo);
                    System.out.println("||||||||||||||||||||||||||||||||||");
                } else {
                    System.out.println("||||||||||||||||||||||||||||||||||");
                    System.out.println("Jumlah setor harus lebih besar dari biaya admin!");
                    System.out.println("||||||||||||||||||||||||||||||||||");
                }
            } else {
                setor(jumlah);
            }
        } else {
            System.out.println("||||||||||||||||||||||||||||||||||");
            System.out.println("Jumlah setor harus lebih dari 0.");
            System.out.println("||||||||||||||||||||||||||||||||||");
        }
    }

    public void tarik(double jumlah) {
        if (jumlah <= 0) {
            System.out.println("||||||||||||||||||||||||||||||||||");
            System.out.println("Jumlah penarikan harus lebih dari 0.");
            System.out.println("||||||||||||||||||||||||||||||||||");
            return;
        }

        if (saldo >= jumlah) {
            saldo -= jumlah;
            System.out.println("||||||||||||||||||||||||||||||||||");
            System.out.println("Penarikan berhasil.");
            System.out.println("Saldo tersisa: " + saldo);
            System.out.println("||||||||||||||||||||||||||||||||||");
        } else if ((saldo + limitGiro) >= jumlah) {
            double sisa = jumlah - saldo;
            saldo = 0;
            limitGiro -= sisa;
            System.out.println("||||||||||||||||||||||||||||||||||");
            System.out.println("Penarikan berhasil dengan menggunakan limit giro.");
            System.out.println("Sisa limit giro: " + limitGiro);
            System.out.println("||||||||||||||||||||||||||||||||||");
        } else {
            System.out.println("||||||||||||||||||||||||||||||||||");
            System.out.println("Saldo dan limit giro tidak mencukupi.");
            System.out.println("||||||||||||||||||||||||||||||||||");
        }
    }

    public void tampilkanInfo() {
        System.out.println("||||||||||||||||||||||||||||||||||");
        System.out.println("Nama Pemilik: " + namaPemilik);
        System.out.println("Nomor Rekening: " + nomorRekening);
        System.out.println("Saldo: " + saldo);
        if (limitGiro > 0) {
            System.out.println("Limit Giro: " + limitGiro);
        }
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

    public double getLimitGiro() {
        return limitGiro;
    }

    public void setLimitGiro(double limitGiro) {
        this.limitGiro = limitGiro;
    }

    
}
