package main;

import java.util.ArrayList;
import java.util.List;

import intefarces.IPoint;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;

public class ScatterChartObject {
	NumberAxis x;
	NumberAxis y;
	ScatterChart<Double, Double> scatterChart;
	XYChart.Series<Double, Double> series1;
	XYChart.Series<Double, Double> series2;
	List<IPoint> firstList;
	List<IPoint> secondList;
	
	public ScatterChartObject(List<IPoint> firstList, List<IPoint> secondList) {
		x = new NumberAxis();
		y = new NumberAxis();
		scatterChart = new ScatterChart(x, y);
		series1 = new XYChart.Series<Double, Double>();
		series2 = new XYChart.Series<Double, Double>();
		series1.setName("x");
		series2.setName("y");
		this.firstList.addAll(firstList);
		this.secondList.addAll(secondList);
	}
	
//	
//	for(int i = 0; i < 10; i++) {
//		double rand1 = (Math.random() * 101);
//		double rand2 = (Math.random() * 101);
//		series1.getData().add(new XYChart.Data<Double, Double>(rand1, rand2));
//	}
//	
//	for(int i = 0; i < 10; i++) {
//		double rand1 = (Math.random() * 101);
//		double rand2 = (Math.random() * 101);
//		series2.getData().add(new XYChart.Data<Double, Double>(rand1, rand2));
//	}
}
