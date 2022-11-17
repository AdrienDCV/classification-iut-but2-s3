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
import titanic.Embarked;
import titanic.Sex;
import titanic.Titanic;

public class EnumValueNormalizerTest {

    Titanic point1, point2, point3;
    Column column1, column2;
    EnumValueNormalizer evn1, evn2;
    public static List<IPoint> pointsList = new ArrayList<>();

    @BeforeEach
    void setup() {
        this.point1 = new Titanic( 1,0,3,"Braund, Mr. Owen Harris",Sex.M,22,1,0,"A/5 21171",7.25,"",Embarked.S);
        this.point2 = new Titanic(2,1,1,"Cumings, Mrs. John Bradley (Florence Briggs Thayer)",Sex.F,38,1,0,"PC 17599",71.2833,"C85",Embarked.C);
        this.point3 = new Titanic(17,0,3,"Rice, Master. Eugene",Sex.M,2,4,1,"382652",29.125,"",Embarked.Q);
        this. pointsList.add(point1); pointsList.add(point2); pointsList.add(point3);
        
        this.column1 = new EnumColumn("Embarked", null, this.pointsList); 
        this.column2 = new EnumColumn("Sex", null, this.pointsList); 

        this.evn1 = new EnumValueNormalizer(column1);
        this.evn2 = new EnumValueNormalizer(column2);
    }

    @Test
    public void test_enum_value_normalizer_consstrcutor() {
        assertEquals("Embarked", ((Column) this.evn1.getNormalizerTarget()).getName());

        assertEquals("Sex", ((Column) this.evn2.getNormalizerTarget()).getName());
    }

    @Test
    public void test_enum_value_normalizer_normalize() {
        assertEquals(0, this.column1.getNormalizedValue(this.pointsList.get(0)));
        assertEquals(0.5, this.column1.getNormalizedValue(this.pointsList.get(1)));
        assertEquals(1, column1.getNormalizedValue(this.pointsList.get(2)));

        assertEquals(0, this.column2.getNormalizedValue(this.pointsList.get(0)));
        assertEquals(1, this.column2.getNormalizedValue(this.pointsList.get(1)));    
    }

    @Test
    public void test_enum_value_normalizer_denormalize() {
        assertEquals(Embarked.S, this.column1.getDenormalizedValue(0));
        assertEquals(Embarked.Q, this.column1.getDenormalizedValue(0.5));
        assertEquals(Embarked.C, this.column1.getDenormalizedValue(1));

        assertEquals(Sex.M, this.column2.getDenormalizedValue(0));
        assertEquals(Sex.F, this.column2.getDenormalizedValue(0.5));
    }
    
}
