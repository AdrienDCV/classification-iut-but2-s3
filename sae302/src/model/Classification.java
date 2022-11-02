package model;

public class Classification {

	
	public double euclidianDistance(double d1,double d2) {
		return Math.sqrt(Math.pow(d1-d2, 2));
	}
	
	public double manhatanDistance(double d1,double d2) {
		return Math.abs(d1-d2);
	}
}
