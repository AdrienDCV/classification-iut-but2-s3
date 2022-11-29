package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.DistanceStrategy;
import model.DistanceStrategyNull;
import model.pokemon.Pokemon;
import model.pokemon.PokemonDataSet;

public class DistanceStrategyNullTest {

	@Test
	public void calculDistanceTest() {
		DistanceStrategyNull dist=new DistanceStrategyNull();
		PokemonDataSet pokemons=new PokemonDataSet();
		pokemons.loadFromFile("./res/pokemon_train.csv");
		Pokemon pokemon1 = new Pokemon("Swablu", 40, 5120, 255.0, 60, 600000, 45, 75, 50, "normal", "flying", 1.2, false);
		Pokemon pokemon2 = new Pokemon("Swablu", 40, 5120, 255.0, 60, 600000, 45, 75, 50, "normal", "flying", 1.2, false);
		assertEquals(0,dist.calculDistance(pokemon1, pokemon2, pokemons.defaultXCol(), pokemons.defaultYCol()));
	}
}
