package model;

import java.util.ArrayList;
import java.util.List;

public class EnumValueNormalizer extends ValueNormalizer{

    private Class<Enum> enumType;
    private List<Object> elemsTypes;

    public EnumValueNormalizer(Column normalizerTarget) {
        super("ENUM_NORMALIZER", normalizerTarget);
        this.getEnumType();
        this.fillElemsTypes();
    }

    @Override
    public double normalize(Object value) {
        return (double) this.elemsTypes.indexOf(value) / (double) (this.elemsTypes.size()-1);
    }

    @Override
    public Object denormalize(double value) {
    	if (value == 0) return this.elemsTypes.get(0);
        return this.elemsTypes.get((int) value * this.elemsTypes.size() / this.elemsTypes.size()+1);
    }

    public Object getNormalizerTarget() { // méthodes uniquement utilisée pour des tests
        return this.normalizerTarget;
    }
    public void fillElemsTypes() {
    	this.elemsTypes = new ArrayList<>();
    	System.out.println(elemsTypes);
    	 for (int i=0; i < this.enumType.getEnumConstants().length; i++) {
         	elemsTypes.add(this.enumType.getEnumConstants()[i]);
         }
    	
    }
    
    public void getEnumType() {
    	this.enumType = (Class<Enum>) this.normalizerTarget.getPointsList().get(0).getValue(this.normalizerTarget).getClass();
    }
}


