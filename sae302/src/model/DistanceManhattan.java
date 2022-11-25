package model;


import intefarces.IPoint;

public class DistanceManhattan extends DistanceStrategy{

	@Override
	public double calculDistance(IPoint p1, IPoint p2, Column colX, Column colY) {
		return Math.abs((double) colX.getNormalizedValue(p1) - (double) colX.getNormalizedValue(p2)) + 
				   Math.abs((double) colY.getNormalizedValue(p1) - (double) colY.getNormalizedValue(p2));
	}

}
