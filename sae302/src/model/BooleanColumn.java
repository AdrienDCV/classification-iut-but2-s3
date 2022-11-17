package model;

import java.util.List;

import intefarces.IMVCModel;
import intefarces.IPoint;

public class BooleanColumn extends Column {

    public BooleanColumn(String name, IMVCModel dataSet, List<IPoint> pointsList) {
        super(name, dataSet, pointsList);
        this.setNormalizer(new BooleanValueNormalizer(this));
    }
    
}
