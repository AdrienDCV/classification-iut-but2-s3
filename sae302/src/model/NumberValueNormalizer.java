package model;

import intefarces.IColumn;


public class NumberValueNormalizer extends ValueNormalizer{

	// attributes


	// constructor(s)
	public NumberValueNormalizer(NumberColumn normalizerTarget) {
		super("NUMBER_NORMALIZER", normalizerTarget);
	}

	// methods
	@Override
	public double normalize(Object value) {
		NumberColumn column = ((NumberColumn) this.normalizerTarget);
		return ((double) value - column.getMinimumValue()) / (column.getAmplitudeValueColumn());
	}

	@Override
	public Object denormalize(double value) {
		NumberColumn column = ((NumberColumn) this.normalizerTarget);
		return value + column.getMinimumValue() * column.getAmplitudeValueColumn();
	}

}