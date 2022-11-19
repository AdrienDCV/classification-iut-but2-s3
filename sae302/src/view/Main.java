package view;

import java.io.IOException;
import java.util.List;

import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {

	public static void main (String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		new View();
	}
	
}


