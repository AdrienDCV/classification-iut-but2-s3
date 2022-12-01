package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import intefarces.IPoint;

public class Classification {
	
	protected List<Column> column;
	protected DataSet dataset;
	protected Criteria criteria;
	protected Column colX;
	protected Column colY;
	protected DistanceStrategy distance;
	
	public Classification(List<Column> column, Criteria criteria, String distanceStrategyName) {
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

		getKNN(k, pointList, listeProcheVoisin, distance);
		
		return listeProcheVoisin;
	}

	public void getKNN(int k, List<IPoint> pointList, List<IPoint> listeProcheVoisin, double[] distance) {
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
		
		for(String cle: numberColumnName.keySet()) {
			if(numberColumnName.get(cle) > max) {
				max = numberColumnName.get(cle);
				for(Category c : this.dataset.getCategoriesList()) {
					if(cle.equals(c.getCategoryName())) {
						category = c;
					}
				}
			} else if(numberColumnName.get(cle) == max) {
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
		return category;
	}

	
	public double calculRobustness(int k, IPoint point, Category pointCategory) {
		double nombreElemParPaquet = this.dataset.getPointsList().size() / 10;
		List<List<IPoint>> listPaquet = new ArrayList<>();
		List<Category> listeCategoryPossiblePoint = new ArrayList<>();
		
		//init paquet de données
		initDataPackages(nombreElemParPaquet, listPaquet);
	
		//création d'une copie des catégories du dataset
		List<List<IPoint>> listPokemonCategory = initListPokemonCategory(dataset.getCategoriesList());
		
		for(List<IPoint> paquet : listPaquet) {
			clearCategories(listPokemonCategory);
			
			//prend les plus proches voisins du point dans chaque paquet
			List<IPoint> knn = this.knnCalcul(k, point, paquet);
	
			addPointsToRightCategory(dataset.getCategoriesList(), knn, listPokemonCategory);
			
			Category category = null;
			//on cherche la category contenant le plus d'élément (= classification par les voisins)
			category = getMaxElemsCategory(listPokemonCategory, knn, category);
			listeCategoryPossiblePoint.add(category);
		}
		
		int sameCategory = getNbrElemSameCategory(pointCategory, listeCategoryPossiblePoint);		
		return (double) sameCategory/(double)listeCategoryPossiblePoint.size();
	}

	public void clearCategories(List<List<IPoint>> listCategory) {
		for(List<IPoint> list :  listCategory) {
			list.clear();
		}
	}
	
	public List<List<IPoint>> initListPokemonCategory(List<Category> list) {
		List<List<IPoint>> listPokemonCategory = new ArrayList<>();
		for(Category category : list) {
			if(!category.getCategoryName().equals("Undefined")) {
				List<IPoint> listPokemon = new ArrayList<>(category.getCategoryElements());
				listPokemonCategory.add(listPokemon);
			}
		}
		return listPokemonCategory;
	}

	public void addPointsToRightCategory(List<Category> listCategory, List<IPoint> knn, List<List<IPoint>> list) {
		for(int i = 0; i < knn.size(); i ++) {
			//on met chaque point du knn dans leur bonne catégorie
			for(int j = 0; j < listCategory.size(); j++) {
				if(!listCategory.get(j).getCategoryName().equals("Undefined")) {
					list.get(j).add(knn.get(i));
				}
			}	
		}
	}

	public int getNbrElemSameCategory(Category pointCategory, List<Category> listeCategoryPossiblePoint) {
		int sameCategory = 0;
		for(Category c : listeCategoryPossiblePoint) {
			//si la catégory est la même que celle du point on incrémente le compteur de category
			if (c.getCategoryName().equals(pointCategory.getCategoryName())) {
				sameCategory += 1;
			}
		}
		return sameCategory;
	}
	
	public Category getMaxElemsCategory(List<List<IPoint>> listeIPoint, List<IPoint> knn, Category category) {
		int max = -1;
		for(int i = 0; i < listeIPoint.size(); i ++) {

			if(max < listeIPoint.get(i).size()) {
				max = listeIPoint.get(i).size();
				category = this.dataset.getCategoriesList().get(i);
				
			//cas où deux category ont la même taille -> renvoie catégory du plus proche voisin
			} else if (max == listeIPoint.get(i).size()) {
				max = Integer.MAX_VALUE;
			}
		}
		if(max == Integer.MAX_VALUE) {
			for(int j = 0; j < listeIPoint.size(); j ++) {
				if(listeIPoint.get(j).contains(knn.get(0))) {
					category = this.dataset.getCategoriesList().get(j);
				}
			}
		}
		return category;
	}

	public void initDataPackages(double nombreElemParPaquet, List<List<IPoint>> listPaquet) {
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
	}

}