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


    public void test_get_minimum_value() {
        // name , attack , base_egg_steps , capture_rate , defense , experience_growth , hp , sp_attack , sp_defense , type1 ,  type2 , speed , is_legendary
        Pokemon pikachu = new Pokemon("Pikachu", 2560, 190, 1000000, 6.0, false);
        Pokemon charizard = new Pokemon("Charizard", 5120, 45.0, 1059860, 90.5, false);
        Pokemon dialga = new Pokemon("Dialga", 30720, 3.0, 1250000, 683.0, true);
        List<IPoint> pointsList = new ArrayList<>();
        pointsList.add(pikachu); pointsList.add(charizard); pointsList.add(dialga); 

        NumberColumn numberColumn = new NumberColumn("nColumn", new DataSet(), pointsList);
        assertEquals(3.0, numberColumn.getMaximumValue());
    }

}
