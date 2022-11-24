package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import intefarces.IColumn;
import intefarces.IPoint;

public class Classification {
	
	List<IColumn> column;
	DataSet dataset;
	Criteria criteria;
	IColumn colX;
	IColumn colY;
	DistanceStrategy distance;
	
	public Classification(List<IColumn> column, Criteria criteria, String distanceStrategyName) {
		this.column = column;
		this.criteria = criteria;
		this.setDistanceStrategy(distanceStrategyName);
		for(int i = 0; i < this.column.size(); i ++) {
			if(this.column.get(i).getName().equals(this.criteria.getCriteriaX())) {
				this.colX = this.column.get(i);
			} else if(this.column.get(i).getName().equals(this.criteria.getCriteriaY())) {
				this.colY = this.column.get(i);
			}
		}
		this.dataset = this.colX.getDataset();
	}
	private void setDistanceStrategy(String distanceStrategyName) {
		this.distance = DistanceStrategyFactory.createDistanceStrategy(distanceStrategyName);
	}

	
	public List<IPoint> knnCalcul(int k, IPoint p, List<IPoint> pointList) {
		List <IPoint> listeProcheVoisin = new ArrayList<IPoint>();
		double[] distance = new double[pointList.size()];
		for(int i = 0; i < pointList.size(); i ++) {
			distance[i] = this.distance.calculDistance(p, pointList.get(i), this.colX, this.colY);
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
	
	public Category classifyPoint(int k, IPoint point, List<IPoint> pointList) {
		//Knn par rapport au point
		
		List<IPoint> knn = this.knnCalcul(k, point, this.dataset.getPointsList());
		//Ajout du nom de la catégory de chaque point du knn
		List<String> listeColumnName = new ArrayList<>();
		for(Category c : this.dataset.getCategoriesList()) {
			for(IPoint p : knn) {
				if(c.getCategoryElements().contains(p)) {
					listeColumnName.add(c.getCategoryName());
				}
			}
		}
		//Map du nom de la colonne et le nombre d'élement
		Map<String, Integer> numberColumnName = new HashMap<>();
		for(int i = 0; i < listeColumnName.size(); i++) {
			if(numberColumnName.containsKey(listeColumnName.get(i))) {
				numberColumnName.replace(listeColumnName.get(i), numberColumnName.get(listeColumnName.get(i)) + 1);
			} else {
				numberColumnName.put(listeColumnName.get(i), 1);
			}
		}
		//on prend le max de la map ou le plus proche voisin si deux category ont la même taille
		int max = -1;
		Category category = null;
		
		for(String clé: numberColumnName.keySet()) {
			if(numberColumnName.get(clé) > max) {
				max = numberColumnName.get(clé);
				for(Category c : this.dataset.getCategoriesList()) {
					if(clé.equals(c.getCategoryName())) {
						category = c;
					}
				}
			} else if(numberColumnName.get(clé) == max) {
				max = Integer.MAX_VALUE;
			}
		}
		
		if(Integer.MAX_VALUE == max) {
			for(Category c : this.dataset.getCategoriesList()) {
				if(c.getCategoryElements().contains(knn.get(0))) {
					category = c;
				}
			}
			
		}
		category.addToCategory(point);
		return category;
	}
	public double calculRobustness(int k, IPoint point, Category pointCategory) {
		double res = 0;
		double nombreElemParPaquet = this.dataset.getPointsList().size() / 10;
		List<Category> numberCategory = new ArrayList<>();
		

		List<List<IPoint>> listPaquet = new ArrayList<>();
		
		List<Category> listeCategoryPossiblePoint = new ArrayList<>();
		
		//init paquet de données
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
		

		//création d'une copie des catégories du dataset

		List<Category> listCategory = new ArrayList<>();
		listCategory.addAll(dataset.getCategoriesList());
		
		
		for(int z = 0; z < listPaquet.size(); z ++) {
			for(int i = 0; i < listCategory.size(); i ++) {
				//clear les category à chaque itération
				listCategory.get(i).getCategoryElements().clear();
			}
			
			//prend les plus proches voisins du point dans chaque paquet
			List<IPoint> knn = this.knnCalcul(k, point, listPaquet.get(z));
			for(int i = 0; i < knn.size(); i ++) {
	
//on met chaque point du knn dans leur bonne catégorie
				for(Category c : listCategory) {

					c.addToCategory(knn.get(i));
				}
				
			}
			
			int max = -1;

			Category category = null;
//on cherche la category contenant le plus d'élément (= classification par les voisins)
			for(Category c : listCategory) {

				if(max < c.getCategoryElements().size()) {
					max = c.getCategoryElements().size();
					category = c;
					
				//cas où deux catégory ont la même taille -> renvoie catégory du plus proche voisin
				} else if (max == c.getCategoryElements().size()) {
					max = Integer.MAX_VALUE;
				}
			}
			if(max == Integer.MAX_VALUE) {
				for(Category c2 : listCategory) {
					if(c2.getCategoryElements().contains(knn.get(0))) {
						category = c2;
					}
				}
			}
			
			listeCategoryPossiblePoint.add(category);
		}


		int sameCategory = 0;
		for(Category c : listeCategoryPossiblePoint) {
			//si la catégory est la même que celle du point on incrémente le compteur de category
			if (c.getCategoryName().equals(pointCategory.getCategoryName())) {
				sameCategory += 1;
			}
		}		
		return (double) sameCategory/(double)listeCategoryPossiblePoint.size();
	}

}