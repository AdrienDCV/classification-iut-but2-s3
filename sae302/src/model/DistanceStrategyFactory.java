package model;


public class DistanceStrategyFactory {

    public static DistanceStrategy createDistanceStrategy(String distanceStrategyName) {
        if (distanceStrategyName.equals("Euclidienne")) return new DistanceEuclidienne();
        if (distanceStrategyName.equals("Manhattan")) return new DistanceManhattan();
        return new DistanceStrategyNull();
    }

}
