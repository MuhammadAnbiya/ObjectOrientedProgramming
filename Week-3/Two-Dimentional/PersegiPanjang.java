public class PersegiPanjang extends BangunDatar {

    public PersegiPanjang(double panjang, double lebar){
        super(panjang, lebar);

    }

    public void setPersegiPanjang(double panjang, double lebar){
        this.panjang = panjang;
        this.lebar = lebar;
    }

    public double getLuasPersegiPanjang(){
        double luas = panjang * lebar;
        return luas;
    }

    public void luasTotal(){
        System.out.println("Luas Persegi Panjang:" + getLuasPersegiPanjang());
    }
}
