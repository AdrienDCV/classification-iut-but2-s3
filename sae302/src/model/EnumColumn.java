package model;

import java.util.List;

import intefarces.IMVCModel;
import intefarces.IPoint;

public class EnumColumn extends Column{

    public EnumColumn(String name, IMVCModel dataSet, List<IPoint> pointsList) {
        super(name, dataSet, pointsList);
        this.setNormalizer(new EnumValueNormalizer(this));
    }

}
