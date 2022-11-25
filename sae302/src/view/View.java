package view;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import intefarces.IColumn;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import main.MenuBarClass;
import main.ScatterChartObject;
import model.Classification;
import model.Criteria;
import model.DataSet;
import model.DataSetFactory;
import model.DistanceEuclidienne;
import model.DistanceManhattan;
import model.DistanceStrategy;
import utils.Observer;
import utils.Subject;

public class View extends Stage implements Observer{
	
	// class attributes
	static Button confirmer, parcourir, ajouter;
    static ComboBox<String> criteriaX, criteriaY, typeDataSet, typeDistance;
    //TextField entrerK=new TextField();

    static FileChooser fichierCsv;
	static HBox hboxVariables;
	static Canvas canvas;//changer en scaterChart
	static DataSet dataSet;
	static DistanceStrategy distance;
	static ScatterChartObject scatterChart;
	//static VBox verticalPosition;
	static HBox hbox;
	
	public View() {
		initWidget();
		
		hbox=new HBox();
    	hbox.getChildren().addAll(this.vBox(), canvas);
    	
    	MenuBarClass menuBarClass = new MenuBarClass();
    	VBox verticalPosition = new VBox();
        verticalPosition.getChildren().addAll(menuBarClass.getMenuBar(), hbox);

    	
    	dataSetComboBox();
    	distanceComboBox();
    	
//    	menuBarClass.loadFile();
    	menuBarClass.exitApplication();
    	menuBarClass.saveScatterChart(this.scatterChart);
    	
    	Scene scene=new Scene(verticalPosition,1000,500);
    	this.setTitle("test");
    	this.setScene(scene);
    	this.show();

	}

	private static void initWidget() {
		initButton();
	    //Button sauvegarde=new Button("sauvegarder");
	    initComboBox();
	    //TextField entrerK=new TextField();
	    fichierCsv=new FileChooser();
		hboxVariables=new HBox();
		canvas=new Canvas();//changer en scaterChart
//		dataSet = new PokemonDataSet("Ratio");
	}

	private static void initComboBox() {
		criteriaX=new ComboBox<>();
	    criteriaY=new ComboBox<>();
	    typeDataSet = new ComboBox<>();
	    typeDistance = new ComboBox<>();
	}

	private static void initButton() {
		confirmer=new Button("confirmer");
	    parcourir=new Button("parcourir");
	    ajouter=new Button("ajouter");
	}
	
    protected VBox vBox() {
    	
    	
    	//entrerK.setPromptText("entrer k");
    	//entrerK.setMaxWidth(100);
    	Stage stage = this;
    	parcourir.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(final ActionEvent e) {
/*<<<<<<< HEAD
                File file = fichierCsv.showOpenDialog(stage);
           
                dataSet.loadFromFile(file.toString());
                comboBox();  
=======*/
                File file = fichierCsv.showOpenDialog(stage);
                System.out.println(file.toString());
                if (file != null) {
                	View.dataSet = DataSetFactory.createDataSet(typeDataSet.getValue());
                	dataSet.loadFromFile(file.toString());
                	comboBox();
                }
                
            }
    	});
    	
    	confirmer.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(final ActionEvent e) {
    			//int k=Integer.parseInt(entrerK.getText());
    			if(criteriaX != null && criteriaY != null) {
    				if(!criteriaX.equals(criteriaY)) {
    					if(View.scatterChart != null) {
    						hbox.getChildren().remove(scatterChart.getScatterChart());
    					}
    					generateDistance();
        				Criteria criteria = new Criteria(criteriaX.getValue(), criteriaY.getValue());
        				Classification classification = new Classification(dataSet.getColumnsList(), criteria, distance.toString());
        				
        				View.scatterChart = new ScatterChartObject(criteria, View.dataSet);
        				//verticalPosition.getChildren().addAll(scatterChart.getScatterChart()); 
        				View.scatterChart.initScatter();
        				hbox.getChildren().addAll(scatterChart.getScatterChart());
        				
        				
        				/*System.out.println("KNN : ");
        				System.out.println(classification.knnCalcul(3, dataSet.getPointsList().get(12), dataSet.getPointsList()));
        				System.out.println("Robustnesss : ");
        				System.out.println(classification.calculRobustness(3, dataSet.getPointsList().get(12), dataSet.getCategoriesList().get(1)));*/
        			} else {
        				System.out.println("Selectionne des paramètres différents !");
        			}
    			}
    			
    		}
    	});
    	
    	ajouter.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(final ActionEvent e) {
            	CreateNewPoint cnp = new CreateNewPoint();
            	try {
					cnp.start(stage);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
            	List<String> listNewPoint = new ArrayList<>();
            	for(int i = 0; i < cnp.listNewPoint.size(); i++) {
            		listNewPoint.add(cnp.listNewPoint.get(i));
            	}
            	System.out.println(cnp.listNewPoint.size());
            	System.out.println(listNewPoint.toString());
            }
    	});
    	
    	VBox vbox=new VBox();
    	vbox.setPadding(new Insets(80,10,100,10));
    	vbox.setSpacing(10);
    	vbox.setStyle("-fx-background-color: #101010;");
    	vbox.getChildren().addAll(typeDataSet,typeDistance,parcourir,criteriaX,criteriaY,confirmer, ajouter);
    	
    	
    	return vbox;
    	
    }
    
    protected void comboBox() {
    	List<IColumn> columns=dataSet.getColumnsList();
    	
    	if(criteriaX.getItems().size()!=0 && criteriaY.getItems().size()!=0) {
    		criteriaX=new ComboBox<>();
    	    criteriaY=new ComboBox<>();
    	}
    	
    	if(columns!=null) {
    		for(int i=0;i<columns.size();i++) {
    			criteriaX.getItems().add(columns.get(i).getName());
        		criteriaY.getItems().add(columns.get(i).getName());
    		}
    	}
    	
    }
    
    protected void dataSetComboBox() {
    	typeDataSet.getItems().add("Pokemon");
    	typeDataSet.getItems().add("Iris");
    	typeDataSet.getItems().add("Titanic");
    	typeDataSet.getSelectionModel().selectFirst();
    }
    protected void distanceComboBox() {
    	typeDistance.getItems().add("Euclidienne");
    	typeDistance.getItems().add("Manhattan");
    	typeDistance.getSelectionModel().selectFirst();
    }
    

    protected static void generateDistance() {
    	if(typeDistance.getValue().equals("Euclidienne")) {
    		distance = new DistanceEuclidienne();
    	} else if (typeDistance.getValue().equals("Manhattan")) {
    		distance = new DistanceManhattan();
    	}
    }
    
 
    
	public Stage getRealStage() {
		return this;
	}





	@Override
	public void update(Subject subj) {
		
	}





	@Override
	public void update(Subject subj, Object data) {
		
	}


}
