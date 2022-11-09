package model;

import intefarces.IValueNormalizer;

public abstract class ValueNormalizer implements IValueNormalizer{

    protected NormalizerTypes normalizerType;
    protected Column normalizerTarget;

    public ValueNormalizer(String normalizerType, Column normalizerTarget) {
        this.normalizerType = NormalizerTypes.valueOf(normalizerType);
        this.normalizerTarget = normalizerTarget;
    } 

    public String getValueNormalizer() {
        return this.normalizerType.getLabel();
    }
    
}
