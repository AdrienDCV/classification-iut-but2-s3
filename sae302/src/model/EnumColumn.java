package model;

import java.util.List;

import intefarces.IPoint;

public class EnumColumn extends Column{

    public EnumColumn(String name, DataSet dataSet, List<IPoint> pointsList) {
        super(name, dataSet, pointsList);
        this.setNormalizer(new EnumValueNormalizer(this));
    }

	@Override
	public boolean isNormalizable() {
		return true;
	}

}