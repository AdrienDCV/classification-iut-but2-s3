package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class View extends Application{
	Button confirmer=new Button("confirmer");
    Button parcourir=new Button("parcourir");
    Button sauvegarde=new Button("sauvegarder");
    ComboBox premiere_var=new ComboBox();
    ComboBox deuxieme_var=new ComboBox();
    TextField entrer_k=new TextField();
    FileChooser fichier_csv=new FileChooser();
    
    
    
    public void start(Stage stage) throws Exception {
    	
    	VBox vbox=new VBox();
    	vbox.getChildren().addAll(confirmer,parcourir,sauvegarde,premiere_var,deuxieme_var,entrer_k);
    	Scene scene=new Scene(vbox,900,900);
    	stage.setTitle("test");
    	stage.setScene(scene);
    	stage.show();
    	
    }
    
    public static void main(String[] args) {
		launch(args);
	}


}
