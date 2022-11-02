package model;

public class StringValueNormalizer extends ValueNormalizer{

    public StringValueNormalizer() {
        super("STRING_NORMALIZER");
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
