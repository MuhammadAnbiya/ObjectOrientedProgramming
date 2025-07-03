package Week4;

public class Food extends Product {
    String expired;

    public Food(String name, int price, String expired) {
        super(name, price);
        this.expired = expired;
    }



    public String getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }


    public void FoodInfo(){
        System.out.println("Name: " + getName());
        System.out.println("Price: " + getPrice());
        System.out.println("Expired: " + getExpired());
    }
    
}
