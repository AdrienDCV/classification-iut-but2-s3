package model;

import java.util.List;

import intefarces.IMVCModel;
import intefarces.IPoint;

public class NumberColumn extends Column{

    private double minimumValue;
    private double amplitude;

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
            if (Double.parseDouble(point.getValue(this).toString()) < minimumValue) {
                minimumValue = Double.parseDouble(point.getValue(this).toString());
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
            if (point.getValue(this) != null && Double.parseDouble(point.getValue(this).toString()) > max) {
                max = (double) Double.parseDouble(point.getValue(this).toString());
            }
        }
        return max;
    }

    public void setAmplitudeValueClomun() {
        this.amplitude = this.getMaximumValue() - this.minimumValue;
    }

    public double getAmplitudeValueColumn() {
        return this.amplitude;
    }

	@Override
	public boolean isNormalizable() {
		return true;
	}

}