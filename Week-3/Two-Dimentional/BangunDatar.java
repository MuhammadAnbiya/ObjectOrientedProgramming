public class BangunDatar {
    double panjang;
    double lebar;
    double sisi;
    double alas;
    double tinggi;
    double sisiA;
    double sisiB;
    double sisiC;

    public BangunDatar(double panjang, double lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
    }

    public BangunDatar(double sisi) {
        this.sisi = sisi;
    }

    public BangunDatar(double alas, double tinggi,boolean isLuasSegitiga) {
        this.alas = alas;
        this.tinggi = tinggi;
    }

    public BangunDatar(double sisiA, double sisiB, double sisiC) {
        this.sisiA = sisiA;
        this.sisiB = sisiB;
        this.sisiC = sisiC;
    }



    public void setDataBangunDatar(double panjang, double lebar, double sisi, double alas, double tinggi, double sisiA, double sisiB, double sisiC) {
        this.panjang = panjang;
        this.lebar = lebar;
        this.sisi = sisi;
        this.alas = alas;
        this.tinggi = tinggi;
        this.sisiA = sisiA;
        this.sisiB = sisiB;
        this.sisiC = sisiC;
    }



    public double getPanjang() { return panjang; }
    public double getLebar() { return lebar; }
    public double getSisi() { return sisi; }
    public double getAlas() { return alas; }
    public double getTinggi() { return tinggi; }
    public double getSisiA() { return sisiA; }
    public double getSisiB() { return sisiB; }
    public double getSisiC() { return sisiC; }    
    public double getLuas() { return 0; }
    public double getKeliling() { return 0; }



    public double luasPersegiPanjang() {
        return panjang * lebar;
    }

    public double kelilingPersegiPanjang() {
        return 2 * (panjang + lebar);
    }

    public double luasPersegi() {
        return sisi * sisi;
    }

    public double kelilingPersegi() {
        return 4 * sisi;
    }

    public double luasSegitiga() {
        return 0.5 * (alas * tinggi);
    }

    public double kelilingSegitiga() {
        return sisiA + sisiB + sisiC;
    }
}
