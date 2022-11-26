package model;

public class ValueNormalizerNull extends ValueNormalizer{

    public ValueNormalizerNull(Column normalizerTarget) {
        super("NULL", normalizerTarget);
    }

    @Override
    public double normalize(Object value) {
        return 0;
    }

    @Override
    public Object denormalize(double value) {
        return "";
    }

}
