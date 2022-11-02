package modelTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import org.junit.Test;

import model.BooleanValueNormalizer;
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
        column1.setNormalizer(new NumberValueNormalizer());
        assertEquals("NN", column1.getNormalizer().getValueNormalizer());
        column1.setNormalizer(new EnumValueNormalizer());
        assertEquals("EN", column1.getNormalizer().getValueNormalizer()); 
        column1.setNormalizer(new StringValueNormalizer());
        assertEquals("SN", column1.getNormalizer().getValueNormalizer());     
        column1.setNormalizer(new BooleanValueNormalizer());
        assertEquals("BN", column1.getNormalizer().getValueNormalizer());  

        column1.setNormalizer(new BooleanValueNormalizer());
        assertNotEquals("NN", column1.getNormalizer().getValueNormalizer());
        column1.setNormalizer(new EnumValueNormalizer());
        assertNotEquals("SN", column1.getNormalizer().getValueNormalizer()); 
    }


}
