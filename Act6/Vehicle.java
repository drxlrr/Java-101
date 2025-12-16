package m2.act6;

public abstract class Vehicle {
    protected int numWheels;
    protected String brand;

    public Vehicle(int numWheels, String brand) {
        this.numWheels = numWheels;
        this.brand = brand;
    }

    public abstract void startEngine();

    public void destroy() {
        System.out.println(brand + " " + numWheels + " wheeler" + " destroyed.");
    }
}

