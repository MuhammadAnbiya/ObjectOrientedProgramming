public class PersegiPanjang extends BangunDatar {
    public PersegiPanjang(double panjang, double lebar) {
        super(panjang, lebar);
    }

    @Override
    public double getLuas() {
        return luasPersegiPanjang();
    }

    @Override
    public double getKeliling() {
        return kelilingPersegiPanjang();
    }
}
