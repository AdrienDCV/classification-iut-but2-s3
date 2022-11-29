package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.NormalizerTypes;

public class NormalizerTypeTest {

	@Test
	public void numberNormalizerTypeTest() {
		assertEquals("NN",NormalizerTypes.NUMBER_NORMALIZER.getLabel());
	}
	
	@Test
	public void enumNormalizerTypeTest() {
		assertEquals("EN",NormalizerTypes.ENUM_NORMALIZER.getLabel());
	}
	
	@Test
	public void booleanNormalizerTypeTest() {
		assertEquals("BN",NormalizerTypes.BOOLEAN_NORMALIZER.getLabel());
	}
}
