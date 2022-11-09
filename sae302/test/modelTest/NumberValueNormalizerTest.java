package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;

import org.junit.Test;

import model.Column;
import model.DataSet;
import model.NumberColumn;
import model.NumberValueNormalizer;

public class NumberValueNormalizerTest {
    
    @Test
    public void test_number_value_normalizer_constructor() {
        NumberColumn nColumn = new NumberColumn("nColumn", new DataSet(), new ArrayList<>());
        NumberValueNormalizer numberValueNormalizer = new NumberValueNormalizer(nColumn);

        assertEquals("NN", numberValueNormalizer.getValueNormalizer());

        assertNotEquals("BN", numberValueNormalizer.getValueNormalizer());
        assertNotEquals("", numberValueNormalizer.getValueNormalizer());
        assertNotEquals(null, numberValueNormalizer.getValueNormalizer());
    }

    @Test
    public void test_number_value_normalizer_normalize() {
        NumberColumn nColumn = new NumberColumn("nColumn", new DataSet(), new ArrayList<>());

        NumberValueNormalizer numberValueNormalizer = new NumberValueNormalizer(nColumn);

        assertEquals(1.0, numberValueNormalizer.normalize(25.0));
    }

}
