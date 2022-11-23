package model;

public class ValueNormalizerNull extends ValueNormalizer{

    public ValueNormalizerNull() {
        super("", new ColumnNull());
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
