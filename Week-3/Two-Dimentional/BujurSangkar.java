public class BujurSangkar extends BangunDatar {
    public BujurSangkar(double sisi) {
        super(sisi);
    }

    @Override
    public double getLuas() {
        return luasPersegi();
    }

    @Override
    public double getKeliling() {
        return kelilingPersegi();
    }
}
