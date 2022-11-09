package main;

import java.util.ArrayList;
import java.util.List;

import intefarces.ICategory;
import intefarces.IPoint;

public class NotLegendaryCategory extends ChargementDonneesPokemon implements ICategory {
	private List<IPoint> categoryElements;
	private String categoryName;
	
	public NotLegendaryCategory() {
		this.categoryElements = new ArrayList<IPoint>();
		this.categoryName = this.getClass().getName();
	}
	
	@Override
	public List<IPoint> addToCategory() {
		for(int i = 0; i < this.getPokemonList().size(); i ++) {
			if(!this.getPokemonList().get(i).isLegendary()) {
				this.categoryElements.add(this.getPokemonList().get(i));
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
