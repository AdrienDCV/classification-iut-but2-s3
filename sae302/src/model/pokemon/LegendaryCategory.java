package model.pokemon;

import java.util.List;

import intefarces.IMVCModel;
import intefarces.IPoint;
import model.Category;


public class LegendaryCategory  extends Category{
	
	public LegendaryCategory() {
		super("Legendary");
	}

	@Override
	public List<IPoint> addToCategory(IMVCModel dataSet) {
		PokemonDataSet p = (PokemonDataSet) dataSet;
		for(int i = 0; i < p.getPointsList().size(); i ++) {
			if(((Pokemon)p.getPointsList().get(i)).isLegendary()) {
				this.categoryElements.add(p.getPointsList().get(i));
			}
		}
		return this.categoryElements;
	}
	
	public List<IPoint> addToCategory(IPoint point) {
		if(((Pokemon)point).isLegendary()) {
			this.categoryElements.add(point);
		}
		return this.categoryElements;
	}
	
	public List<IPoint> addToCategory(IPoint point, Category category) {
		if(this.categoryName.equals(category.getCategoryName())) {
			this.categoryElements.add(point);
		}
		((Pokemon) point).setIsLegendary(this);
		return this.categoryElements;
	}
	
	
}