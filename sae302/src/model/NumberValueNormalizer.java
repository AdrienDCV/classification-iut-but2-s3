package model;

import intefarces.IValueNormalizer;

public class NumberValueNormalizer implements IValueNormalizer{

	// class attributes
	private NormalizerTypes normalizerType;

	// constructor(s)
	public NumberValueNormalizer(String normalizerType) {
		this.normalizerType = NormalizerTypes.valueOf(normalizerType);
	}

	// methods
    public Object getValueNormalizer() {
        return this.normalizerType.getLabel();
    }

	@Override
	public double normalize(Object value) {
		return 0;
	}


	@Override
	public Object denormalize(double value) {
		return null;
	}

}
