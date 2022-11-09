package main;

import java.util.ArrayList;
import java.util.List;

import intefarces.ICategory;
import intefarces.IPoint;
import model.Pokemon;

public class LegendaryCategory extends ChargementDonneesPokemon {
	
	public List<Pokemon> addToCategory() {
		List<Pokemon> legendaryList = new ArrayList<Pokemon>();
		for(int i = 0; i < this.getPokemonList().size();i++) {
			if(this.getPokemonList().get(i).isLegendary()) {
				legendaryList.add(this.getPokemonList().get(i));
			}
		}
		return legendaryList;
	}
	
}
