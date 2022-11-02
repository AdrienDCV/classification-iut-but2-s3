package model;

public class BooleanValueNormalizer extends ValueNormalizer {

    public BooleanValueNormalizer() {
        super("BOOLEAN_NORMALIZER");
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
