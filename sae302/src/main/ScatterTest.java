package main;

import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;


public class ScatterTest {
	ScatterChart<Double, Double> scatterChart;

	
//	Column xCol, Column yCol
	
	
	// voir pour rajouter les options "k, colonneCatégorieX, colonneCatégorieY 
	public ScatterTest() {
		NumberAxis x = new NumberAxis();
		x.setLabel("Axe des X");
		NumberAxis y = new NumberAxis();
		y.setLabel("Axe des Y");
		
		
		scatterChart = new ScatterChart(x, y);
		XYChart.Series<Double, Double> series1 = new XYChart.Series<Double, Double>();
		XYChart.Series<Double, Double> series2 = new XYChart.Series<Double, Double>();
		series1.setName("x");
		series2.setName("y");
		for (int i=0; i < 10; i++) {
			 double xCurrentPoint = Math.random()*101 ;  
			 double yCurrentPoint = Math.random()*101 ; 
			 series1.getData().add(new XYChart.Data<Double,Double>(xCurrentPoint, yCurrentPoint));
		 }
		
		for (int i=0; i < 10; i++) {
			double xCurrentPoint = Math.random()*101 ;  
			 double yCurrentPoint = Math.random()*101 ; 
			 series2.getData().add(new XYChart.Data<Double,Double>(xCurrentPoint, yCurrentPoint));
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