package model;


import intefarces.IPoint;

public abstract class DistanceStrategy {
    public abstract double calculDistance(IPoint p1, IPoint p2, Column colX, Column colY);
}
