package designPatterns.behavioural;

public class StrategyDP {
    //client
    public static void main(String[] args) {
    BuildingRoute route= new BuildingRoute(new WalkRoute(),"KUN","KAS");
    route.buildRoute();

    BuildingRoute route2=new BuildingRoute(new CarRoute(),"DEL", "BOM");
    route2.buildRoute();

    // Now client can change algorithm at runtime:
    BuildingRoute route3 = new BuildingRoute(new WalkRoute(),"KUN","KAS");
    route3.buildRoute();

    route3.setRouteStrategy(new CarRoute());
    route3.buildRoute();

    route3.setRouteStrategy(new BicycleRoute());
    route3.buildRoute();
    }
}
class BuildingRoute
{
    RouteStrategy routeStrategy;
    String source;
    String destination;
    BuildingRoute(RouteStrategy routeStrategy, String source, String destination)
    {
        this.routeStrategy=routeStrategy;
        this.source=source;
        this.destination=destination;
    }

    public void buildRoute()
    {
        routeStrategy.buildRoute(source, destination);
    }

    public void setRouteStrategy(RouteStrategy routeStrategy)
    {
        this.routeStrategy = routeStrategy;
    }

}
interface RouteStrategy
{
    public void buildRoute(String source, String destination);
}

class WalkRoute implements RouteStrategy
{
    @Override
    public void buildRoute(String source, String destination) {
        //algorithm for building the route for walking
        System.out.println("Walking route for "+ source + " to " + destination);

    }
}
class BicycleRoute implements RouteStrategy
{
    @Override
    public void buildRoute(String source, String destination) {
        //algorithm for building the route for bicycle
        System.out.println("Bicycle route for "+ source + " to " + destination);
    }
}
class CarRoute implements RouteStrategy
{
    @Override
    public void buildRoute(String source, String destination) {
        //algorithm for building the route for Car
        System.out.println("Car route for "+ source + " to " + destination);
    }
}
