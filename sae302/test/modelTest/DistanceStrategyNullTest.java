package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.DistanceStrategyNull;
import model.pokemon.Pokemon;
import model.pokemon.PokemonDataSet;

public class DistanceStrategyNullTest {
	
	DistanceStrategyNull distNull;
	PokemonDataSet pokemons;
	Pokemon pokemon1, pokemon2;
	
	@BeforeEach
	public void setup() {
		distNull=new DistanceStrategyNull();
		pokemons=new PokemonDataSet();
		pokemons.loadFromFile("./res/pokemon_train.csv");
		pokemon1 = new Pokemon("Swablu", 40, 5120, 255.0, 60, 600000, 45, 75, 50, "normal", "flying", 1.2, false);
		pokemon2 = new Pokemon("Meloetta", 128, 30720, 3.0, 90, 1250000, 100, 77, 128, "normal", "psychic", 6.5, true);
	}

	@Test
	public void calculDistanceTest() {
		assertEquals(0,distNull.calculDistance(pokemon1, pokemon2, pokemons.defaultXCol(), pokemons.defaultYCol()));
	}
}
