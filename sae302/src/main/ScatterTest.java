package main;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


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
        
	    Stage nodeInformation = new Stage();
	    nodeInformation.initStyle(StageStyle.UNDECORATED);
	    

	    for(XYChart.Data<Double,Double> data: series1.getData()) {
	    	data.getNode().hoverProperty().addListener((ChangeListener<Boolean>) (observable, oldValue, newValue) -> {
		        if (newValue) {
		        	Group group = new Group();
		        	Label label = new Label("X = " + data.getXValue() + "\nY = " + data.getYValue());
		    	    group.getChildren().add(label);
		    	    nodeInformation.setScene(new Scene(group));
		        	
		        	Bounds boundsInScene = data.getNode().localToScreen(data.getNode().getBoundsInLocal());
		        	nodeInformation.setX(boundsInScene.getCenterX() + 20);
		    	    nodeInformation.setY(boundsInScene.getCenterY() - 25);
		            nodeInformation.show();
		        } else {
		        	nodeInformation.hide();
		        }
		    });
	    }
        
        
	}

	public ScatterChart<Double, Double> getScatterChart() {
		return scatterChart;
	}

	public void setScatterChart(ScatterChart<Double, Double> scatterChart) {
		this.scatterChart = scatterChart;
	}
	
}