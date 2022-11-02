package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import model.Column;
import model.DataSet;
import model.EnumValueNormalizer;
import model.NumberValueNormalizer;
import model.StringValueNormalizer;

public class ColumnTest {
	
    @Test
    public void test_column_constructor() {
        Column column1 = new Column("Column1", new DataSet(), new ArrayList<>(), null);
        assertEquals("Column1", column1.getName());
    }

    @Test
    public void test_set_normalizer() {
        Column column1 = new Column("Column1", new DataSet(), new ArrayList<>(), null);
        assertEquals("NN", new NumberValueNormalizer("NUMBER_NORMALIZER").getValueNormalizer());
        assertEquals("EN", new EnumValueNormalizer("ENUM_NORMALIZER").getValueNormalizer());
        assertEquals("SN", new StringValueNormalizer("STRING_NORMALIZER").getValueNormalizer());
    }


}
