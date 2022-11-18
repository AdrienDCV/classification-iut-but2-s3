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

    public double getMinimumValue() {
        setMinimumValue();
        return minimumValue;
    }

    private void setMinimumValue() {
        minimumValue = Double.MAX_VALUE;
        for (IPoint point : this.pointsList) {
            if ((Double) point.getValue(this) < minimumValue) {
                minimumValue = (Double) point.getValue(this);
            }
        }
    }

    public double getMaximumValue() {
        double max = maximumValue();
        return max;
    }

    private double maximumValue() {
        double max = 0.0;
        for (IPoint point : this.pointsList) {
            if ((double) point.getValue(this) > max) {
                max = (double) point.getValue(this);
            }
        }
        return max;
    }

    public void setAmplitudeValueClomun() {
        NumberColumn.amplitude = this.getMaximumValue() - NumberColumn.minimumValue;
    }

    public double getAmplitudeValueColumn() {
        return NumberColumn.amplitude;
    }

}
