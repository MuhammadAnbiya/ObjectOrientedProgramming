package Week4;

public class Clothing extends Product{
    int size;
    String material;

    public Clothing(String name, int price, int size, String material) {
        super(name, price);
        this.size = size;
        this.material = material;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }   

    public void ClothingInfo(){
        System.out.println("Name: " + getName());
        System.out.println("Price: " + getPrice());
        System.out.println("Size: " + getSize());
        System.out.println("Material: " + getMaterial());
    }
}
