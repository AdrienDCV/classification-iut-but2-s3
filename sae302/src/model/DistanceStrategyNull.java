package model;


import intefarces.IPoint;

public class DistanceStrategyNull extends DistanceStrategy {

    @Override
    public double calculDistance(IPoint p1, IPoint p2, Column colX, Column colY) {
        return 0;
    }

}
