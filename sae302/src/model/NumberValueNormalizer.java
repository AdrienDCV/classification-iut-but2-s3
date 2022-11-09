package model;

import intefarces.IColumn;

public class NumberValueNormalizer extends ValueNormalizer{

	// attributes
	private NumberColumn normalizerTarget;

	// constructor(s)
	public NumberValueNormalizer(NumberColumn normalizerTarget) {
		super("NUMBER_NORMALIZER");
		this.normalizerTarget = normalizerTarget;
	}

	// methods
	@Override
	public double normalize(Object value) {
		return ((double) value - normalizerTarget.getMinimumValue()) / (normalizerTarget.getAmplitudeValueColumn());
	}

	@Override
	public Object denormalize(double value) {
		return value + normalizerTarget.getMinimumValue() * normalizerTarget.getAmplitudeValueColumn();
	}

}