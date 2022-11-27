package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.DistanceStrategyNull;
import model.NumberColumn;
import pokemon.Pokemon;

public class DistanceStrategyNullTest {

	
	@Test
	public void calculDistanceTest() {
		Pokemon poke1=new Pokemon();
		Pokemon poke2=new Pokemon();
		NumberColumn nc1=new NumberColumn(null, null, null);
		NumberColumn nc2=new NumberColumn(null, null, null);
		DistanceStrategyNull dsn=new DistanceStrategyNull();
		assertEquals(0,dsn.calculDistance(poke1, poke2, nc1, nc2));
	}
}
