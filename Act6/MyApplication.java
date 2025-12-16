package m2.act6;

public class MyApplication {


public static void main(String[] args) {
	
        Car car = new Car(4, "NWOW");
        Truck truck = new Truck(10, "Lucky Lion");

        car.startEngine();
        car.refuel();

        truck.startEngine();
        truck.refuel();

        destroyVehicle(car);
        destroyVehicle(truck);
    }

    public static void destroyVehicle(Vehicle destVehicle) {
        destVehicle.destroy();
    }


}
