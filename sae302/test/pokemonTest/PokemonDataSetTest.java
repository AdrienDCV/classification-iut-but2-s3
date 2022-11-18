package pokemonTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pokemon.Pokemon;
import pokemon.PokemonDataSet;

class PokemonDataSetTest {
	PokemonDataSet dataset;
	Pokemon pokemon1, pokemon2, pokemon3;
	
	@BeforeEach
	void setup() {
		dataset = new PokemonDataSet("PokemonTest");
		pokemon1 = new Pokemon("Swablu", 40, 5120, 255.0, 60, 600000, 45, 75, 50, "normal", "flying", 1.2, false);
		pokemon2 = new Pokemon("Budew", 30, 5120, 255.0, 35, 1059860, 40, 70, 55, "grass", "poison", 1.2, false);
		pokemon3 = new Pokemon("Dialga", 120, 30720, 3.0, 120, 1250000, 100, 100, 90, "steel", "dragon", 683.0, true);
	}
	
	@Test
	void dataSetInitTest() {
		assertEquals("PokemonTest", dataset.getTitle());
	}
	
	@Test
	void chargementTest() {
		dataset.loadFromFile("./res/pokemon_test.csv");
		assertEquals(13, dataset.getPointsList().size());
	}

}
