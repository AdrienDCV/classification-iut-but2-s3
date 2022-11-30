package main;

import java.util.List;

import intefarces.IPoint;
import model.Category;
import model.Classification;
import model.Criteria;
import model.pokemon.Pokemon;
import model.pokemon.PokemonDataSet;

public class Scenario {
	public static void main(String[] args) {
		PokemonDataSet dataSet = new PokemonDataSet();
		dataSet.loadFromFile(".\\res\\pokemon_train.csv");
		Pokemon pokemon = new Pokemon("Arceus", 120, 30720, 3.0, 120, 1250000, 120, 120, 120, "normal", null, 120);
		Criteria criteria = new Criteria(dataSet.getColumnsList().get(0).getName(), dataSet.getColumnsList().get(1).getName());
		
		Classification classification = new Classification(dataSet.getColumnsList(), criteria, "Euclidienne");
		
		int k = 3;
		List<IPoint> knn = classification.knnCalcul(k, pokemon, dataSet.getPointsList());
		Category categoryPokemon = classification.classifyPoint(k, pokemon, dataSet.getPointsList());
		pokemon.setIsLegendary(categoryPokemon);
		categoryPokemon.addToCategory(pokemon);
		
		System.out.println("Critères utilisées pour la classification : " + criteria.getCriteriaX() + "," + criteria.getCriteriaY());
		System.out.println();
		System.out.println("Pokémon à classifier : " + pokemon);
		System.out.println();
		System.out.println("Plus proche voisin du Pokemon : ");
		System.out.println(knn);
		System.out.println();
		System.out.println("Categorie du Pokemon: " + categoryPokemon.getCategoryName());
		System.out.println();
		System.out.println("Est ce que le pokemon a été ajouté à la catégorie : " + categoryPokemon.getCategoryElements().contains(pokemon));
		Category legendary = null;
		for(Category category : dataSet.getCategoriesList()) {
			if(category.getCategoryName().equals("Legendary")) {
				legendary = category;
			}
		}
		System.out.println();
		System.out.println("Robustesse : " + classification.calculRobustness(k, pokemon, legendary));
	}
}
