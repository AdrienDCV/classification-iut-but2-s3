package model.iris;

import com.opencsv.bean.CsvBindByName;

import intefarces.IPoint;
import model.Column;

public class Iris implements IPoint {
	@CsvBindByName(column = "sepal.length")
	private double sepalLength;
	@CsvBindByName(column = "sepal.width")
	private double sepalWidth;
	@CsvBindByName(column = "petal.length")
	private double petalLength;
	@CsvBindByName(column = "petal.width")
	private double petalWidth;
	@CsvBindByName(column = "variety")
	private String variety;
	
	public Iris(double sepalLength, double sepalWidth, double petalLength, double petalWidth, String variety) {
		super();
		this.sepalLength = sepalLength;
		this.sepalWidth = sepalWidth;
		this.petalLength = petalLength;
		this.petalWidth = petalWidth;
		this.variety = variety;
	}

	public Iris(double sepalLength, double sepalWidth, double petalLength, double petalWidth) {
		super();
		this.sepalLength = sepalLength;
		this.sepalWidth = sepalWidth;
		this.petalLength = petalLength;
		this.petalWidth = petalWidth;
	}
	
	public Iris() {}

	@Override
	public String toString() {
		return "Iris [sepalLength=" + sepalLength + ", sepalWidth=" + sepalWidth + ", petalLength=" + petalLength
				+ ", petalWidth=" + petalWidth + ", variety=" + variety + "]";
	}

	@Override
	public Object getValue(Column col) {
		if (col.getName().equals("\"sepal.length\"")) return this.sepalLength;
		if (col.getName().equals("\"sepal.width\"")) return this.sepalWidth;
		if (col.getName().equals("\"petal.length\"")) return this.petalLength;
		if (col.getName().equals("\"petal.width\"")) return this.petalWidth;
		if (col.getName().equals("\"variety\"")) return this.variety;
		return null;
	}

	@Override
	public double getNormalizedValue(Column xcol) {
		return xcol.getNormalizedValue(this);
	}

	public String getVariety() {
		return variety;
	}

	public void setVariety(String variety) {
		this.variety = variety;
	}
	
	
	
	
	
	
	
}
