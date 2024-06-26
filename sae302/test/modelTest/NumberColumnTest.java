package modelTest;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import intefarces.IPoint;
import model.NumberColumn;
import model.pokemon.Pokemon;
import model.pokemon.PokemonDataSet;

public class NumberColumnTest {
    
    Pokemon pikachu, charizard, dialga;
    NumberColumn captureRate, speed, experienceGrowth;
    List<IPoint> pointsList;

    @BeforeEach
    void setup() {
        this.pikachu = new Pokemon("Pikachu", 2560, 190, 1000000, 0, 0, 0, 0, 0, null, null, 6.0, false);
        this.charizard = new Pokemon("Charizard", 5120, 0, 45.0, 1059860, 0, 0, 0, 0, null, null, 90.5, false);
        this.dialga = new Pokemon("Dialga", 30720, 0, 3.0, 1250000, 0, 0, 0, 0, null, null, 683.0, true);
        this.pointsList = new ArrayList<>();
        pointsList.add(pikachu); pointsList.add(charizard); pointsList.add(dialga); 

        this.captureRate = new NumberColumn("capture_rate", null, pointsList);
        this.speed = new NumberColumn("speed", null, pointsList);
        this.experienceGrowth = new NumberColumn("experience_growth", null, pointsList);
    }

    @Test
    public void test_number_column_constructor() {
        assertEquals("nColumn", new NumberColumn("nColumn", new PokemonDataSet(), new ArrayList<>()).getName());
    }


    @Test
    public void test_get_minimum_value() {
        assertEquals(3.0, captureRate.getMinimumValue());
        
        assertNotEquals(190, captureRate.getMinimumValue());

        assertEquals(6.0, speed.getMinimumValue());
        assertNotEquals(90.5, speed.getMinimumValue());

        assertEquals(0.0, experienceGrowth.getMinimumValue());
        assertNotEquals(1250000.0, experienceGrowth.getMinimumValue());
    }

}
