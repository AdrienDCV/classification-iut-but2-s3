package model;

import java.util.ArrayList;
import java.util.List;

import intefarces.ICategory;
import intefarces.IColumn;
import intefarces.IPoint;

public class Classification {
	
	List<IColumn> column;
	DataSet dataset;
	Criteria criteria;
	IColumn colX;
	IColumn colY;
	
	
	public Classification(List<IColumn> column, Criteria criteria) {
		this.column = column;
		this.criteria = criteria;
		for(int i = 0; i < this.column.size(); i ++) {
			if(this.column.get(i).getName().equals(this.criteria.getCriteriaX())) {
				this.colX = this.column.get(i);
			} else if(this.column.get(i).getName().equals(this.criteria.getCriteriaY())) {
				this.colY = this.column.get(i);
			}
		}
		this.dataset = this.colX.getDataset();
	}

	public double euclidianDistance(IPoint p1,IPoint p2) {
		return Math.sqrt(Math.pow((double) colX.getNormalizedValue(p1) - (double) colX.getNormalizedValue(p2), 2) + 
						 Math.pow((double) colY.getNormalizedValue(p1) - (double) colX.getNormalizedValue(p2), 2));
		
	}
	
	public double manhatanDistance(IPoint p1,IPoint p2) {
		return Math.abs((double) colX.getNormalizedValue(p1) - (double) colX.getNormalizedValue(p2)) + 
			   Math.abs((double) colY.getNormalizedValue(p1) - (double) colY.getNormalizedValue(p2));
	}
	
	public List<IPoint> knnCalcul(int k, IPoint p, List<IPoint> pointList) {
		
		/*
		 * ATTENTION IL FAUT TROUVER UN MOYEN POUR POUVOIR CHOISIR LA DISTANCE
		 *
		 */
		List <IPoint> listeProcheVoisin = new ArrayList<IPoint>();
		double[] distance = new double[pointList.size()];
		for(int i = 0; i < pointList.size(); i ++) {
			distance[i] = this.euclidianDistance(p, pointList.get(i));
		}
		
		for(int j = 0; j < k; j ++) {
			int min = 0;
			for(int idx = 0; idx < distance.length; idx ++) {
				if(distance[min] > distance[idx] && distance[idx] > 0) {
					min = idx;
				}
			}
			distance[min] = -1;
			listeProcheVoisin.add(pointList.get(min));
		}
		
		return listeProcheVoisin;
	}
	
	public List<ICategory> toClassify() {
		for(int i = 0; i < this.dataset.getCategoriesList().size(); i++) {
			this.dataset.getCategoriesList().get(i).addToCategory(this.dataset);
		}
		return this.dataset.getCategoriesList();
	}
	
	public double calculRobustness(int k, IPoint point, ICategory pointCategory) {
		double res = 0;
		double nombreElemParPaquet = this.dataset.getPointsList().size() / 10;
		List<ICategory> numberCategory = new ArrayList<>();
		
		List<List<IPoint>> listPaquet = new ArrayList<>();
		List<IPoint> paquet = new ArrayList<IPoint>();
		for(int i = 0; i < this.dataset.getPointsList().size(); i++) {
			if(paquet.size() != nombreElemParPaquet) {
				paquet.add(this.dataset.getPointsList().get(i));
			} else {
				listPaquet.add(paquet);
				paquet = new ArrayList<IPoint>();
				paquet.add(this.dataset.getPointsList().get(i));
			}
		}
		
		List<ICategory> listCategory = new ArrayList<>();
		listCategory.addAll(dataset.getCategoriesList());
		
		for(int z = 0; z < listPaquet.size(); z ++) {
			for(int i = 0; i < listCategory.size(); i ++) {
				listCategory.get(i).getCategoryElements().clear();
			}
			List<IPoint> knn = this.knnCalcul(k, point, listPaquet.get(z));
			
			for(int i = 0; i < knn.size(); i ++) {
				for(ICategory c : listCategory) {
					c.addToCategory(knn.get(i));
				}
			}
			
			int max = -1;
			ICategory category = null;
			for(ICategory c : listCategory) {
				if(max < c.getCategoryElements().size()) {
					max = c.getCategoryElements().size();
					category = c;
				}
			}
			/*cas où deux catégories ont le même nombre de point
			 * alors on prend la catégory du point le plus proche (knn.get(0))
			 * if (max > 1) {
				
			}*/
			numberCategory.add(category);
		}

		int nbr = 0;
		for(ICategory c : numberCategory) {

			if (c.getCategoryName().equals(pointCategory.getCategoryName())) {
				nbr += 1;
			}
		}
		System.out.println(nbr);
		System.out.println(numberCategory.size());
				
		return (double) nbr/(double)numberCategory.size();
	}

}