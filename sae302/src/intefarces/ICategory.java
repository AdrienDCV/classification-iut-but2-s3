package intefarces;

import java.util.List;

public interface ICategory {

	
	List<IPoint> addToCategory(IMVCModel dataset);
	List<IPoint> addToCategory(IPoint point);
	String getCategoryName();
	public List<IPoint> getCategoryElements();
}