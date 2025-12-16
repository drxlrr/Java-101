package m2.act6;


public class Car extends Vehicle implements Refuelable {
    public Car(int numWheels, String brand) {
        super(numWheels, brand);
    }

    @Override
    public void startEngine() {
        System.out.println(brand + " " + numWheels + " wheeler" + " Car engine started.");
    }

    @Override
    public void refuel() {
        System.out.println(brand + " " + numWheels + " wheeler" + " Car refueled/charged.");
    }
}
