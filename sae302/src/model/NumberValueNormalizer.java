package model;


public class NumberValueNormalizer extends ValueNormalizer{

	public NumberValueNormalizer() {
		super("NUMBER_NORMALIZER");
	}

	@Override
	public double normalize(Object value) {
		return 0;
	}

	@Override
	public Object denormalize(double value) {
		return null;
	}

    public String hello() {
		return "Hello";
	}

}