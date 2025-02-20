public class CarObject {
    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car();

        car1.setDataCar( "nissan", "blue", 0);
        car2.setDataCar("mitsubishi", "red", 0);

        car1.TurnOnCar(true);
        car1.IncreaseSpeed(10);
        car1.IncreaseSpeed(20);
        car1.IncreaseSpeed(40);

        car1.CarInfo();
        car2.CarInfo();

    }

}
