package pokemon;

import java.util.ArrayList;
import java.util.List;

import intefarces.IMVCModel;
import intefarces.IPoint;
import model.Category;

public class NotLegendaryCategory  extends Category {
	
	public NotLegendaryCategory(String categoryName) {
		super(categoryName);
	}

	@Override
	public List<IPoint> addToCategory(IMVCModel dataset) {
		PokemonDataSet p = (PokemonDataSet) dataset;
		for(int i = 0; i < p.getPointsList().size(); i ++) {
			if(!((Pokemon) p.getPointsList().get(i)).isLegendary()) {
				this.categoryElements.add(p.getPointsList().get(i));
			}
		}
		return this.categoryElements;
	}
	
	public List<IPoint> addToCategory(IPoint point) {
		if(!((Pokemon)point).isLegendary()) {
			this.categoryElements.add(point);
		}

		return this.categoryElements;
	}

	public List<IPoint> getCategoryElements() {
		return categoryElements;
	}

	public String getCategoryName() {
		return categoryName;
	}
	
	
	
}