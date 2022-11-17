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

    public static void main(String[] args) {
        List<IPoint> pointsList = new ArrayList<>();
        Titanic point3 = new Titanic(17,0,3,"Rice, Master. Eugene",Sex.M,2,4,1,"382652",29.125,"",Embarked.Q);
        Titanic point2 = new Titanic(2,1,1,"Cumings, Mrs. John Bradley (Florence Briggs Thayer)",Sex.F,38,1,0,"PC 17599",71.2833,"C85",Embarked.C);
        Titanic point1 = new Titanic( 1,0,3,"Braund, Mr. Owen Harris",Sex.M,22,1,0,"A/5 21171",7.25,"",Embarked.S);
        pointsList.add(point1); pointsList.add(point2); pointsList.add(point3);

        EnumColumn column = new EnumColumn("Embarked", null, pointsList);
        EnumValueNormalizer evn = new EnumValueNormalizer(column);
        for (int i=0; i < evn.elemsTypes.size(); i++) {
            System.out.println(evn.elemsTypes.get(i) + " associe la valeur normalisée ->" + column.getNormalizedValue(column.pointsList.get(i)) );
        }
        System.out.println("0 associe la valeur normalisée ->" + column.getDenormalizedValue(0.0));
        System.out.println("0.5 associe la valeur normalisée ->" + column.getDenormalizedValue(0.5));
        System.out.println("1 associe la valeur normalisée ->" + column.getDenormalizedValue(1));
    }

}
