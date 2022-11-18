package modelTest;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import intefarces.IPoint;
import model.DataSet;
import model.NumberColumn;
import pokemon.Pokemon;

public class NumberColumnTest {
    
    Pokemon pikachu, charizard, dialga;
    NumberColumn captureRate, speed, experienceGrowth;
    List<IPoint> pointsList;

    @BeforeEach
    void setup() {
        this.pikachu = new Pokemon("Pikachu", 2560, 190, 1000000, 6.0, false);
        this.charizard = new Pokemon("Charizard", 5120, 45.0, 1059860, 90.5, false);
        this.dialga = new Pokemon("Dialga", 30720, 3.0, 1250000, 683.0, true);
        this.pointsList = new ArrayList<>();
        pointsList.add(pikachu); pointsList.add(charizard); pointsList.add(dialga); 

        this.captureRate = new NumberColumn("captureRate", null, pointsList);
        this.speed = new NumberColumn("speed", null, pointsList);
        this.experienceGrowth = new NumberColumn("experienceGrowth", null, pointsList);
    }

    @Test
    public void test_number_column_constructor() {
        assertEquals("nColumn", new NumberColumn("nColumn", new DataSet(), new ArrayList<>()).getName());
    }


    @Test
    public void test_get_minimum_value() {
        assertEquals(3.0, captureRate.getMinimumValue());
        
        assertNotEquals(190, captureRate.getMinimumValue());

        assertEquals(6.0, speed.getMinimumValue());
        assertNotEquals(90.5, speed.getMinimumValue());

        assertEquals(1000000.0, experienceGrowth.getMinimumValue());
        assertNotEquals(1250000.0, experienceGrowth.getMinimumValue());
    }

}
