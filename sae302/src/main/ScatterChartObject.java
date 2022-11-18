package main;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import intefarces.IPoint;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.image.WritableImage;
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
	
//	public void saveScatterChart() {
//		String path;
//		if(new File(System.getProperty("user.home") + "/Bureau").exists()) {
//			path = System.getProperty("user.home") + "/Bureau/image.png";
//		} else {
//			path = System.getProperty("user.home") + "/Desktop/image.png";
//		}
//		File file = new File(path);
//		WritableImage image = this.scatterChart.snapshot(new SnapshotParameters(), null);
//		try {
//		  ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
//		} catch (IOException e) {
//			System.err.println(e.getMessage());
//			e.getStackTrace();
//		}
//		
//	}
	
}