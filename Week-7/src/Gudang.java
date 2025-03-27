import java.util.HashMap;
import java.util.Map;

public class Gudang<T> {
    private Map<T, Item<T>> barang;

    public Gudang() {
        barang = new HashMap<>();
    }

    public void addItem(Item<T> item) {
        barang.put(item.getCode(), item);
        System.out.println(item.getName() + " berhasil ditambahkan");
    }

    public void removeItem(T code) {
        if (barang.containsKey(code)) {
            System.out.println(barang.get(code).getName() + " berhasil dihapus");
            barang.remove(code);
        } else {
            System.out.println("Barang dengan kode " + code + " tidak ditemukan");
        }
    }

    public void updateStock(T code, int stock) {
        if (barang.containsKey(code)) {
            barang.get(code).addStock(stock);
            System.out.println("Stock dari barang " + barang.get(code).getName() + " berhasil ditambahkan");
        } else {
            System.out.println("Barang dengan kode " + code + " tidak ditemukan");
        }
    }

    public void removeStock(T code, int stock) {
        if (barang.containsKey(code)) {
            barang.get(code).removeStock(stock);
            System.out.println("Stock dari barang " + barang.get(code).getName() + " berhasil dikurangi");
        } else {
            System.out.println("Barang dengan kode " + code + " tidak ditemukan");
        }
    }

    public void printItem(T code) {
        for(Item<T> item : barang.values()) {
            if (item.getCode().equals(code)) {
                item.infoItem();
            }
        }
    }
}
