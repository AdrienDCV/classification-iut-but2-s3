package modelTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.opencsv.bean.CsvBindByName;

import pokemon.ChargementDonneesPokemon;
import pokemon.Pokemon;

class ChargementDonneesTest {
	ChargementDonneesPokemon c;
	List<Pokemon> l;
	@BeforeEach
	void setup() {
		c  = new ChargementDonneesPokemon();
		c.loadFromFile("./res/pokemon_train.csv");
		l = c.getPokemonList();
	}
	@Test
	void testSwablu() {
		assertEquals("Swablu",l.get(0).getName());
		assertEquals(5120,l.get(0).getBaseEggSteps());
		assertEquals(255.0,l.get(0).getCaptureRate());
		assertEquals(600000,l.get(0).getExperienceGrowth());
		assertEquals(1.2,l.get(0).getSpeed());
		assertEquals(false,l.get(0).isLegendary());
	}

	@Test
	void testDialga() {
		assertEquals("Dialga",l.get(12).getName());
		assertEquals(30720,l.get(12).getBaseEggSteps());
		assertEquals(3.0,l.get(12).getCaptureRate());
		assertEquals(1250000,l.get(12).getExperienceGrowth());
		assertEquals(683.0,l.get(12).getSpeed());
		assertEquals(true,l.get(12).isLegendary());
	}
		
	@Test
	void testSeismitoad() {
		int last = l.size() - 1;
		assertEquals("Seismitoad",l.get(last).getName());
		assertEquals(5120,l.get(last).getBaseEggSteps());
		assertEquals(45.0,l.get(last).getCaptureRate());
		assertEquals(1059860,l.get(last).getExperienceGrowth());
		assertEquals(62.0,l.get(last).getSpeed());
		assertEquals(false,l.get(last).isLegendary());
	}
	
	@Test
	void fichierInchargeable() {
		c  = new ChargementDonneesPokemon();
		c.loadFromFile("./fichier impossible");
		List<Pokemon> l2 = c.getPokemonList();
		assertEquals(new ArrayList<Pokemon>(), l2);
	}

}
