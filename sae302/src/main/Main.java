package main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static void main(String[] args) {  
        launch(args);
    }
    
	public void start(Stage stage) throws Exception {
    	VBox vboxLeft = new VBox();
    	VBox vboxRight = new VBox();
    	Button button = new Button("Charger Donnée");
    	//ScatterChartObject sc = new ScatterChartObject();
    	vboxLeft.getChildren().add(button);
    	
    	Group root = new Group();
        root.getChildren().addAll(vboxLeft,vboxRight);  
        Scene scene = new Scene(root, 600, 400);  
        stage.setScene(scene);  
        stage.setTitle("ScatterChart");  
        stage.show();
    	
        System.out.println("tout va bien !");
    }

}
