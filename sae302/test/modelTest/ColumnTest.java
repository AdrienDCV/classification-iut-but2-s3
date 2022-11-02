package modelTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import model.Column;
import model.DataSet;
import model.NumberValueNormalizer;


public class ColumnTest {
	
    @Test
    public void test_column_constructor() {
        Column column1 = new Column("Column1", new DataSet(), new ArrayList<>(), null);
        assertEquals("Column1", column1.getName());
    }

    @Test
    public void test_set_normalizer() {
        Column column1 = new Column("Column1", new DataSet(), new ArrayList<>(), null);
        column1.setNormalizer(new NumberValueNormalizer("NUMBER_NORMALIZER"));
        assertEquals("NN", column1.getNormalizer().getValueNormalizer());
    }


}
