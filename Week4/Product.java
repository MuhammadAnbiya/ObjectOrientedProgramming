package Week4;

public class Product {
    String name;
    int price;

    public Product(String name, int price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public int getPriceDisc(int disc){
        return getPrice() - getPrice()*disc/100;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
