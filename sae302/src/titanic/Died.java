package titanic;

import java.util.List;

import intefarces.IMVCModel;
import intefarces.IPoint;
import model.Category;

public class Died extends Category  {

    public Died() {
        super("Died");
    }

    @Override
    public List<IPoint> addToCategory(IMVCModel dataset) {
        TitanicDataSet titanicDataSet = (TitanicDataSet) dataset;

		for (IPoint passenger : titanicDataSet.getPointsList()) {
			if (!((Titanic) passenger).hasSurvived()) {
				this.categoryElements.add(passenger);
			}
		}
		return this.categoryElements;
    }

    @Override
    public List<IPoint> addToCategory(IPoint point) {
        if(!((Titanic)point).hasSurvived()) {
			this.categoryElements.add(point);
		}
		return this.categoryElements;
    }
}
