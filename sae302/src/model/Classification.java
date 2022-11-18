package model;

import java.util.ArrayList;
import java.util.List;

import intefarces.IColumn;
import intefarces.IPoint;

public class Classification {
	
	List<Column> column;
	Criteria criteria;
	Column colX;
	Column colY;
	
	
	public Classification(List<Column> column, Criteria criteria) {
		this.column = column;
		this.criteria = criteria;
		for(int i = 0; i < this.column.size(); i ++) {
			if(this.column.get(i).getName().equals(this.criteria.getCriteriaX())) {
				this.colX = this.column.get(i);
			} else if(this.column.get(i).getName().equals(this.criteria.getCriteriaY())) {
				this.colY = this.column.get(i);
			}
		}
	}

	public double euclidianDistance(IPoint p1,IPoint p2) {
		return Math.sqrt(Math.pow((double) colX.getNormalizedValue(p1) - (double) colX.getNormalizedValue(p2), 2) + 
						 Math.pow((double) colY.getNormalizedValue(p1) - (double) colX.getNormalizedValue(p2), 2));
		
	}
	
	public double manhatanDistance(IPoint p1,IPoint p2) {
		return Math.abs((double) colX.getNormalizedValue(p1) - (double) colX.getNormalizedValue(p2)) + 
			   Math.abs((double) colY.getNormalizedValue(p1) - (double) colY.getNormalizedValue(p2));
	}
	
	public List<IPoint> knnCalcul(int k, IPoint p) {
		
		/*
		 * ATTENTION IL FAUT TROUVER UN MOYEN POUR POUVOIR CHOISIR LA DISTANCE
		 *
		 */
		List <IPoint> listeProcheVoisin = new ArrayList<IPoint>();
		double[] distance = new double[colX.getPointsList().size()];
		for(int i = 0; i < colX.getPointsList().size(); i ++) {
			distance[i] = this.euclidianDistance(p, colX.getPointsList().get(i));
		}
		
		for(int j = 0; j < k; j ++) {
			int min = 0;
			for(int idx = 0; idx < distance.length; idx ++) {
				if(distance[min] > distance[idx] && distance[idx] > 0) {
					min = idx;
				}
			}
			distance[min] = -1;
			listeProcheVoisin.add(colX.getPointsList().get(min));
		}
		
		return listeProcheVoisin;
	}

}