package model;

import java.util.ArrayList;
import java.util.List;

import intefarces.IMVCModel;
import intefarces.IPoint;

public abstract class Category {

	protected List<IPoint> categoryElements;
	protected String categoryName;
	
	public Category(String categoryName) {
		this.categoryElements = new ArrayList<IPoint>();
		this.categoryName = categoryName;
	}

	public abstract List<IPoint> addToCategory(IMVCModel dataset);
	public abstract List<IPoint> addToCategory(IPoint point);
	
	public  String getCategoryName() {
		return this.categoryName;
	}
	
	public List<IPoint> getCategoryElements() {
		return this.categoryElements;
	}
}