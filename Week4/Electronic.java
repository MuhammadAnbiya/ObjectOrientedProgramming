package Week4;

public class Electronic extends Product {
    int warranty;
    int disc = 20;

    public Electronic(String name, int price, int warranty) {
        super(name, price);
        this.warranty = warranty;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    public void ElectronicInfo() {
        System.out.println("Name: " + getName());
        if (price > 10){
            System.out.println("Selamat anda mendapatkan diskon harga potongan nya : " + getPriceDisc(price));
        }else{
            System.out.println("Price: " + getPrice());
        }
        System.out.println("Warranty: " + getWarranty());
    }
}