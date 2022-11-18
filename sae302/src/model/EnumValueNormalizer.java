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
        return (double) this.elemsTypes.indexOf(value) / (double) (this.elemsTypes.size()-1);
    }

    @Override
    public Object denormalize(double value) {
        if (value == 0) return this.elemsTypes.get(0);
        return this.elemsTypes.get((int) (value * this.elemsTypes.size()) / this.elemsTypes.size()+1);
    }

    public void fillElemsTypes() {
        EnumColumn column = (EnumColumn) this.normalizerTarget;
        for (IPoint point : column.pointsList) {
            String elemTypes = point.getValue(column).toString();
            if (!this.elemsTypes.contains(elemTypes) && elemTypes != null) {
                this.elemsTypes.add(elemTypes);
            }
        }
        System.out.println(this.elemsTypes);
    }

    public Object getNormalizerTarget() { // méthodes uniquement utilisée pour des tests
        return this.normalizerTarget;
    }

}