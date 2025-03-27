public class Item <T>{
    T code;
    String name;
    int stock;

    public Item(T code, String name, int stock) {
        this.code = code;
        this.name = name;
        this.stock = stock;
    }

    public T getCode() {
        return code;
    }

    public void setCode(T code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    
    public void infoItem(){
        System.out.println("Code: " + getCode() + "Name: " + getName() + "Stock: " + getStock());
    }

    public void addStock(int stock){
        this.stock += stock;
        System.out.println("Stock: " + getStock());
    }

    public void removeStock(int stock){
        this.stock -= stock;
        if(this.stock < 0){
            this.stock = 0;
        }
        System.out.println("Stock: " + getStock());
    }
}
