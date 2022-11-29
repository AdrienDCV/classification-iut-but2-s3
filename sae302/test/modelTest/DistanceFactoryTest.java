package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.DistanceEuclidienne;
import model.DistanceManhattan;
import model.DistanceStrategyFactory;
import model.DistanceStrategyNull;

public class DistanceFactoryTest {
	
	DistanceStrategyFactory fact;
	
	@BeforeEach
	public void setup() {
		fact=new DistanceStrategyFactory();
	}
	
	@Test
	public void createDistanceStrategyEuclidienneTest() {
		DistanceEuclidienne dist=new DistanceEuclidienne();
		assertEquals(dist.getClass(),fact.createDistanceStrategy("Euclidienne").getClass());
	}
	
	@Test
	public void createDistanceStrategyManhattanTest() {
		DistanceManhattan dist=new DistanceManhattan();
		assertEquals(dist.getClass(),fact.createDistanceStrategy("Manhattan").getClass());
	}
	
	@Test
	public void createDistanceStrategyNullTest() {
		DistanceStrategyNull dist=new DistanceStrategyNull();
		assertEquals(dist.getClass(),fact.createDistanceStrategy("nnn").getClass());
	}
}
