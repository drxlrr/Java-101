package m2.act6;


public class Truck extends Vehicle implements Refuelable {
    public Truck(int numWheels, String brand) {
        super(numWheels, brand);
    }

    @Override
    public void startEngine() {
        System.out.println(brand + " " + numWheels + " wheeler" + " engine started.");
    }

    @Override
    public void refuel() {
        System.out.println(brand + " " + numWheels + " wheeler" + " Truck refueled/charged.");
    }
}

