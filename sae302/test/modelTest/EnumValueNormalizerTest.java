package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import model.EnumValueNormalizer;

public class EnumValueNormalizerTest {
    
    @Test
    public void test_enum_value_normalizer_constrcutor() {
        assertEquals("EN", new EnumValueNormalizer().getValueNormalizer());
    }
    
}
