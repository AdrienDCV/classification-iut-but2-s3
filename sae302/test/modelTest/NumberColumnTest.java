package modelTest;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import intefarces.IPoint;
import model.DataSet;
import model.NumberColumn;
import model.Pokemon;

public class NumberColumnTest {
    
    @Test
    public void test_number_column_constructor() {
        assertEquals("nColumn", new NumberColumn("nColumn", new DataSet(), new ArrayList<>()).getName());
    }


    @Test
    public void test_get_minimum_value() {
        // name , attack , base_egg_steps , capture_rate , defense , experience_growth , hp , sp_attack , sp_defense , type1 ,  type2 , speed , is_legendary
        Pokemon pikachu = new Pokemon("Pikachu", 2560, 190, 1000000, 6.0, false);
        Pokemon charizard = new Pokemon("Charizard", 5120, 45.0, 1059860, 90.5, false);
        Pokemon dialga = new Pokemon("Dialga", 30720, 3.0, 1250000, 683.0, true);
        List<IPoint> pointsList = new ArrayList<>();
        pointsList.add(pikachu); pointsList.add(charizard); pointsList.add(dialga); 

        NumberColumn captureRate = new NumberColumn("captureRate", null, pointsList);
        assertEquals(3.0, captureRate.getMinimumValue());
        assertNotEquals(190, captureRate.getMinimumValue());

        NumberColumn speed = new NumberColumn("speed", null, pointsList);
        assertEquals(6.0, speed.getMinimumValue());
        assertNotEquals(90.5, speed.getMinimumValue());

        NumberColumn experienceGrowth = new NumberColumn("experienceGrowth", null, pointsList);
        assertEquals(1000000.0, experienceGrowth.getMinimumValue());
        assertNotEquals(1250000.0, experienceGrowth.getMinimumValue());
        
    }

}
