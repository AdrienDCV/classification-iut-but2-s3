package main;

import java.util.ArrayList;
import java.util.List;

import intefarces.IColumn;
import intefarces.IPoint;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import model.Category;
import model.Column;
import model.Criteria;
import model.DataSet;


public class ScatterChartObject {
//	ScatterChart<Double, Double> scatterChart = new ScatterChart<Double, Double>(new NumberAxis(), new NumberAxis());
	ScatterChart<Number, Number> scatterChart = new ScatterChart<>(new NumberAxis(), new NumberAxis());
	Column xCol; 
	Column yCol;
	NumberAxis x = new NumberAxis(0, 1, 0.01);
	NumberAxis y = new NumberAxis(0, 1, 0.01);
	DataSet dataSet;

	
//	Column xCol, Column yCol
	public ScatterChartObject(Criteria criteria, DataSet dataset) {
		
		x.setLabel(criteria.getCriteriaX());
		y.setLabel(criteria.getCriteriaY());
		this.dataSet = dataset;
		for(Column c : this.dataSet.getColumnsList()) {
			if(c.getName().equals(criteria.getCriteriaX())) {
				xCol = (Column) c;
			} else if(c.getName().equals(criteria.getCriteriaY())) {
				yCol = (Column) c;
			}
		}
	}
	
	// voir pour rajouter les options "k, colonneCatégorieX, colonneCatégorieY 
	public void initScatter() {
		scatterChart = new ScatterChart(x, y);
		List<XYChart.Series<Number, Number>> listeCategory = new ArrayList<>();
		for(Category c : this.dataSet.getCategoriesList()) {
			listeCategory.add(new XYChart.Series<Number, Number>());
			listeCategory.get(listeCategory.size()-1).setName(c.getCategoryName());
		}
		
		for(int i = 0; i < listeCategory.size(); i ++) {
			List<XYChart.Data<Number, Number>>listData = listeCategory.get(i).getData();
			for(IPoint p : this.dataSet.getCategoriesList().get(i).getCategoryElements()) {
				listData.add(new XYChart.Data<Number,Number>(xCol.getNormalizedValue(p), yCol.getNormalizedValue(p)));
			}
			scatterChart.getData().add(listeCategory.get(i));
		}
	}

	public ScatterChart<Number, Number> getScatterChart() {
		return scatterChart;
	}

	
}