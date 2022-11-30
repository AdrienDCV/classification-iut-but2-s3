package model;

import java.util.List;

import intefarces.IMVCModel;
import intefarces.IPoint;

public class Undefined extends Category {

	public Undefined() {
		super("Undefined");
	}
	
	@Override
	public List<IPoint> addToCategory(IMVCModel dataSet) {
		return this.categoryElements;
	}
	
	public List<IPoint> addToCategory(IPoint point) {
		this.categoryElements.add(point);
		return this.categoryElements;
	}
	public List<IPoint> addToCategory(IPoint point, Category category) {
		if(this.categoryName.equals(category.getCategoryName())) {
			this.categoryElements.add(point);
		}
		return this.categoryElements;
	}

}
