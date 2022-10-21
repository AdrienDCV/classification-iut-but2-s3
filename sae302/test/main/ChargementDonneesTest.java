package main;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ChargementDonneesTest {

	@Test
	void test() {
		List<Pokemon> l = ChargementDonnees.charger("./res/pokemon_train.csv");
		assertEquals("Swablu",l.get(0).getName());
		assertEquals(5120,l.get(1).getBaseEggSteps());
		assertEquals(200.0,l.get(2).getCaptureRate());
		assertEquals(1000000,l.get(3).getExperienceGrowth());
		
		List<Pokemon> l2 = ChargementDonnees.charger("./fichier impossible");
		assertEquals(new ArrayList<Pokemon>(), l2);
	}

}
