package model;

public class BooleanValueNormalizer extends ValueNormalizer {

    public BooleanValueNormalizer(BooleanColumn normalizerTarget) {
        super("BOOLEAN_NORMALIZER", normalizerTarget);
    }

    @Override
    public double normalize(Object value) {
       if ((Boolean) value == true) return 1;
       return 0;
    }

    @Override
    public Object denormalize(double value) {
        if (value == 1) return true;
        return false;
    }
    
}
