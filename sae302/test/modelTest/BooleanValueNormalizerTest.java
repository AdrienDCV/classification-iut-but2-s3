package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import model.BooleanValueNormalizer;

public class BooleanValueNormalizerTest {
    
    @Test
    public void test_boolean_value_normalizer_constructor() {
        assertEquals("BN", new BooleanValueNormalizer().getValueNormalizer());
    }

}
