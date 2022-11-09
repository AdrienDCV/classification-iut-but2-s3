package main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Scatter extends Application {
	//NumberAxis()
	//Create a auto-ranging NumberAxis
	
	//NumberAxis(double lowerBound, double upperBound, double tickUnit)
	//Create a non-auto-ranging NumberAxis with the given upper bound, lower bound and tick unit
	

	@Override
	public void start(Stage stage) throws Exception {
		NumberAxis x = new NumberAxis();
		x.setLabel("Axe des X");
		NumberAxis y = new NumberAxis();
		y.setLabel("Axe des Y");
		
		ScatterChart<String, Double> scatterChart = new ScatterChart(x,y);
		
		XYChart.Series series1 = new XYChart.Series();
		series1.setName("x");
		XYChart.Series series2 = new XYChart.Series();
		series2.setName("y");
		
		for(int i = 0; i < 10; i++) {
			double rand1 = (Math.random() * 101);
			double rand2 = (Math.random() * 101);
			series1.getData().add(new XYChart.Data<Double, Double>(rand1, rand2));
		}
		
		for(int i = 0; i < 10; i++) {
			int rand1 = (int)(Math.random() * 101);
			int rand2 = (int)(Math.random() * 101);
			series2.getData().add(rand1,rand2);
		}

	        scatterChart.getData().addAll(series1,series2);
	        
	        Group root = new Group();  
	        root.getChildren().add(scatterChart);  
	        Scene scene = new Scene(root, 600, 400);  
	        stage.setScene(scene);  
	        stage.setTitle("ScatterChart");  
	        stage.show(); 
	
	}
	
	public static void main(String[] args) {  
        launch(args);  
    }  
}
