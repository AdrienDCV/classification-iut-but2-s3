package model;


public class DistanceStrategyFactory {

    public static DistanceStrategy createDistanceStrategy(String distanceStrategyName) {
        if (distanceStrategyName.equals("Euclidienne")) return new DistanceEuclidienne();
        else return new DistanceManhattan();
    }

}
