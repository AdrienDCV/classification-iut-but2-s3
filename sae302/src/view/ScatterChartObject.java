package view;

import java.util.ArrayList;
import java.util.List;

import intefarces.IPoint;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import model.Category;
import model.Column;
import model.Criteria;
import model.DataSet;


public class ScatterChartObject {
	ScatterChart<Number, Number> scatterChart = new ScatterChart<>(new NumberAxis(), new NumberAxis());
	Column xCol; 
	Column yCol;
	NumberAxis x = new NumberAxis(0, 1, 0.01);
	NumberAxis y = new NumberAxis(0, 1, 0.01);
	DataSet dataSet;

	
	public ScatterChartObject(Criteria criteria, DataSet dataset) {
		
		x.setLabel(criteria.getCriteriaX());
		y.setLabel(criteria.getCriteriaY());
		this.dataSet = dataset;
		for(Column c : this.dataSet.getColumnsList()) {
			if(c.getName().equals(criteria.getCriteriaX())) {
				xCol = (Column) c;
			} else if(c.getName().equals(criteria.getCriteriaY())) {
				yCol = (Column) c;
			}
		}
	}
	
	public void initScatter() {
		
		scatterChart = new ScatterChart(x, y);
		List<XYChart.Series<Number, Number>> listeCategory = new ArrayList<>();
		for(Category c : this.dataSet.getCategoriesList()) {
			listeCategory.add(new XYChart.Series<Number, Number>());
			listeCategory.get(listeCategory.size()-1).setName(c.getCategoryName());
		}
		for(int i = 0; i < listeCategory.size(); i ++) {
			List<XYChart.Data<Number, Number>>listData = listeCategory.get(i).getData();
			for(IPoint p : this.dataSet.getCategoriesList().get(i).getCategoryElements()) {
				
				listData.add(new XYChart.Data<Number,Number>(xCol.getNormalizedValue(p), yCol.getNormalizedValue(p)));
			}
			scatterChart.getData().add(listeCategory.get(i));
		}
		
		getInformationOnMouseClicked(listeCategory);

	}
	

	protected void getInformationOnMouseClicked(List<XYChart.Series<Number, Number>> listeCategory) {
		for(int i = 0; i < listeCategory.size() - 1; i++) {
			for(XYChart.Data<Number,Number> data : listeCategory.get(i).getData()) {
				data.getNode().setOnMouseClicked(e -> {
					View.pointInformations.getItems().clear();
					for(Series<Number, Number> data2 : listeCategory) {
						for(XYChart.Data<Number,Number> data3 : data2.getData()) {
							if(data3.equals(data)) {
								for(IPoint point: dataSet.getPointsList()) {
									if(data3.getXValue().doubleValue() == xCol.getNormalizedValue(point) && data3.getYValue().doubleValue() == yCol.getNormalizedValue(point)) {
										String string = point.toString();
										string = " " + string.substring(string.indexOf("[") + 1);
										string = string.substring(0, string.indexOf("]"));
										String[] list = string.split(",");
										for(int l = 0; l < list.length; l++) {
											View.pointInformations.getItems().add(list[l]);
										}
										View.pointInformations.getItems().add("");
									}
								}
								
							}
						}
					}
				});
			}
		}
	}

	public ScatterChart<Number, Number> getScatterChart() {
		return scatterChart;
	}

	
}