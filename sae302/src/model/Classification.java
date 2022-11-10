package model;

import java.util.List;

import intefarces.IColumn;
import intefarces.IPoint;

public class Classification {
	
	List<Column> column;
	List<Criteria> criteria;
	
	
	public Classification(List<Column> column, List<Criteria> criteria) {
		this.column = column;
		this.criteria = criteria;
	}

	public double euclidianDistance(double d1,double d2) {
		return Math.sqrt(Math.pow(d1-d2, 2));
	}
	
	public double manhatanDistance(double d1,double d2) {
		return Math.abs(d1-d2);
	}
	
	public List<IPoint> knnCalcul(int k, IPoint p) {
		
		/*for(int i = 0; i < this.column.size(); i ++) {
			List<IPoint> listePoint = this.column.get(i).getDataset().getPointsList();
			for(int j = 0; j < listePoint.size(); j ++) {
				this.column.get(i).getName();
			}
		}*/
		
		
		return null;
	}
}
