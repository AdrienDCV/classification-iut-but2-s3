package pokemonTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.pokemon.Pokemon;
import model.pokemon.PokemonDataSet;

class PokemonTest {
	
	PokemonDataSet pokemons;
	Pokemon pokemon1, pokemon2, pokemon3;
	
	@BeforeEach
	void setup() {
		pokemons=new PokemonDataSet();
		pokemons.loadFromFile("./res/pokemon_train.csv");
		pokemon1 = new Pokemon("Swablu", 40, 5120, 255.0, 60, 600000, 45, 75, 50, "normal", "flying", 1.2, false);
		pokemon2 = new Pokemon("Budew", 30, 5120, 255.0, 35, 1059860, 40, 70, 55, "grass", "poison", 1.2, false);
		pokemon3 = new Pokemon("Dialga", 120, 30720, 3.0, 120, 1250000, 100, 100, 90, "steel", "dragon", 683.0, true);
	}
	
	@Test
	void pokemonGetter() {
		assertEquals("Swablu", pokemon1.getName());
		assertEquals(40, pokemon1.getAttack());
		assertEquals(5120, pokemon1.getBaseEggSteps());
		assertEquals(255.0, pokemon1.getCaptureRate());
		assertEquals(60, pokemon1.getDefense());
		assertEquals(600000,pokemon1.getExperienceGrowth());
		assertEquals(45, pokemon1.getHp());
		assertEquals(75, pokemon1.getSpAttack());
		assertEquals(50, pokemon1.getSpDefense());
		assertEquals("normal", pokemon1.getType1());
		assertEquals("flying", pokemon1.getType2());
		assertEquals(1.2, pokemon1.getSpeed());
		assertFalse(pokemon1.isLegendary());
	}
	
	@Test
	void toStringTest() {
		assertEquals("Pokemon [name=Swablu, attack=40, baseEggSteps=5120, captureRate=255.0, defense=60, experienceGrowth=600000, hp=45, sp_attack=75, sp_defense=50, type1=normal, type2=flying, speed=1.2, isLegendary=false]", pokemon1.toString());
		assertEquals("Pokemon [name=Budew, attack=30, baseEggSteps=5120, captureRate=255.0, defense=35, experienceGrowth=1059860, hp=40, sp_attack=70, sp_defense=55, type1=grass, type2=poison, speed=1.2, isLegendary=false]", pokemon2.toString());
		assertEquals("Pokemon [name=Dialga, attack=120, baseEggSteps=30720, captureRate=3.0, defense=120, experienceGrowth=1250000, hp=100, sp_attack=100, sp_defense=90, type1=steel, type2=dragon, speed=683.0, isLegendary=true]", pokemon3.toString());
	}
	
	@Test
	public void getNormalizedValueTest() {
		assertEquals(0.125,pokemon1.getNormalizedValue(pokemons.defaultXCol()));
	}

}
