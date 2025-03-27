public class GudangApp {
    public static void main(String[] args) {
        Gudang<String> gudang = new Gudang();
        Item<String> item1 = new Item<>("A001", "BUKU", 30);

        gudang.addItem(item1);
        gudang.printItem();

        gudang.addItem(new Item<>("A002","LAPTOP",20));
        gudang.printItem();

        gudang.addItem(new Item<>("A003","SPIDOl",20));
        gudang.printItem();


    }
}

