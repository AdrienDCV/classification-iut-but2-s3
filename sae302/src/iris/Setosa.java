package iris;

import java.util.List;

import intefarces.IMVCModel;
import intefarces.IPoint;
import model.Category;

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
    
}
