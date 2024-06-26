package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import intefarces.IPoint;
import model.Column;
import model.EnumColumn;
import model.EnumValueNormalizer;
import model.titanic.Embarked;
import model.titanic.Sex;
import model.titanic.Titanic;

public class EnumValueNormalizerTest {
  
	Titanic point1, point2, point3, point4;
	List<IPoint> pointsList;
	EnumColumn columnEmbarked, columnSex; 
	EnumValueNormalizer evnEmbarked, evnSex;
	
    @BeforeEach
    void setup() {
    	pointsList = new ArrayList<>();
        point1 = new Titanic( 1,0,3,"Braund, Mr. Owen Harris",Sex.MALE,22,1,0,"A/5 21171",7.25,"",Embarked.S);
        point2 = new Titanic(2,1,1,"Cumings, Mrs. John Bradley (Florence Briggs Thayer)",Sex.FEMALE,38,1,0,"PC 17599",71.2833,"C85",Embarked.C);
        point3 = new Titanic(17,0,3,"Rice, Master. Eugene",Sex.MALE,2,4,1,"382652",29.125,"",Embarked.Q);
        point4 = new Titanic( 1,0,3,"Braund, Mr. Owen Harris",Sex.UNKNOWN,22,1,0,"A/5 21171",7.25,"",Embarked.UNKNOWN);
        pointsList.add(point1); pointsList.add(point2); pointsList.add(point3); pointsList.add(point4);
        
        columnEmbarked = new EnumColumn("Embarked", null, pointsList);
        columnSex = new EnumColumn("Sex", null, pointsList); 
        
        evnEmbarked  = new EnumValueNormalizer(columnEmbarked);  
        evnSex = new EnumValueNormalizer(columnSex);
    }

    @Test
    public void test_enum_value_normalizer_consstrcutor() {
        assertEquals("Embarked", ((Column) evnEmbarked.getNormalizerTarget()).getName());
        assertEquals("Sex", ((Column) evnSex.getNormalizerTarget()).getName());
    }

    @Test
    public void test_enum_value_normalizer_normalize() {
    	 assertEquals(0.33, columnEmbarked.getNormalizedValue(pointsList.get(0)), 0.01);
         assertEquals(0.66, columnEmbarked.getNormalizedValue(pointsList.get(1)), 0.01);
         assertEquals(1, columnEmbarked.getNormalizedValue(pointsList.get(2)), 0.01);
         assertEquals(0, columnEmbarked.getNormalizedValue(pointsList.get(3)), 0.01);
         
         assertEquals(0.5, columnSex.getNormalizedValue(pointsList.get(0)), 0.01);
         assertEquals(1, columnSex.getNormalizedValue(pointsList.get(1)), 0.01);
         assertEquals(0, columnSex.getNormalizedValue(pointsList.get(3)), 0.01);
    }

    @Test
    public void test_enum_value_normalizer_denormalize() {
        assertEquals(Embarked.UNKNOWN, columnEmbarked.getDenormalizedValue(0));
        assertEquals(Embarked.S, columnEmbarked.getDenormalizedValue(0.33));
        assertEquals(Embarked.C, columnEmbarked.getDenormalizedValue(0.66));
        assertEquals(Embarked.Q, columnEmbarked.getDenormalizedValue(1));

        assertEquals(Sex.UNKNOWN, columnSex.getDenormalizedValue(0));
        assertEquals(Sex.MALE, columnSex.getDenormalizedValue(0.5));
        assertEquals(Sex.FEMALE, columnSex.getDenormalizedValue(1));
    }
      
}
