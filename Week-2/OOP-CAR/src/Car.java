public class Car {
    String brand;
    String color;
    int speed;
    Boolean isTurnedOn = false;


    public void setDataCar(String brand, String color, int k){
        // dibeberapa case kalau nama attribure dan value nya sama bisa menggunakan this
        this.brand = brand;
        this.color = color;
        speed = k;
    }

    public String getBrand(){
        return brand;
    }

    public String getColor(){
        return color;
    }

    public int getSpeed(){
        return speed;
    }

    public void CarInfo(){
        System.out.println("Brand: " + getBrand());
        System.out.println("Color: " + getColor());
        System.out.println("Speed: " + getSpeed());
        System.out.println("==============================");
    }
    

    public void IncreaseSpeed(int k){
        if (isTurnedOn == true){ 
            speed += k;
        }else{
            System.out.println("Car is turned off");
        }
    }


    public void TurnOnCar(Boolean True){
        isTurnedOn = True;
    }

    public void TurnOffCar(Boolean False){
        isTurnedOn = False;
    }
}

