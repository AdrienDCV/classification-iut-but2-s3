package model;

import java.util.List;

import intefarces.IPoint;

public class BooleanColumn extends Column {

    public BooleanColumn(String name, DataSet dataSet, List<IPoint> pointsList) {
        super(name, dataSet, pointsList);
        this.setNormalizer(new BooleanValueNormalizer(this));
    }

	@Override
	public boolean isNormalizable() {
		return true;
	}
    
}