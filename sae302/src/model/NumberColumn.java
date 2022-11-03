package model;

import java.util.List;

import intefarces.IPoint;

public class NumberColumn extends Column{

    private static double minimumValue;
    private static double amplitude;

    public NumberColumn(String name, DataSet dataSet, List<IPoint> pointsList) {
        super(name, dataSet, pointsList);
        super.setNormalizer(new NumberValueNormalizer(this));
    }

}
