package model;

import intefarces.IColumn;
import intefarces.IPoint;

public class DistanceStrategyNull extends DistanceStrategy {

    @Override
    public double calculDistance(IPoint p1, IPoint p2, IColumn colX, IColumn colY) {
        return 0;
    }

}
