package modelTest;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import model.BooleanColumn;

public class BooleanColumnTest {

     @Test
     public void test_boolean_column_constructor() {
        assertEquals("bColumn", new BooleanColumn("bColumn", null , new ArrayList<>()).getName());
     }
     
     @Test
     public void test_boolean_column_isNomalizable() {
    	 assert(new BooleanColumn("bColumn", null , new ArrayList<>()).isNormalizable());
     }

}
