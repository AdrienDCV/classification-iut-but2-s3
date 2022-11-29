package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.ValueNormalizerNull;

public class VNNullTest {

	@Test
	public void test() {
		ValueNormalizerNull value=new ValueNormalizerNull();
		assertEquals("",value.getValueNormalizer());
	}
}
