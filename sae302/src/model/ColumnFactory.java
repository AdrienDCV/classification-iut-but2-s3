package model;

import java.util.List;

import intefarces.IPoint;

public class ColumnFactory {

    public static Column createColumn(DataSet dataSet, List<IPoint> pointsList, String type, String columnName) {
    	if (type.equals("int") || type.equals("double")) {
        	return new NumberColumn(columnName, dataSet, pointsList);
        }if (type.equals("boolean")){
        	return new BooleanColumn(columnName, dataSet, pointsList);
        }
        if (type.equals("java.lang.String")) {
        }
        else {
        	return new EnumColumn(columnName, dataSet, pointsList);
        }
        
		return new ColumnNull();
    }
    
}
