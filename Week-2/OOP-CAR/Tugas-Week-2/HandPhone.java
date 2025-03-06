public class HandPhone {
    String jenis_hp;
    int tahun_pembuatan;

    // Mengganti PSMV ke PSVM dan menambahkan parameter
    public void setDataHP(String jenis_hp, int tahun_pembuatan) {
        this.jenis_hp = jenis_hp;
        this.tahun_pembuatan = tahun_pembuatan;
    }

    // Menambahkan Return
    public String getJenisHP() {
        return jenis_hp;
    }

    // Menambahkan Return
    public int getTahunPembuatan() {
        return tahun_pembuatan;
    }

    // Perbaikan method main
    public static void main(String[] args) {
        HandPhone hp = new HandPhone();
        
        // Memberikan nilai sebelum dipanggil dalam method
        hp.setDataHP("Samsung", 2022);

        // Menampilkan output
        System.out.println("Jenis HP: " + hp.getJenisHP());
        System.out.println("Tahun Pembuatan: " + hp.getTahunPembuatan());
    }
}
