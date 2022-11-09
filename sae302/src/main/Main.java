package main;

import javafx.application.*;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{
    Button confirmer=new Button("confirmer");
    Button parcourir=new Button("parcourir");
    Button sauvegarde=new Button("sauvegarder");
    ComboBox premiere_var=new ComboBox();
    ComboBox deuxieme_var=new ComboBox();
    TextField entrer_k=new TextField();
    FileChooser fichier_csv=new FileChooser();
    
    
    
    public void start(Stage stage) throws Exception {
    	
    	VBox vbox=new Vbox();
    	vbox.getChildren().addAll(confirmer,parcourir,sauvegarder,premiere_var,deuxieme_var,champs_k);
    	Scene scene=new Scene(vbox,900,900);
    	stage.setTitle("test");
    	stage.setScene(scene);
    	stage.show();
    	
    }
    
    public static void main(String[] args) {
		launch(args);
	}

}
