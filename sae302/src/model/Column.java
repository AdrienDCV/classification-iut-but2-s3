package model;

import java.util.Collection;
import java.util.List;

import intefarces.IColumn;
import intefarces.IDataSet;
import intefarces.IMVCModel;
import intefarces.IPoint;
import intefarces.IValueNormalizer;


/**
 * 
 * @author adrien
 *
 */
public abstract class Column implements IColumn{
	
	// class attributes
	protected String name;
	protected IMVCModel dataSet;
	protected List<IPoint> pointsList;
	protected ValueNormalizer valueNormalizer;
	
	// constructor(s)
	public Column(String name, IMVCModel dataSet, List<IPoint> pointsList) {
		this.name = name;
		this.dataSet = dataSet;
		this.pointsList = pointsList;
	}
	
	// methods
	@Override
	public void setNormalizer(IValueNormalizer valueNormalizer) {
		this.valueNormalizer = (ValueNormalizer) valueNormalizer;
	}

	@Override
	public double getNormalizedValue(IPoint point) {
		return this.valueNormalizer.normalize(point.getValue(this));
	}

	@Override
	public Object getDenormalizedValue(double value) {
		return this.valueNormalizer.denormalize(value);
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public IMVCModel getDataset() {
		return this.dataSet;
	}

	@Override
	public boolean isNormalizable() {
		return false;
	}

	public ValueNormalizer getNormalizer() { // pour effectuer tester
		return this.valueNormalizer;
	}

	public List<IPoint> getPointsList() {
		return pointsList;
	}
	

}
