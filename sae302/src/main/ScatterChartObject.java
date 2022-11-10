package main;

import java.util.List;

import intefarces.IColumn;
import javafx.scene.Group;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;

public class ScatterChartObject {
	ScatterChart<Double, Double> scatterChart;
	List<IColumn> firstList;
	List<IColumn> secondList;
	
	public ScatterChartObject(List<IColumn> firstList, List<IColumn> secondList) {
		NumberAxis x = new NumberAxis();
		x.setLabel("Axe des X");
		NumberAxis y = new NumberAxis();
		y.setLabel("Axe des Y");
		
		scatterChart = new ScatterChart(x, y);
		XYChart.Series<Double, Double> series1 = new XYChart.Series<Double, Double>();
		XYChart.Series<Double, Double> series2 = new XYChart.Series<Double, Double>();
		series1.setName("x");
		series2.setName("y");
		for(int i = 0; i < firstList.size(); i++) {
			series2.getData().add(new XYChart.Data<Double, Double>(secondList.get(i).getX(), secondList.get(i).getY());
		}
		for(int i = 0; i < secondList.size(); i++) {
			series2.getData().add(new XYChart.Data<Double, Double>(secondList.get(i).getX(), secondList.get(i).getY());
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
