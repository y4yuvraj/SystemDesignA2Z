package designPatterns.behavioural;

public class FactoryMethodDP {
    public static void main(String[] args) {

        Logistics logistics;

        logistics = getLogistics("ROAD");
        logistics.planDelivery();

        logistics = getLogistics("SEA");
        logistics.planDelivery();
    }

    // selector method
    public static Logistics getLogistics(String type) {
        if(type.equalsIgnoreCase("ROAD")) {
            return new RoadLogistics();
        }
        else if(type.equalsIgnoreCase("SEA")) {
            return new SeaLogistics();
        }
        else {
            throw new IllegalArgumentException("Invalid transport type");
        }
    }
}
interface Transport
{
    public void deliver();
}
class Truck implements Transport
{
    @Override
    public void deliver() {
        System.out.println("************* doing delivery by Truck **********");
    }
}
class Ship implements Transport
{
    @Override
    public void deliver() {
        System.out.println("************* doing delivery by Ship **********");
    }
}
abstract class Logistics {
    // This is the actual Factory Method
    public abstract Transport createTransport();

    public void planDelivery() {
        // Call the factory method to create a product object
        Transport t = createTransport();
        // Use the product
        t.deliver();
    }
}
class RoadLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Truck();
    }
}

class SeaLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Ship();
    }
}
