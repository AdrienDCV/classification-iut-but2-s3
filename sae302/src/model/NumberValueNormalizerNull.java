package model;

public class NumberValueNormalizerNull extends ValueNormalizer {

    public NumberValueNormalizerNull(String normalizerType) {
        super(normalizerType);
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
