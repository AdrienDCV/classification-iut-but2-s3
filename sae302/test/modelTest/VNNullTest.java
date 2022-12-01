package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.ValueNormalizerNull;

public class VNNullTest {

	ValueNormalizerNull value;
	
	@BeforeEach
	public void setup() {
		value=new ValueNormalizerNull(null);
	}
	
	@Test
	public void test() {
		assertEquals("NULL",value.getValueNormalizer());
	}
}
