package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;

import model.NumberValueNormalizer;

public class NumberValueNormalizerTest {
    
    @Test
    public void test_number_value_normalizer_constructor() {
        assertEquals("NN", new NumberValueNormalizer().getValueNormalizer());
    
    }

}
