package pokemon;

import java.util.ArrayList;
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
	
}