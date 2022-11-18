package main;

import intefarces.IPoint;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import model.Column;


public class ScatterChartObject {
	ScatterChart<Double, Double> scatterChart;
	Column xCol; 
	Column yCol;

	
//	Column xCol, Column yCol
	
	
	// voir pour rajouter les options "k, colonneCatégorieX, colonneCatégorieY 
	public ScatterChartObject() {
		NumberAxis x = new NumberAxis();
		x.setLabel("Axe des X");
		NumberAxis y = new NumberAxis();
		y.setLabel("Axe des Y");
		
		
		scatterChart = new ScatterChart(x, y);
		XYChart.Series<Double, Double> series1 = new XYChart.Series<Double, Double>();
		XYChart.Series<Double, Double> series2 = new XYChart.Series<Double, Double>();
		series1.setName("x");
		series2.setName("y");
		for (int i=0; i < this.xCol.getPointsList().size(); i++) {
			 IPoint xCurrentPoint = xCol.getPointsList().get(i);
			 IPoint yCurrentPoint = yCol.getPointsList().get(i);
			 series1.getData().add(new XYChart.Data<Double,Double>(xCol.getNormalizedValue(xCurrentPoint), yCol.getNormalizedValue(yCurrentPoint)));
		 }
		
		for (int i=0; i < this.xCol.getPointsList().size(); i++) {
			 IPoint xCurrentPoint = xCol.getPointsList().get(i);
			 IPoint yCurrentPoint = yCol.getPointsList().get(i);
			 series2.getData().add(new XYChart.Data<Double,Double>(xCol.getNormalizedValue(xCurrentPoint), yCol.getNormalizedValue(yCurrentPoint)));
		 }
		
		scatterChart.getData().add(series1);
        scatterChart.getData().add(series2);
	}

	public ScatterChart<Double, Double> getScatterChart() {
		return scatterChart;
	}

	public void setScatterChart(ScatterChart<Double, Double> scatterChart) {
		this.scatterChart = scatterChart;
	}
	
}