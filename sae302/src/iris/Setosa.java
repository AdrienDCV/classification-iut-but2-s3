package iris;

import java.util.List;

import intefarces.IMVCModel;
import intefarces.IPoint;
import model.Category;
import pokemon.Pokemon;

public class Setosa extends Category {

    public Setosa() {
        super("Setosa");
    }

    @Override
    public List<IPoint> addToCategory(IMVCModel dataset) {
        IrisDataSet irisDataSet = (IrisDataSet) dataset;

		for (IPoint iris : irisDataSet.getPointsList()) {
			if (((Iris) iris).getVariety().equals("Setosa")) {
				this.categoryElements.add(iris);
			}
		}
		return this.categoryElements;
    }

    @Override
    public List<IPoint> addToCategory(IPoint point) {
        if(((Iris)point).equals("Setosa")) {
			this.categoryElements.add(point);
		}
		return this.categoryElements;
    }
    
    public List<IPoint> addToCategory(IPoint point, Category category) {
		if(this.categoryName.equals(category.getCategoryName())) {
			this.categoryElements.add(point);
		}
		((Iris) point).setVariety(this.getCategoryName());
		return this.categoryElements;
	}
    
}
