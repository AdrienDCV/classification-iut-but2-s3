package model;

import intefarces.IColumn;
import intefarces.IDistance;
import intefarces.IPoint;

public class DistanceManhattan implements IDistance{

	@Override
	public double calculDistance(IPoint p1, IPoint p2, IColumn colX, IColumn colY) {
		return Math.abs((double) colX.getNormalizedValue(p1) - (double) colX.getNormalizedValue(p2)) + 
				   Math.abs((double) colY.getNormalizedValue(p1) - (double) colY.getNormalizedValue(p2));
	}

}
