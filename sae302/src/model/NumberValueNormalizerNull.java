package model;

import intefarces.IValueNormalizer;

public class NumberValueNormalizerNull implements IValueNormalizer{

    @Override
    public double normalize(Object value) {
        return 0;
    }

    @Override
    public Object denormalize(double value) {
        return 0;
    }

}
