package model;

import java.util.ArrayList;
import java.util.List;

import intefarces.IColumn;
import intefarces.IPoint;

public class ColumnFactory {

    public static Column createColumn(DataSet dataSet, List<IColumn> columnsList, String type, String columnName) {
        List<IPoint> points = new ArrayList<>();

        if (type.equals("int") || type.equals("double")) {
            points.addAll(dataSet.getPointsList());
            return new NumberColumn(columnName, dataSet, points);
        } 
        if (type.equals("boolean")){
            points.addAll(dataSet.pointsList);
            return new BooleanColumn(columnName, dataSet, points);
        } else {
        	points.addAll(dataSet.pointsList);
        	return new EnumColumn(columnName, dataSet, points);
        }
    }
    
}
