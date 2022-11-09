package model;


public class EnumValueNormalizer extends ValueNormalizer{

    public EnumValueNormalizer() {
        super("ENUM_NORMALIZER");
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
