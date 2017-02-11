import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RomanNumberTest {

    @Test
    public void equals() throws Exception {
        RomanNumber C1 = new CRomanNumber();
        RomanNumber C2 = new CRomanNumber();
        assertEquals(C1, C2);
    }

    @Test
    public void not_equals() throws Exception {
        RomanNumber C = new CRomanNumber();
        RomanNumber L = new LRomanNumber();
        assertNotEquals(C,L);
    }


    @Test
    public void should_return_150_when_C_plus_L() throws Exception {
        RomanNumber C = new CRomanNumber();
        RomanNumber L = new LRomanNumber();
        assertEquals(150, C.plus(L));
    }

    @Test
    public void should_return_1500_when_V_plus_M() throws Exception {
        RomanNumber V = new VRomanNumber();
        RomanNumber M = new MRomanNumber();
        assertEquals(1005, V.plus(M));
    }

    @Test
    public void should_return_true_if_numbers_match() throws Exception {
        RomanNumber V1 = new VRomanNumber();
        RomanNumber V2 = new VRomanNumber();
        assertEquals(V1, V2);
    }
}