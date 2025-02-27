public class BangunDatar {
    double panjang;
    double lebar;
    double sisi;
    double alas;
    double tinggi;

    public BangunDatar(double panjang, double lebar){
        this.panjang = panjang;
        this.lebar = lebar;
    }

    // public BangunDatar(double alas, double tinggi){
    //     this.alas = alas;
    //     this.tinggi = tinggi;
    // }

    public BangunDatar(double sisi){
        this.sisi = sisi;
    }

    public double LuasPersegiPanjang(){
        double luas = panjang * lebar;
        return luas;
    }

    public void setDataBangunDatar(double panjang, double lebar, double sisi, double alas, double tinggi){
        this.panjang = panjang;
        this.lebar = lebar;
        this.sisi = sisi;
        this.alas = alas;
        this.tinggi = tinggi;   
    }

    public double getPanjang(){
        return panjang;
    }

    public double getLebar(){
        return lebar;
    }

    public double getSisi(){
        return sisi;
    }

    public double getAlas(){
        return alas;
    }

    public double getTinggi(){
        return tinggi;
    }
}
