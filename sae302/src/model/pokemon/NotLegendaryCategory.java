package model.pokemon;

import java.util.List;

import intefarces.IMVCModel;
import intefarces.IPoint;
import model.Category;

public class NotLegendaryCategory  extends Category {
	
	public NotLegendaryCategory() {
		super("NotLegendary");
	}

	@Override
	public List<IPoint> addToCategory(IMVCModel dataset) {
		PokemonDataSet pokemonDataSet = (PokemonDataSet) dataset;

		for (IPoint pokemon : pokemonDataSet.getPointsList()) {
			if (!((Pokemon) pokemon).isLegendary()) {
				this.categoryElements.add(pokemon);
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
	
	public List<IPoint> addToCategory(IPoint point, Category category) {
		if(this.categoryName.equals(category.getCategoryName())) {
			this.categoryElements.add(point);
		}
		((Pokemon) point).setIsLegendary(this);
		return this.categoryElements;
	}
	
}