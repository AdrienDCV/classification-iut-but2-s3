package model;

import intefarces.IColumn;
import intefarces.IPoint;

public abstract class DistanceStrategy {
    public abstract double calculDistance(IPoint p1, IPoint p2, IColumn colX, IColumn colY);
}
