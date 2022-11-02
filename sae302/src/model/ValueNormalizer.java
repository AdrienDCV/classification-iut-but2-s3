package model;

import intefarces.IValueNormalizer;

public abstract class ValueNormalizer implements IValueNormalizer{

    protected NormalizerTypes normalizerType;

    public ValueNormalizer(String normalizerType) {
        this.normalizerType = NormalizerTypes.valueOf(normalizerType);
    } 

    public String getValueNormalizer() {
        return this.normalizerType.getLabel();
    }
    
}
