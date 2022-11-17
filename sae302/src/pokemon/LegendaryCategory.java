package pokemon;

import java.util.ArrayList;
import java.util.List;

import intefarces.ICategory;
import intefarces.IMVCModel;
import intefarces.IPoint;


public class LegendaryCategory  extends PokemonDataSet implements ICategory{
	private List<IPoint> categoryElements;
	private String categoryName;
	
	public LegendaryCategory() {
		this.categoryElements = new ArrayList<IPoint>();
		this.categoryName = this.getClass().getName();
	}
	
	@Override
	public List<IPoint> addToCategory(IMVCModel dataSet) {
		PokemonDataSet p = (PokemonDataSet) dataSet;
		for(int i = 0; i < p.getPointsList().size(); i ++) {
			if(!((Pokemon)p.getPointsList().get(i)).isLegendary()) {
				this.categoryElements.add(p.getPointsList().get(i));
			}
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
