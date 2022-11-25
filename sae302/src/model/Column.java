package model;

import java.util.List;

import intefarces.IMVCModel;
import intefarces.IPoint;
import intefarces.IValueNormalizer;


/**
 * 
 * @author adrien.dacostaveiga.etu
 *
 */
public abstract class Column{
	
	// class attributes
	protected String name;
	protected DataSet dataSet;
	protected List<IPoint> pointsList;
	protected ValueNormalizer valueNormalizer;
	
	// constructor(s)
	public Column(String name, DataSet dataSet, List<IPoint> pointsList) {
		this.name = name;
		this.dataSet = dataSet;
		this.pointsList = pointsList;
	}
	
	// methods

	public void setNormalizer(IValueNormalizer valueNormalizer) {
		this.valueNormalizer = (ValueNormalizer) valueNormalizer;
	}


	public double getNormalizedValue(IPoint point) {
		return this.valueNormalizer.normalize(point.getValue(this));
	}

	public Object getDenormalizedValue(double value) {
		return this.valueNormalizer.denormalize(value);
	}


	public String getName() {
		return this.name;
	}


	public DataSet getDataset() {
		return this.dataSet;
	}


	public abstract boolean isNormalizable();

	public ValueNormalizer getNormalizer() { // pour effectuer tester
		return this.valueNormalizer;
	}

	public List<IPoint> getPointsList() {
		return pointsList;
	}
	

}