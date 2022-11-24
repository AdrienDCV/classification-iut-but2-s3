package view;

import java.io.File;
import java.util.List;

import intefarces.IColumn;
import intefarces.IPoint;
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
import model.Category;
import model.Classification;
import model.Column;
import model.Criteria;
import model.DataSet;
import model.DataSetFactory;
import model.DistanceEuclidienne;
import model.DistanceManhattan;
import model.DistanceStrategy;
import model.DistanceStrategyFactory;
import pokemon.Pokemon;
import utils.Observer;
import utils.Subject;

public class View extends Stage implements Observer{
	
	// class attributes
	static Button confirmer, parcourir, testPokemon;
    static ComboBox<String> criteriaX, criteriaY, typeDataSet, typeDistance;
    //TextField entrerK=new TextField();

    static FileChooser fichierCsv;
	static HBox hboxVariables;
	static Canvas canvas;//changer en scaterChart
	static DataSet model;
	static DistanceStrategy distance;
	static Criteria criteria;
	static ScatterChartObject scatterChart;
	//static VBox verticalPosition;
	static HBox hbox;
	static VBox vbox;
	
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
	    testPokemon= new Button("Test pokemon");
	}
	
    protected VBox vBox() {
    	
    	
    	//entrerK.setPromptText("entrer k");
    	//entrerK.setMaxWidth(100);
    	Stage stage = this;
    	View view = this;
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
                	View.model = DataSetFactory.createDataSet(typeDataSet.getValue());
                	View.distance = DistanceStrategyFactory.createDistanceStrategy(typeDistance.getValue());
                	model.loadFromFile(file.toString());
                	View.model.attach(view);
                	if(criteriaX != null && criteriaY != null) {
                		comboBox();
                	}else {
                		vbox.getChildren().set(vbox.getChildren().indexOf(criteriaX), criteriaX);
                		vbox.getChildren().set(vbox.getChildren().indexOf(criteriaY), criteriaY);
                	}
                }
            }
            
    	});
    	confirmer.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(final ActionEvent e) {
    			//int k=Integer.parseInt(entrerK.getText());
    			if(criteriaX != null && criteriaY != null) {
    				if(!criteriaX.equals(criteriaY)) {
    					if(View.scatterChart != null) {
    						updateScatter();
    					} else {
    						createScatter();
    					}
        				
        				generateDistance();
        				
        				
        				
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
    	
    	testPokemon.setOnMouseClicked(e -> {
    		System.out.println(View.model.getPointsList().size());
    			Pokemon p = new Pokemon("TestPokemon", 95, 16000, 250.0, 55, 600001, 50, 74, 75, "normal", "flying", 2, false);
    			View.model.addLine(p);
    			Classification classification = new Classification(model.getColumnsList(), criteria, typeDistance.getValue());
    			Category c = classification.classifyPoint(3, p, model.getPointsList());
    			for(Category dataC : View.model.getCategoriesList()) {
    				if(c.getCategoryName().equals(dataC.getCategoryName())) {
    					dataC.addToCategory(p);
    					/*
    					 * 
    					 * SI LE POINT EST DIT LEGENDAIRE ALORS QUIL NE L'EST PAS
    					 * SET ISLEGENDARY TRUE
    					 * ET INVERSEMENT
    					 * 
    					 * 
    					 */
    				}
    			}
    			});
    	vbox=new VBox();
    	vbox.setPadding(new Insets(80,10,100,10));
    	vbox.setSpacing(10);
    	vbox.setStyle("-fx-background-color: #101010;");
    	vbox.getChildren().addAll(typeDataSet,typeDistance,parcourir,criteriaX,criteriaY,confirmer, testPokemon);
    	return vbox;
    }
    
    public void createScatter() {
    	View.criteria = new Criteria(criteriaX.getValue(), criteriaY.getValue());
		View.scatterChart = new ScatterChartObject(criteria, View.model);
		View.scatterChart.initScatter();
		hbox.getChildren().addAll(scatterChart.getScatterChart());
    }
    
    public void updateScatter() {
    	hbox.getChildren().remove(scatterChart.getScatterChart());
    	createScatter();
    }

    
   
    protected void comboBox() {
    	/*
    	 * 
    	 * 
    	 * CHANGER LE CAS COLUMN NULL POUR EVITER COLUMN FANTOME
    	 * 
    	 * 
    	 * 
    	 */
    	List<IColumn> columns=model.getColumnsList();
    	System.out.println(columns);
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
		updateScatter();
	}

	@Override
	public void update(Subject subj, Object data) {
		updateScatter();
	}

}
