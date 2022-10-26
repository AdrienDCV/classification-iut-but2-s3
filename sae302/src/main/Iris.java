package main;

import intefarces.IColumn;
import intefarces.IPoint;

public class Iris implements IPoint {
	private double sepalLength;
	private double sepalWidth;
	private double petalLength;
	private double petalWidth;
	private String variety;
	
	public Iris(double sepalLength, double sepalWidth, double petalLength, double petalWidth, String variety) {
		super();
		this.sepalLength = sepalLength;
		this.sepalWidth = sepalWidth;
		this.petalLength = petalLength;
		this.petalWidth = petalWidth;
		this.variety = variety;
	}
	
	public Iris() {}

	@Override
	public String toString() {
		return "Iris [sepalLength=" + sepalLength + ", sepalWidth=" + sepalWidth + ", petalLength=" + petalLength
				+ ", petalWidth=" + petalWidth + ", variety=" + variety + "]";
	}

	@Override
	public Object getValue(IColumn col) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getNormalizedValue(IColumn xcol) {
		// TODO Auto-generated method stub
		return 0;
	};
	
	
	
}
