package model;


import intefarces.IColumn;


public class NumberValueNormalizer extends ValueNormalizer{

	// attributes
	/* no attributes */

	// constructor(s)
	public NumberValueNormalizer(Column normalizerTarget) {
		super("NUMBER_NORMALIZER", normalizerTarget);
	}

	// methods
	@Override
	public double normalize(Object value) {
		NumberColumn column = ((NumberColumn) this.normalizerTarget);
		column.setAmplitudeValueClomun();
		System.out.println("max =" + column.getMaximumValue());
		System.out.println("min =" + column.getMinimumValue());
		System.out.println("amplitude =" + column.getAmplitudeValueColumn());
		System.out.println((Double.parseDouble(value.toString()) - column.getMinimumValue()) / (column.getAmplitudeValueColumn()));
		return (Double.parseDouble(value.toString()) - column.getMinimumValue()) / (column.getAmplitudeValueColumn());
	}

	@Override
	public Object denormalize(double value) {
		NumberColumn column = ((NumberColumn) this.normalizerTarget);
		return value + column.getMinimumValue() * column.getAmplitudeValueColumn();
	}

}