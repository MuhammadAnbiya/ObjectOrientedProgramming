public class Segitiga extends BangunDatar {
    public Segitiga(double alas, double tinggi, boolean isLuasSegitiga) {
        super(alas, tinggi, isLuasSegitiga);
    }

    public Segitiga(double sisiA, double sisiB, double sisiC) {
        super(sisiA, sisiB, sisiC);
    }

    @Override
    public double getLuas() {
        return luasSegitiga();
    }

    @Override
    public double getKeliling() {
        return kelilingSegitiga(); 
    }
}
