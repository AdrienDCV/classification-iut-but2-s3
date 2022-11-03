package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;

import model.Column;
import model.NumberValueNormalizer;

public class NumberValueNormalizerTest {
    
    @Test
    public void test_number_value_normalizer_constructor() {
        NumberColumn nColumn = new NumberColumn();
        assertEquals("NN", new NumberValueNormalizer().getValueNormalizer());

        assertNotEquals("BN", new NumberValueNormalizer().getValueNormalizer());
        assertNotEquals("", new NumberValueNormalizer().getValueNormalizer());
        assertNotEquals(null, new NumberValueNormalizer().getValueNormalizer());
    }

}
