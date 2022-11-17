package model;

import java.util.ArrayList;
import java.util.List;

import intefarces.IPoint;
import titanic.Embarked;
import titanic.Sex;
import titanic.Titanic;

public class EnumValueNormalizer extends ValueNormalizer{

    private List<String> elemsTypes;

    public EnumValueNormalizer(EnumColumn normalizerTarget) {
        super("ENUM_NORMALIZER", normalizerTarget);
        this.elemsTypes  = new ArrayList<>();
        this.fillElemsTypes();
    }

    @Override
    public double normalize(Object value) {
        return this.elemsTypes.indexOf(value) % this.elemsTypes.size();
    }

    @Override
    public Object denormalize(double value) {
        return value * this.elemsTypes.size();
    }

    public void fillElemsTypes() {
        EnumColumn column = (EnumColumn) this.normalizerTarget;
        for (IPoint point : column.pointsList) {
            String elemTypes = point.getValue(column).toString();
            if (!this.elemsTypes.contains(elemTypes) && elemTypes != null) {
                this.elemsTypes.add(elemTypes);
            }
        }
    }

    public Object getNormalizerTarget() { // méthodes uniquement utilisée pour des tests
        return this.normalizerTarget;
    }

}
