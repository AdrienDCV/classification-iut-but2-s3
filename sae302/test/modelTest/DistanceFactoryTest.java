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
	DistanceEuclidienne distEuclidienne;
	DistanceManhattan distManhattan;
	DistanceStrategyNull distNull;
	
	
	@BeforeEach
	public void setup() {
		fact=new DistanceStrategyFactory();
		distEuclidienne=new DistanceEuclidienne();
		distManhattan =new DistanceManhattan();
		distNull=new DistanceStrategyNull();
	}
	
	@Test
	public void createDistanceStrategyEuclidienneTest() {
		assertEquals(distEuclidienne.getClass(),fact.createDistanceStrategy("Euclidienne").getClass());
	}
	
	@Test
	public void createDistanceStrategyManhattanTest() {
		assertEquals(distManhattan.getClass(),fact.createDistanceStrategy("Manhattan").getClass());
	}
	
	@Test
	public void createDistanceStrategyNullTest() {
		assertEquals(distNull.getClass(),fact.createDistanceStrategy("nnn").getClass());
	}
}
